package com.lynx.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/4/14
 */
public class Trie {

    private Map<Character, Trie> map;
    private Character val;
    private boolean isLeaf;

    /** Initialize your data structure here. */
    public Trie() {
        this.map = new HashMap<>();
        this.val = null;
        this.isLeaf = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie trie = this;
        for (char c : chars) {
            if (trie.containsKey(c)) {
                trie = trie.get(c);
            } else {
                trie = trie.put(c);
            }
        }
        trie.setLeaf(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.containsKey(c)) {
                trie = trie.get(c);
            } else {
                return false;
            }
        }
        return trie.isLeaf();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            if (trie.containsKey(c)) {
                trie = trie.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean containsKey(char c) {
        return map.containsKey(c);
    }

    public Trie get(char c) {
        return map.get(c);
    }


    private Trie put(char c) {
        Trie res = new Trie();
        res.setVal(c);
        this.getMap().put(c, res);
        return res;
    }

    public Map<Character, Trie> getMap() {
        return map;
    }

    public void setMap(Map<Character, Trie> map) {
        this.map = map;
    }

    public Character getVal() {
        return val;
    }

    public void setVal(Character val) {
        this.val = val;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
