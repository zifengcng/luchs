package com.lynx.explore.find;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/13 10:50
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/236/learn-to-use-set/979/
 */
public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        int sum = n;
        while (sum > 1) {
            sum = getSum(sum);
            if (visited.contains(sum)) {
                break;
            }
            visited.add(sum);
        }
        return sum == 1;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n >= 10) {
            int m = n % 10;
            sum += m * m;
            n /= 10;
        }
        sum += n * n;
        return sum;
    }

    public static void main(String[] args) {
        IsHappy i = new IsHappy();
        boolean happy = i.isHappy(19);
        System.out.println(happy);
    }
}
