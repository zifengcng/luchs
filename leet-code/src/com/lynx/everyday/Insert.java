package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/11/4
 * <p>
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * https://leetcode-cn.com/problems/insert-interval/
 */
@HardCode
public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        List<int[]> res = new ArrayList<>();
        boolean add = true;

        for (int[] interval : intervals) {
            if (interval[1] < left) {
                // 左侧，无交集
                res.add(interval);
            } else if (interval[0] > right) {
                // 右侧，无交集
                if (add) {
                    res.add(new int[]{left, right});
                    add = false;
                }
                res.add(interval);
            } else {
                // 重叠部分，计算最左端和最右端
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (add) {
            res.add(new int[]{left, right});
        }

        int size = res.size();
        int[][] resArr = new int[size][2];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] arr = insert.insert(new int[][]{{0, 5}}, new int[]{0, 6});
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
