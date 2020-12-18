package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/12/3
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 * https://leetcode-cn.com/problems/count-primes/
 */
@EasyCode
public class CountPrimes {

    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }

        return res;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 埃氏筛
    public int countPrimes2(int n) {
        int res = 0;
        // 是否是质数
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                res++;
                if ((long) (i * i) < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }

        return res;
    }

    // 线性筛
    public int countPrimes3(int n) {
        int res = 0;
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                primes.add(i);
            }
            for (Integer prime : primes) {
                if (i * prime >= n) {
                    break;
                }
                isPrime[i * prime] = false;
                if (i % prime == 0) {
                    break;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes2(499979));
    }
}
