package com.lynx.explore.hash;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/20 9:43
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/799/
 */
public class MyHashSet {

    private Integer[] data;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.data = new Integer[16];
        this.size = 16;
    }

    public void add(int key) {
        if (key < size) {
            data[key] = key;
            return;
        }
        size = key + 1;
        Integer[] temp = Arrays.copyOf(data, size);
        temp[key] = key;
        data = temp;
    }

    public void remove(int key) {
        if (key >= size) {
            return;
        }
        data[key] = null;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (key >= size) {
            return false;
        }
        return data[key] != null;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(6);
        myHashSet.remove(4);
        myHashSet.add(17);
        myHashSet.contains(14);
        myHashSet.add(14);
        myHashSet.remove(17);
        myHashSet.add(14);
        myHashSet.add(14);
        myHashSet.add(18);
        myHashSet.add(14);

        System.out.println();
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
