package com.group3.trividi.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateProcessor {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static long duration(String now, String late) {
        long duration;
        now = now.replace("/", "-");
        late = late.replace("/", "-");
        System.out.println(now);
        System.out.println(late);
        LocalDate localDate = LocalDate.parse(now);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        Instant n = localDateTime.toInstant(ZoneOffset.UTC);
        localDate = LocalDate.parse(late);
        localDateTime = localDate.atStartOfDay();
        Instant l = localDateTime.toInstant(ZoneOffset.UTC);
        duration = ChronoUnit.DAYS.between(n, l);

        return duration;
    }

    public boolean isLogicDate(String dateS) {
        Date date = new Date();
        String dateN = formatter.format(date);

        if (duration(dateN, dateS) >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DateProcessor tool = new DateProcessor();
        System.out.println(tool.isLogicDate("2022-07-01"));
    }
}
