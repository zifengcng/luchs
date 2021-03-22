package com.lynx.explore.nAryTree;

/**
 * @author wbc
 * @date 2020/7/24 18:28
 * Maximum Depth of N-ary Tree
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/160/recursion/624/
 */
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        for (Node child : root.children) {
            res = Integer.max(res, maxDepth(child));
        }
        return res + 1;
    }
}
