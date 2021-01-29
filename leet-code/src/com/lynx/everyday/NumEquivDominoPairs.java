package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2021/1/26
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 */
@EasyCode
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] count = new int[100];
        for (int[] dominoe : dominoes) {
            int num = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            res += count[num];
            count[num]++;
        }
        return res;
    }


    public static void main(String[] args) {
        NumEquivDominoPairs n = new NumEquivDominoPairs();
        //示例：
        //
        //输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
        //输出：1
        int[][] dominoes = new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(n.numEquivDominoPairs(dominoes));
    }
}
