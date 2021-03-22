package com.lynx.explore.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/13 16:44
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/989/
 */
public class FrequencySort {

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                count++;
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (count-- > 0) {
                sb.append(chars[i]);
            }
            list.add(sb.toString());
        }

        list.sort(Comparator.comparingInt(String::length).reversed());
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
