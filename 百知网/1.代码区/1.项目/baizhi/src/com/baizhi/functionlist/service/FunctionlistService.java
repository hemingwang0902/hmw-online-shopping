package com.baizhi.functionlist.service;

import java.util.List;
import java.util.Map;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.functionlist.dao.FunctionlistDao;
/**
 * 
 * 类名：FunctionlistService.java
 * 描述： 功能菜单表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-20 22:11:46
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class FunctionlistService extends ServiceSupport{
	
	private static final long serialVersionUID = -3804610129071399637L;
	
	private FunctionlistDao functionlistDao;
	
	public FunctionlistDao getFunctionlistDao() {
		return functionlistDao;
	}

	public void setFunctionlistDao(FunctionlistDao functionlistDao) {
		this.functionlistDao = functionlistDao;
	}
	
	/**
     * 获取功能菜单表信息
     * 
     * @param  params 参数
     * @return 成功返回功能菜单表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getFunctionlistList(Map<String, Object> params){
		return functionlistDao.getFunctionlistList(params);
	}

}
