package com.fsoft.roomreservation.core.util;

public class PropertyUtil{

    public static String get(String key){
        String value = System.getProperty(key);
        return value != null ? value.trim() : null;
    }

    public static boolean getBoolean(String key){
        return Boolean.valueOf(get(key));
    }

    public static int getInt(String key){
        try { return Integer.parseInt(get(key)); }catch (NumberFormatException e) {;}
        return 0;
    }
}
