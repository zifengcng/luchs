package com.lynx.explore.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/13
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        return permute2(nums, 0);
    }

    private List<List<Integer>> permute2(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= nums.length) {
            return res;
        }
        if (index == nums.length - 1) {
            List<Integer> t = new ArrayList<>();
            t.add(nums[index]);
            res.add(t);
            return res;
        }
        int num = nums[index];
        List<List<Integer>> list = permute2(nums, index + 1);
        list.forEach(s -> {
            for (int i = 0; i <= s.size(); i++) {
                List<Integer> t = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    t.add(s.get(j));
                }
                t.add(num);
                for (int j = i; j < s.size(); j++) {
                    t.add(s.get(j));
                }
                res.add(t);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        List<List<Integer>> list = p.permute(new int[]{1, 2, 3});
        System.out.println(list);

    }
}
