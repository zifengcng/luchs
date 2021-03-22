package com.lynx.explore.binarySearchTree;

import java.util.Collections;

/**
 * @author wbc
 * @date 2020/7/23 16:22
 * Insert into a Binary Search Tree
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * 例如,
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                insert(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Collections.singletonList(Long.parseLong("123")).toString());
    }

}

