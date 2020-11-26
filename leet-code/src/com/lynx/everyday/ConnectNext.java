package com.lynx.everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author cheng
 * @Date 2020/9/28
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * <p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class ConnectNext {

    // 时间O(N) 空间O(N)
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                node.next = i == size - 1 ? null : queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ConnectNext c = new ConnectNext();
        Node root = c.new Node(1);
        Node n1 = c.new Node(2);
        Node n2 = c.new Node(3);
        Node n3 = c.new Node(4);
        Node n4 = c.new Node(5);
        Node n5 = c.new Node(7);

        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        root.left = n1;
        root.right = n2;

        Node node = c.connect(root);
        System.out.println(node);
    }

    private Node last = null;
    private Node nextStart = null;

    // 时间O(N) 空间O(1)
    public Node connect2(Node root) {
        Node start = root;

        while (start != null) {
            last = null;
            nextStart = null;

            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handler(p.left);
                }
                if (p.right != null) {
                    handler(p.right);
                }
            }
            start = nextStart;
        }

        return root;
    }

    private void handler(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
