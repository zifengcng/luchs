package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wubaocheng1
 * @date 2021/11/29 6:34 下午
 * <p>
 * 786. 第 K 个最小的素数分数
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * <p>
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * <p>
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 * <p>
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * <p>
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 */
@HardCode
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        list.sort((o1, o2) -> o1[0] * o2[1] - o2[0] * o1[1]);
        return list.get(k - 1);
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int len = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]]);
        for (int i = 1; i < len; i++) {
            queue.offer(new int[]{0, i});
        }
        for (int i = 1; i < k; i++) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x + 1 < y) {
                queue.offer(new int[]{x + 1, y});
            }
        }

        return new int[]{arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }

    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
        int len = arr.length;
        double left = 0D;
        double right = 1D;
        while (true) {
            double mid = (left + right) / 2;
            int i = -1;
            int count = 0;

            // 记录最大的分数
            int x = 0;
            int y = 1;

            for (int j = 1; j < len; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }

            if (count == k) {
                return new int[]{x, y};
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }


}
