package com.yangfan.xiang.core.util;

import java.util.Date;

import org.junit.Test;

import com.yangfan.xiang.core.support.DateUtils;

public class DateUtilsTest {
	
	private Date date = new Date();
	
	private String dateTimeStr = "2013-02-22 16:38:48";
	private String dateStr = "2013-02-22";
	private String timeStr = "16:38:48";
	private String customStr = "2013/02/22 16:38:48";

	@Test
	public void testFormatDateTime() {
		String formatDateTime = DateUtils.formatDateTime(date);
		System.out.println(formatDateTime);
	}

	@Test
	public void testFormatDate() {
		String formatDate = DateUtils.formatDate(date);
		System.out.println(formatDate);
	}

	@Test
	public void testFormatTime() {
		String formatTime = DateUtils.formatTime(date);
		System.out.println(formatTime);
	}

	@Test
	public void testFormat() {
		String format = DateUtils.format("yyyy/MM/dd HH:mm:ss", date);
		System.out.println(format);
	}

	@Test
	public void testParseDateTime() {
		Date parseDateTime = DateUtils.parseDateTime(dateTimeStr);
		System.out.println(parseDateTime);
	}

	@Test
	public void testParseDate() {
		Date parseDate = DateUtils.parseDate(dateStr);
		System.out.println(parseDate);
	}

	@Test
	public void testParseTime() {
		Date parseTime = DateUtils.parseTime(timeStr);
		System.out.println(parseTime);
	}

	@Test
	public void testParse() {
		Date parse = DateUtils.parse("yyyy/MM/dd HH:mm:ss", customStr);
		System.out.println(parse);
	}

}
