package com.example.recovery.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具包
 *
 * @author wgl
 */
public class TimeUtil {

    /**
     * 默认时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULTPATTERN="yyyy-MM-dd HH:mm:ss";
	public  static final String PATTERN_YYYY_MM_DD="yyyy-MM-dd";
	public  static final String PATTERN_YYYYMMDDHHMMSS="yyyyMMddHHmmss";
	
    /**
     * 获取现在时间
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(TimeUtil.DEFAULT_FORMAT);
        String dateString = formatter.format(new Date());
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(new Date());
        return dateString;
    }
    /**
     * 格式化時間
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     * @throws ParseException 
     */
    public static Date getFormatDate(String format)  {
    	
    	try { 
    		SimpleDateFormat sdf = new SimpleDateFormat( DEFAULT_FORMAT );
    		Date sourceDate = sdf.parse( format );
        	return sourceDate;
		} catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
    	
    	return null;
    }
    /**
     * 格式化時間
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     * @throws ParseException 
     */
    public static String getFormatDate(Date date)  {
    	
    	try { 
    		SimpleDateFormat formatter = new SimpleDateFormat(TimeUtil.DEFAULT_FORMAT);
            String dateString = formatter.format( date );
            return dateString;
    	} catch (Exception e) 
    	{ 
    		e.printStackTrace(); 
    	} 
    	
    	return null;
    }

    /**
     * 判断是否在时间区间内
     *
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当天的开始时间
     * @param date
     * @return
     */
    public static Date getFirstTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天的结束时间
     * @param date
     * @return
     */
    public static Date getLastTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
    
   public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat( DEFAULT_FORMAT );
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
   /**
    * @param DATE1
    * @param DATE2
    * @return
    * DATE1 > DATE2 return 1
    * DATE1 < DATE2 return -1
    */
   public static int compare_date(Date DATE1, Date DATE2) {
	   DateFormat df = new SimpleDateFormat( DEFAULT_FORMAT );
	   try {
		   if (DATE1.getTime() > DATE2.getTime()) {
			   return 1;
		   } else if (DATE1.getTime() < DATE2.getTime()) {
			   return -1;
		   } else {
			   return 0;
		   }
	   } catch (Exception exception) {
		   exception.printStackTrace();
	   }
	   return 0;
   }
   /**
	 * 返回当前时间 month个月以前的时间  
	 */
	@SuppressWarnings("unchecked")
	public static String[] getCurrentMonth( int month) {
		String [] timeMonth=new String[month];
		for(int i=1;i<=timeMonth.length;i++){
			Calendar cc = Calendar.getInstance();
			cc.add(Calendar.MONTH, -i+1);
			timeMonth[i-1]=cc.get(Calendar.YEAR)+"-"+((cc.get(Calendar.MONTH)+1));
			
		}
		for(int i=0;i<timeMonth.length;i++){
			String date=timeMonth[i];
			String[] monthnow=date.split("-");
			if(monthnow[1].length()==1){
				monthnow[1]="0"+monthnow[1];
			}
			String start=monthnow[0]+"-"+monthnow[1];
	        
			timeMonth[i]=start;
		}
		return timeMonth;
	}
	/** 
	* 获取指定月的前一月(年)或后一月(年) 
	* @param dateStr 
	* @param addYear 
	* @param addMonth 
	* @param addDate 
	* @return 输入的时期格式为yyyy-MM,输出的日期格式为yyyy-MM 
	* @throws Exception 
	*/ 
	public static String getLastMonth(String dateStr,int addYear, int addMonth, int addDate) throws Exception { 
		try { 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date sourceDate = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(sourceDate); 
			cal.add(Calendar.YEAR,addYear); 
			cal.add(Calendar.MONTH, addMonth); 
			cal.add(Calendar.DATE, addDate); 
			SimpleDateFormat returnSdf = new SimpleDateFormat("yyyy-MM");
			String dateTmp = returnSdf.format(cal.getTime()); 
			Date returnDate = returnSdf.parse(dateTmp);
			return dateTmp; 
		} catch (Exception e) 
		{ 
			e.printStackTrace(); 
			throw new Exception(e.getMessage()); 
		} 
	}
	/** 
	 * 获取指定月的前一月(年)或后一月(年) 
	 * @param dateStr 
	 * @param addYear 
	 * @param addMonth 
	 * @param addDate 
	 * @return 输入的时期格式为yyyy-MM,输出的日期格式为yyyy-MM 
	 * @throws Exception 
	 */ 
	public static String getLastMonth(Date dateStr,int addYear, int addMonth, int addDate) throws Exception { 
		try { 
			Calendar cal = Calendar.getInstance(); 
			cal.setTime( dateStr ); 
			cal.add(Calendar.YEAR,addYear); 
			cal.add(Calendar.MONTH, addMonth); 
			cal.add(Calendar.DATE, addDate); 
			SimpleDateFormat returnSdf = new SimpleDateFormat( DEFAULT_FORMAT );
			String dateTmp = returnSdf.format(cal.getTime()); 
			return dateTmp; 
		} catch (Exception e) 
		{ 
			e.printStackTrace(); 
			throw new Exception(e.getMessage()); 
		} 
	}
	public static String getYear( Date inputdate ){
		Calendar calender = Calendar.getInstance();
		calender.setTime( inputdate );
		String year = Integer.toString(calender.get(Calendar.YEAR));
		return year;
	}
	public static String getMonth( Date inputdate ){
		Calendar calender = Calendar.getInstance();
		calender.setTime( inputdate );
		String month = Integer.toString(calender.get(Calendar.MONTH)+1);
		return month;
	}
}
