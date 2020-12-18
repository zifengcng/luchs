package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2020/12/4
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 */
@MidCode
public class IsPossible {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {
                PriorityQueue<Integer> queue = map.get(num - 1);
                Integer prevLen = queue.poll();
                if (queue.isEmpty()) {
                    map.remove(num - 1);
                }
                map.get(num).offer(prevLen + 1);
            } else {
                map.get(num).offer(1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() > 3) {
                return false;
            }
        }

        return true;
    }


}
