package com.lynx.explore.prefixTree;

/**
 * @author wbc
 * @date 2020/7/24 18:51
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * https://leetcode-cn.com/explore/learn/card/trie/166/basic-operations/645/
 */
public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!node.containsKey(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        private TrieNode[] nodes;
        private boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public boolean containsKey(Character c) {
            return nodes[c - 'a'] != null;
        }

        public TrieNode get(Character c) {
            return nodes[c - 'a'];
        }

        public void put(Character c) {
            nodes[c - 'a'] = new TrieNode();
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
