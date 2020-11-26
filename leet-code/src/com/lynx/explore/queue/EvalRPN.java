package com.lynx.explore.queue;

import java.util.Stack;

/**
 * @author wbc
 * @date 2020/7/9 16:26
 * 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/880/
 */
public class EvalRPN {

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (isOp(s)) {
				Integer i2 = stack.pop();
				Integer i1 = stack.pop();
				int t = op(i1, s, i2);
				stack.push(t);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();
	}

	private int op(Integer i1, String s, Integer i2) {
		if (s.equals("+")) {
			return i1 + i2;
		}
		if (s.equals("-")) {
			return i1 - i2;
		}
		if (s.equals("*")) {
			return i1 * i2;
		}
		if (s.equals("/")) {
			return i1 / i2;
		}
		return 0;
	}

	private boolean isOp(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
}
