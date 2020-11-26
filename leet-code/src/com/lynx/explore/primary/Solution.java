package com.lynx.explore.primary;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author cheng
 * @Date 2020/8/6
 */
public class Solution {

    private int[] arr;
    private int[] origin;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.arr = nums;
        this.origin = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        arr = origin;
        origin = origin.clone();
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(arr.length - i) + i);
        }
        return arr;
    }

    private void swap(int[] res, int i, int j) {
        int t = res[i];
        res[i] = res[j];
        res[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
