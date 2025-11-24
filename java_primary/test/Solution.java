import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wbc
 * @date 2025/10/24 11:55
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextBeautifulNumber(1));
        System.out.println(solution.nextBeautifulNumber(10));
        System.out.println(solution.nextBeautifulNumber(1000));
        System.out.println(solution.nextBeautifulNumber(23330));
    }

    public int nextBeautifulNumber(int n) {
        Integer[] nums = buildAllBeautifulNumber(7);
        Arrays.sort(nums);
        // 二分查找
        return findNum(nums, n);
    }

    public Integer[] buildAllBeautifulNumber(int len) {
        List<Integer> nums = new ArrayList<>();
        int curLen = 0;
        int l = 1;
        Set<Integer> res = dfs(nums, curLen, l, len);
        return res.toArray(new Integer[0]);
    }

    public Set<Integer> dfs(List<Integer> nums, int curLen, int l, int len) {
        Set<Integer> res = new HashSet<>();
        if (curLen > len) {
            return res;
        }
        if (curLen > 0) {
            res.addAll(perm(nums));
        }

        for(int i = l; i <= len; i++) {
            nums.add(i);
            curLen += i;

            Set<Integer> set = dfs(nums, curLen, i + 1, len);
            if (!set.isEmpty()) {
                res.addAll(set);
            }
            nums.remove(new Integer(i));
            curLen -= i;
        }
        return res;
    }

    public Set<Integer> perm(List<Integer> nums) {
        List<Integer> newNums = new ArrayList<>();
        nums.forEach(num -> {
            int i = 0;
            while (i < num) {
                newNums.add(num);
                i++;
            }
        });

        List<Integer> target = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        dfsPerm(newNums, target, visited, res);
        return res;
    }

    public void dfsPerm(List<Integer> nums, List<Integer> target, Set<Integer> visited, Set<Integer> res) {
        if (target.size() == nums.size()) {
            StringBuilder sb = new StringBuilder();
            target.forEach(sb::append);
            res.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }

            Integer num = nums.get(i);
            target.add(num);
            visited.add(i);

            dfsPerm(nums, target, visited, res);
            target.remove(target.size() - 1);
            visited.remove(i);
        }
    }

    public int findNum(Integer[] nums, int value) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > value) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
