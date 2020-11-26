package com.lynx.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/10/14
 * <p>
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int len = A.length;
        if (len == 0) {
            return res;
        }

        Map<String, Integer> firstMap = new HashMap<>();
        char[] chars = A[0].toCharArray();
        for (char c : chars) {
            String key = String.valueOf(c);
            firstMap.put(key, firstMap.getOrDefault(key, 0) + 1);
        }

        for (int i = 1; i < len; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (char c : A[i].toCharArray()) {
                String key = String.valueOf(c);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            firstMap.forEach((k, v) -> {
                int num = 0;
                if (map.containsKey(k)) {
                    num = Math.min(v, map.get(k));
                }
                firstMap.put(k, num);
            });
        }

        firstMap.forEach((k, v) -> {
            if (v > 0) {
                for (int i = 0; i < v; i++) {
                    res.add(k);
                }
            }
        });

        return res;
    }

    public static void main(String[] args) {
        CommonChars c = new CommonChars();
        List<String> list = c.commonChars(new String[]{"cool", "lock", "cook"});
        System.out.println(list);
    }
}
