package com.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceImgUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String msg = "│●爱@姚谣:/fe037 asdfadfs   /fe039         2013-07-06 10:57:06";
         System.out.println(msg);
	}

	public static String replaceImgUrl(String msg){
		//通过compile（）方法创建Pattern实例   
        Pattern pattern=Pattern.compile("/fe\\d{3}");   
        //通过match（）创建Matcher实例   
        Matcher matcher=pattern.matcher(msg);   
        while (matcher.find())//查找符合pattern的字符串   
        {   
            msg = msg.replace(matcher.group(), "public/images/web"+matcher.group()+".png");
        }   
        return msg;
	}
}
