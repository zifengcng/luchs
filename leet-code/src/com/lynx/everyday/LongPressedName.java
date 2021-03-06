package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2020/10/21
 * <p>
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 * <p>
 * https://leetcode-cn.com/problems/long-pressed-name/
 */
@EasyCode
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int len = name.length();
        int tLen = typed.length();
        int j = 0;

        for (int i = 0; i < len; i++) {
            if (j == tLen) {
                return false;
            }
            if (typed.charAt(j) == name.charAt(i)) {
                j++;
            } else {
                if (j == 0) {
                    return false;
                }
                char prev = typed.charAt(j - 1);
                if (typed.charAt(j) == prev) {
                    while (j < tLen && typed.charAt(j) == prev) {
                        j++;
                    }
                } else {
                    return false;
                }

                if (j < tLen && typed.charAt(j) == name.charAt(i)) {
                    j++;
                } else {
                    return false;
                }
            }
        }

        char prev = typed.charAt(j - 1);
        if (j < tLen && typed.charAt(j) == prev) {
            while (j < tLen && typed.charAt(j) == prev) {
                j++;
            }
        }

        return j == tLen;
    }


    public static void main(String[] args) {
        LongPressedName l = new LongPressedName();
        System.out.println(l.isLongPressedName("laiden", "laiden"));
    }
}
