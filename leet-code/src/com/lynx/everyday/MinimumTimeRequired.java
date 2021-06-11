package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/5/8
 * 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * <p>
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 * <p>
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 */
@HardCode
public class MinimumTimeRequired {

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int len = jobs.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;

            low++;
            high--;
        }

        int l = jobs[0];
        int r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, 0, workloads, limit);
    }

    private boolean backtrack(int[] jobs, int i, int[] workloads, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; j++) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, i + 1, workloads, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MinimumTimeRequired m = new MinimumTimeRequired();
        //示例 1：
        //
        //输入：jobs = [3,2,3], k = 3
        //输出：3
        int[] jobs = new int[]{3, 2, 3};
        int k = 3;
        System.out.println(m.minimumTimeRequired(jobs, k) == 3);

        //示例 2：
        //
        //输入：jobs = [1,2,4,7,8], k = 2
        //输出：11
        jobs = new int[]{1, 2, 4, 7, 8};
        k = 2;
        System.out.println(m.minimumTimeRequired(jobs, k) == 11);

        //示例 3：
        //
        //输入：jobs = [1,2,4,7,8], k = 3
        //输出：8
        jobs = new int[]{1, 2, 4, 7, 8};
        k = 3;
        System.out.println(m.minimumTimeRequired(jobs, k) == 8);
    }
}
