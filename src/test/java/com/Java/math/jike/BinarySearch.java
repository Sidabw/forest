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
package com.Java.math.jike;

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
        int index = binarySearchTest(origin, 29);
        System.out.println(index);
    }

    private static int binarySearchTest(int[] origin, int target) {
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

}
