package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:13
 * 冒泡排序
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        Bubble<Integer> bean = new Bubble<>();
        Integer[] nums = new Integer[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = new Integer((int)(1+Math.random()*(100-1+1)));
        }

        bean.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }

    }

    @Override
    public void sort(T[] nums) {
//        int N = nums.length;
//        boolean isSorted = false;
//        for (int i = N-1; i > 0 && !isSorted ; i--) {
//            isSorted = true;
//            for (int j = 0; j < i; j++) {
//                if(less(nums[j+1],nums[j])){
//                    swap(nums,j,j+1);
//                    isSorted = false;
//                }
//            }
//        }
        int N = nums.length;
        boolean isSorted = false;
        for (int i = 0; i < N - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < N - 1 - i ; j++) {
                if(less(nums[j+1],nums[j])){
                    swap(nums,j,j+1);
                    isSorted = false;
                }
            }
        }
    }
}
