package com.erp.production.ssm.util;




import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HorseXInsect
 * 2019/5/20 15:20
 */
// String 转 Date
public class DateUtils implements Converter<String, Date> {

    @Override
    public Date convert(String value) {
        //System.out.println("value=" + value);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(value);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
