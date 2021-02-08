package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2021/2/3
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 * https://leetcode-cn.com/problems/sliding-window-median/
 */
@HardCode
public class MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        int len = nums.length;
        double[] res = new double[len - k + 1];
        res[0] = dh.getMedian();
        for (int i = k; i < len; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            res[i - k + 1] = dh.getMedian();
        }
        return res;
    }

    class DualHeap {
        private int k;
        // 大根堆：维护较小的一半元素
        private PriorityQueue<Integer> small;
        // 小根堆：维护较大的一半元素
        private PriorityQueue<Integer> large;
        // 哈希表：记录 【延迟删除】的元素，key 为元素，value 为需要删除的次数
        private Map<Integer, Integer> delayed;
        // small 和 large 当前包含的元素个数，需要扣除被【延迟删除】的元素
        private int smallSize;
        private int largeSize;

        public DualHeap(int k) {
            this.k = k;
            this.small = new PriorityQueue<>(Comparator.reverseOrder());
            this.large = new PriorityQueue<>((Integer::compareTo));
            this.delayed = new HashMap<>();
            this.smallSize = 0;
            this.largeSize = 0;
        }

        public void insert(int num) {
            if (small.isEmpty() || num < small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }

        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                // small 比 large 元素多 2 个
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }

        // 不断地弹出 heap 的堆顶元素，并且更新哈希表
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    Integer count = delayed.get(num);
                    if (count == 1) {
                        delayed.remove(num);
                    } else {
                        delayed.put(num, count - 1);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        public void erase(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                largeSize--;
                if (num == large.peek()) {
                    prune(large);
                }
            }
            makeBalance();
        }

        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }
    }
}
