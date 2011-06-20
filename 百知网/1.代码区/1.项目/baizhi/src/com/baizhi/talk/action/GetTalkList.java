package com.baizhi.talk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.talk.service.TalkService;
/**
 * 类名： TalkList.java<br>
 * 描述：  获取话题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetTalkList extends TalkForm {
	
	private static final long serialVersionUID = -8472641085073099878L;
	
	private TalkService talkService;//话题信息表业务类
	
	public TalkService getTalkService() {
		return talkService;
	}

	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "TALK_ID=?", this.getTALK_ID());// 话题ID
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 内容
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询话题信息表列表
		Map<String, Object> returnMap = talkService.getTalkList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}