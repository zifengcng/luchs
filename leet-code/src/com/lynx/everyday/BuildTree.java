package com.lynx.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/25
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTree {

    private int post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        post = len - 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return buildTree2(postorder, 0, len - 1, map);
    }

    private TreeNode buildTree2(int[] postorder, int l, int r, Map<Integer, Integer> map) {
        if (l > r) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[post]);
        Integer index = map.get(postorder[post]);
        post--;
        node.right = buildTree2(postorder, index + 1, r, map);
        node.left = buildTree2(postorder, l, index - 1, map);
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        int[] inorder = {2, 1};
        int[] posorder = {1, 2};
        TreeNode node = b.buildTree(inorder, posorder);
        System.out.println(node);
    }

}
