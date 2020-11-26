package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:35
 * 3. 自底向上归并排序
 * 先归并那些微型数组，然后成对归并得到的微型数组。
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[])new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz+sz) {
                merge(nums,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    public static void main(String[] args) {
        Down2UpMergeSort<Integer> bean = new Down2UpMergeSort<>();
        Integer[] nums = new Integer[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = new Integer((int)(1+Math.random()*(100-1+1)));
        }

        bean.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }

    }
}
