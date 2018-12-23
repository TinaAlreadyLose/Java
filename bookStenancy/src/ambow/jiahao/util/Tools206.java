package ambow.jiahao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类主要用于获取系统当前标时间
 * @author GreenDan
 * @Date 2018.12.22
 * @version 1.0.0.206
 */
public class Tools206 { //返回格式化后的时间
    public static String getTime206() {
        /**
         * 获取当前时间的方法
         *
         * @return 返回格式为yyyy-mm-dd的年月日字符串
         *
         */
        Date time = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM1-dd");
        String nowTime = simpleDateFormat.format(time);
        return nowTime;
    }
}
