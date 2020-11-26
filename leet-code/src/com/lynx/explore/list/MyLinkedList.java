package com.lynx.explore.list;

/**
 * @author wbc
 * @date 2020/7/16 18:18
 * 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 * 提示：
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * https://leetcode-cn.com/explore/learn/card/linked-list/193/singly-linked-list/741/
 */
public class MyLinkedList {

	private Integer val;
	private MyLinkedList next;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		this.val = null;
		this.next = null;
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index < 0) {
			return -1;
		}
		MyLinkedList temp = this;
		for (int i = 1; i <= index; i++) {
			if (temp.next == null) {
				return -1;
			}
			temp = temp.next;
		}
		if (temp.val == null) {
			return -1;
		}
		return temp.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		if (this.val == null) {
			this.val = val;
			return;
		}
		MyLinkedList temp = new MyLinkedList();
		temp.val = this.val;
		temp.next = this.next;

		this.val = val;
		this.next = temp;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (this.val == null) {
			this.val = val;
			return;
		}
		MyLinkedList temp = this;
		while (temp.next!=null) {
			temp = temp.next;
		}
		MyLinkedList t = new MyLinkedList();
		t.val = val;
		temp.next = t;
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if (index <= 0) {
			addAtHead(val);
			return;
		}
		MyLinkedList temp = this;
		int i = 0;
		while (i < index - 1) {
			if (temp.next == null) {
				return;
			}
			i++;
			temp = temp.next;
		}

		MyLinkedList t = new MyLinkedList();
		t.val = val;
		t.next = temp.next;
		temp.next = t;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < 0) {
			return;
		}
		if (index == 0) {
			if (this.next != null) {
				this.val = this.next.val;
				this.next = this.next.next;
			} else {
				this.val = null;
			}
			return;
		}
		MyLinkedList temp = this;
		int i = 0;
		while (i < index - 1) {
			if (temp.next == null) {
				return;
			}
			i++;
			temp = temp.next;
		}

		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList m = new MyLinkedList();
		m.addAtHead(1);
		m.addAtTail(3);
		m.addAtIndex(1,2);
		int i = m.get(1);
		m.deleteAtIndex(1);
		int i1 = m.get(1);
		System.out.println(i);
		System.out.println(i1);
	}
}
