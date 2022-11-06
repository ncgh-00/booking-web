package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.StatisticWeb;
import com.group3.trividi.model.Statistic_Rate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Statistic_DAO {

    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;
    String sql;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat dfr = new DecimalFormat("0.0");
    private HashMap<String,String> dicMonth(){
        HashMap<String,String> dic = new HashMap<>();
        dic.put("01","January");
        dic.put("02","February ");
        dic.put("03","March");
        dic.put("04","April");
        dic.put("05","May");
        dic.put("06","June");
        dic.put("07","July");
        dic.put("08","August");
        dic.put("09","September");
        dic.put("10","October");
        dic.put("11","November");
        dic.put("12","December");
        return dic;
    }

    public HashMap<String,StatisticWeb> getData(String year,String month){
        System.out.println(year + month);
        LinkedHashMap <String,StatisticWeb> frame = new LinkedHashMap<>();
        HashMap<String,String> dic = dicMonth();
        if(year != null && !year.trim().isEmpty() && (month ==  null|| month.trim().isEmpty())){
            System.out.println("1");
            sql = "select Month,sum(Total),sum(number_of_book) from [Statistic]\n" +
                    "where year = "+ year +" group by Month " +" order by Month";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(dic.get(rs.getString(1)),new StatisticWeb(rs.getInt(3),Double.parseDouble(df.format((rs.getDouble(2)*0.001)))));
                }

                System.out.println("ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if((year == null && month == null) || (year.trim().isEmpty() && month.trim().isEmpty())){
            System.out.println(2);
            year = String.valueOf(java.time.LocalDate.now()).substring(0,4);
            sql = "select Month,sum(Total),sum(number_of_book) from [Statistic]\n" +
                    "where year = "+ year +" group by Month " +" order by Month";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(dic.get(rs.getString(1)),new StatisticWeb(rs.getInt(3),Double.parseDouble(df.format((rs.getDouble(2)*0.001)))));
                }

                System.out.println("ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(year != null && month != null && !year.trim().isEmpty() && !month.trim().isEmpty()){
            System.out.println(3);
            sql = "select Day,Month,sum(Total),sum(number_of_book) from [Statistic]\n" +
                    "where year = "+ year +" and Month = "+ month +"group by Day,Month order by Day";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(rs.getString(1)+"/"+rs.getString(2),new StatisticWeb(rs.getInt(4),Double.parseDouble(df.format((rs.getDouble(3)*0.001)))));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return frame;
    }

    public HashMap<String,StatisticWeb> getData(String id,String year,String month){
        System.out.println(year + month);
        LinkedHashMap <String,StatisticWeb> frame = new LinkedHashMap<>();
        HashMap<String,String> dic = dicMonth();
        if(year != null && !year.trim().isEmpty() && (month ==  null|| month.trim().isEmpty())){
            System.out.println("1");
            sql = "select Month,sum(Total),sum(number_of_book) from [Statistic_Hotel]\n" +
                    "where year = "+ year +" and [ID_Hotel] = "+id+" group by Month " +" order by Month";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(dic.get(rs.getString(1)),new StatisticWeb(rs.getInt(3),Double.parseDouble(df.format((rs.getDouble(2))))));
                }

                System.out.println("ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if((year == null && month == null) || (year.trim().isEmpty() && month.trim().isEmpty())){
            System.out.println(2);
            year = String.valueOf(java.time.LocalDate.now()).substring(0,4);
            sql = "select Month,sum(Total),sum(number_of_book) from [Statistic_Hotel]\n" +
                    "where year = "+ year +" and [ID_Hotel] = "+id+" group by Month " +" order by Month";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(dic.get(rs.getString(1)),new StatisticWeb(rs.getInt(3),Double.parseDouble(df.format((rs.getDouble(2))))));
                }

                System.out.println("ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(year != null && month != null && !year.trim().isEmpty() && !month.trim().isEmpty()){
            System.out.println(3);
            sql = "select Day,Month,sum(Total),sum(number_of_book) from [Statistic_Hotel]\n" +
                    "where year = "+ year +" and [ID_Hotel] = "+id+" and Month = "+ month +"group by Day,Month order by Day";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    frame.put(rs.getString(1)+"/"+rs.getString(2),new StatisticWeb(rs.getInt(4),Double.parseDouble(df.format((rs.getDouble(3))))));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return frame;
    }

    public StatisticWeb getTotalInDay() {

        String dt = String.valueOf(java.time.LocalDate.now());
        String year = dt.substring(0, 4);
        String month = dt.substring(5, 7);
        String day = dt.substring(8, 10);
        sql = "select Number_Of_Book,Total from [Statistic] " +
        "where year = "+ year+ " and month = "+month+"  and Day = "+day;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new StatisticWeb(rs.getInt(1), Double.parseDouble(df.format(rs.getDouble(2)*0.001)));
            }
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StatisticWeb(0,0);
    }

    public StatisticWeb getTotalInDay(String id) {

        String dt = String.valueOf(java.time.LocalDate.now());
        String year = dt.substring(0, 4);
        String month = dt.substring(5, 7);
        String day = dt.substring(8, 10);
        sql = "select Number_Of_Book,Total from [Statistic_Hotel] " +
                "where year = "+ year+" and [ID_Hotel] = "+ id+" and month = "+month+"  and Day = "+day;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new StatisticWeb(rs.getInt(1), Double.parseDouble(df.format(rs.getDouble(2))));
            }
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StatisticWeb(0,0);
    }

    public double getAllProfits(){
        sql = "select sum(Total) from [Statistic]";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return Double.parseDouble(dfr.format(rs.getDouble(1)*0.001));
            }
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return 0;
    }

    public double getAllProfits(String id){
        sql = "select sum(Total) from [Statistic_Hotel] where [ID_Hotel] = "+ id +" group by ID_Hotel ";
        System.out.println(sql);
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return Double.parseDouble(dfr.format(rs.getDouble(1)));
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return 0;
    }

    public int getNumberOfBooks(){
        sql = "select count([ID_Booking]) from [Booking] where [Confirm] = 1";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return 0;
    }

    public int getNumberOfBooks(String id){
        sql = "select count([ID_Booking]) from [Manage_Booking] where [Confirm] = 1 and [ID_Hotel] = "+ id +" group by ID_Hotel";
        System.out.println(sql);
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            System.out.println(rs.getInt(1));

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return 0;
    }

    public Statistic_Rate getRateStatistic (String id_hotel) {
        sql = "select COUNT(ID_Hotel) as NumOfRate, sum(NumberOfStars) as NumOfStar from Rate_View \n" +
                "where ID_Hotel = "+ id_hotel+ " \n"+
                "group by ID_Hotel";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Statistic_Rate(rs.getInt(1),Double.parseDouble(dfr.format(rs.getDouble(2)/rs.getInt(1))));
            }
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return null;
    }

    public static void main(String[] args) {
        Statistic_DAO dao = new Statistic_DAO();
        System.out.println(dao.getRateStatistic("2"));
    }
}
