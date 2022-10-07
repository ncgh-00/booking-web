package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.DayProfit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Statistic_DAO {

    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;
    String sql;

    private HashMap<Integer,String> dicMonth(){
        HashMap<Integer,String> dic = new HashMap<>();
        dic.put(1,"January");
        dic.put(2,"February ");
        dic.put(3,"March");
        dic.put(4,"April");
        dic.put(5,"May");
        dic.put(6,"June");
        dic.put(7,"July");
        dic.put(8,"August");
        dic.put(9,"September");
        dic.put(10,"October");
        dic.put(11,"November");
        dic.put(12,"December");
        return dic;
    }

    public HashMap<String,Double> getData(Integer year,Integer month){
        HashMap<String,Double> frame = new HashMap<>();
        HashMap<Integer,String> dic = dicMonth();
        if(year != null && month ==  null){
            sql = "select Month,(sum)Total from [Statistic]\n" +
                    "where year = "+ year +" group by Month " +" order by Month";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                     frame.put(dic.get(rs.getInt(1)),rs.getInt(2)/24000*0.001);
                }

                System.out.println("ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return frame;
    }


    public DayProfit getTotalInDay() {

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
                return new DayProfit(rs.getInt(1), rs.getInt(2)/24000*0.001);
            }
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DayProfit(0,0);
    }

    public double getAllProfits(){
        sql = "select sum(Total) from [Statistic]";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1)/24000*0.001;
            }
            System.out.println("ok");
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
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return 0;
    }

    public static void main(String[] args) {
        Statistic_DAO dao = new Statistic_DAO();
        System.out.println(dao.getTotalInDay().getNumberBooks());
    }
}
