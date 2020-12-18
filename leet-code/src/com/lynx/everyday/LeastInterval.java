package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2020/12/5
 * 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 * <p>
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= task.length <= 104
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 * https://leetcode-cn.com/problems/task-scheduler/
 */
@MidCode
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int i : map) {
            if (i > 0) {
                queue.add(i);
            }
        }

        int time = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while (i <= n) {
                if (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (poll > 1) {
                        temp.add(poll - 1);
                    }
                }
                time++;
                if (queue.isEmpty() && temp.isEmpty()) {
                    break;
                }
                i++;
            }
            queue.addAll(temp);
        }

        return time;
    }

    public static void main(String[] args) {
        LeastInterval l = new LeastInterval();

        //示例 1：
        //
        //输入：tasks = ['A','A','A','B','B','B'], n = 2
        //输出：8
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(l.leastInterval(tasks, n));

        //示例 2：
        //
        //输入：tasks = ['A','A','A','B','B','B'], n = 0
        //输出：6
        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        n = 0;
        System.out.println(l.leastInterval(tasks, n));

        //示例 3：
        //
        //输入：tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
        //输出：16
        tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        n = 2;
        System.out.println(l.leastInterval(tasks, n));


    }
}
