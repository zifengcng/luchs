package com.lynx.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/9/28
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> queue = new LinkedList<>();
        return dfs(k, n, 1, queue);
    }

    private List<List<Integer>> dfs(int k, int n, int from, Deque<Integer> queue) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || from > 9 || n < from) {
            return res;
        }
        if (k == 1) {
            if (n < 1 || n > 9) {
                return res;
            }
            queue.add(n);
            res.add(new ArrayList<>(queue));
            queue.removeLast();
            return res;
        }

        for (int i = from; i <= 9; i++) {
            queue.add(i);
            res.addAll(dfs(k - 1, n - i, i + 1, queue));
            queue.remove(i);
        }

        return res;
    }

    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        List<List<Integer>> lists = c.combinationSum3(2, 18);
        System.out.println(lists);
    }

}
