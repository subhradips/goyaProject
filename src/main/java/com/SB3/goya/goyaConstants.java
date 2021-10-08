package com.SB3.goya;

public class goyaConstants {

    public static final String URL ="goya.url";
    public static final String username ="goya.username";
    public static final String password = "goya.password";
    public static final String Search_customer ="goya.search_customer";
    public static final String Pop_Up_Massage = "goya.popup";
    public static final String dropdownValue="goya.dropdownValue";
    public static final String SearchItemsValue = "goya.SearchItemsValue";

    public final static long explicitWait = 100;
    public final static long impliciteWait = 100;

    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
    public static long getExplicitwait() {
        return explicitWait;
    }
    public static long getImplicitewait() {
        return impliciteWait;
    }
}
