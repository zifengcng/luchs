package com.lynx.random;

import com.lynx.common.annotition.HardCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/11/4
 * <p>
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 * <p>
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 */
@HardCode
public class MaxSumBST {

    public int maxSumBST(TreeNode root) {
        Map<TreeNode, Node> map = new HashMap<>();
        return maxSum(root, map);
    }

    private int maxSum(TreeNode root, Map<TreeNode, Node> map) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Math.max(0, root.val);
        } else if (root.left == null) {
            int max = maxSum(root.right, map);
            Node node = map.get(root.right);

            if (node.isBst) {
                if (root.val < node.min) {
                    map.put(root, new Node(node.max, root.val, Math.max(max, max + root.val), true));
                } else {
                    map.put(root, new Node(0, 0, max, false));
                }
            } else {
                map.put(root, new Node(0, 0, max, false));
            }
            return max;
        } else if (root.right == null) {
            return maxSum(root.left, map);
        }

        int res = 0;
        boolean isBst = false;
        int max;
        int min;
        int sum;

        if (root.left != null) {
            res = Math.max(res, maxSum(root.left, map));
        }
        if (root.right != null) {
            res = Math.max(res, maxSum(root.right, map));
        }


        return res;
    }

    public class Node {
        int max;
        int min;
        int sum;
        boolean isBst;

        public Node() {
        }

        public Node(int max, int min, int sum, boolean isBst) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBst = isBst;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
