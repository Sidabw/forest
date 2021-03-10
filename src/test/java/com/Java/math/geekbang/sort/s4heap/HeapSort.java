/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: HeapSort
 * Author:   feiyi
 * Date:     2021/3/7 5:33 PM
 * Description: 堆排
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang.sort.s4heap;

/**
 * 〈一句话功能简述〉:
 * 〈堆排〉
 *
 * @author feiyi
 * @create 2021/3/7
 * @since 1.0.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 4, 2, 9, 3, 5, 1, 0, 7};
        sort(arr, 8);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    //n表示数据的个数，数组a中的数据从下标1到n的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }
    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
    public static void swap(int[] arr,int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
