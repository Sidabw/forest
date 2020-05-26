/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode27
 * Author:   feiyi
 * Date:     2020/5/25 9:16 AM
 * Description: 移除元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈移除元素〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode27 {

    /**
     * @Description给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     *
     * 注意这五个元素可为任意顺序。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/19 2:13 PM
     **/
    @Test
    public void test9 (){
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int val = 2;
//        int[] nums = new int[]{3,2,2,3};
//        int val = 3;
        int[] nums = new int[]{3, 3,3,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int numsLen = nums.length;
        int index = 0;
        for (int i = 0; i < numsLen; i++){
            int cur = nums[i];
            if (cur != val) {
                nums[index] = cur;
                index++;
            }
        }
        for (int i = 0; i < index; i++){
            System.out.println(nums[i]);
        }
        return index;
    }

}
