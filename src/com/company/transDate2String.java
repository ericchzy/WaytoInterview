package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class transDate2String {
    private static String tranDate2String(Date date) {
        if (date == null) return null;
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(date);
    }

    private static final int REQUIRED_LENGTH = 10;
    private static String FormatString(String str) {
        if (str == null) return null;

        String result = null;

        if (str.length() > REQUIRED_LENGTH)
            result = str.substring(str.length() - REQUIRED_LENGTH, str.length());
        else {
            int strLen = str.length();
            while (strLen < REQUIRED_LENGTH) {
                StringBuilder sb = new StringBuilder();
                str = sb.append("0").append(str).toString();
                strLen = str.length();
            }
            result = str;
        }

        return result;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(tranDate2String(date));

        System.out.println(FormatString("12345678901"));
        System.out.println(FormatString("1111"));
        System.out.println(FormatString(""));
    }
}
