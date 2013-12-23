package com.yangfan.xiang.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yangfan.xiang.core.CoreException;

public class DateUtils {
	
	/**
	 * 日期时间格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static final String datePattern = "yyyy-MM-dd";
	
	/**
	 * 时间格式：HH:mm:ss
	 */
	public static final String timePattern = "HH:mm:ss";
	
	private static SimpleDateFormat formatter = new SimpleDateFormat();
	
	/**
	 * 将Date格式化成yyyy-MM-dd HH:mm:ss的字符串
	 * @param date 待格式化Date
	 * @return 日期时间字符串
	 */
	public static String formatDateTime(Date date) {
		return format(dateTimePattern, date);
	}

	/**
	 * 将Date格式化成yyyy-MM-dd的字符串
	 * @param date 待格式化Date
	 * @return 日期字符串
	 */
	public static String formatDate(Date date) {
		return format(datePattern, date);
	}
	
	/**
	 * 将Date格式化成HH:mm:ss的字符串
	 * @param date 待格式化Date
	 * @return 时间字符串
	 */	
	public static String formatTime(Date date) {
		return format(timePattern, date);
	}
	
	/**
	 * 将Date格式化成指定格式的字符串
	 * @param pattern 指定格式
	 * @param date 待格式化Date
	 * @return 格式化后的字符串
	 */
	public static String format(String pattern, Date date) {
		formatter.applyPattern(pattern);
		return formatter.format(date);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的字符串解析成Date
	 * @param source 待格式化字符串
	 * @return Date类型
	 */
	public static Date parseDateTime(String source) {
		return parse(dateTimePattern, source);
	}
	
	/**
	 * 将yyyy-MM-dd格式的字符串解析成Date
	 * @param source 待格式化字符串
	 * @return Date类型
	 */	
	public static Date parseDate(String source) {
		return parse(datePattern, source);
	}

	/**
	 * 将HH:mm:ss格式的字符串解析成Date
	 * @param source 待格式化字符串
	 * @return Date类型
	 */
	public static Date parseTime(String source) {
		return parse(timePattern, source);
	}
	
	/**
	 * 将指定格式的字符串解析成Date
	 * @param pattern 指定格式
	 * @param source 待格式化字符串
	 * @return Date类型
	 */
	public static Date parse(String pattern, String source) {
		formatter.applyPattern(pattern);
		try {
			return formatter.parse(source);
		} catch (ParseException e) {
			throw new CoreException(e);
		}
	}
	
}
