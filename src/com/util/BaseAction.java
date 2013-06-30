package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -32431L;
	public static final int SAVE = 0;
	public static final int UPDATE = 1;
	protected final String CUSTOM = "custom";
	private boolean listFlag = false;
	private int editState;// 标示返回到创建页面还是编辑修改页面：0 新建 ；1修改
	public String menuId;// 页面权限菜单使用
	private String error;// 页面消息显示
	private int token;
	private String target;
	public HttpServletRequest request = ServletActionContext.getRequest();
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	public int getEditState() {
		return editState;
	}

	public void setEditState(int editState) {
		this.editState = editState;
	}

	public boolean isListFlag() {
		return listFlag;
	}

	public void setListFlag(boolean listFlag) {
		this.listFlag = listFlag;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	protected String render(String _target) {
		setTarget(_target);
		return CUSTOM;
	}

	/**
	 * 32位的md5加密
	 * 
	 * @param str
	 * @return
	 */
	public String toMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
