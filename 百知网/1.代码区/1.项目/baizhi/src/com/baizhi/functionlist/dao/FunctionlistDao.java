package com.baizhi.functionlist.dao;

import java.util.List;
import java.util.Map;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：FunctionlistDao.java
 * 描述：功能菜单表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-20 22:11:46
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class FunctionlistDao extends DaoSupport{
	
	
	/**
     * 获取功能菜单表信息
     * 
     * @param  params 参数
     * @return 成功返回功能菜单表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getFunctionlistList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.FUNCLIST_ID as FUNCLIST_ID,")//功能ID
		   .append("a.FUNC_NAME as FUNC_NAME,")//功能名称
		   .append("a.FUNC_URL as FUNC_URL,")//功能URL
		   .append("a.PARENT_FLID as PARENT_FLID,")//父功能ID
		   .append("a.FUNC_ORDER as FUNC_ORDER,")//显示顺序
		   .append("a.FUNC_STATUS as FUNC_STATUS,")//是否启用(0停用1启用)
		   .append("a.ACC_LIMIT as ACC_LIMIT,")//是否有资源限制(0无,1有)
		   .append("a.IS_CHILD as IS_CHILD,")//是否有下级菜单(0无,1有)
		   .append("a.FUNC_DESC as FUNC_DESC,")//功能说明
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_FUNCTIONLIST a where FUNC_STATUS=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions()+" order by a.PARENT_FLID,a.FUNC_ORDER ");
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

