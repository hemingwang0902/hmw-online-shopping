package com.baizhi.functionlist.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.functionlist.service.FunctionlistService;
/**
 * 类名： FunctionlistList.java<br>
 * 描述：  获取功能菜单表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-20 22:11:46
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetFunctionlistList extends ActionSupport {
	
	private static final long serialVersionUID = 9154970976510568055L;
	
	private FunctionlistService functionlistService;//功能菜单表业务类
	
	public FunctionlistService getFunctionlistService() {
		return functionlistService;
	}

	public void setFunctionlistService(FunctionlistService functionlistService) {
		this.functionlistService = functionlistService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		//设置查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		this.setMap(params, "PARENT_FLID=?", "0");// 父功能ID
		
		//获取父ID为0的功能菜单
		List<Map<String, Object>> list = functionlistService.getFunctionlistList(params);
		StringBuffer content=new StringBuffer();
		content.append("<ul>");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> nodes = list.get(i);
			String FUNCLIST_ID=String.valueOf(nodes.get("FUNCLIST_ID"));
			String FUNC_NAME=String.valueOf(nodes.get("FUNC_NAME"));
			String IS_CHILD=String.valueOf(nodes.get("IS_CHILD"));
			String FUNC_URL=String.valueOf(nodes.get("FUNC_URL"));
			if(IS_CHILD!=null&&IS_CHILD.equals("0")){
				content.append("<li><a onclick=\"addTab('"+FUNC_NAME+"','"+FUNC_URL+"')\">"+FUNC_NAME+"</a></li>");
			}else{
				content.append("<li><a href='javascript:;'>"+FUNC_NAME+"</a>");
				//获取子菜单
				content.append(getChildNodes(FUNCLIST_ID));
				content.append("</li>");
			}  
		}
		content.append("</ul><br style='clear: left' />");
		
		returnMap.put("content", content.toString());
		this.setResult(returnMap);
		return JSONSUCCESS;
		
	}
	
	/**
	 * 获取子节点
	 * @param PARAM_FUNCLIST_ID 功能父ID
	 * @return
	 */
	private String getChildNodes(String PARAM_FUNCLIST_ID){
		StringBuffer content=new StringBuffer();
		//获取父ID为FUNCLIST_ID的功能菜单
		Map<String, Object> params = new HashMap<String, Object>();
		this.setMap(params, "PARENT_FLID=?", PARAM_FUNCLIST_ID);
		List<Map<String, Object>> list = functionlistService.getFunctionlistList(params);
		content.append("<ul>");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> nodes = list.get(i);
			String FUNCLIST_ID=String.valueOf(nodes.get("FUNCLIST_ID"));
			String FUNC_NAME=String.valueOf(nodes.get("FUNC_NAME"));
			String IS_CHILD=String.valueOf(nodes.get("IS_CHILD"));
			String FUNC_URL=String.valueOf(nodes.get("FUNC_URL"));
			if(IS_CHILD!=null&&IS_CHILD.equals("0")){
				content.append("<li><a onclick=\"addTab('"+FUNC_NAME+"','"+FUNC_URL+"')\">"+FUNC_NAME+"</a></li>");
			}else{
				content.append("<li><a href='javascript:;'>"+FUNC_NAME+"</a>");
				//获取子菜单
				content.append(getChildNodes(FUNCLIST_ID));
				content.append("</li>");
			}  
		}
		content.append("</ul>");
		return content.toString();
	}
	
}