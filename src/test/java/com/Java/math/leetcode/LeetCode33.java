/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode33
 * Author:   feiyi
 * Date:     2020/10/15 4:31 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import com.Java.math.jike.BinarySearch;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/15
 * @since 1.0.0
 */
public class LeetCode33 {

    /**
     * @Description 给你一个升序排列的整数数组 nums ，和一个整数 target 。
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
     *
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     *  
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target
     * = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/10/15 4:32 PM
     **/
    public static void main(String[] args) {
//        int[] origin = new int[]{4,5,6,7,0,1,2};
        int[] origin = new int[]{3,1};
//        int target = 5;
//        int target = 1;
        int target = 3;
        System.out.println(searchInRotatedSortedArray(origin, target));
    }

    private static int searchInRotatedSortedArray(int[] origin, int target){
        //把数组分成两部分，一定有一部分是有序的.
        //一直折半去找，直到找到target落到了有序数组里。这个时候就直接去折半就可以了
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[low] <= origin[mid] && (target <= origin[mid] && target >= origin[low])) {
                return binarySearchInSpecialArrArea(origin, low, mid, target);
            } else if (origin[mid] <= origin[high] && (target <= origin[high] && target >= origin[mid])) {
                return binarySearchInSpecialArrArea(origin, mid, high, target);
            } else if (origin[low] <= origin[mid]) {
                //左边有序，继续找右边
                low = mid + 1;
            } else {
                //右边有序，继续找左边
                high = mid - 1;
            }
        }
        return -1;
    }

    //在一个数组的制定区间内进行折半查找
    private static int binarySearchInSpecialArrArea(int[] origin, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] == target) return mid;
            else if (origin[mid] < target) low = mid + 1;
            else if (origin[mid] > target) high = mid - 1;
        }
        return -1;
    }


}
