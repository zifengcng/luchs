package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/18
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdkk5t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Trap {

    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        int sum = 0;
        int hLeft = height[left];
        int hRight = height[right];
        while (left < right) {
            while (left + 1 < right && height[left + 1] > hLeft) {
                left++;
                hLeft = height[left];
            }
            while (right - 1 > left && height[right - 1] > hRight) {
                right--;
                hRight = height[right];
            }
            if (left + 1 == right) {
                break;
            }

            if (hLeft < hRight) {
                left++;
                sum += Math.max(hLeft - height[left], 0);
            } else {
                right--;
                sum += Math.max(hRight - height[right], 0);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = trap.trap(height);
        System.out.println(sum);
    }
}
