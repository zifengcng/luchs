package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/12/16
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * https://leetcode-cn.com/problems/word-pattern/
 */
@EasyCode
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] sArr = s.split(" ");
        int len = chars.length;
        if (sArr.length != len) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                String s1 = map.get(chars[i]);
                if (!s1.equals(sArr[i])) {
                    return false;
                }
            } else {
                if (visited.contains(sArr[i])) {
                    return false;
                }
                map.put(chars[i], sArr[i]);
                visited.add(sArr[i]);
            }
        }
        return true;
    }
}
