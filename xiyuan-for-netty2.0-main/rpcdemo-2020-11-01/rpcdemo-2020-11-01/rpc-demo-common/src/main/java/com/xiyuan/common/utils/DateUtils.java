package com.xiyuan.common.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供时间先关的常用方法
 */
public class DateUtils {

    //当前时间
    public static Date DATE_NOW=new Date();

    /**
     * 得到完整的时间戳，格式:yyyyMMddHHmmssSSS(年月日时分秒毫秒)
     * @return 完整的时间戳
     */
    public static String getFullTimeStamp(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) ;
    }

    /**
     * 得到简单的时间戳，格式:yyyyMMdd(年月日)
     * @return 简单的时间戳
     */
    public static String getSimpleTimeStamp(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date()) ;
    }

    /**
     * 根据指定的格式得到时间戳
     * @param pattern 指定的格式
     * @return 指定格式的时间戳
     */
    public static String getTimeStampByPattern(String pattern){
        return new SimpleDateFormat(pattern).format(new Date()) ;
    }

    /**
     * 得到当前日期格式化后的字符串，格式：yyyy-MM-dd(年-月-日)
     * @return 当前日期格式化后的字符串
     */
    public static String getTodayStr(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ;
    }

    /**
     * 时间戳，格式:yyyy-MM-dd HH:mm:ss(年-月-日 时：分：秒)
     * @return 简单的时间戳
     */
    public static String getDateTimeStamp(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) ;
    }

    public static Date getDateByString(String str){
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateTime = null;
        try {
            dateTime = sim.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    //判断时间是否已过
    public static boolean isold(Date date){
        Date temp =new Date();
        if(temp.getTime()-date.getTime()>0){
            return true;
        }
        return false;
    }

    /**
     * 计算两个时间差多少秒，用于设置redis数据的生命周期
     * @param startDate
     * @param endDate
     * @return
     */
    public static   int calLastedTime(Date startDate,Date endDate) {
        long a = endDate.getTime();
        long b = startDate.getTime();
        int c = (int)((a - b) / 1000);
        return c;
    }

   /*************************************************时间Date和时间表达式间的转换**************************************/
    /**
     * 日期转化为cron表达式
     * @param date
     * @return
     */
    public static String getCron(Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return  DateUtils.fmtDateToStr(date, dateFormat);
    }

    /**
     * cron表达式转为日期
     * @param cron
     * @return
     */
    public static Date getCronToDate(String cron) {
        String dateFormat="ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * Description:格式化日期,String字符串转化为Date
     *
     * @param date
     * @param dtFormat
     *            例如:yyyy-MM-dd HH:mm:ss yyyyMMdd
     * @return
     */
    public static String fmtDateToStr(Date date, String dtFormat) {
        if (date == null)
            return "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}