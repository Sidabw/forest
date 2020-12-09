/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BinarySearch
 * Author:   feiyi
 * Date:     2020/7/4 6:55 PM
 * Description: 二分查找【极客时间】
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang;

/**
 * 〈一句话功能简述〉:
 * 〈二分查找【极客时间】〉
 *
 * @author feiyi
 * @create 2020/7/4
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] origin = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 12, 15, 18, 29, 36, 58};
        System.out.println(binarySearch1(origin, 29));

        int[] origin2 = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(binarySearch1(origin2, 8));//结果是错误的
        System.out.println(binarySearch2(origin2, 8));//结果是对的。

        System.out.println(binarySearch3(origin2, 7));
    }

    //基础的二分查找
    public static int binarySearch1(int[] origin, int target) {
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] == target) return mid;
            else if (origin[mid] < target) low = mid + 1;
            else if (origin[mid] > target) high = mid - 1;
        }
        return -1;
    }
    //查找第一个值等于给定值的元素(数组内容有重复)
    public static int binarySearch2(int[] origin, int target){
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] < target) low = mid + 1;
            else if (origin[mid] > target) high = mid - 1;
            else {
                if ((mid == 0) || origin[mid - 1] != target)
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素（数组内容有重复）
    public static int binarySearch3(int[] origin, int target) {
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] >= target) {
                if ((mid == 0)||(origin[mid - 1] < target)) return mid;
                else high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
