package com.baizhi.problemcollection.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.problemcollection.service.ProblemCollectionService;

/**
 * 类名：ProblemCollectionDel.java<br>
 * 描述： 删除问题收藏信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-10 13:47:13<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelProblemCollection extends ActionSupport{

	private static final long serialVersionUID = -1839093626673888152L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private ProblemCollectionService problemCollectionService;//问题收藏信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public ProblemCollectionService getProblemCollectionService() {
		return problemCollectionService;
	}

	public void setProblemCollectionService(ProblemCollectionService problemCollectionService) {
		this.problemCollectionService = problemCollectionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = problemCollectionService.deleteProblemCollection(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="问题收藏删除成功";
			}else{
				message="问题收藏删除失败";
			}
		}else{
			message="请选择要删除的问题收藏信息";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}