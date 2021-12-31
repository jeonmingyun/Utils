package com.min.utils;

import com.google.gson.GsonBuilder;

public class JsonConvertible {
    /**
     * json, DTO -> String
     */
    public String toJson() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

    /**
     * String -> json, DTO
     */
    public JsonConvertible fromJson(String str) {
        if (str == null || str.length() == 0) {
            return this;
        }
        return new GsonBuilder().setPrettyPrinting().create().fromJson(str, this.getClass());
    }

    public JsonConvertible getClone() {
        return fromJson(toJson());
    }
}
