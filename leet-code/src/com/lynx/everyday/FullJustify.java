package com.lynx.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/9/9
 * <p>
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * <p>
 * https://leetcode-cn.com/problems/text-justification/
 */
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;

        int sum = 0;
        List<List<String>> allList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int newSum = sum;
            if (newSum > 0) {
                newSum += 1;
            }
            if (newSum + words[i].length() > maxWidth) {
                allList.add(list);
                sum = words[i].length();
                list = new ArrayList<>();
                list.add(words[i]);
            } else {
                sum = newSum + words[i].length();
                list.add(words[i]);
            }
        }
        if (sum > 0) {
            allList.add(list);
        }
        List<String> res = new ArrayList<>(allList.size());
        for (int k = 0; k < allList.size() - 1; k++) {
            List<String> s = allList.get(k);
            StringBuilder sb = new StringBuilder();
            int count = s.size();
            int l = s.stream().map(String::length).reduce(Integer::sum).orElse(0);
            int x = maxWidth - l;
            if (count == 1) {
                sb.append(s.get(0));
                for (int i = 0; i < x; i++) {
                    sb.append(" ");
                }
            } else {
                int averSpace = x / (count - 1);
                int space = x - (averSpace * (count - 1));
                for (int i = 0; i < count - 1; i++) {
                    sb.append(s.get(i));
                    for (int j = 0; j < averSpace; j++) {
                        sb.append(" ");
                    }
                    if (space > 0) {
                        sb.append(" ");
                        space--;
                    }
                }
                sb.append(s.get(count - 1));
            }
            res.add(sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        List<String> last = allList.get(allList.size() - 1);
        for (String s : last) {
            sb.append(s);
            sb.append(" ");
        }
        if (sb.length() > maxWidth) {
            res.add(sb.substring(0, sb.length() - 1));
        } else {
            int x = maxWidth - sb.length();
            for (int i = 0; i < x; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        FullJustify f = new FullJustify();
        // 示例:
        //
        //输入:
        //words = ["This", "is", "an", "example", "of", "text", "justification."]
        //maxWidth = 16
        //输出:
        //[
        //   "This    is    an",
        //   "example  of text",
        //   "justification.  "
        //]
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(f.fullJustify(words, maxWidth));

        // 示例 2:
        //
        //输入:
        //words = ["What","must","be","acknowledgment","shall","be"]
        //maxWidth = 16
        //输出:
        //[
        //  "What   must   be",
        //  "acknowledgment  ",
        //  "shall be        "
        //]
        //解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
        //     因为最后一行应为左对齐，而不是左右两端对齐。
        //     第二行同样为左对齐，这是因为这行只包含一个单词。
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        System.out.println(f.fullJustify(words, maxWidth));

        // 示例 3:
        //
        //输入:
        //words = ["Science","is","what","we","understand","well","enough","to","explain",
        //         "to","a","computer.","Art","is","everything","else","we","do"]
        //maxWidth = 20
        //输出:
        //[
        //  "Science  is  what we",
        //  "understand      well",
        //  "enough to explain to",
        //  "a  computer.  Art is",
        //  "everything  else  we",
        //  "do                  "
        //]
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        System.out.println(f.fullJustify(words, maxWidth));
    }
}
