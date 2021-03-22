package com.lynx.explore.prefixTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/28 14:22
 * 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入只包含小写字母。
 * 1 <= dict.length <= 1000
 * 1 <= dict[i].length <= 100
 * 1 <= 句中词语数 <= 1000
 * 1 <= 句中词语长度 <= 1000
 * https://leetcode-cn.com/explore/learn/card/trie/167/practical-application-i/648/
 */
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty() || sentence == null) {
            return sentence;
        }
        String[] strs = sentence.split(" ");
        if (strs.length == 0) {
            return sentence;
        }
        TrieNode root = buildTrie(dict);
        List<String> res = getNewWords(strs, root);
        return String.join(" ", res);
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String str : dict) {
            TrieNode cur = root;
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (!cur.containsKey(c)) {
                    cur.put(c);
                }
                cur = cur.get(c);
            }
            cur.isLeaf = true;
        }
        return root;
    }

    private List<String> getNewWords(String[] strs, TrieNode root) {
        List<String> res = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            List<TrieNode> list = Collections.singletonList(root);
            String s = str;
            for (int i = 0; i < chars.length; i++) {
                List<TrieNode> temp = new ArrayList<>();
                char c = chars[i];
                boolean end = false;
                for (TrieNode trieNode : list) {
                    if (trieNode.containsKey(c)) {
                        if (trieNode.get(c).isLeaf) {
                            s = str.substring(0, i + 1);
                            end = true;
                            break;
                        }
                        temp.add(trieNode.get(c));
                    }
                }
                if (end) {
                    break;
                }
                list = temp;
            }
            res.add(s);
        }
        return res;
    }

    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isLeaf;

        public TrieNode() {
            children = new HashMap<>();
            isLeaf = false;
        }

        public boolean containsKey(Character c) {
            return children.containsKey(c);
        }

        public TrieNode get(Character c) {
            return children.get(c);
        }

        public void put(Character c) {
            children.put(c, new TrieNode());
        }
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        //["cat","bat","rat"]
        //"the cattle was rattled by the battery"
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String s = replaceWords.replaceWords(list, "the cattle was rattled by the battery");
        System.out.println(s);
    }
}
