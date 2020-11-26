package com.lynx.random;

/**
 * @Author cheng
 * @Date 2020/10/14
 * <p>
 * LCP 14. 切分数组
 * 给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。为了减少他的工作量，请求出最少可以切成多少个子数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,3,2,3,3]
 * <p>
 * 输出：2
 * <p>
 * 解释：最优切割为 [2,3,3,2] 和 [3,3] 。第一个子数组头尾数字的最大公约数为 2 ，第二个子数组头尾数字的最大公约数为 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,5,7]
 * <p>
 * 输出：4
 * <p>
 * 解释：只有一种可行的切割：[2], [3], [5], [7]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 2 <= nums[i] <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/qie-fen-shu-zu/
 */
public class SplitArray {

    int[] minPrime = new int[1000010];
    int[] prime = new int[100010];
    int[] g = new int[1000010];

    public int splitArray(int[] nums) {
        int n = nums.length;
        int m = 2;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
        }
        for (int i = 2; i <= m; i++) {
            if (minPrime[i] == 0) {
                prime[++prime[0]] = i;
                minPrime[i] = i;
            }
            for (int j = 1; j <= prime[0]; j++) {
                if (i > m / prime[j]) break;
                minPrime[i * prime[j]] = prime[j];
                if (i % prime[j] == 0) break;
            }
        }
        for (int j = 1; j <= prime[0]; j++) {
            g[prime[j]] = n;
        }
        for (int x = nums[0]; x > 1; x /= minPrime[x]) {
            g[minPrime[x]] = 0;
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = i + 1;
            for (int x = nums[i]; x > 1; x /= minPrime[x]) {
                ans = Math.min(g[minPrime[x]] + 1, ans);
            }
            if (i == n - 1) break;
            for (int x = nums[i + 1]; x > 1; x /= minPrime[x]) {
                g[minPrime[x]] = Math.min(g[minPrime[x]], ans);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        SplitArray s = new SplitArray();
        int count = s.splitArray(new int[]{782581, 227, 113147, 13451, 288053, 684113, 413579, 917629, 454021, 827633, 673787, 514127, 432001, 507961, 790051, 164617, 139759, 315881, 160681, 235231, 106627, 135977, 483811, 570839, 758699, 549011, 389227, 21961, 524347, 24763, 882247, 932101, 717559, 124853, 967919, 968111, 966439, 967229, 967739, 968213, 967171, 966509, 967397, 967481, 968111, 967297, 968311, 967753, 966677, 968573, 966527, 966653, 967319, 967663, 967931, 968021, 967961, 968423, 966727, 967937, 967699, 966883, 968017, 968311, 967781, 966617, 967937, 967763, 967459, 966971, 968567, 968501, 966991, 966613, 968557, 966863, 966619, 966863, 966727, 967567, 967061, 966913, 966631, 968021, 968003, 968431, 968291, 969667, 970667, 971723, 969011, 972113, 972373, 969929, 971491, 970027, 973031, 982973, 980491, 985657});
        System.out.println(count);
    }
}
