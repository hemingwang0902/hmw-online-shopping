package com.baizhi.user.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：    SaveUser.java
 * 描述：    新增或者修改用户信息表信息
 * 创建者：  江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：    V0.9
 * 修改者：  
 * 修改日期：
 */
public class SaveUser extends UserForm{

	private static final long serialVersionUID = -8075832185081472628L;
	
	private UserService  userService;//用户信息表业务类
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户ID为""，则为新增用户信息表，否则更新用户信息表
		if(StringUtils.isNotEmpty(this.getUSER_ID())){
			element = userService.getUserEleById("USER_ID");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());
			Elements.setElementValue(element, "EMAIL", this.getEMAIL());
			Elements.setElementValue(element, "PASSWORD", this.getPASSWORD());
			Elements.setElementValue(element, "REG_TIME", this.getREG_TIME());
			Elements.setElementValue(element, "LAST_LOGINTIME", this.getLAST_LOGINTIME());
			Elements.setElementValue(element, "IP", this.getIP());
			Elements.setElementValue(element, "MAC", this.getMAC());
			Elements.setElementValue(element, "LAST_FREEZETIME", this.getLAST_FREEZETIME());
			
			//如果保存成功，返回主键
			keyid = userService.saveOrUpdateUser(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER");
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());
			Elements.setElementValue(element, "EMAIL", this.getEMAIL());
			Elements.setElementValue(element, "PASSWORD", this.getPASSWORD());
			Elements.setElementValue(element, "REG_TIME", this.getREG_TIME());
			Elements.setElementValue(element, "LAST_LOGINTIME", this.getLAST_LOGINTIME());
			Elements.setElementValue(element, "IP", this.getIP());
			Elements.setElementValue(element, "MAC", this.getMAC());
			Elements.setElementValue(element, "LAST_FREEZETIME", this.getLAST_FREEZETIME());
			//如果保存成功，返回主键
			keyid = userService.saveOrUpdateUser(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
}
