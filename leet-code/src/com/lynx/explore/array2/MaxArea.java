package com.lynx.explore.array2;

/**
 * @author wbc
 * @date 2020/7/16 17:13
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/232/two-pointers/969/
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int res = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                int t = height[i];
                while (i <= j && height[i] <= t) {
                    i++;
                }
            } else {
                int t = height[j];
                while (j >= i && height[j] <= t) {
                    j--;
                }
            }
        }

        return res;
    }
}
