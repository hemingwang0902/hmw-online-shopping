package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userprivate.service.UserPrivateService;
/**
 * 类名： UserPrivateList.java<br>
 * 描述：  获取用户私信信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserPrivateList extends UserPrivateForm {
	
	private static final long serialVersionUID = 5554241177186132005L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "PRIVATE_ID=?", this.getPRIVATE_ID());// 私信ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 收件人ID
		this.setMap(params, "SEND_ID=?", this.getSEND_ID());// 发送人ID
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 发送内容
		this.setMap(params, "IS_READ=?", this.getIS_READ());// 是否阅读(0否、1是)
		this.setMap(params, "PPRIVATE_ID=?", this.getPPRIVATE_ID());// 父私信ID（私信、与私信回复为一张表）
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		// 查询用户私信信息表列表
		Map<String, Object> returnMap = userPrivateService.getUserPrivateList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}