package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author cheng
 * @Date 2020/11/23
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
@MidCode
public class FindMinArrowShots {

    // 方法一：xStart排
    // 方法二：xEnd排
    public int findMinArrowShots(int[][] points) {
        // 1.排序：按xStart从小往大
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        return helper(points, points.length);
    }

    private int helper(int[][] points, int len) {
        if (len == 0) {
            return 0;
        }
        int cnt = 1;
        int l = points[0][0];
        int r = points[0][1];
        int index = 0;
        while (index < len) {
            // 当前节点
            int[] cur = points[index];
            // 1.左下标在范围内
            if (cur[0] >= l && cur[0] <= r) {
                l = cur[0];
                r = Math.min(r, cur[1]);
            } else {
                cnt++;
                l = cur[0];
                r = cur[1];
            }
            index++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        FindMinArrowShots f = new FindMinArrowShots();
        //示例 1：
        //
        //输入：points = {{10,16},{2,8},{1,6},{7,12}}
        //输出：2
        //解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
        System.out.println(f.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));

        //示例 2：
        //
        //输入：points = {{1,2},{3,4},{5,6},{7,8}}
        //输出：4
        System.out.println(f.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));

        //示例 3：
        //
        //输入：points = {{1,2},{2,3},{3,4},{4,5}}
        //输出：2
        System.out.println(f.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));

        //示例 4：
        //
        //输入：points = {{1,2}}
        //输出：1
        System.out.println(f.findMinArrowShots(new int[][]{{1, 2}}));

        //示例 5：
        //
        //输入：points =  {{2,3},{2,3}}
        //输出：1
        System.out.println(f.findMinArrowShots(new int[][]{{2, 3}, {2, 3}}));

    }
}