package com.lynx.random;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2020/9/28
 * 857. 雇佣 K 名工人的最低成本
 * 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
 * <p>
 * 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
 * <p>
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 返回组成一个满足上述条件的工资组至少需要多少钱。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： quality = [10,20,5], wage = [70,50,30], K = 2
 * 输出： 105.00000
 * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 * 示例 2：
 * <p>
 * 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
 * 输出： 30.66667
 * 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= N <= 10000，其中 N = quality.length = wage.length
 * 1 <= quality[i] <= 10000
 * 1 <= wage[i] <= 10000
 * 与正确答案误差在 10^-5 之内的答案将被视为正确的。
 * <p>
 * https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers/
 */
@HardCode
public class MincostToHireWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Node> list = new ArrayList<>();
        int len = quality.length;

        for (int i = 0; i < len; i++) {
            list.add(new Node(quality[i], wage[i]));
        }
        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        double res = Double.MAX_VALUE;
        int sumQ = 0;

        for (Node node : list) {
            queue.offer(-node.quality);
            sumQ += node.quality;

            if (queue.size() > K) {
                sumQ += queue.poll();
            }
            if (queue.size() == K) {
                res = Math.min(res, sumQ * node.ratio());
            }
        }

        return res;
    }

    class Node implements Comparable<Node> {
        int quality;
        int wage;

        public Node() {
        }

        public Node(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(ratio(), o.ratio());
        }

        public double ratio() {
            return (double) wage / quality;
        }
    }

    public static void main(String[] args) {
        MincostToHireWorkers m = new MincostToHireWorkers();
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        double v = m.mincostToHireWorkers(quality, wage, 2);
        System.out.println(v);
    }
}
