/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: PinYin
 * Author:   feiyi
 * Date:     2018/11/22 下午7:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch.util;

import com.alibaba.druid.util.StringUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 〈一句话功能简述〉:
 * 〈汉字转拼音〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class PinYin {
    /**
     * 功能描述:
     * 〈汉字转拼音〉
     *
     * @since: 1.0.0
     * @Author:feiyi
     * @Date: 2019/3/19 11:42 AM
     */
    public static String getPinyin(String hanzi){
        //ascii 32-126 是所有符号及大小写英文的10进制值
        StringBuffer convertResult = new StringBuffer();
        for(int i =0 ; i < hanzi.length(); i++){
            char c = hanzi.charAt(i);
            boolean condition = (c > 31 && c < 127) || c == 65295 || c == 12289;
            if(!condition){
                convertResult.append(c);
            }
        }
        String input = convertResult.toString();
        StringBuilder pinyin = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            char c = input.charAt(i);
            String[] pinyinArray = null;
            try {
                pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (pinyinArray != null) {
                pinyin.append(pinyinArray[0]);
            } else if (c != ' ') {
                pinyin.append(input.charAt(i));
            }
        }
        return pinyin.toString().trim().toLowerCase();
    }

    /**
     * 功能描述:
     * 〈转拼音首字母〉
     *
     * @return:
     * @since: 1.0.0
     * @Author:feiyi
     * @Date: 2019/3/19 11:43 AM
     */
    public static String getSimplifiedPinyin(String companyName) {
        if(StringUtils.isEmpty(companyName))
            return null;
        StringBuffer result = new StringBuffer();
        for(char c : companyName.toCharArray()){
            String pinyin = getPinyin(new StringBuffer().append(c).toString());
            if(StringUtils.isEmpty(pinyin))
                continue;
            result.append(pinyin.substring(0,1));
        }
        return result.toString();
    }



    public static void main(String[] args){
        System.out.println(getPinyin("萝卜"));
        System.out.println(getSimplifiedPinyin("萝卜"));
    }
}
