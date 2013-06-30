package com.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.util.BaseAction;
import com.web.entity.UserBean;

public class IndexAction extends BaseAction{

	private int cnum = 20;
	private int eid = 2314;
	private int pagesize;
	List<UserBean> list = new ArrayList<UserBean>();
	
	public String getIndexData(){
		for (int i = 0; i < 100; i++) {
			UserBean bean = new UserBean();
			bean.setUsername("天外來客====="+i);
			bean.setMobilephone("13698698745====="+i);
			list.add(bean);
		}
		return render("tld");
	}

	public void getJsonData(){
		try {
			HttpServletResponse res = ServletActionContext.getResponse();
			PrintWriter out = res.getWriter();
			for (int i = 0; i < 100; i++) {
				UserBean bean = new UserBean();
				bean.setUsername("天外來客====="+i);
				bean.setMobilephone("13698698745====="+i);
				list.add(bean);
			}
			  Gson gson = new Gson();
              String json = gson.toJson(list);
              System.out.println(json);
              out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public int getCnum() {
		return cnum;
	}


	public void setCnum(int cnum) {
		this.cnum = cnum;
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public List<UserBean> getList() {
		return list;
	}


	public void setList(List<UserBean> list) {
		this.list = list;
	}
	
}
