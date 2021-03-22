package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2021/3/5
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
@EasyCode
public class MyQueue {

    private Deque<Integer> stackFirst;
    private Deque<Integer> stackSecond;

    Integer front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackFirst = new ArrayDeque<>();
        stackSecond = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stackFirst.isEmpty()) {
            front = x;
        }
        stackFirst.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (stackSecond.isEmpty()) {
            while (!stackFirst.isEmpty()) {
                stackSecond.push(stackFirst.pop());
            }
        }
        return stackSecond.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) {
            return -1;
        }
        if (!stackSecond.isEmpty()) {
            return stackSecond.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackFirst.isEmpty() && stackSecond.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
