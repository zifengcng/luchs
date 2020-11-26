package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/8/31
 * 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xd54x2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        if (m == 0) {
            return true;
        }
        int n = prerequisites[0].length;
        if (n == 0) {
            return true;
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

        int resCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                resCount++;
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

        return resCount == numCourses;
    }

    public static void main(String[] args) {
        CanFinish c = new CanFinish();
        boolean b = c.canFinish(3, new int[][]{{1, 0}, {0, 2}});
        System.out.println(b);
    }
}
