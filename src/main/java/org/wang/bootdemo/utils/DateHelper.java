package org.wang.bootdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DateHelper
 * @Description 时间转换类
 * @Author wangHao
 * @DATE 2020/1/5 22:12
 * @Version 1.0
 */
public class DateHelper {

    /**
     * @description 日期转换为字符串
     * @author wangHao
     * @date 2020/1/5 22:21
     * @param [date, pattern]
     * @return java.lang.String
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * @description 字符串转化为日期
     * @author wangHao
     * @date 2020/1/5 22:26
     * @param [dateStr, pattern]
     * @return java.util.Date
     */
    public static Date stringToDate(String dateStr, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
    public static void main(String[] args) {
        List<String> alist = new ArrayList<>(20);
        alist.add(null);
    }
}
