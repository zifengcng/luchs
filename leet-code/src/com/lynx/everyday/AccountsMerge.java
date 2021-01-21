package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/1/18
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * https://leetcode-cn.com/problems/accounts-merge/
 */
@MidCode
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 并查集
        int n = 0;
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                emailToIndex.put(account.get(i), n++);
                emailToName.put(account.get(i), name);
            }
        }

        // 合并
        UnionFind unionFind = new UnionFind(n);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            Integer firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                Integer nextIndex = emailToIndex.get(account.get(i));
                unionFind.union(firstIndex, nextIndex);
            }
        }

        // 查询
        Map<Integer, List<String>> indexToEmail = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = unionFind.find(emailToIndex.get(email));
            List<String> emails = indexToEmail.getOrDefault(index, new ArrayList<>());
            emails.add(email);
            indexToEmail.put(index, emails);
        }

        // 结果
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            String name = emailToName.get(emails.get(0));
            Collections.sort(emails);

            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            res.add(list);
        }

        return res;
    }

    public class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            parent[find(y)] = find(x);
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
