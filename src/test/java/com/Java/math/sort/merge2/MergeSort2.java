/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MergeSort2
 * Author:   feiyi
 * Date:     2019/12/11 3:45 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.sort.merge2;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * 〈https://zhuanlan.zhihu.com/p/36075856〉
 *
 * @author feiyi
 * @create 2019/12/11
 * @since 1.0.0
 */
public class MergeSort2 {

    public static void main(String[] args) {
        mergeArray1(new int[]{5,4,7,8,9,1,3,4,6,2}, 0, 0, 1);
    }

    /**
     * @Description 同mergeArray1
     * @param array
     * @param first
     * @param mid
     * @param last
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/12/11 4:34 PM
     **/
    public static void mergeArray2(int[] array, int first, int mid, int last){
        int[] temp = new int[last - first + 1];

    }

    /**
     * @Description 合并两个排好序的数组 first -> mid 是第一个， mid + 1 -> last是第二个
     * @param array 原数组
     * @param first
     * @param mid
     * @param last
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/12/11 3:51 PM
     **/
    public static void mergeArray1(int[] array, int first, int mid, int last) {
        int originFirst = first;
        int[] res = new int[last - first + 1];
        int second = mid + 1;
        for (int i = 0; i < res.length; i ++) {
            if (first > mid) {
                //此时把second -> last放到res中
                res[i] = array[second++];
                continue;
            } else if (second > last) {
                //此时把fist -> mid 放到res中
                res[i] = array[first++];
                continue;
            }
            int left = array[first];
            int right = array[second];
            if (left < right) {
                res[i] = left;
                first++;
            } else {
                res[i] = right;
                second++;
            }
        }
        System.out.println(JSONObject.toJSONString(res));
        //将排好序的res放回到origin array中
        for (int i = 0; i < res.length; i++, originFirst++) {
            array[originFirst] = res[i];
        }
        System.out.println(JSONObject.toJSONString(array));
    }


}
