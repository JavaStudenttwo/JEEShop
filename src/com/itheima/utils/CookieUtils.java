package com.itheima.utils;

import javax.servlet.http.Cookie;

/**
 * Created by 13718 on 2017/8/31.
 */
public class CookieUtils {
    public static Cookie findCookie(Cookie[] allCookie ,String cookieName){
        if (cookieName == null){
            return null;
        }
        if (allCookie != null){
            for (Cookie c : allCookie){
                if (cookieName.equals(c.getName())){
                    return c;
                }
            }
        }
        return null;
    }
}
