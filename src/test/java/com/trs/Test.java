package com.trs;

/***
 *  Created by shao.guangze on 2018/10/9
 */
public class Test {

    public static void main(String[] args){
        String trsl = "ajlk啊#萝卜头#啊lkj";
        System.out.println(replaceTrsl(trsl));
    }
    /**
     * 表达式加引号
     *
     * @param trsl 表达式
     */
    public static String replaceTrsl(String trsl) {
        //trsl = trsl.replaceAll(" ", "");
        StringBuilder builder = new StringBuilder();
        char[] c = ("#" + trsl + "#").toCharArray();
        boolean f = true;
        out:
        for (int i = 0; i < c.length; i++) {
            builder.append(c[i]);
            //遇到引号切换遍历状态
            if (c[i] == '"') {
                f = !f;
                continue;
            }
            //发现其他字符到汉字转换
            if (f && isChinese(c[i]) && !isChinese(c[i - 1])) {
                for (int j = 1; j <= i; j++) {
                    char a = c[i - j];
                    if (a == ':' || a == '(' || a == ' ' || a == '#') {
                        builder.insert(builder.length() - j, "\"");
                        continue out;
                    }
                }
            }
            //发现汉字到其他字符转换
            if (i > 1 && f && !isChinese(c[i]) && isChinese(c[i - 1])) {
                for (int j = 0; j < c.length - i; j++) {
                    char a = c[i];
                    if (a == ':' || a == ')' || a == ' ' || a == '#') {
                        builder.insert(builder.length() - 1, "\"");
                        continue out;
                    }
                    builder.append(c[i + 1]);
                    i++;
                }
            }
        }
        return f ? builder.deleteCharAt(builder.length() - 1).deleteCharAt(0).toString() : trsl;
    }

    /**
     * 输入的字符是否是汉字
     * @param a char
     * @return boolean
     */
    public static boolean isChinese(char a) {
        int v = (int)a;
        return (v >=19968 && v <= 171941);
    }
}
