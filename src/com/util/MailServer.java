package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;

public class MailServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailServer mailServer = new MailServer();
		 String str="";  

		        boolean bool=true;  

		        Runtime run=Runtime.getRuntime();  

		        Properties props = new Properties();  

		        props.setProperty("mail.smtp.host", "smtp.163.com");  

		        props.setProperty("mail.smtp.auth", "true");  

		        Session session = Session.getDefaultInstance(props,null);  

		        URLName urlname = new URLName("pop3","pop.163.com",110,null,"deng3090@163.com","jdfy012306");  

		        Date nowtime;  

		        while(true)  

		        {  

		            nowtime=new Date();  

		            SimpleDateFormat dft= new SimpleDateFormat("yyyy-MM-dd");  

		            Calendar da=Calendar.getInstance();  

		            da.setTime(nowtime);  

		            da.get(Calendar.MINUTE);  

		            if(bool)  

		            {  

		                Store store;  

		                bool=false;  

		                try {  

		                    store = session.getStore(urlname);  

		                    store.connect();  

		                    Folder folder = store.getFolder("INBOX");  

		                    folder.open(Folder.READ_WRITE);  

		                    Message msgs[] = folder.getMessages();  

		                    int count = msgs.length;  

		                    System.out.println("Message Count:"+count);  

		                  System.out.println("�һ������أ��������ʼ�"+count+"�⣡");  

		                    ReciveMail rm = null;  
		                    for(int i=count-1;i>0;i--){  
		                        rm = new ReciveMail((MimeMessage) msgs[i]);  
                                if(!rm.isNew()){
                                	System.out.println(rm.getSubject());
                                } 
		                    }  
		                    folder.close(true);  
		                    if(!str.equals(""))  

		                    {  

		                       System.out.println(str);  

		                        run.exec(str);  

		                        run.gc();  

		                        str="";  

		                    }  

		                } catch (Exception e) {  

		                    // TODO Auto-generated catch block  

		                    e.printStackTrace();  

		                    System.out.println(e.getMessage());  

		                    bool=true;  

		                }  

		            }  

		            else if(da.get(Calendar.MINUTE)%5!=0)  

		            {  

		                bool=true;  

		            }  

		            try {  

		                Thread.sleep(5000);  

		            } catch (InterruptedException e) {  

		                // TODO Auto-generated catch block  

		                e.printStackTrace();  

		                System.out.println(e.getMessage());               

		            }  

		        }  

		    }  

		
	}

