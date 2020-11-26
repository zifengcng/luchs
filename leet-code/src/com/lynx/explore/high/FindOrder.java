package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/1
 * 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xd9kfc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        if (m == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;

        }
        int n = prerequisites[0].length;
        if (n == 0) {
            return new int[0];
        }

        // BFS 记录每个节点的出度值
        Map<Integer, List<Integer>> preNode = new HashMap<>();
        int[] outDegree = new int[numCourses];
        for (int[] nums : prerequisites) {
            List<Integer> list = preNode.getOrDefault(nums[1], new ArrayList<>());
            list.add(nums[0]);
            preNode.put(nums[1], list);
            outDegree[nums[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        int len = outDegree.length;
        for (int i = 0; i < len; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> courses = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                courses.add(num);
                List<Integer> list = preNode.get(num);
                if (list != null) {
                    for (Integer a : list) {
                        outDegree[a]--;
                        if (outDegree[a] == 0) {
                            queue.add(a);
                        }
                    }
                }
            }
        }

        if (courses.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        int i = 0;
        for (Integer course : courses) {
            res[i++] = course;
        }

        return res;
    }

    public static void main(String[] args) {
        FindOrder f = new FindOrder();
        int[] order = f.findOrder(1, new int[0][]);
        System.out.println(Arrays.toString(order));
    }
}
