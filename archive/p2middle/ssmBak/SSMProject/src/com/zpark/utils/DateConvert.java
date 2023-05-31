package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;




public class DateConvert implements Converter<String,Date> {

	@Override
	public Date convert(String strDate) {
		System.out.println("11111111111111111111111111111111111111111111"+strDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
