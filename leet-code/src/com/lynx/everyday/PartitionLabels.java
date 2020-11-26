package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/10/22
 * <p>
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * https://leetcode-cn.com/problems/partition-labels/
 */
@MidCode
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Set<Character> visited = new HashSet<>();
        int split = 0;
        while (split < len) {
            char c = S.charAt(split);
            visited.add(c);
            int last = S.lastIndexOf(c);
            if (last - split > 1) {
                for (int i = split + 1; i < last; i++) {
                    char c1 = S.charAt(i);
                    if (visited.contains(c1)) {
                        continue;
                    }
                    visited.add(c1);

                    int last1 = S.lastIndexOf(c1);
                    if (last1 <= last) {
                        continue;
                    }
                    last = last1;
                }
            }
            res.add(last - split + 1);
            split = last + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
