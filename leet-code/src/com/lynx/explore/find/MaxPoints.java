package com.lynx.explore.find;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/14 14:07
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/239/learn-to-use-keys/1003/
 */
public class MaxPoints {

    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int length = points.length;
        // 水平直线
        Map<Integer, Integer> xMap = new HashMap<>();
        // 垂直直线
        Map<Integer, Integer> yMap = new HashMap<>();
        // 存在斜率k
        Map<Slope, Integer> kMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            xMap.put(points[i][0], xMap.getOrDefault(points[i][0], 0) + 1);
            yMap.put(points[i][1], yMap.getOrDefault(points[i][1], 0) + 1);

            int samePoints = 0;
            for (int j = i + 1; j < length; j++) {
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    // 不存在斜率k
                    samePoints++;
                    continue;
                }
                if (points[j][0] == points[i][0] || points[j][1] == points[i][1]) {
                    // 不存在斜率k
                    continue;
                }
                // k=(y2-y1)/(x2-x1)
                int k1 = points[j][1] - points[i][1];
                int k2 = points[j][0] - points[i][0];
                int k = gcd(k1, k2);
                k1 /= k;
                k2 /= k;
                // b=y-kx
                // b=(x2y1-x1y2) / (x2-x1)
                int b1 = points[j][0] * points[i][1] - points[i][0] * points[j][1];
                int b2 = points[j][0] - points[i][0];
                int b = gcd(b1, b2);
                b1 /= b;
                b2 /= b;

                Slope slope = new Slope(k1, k2, b1, b2);
                kMap.put(slope, kMap.getOrDefault(slope, 1) + 1);
            }
            int temp = res;
            for (Map.Entry<Slope, Integer> entry : kMap.entrySet()) {
                res = Integer.max(res, entry.getValue());
            }
            if (temp != res) {
                res += samePoints;
            }
            kMap.clear();
        }

        res = Integer.max(res, Collections.max(xMap.values()));
        res = Integer.max(res, Collections.max(yMap.values()));

        return res;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    class Slope {
        int k1;
        int k2;
        int b1;
        int b2;

        public Slope(int k1, int k2, int b1, int b2) {
            this.k1 = k1;
            this.k2 = k2;
            this.b1 = b1;
            this.b2 = b2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            Slope s = (Slope) obj;
            if (s.k1 == k1 && s.k2 == k2 && s.b1 == b1 && s.b2 == b2) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return k1 + k2 + b1 + b2;
        }
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
//		[[0,0],[94911151,94911150],[94911152,94911151]]
        int num = maxPoints.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        System.out.println(num);

    }


}
