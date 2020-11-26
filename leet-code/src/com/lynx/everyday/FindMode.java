package com.lynx.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/25
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = dfs(root, map);
        if (max <= 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == max) {
                list.add(k);
            }
        });

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);

        max = Math.max(max, count);
        max = Math.max(max, dfs(root.left, map));
        max = Math.max(max, dfs(root.right, map));
        return max;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
