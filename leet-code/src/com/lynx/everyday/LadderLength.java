package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/11/5
 * <p>
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
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
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * https://leetcode-cn.com/problems/word-ladder/
 */
@MidCode
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return getLadderLength(beginWord, endWord, wordList);
    }

    private int getLadderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
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

        Deque<Pair<String, Integer>> beginQueue = new LinkedList<>();
        Deque<Pair<String, Integer>> endQueue = new LinkedList<>();
        Map<String, Integer> beginVisited = new HashMap<>();
        Map<String, Integer> endVisited = new HashMap<>();

        beginQueue.add(new Pair<>(beginWord, 1));
        endQueue.add(new Pair<>(endWord, 1));
        beginVisited.put(beginWord, 1);
        endVisited.put(endWord, 1);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int res = visitWord(beginQueue, len, map, beginVisited, endVisited);
            if (res > -1) {
                return res;
            }
            res = visitWord(endQueue, len, map, endVisited, beginVisited);
            if (res > -1) {
                return res;
            }
        }

        return 0;
    }

    private int visitWord(Deque<Pair<String, Integer>> queue, int len, Map<String, List<String>> map,
                          Map<String, Integer> beginVisited, Map<String, Integer> endVisited) {
        Pair<String, Integer> pair = queue.poll();
        String key = pair.getKey();
        Integer value = pair.getValue();

        for (int i = 0; i < len; i++) {
            String str = key.substring(0, i) + "*" + key.substring(i + 1);
            for (String cur : map.getOrDefault(str, new ArrayList<>())) {
                if (endVisited.containsKey(cur)) {
                    return value + endVisited.get(cur);
                }
                if (!beginVisited.containsKey(cur)) {
                    beginVisited.put(cur, value + 1);
                    queue.add(new Pair<>(cur, value + 1));
                }
            }
        }

        return -1;
    }
}
