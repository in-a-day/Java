package cc.margay.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author margay
 */
public interface DateUtil {
    /**
     * Date 类型转换为LocalDate
     * @param date 要转换的数据
     * @return 转换后的LocalDate
     */
    static LocalDate transDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 日期相隔天数
     * @param startDate
     * @param endDate
     * @return 相隔天数, 负数代表开始时间大于结束时间
     */
    static long daysBetweenTwoDate(Date startDate, Date endDate) {
        return transDateToLocalDate(startDate).until(transDateToLocalDate(endDate), ChronoUnit.DAYS);
    }

    static long hoursBetweenTwoDate(Date start, Date end) {
        return (end.getTime() - start.getTime()) / (60 * 60 * 1000);
    }

    /**
     * 格式化日期对象
     * @param date
     * @param pattern 格式化字符串模式
     * @return 格式化后的字符串日期
     */
    static String formatterDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    /**
     * 以yyyyMMdd格式格式化日期
     * @param date
     * @return
     */
    static String formatterDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * 获取给定日期的前后天数的日期
     * @param date 给定的日期
     * @param days 要增加或减少的天数
     * @return 增加/减少指定天数后的指定日期
     */
    static Date addDateDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 返回字符串日期的下个指定天数的日期
     * @param dateStr 字符串日期, 形如: yyyy-MM-dd HH:mm:ss
     * @param days 需要增加或减少的天数
     * @return 返回字符串日期的下个指定天数的日期
     */
    static String addDateDays(String dateStr, int days) {
        Date date = toDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        Date afterAdd = addDateDays(date, days);
        return formatterDate(afterAdd, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 接收String,返回格式化日期
     * @param dateStr 日期字符串
     * @param pattern 格式化类型
     * @return 格式化后日期
     */
    static Date toDate(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date resDate = null;
        try {
            resDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resDate;
    }

    /**
     * 判断两个日期字符串是否相同
     * @param dateStr1 形如: yyyy-MM-dd HH:mm:ss
     * @param dateStr2 形如: yyyy-MM-dd HH:mm:ss
     * @return 返回是否相同
     */
    static boolean isDateStrEquals(String dateStr1, String dateStr2) {
        dateStr1 = dateStr1.substring(0, 10).replace("-", "");
        dateStr2 = dateStr2.substring(0, 10).replace("-", "");
        return dateStr1.equals(dateStr2);
    }
}
