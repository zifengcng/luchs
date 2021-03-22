package com.lynx.explore.prefixTree;

/**
 * @author wbc
 * @date 2020/7/27 18:13
 * Map Sum Pairs
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * https://leetcode-cn.com/explore/learn/card/trie/167/practical-application-i/647/
 */
public class MapSum {

    private MapSum[] nodes;
    private int sum;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        nodes = new MapSum[26];
    }

    public void insert(String key, int val) {
        char[] chars = key.toCharArray();
        MapSum temp = this;
        for (char c : chars) {
            if (temp.nodes[c - 'a'] == null) {
                temp.nodes[c - 'a'] = new MapSum();
            }
            temp = temp.nodes[c - 'a'];
        }
        temp.sum = val;
        temp.isEnd = true;
    }

    public int sum(String prefix) {
        char[] chars = prefix.toCharArray();
        MapSum temp = this;
        for (char c : chars) {
            if (temp.nodes[c - 'a'] != null) {
                temp = temp.nodes[c - 'a'];
            } else {
                return 0;
            }
        }
        return sumNode(temp);
    }

    private int sumNode(MapSum node) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.isEnd) {
            res += node.sum;
        }
        for (MapSum n : node.nodes) {
            res += sumNode(n);
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
    }
}
