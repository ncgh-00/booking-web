package com.group3.trividi.utils;

public class StringCutter {
    public static String cut(String name){
        String[] s = name.split("\\s");
        if(s.length > 2) return s[0] + " " + s[2];
        else {
            return name;
        }

    }

    public static void main(String[] args) {
        System.out.println(StringCutter.cut("a b"));
    }
}
