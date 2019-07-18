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

import com.sun.media.sound.SoftTuning;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    /**
     * @Description 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     *
     * 如果不存在最后一个单词，请返回 0 。
     *
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     *
     * 示例:
     *
     * 输入: "Hello World"
     * 输出: 5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 10:53 AM
     **/
    @Test
    public void test4(){
//        String s = "Hello World";
        String s = " ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) return 0;
        s = s.trim();
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
    
    /**
     * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     *
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param  
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 11:06 AM
     **/
    @Test
    public void test5(){
//        String str = "III";
//        String str = "IV";
//        String str = "IX";
//        String str = "LVIII";
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));

    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0 ; i < chars.length; i++){
            char cur = chars[i];
            if (i == chars.length - 1) {
                result+=map.get(String.valueOf(cur));
                break;
            }
            boolean flag = false;
            switch (cur){
                case 'I':
                    if (chars[i + 1] == 'V') {
                        result += 4;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'X') {
                        result  +=9;
                        i++;
                        flag = true;
                    }
                    break;
                case 'X':
                    if (chars[i + 1] == 'L') {
                        result += 40;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'C') {
                        result  +=90;
                        i++;
                        flag = true;
                    }
                    break;
                case 'C':
                    if (chars[i + 1] == 'D') {
                        result += 400;
                        i++;
                        flag = true;
                    } else if (chars[i + 1] == 'M') {
                        result  +=900;
                        i++;
                        flag = true;
                    }
                    break;
                default:
                    break;
            }
            if (!flag) result+=map.get(String.valueOf(cur));
        }
        if (result < 1 || result > 3999) return 0;
        return result;
    }
    
    /**
     * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param  
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 11:52 AM
     **/
    @Test
    public void test6(){
//        String str = "{[]}";
//        String str = "([][]){{}}";
//        String str = "()[]{}";
        String str = "(]";
//        ( ( ( [ ] ) ) )
//        0 1 2 3 4 5 6 7
//
//        { { { } } }
//        0 1 2 3 4 5
        System.out.println(isValid((str)));
    }
    public static boolean isValid(String s) {
        //40 41 91 93 123 125
        if (s == null || s.length() % 2 == 1) return false;
        if ( s.length() == 0 || s.trim().length() == 0) return true;
        char[] chars = s.toCharArray();
        boolean[] bs = new boolean[chars.length];
        for (int i = 0; i < chars.length ; i++) {
            if (bs[i]) continue;
            char cur = chars[i];
            char next = chars[i + 1];
            int temp = next - cur;
            if (temp == 2 || temp == 1) {
                bs[i] = true;
                bs[i + 1 ] = true;
            } else {
                boolean flag = false;
                int index = 0;
                int repeated = 0;
                for (int j = i + 1 ; j < chars.length; j++){
                    if (bs[j]) return false;
                    char next2 = chars[j];
                    int temp2 = next2 - cur;
                    if (temp2 == 0) {
                        repeated ++;
                        continue;
                    }
                    if (temp2 == 2 || temp2 == 1) {
                        repeated --;
                        if (repeated == -1){
                            flag = true;
                            index = j;
                            bs[i] = true;
                            bs[j] = true;
                            break;
                        }
                    }
                }
                if (!flag) return false;
                if ((index - i + 1) % 2 == 1) return false;
            }
        }
        return true;
    }

    /**
     * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
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
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 9:26 PM
     **/
    @Test
    public void test7(){
        //[],
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{1, 2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 ) return 0;
        int curOut = nums[0];
        int outIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int curIn = nums[i];
            if (curIn != curOut){
                outIndex++;
                nums[outIndex] = curIn;
                curOut = curIn;
            }
        }
        for (int i = 0;i < outIndex + 1 ; i ++) {
            System.out.println(nums[i]);
        }
        return outIndex + 1;
    }

    /**
     * @Description
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/18 4:00 PM
     **/
    @Test
    public void test8(){
        String hayStack = "mississippi";
        String needle = "sippia";
        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        if (needle.length() > haystack.length()) return -1;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        for (int i = 0; i< chars1.length;i ++){
            char curI = chars1[i];
            boolean eq = false;
            int x = 0;
            int y = 0;
            for (int j = 0; j< chars2.length; j ++){
                char curJ = chars2[j];
                if (curJ == curI){
                    eq = true;
                    if (i == chars1.length - 1 && j != chars2.length -1) return -1;
                    if (j == chars2.length -1) return i;
                    x++;
                    y = i +x;
                    if (y > chars1.length - 1 ) return -1;
                    curI = chars1[y];
                } else {
                    eq = false;
                    break;
                }
            }
            if (eq) return i;
        }
        return -1;
    }
}
