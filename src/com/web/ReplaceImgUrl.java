package com.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceImgUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String msg = "����@Ҧҥ:/fe037 asdfadfs   /fe039         2013-07-06 10:57:06";
         System.out.println(msg);
	}

	public static String replaceImgUrl(String msg){
		//ͨ��compile������������Patternʵ��   
        Pattern pattern=Pattern.compile("/fe\\d{3}");   
        //ͨ��match��������Matcherʵ��   
        Matcher matcher=pattern.matcher(msg);   
        while (matcher.find())//���ҷ���pattern���ַ���   
        {   
            msg = msg.replace(matcher.group(), "public/images/web"+matcher.group()+".png");
        }   
        return msg;
	}
}
