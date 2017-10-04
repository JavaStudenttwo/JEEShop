package com.itheima.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MyRequest extends HttpServletRequestWrapper {

    private boolean encoded = false;

    //编码过滤器调用了此方法
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name){
        String[] all = getParameterValues(name);
        if (all == null){
            return null;
        }
        return all[0];
    }

    public String [] getParameterValues(String name){
        return getParameterMap().get(name);
    }

    public Map<String,String[]> getParameterMap(){

        //使用了装饰者模式
        Map<String ,String[]> map = super.getParameterMap();

        if (!encoded){
            if ("GET".equalsIgnoreCase(super.getMethod())){
                for (Map.Entry<String ,String[]> entry : map.entrySet()){
                    String [] allValue = entry.getValue();
                    for (int i=0; i< allValue.length;i++){
                        String encoding = super.getCharacterEncoding();
                        if (encoding == null){
                            encoding = "UTF-8";
                        }
                        try {
                            //以字节为单位，进行编码转换
                            allValue[i] = new String(allValue[i].getBytes("ISO-8859-1"),encoding);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                encoded = true;
            }
        }
        return map;
    }




















}
