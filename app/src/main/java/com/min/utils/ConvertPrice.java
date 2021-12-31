package com.min.utils;

import java.text.DecimalFormat;

public class ConvertPrice {
    /**
     * ###### change to ###,###
     * */
    public static String priceAddDot(String price) {
        return priceAddDot(Integer.parseInt(price));
    }

    public static String priceAddDot(int price) {
        if(price < 999){
            return String.valueOf(price);
        } else {
            DecimalFormat df = new DecimalFormat("###,###");
            return df.format(price);
        }
    }

    /**
     * ###,### change to ######
     * */
    public static String priceDelDot(String price) {
        return price.replaceAll(",", "");
    }
}
