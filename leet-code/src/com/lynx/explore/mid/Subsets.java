package com.lynx.explore.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/20
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * Java
 * <p>
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv67o6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 一个空子集
        res.add(new ArrayList<>());
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        dfs(nums, len, 0, res);
        return res;
    }

    private void dfs(int[] nums, int len, int index, List<List<Integer>> res) {
        if (index == len - 1) {
            List<Integer> t = new ArrayList<>();
            t.add(nums[index]);
            res.add(t);
            return;
        }
        int num = nums[index];
        dfs(nums, len, index + 1, res);
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> list = res.get(j);
            List<Integer> t = new ArrayList<>();
            t.add(num);
            t.addAll(list);
            res.add(t);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        List<List<Integer>> res = s.subsets(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
