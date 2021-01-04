package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author cheng
 * @Date 2021/1/4
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
@EasyCode
public class Fib {

    public int fib(int n) {
        Map<Integer, Integer> visited = new HashMap<>();
        int helper = helper(n, visited);
        System.out.println(visited);
        return helper;
    }

    private int helper(int n, Map<Integer, Integer> visited) {
        if (n < 2) {
            return n;
        }
        Integer existNum = visited.get(n);
        if (Objects.nonNull(existNum)) {
            return existNum;
        }
        int sum = helper(n - 1, visited) + helper(n - 2, visited);
        visited.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        Fib f = new Fib();
        System.out.println(f.fib(48));
        // sum = 2971215073 > Integer.MAX_VALUE , n = 48
//        f.getMaxN();
    }

    public void getMaxN() {
        Map<Long, Long> visited = new HashMap<>();
        long sum = 0;
        long n = 0;
        while (sum <= Integer.MAX_VALUE) {
            sum = helper2(n, visited);
            n++;
        }
        System.out.println("sum = " + sum + ", n = " + n);
    }

    private long helper2(long n, Map<Long, Long> visited) {
        if (n < 2) {
            return n;
        }
        Long existNum = visited.get(n);
        if (Objects.nonNull(existNum)) {
            return existNum;
        }
        long sum = helper2(n - 1, visited) + helper2(n - 2, visited);
        visited.put(n, sum);
        return sum;
    }
}
