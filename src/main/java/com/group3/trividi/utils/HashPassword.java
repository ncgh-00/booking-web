package com.group3.trividi.utils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class HashPassword {
    public static String getHashedPassword(String password) {
        String myHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (Exception e){
            System.out.println(e);
        }

    return  myHash;
    }

    public static void main(String[] args)  {
        System.out.println(HashPassword.getHashedPassword("123456"));
    }

}
