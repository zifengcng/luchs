package com.lynx.random;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/10/13
 */
public class RestoreString {

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < len; i++) {
            int next = indices[i];
            while (next != i && !visited.contains(i)) {
                visited.add(next);
                swap(chars, i, next);

                next = indices[next];
            }

            visited.add(i);
        }

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        RestoreString res = new RestoreString();
        String s = res.restoreString("aiohn", new int[]{3, 1, 4, 2, 0});
        System.out.println(s);
    }
}
