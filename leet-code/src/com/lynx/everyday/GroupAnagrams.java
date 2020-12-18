package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/12/14
 * 49. 字母异位词分组
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
 * https://leetcode-cn.com/problems/group-anagrams/
 */
@MidCode
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list;
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        //示例:
        //
        //输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出:
        //[
        //  ["ate","eat","tea"],
        //  ["nat","tan"],
        //  ["bat"]
        //]
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = g.groupAnagrams(strs);
        System.out.println(res);
    }
}
