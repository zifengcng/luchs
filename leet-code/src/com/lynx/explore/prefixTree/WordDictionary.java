package com.lynx.explore.prefixTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wbc
 * @date 2020/7/28 16:50
 * 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * https://leetcode-cn.com/explore/learn/card/trie/167/practical-application-i/650/
 */
public class WordDictionary {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (!cur.containsKey(c)) {
                cur.put(c);
            }
            cur = cur.get(c);
        }
        cur.setIsLeaf();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        Deque<TrieNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 0;
        int len = chars.length;
        while (!queue.isEmpty() && i < len) {
            int size = queue.size();
            char c = chars[i++];
            boolean res = false;
            for (int j = 0; j < size; j++) {
                TrieNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if ('.' == c && !node.getChildren().isEmpty()) {
                    queue.addAll(node.getChildren().values());
                    res = true;
                } else if (node.containsKey(c)) {
                    queue.add(node.get(c));
                    res = true;
                }
            }
            if (!res) {
                return false;
            }
        }
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if (node.getIsLeaf()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("a."));
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
