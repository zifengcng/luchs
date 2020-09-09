package com.luchs.java.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/9/8
 */
public class TestMap {

    public static void main(String[] args) {
        // 初始因子0.75, 容量16， 界值 16 * 0.75 = 12， 2倍扩容
        // hash值：key的hashcode ^ (hashcode>>16)
        // 当前节点： tab[(n-1)&hash]
        // 存储：当前桶为null，直接保存；
        //       否则：是否链表，当前节点的hash值==key的hash值 && (cur.key == key || cur.key.equals(key))
        //             是否红黑树， instanseof TreeNode
        //             单纯被占用，存储到下一个空位上
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        System.out.println(map);


        // 初始容量10， 1.5倍扩容
        List<String> list = new ArrayList<>();
        list.add("abc");
        System.out.println(list);
    }
}
