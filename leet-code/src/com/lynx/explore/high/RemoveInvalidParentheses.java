package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/9/3
 * 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * <p>
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 * <p>
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 * <p>
 * 输入: ")("
 * 输出: [""]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdm2sj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveInvalidParentheses {

    private Set<String> validSet = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        dfs(s, 0, 0, 0, left, right, new StringBuilder());

        return new ArrayList<>(validSet);
    }

    private void dfs(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder express) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                validSet.add(express.toString());
            }
        } else {
            char c = s.charAt(index);

            if (c == '(' && leftRem > 0) {
                dfs(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, express);
            }
            if (c == ')' && rightRem > 0) {
                dfs(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, express);
            }

            int length = express.length();
            express.append(c);
            if (c != '(' && c != ')') {
                dfs(s, index + 1, leftCount, rightCount, leftRem, rightRem, express);
            } else if (c == '(') {
                dfs(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, express);
            } else if (rightCount < leftCount) {
                dfs(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, express);
            }
            express.deleteCharAt(length);
        }

    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        List<String> list = r.removeInvalidParentheses("((((((())))((");
        System.out.println(list);
    }

}
