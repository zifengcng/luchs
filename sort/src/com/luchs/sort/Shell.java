package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:20
 * 希尔排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }

        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h ; j -= h) {
                    if(less(nums[j],nums[j-h])){
                        swap(nums,j,j-h);
                    }
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Shell<Integer> bean = new Shell<>();
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
