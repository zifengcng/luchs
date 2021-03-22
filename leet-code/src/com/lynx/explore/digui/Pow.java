package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/24 18:58
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/259/complexity-analysis/1227/
 */
public class Pow {

    public double myPow(double x, int n) {
        long f = n;
        return myPow2(x, f);
    }

    private double myPow2(double x, long f) {
        if (f < 0) {
            return 1 / myPow2(x, -f);
        }
        if (f == 0) {
            return 1;
        }
        if (f == 1) {
            return x;
        }
        double half = myPow2(x, f / 2);

        if (f % 2 != 0) {
            return half * half * x;
        } else {
            return half * half;
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2.00000D, -10));
    }

}
