package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2020/11/30
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * https://leetcode-cn.com/problems/reorganize-string/
 */
@MidCode
public class ReorganizeString {

    public String reorganizeString(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder(len);

        int[] counts = new int[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
            max = Math.max(max, counts[c - 'a']);
        }

        if (max > (len + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue =
                new PriorityQueue<>((o1, o2) -> counts[o2 - 'a'] - counts[o1 - 'a']);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                queue.add((char) (i + 'a'));
            }
        }

        while (queue.size() > 1) {
            Character letter1 = queue.poll();
            Character letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);

            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString r = new ReorganizeString();
        //示例 1:
        //
        //输入: S = "aab"
        //输出: "aba"
        System.out.println(r.reorganizeString("aab"));

        //示例 2:
        //
        //输入: S = "aaab"
        //输出: ""
        System.out.println(r.reorganizeString("aaab"));

        //输入: S = "aaabc"
        //输出: "abaca"
        System.out.println(r.reorganizeString("aaabc"));

    }
}
