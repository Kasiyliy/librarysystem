package com.sberteam.librarysustem.utils;

public class CommonUtils {

    public static String encode(String password){
        org.springframework.security.crypto.password.PasswordEncoder encoder
                = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
