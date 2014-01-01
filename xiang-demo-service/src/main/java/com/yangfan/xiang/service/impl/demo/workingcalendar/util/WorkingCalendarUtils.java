package com.yangfan.xiang.service.impl.demo.workingcalendar.util;

import java.util.Date;

/**
 * 工作日工具类
 * 
 * @author 杨帆
 *
 */
public class WorkingCalendarUtils {
	
	/**
	 * 获取指定日期之前或之后的工作日
	 * 
	 * 假如：[2013-05-05, 2013-05-29]区间除周六日外其他都为工作日
	 * 
	 * 例如调用：
	 * 
	 * 1、2013-05-15之后的第一个工作日，返回2013-05-16。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, 1, true )
	 * 
	 * 2、2013-05-15之前的第一个工作日，返回2013-05-14。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, -1, true )
	 * 
	 * 3、2013-05-11之后的第一个工作日，返回2013-05-13。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-11, 1, true )
	 * 
	 * 4、2013-05-11之前的第一个工作日，返回2013-05-10。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-11, -1, true )
	 * 
	 * 5、2013-05-15之后的第五个工作日，返回2013-05-22。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, 5, true )
	 * 
	 * 6、2013-05-15之前的第五个工作日，返回2013-05-8。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, -5, true )
	 * 
	 * 7、2013-05-15之后的第五个日期，若为工作日则返回，若非工作日则顺延至下一工作日，返回2013-05-20。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, 5, false )
	 * 
	 * 8、2013-05-15之前的第五个日期，若为工作日则返回，若非工作日则顺延至下一工作日，返回2013-05-10。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, -5, false )
	 * 
	 * 9、2013-05-15之后的第三个日期，若为工作日则返回，若非工作日则顺延至下一工作日，返回2013-05-20。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, 3, false )
	 * 
	 * 10、2013-05-15之前的第三个日期，若为工作日则返回，若非工作日则顺延至下一工作日，返回2013-05-10。
	 * WorkingCalendarUtils.getWorkingDate( 2013-05-15, -3, false )
	 * 
	 * @param date 指定日期
	 * @param interval 之前或之后的日期数, 传负数为之前, 不能传入 0
	 * @param isWorkingDate 间隔日期是否为工作日，true为工作日，false为自然日
	 * @return
	 */
	public static Date getWorkingDate(Date date, Integer interval, boolean isWorkingDate ) {
		return null;
	}

}
