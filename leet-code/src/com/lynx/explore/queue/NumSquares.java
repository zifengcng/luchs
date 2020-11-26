package com.lynx.explore.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/9 13:49
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 */
public class NumSquares {

	public int numSquares(int n) {
		ArrayList<Integer> square_nums = new ArrayList<Integer>();
		for (int i = 1; i * i <= n; ++i) {
			square_nums.add(i * i);
		}

		Set<Integer> queue = new HashSet<Integer>();
		queue.add(n);

		int level = 0;
		while (queue.size() > 0) {
			level += 1;
			Set<Integer> next_queue = new HashSet<Integer>();

			for (Integer remainder : queue) {
				for (Integer square : square_nums) {
					if (remainder.equals(square)) {
						return level;
					} else if (remainder < square) {
						break;
					} else {
						next_queue.add(remainder - square);
					}
				}
			}
			queue = next_queue;
		}
		return level;
	}


	public static void main(String[] args) {
		NumSquares numSquares = new NumSquares();
		System.out.println(numSquares.numSquares(13));
	}
}
