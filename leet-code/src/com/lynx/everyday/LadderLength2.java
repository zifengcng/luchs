package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/11/5
 * <p>
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * https://leetcode-cn.com/problems/word-ladder-ii/
 */
@MidCode
public class LadderLength2 {

    // TODO
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return find(beginWord, endWord, wordList);
    }

    private List<List<String>> find(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }

        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(word);
                map.put(key, list);
            }
        });

        Deque<String> beginQueue = new LinkedList<>();
        Deque<String> endQueue = new LinkedList<>();
        beginQueue.add(beginWord);
        endQueue.add(endWord);

        Map<String, List<String>> beginVisited = new HashMap<>();
        Map<String, Deque<String>> endVisited = new HashMap<>();
        List<String> beginPath = new ArrayList<>();
        beginPath.add(beginWord);
        beginVisited.put(beginWord, beginPath);
        Deque<String> endPath = new ArrayDeque<>();
        endPath.push(endWord);
        endVisited.put(endWord, endPath);

        int min = Integer.MAX_VALUE;

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            //
        }

        return res;
    }


    public static void main(String[] args) {
        LadderLength2 l = new LadderLength2();
        String[] arr = {"hot", "dot", "dog", "lot", "cog"};
        List<List<String>> lists = l.findLadders("hit", "cog", Arrays.asList(arr));
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}
