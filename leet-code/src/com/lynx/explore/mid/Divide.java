package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/21
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwp6vi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        boolean isPositive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isPositive = false;
        }

        long a = dividend;
        long b = divisor;
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }

        int res = div(a, b);
        if (isPositive) {
            return res;
        }
        return -res;
    }

    private int div(long a, long b) {
        if (a < b) {
            return 0;
        }
        int res = 1;
        long t = b;
        while (t + t <= a) {
            res += res;
            t += t;
        }
        a -= t;
        return res + div(a, b);
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(-2147483648, 2));
    }
}
