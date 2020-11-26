package com.lynx.explore.digui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/6/24 18:12
 * <p>
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/258/memorization/1213/
 */
public class Climb {

	Map<Integer, Integer> cache = new HashMap<>();

	public int climbStairs(int n) {
		Integer value = cache.get(n);
		if (value != null) {
			return value;
		}
		if (n < 3) {
			value = n;
		} else {
			value = climbStairs(n - 1) + climbStairs(n - 2);
		}
		cache.put(n, value);
		return value;
	}
}
