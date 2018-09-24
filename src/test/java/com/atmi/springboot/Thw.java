package com.atmi.springboot;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Thw {
    private FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private final static String ASD = "ASD";
    private String prevTime = "0";
    private String period = "5";
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(calendar.getTimeInMillis());
        Thw thw = new Thw();
        Map<String, Object> map = thw.buildBasicParams(cal);
        System.out.println(map);

    }

    protected Map<String, Object>  buildBasicParams(Calendar calendar) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(calendar.getTimeInMillis());

        Map<String, Object> params = new HashMap<String, Object>();

        String endTime = format.format(cal);
        // String temp = prevTime;
        String startTime;
        if (prevTime.equals("0")) {
            cal.add(Calendar.MINUTE, -Integer.parseInt(period));
            startTime = format.format(cal);
        } else {
            startTime = prevTime;
        }
        prevTime = endTime;

        params.put("STARTTIME", startTime);

		/*
		 * 测试用
		 */
        // log.info("Start Time:" + "2013-05-16 14:45:01");
        // params.put("STARTTIME", "2013-05-16 14:45:01");

        params.put("ENDTIME", endTime);

		/*
		 * 测试用
		 */
        // log.info("End Time:" + "2013-05-29 13:15:00");
        // params.put("ENDTIME", "2013-05-29 13:15:00");

        params.put("Calendar", calendar);

        return params;
    }
}
