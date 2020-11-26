package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/11/11
 * 514. 自由之路
 * 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 示例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * 提示：
 * <p>
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出。
 * https://leetcode-cn.com/problems/freedom-trail/
 */
@HardCode
public class FindRotateSteps {

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 27 ms
     * , 在所有 Java 提交中击败了
     * 17.12%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 78.10%
     * 的用户
     */
    public int findRotateSteps(String ring, String key) {
        char[] ringArr = ring.toCharArray();
        char[] keyArr = key.toCharArray();
        int ringLen = ringArr.length;
        int keyLen = keyArr.length;

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyLen; i++) {
            List<Integer> list = map.getOrDefault(keyArr[i], new ArrayList<>());
            list.add(i);
            map.put(keyArr[i], list);
        }

        // 记录ki在r中对应的下标
        Map<Integer, List<Integer>> keyMap = new HashMap<>();
        for (int i = 0; i < ringLen; i++) {
            if (map.containsKey(ringArr[i])) {
                for (Integer index : map.get(ringArr[i])) {
                    List<Integer> list = keyMap.getOrDefault(index, new ArrayList<>());
                    list.add(i);
                    keyMap.put(index, list);
                }
            }
        }


        // 最短距离
        Map<Integer, Integer> min = new HashMap<>();
        List<Integer> last = keyMap.get(keyLen - 1);
        for (Integer index : last) {
            min.put(index, 1);
        }
        for (int i = keyLen - 2; i >= 0; i--) {
            Map<Integer, Integer> prev = new HashMap<>();
            List<Integer> indexes = keyMap.get(i);
            for (Integer index : indexes) {
                int dist = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> entry : min.entrySet()) {
                    Integer k = entry.getKey();
                    Integer v = entry.getValue();
                    int minDist = getMinDist(index, k, ringLen) + v + 1;
                    if (minDist < dist) {
                        dist = minDist;
                        prev.put(index, minDist);
                    }

                }
            }
            min = prev;
        }

        int minSteps = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : min.entrySet()) {
            Integer index = entry.getKey();
            Integer dist = entry.getValue();
            minSteps = Math.min(minSteps, getMinDist(0, index, ringLen) + dist);
        }

        return minSteps;
    }

    private Integer getMinDist(Integer i, Integer j, int len) {
        if (i.equals(j)) {
            return 0;
        } else if (i < j) {
            return Math.min(j - i, i + len - j);
        } else {
            return getMinDist(j, i, len);
        }
    }

    public static void main(String[] args) {
        FindRotateSteps f = new FindRotateSteps();
        //ring = "godding", key = "gd"       4
        System.out.println(f.findRotateSteps("godding", "gd"));
        //ring = "godding", key = "gi"       5
        System.out.println(f.findRotateSteps("godding", "gi"));
        //ring = "godding", key = "ddi"       7
        System.out.println(f.findRotateSteps("godding", "ddi"));
        // "bicligfijg"
        //"cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl"
        System.out.println(f.findRotateSteps("bicligfijg", "cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl"));
    }
}
