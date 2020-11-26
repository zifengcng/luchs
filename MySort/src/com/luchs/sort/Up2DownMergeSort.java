package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:32
 * 2. 自顶向下归并排序
 * 将一个大数组分成两个小数组去求解。
 *
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length-1);
    }

    private void sort(T[] nums, int l, int h) {
        if(h <= l){
            return;
        }

        int mid = l + (h - l) / 2;
        sort(nums,l,mid);
        sort(nums,mid+1,h);
        merge(nums,l,mid,h);
    }

    public static void main(String[] args) {
        Up2DownMergeSort<Integer> bean = new Up2DownMergeSort<>();
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
