package com.lynx.explore.prefixTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/28 19:17
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * https://leetcode-cn.com/explore/learn/card/trie/168/practical-application-ii/652/
 */
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (!root.containsKey(c)) {
            return;
        }
        TrieNode cur = root.get(c);
        if (cur.getWord() != null) {
            res.add(cur.getWord());
            cur.setWord(null);
        }

        board[i][j] = '#';

        dfs(board, i - 1, j, cur, res);
        dfs(board, i + 1, j, cur, res);
        dfs(board, i, j - 1, cur, res);
        dfs(board, i, j + 1, cur, res);

        board[i][j] = c;

        if (cur.getChildren().isEmpty()) {
            root.getChildren().remove(c);
        }

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c);
                }
                node = node.get(c);
            }
            node.setWord(word);
        }
        return root;
    }

}
