package com.group3.trividi.utils;

public class Validation {
    public static boolean validEmail(String email) {
        if (!email.isEmpty()) {
            if (email.matches("^[a-zA-z]+\\w*([.-_]\\w+)*\\@[a-zA-Z]+\\w*([.-_]\\w+)*(\\.\\w+)+$")) {
                return true;
            }
            return false;
        }

        return true;
    }

    public static boolean validPhone(String phone) {
        if (!phone.isEmpty()) {
            if (phone.matches("^0[1-9]\\d{8,10}$")) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean validLocation(String location) {
        if (!location.isEmpty()) {
            if (location.matches("^[\\.0-9]*$")) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Validation.validLocation("20.95459478953557"));
    }
}
