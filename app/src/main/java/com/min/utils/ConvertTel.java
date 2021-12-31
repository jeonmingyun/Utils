package com.min.utils;

public class ConvertTel {
    /**
     * @param tel 010-1111-2222
     * @return 01011112222
     */
    public static String formatDelBar(String tel) {
        if (tel == null) {
            return "";
        }

        return tel.replaceAll("-", "");
    }

    /**
     * @param tel 01011112222
     * @return 010-1111-2222
     */
    public static String formatAddBar(String tel) {
        if (tel == null) {
            return "";
        }

        if (tel.length() == 12) {
            return tel.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
        } else if (tel.length() == 8) {
            return tel.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
        }
        return tel.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    }
}
