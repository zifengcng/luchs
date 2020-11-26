package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/9/1
 * 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * Java
 * <p>
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdoube/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountSmaller {

    private int[] c;
    private int[] a;


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        discretization(nums);
        init(len + 1);

        for (int i = len - 1; i >= 0; i--) {
            int id = getId(nums[i]);
            res.add(query(id - 1));
            update(id);
        }

        Collections.reverse(res);
        return res;
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos]++;
            pos += lowBit(pos);
        }
    }

    private Integer query(int pos) {
        int res = 0;
        while (pos > 0) {
            res += c[pos];
            pos -= lowBit(pos);
        }
        return res;
    }

    private int lowBit(int pos) {
        return pos & (-pos);
    }

    private int getId(int num) {
        return Arrays.binarySearch(a, num) + 1;
    }

    private void init(int len) {
        c = new int[len];
        Arrays.fill(c, 0);
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        a = new int[nums.length];
        int index = 0;
        for (Integer num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }


    public static void main(String[] args) {
        CountSmaller c = new CountSmaller();
        List<Integer> list = c.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(list.toString());
    }
}
