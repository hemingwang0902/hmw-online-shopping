package com.baizhi.diclist.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.diclist.service.DiclistService;
/**
 * 
 * 类名：DiclistDel.java<br>
 * 描述： 删除字典列表信息
 * 创建者：江红
 * 创建日期：2011-06-22 21:19:11
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelDiclist extends ActionSupport{
	
	private static final long serialVersionUID = -5317947817789204569L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private DiclistService diclistService;//字典列表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public DiclistService getDiclistService() {
		return diclistService;
	}

	public void setDiclistService(DiclistService diclistService) {
		this.diclistService = diclistService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = diclistService.deleteDiclist(IDS);
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