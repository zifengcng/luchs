package com.lynx.explore;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/1/15
 */
public class LRUCache {

    private DLinkNode head;
    private DLinkNode tail;
    private Map<String, DLinkNode> cache;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        cache = new HashMap<>();
        size = 0;
    }

    public String get(String key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(String key, String value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode dLinkNode = new DLinkNode(key, value);
            addToHead(dLinkNode);
            size++;
            cache.put(key, dLinkNode);
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
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
        String key;
        String value;

        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
