import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/4/2
 * 字符串统计
 * 统计数组arr中的字符串=target的个数
 * 字符串=target：含有的字符相同
 */
public class CountWords {

    public static void main(String[] args) {
        CountWords c = new CountWords();
        // 3
        System.out.println(c.search("abc", new String[]{"abc", "adc", "bac", "bbc", "cba", "acc"}));
        // 2
        // dead
        System.out.println(c.search("abcaaaaaaaaaaabbbbbbbbbbbbbbbbbb", new String[]{"bcaa", "aadc", "abac", "bbc", "abc", "acc"}));
    }

//    // arr构造字典树
//    public int search2(String target, String[] arr) {
//        int len = target.length();
//        Trie root = buildTrie2(arr, len);
//
//
//
//    }




    // 方式一：target构建全排类，len太大时不可用
    public int search(String target, String[] arr) {
        Trie root = buildTrie(target);
        int res = 0;
        int len = target.length();
        for (String s : arr) {
            if (s.length() == len) {
                if (dfs(s, root)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean dfs(String s, Trie root) {
        int length = s.length();
        char[] chars = s.toCharArray();
        Trie t = root;
        for (int i = 0; i < length; i++) {
            if (t.containsKey(chars[i])) {
                t = t.get(chars[i]);
            } else {
                return false;
            }
        }
        return t.isLeaf;
    }

    private Trie buildTrie(String target) {
        int len = target.length();
        char[] chars = target.toCharArray();
        Trie root = new Trie();
        buildTrie(chars, 0, len, root);
        return root;
    }

    private void buildTrie(char[] chars, int i, int len, Trie root) {
        if (i == len) {
            Trie t = root;
            for (int j = 0; j < len; j++) {
                if (t.containsKey(chars[j])) {
                    t = t.get(chars[j]);
                } else {
                    t = t.put(chars[j]);
                    if (j == len - 1) {
                        t.setIsLeaf();
                    }
                }
            }
        } else {
            for (int j = i; j < len; j++) {
                swap(chars, i, j);
                buildTrie(chars, i + 1, len, root);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public class Trie {
        Map<Character, Trie> map;
        boolean isLeaf;
        Character val;

        public Trie() {
            this.val = null;
            this.isLeaf = false;
            map = new HashMap<>();
        }

        public Trie(char val) {
            this.val = val;
            this.isLeaf = false;
            map = new HashMap<>();
        }

        public boolean containsKey(char c) {
            return map.containsKey(c);
        }

        public Trie get(char c) {
            return map.get(c);
        }

        public Trie put(char c) {
            Trie node = new Trie(c);
            map.put(c, node);
            return node;
        }

        public void setIsLeaf() {
            this.isLeaf = true;
        }
    }
}
