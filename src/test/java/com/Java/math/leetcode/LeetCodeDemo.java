/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: LeetCodeDemo
 * Author:   feiyi
 * Date:     2019/6/12 7:56 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.leetcode;

import org.junit.Test;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/12
 * @since 1.0.0
 */
public class LeetCodeDemo {

    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     *示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @Description
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/6/12 7:56 PM
     **/
    @Test
    public void test(){
        System.out.println(m());
    }
    public static int m (){
//        String str = "abcabcbb";//3
//        String str = "bbbbb";
//        String str = "pwwkew";
//        String str = "zcxabcdebce"; //1b: 4 2b:8,子串：1b:4
        String str = "nfpdmpi";
        if (str == null || "".equals(str)) return 0;
        char[] chars = str.toCharArray();
        char[] chars1 = new char[]{chars[0]};
        int max = 1;
        for (int i = 1 ; i < chars.length ; i ++) {
            char cur = chars[i];
            boolean flag = false;
            int indexRepeated = 0;
            for (int j = 0; j < chars1.length; j++){
                if (chars1[j] == cur) {
                    flag = true;
                    indexRepeated = j;
                }
            }

            if (!flag) {
                //不重复，就继续往下加
                char[] chars2 = new char[chars1.length + 1];
                for (int j = 0 ; j < chars2.length -1 ; j ++){
                    chars2[j] = chars1[j];
                }
                chars2[chars2.length - 1] = cur;
                chars1 = chars2;
                max = max < chars2.length ? chars2.length : max;
                continue;
            } else {
                //重复了,重新生成chars1,attention：chars1不一定就是最长子串！
                int index2 = i - chars1.length + indexRepeated;
                char[] chars2 = new char[i - index2];
                for (int j = 0 ;j < chars2.length ; j ++){
                    chars2[j] = chars[index2 + j + 1];
                }
                chars1 = chars2;
                max = max < chars1.length ? chars1.length : max;
            }

        }
        return max;
    }


    /**
     * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/1 7:40 PM
     **/
    @Test
    public void test2(){
//        System.out.println(n(-230));
//        System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println("2143847412".compareTo(Long.valueOf(Integer.MAX_VALUE + 1).toString()));
        System.out.println("2143847412".compareTo("2147483647"));
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Long.valueOf(Integer.MAX_VALUE + 1));
    }


    public static int n(int in) {
        String strIn = new Integer(in).toString();
        int startIndex = 0 ;
        if (strIn.substring(0,1).equals("-")) {
            strIn = strIn.substring(1);
            startIndex = 1;
        }
        String reversedStrIn = new StringBuffer(strIn).reverse().toString();
        char[] chars = reversedStrIn.toCharArray();
        int charLength = chars.length;
        String subStr = reversedStrIn;
        for (int i = 0; i < charLength; i ++) {
            char charIn = chars[i];
            if (charIn == '0') {
                if (i == charLength - 1) break;
                subStr = reversedStrIn.substring(i + 1);
            } else {
                break;
            }
        }
        if (startIndex == 0) {
            //正数
            if (subStr.length() < 10 )  return Integer.valueOf(subStr).intValue();
            int i = subStr.compareTo("2147483647");
            if (i > 0) return 0;
            return Integer.valueOf(subStr).intValue();
        } else {
            //负数
            if (subStr.length() < 10 )  return Integer.valueOf("-" + subStr).intValue();
            int i = subStr.compareTo("2147483648");
            if (i > 0) return 0;
            return Integer.valueOf("-" + subStr).intValue();
        }
    }
    
    
    /**
     * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param  
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi  
     * @Date: 2019/7/15 7:50 PM
     **/
    @Test
    public void test3 (){
        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"c", "c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String first = strs[0];
        for (int i = 0; i<first.length() ; i++){
            String cur = first.substring(0, i + 1);
            boolean flag = true;
            for (int j = 1; j<strs.length;j++){
                String curJ = strs[j];
                if (curJ.indexOf(cur) != 0){
                    flag = false;
                    break;
                }
            }
            if (i == 0 && !flag) return "";
            if (!flag) return cur.substring(0, cur.length()-1);
            if (cur.equals(first)) return cur;
        }
//        HashSet<String> strings = new HashSet<>();
//        for (int i = 0; i < chars.length-1; i++){
//            for (int j = i+1; j<chars.length;j++){
//                String in = String.valueOf(chars[i]) + String.valueOf(chars[j]);
//                strings.add(in);
//            }
//        }
        return "";
    }
}
