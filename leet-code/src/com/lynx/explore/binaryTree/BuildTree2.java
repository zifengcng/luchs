package com.lynx.explore.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/23 9:35
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/16/
 */
public class BuildTree2 {

    private int preIndex;
    private Map<Integer, Integer> inorderMap;
    private int[] preOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        preOrder = preorder;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int l, int r) {
        if (l > r) {
            return null;
        }
        int value = preOrder[preIndex];
        TreeNode root = new TreeNode(value);
        int index = inorderMap.get(value);
        preIndex++;
        root.left = buildTreeHelper(l, index - 1);
        root.right = buildTreeHelper(index + 1, r);
        return root;
    }
}
