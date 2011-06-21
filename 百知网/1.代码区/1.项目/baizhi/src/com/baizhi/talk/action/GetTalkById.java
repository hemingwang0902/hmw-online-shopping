package com.baizhi.talk.action;

import java.util.Map;
import com.baizhi.talk.service.TalkService;
/**
 * 
 * 类名：GetTalkById.java
 * 描述： 获取单条话题信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetTalkById extends TalkForm{
	
	private static final long serialVersionUID = -552844046939142738L;
	
	private TalkService talkService;//话题信息表业务类
	
	public TalkService getTalkService() {
		return talkService;
	}

	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = talkService.getTalkMapById(this.getTALK_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 内容
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
