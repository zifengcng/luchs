package com.lynx.explore.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/6/24 14:27
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1202/
 */
public class YangHui {

	/**
	 * 杨辉三角
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows <= 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(j, 1);
				} else {
					List<Integer> list1 = result.get(i - 1);
					list.add(j, list1.get(j-1)+list1.get(j));
				}
			}
			result.add(i, list);
		}
		return result;
	}

	/**
	 * 杨辉三角 II
	 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
	 * 你可以优化你的算法到 O(k) 空间复杂度吗？
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>(rowIndex + 1);
		if (rowIndex < 0) {
			return result;
		}
		long index = 1;
		for (int i = 0; i <= rowIndex; i++) {
			result.add(i, (int) index);
			index = index * (rowIndex - i) / (i + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		YangHui yangHui = new YangHui();
		List<Integer> row = yangHui.getRow(6);
		System.out.println(row);
	}
}
