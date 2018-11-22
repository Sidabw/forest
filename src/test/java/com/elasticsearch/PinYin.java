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
package com.elasticsearch;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class PinYin {
    private String getPinyin(String hanzi){
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
    public static void main(String[] args){
        char a = '、';
        System.out.println(a);
    }
}
