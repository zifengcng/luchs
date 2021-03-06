package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/6
 * <p>
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
@EasyCode
public class SortByBits {

    public int[] sortByBits(int[] arr) {
        return helper(arr);
    }

    private int[] helper(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Integer.bitCount(arr[i]) * 1000000 + arr[i];
        }

        Arrays.sort(res);

        for (int i = 0; i < len; i++) {
            res[i] = res[i] % 1000000;
        }

        return res;
    }

    public static void main(String[] args) {
        SortByBits s = new SortByBits();
        int[] arr = s.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 10; i++) {
            System.out.println("num=" + i + ", 1个数：" + s.get(i));
        }
    }

    // 获取二进制中1的个数
    // 方法一:
    public int get(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 2;
            num /= 2;
        }
        return res;
    }

    // 方法二：
    // 定义 bit[i]bit[i] 为数字 ii 二进制表示下数字 1 的个数，则可以列出递推式：
    // bit[i]=bit[i>>1]+(i&1)

    // 第三种：num = num & num-1：让num和num-1进行按位与运算，将二进制中出现的1从低位到高位依次变成0，num=0循环终止，循环的次数就为1的个数
}
