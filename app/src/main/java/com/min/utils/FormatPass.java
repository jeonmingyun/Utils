package com.min.utils;

import java.util.regex.Pattern;

public class FormatPass {
    /**
     * password format : 8~12자, 영문, 숫자 포함
     */
    public static boolean passRule(String pass) {
        String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]$@!%*#?&]{8,12}$";
        return Pattern.matches(pwPattern, pass);
    }
}