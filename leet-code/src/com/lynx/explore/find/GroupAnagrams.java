package com.lynx.explore.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/14 10:54
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/239/learn-to-use-keys/999/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = maps.get(key);
            if (list != null) {
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
                maps.put(key, list);
            }
        }

        return new ArrayList<>(maps.values());
    }
}
