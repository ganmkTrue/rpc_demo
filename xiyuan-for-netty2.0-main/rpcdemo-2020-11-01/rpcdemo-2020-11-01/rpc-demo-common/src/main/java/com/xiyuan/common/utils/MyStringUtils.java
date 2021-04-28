package com.xiyuan.common.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtils {


    /**
     * 判断是不是0或1
     * @param str
     * @return
     */
    public static boolean  iszerandone(String str){
        Pattern pattern = Pattern.compile("[0-1]{1}");
        Matcher matcher = pattern.matcher((CharSequence)str);
        return matcher.matches();
    }

    /**
     * 判断是不是数字
     * @param str
     * @return
     */
    public static boolean  isnum(String str){
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence)str);
        return matcher.matches();
    }

    /**
     * 判断是否是时间
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess=true;
       // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
      // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
       // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }
    /**
     * 逗号分隔字符串
     *
     * @param ids
     * @return
     */
    public static List<String> getOptionList(String ids) {
        List<String> list = new ArrayList<>();
        String[] Str = ids.split(",");
        for (String temp : Str) {
            list.add(temp);
        }
        return list;
    }

}
