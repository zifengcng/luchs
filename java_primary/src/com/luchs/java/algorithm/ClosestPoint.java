package com.luchs.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/10/28
 * <p>
 * 平面上的最近点对
 * <p>
 * 输入： n个点的点集P,X是横坐标的排序数组， Y是纵坐标的
 * 排序数组
 * 输出：最近的两个点及距离。
 */
public class ClosestPoint {

    public double minDist(Point[] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x < o2.x) {
                return -1;
            } else if (o1.y > o2.y) {
                return 1;
            } else if (o1.y < o2.y) {
                return -1;
            }
            return 0;
        });
        return minDist(points, 0, points.length - 1);
    }

    private double minDist(Point[] points, int l, int r) {
        if (l == r) {
            return Integer.MAX_VALUE;
        }

        if (r - l == 1) {
            return distance(points[l], points[r]);
        }

        int mid = (l + r) >> 1;
        double left = minDist(points, l, mid);
        double right = minDist(points, mid + 1, r);
        double minDistance = min(left, right);

        List<Point> nearest = new ArrayList<>();
        for (Point point : points) {
            if (abs(point.x - points[mid].x) <= minDistance) {
                nearest.add(point);
            }
        }

        nearest.sort((o1, o2) -> {
            if (o1.y > o2.y) {
                return 1;
            } else if (o1.y < o2.y) {
                return -1;
            } else if (o1.x > o2.x) {
                return 1;
            } else if (o1.x < o2.x) {
                return -1;
            }
            return 0;
        });

        int size = nearest.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nearest.get(j).y - nearest.get(i).y >= minDistance) {
                    break;
                }
                double d = distance(nearest.get(j), nearest.get(i));
                if (d < minDistance) {
                    minDistance = d;
                }
            }
        }

        return minDistance;
    }

    private double distance(Point p1, Point p2) {
        if (p1 == p2) {
            return 0;
        }
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private double abs(int num) {
        return Math.abs(num);
    }

    private double min(double left, double right) {
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        ClosestPoint c = new ClosestPoint();

        Point p1 = new Point(1, 3);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(5, 2);
        Point p4 = new Point(7, 0);
        Point[] points = new Point[]{p1,p2,p3,p4};

        double d = c.minDist(points);
        System.out.println(d);
    }


    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
