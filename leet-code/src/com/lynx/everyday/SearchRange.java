package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/12/1
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
@MidCode
public class SearchRange {

    // 二分查找
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1, -1};
        if (len == 0) {
            return res;
        }

        int l = 0;
        int r = len;
        while (l < r) {
            int mid = (l + r) >> 1;
            int compare = nums[mid] - target;
            if (compare == 0) {
                // mid 为边界 查找左端点和右端点
                // 1左端点
                int l2 = l;
                int r2 = mid;
                while (l2 < r2) {
                    int m = (l2 + r2) >> 1;
                    int c = nums[m] - target;
                    if (c == 0) {
                        r2 = m;
                    } else {
                        l2 = m + 1;
                    }
                }
                res[0] = r2;

                // 2右端点
                l2 = mid;
                r2 = r;
                while (l2 < r2) {
                    int m = (l2 + r2) >> 1;
                    int c = nums[m] - target;
                    if (c == 0) {
                        l2 = m + 1;
                    } else {
                        r2 = m;
                    }
                }
                res[1] = l2 - 1;
                break;
            } else if (compare > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        //示例 1：
        //
        //输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(s.searchRange(nums, 8)));

        //示例 2：
        //
        //输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]
        nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(s.searchRange(nums, 6)));

        //示例 3：
        //
        //输入：nums = [], target = 0
        //输出：[-1,-1]
        nums = new int[]{};
        System.out.println(Arrays.toString(s.searchRange(nums, 0)));

        //示例 4：
        //
        //输入：nums = [1], target = 1
        //输出：[0,0]
        nums = new int[]{1};
        System.out.println(Arrays.toString(s.searchRange(nums, 1)));

        //示例 5：
        //
        //输入：nums = [1,3], target = 1
        //输出：[0,0]
        nums = new int[]{1, 3};
        System.out.println(Arrays.toString(s.searchRange(nums, 1)));

        //示例 6：
        //输入：nums = [1,2,3,3,3,3,4,5,9], target = 3
        //输出：[2,5]
        nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9};
        System.out.println(Arrays.toString(s.searchRange(nums, 3)));


    }
}
