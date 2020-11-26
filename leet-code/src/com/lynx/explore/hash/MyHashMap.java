package com.lynx.explore.hash;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/20 10:17
 */
public class MyHashMap {

	private Node[] data;
	private int size;

	/** Initialize your data structure here. */
	public MyHashMap() {
		this.data = new Node[16];
		this.size = 16;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if (key < size) {
			data[key] = new Node(key,value);
			return;
		}
		size = key+1;
		Node[] temp = Arrays.copyOf(data, size);
		temp[key] = new Node(key,value);
		data = temp;
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		if (key >= size) {
			return -1;
		}
		Node node = data[key];
		return node == null ? -1 : node.getValue();
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		if (key >= size) {
			return;
		}
		data[key] = null;
	}

}

class Node{
	private int key;
	private int value;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
