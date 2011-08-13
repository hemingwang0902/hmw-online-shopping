package com.baizhi.talktype.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.talktype.service.TalktypeService;

/**
 * 类名： SettingTalktype.java<br>
 * 描述：设置话题类型<br>
 * 创建者：江红<br>
 * 创建日期：2011-8-14 上午12:04:41<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SettingTalktype extends ActionSupport{
	
	private static final long serialVersionUID = -5964683104827285190L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private String TYPE;//类型
	
	private String TALKTYPE_ID;//话题类型
	
	private TalktypeService talktypeService;//话题类型表业务类
	
	
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
	

	public String getTALKTYPE_ID() {
		return TALKTYPE_ID;
	}

	public void setTALKTYPE_ID(String talktype_id) {
		TALKTYPE_ID = talktype_id;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String type) {
		TYPE = type;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//取消、设置话题类型
			int count = talktypeService.setTalktype(IDS,TYPE,TALKTYPE_ID);
			//判断取消、设置是否成功
			if(count>0){
				if(TYPE.equals("1")){
					flag=true;
					message="话题类型取消成功";
				}else{
					flag=true;
					message="话题类型设置成功";
				}
				
			}else{
				if(TYPE.equals("1")){
					message="话题类型取消失败";
				}else{
					message="话题类型设置失败";
				}
			}
			
		}else{
			if(TYPE.equals("1")){
				message="请选择取消话题类型";
			}else{
				message="请选择设置话题类型";
			}
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}
