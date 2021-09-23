package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2021/9/23
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 * https://leetcode-cn.com/problems/power-of-three/
 */
@EasyCode
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
