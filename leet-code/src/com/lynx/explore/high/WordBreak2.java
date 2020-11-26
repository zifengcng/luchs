package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/7
 * 单词拆分 II
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
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdl705/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WordBreak2 {

    private Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakDfs(s, wordDict, 0);
    }

    private List<String> wordBreakDfs(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                List<String> list = wordBreakDfs(s, wordDict, i);
                for (String str : list) {
                    res.add(s.substring(start, i) + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        WordBreak2 w = new WordBreak2();
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(w.wordBreak("leetcode", wordDict));
    }

}
