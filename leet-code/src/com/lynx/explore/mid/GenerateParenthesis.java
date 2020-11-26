package com.lynx.explore.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/11
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv33m7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            res.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append("(");
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(4));
    }
}
