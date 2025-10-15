//package com.lynx.explore.high;
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//
///**
// * @Author cheng
// * @Date 2020/8/27
// */
//public class LadderLength {
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        return getLadderLength(beginWord, endWord, wordList);
//    }
//
//    private int getLadderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        int len = beginWord.length();
//        Map<String, List<String>> all = new HashMap<>();
//        wordList.forEach(word -> {
//            for (int i = 0; i < len; i++) {
//                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
//                List<String> list = all.getOrDefault(newWord, new ArrayList<>());
//                list.add(word);
//                all.put(newWord, list);
//            }
//        });
//
//        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
//        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
//        beginQueue.add(new Pair<>(beginWord, 1));
//        endQueue.add(new Pair<>(endWord, 1));
//
//        Map<String, Integer> beginVisited = new HashMap<>();
//        Map<String, Integer> endVisited = new HashMap<>();
//        beginVisited.put(beginWord, 1);
//        endVisited.put(endWord, 1);
//
//        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
//            int res = visitWord(all, len, beginQueue, beginVisited, endVisited);
//            if (res > -1) {
//                return res;
//            }
//
//            res = visitWord(all, len, endQueue, endVisited, beginVisited);
//            if (res > -1) {
//                return res;
//            }
//        }
//
//        return 0;
//    }
//
//    private int visitWord(Map<String, List<String>> all, int len, Queue<Pair<String, Integer>> beginQueue, Map<String, Integer> beginVisited, Map<String, Integer> endVisited) {
//        Pair<String, Integer> node = beginQueue.poll();
//        String word = node.getKey();
//        Integer level = node.getValue();
//
//        for (int i = 0; i < len; i++) {
//            String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
//            for (String cur : all.getOrDefault(newWord, new ArrayList<>())) {
//                if (endVisited.containsKey(cur)) {
//                    return level + endVisited.get(cur);
//                }
//                if (!beginVisited.containsKey(cur)) {
//                    beginVisited.put(cur, level + 1);
//                    beginQueue.add(new Pair<>(cur, level + 1));
//                }
//            }
//
//        }
//
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        String str = "abc";
//        System.out.println(str.substring(0, 0));
//        System.out.println(str.substring(0, 2) + "*" + str.substring(3));
//    }
//}
