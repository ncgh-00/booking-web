package com.group3.trividi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trans_Date {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String translate(String date) {
        String date_sql;
        try {
            Date date_input = formatter.parse(date);
            System.out.println(date_input);
            date_sql = sqlDateFormat.format(date_input);
            return date_sql;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Trans_Date tool = new Trans_Date();
        System.out.println(tool.translate("20/4/2002"));
    }
}
