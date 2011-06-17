package com.baizhi.commons.support;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;


/**
 * 
 * 类名：DateUtils<br>
 * 描述：日期支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class DateUtils {

	public static final String DB_DATE_FORMAT = "yyyyMMddHHmmss";
	
	public static final String SHOW_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_YEAR = "yyyy";
	
	public static final String DATE_YEARMONTHDAY = "yyyyMMdd";
	
	public static final String DATE_YEAR_MONTH_DAY = "yyyy-MM-dd";
	
	public static final String DATE_YEARMONTH = "yyyyMM";
	
	public static final String DATE_YEAR_MONTH = "yyyy-MM";

	/**
	 * 获取服务器当前时间
	 * 
	 * @param pattern 日期格式,示例：yyyyMMddHHmmss
	 * @return 返回当前指定格式时间
	 */
	public static String getCurrentTime(String pattern) {
		Calendar calendar = new GregorianCalendar();
		Format format = new SimpleDateFormat(pattern);
		return format.format(calendar.getTime());
	}
	
	/**
	 * 获取当前年月(yyyy-MM)
	 */
	public static String getCurrentYearMonth() {
		return getYearMonth(new Date(), DateUtils.DATE_YEAR_MONTH);
	}
	
	
	/**
	 * 获取年月
	 * @param date    日期
	 * @param pattern 转换日期格式
	 * @return
	 */
	public static String getYearMonth(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 获取指定时间
	 * 
	 * @param pattern 日期格式,示例：yyyyMMddHHmmss
	 * @param amount  天数
	 * @return 返回当前日期+天数
	 */
	public static String getAppointTime(String pattern, int amount) {
		return getAppointTime("", pattern, amount);
	}
	
	/**
	 * 获取指定时间
	 * 
	 * @param date    日期
	 * @param pattern 日期格式,示例：yyyyMMddHHmmss
	 * @param amount  天数
	 * @return 返回当前日期+天数
	 */
	public static String getAppointTime(String date,String pattern, int amount) {
		Calendar calendar = new GregorianCalendar();
		if(date!=null&&!date.trim().equals("")){
			calendar.setTime(conversionDate(date, pattern));
		}
		calendar.add(Calendar.DAY_OF_MONTH, amount);
		Format format = new SimpleDateFormat(pattern);
		return format.format(calendar.getTime());
	}

	/**
	 * 转换时间
	 * 
	 * @param date
	 *            被转换日期
	 * @param format
	 *            被转换日期格式
	 * @param conversion_format
	 *            转换日期格式
	 * @return 返回转换日期格式
	 */
	public static String conversionTime(String date, String format,
			String conversion_format) {
		if (StringUtils.isEmpty(date)){
			return "";
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		SimpleDateFormat sdf2 = new SimpleDateFormat(conversion_format);
		try {
			return sdf2.format(sdf1.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 转换时间。说明：将日期格式为：yyyy-MM-dd HH:mm:ss转换成日期格式为：yyyyMMddHHmmss
	 * 
	 * @param date
	 *            转换日期
	 * @return 返回转换日期格式
	 */
	public static String conversionTime(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat(DateUtils.SHOW_DATE_FORMAT);
		SimpleDateFormat sdf2 = new SimpleDateFormat(DateUtils.DB_DATE_FORMAT);
		try {
			return sdf2.format(sdf1.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 转换时间。说明：将日期格式为：yyyy-MM-dd HH:mm:ss转换成日期格式为：yyyyMMddHHmmss
	 * 
	 * @param date
	 *            转换日期
	 * @return 返回转换日期格式
	 */
	public static String conversionDataBaseTime(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat(DateUtils.DB_DATE_FORMAT);
		SimpleDateFormat sdf2 = new SimpleDateFormat(DateUtils.SHOW_DATE_FORMAT);
		try {
			return sdf2.format(sdf1.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将String类型转换日期类型
	 * 
	 * @param date
	 *            转换日期
	 * @param pattern
	 *            日期格式
	 * @return 返回日期类型
	 */
	public static Date conversionDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将日期类型转换String类型
	 * 
	 * @param date
	 *            转换日期
	 * @param pattern
	 *            日期格式
	 * @return 返回String类型
	 */
	public static String conversionDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}


	


	/**
	 * 将显示格式的时间字符串转换为数据库存储的类型
	 * 
	 * @param dateStr
	 *            最小4位，最大19位。显示的时间格式时间串如:2004-12-12
	 * @return 数据库存储的时间字符串
	 */
	public static String toStoreStr(String dateStr) {
		if (dateStr == null || dateStr.trim().equals("")) {
			return "";
		}
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < dateStr.length(); i++) {
			if (dateStr.charAt(i) >= '0' && dateStr.charAt(i) <= '9') {
				strBuf.append(dateStr.charAt(i));
			}
		}
		return strBuf.toString();
	}

	/**
	 * <b>功能描述：</b> 把时间转换成14位的字符串，不足位数补充 0 或者 9
	 * 
	 * @param dateStr
	 *            String
	 * @param key
	 *            int
	 * @return String
	 */
	public static String toStoreStr14(String dateStr, boolean bMax) {
		if (dateStr == null || dateStr.trim().equals("")) {
			return "";
		}
		StringBuffer strBuf = new StringBuffer(toStoreStr(dateStr));
		String retStr = strBuf.toString();
		if (bMax) {
			retStr = StringUtils.pad(retStr, 14, '9', true);
		} else {
			retStr = StringUtils.pad(retStr, 14, '0', true);
		}
		return retStr;
	}

	/**
	 * 将生日存储的时间格式转化为年龄（周岁，小数点后不计）
	 * 
	 * @param birthdayStr
	 *            生日字段 "yyyymmdd"
	 * @return 年龄
	 */
	public static String birthdayToAge(String birthdayStr) {
		if (birthdayStr == null || birthdayStr.length() < 6) {
			return "";
		} else {
			int birthYear = Integer.parseInt(birthdayStr.substring(0, 4));
			int birthMonth = Integer.parseInt(birthdayStr.substring(4, 6));
			Calendar cal = new GregorianCalendar();
			int currYear = cal.get(Calendar.YEAR);
			int currMonth = cal.get(Calendar.MONTH);
			int age = currYear - birthYear;
			age -= (currMonth < birthMonth) ? 1 : 0;
			return "" + age;
		}
	}

	/**
	 * 功能描述: 将年龄转换为生日
	 * 
	 * @param age
	 *            int
	 * @return String
	 */
	public static String ageToBirthday(int age) {

		String currDateStr = DateUtils.getYearMonth(new Date(), DateUtils.DATE_YEARMONTH);
		int currDateInt = Integer.parseInt(currDateStr);
		int ageDateInt = currDateInt - age * 100;
		return String.valueOf(ageDateInt);
	}
	

	/**
	 * 功能描述: 增加一年
	 * 
	 * @param age
	 *            int
	 * @return String
	 */
	public static String nextAgeDate(String birDate) {

		int currDateInt = Integer.parseInt(birDate);
		int ageDateInt = currDateInt + 100;
		return String.valueOf(ageDateInt);
	}

	/**
	 * @param dateTimeStr
	 *            String 格式化的时间串
	 * @param formatType
	 *            时间格式
	 * @param detal
	 *            int 增加或减少的时间
	 * @param field
	 *            int 参见Calendar中关于时间字段属性的定义
	 * @return String 返回的
	 */
	public static String add(String dateTimeStr, String formatStr, int detal,
			int field) {
		if (dateTimeStr == null || dateTimeStr.length() < 6) {
			return dateTimeStr;
		} else {
			try {
				formatStr = formatStr.substring(0, dateTimeStr.length());
				SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
				Date d = sdf.parse(dateTimeStr);
				GregorianCalendar g = new GregorianCalendar();
				g.setTime(d);
				g.add(field, detal);
				d = g.getTime();
				return sdf.format(d);
			} catch (ParseException ex) {
				ex.printStackTrace();
				return dateTimeStr;
			}
		}
	}

	

	/**
	 * 把日期时间对象格式化为yyyyMMdd样式
	 * 
	 * @param date
	 *            Date 将要被格式化的日期对象
	 * @return String 格式化后的日期、时间字符串，如：20041001
	 */
	public static String getDateFormat(Date date) {
		return conversionDate(date, DateUtils.DATE_YEARMONTHDAY);
	}

	

	/**
	 * 把系统当前日期时间格式化为默认样式yyyyMMdd
	 * 
	 * @return String 格式化后的日期、时间字符串，如：20041001
	 */
	public static String getDateFormat() {
		return conversionDate(new Date(), DateUtils.DATE_YEARMONTHDAY);
	}

	/**
	 * 日期、时间格式化
	 * 
	 * @param millis
	 *            long the number of milliseconds（毫秒） since January 1, 1970,
	 *            00:00:00 GMT.
	 * @param outFmt
	 *            String 返回样式，参照类说明，如：yyyy年MM月dd日
	 * @return String 格式化后的日期、时间字符串
	 */
	public static String getDateFormat(long millis, String outFmt) {
		Date d = new Date(millis);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		String retu = conversionDate(calendar.getTime(), outFmt);
		calendar = null;
		return retu;
	}

	

	

	/**
	 * 根据format的样式，日期时间字符串转化为日期时间对象
	 * 
	 * @param datestr
	 *            String 日期时间字符串，如：20041001、2004年10月01日 15:03
	 * @param format
	 *            String 对datestr参数格式说明，参照类说明，如yyyyMMdd、yyyy年MM月dd日 HH:mm
	 * @return Date 日期时间对象，格式inFmt非法时，使用yyyyMMdd格式
	 */
	public static Date getDate(String datestr, String format) {
		if (StringUtils.isEmpty(datestr)) {
			return null;
		}
		if (StringUtils.isEmpty(format)) { // inFmt非法
			format = DateUtils.DATE_YEARMONTHDAY;
		}
		if (format.length() > datestr.length()) {
			format = format.substring(0, datestr.length());
		}

		try {
			// 依据inFmt格式把日期字符串转化为日期对象
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setLenient(true);
			return dateFormat.parse(datestr);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 对日期时间对象进行调整，实现如昨天是几号，去年的今天星期几等.
	 * 
	 * @param date
	 *            需要调整的日期时间对象
	 * @param CALENDARFIELD
	 *            对日期时间对象以什么单位进行调整
	 * @param amount
	 *            调整数量，>0表向后调整（明天，明年），<0表向前调整（昨天，去年）
	 * @return 调整后的日期时间对象
	 */
	public static Date addDate(Date date, int CALENDARFIELD, int amount) {
		if (null == date) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(CALENDARFIELD, amount);
		return calendar.getTime();
	}

	
	/**
	 * 对日期时间对象进行调整.
	 * 
	 * @param datestr
	 *            String 需要调整的日期时间字符串，它的格式为yyyyMMdd
	 * @param CALENDARFIELD
	 *            int 对日期时间对象以什么单位进行调整
	 * @param amount
	 *            int 调整数量
	 * @return Date 调整后的日期时间对象
	 * @throws ParseException
	 *             当datestr不能格式化为yyyyMMdd格式时抛出此异常
	 * @see #addDate(java.util.Date, int, int)
	 */
	public static Date addDate(String datestr, int CALENDARFIELD, int amount)
			throws ParseException {
		return addDate(getDate(datestr, DateUtils.DATE_YEARMONTHDAY), CALENDARFIELD, amount);
	}


	

	/**
	 * 计算两个日期之间相差的时间（单位秒） add by linkx 2010-08-18
	 * 
	 * @param endDate 结束日期
	 * @param srartDate  开始日期
	 * @return 相差的天数
	 */
	public static long getMinusTimes(String endDate, String startDate) {
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = getDate(endDate, DateUtils.DB_DATE_FORMAT);
			date2 = getDate(startDate, DateUtils.DB_DATE_FORMAT);
			long thevalue = (long) (Math.abs(date1.getTime() - date2.getTime()) / (1000) + 0.5);
			return thevalue;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取两个日期的时间差，包括时间单位（秒|分｜小时｜天） add by linkx 2010-08-18
	 * 
	 * @param endDate
	 * @param srartDate
	 * @return
	 */
	public static String getMinusTimesIncludeUnit(String endDate,
			String startDate) {
		long times = getMinusTimes(endDate, startDate);
		StringBuffer timesStr = new StringBuffer("");
		int days = 0;
		int hours = 0;
		int minutes = 0;
		if (times >= 24 * 60 * 60) {
			days = ((int) (times / (24 * 60 * 60)));
			times = times % (24 * 60 * 60);
			timesStr.append(days + "天");
		}
		if (times >= 60 * 60) {
			hours = ((int) (times / (60 * 60)));
			times = times % (60 * 60);
			timesStr.append(hours + "小时");
		}
		if (times >= 60) {
			minutes = ((int) (times / 60));
			times = times % (60);
			timesStr.append(minutes + "分钟");
		}
		if (times > 0) {
			timesStr.append(times + "秒");
		}
		return timesStr.toString();
	}
	/**
	 * 
	 * @param endDate  2007/6
	 * @param startDate  2004/6
	 * @return
	 */
	public static String getYearAndMonth(String endDate,
			String startDate) {
		 String reStr="";
		 try{
		 endDate = endDate.split("/")[0]+endDate.split("/")[1]+"01000000";
		 startDate = startDate.split("/")[0]+startDate.split("/")[1]+"01000000";
		 long day = DateUtils.getMinusTimes(endDate,startDate);
		 long year = day/(365*24*3600);
		 long month = (day%(365*24*3600)/(24*3600*30));
		 if(year>0){
			 reStr = year+"年";
		 }
		 if(month>0){
			 reStr = reStr+month+"月";
		 }}catch(Exception ex){
			 ex.printStackTrace();
		 }
		 return reStr;
	}
	
	/**
	 * 获取显示时间
	 * @param map
	 * @param name
	 * @return
	 */
	public static String getShowTime(Map<String,Object> map,String name){
		String sreturn="";
		if(map.get(name)!=null&&!String.valueOf(map.get(name)).trim().equals("")){
			sreturn=DateUtils.conversionTime(String.valueOf(map.get(name)), DateUtils.DB_DATE_FORMAT, DateUtils.SHOW_DATE_FORMAT);
		}
		return sreturn;
	}
	
	/**
	 * 获取显示日期
	 * @param map
	 * @param name
	 * @return
	 */
	public static String getShowDate(Map<String,Object> map,String name){
		String sreturn="";
		if(map.get(name)!=null&&!String.valueOf(map.get(name)).trim().equals("")){
			sreturn=DateUtils.conversionTime(String.valueOf(map.get(name)), DateUtils.DATE_YEARMONTHDAY, DateUtils.DATE_YEAR_MONTH_DAY);
		}
		return sreturn;
	}
	/**
	 * 转换list中的日期 
	 * 支持多个日期字段转换
	 * @param list             含有需转换日期list
	 * @param namepatternMap   key=需转换日期名称  value=转换日期格式
	 * @return 
	 */
	public static List<Map<String,Object>> fromatListDate(List<Map<String,Object>> list,Map<String,String> namepatternMap){
		for(Map<String,Object> map:list){
			for(Object key:namepatternMap.keySet()){
				String pattern  = Nuller.getString(namepatternMap.get(key));
				String strDate = Nuller.getString(map.get(key));
				String pattern1 = DB_DATE_FORMAT;
				if(strDate.length()==8){
					pattern1 = DATE_YEARMONTHDAY;
				}
				if(StringUtils.isNotEmpty(Nuller.getString(map.get(key)))){
					String itemDate = DateUtils.conversionTime(Nuller.getString(map.get(key)), pattern1,pattern);
					map.put(key.toString(), itemDate);
				}
			}
		}
		return list;
	}
}
