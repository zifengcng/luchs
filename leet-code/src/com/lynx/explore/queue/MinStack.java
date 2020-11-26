package com.lynx.explore.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/9 14:58
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/877/
 */
public class MinStack {

	private List<Integer> data;
	private List<Integer> minData;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		data = new ArrayList<>();
		minData = new ArrayList<>();
	}

	public void push(int x) {
		data.add(x);
		if (minData.isEmpty()) {
			minData.add(x);
		} else {
			minData.add(Math.min(minData.get(minData.size() - 1), x));
		}
	}

	public void pop() {
		data.remove(data.size() - 1);
		minData.remove(minData.size() - 1);
	}

	public int top() {
		return data.get(data.size() - 1);
	}

	public int getMin() {
		return minData.get(minData.size() - 1);
	}
}
