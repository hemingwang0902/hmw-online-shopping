package com.baizhi.talktype.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.talk.service.TalkService;
import com.baizhi.talktype.service.TalktypeService;
/**
 * 
 * 类名：TalktypeDel.java<br>
 * 描述： 删除话题类型表信息
 * 创建者：江红
 * 创建日期：2011-08-13 22:34:26
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelTalktype extends ActionSupport{
	
	private static final long serialVersionUID = -5964683104827285190L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private TalktypeService talktypeService;//话题类型表业务类
	
	private TalkService talkService;
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public TalktypeService getTalktypeService() {
		return talktypeService;
	}

	public void setTalktypeService(TalktypeService talktypeService) {
		this.talktypeService = talktypeService;
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
			//获取话题类型
			
			Map<String, Object> talkmap=new HashMap<String, Object>();
			talkmap.put("TALKTYPE_ID=?", IDS);
			int count=talkService.getTalkCount(talkmap);
			if(count>0){
				//删除话题类型
				boolean result = talktypeService.deleteTalktype(IDS);
				//判断删除是否成功
				if(result){
					flag=true;
					message="话题类型删除成功";
				}else{
					message="话题类型删除失败";
				}
			}
			
		}else{
			message="请选择要删除的话题类型";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}