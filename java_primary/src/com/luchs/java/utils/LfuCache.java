package com.luchs.java.utils;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU缓存
 * 最近最少被使用的被淘汰
 *
 * @author wbc
 * @date 2025/10/17 09:44
 */
public class LfuCache {

    int capacity;

    Map<String, String> keyToValue;

    Map<String, Integer> keyToFreq;

    Map<Integer, LinkedHashSet<String>> freqToKeys;

    int minFreq;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
    }

    /**
     * 获取key对应的值，并将当前key的使用次数+1
     */
    public String get(String key) {
        String value = keyToValue.get(key);
        if (!StringUtils.isEmpty(value)) {
            addFreq(key);
        }
        return value;
    }

    /**
     * 添加kv，并将当前key的使用次数+1
     */
    public void put(String key, String value) {
        keyToValue.put(key, value);
        addFreq(key);
        // TODO 删除
    }

    /**
     * 将当前key的使用次数+1
     */
    private void addFreq(String key) {
        // 次数+1
        Integer originFreq = keyToFreq.getOrDefault(key, 0);
        keyToFreq.put(key, originFreq + 1);

        // 更新次数对应的key
        updateFeqToKeys(key, originFreq);
    }

    /**
     * 更新次数对应的key
     */
    private void updateFeqToKeys(String key, int originFreq) {
        LinkedHashSet<String> s1 = freqToKeys.get(originFreq);
        if (!s1.isEmpty()) {
            s1.remove(key);
            if (s1.isEmpty()) {
                freqToKeys.remove(originFreq);
                // 更新最小值
                if (freqToKeys.isEmpty()) {
                    minFreq = 0;
                } else {
                    minFreq++;
                }
            }
        }

        LinkedHashSet<String> cur = freqToKeys.computeIfAbsent(originFreq + 1, k -> new LinkedHashSet<>());
        cur.add(key);
        if (minFreq == 0) {
            minFreq = originFreq + 1;
        }
    }


    // 参考 ——————

//    public class LfuCache {
//
//        private final int capacity;
//        private final Map<String, String> keyToValue;
//        private final Map<String, Integer> keyToFreq;
//        private final Map<Integer, LinkedHashSet<String>> freqToKeys;
//        private int minFreq;
//
//        public LfuCache(int capacity) {
//            this.capacity = capacity;
//            this.keyToValue = new HashMap<>();
//            this.keyToFreq = new HashMap<>();
//            this.freqToKeys = new HashMap<>();
//            this.minFreq = 0;
//        }
//
//        public String get(String key) {
//            if (!keyToValue.containsKey(key)) {
//                return null;
//            }
//            increaseFreq(key);
//            return keyToValue.get(key);
//        }
//
//        public void put(String key, String value) {
//            if (capacity <= 0) return;
//
//            if (keyToValue.containsKey(key)) {
//                keyToValue.put(key, value);
//                increaseFreq(key);
//                return;
//            }
//
//            if (keyToValue.size() >= capacity) {
//                removeMinFreqKey();
//            }
//
//            keyToValue.put(key, value);
//            keyToFreq.put(key, 1);
//            freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
//            minFreq = 1;
//        }
//
//        private void increaseFreq(String key) {
//            int freq = keyToFreq.get(key);
//            keyToFreq.put(key, freq + 1);
//
//            // 从原频率集合中移除
//            freqToKeys.get(freq).remove(key);
//            if (freqToKeys.get(freq).isEmpty()) {
//                freqToKeys.remove(freq);
//                if (freq == minFreq) {
//                    minFreq++;
//                }
//            }
//
//            // 添加到新频率集合
//            freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
//        }
//
//        private void removeMinFreqKey() {
//            LinkedHashSet<String> keyList = freqToKeys.get(minFreq);
//            String deletedKey = keyList.iterator().next();
//            keyList.remove(deletedKey);
//            if (keyList.isEmpty()) {
//                freqToKeys.remove(minFreq);
//            }
//            keyToValue.remove(deletedKey);
//            keyToFreq.remove(deletedKey);
//        }
//    }
    // —————— 参考

}
