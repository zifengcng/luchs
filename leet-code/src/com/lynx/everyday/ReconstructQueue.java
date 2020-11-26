package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/16
 */
@MidCode
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len == 0) {
            return people;
        }
        //[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
        //
        //排序：[7,0], [7,1],[6,1],[5,0], [5,2],[4,4],
        Arrays.sort(people, (a1, a2) -> {
            if (a1[0] - a2[0] < 0) {
                return 1;
            } else if (a1[0] - a2[0] > 0) {
                return -1;
            } else {
                return a1[1] - a2[1];
            }
        });
        // 方法一:移动数组
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            if (people[i][0] < people[j][0]) {
                continue;
            }
            int count = people[j][1];
            while (j - 1 >= 0 && j != count) {
                swap(people, j - 1, j);
                j--;
            }
        }
        // 方法二：使用list.add(index, val)

        return people;
    }

    private void swap(int[][] people, int i, int j) {
        int[] t = people[i];
        people[i] = people[j];
        people[j] = t;
    }

    public static void main(String[] args) {
        ReconstructQueue r = new ReconstructQueue();
        //{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        //
        //[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        int[][] peoples = r.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int i = 0; i < peoples.length; i++) {
            System.out.print("[" + peoples[i][0] + ", " + peoples[i][1] + "], ");
        }
    }
}
