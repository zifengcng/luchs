package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/18
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdzifs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= height) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < len; j++) {
                if (heights[j] >= height) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, height * count);
        }
        return max;
    }
}
