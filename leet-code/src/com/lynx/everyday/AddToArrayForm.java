package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/1/22
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
@EasyCode
public class AddToArrayForm {

    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int len = A.length;
        int t = K;
        for (int i = len - 1; i >= 0; i--) {
            int sum = A[i] + t % 10 + carry;
            t /= 10;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            }
            res.add(sum);
        }
        while (t > 0 || carry > 0) {
            int sum = t % 10 + carry;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            }
            res.add(sum);
            t /= 10;
        }

        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        List<Integer> res = new ArrayList<>();
        for (int i = len - 1; i >= 0 || K > 0; i--) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        //示例 1：
        //
        //输入：A = [1,2,0,0], K = 34
        //输出：[1,2,3,4]
        //解释：1200 + 34 = 1234
        int[] A = new int[]{1, 2, 0, 0};
        int K = 34;
        System.out.println(a.addToArrayForm(A, K));

        //示例 2：
        //
        //输入：A = [2,7,4], K = 181
        //输出：[4,5,5]
        //解释：274 + 181 = 455
        A = new int[]{2, 7, 4};
        K = 181;
        System.out.println(a.addToArrayForm(A, K));

        //示例 3：
        //
        //输入：A = [2,1,5], K = 806
        //输出：[1,0,2,1]
        //解释：215 + 806 = 1021
        A = new int[]{2, 1, 5};
        K = 806;
        System.out.println(a.addToArrayForm(A, K));

        //示例 4：
        //
        //输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
        //输出：[1,0,0,0,0,0,0,0,0,0,0]
        //解释：9999999999 + 1 = 10000000000
        A = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        K = 1;
        System.out.println(a.addToArrayForm(A, K));


    }
}
