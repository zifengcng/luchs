package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/12/8
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * <p>
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * <p>
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * <p>
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 */
@MidCode
public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        List<int[]> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(S, 0, len, null, null, list, res);
        return res;
    }

    private boolean helper(String s, int l, int r, Long f2, Long f3, List<int[]> list, List<Integer> res) {
        boolean end = false;
        for (int i = r - 1; i >= l; i--) {
            if (end) {
                return true;
            }
            if (r - i >= 12) {
                break;
            }
            long f1 = Long.parseLong(s.substring(i, r));
            if (f1 > Integer.MAX_VALUE) {
                continue;
            }
            if (f1 != 0 && s.charAt(i) == '0') {
                continue;
            }
            int[] indexes = {i, r};
            list.add(indexes);
            if (f3 == null) {
                end = helper(s, l, i, f2, f1, list, res);
            } else if (f2 == null) {
                end = helper(s, l, i, f1, f3, list, res);
            } else {
                if (f1 + f2 > f3) {
                    list.remove(indexes);
                    break;
                }
                if (f1 + f2 == f3) {
                    if (i == l) {
                        for (int[] arr : list) {
                            int num = Integer.parseInt(s.substring(arr[0], arr[1]));
                            res.add(num);
                        }
                        Collections.reverse(res);
                        return true;
                    }
                    end = helper(s, l, i, f1, f2, list, res);
                }
            }
            list.remove(indexes);
        }
        return end;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci s = new SplitIntoFibonacci();
        //示例 1：
        //
        //输入："123456579"
        //输出：[123,456,579]
        String str = "123456579";
        System.out.println(s.splitIntoFibonacci(str));

        //示例 2：
        //
        //输入: "11235813"
        //输出: [1,1,2,3,5,8,13]
        str = "11235813";
        System.out.println(s.splitIntoFibonacci(str));

        //示例 3：
        //
        //输入: "112358130"
        //输出: []
        //解释: 这项任务无法完成。
        str = "112358130";
        System.out.println(s.splitIntoFibonacci(str));

        //示例 4：
        //
        //输入："0123"
        //输出：[]
        //解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
        str = "0123";
        System.out.println(s.splitIntoFibonacci(str));

        //示例 5：
        //
        //输入: "1101111"
        //输出: [110, 1, 111]
        //解释: 输出 [11,0,11,11] 也同样被接受。。
        str = "1101111";
        System.out.println(s.splitIntoFibonacci(str));


    }
}
