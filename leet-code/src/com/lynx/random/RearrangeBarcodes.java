package com.lynx.random;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/10/16
 * <p>
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * <p>
 * https://leetcode-cn.com/problems/distant-barcodes/
 */
public class RearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        int len = barcodes.length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        int index = 0;
        int count = 1;
        while (index + 1 < len) {
            if (barcodes[index + 1] != barcodes[index]) {
                list.add(new Pair<>(barcodes[index], count));
                count = 1;
            } else {
                count++;
            }
            index++;
        }
        list.add(new Pair<>(barcodes[index], count));
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int[] res = new int[len];
        int even = 0;
        int odd = 1;

        int num = 0;
        Pair<Integer, Integer> pair = list.get(num);
        Integer key = pair.getKey();
        Integer value = pair.getValue();
        while (even < len) {
            if (value <= 0) {
                num++;
                pair = list.get(num);
                key = pair.getKey();
                value = pair.getValue();
            }
            res[even] = key;
            value--;

            even += 2;
        }

        while (odd < len) {
            if (value <= 0) {
                num++;
                pair = list.get(num);
                key = pair.getKey();
                value = pair.getValue();
            }
            res[odd] = key;
            value--;

            odd += 2;
        }

        return res;
    }

    public static void main(String[] args) {
        RearrangeBarcodes r = new RearrangeBarcodes();
        int[] ints = r.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
        System.out.println(Arrays.toString(ints));
    }
}
