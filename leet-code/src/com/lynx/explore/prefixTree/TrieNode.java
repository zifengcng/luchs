package com.lynx.explore.prefixTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/28 16:56
 */
public class TrieNode {

    private Map<Character, TrieNode> children;
    private boolean isLeaf;
    private String word;
    private Integer index;

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

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public boolean getIsLeaf() {
        return this.isLeaf;
    }

    public void setIsLeaf() {
        this.isLeaf = true;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
