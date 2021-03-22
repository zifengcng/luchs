package com.lynx.explore.queue;

/**
 * @author wbc
 * @date 2020/7/3 16:05
 * 广度优先搜索 - 模板
 * 之前，我们已经介绍了使用 BFS 的两个主要方案：遍历或找出最短路径。通常，这发生在树或图中。正如我们在章节描述中提到的，BFS 也可以用于更抽象的场景中。
 * <p>
 * 在本文中，我们将为你提供一个模板。然后，我们在本文后提供一些习题供你练习。
 * <p>
 * 在特定问题中执行 BFS 之前确定结点和边缘非常重要。通常，结点将是实际结点或是状态，而边缘将是实际边缘或可能的转换。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/870/
 */
public class BFSTemplate {

//	模板 I
//
//
//	在这里，我们为你提供伪代码作为模板：
    /**
     * Return the length of the shortest path between root and target node.
     */
//	int BFS(Node root, Node target) {
//		Queue<Node> queue;  // store all nodes which are waiting to be processed
//		int step = 0;       // number of steps neeeded from root to current node
//		// initialize
//		add root to queue;
//		// BFS
//		while (queue is not empty) {
//			step = step + 1;
//			// iterate the nodes which are already in the queue
//			int size = queue.size();
//			for (int i = 0; i < size; ++i) {
//				Node cur = the first node in queue;
//				return step if cur is target;
//				for (Node next : the neighbors of cur) {
//					add next to queue;
//				}
//				remove the first node from queue;
//			}
//		}
//		return -1;          // there is no path from root to target
//	}
//如代码所示，在每一轮中，队列中的结点是等待处理的结点。
//在每个更外一层的 while 循环之后，我们距离根结点更远一步。变量 step 指示从根结点到我们正在访问的当前结点的距离。


// 模板 II
//有时，确保我们永远不会访问一个结点两次很重要。否则，我们可能陷入无限循环。如果是这样，我们可以在上面的代码中添加一个哈希集来解决这个问题。这是修改后的伪代码：
    /**
     * Return the length of the shortest path between root and target node.
     */
//	int BFS(Node root, Node target) {
//		Queue<Node> queue;  // store all nodes which are waiting to be processed
//		Set<Node> used;     // store all the used nodes
//		int step = 0;       // number of steps neeeded from root to current node
//		// initialize
//		add root to queue;
//		add root to used;
//		// BFS
//		while (queue is not empty) {
//			step = step + 1;
//			// iterate the nodes which are already in the queue
//			int size = queue.size();
//			for (int i = 0; i < size; ++i) {
//				Node cur = the first node in queue;
//				return step if cur is target;
//				for (Node next : the neighbors of cur) {
//					if (next is not in used) {
//						add next to queue;
//						add next to used;
//					}
//				}
//				remove the first node from queue;
//			}
//		}
//		return -1;          // there is no path from root to target
//	}

    //有两种情况你不需要使用哈希集：
    //
    //你完全确定没有循环，例如，在树遍历中；
    //你确实希望多次将结点添加到队列中。


}
