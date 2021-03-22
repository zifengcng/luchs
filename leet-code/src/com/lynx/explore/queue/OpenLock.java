package com.lynx.explore.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/3 18:38
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/873/
 */
public class OpenLock {

    // 1ms
    public int openLock2(String[] deadends, String target) {
        List<String> deals = Arrays.asList(deadends);
        if (deals.contains("0000")) return -1;
        final List<String> options = new ArrayList<>();
        char[] cs;
        char c;
        int zero = '0';
        for (int i = 0; i < 4; i++) {
            cs = target.toCharArray();
            c = cs[i];
            cs[i] = (char) ((c - zero + 1) % 10 + zero);
            options.add(new String(cs));
            cs[i] = (char) ((c - zero + 9) % 10 + zero);
            options.add(new String(cs));
        }
        options.removeAll(deals);
        if (options.isEmpty()) return -1;
        int step = Integer.MAX_VALUE;
        for (String option : options) {
            int curStep = 1;
            cs = option.toCharArray();
            for (int i = 0; i < 4; i++) {
                int num = cs[i] - zero;
                if (num > 5) curStep += 10 - num;
                else curStep += num;
            }
            step = Math.min(curStep, step);
        }
        return step;
    }

    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> usedSet = new HashSet<>();

        String start = "0000";
        if (deadSet.contains(start) || deadSet.contains(target)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(target)) {
                return count;
            }
            List<String> nexts = getNext(curr);
            for (String next : nexts) {
                if (!deadSet.contains(next) && !usedSet.contains(next)) {
                    usedSet.add(next);
                    queue2.offer(next);
                }
            }
            if (queue.isEmpty()) {
                count++;
                queue = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    private List<String> getNext(String curr) {
        List<String> res = new ArrayList<>(10);
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder(curr);
            char c = curr.charAt(i);
            sb.setCharAt(i, c == '0' ? '9' : (char) (c - 1));
            res.add(sb.toString());

            sb = new StringBuilder(curr);
            sb.setCharAt(i, c == '9' ? '0' : (char) (c + 1));
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        //"0201","0101","0102","1212","2002"], target = "0202"
        int next = openLock.openLock2(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(next);
    }
}
