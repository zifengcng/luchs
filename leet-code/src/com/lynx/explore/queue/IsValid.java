package com.lynx.explore.queue;

import java.util.Stack;

/**
 * @author wbc
 * @date 2020/7/9 15:07
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/878/
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && isEquals(chars[i], stack.peek())) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    private boolean isEquals(char a, Character b) {
        if (a == ')') {
            return b == '(';
        }
        if (a == '}') {
            return b == '{';
        }
        if (a == ']') {
            return b == '[';
        }
        return false;
    }
}
