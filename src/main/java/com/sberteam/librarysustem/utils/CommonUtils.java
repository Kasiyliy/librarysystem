package com.sberteam.librarysustem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String encode(String password){
        org.springframework.security.crypto.password.PasswordEncoder encoder
                = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static Date getDateFromString(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedCurrentDate = null;
        try{
            convertedCurrentDate = sdf.parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertedCurrentDate;
    }
}
