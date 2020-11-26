package com.luchs.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luchs
 * @date 2019/7/18 17:39
 * 快速排序
 * 1. 基本算法
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    protected void sort(T[] nums, int l, int h) {
        if(h <= l){
            return;
        }

        int j = partition(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    /**
     * 2. 切分
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于它的元素，
     * 交换这两个元素。不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
     * 当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     */
    private int partition(T[] nums, int l, int h) {
        int i = l;
        int j = h+1;
        T v = nums[l];

        while (true) {
            while (less(nums[++i],v) && i!=h);
            while (less(v,nums[--j])&& j!=l);
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     *  5. 基于切分的快速选择算法
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，
     * 此时 a[j] 就是数组的第 j 大元素。
     *
     * 可以利用这个特性找出数组的第 k 个元素。
     *
     * 该算法是线性级别的，假设每次能将数组二分，那么比较的总次数为 (N+N/2+N/4+..)，直到找到第 k 个元素，这个和显然小于 2N。
     */
    public T select(T[] nums, int k) {
        int l = 0;
        int h = nums.length-1;
        while (h > l) {
            int j = partition(nums,l,h);
            if(j == k){
                return nums[k];
            } else if (j > k) {
                h = j-1;
            } else {
                l = j+1;
            }
        }
        return nums[k];
    }

    public static void main(String[] args) {
        QuickSort<Integer> bean = new QuickSort<>();
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
