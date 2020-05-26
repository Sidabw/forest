package com.beta.basic.util;


import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class PhoneCheck {
	/**
	 * 验证手机号是否合法 合法手机号有如下: 
	 * 联通：130","131","132","155","156","175 ( 新) ","176( 新)","185","186","145 
	 * 移动:134","135","136","137"," 138","139","150","151","152","157","158","159"," 178(新)"," 182","183"," 184","187"," 188","147
	 * 电信:133","153 ","173(新) "," 177 (新) "," 180","181","189","149
	 * 其他(虚拟运营商)：170(新)","171 (新)
	 * 
	 * 整理入下： 130","131","132","133","134","135","136","137"," 138","139
	 * 145","147","149 150"," 151","152","153"," 155","156","157","158","159","
	 * 170","171 "," 173"," 175 ","176","177","178 180","181","182","183","
	 * 184","185","186","187","188","189
	 */
	public static void main(String[] args) {
		String testStr = "+8617610170622";
		String regex = "^((\\+86)??)((13[0-9])|(14[579])|(15[012356789])|(18[0-9])|(17[0135678]))\\d{8}$";
		String regex2 = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";
		String regex3 = "(\\+\\d+)?1((3[0-9])|(4[579])|(5[012356789])|(8[0-9])|(7[0135678]))\\d{8}$";
		/*Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(testStr);
		boolean matches = matcher.matches();*/
		boolean matches2 = Pattern.matches(regex3, testStr);
		System.out.println(matches2);
	}


	public void test() {
		//System.out.println(1);
		/*String[] str = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };*/
		for (int i = 0; i < 43; i++) {
			int nextInt = new Random().nextInt(10);
			System.out.print(nextInt);
		}
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		String[] strs=new String[]{"ajnav","saljkdf","hnzqa"};
		Arrays.sort(strs);
		for(int i=0;i<strs.length;i++){
			System.out.print(strs[i]);
		}
	}
}
