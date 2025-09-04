package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
@EasyCode
public class CanPlaceFlowers {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cur = 0;
        while (cur < len && n > 0) {
            if (flowerbed[cur] == 0 && (cur == 0 || flowerbed[cur - 1] == 0)
                    && (cur == len - 1 || flowerbed[cur + 1] == 0)) {
                n--;
                cur++;
            }
            cur++;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        //示例 1:
        //
        //输入: flowerbed = [1,0,0,0,1], n = 1
        //输出: True
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(c.canPlaceFlowers(flowerbed, n));

        //示例 2:
        //
        //输入: flowerbed = [1,0,0,0,1], n = 2
        //输出: False
        flowerbed = new int[]{1, 0, 0, 0, 1};
        n = 2;
        System.out.println(c.canPlaceFlowers(flowerbed, n));

        //示例 3:
        //
        //输入: flowerbed = [1,0,0,0,0,1], n = 2
        //输出: False
        flowerbed = new int[]{1, 0, 0, 0, 0, 1};
        n = 2;
        System.out.println(c.canPlaceFlowers(flowerbed, n));


    }
}
