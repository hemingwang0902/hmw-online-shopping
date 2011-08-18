package com.baizhi.talk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.talk.service.TalkService;
/**
 * 
 * 类名：TalkDel.java<br>
 * 描述： 删除话题信息表信息
 * 创建者：江红
 * 创建日期：2011-06-20 23:49:03
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelTalk extends ActionSupport{
	
	private static final long serialVersionUID = 2025017751744598082L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private TalkService talkService;
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public TalkService getTalkService() {
		return talkService;
	}

	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = talkService.deleteTalk(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="话题删除成功";
			}else{
				message="话题删除失败";
			}
		}else{
			message="请选择要删除的话题";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}