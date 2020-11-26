package com.lynx.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/10/30
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2  );* 缓存容量 *
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * 作者：力扣(LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmsw5r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LRUCache {

    private DLinkNode head;
    private DLinkNode tail;
    private Map<Integer, DLinkNode> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new DLinkNode();
        tail = new DLinkNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            // 不存在
            DLinkNode dLinkNode = new DLinkNode(key, value);
            map.put(key, dLinkNode);
            addToHead(dLinkNode);
            size++;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            // 存在
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
