package com.lynx.explore.binarySearch;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/22 10:02
 * 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * https://leetcode-cn.com/explore/learn/card/binary-search/215/more-practices-ii/861/
 */
public class SplitArray {

	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (m == 1) {
			return Arrays.stream(nums).sum();
		}
		if (m == nums.length) {
			return Arrays.stream(nums).max().getAsInt();
		}
		int n = nums.length / m;
		long max = getMax(nums, n);

		long sum;

		long l = 0;
		long r = max;
		while (l < r) {
			long mid = (l + r) / 2;
			sum = 0;
			int count = 0;
			boolean b = false;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > mid) {
					b = true;
					break;
				}
				if (sum + nums[i] > mid) {
					sum = nums[i];
					count++;
				} else {
					sum += nums[i];
				}
			}
			if (b) {
				l++;
				continue;
			}
			if (sum > 0) {
				count++;
			}
			if (count > m) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		return (int) r;
	}

	private long getMax(int[] nums, int n) {
		long max = Long.MIN_VALUE;
		long sum = 0;
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (n % (i + 1) == 0 && n / (i + 1) == 1 && c != n) {
				max = Long.max(max, sum);
				sum = 0;
				c++;
			}
		}
		max = Long.max(max, sum);
		return max;
	}

	public static void main(String[] args) {
		SplitArray splitArray = new SplitArray();
		int i = splitArray.splitArray(new int[]{7,2,5,10,8}, 2);
		System.out.println(i);
	}

}
