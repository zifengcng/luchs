package com.lynx.explore.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/8/6
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rob {

    private Map<Integer, Integer> map;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        map = new HashMap<>();
        return getRob(nums, 0);
    }

    private int getRob(int[] nums, int l) {
        if (l >= nums.length) {
            return 0;
        }
        if (map.containsKey(l)) {
            return map.get(l);
        }
        int res = Integer.max(getRob(nums, l + 1), nums[l] + getRob(nums, l + 2));
        map.put(l, res);
        return res;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob.rob(nums));
    }
}
