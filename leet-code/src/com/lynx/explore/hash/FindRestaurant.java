package com.lynx.explore.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/20 10:45
 * 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 */
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            restaurantMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (restaurantMap.containsKey(list2[i])) {
                if (min > i + restaurantMap.get(list2[i])) {
                    min = i + restaurantMap.get(list2[i]);
                    res = new ArrayList<>();
                    res.add(list2[i]);
                } else if (min == i + restaurantMap.get(list2[i])) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] restaurant = findRestaurant.findRestaurant(list1, list2);
        System.out.println(restaurant);
    }
}
