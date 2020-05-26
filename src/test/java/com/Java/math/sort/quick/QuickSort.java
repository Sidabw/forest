/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: QuickSort
 * Author:   feiyi
 * Date:     2019/12/16 7:39 PM
 * Description: 快速排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.sort.quick;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈快排，快速排序
 * 参考：https://blog.csdn.net/shujuelin/article/details/82423852〉
 *
 * @author feiyi
 * @create 2019/12/16
 * @since 1.0.0
 */
public class QuickSort {

    @Test
    public void test (){
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(JSONObject.toJSONString(arr));

    }

    public static void quickSort(int[] arr, int low, int high){
        double a = getA(0, 0, 1);
        //temp就是基准位
        int i = low,j = high;
        if(low>high) return;
        int temp = arr[low];
        //这个while代表每一次i j的值交换
        while (i<j) {
            //先看右边，依次往左递减，找小于基准值的
            while (temp<=arr[j]&&i<j) {j--;}
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {i++;}
            //如果满足条件则交换
            if (i<j) swap(i, j, arr);
        }
        //最后将基准值与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    private static void swap(int i, int j, int[] arr) {
        int t;
        t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static <T> T getA (T... ts) {
        return ts[0];
    }


    //原文代码
    public static void quickSort2(int[] arr, int low, int high) {
        int i,j,temp,t;
        if(low>high) return;
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) j--;
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) i++;
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort2(arr, low, j-1);
        //递归调用右半数组
        quickSort2(arr, j+1, high);
    }



}
