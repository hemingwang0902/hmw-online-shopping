package com.baizhi.ad.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.ad.service.AdService;
/**
 * 
 * 类名：AdDel.java<br>
 * 描述： 删除广告信息表信息
 * 创建者：江红
 * 创建日期：2011-06-21 00:52:07
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelAd extends ActionSupport{
	
	private static final long serialVersionUID = 2001078880364633567L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private AdService adService;//广告信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public AdService getAdService() {
		return adService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = adService.deleteAd(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="用户删除成功";
			}else{
				message="用户删除失败";
			}
		}else{
			message="请选择要删除的用户";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}