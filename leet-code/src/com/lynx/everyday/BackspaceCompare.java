package com.lynx.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2020/10/19
 * <p>
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();

        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();

        for (int i = 0; i < sLen; i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }
        for (int i = 0; i < tLen; i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }

        if (stackS.size() != stackT.size()) {
            return false;
        }

        while (!stackS.isEmpty()) {
            if (!stackS.pop().equals(stackT.pop())) {
                return false;
            }
        }
        return true;
    }
}
