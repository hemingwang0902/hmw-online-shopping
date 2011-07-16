package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.ip.IPSeeker;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 类名： Regiest.java<br>
 * 描述：注册<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-13 上午01:03:04<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Regiest  extends UserForm{
	
	private static final long serialVersionUID = 5467791910146539619L;
	
	private UserService  userService;//用户信息表业务类
	
	private String NAME;//姓名
	
	private String INTRODUCTION;//个人简介
	
	private String PROVINCE;//省
	
	private String CITY;//市
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setNAME(String name) {
		NAME = name;
	}
	
	public void setINTRODUCTION(String introduction) {
		INTRODUCTION = introduction;
	}
	
	public void setPROVINCE(String province) {
		PROVINCE = province;
	}
	
	public void setCITY(String city) {
		CITY = city;
	}

	@Override
	public String execute() throws Exception {
		Integer WAS_USERID=-1;
		//获取邀请人ID
		if(this.getUSER_ID()!=null&&!this.getUSER_ID().trim().equals("")){
			try {
				Integer temp_user_id=Integer.parseInt(Encrypt.decodeBase64(this.getUSER_ID()));
				
				Map<String,Object> params=new HashMap<String, Object>();
				params.put("USER_ID=?",temp_user_id);
				int count=userService.getUserCount(params);
				if(count>0){
					WAS_USERID=temp_user_id;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//获取IP地址
		HttpServletRequest request = ServletActionContext.getRequest();
		IPSeeker ipSeeker = IPSeeker.getInstance();
		String IP = ipSeeker.getRemoteAddr(request);
		
		//组织用户实体
		Element userelement = new DefaultElement("T_USER");
		Elements.setElementValue(userelement, "USER_TYPE", 1);
		Elements.setElementValue(userelement, "EMAIL", this.getEMAIL());
		Elements.setElementValue(userelement, "PASSWORD",  Encrypt.edcryptMD5(this.getPASSWORD()));
		Elements.setElementValue(userelement, "REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
		Elements.setElementValue(userelement, "IP", IP);
		Elements.setElementValue(userelement, "MAC", this.getMAC());
		
		//组织基本信息实体
		Element element = new DefaultElement("T_USER_BASIC");
		Elements.setElementValue(element, "USER_TYPE", 1);// 用户类型(字典：1用户、2品牌)冗余字段
		Elements.setElementValue(element, "NAME", NAME);// 姓名/品牌名称
		Elements.setElementValue(element, "INTRODUCTION", INTRODUCTION);// 个人介绍/品牌介绍
		Elements.setElementValue(element, "PRIVATE_SET", 2);// 私信设置(字典：1所有人、2我关注的人)
		Elements.setElementValue(element, "PROVINCE", PROVINCE);//省
		Elements.setElementValue(element, "CITY", CITY);//市
		Elements.setElementValue(element, "LEVEL", 0);// 级别
		Elements.setElementValue(element, "SCORE", 0);// 积分
		Elements.setElementValue(element, "CREATE_TIME",DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		Map<String, Object> returnMap = userService.regiest(userelement, element,WAS_USERID);
		if(returnMap!=null&&!this.getValue(returnMap, "USER_ID").equals("")){
			returnMap.put("NAME", NAME);
			returnMap.put("EMAIL", this.getEMAIL());
			returnMap.put("REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			returnMap.put("USER_TYPE", this.getUSER_TYPE());
			returnMap.put("REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			returnMap.put("LAST_LOGINTIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			returnMap.put("IP", IP);
			
			//获取Session对象
			HttpSession session = request.getSession();
			//将值设置到Session对象中
			session.setAttribute("userinfo", returnMap);
			session.setAttribute("USER_ID", returnMap.get("USER_ID"));
			return SUCCESS;
		}
		return ERROR;
	}
}
