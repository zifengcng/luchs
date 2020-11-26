package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/11/18
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * https://leetcode-cn.com/problems/word-break-ii/
 */
@HardCode
public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> visited = new HashMap<>();
        return wordBreakDfs(s, new HashSet<>(wordDict), 0, s.length(), visited);
    }

    private List<String> wordBreakDfs(String s, Set<String> wordDict, int index,
                                      int len, Map<Integer, List<String>> visited) {

        if (visited.containsKey(index)) {
            return visited.get(index);
        }
        List<String> res = new ArrayList<>();
        if (index == len) {
            res.add("");
            return res;
        }
        for (int i = index + 1; i <= len; i++) {
            String cur = s.substring(index, i);
            if (wordDict.contains(cur)) {
                List<String> next = wordBreakDfs(s, wordDict, i, len, visited);
                for (String str : next) {
                    res.add(cur + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        visited.put(index, res);

        return res;
    }


    public static void main(String[] args) {
        WordBreak w = new WordBreak();

        //示例 1：
        //
        //输入:
        //s = "catsanddog"
        //wordDict = ["cat", "cats", "and", "sand", "dog"]
        //输出:
        //[
        //  "cats and dog",
        //  "cat sand dog"
        //]
        printRes(w.wordBreak("catsanddog", buildList(new String[]{"cat", "cats", "and", "sand", "dog"})));

        //示例 2：
        //
        //输入:
        //s = "pineapplepenapple"
        //wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
        //输出:
        //[
        //  "pine apple pen apple",
        //  "pineapple pen apple",
        //  "pine applepen apple"
        //]
        //解释: 注意你可以重复使用字典中的单词。
        printRes(w.wordBreak("pineapplepenapple", buildList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"})));

        //示例 3：
        //
        //输入:
        //s = "catsandog"
        //wordDict = ["cats", "dog", "sand", "and", "cat"]
        //输出:
        //[]
        printRes(w.wordBreak("catsandog", buildList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }

    private static void printRes(List<String> res) {
        for (String r : res) {
            System.out.println(r);
        }
    }

    private static List<String> buildList(String[] arr) {
        return Arrays.asList(arr);
    }
}
