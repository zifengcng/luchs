package com.luchs.sort;

/**
 * @author luchs
 * @date 2019/7/18 17:24
 * 归并排序
 * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 * 1. 归并方法
 * 归并方法将数组中两个已经排序的部分归并成一个。
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h){

        int i = l;
        int j = m+1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if(i > m){
                nums[k] = aux[j++];
            } else if (j > h){
                nums[k] = aux[i++];
            } else if(less(aux[i],aux[j])) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
