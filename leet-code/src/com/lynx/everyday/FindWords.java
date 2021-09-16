package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author cheng
 * @Date 2021/9/16
 * <p>
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * https://leetcode-cn.com/problems/word-search-ii/
 */
@HardCode
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        return findWordsHelper(board, root);
    }

    private List<String> findWordsHelper(char[][] board, Trie root) {
        // 右上遍历，左下遍历
        int m = board.length;
        int n = board[0].length;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder seen = new StringBuilder();
                dfs(board, i, j, m, n, root, seen, res);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(char[][] board, int i, int j, int m, int n, Trie root, StringBuilder seen, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.isEnd) {
            if (seen.length() > 0) {
                res.add(seen.toString());
            }
            root.isEnd = false;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        char cur = board[i][j];
        if (!root.containsKey(cur)) {
            return;
        }

        seen.append(cur);
        Trie trie = root.get(cur);

        board[i][j] = '#';

        dfs(board, i + 1, j, m, n, trie, seen, res);
        dfs(board, i - 1, j, m, n, trie, seen, res);
        dfs(board, i, j - 1, m, n, trie, seen, res);
        dfs(board, i, j + 1, m, n, trie, seen, res);

        if (seen.length() > 0) {
            seen.deleteCharAt(seen.length() - 1);
        }

        board[i][j] = cur;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie(null);
        for (String word : words) {
            Trie trie = root;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                trie = trie.put(aChar);
            }
            trie.isEnd = true;
        }
        return root;
    }

    static class Trie {
        Character val;
        boolean isEnd;
        Map<Character, Trie> map;

        public Trie(Character val) {
            this.val = val;
            this.map = new HashMap<>();
        }

        public boolean containsKey(char val) {
            return map.containsKey(val);
        }

        public Trie get(char val) {
            return map.get(val);
        }

        public Trie put(char val) {
            if (containsKey(val)) {
                return get(val);
            }
            Trie trie = new Trie(val);
            map.put(val, trie);
            return trie;
        }
    }

    public static void main(String[] args) {
        FindWords f = new FindWords();

        // 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
        //输出：["eat","oath"]
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(f.findWords(board, words));

        // 输入：
        //[["a","a"]]
        //["aaa"]
        //输出：
        //[]
        board = new char[][]{{'a', 'a'}};
        words = new String[]{"aaa"};
        System.out.println(f.findWords(board, words));

        // 输入：
        //{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}
        //{"oath","pea","eat","rain","hklf", "hf"}
        //预期结果：
        //{'oath','eat','hklf','hf'}
        board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        words = new String[]{"oath","pea","eat","rain","hklf", "hf"};
        System.out.println(f.findWords(board, words));
    }
}
