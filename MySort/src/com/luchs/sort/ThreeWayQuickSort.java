package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:47
 * 4. 算法改进
 * 4.1 切换到插入排序
 * 因为快速排序在小数组中也会递归调用自己，对于小数组，插入排序比快速排序的性能更好，因此在小数组中可以切换到插入排序。
 *
 * 4.2 三数取中
 * 最好的情况下是每次都能取数组的中位数作为切分元素，但是计算中位数的代价很高。一种折中方法是取 3 个元素，并将大小居中的元素作为切分元素。
 *
 * 4.3 三向切分
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 *
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    protected void sort(T[] nums, int l, int h) {
        if(h <= l){
            return;
        }

        int lt = l;
        int i = l+1;
        int gt = h;
        T v = nums[l];

        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if(cmp < 0) {
                swap(nums,lt++,i++);
            } else if(cmp > 0) {
              swap(nums,i,gt--);
            } else {
                i++;
            }
        }

        sort(nums,l,lt-1);
        sort(nums,gt+1,h);

    }

    public static void main(String[] args) {
        ThreeWayQuickSort<Integer> bean = new ThreeWayQuickSort<>();
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
