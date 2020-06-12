package com.java.algorithm.sort;

/**
 * Created by zhangyuan on 2020/6/9 0009.
 */
public class Sort {

    /**
     * 冒泡排序 时间复杂度O(n^2)
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 选择排序 O(n^2)
     *
     * @param array
     */
    public static void chooseSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     *
     * 插入排序，不稳定排序;O(n)~O(n^2)，时间复杂度为O(n^2)
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }


    /**
     * 快排；O(n*lgn)
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(int []array,int left,int right){
        if(right - left <= 0){
            return;
        }
        int pl = left;
        int pr = right;
        int mid =array[left];
        boolean dir = true;
        L1:		while(pl < pr){
            //true为右
            if(dir){
                for(int i = pr; i > pl; i--){
                    if(mid >= array[i]){
                        array[pl] = array[i];
                        dir = !dir;
                        pr = i;
                        pl ++;
                        continue L1;
                    }
                }
                pr = pl;
            } else {
                for(int i = pl; i < pr; i++){
                    if(mid <= array[i]){
                        array[pr --] = array[i];
                        pl = i;
                        dir = !dir;
                        continue L1;
                    }
                }
                pl = pr;
            }
        }
        array[pl] = mid;
        quickSort(array,left,pl - 1);
        quickSort(array,pl + 1,right);
    }


    /**
     *归并排序；O(n*lgn)
     *
     * @param array
     * @param l
     * @param r
     */
    public static void mergeSort(int[] array, int l, int r) {
        if (r - l <= 0) {
            return;
        }
        int midIndex = l + ((r - l) >> 1);
        mergeSort(array, l, midIndex);
        mergeSort(array, midIndex + 1, r);
        //合并
        int[] newSort = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = midIndex + 1;
        while (p1 <= midIndex && p2 <= r) {
            newSort[i] = array[p1] > array[p2] ? array[p2++] : array[p1++];
            i++;
        }
        while (p1 <= midIndex) {
            newSort[i] = array[p1++];
            i++;
        }
        while (p2 <= r) {
            newSort[i] = array[p2++];
            i++;
        }
        int length = newSort.length;
        for (int j = 0; j < length; j++) {
            array[l + j] = newSort[j];
        }
    }


    /**
     * 堆排序  O(n*logn)
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        //big heap
        int heapSize = array.length;
        for (int i = 0; i < heapSize; i++) {
            int j = i;
            while (array[j] > array[(j - 1) / 2]) {
                int temp = array[j];
                array[j] = array[(j - 1) / 2];
                array[(j - 1) / 2] = temp;
                j = (j - 1) / 2;
            }
        }
        int temp = array[0];
        array[0] = array[heapSize - 1];
        array[heapSize - 1] = temp;
        heapSize--;
        while (heapSize > 0) {
            int j = 0;
            int left = 2 * j + 1;
            while (left < heapSize) {
                int larger = (left + 1) < heapSize && array[left] < array[left + 1] ? left + 1 : left;
                larger = array[j] > array[larger] ? j : larger;
                if (larger == j) {
                    break;
                }
                temp = array[j];
                array[j] = array[larger];
                array[larger] = temp;
                j = larger;
                left = 2 * j + 1;
            }
            temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;
            heapSize--;
        }
    }
}
