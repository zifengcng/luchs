package com.lynx.explore.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/14 11:26
 * 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/239/learn-to-use-keys/1001/
 */
public class NumberOfBoomerangs {

	public int numberOfBoomerangs(int[][] points) {
		int res = 0;

		int length = points.length;
		for (int i = 0; i < length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < length; j++) {
				if (i == j) {
					continue;
				}
				int dist = (points[j][1] - points[i][1]) * (points[j][1] - points[i][1])
						+ (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]);
				map.put(dist, map.getOrDefault(dist, 0) + 1);
			}
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				Integer value = entry.getValue();
				if (value != null) {
					res += value * (value - 1);
				}
			}
		}

		return res;
	}
}
