package com.lynx.explore.digui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/6/24 18:05
 * <p>
 * 斐波那契数
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/258/memorization/1212/
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Fib {

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        Integer value = cache.get(N);
        if (value != null) {
            return value;
        }
        if (N < 2) {
            value = N;
        } else {
            value = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, value);
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(10));
    }
}
