package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/11/24
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
@MidCode
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        res += countNodes(root.left);
        res += countNodes(root.right);
        return res;
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
        CountNodes c = new CountNodes();
        TreeNode root = c.new TreeNode(1);
        TreeNode n2 = c.new TreeNode(2);
        TreeNode n3 = c.new TreeNode(3);
        TreeNode n4 = c.new TreeNode(4);
        TreeNode n5 = c.new TreeNode(5);
        TreeNode n6 = c.new TreeNode(6);
        n3.left = n6;
        n2.left = n4;
        n2.right = n5;
        root.left = n2;
        root.right = n3;

        System.out.println(c.countNodes(root));
    }
}
