
package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHandle {
	public static void main(String[] args) throws ParseException {
		/*Calendar calendar = Calendar.getInstance();
		String format = new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String format2 = new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
		System.out.println(format);
		System.out.println(format2);*/
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,0);   //week时，这里0表示明天，-1表示今天
		String yesterday = new SimpleDateFormat( "yyyy年MM月dd日HH时mm分ss秒").format(cal.getTime());
        System.out.println("明天周"+ cal.get(Calendar.DAY_OF_WEEK));

		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,0);
		String today = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(cal.getTime());
		cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		String lastYear = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(cal.getTime());
		System.out.println("yesterday"+yesterday);
		System.out.println(today);
		System.out.println(lastYear);

		
		/*System.out.println(new Date().getTime());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY  ,new Integer("-"+"1分钟前".replace("分钟前", "")));
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(cal.getTime()));
		System.out.println(cal.getTime().getTime());*/
		
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(new Date(1529592000000L)));
		Date parse = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse("2018.07.03 23:59:00");
		System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(parse));
		//System.out.println(parse.getTime());2018.07.03 23:59:00

		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, +2);
		String aftertTomorrow = new SimpleDateFormat("yyyy年MM月dd日").format(instance.getTime());
		String result = aftertTomorrow + " 00时00分00秒";
		System.out.println(result);

		System.out.println("---------------------------------");
		Calendar currentTime = Calendar.getInstance();
		currentTime.add(Calendar.MINUTE, -10);
		System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(currentTime.getTime()));
	}
}
