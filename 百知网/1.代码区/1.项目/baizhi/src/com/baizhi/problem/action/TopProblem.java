package com.baizhi.problem.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.problem.service.ProblemService;
/**
 * 
 * 类名：TopProblem.java<br>
 * 描述： 置顶问题信息表信息
 * 创建者：江红
 * 创建日期：2011-06-21 00:45:57
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class TopProblem extends ActionSupport{
	
	private static final long serialVersionUID = -5601922626666464673L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private String IS_TOP;//是否置顶(0：否、1：是)
	
	private ProblemService problemService;//问题信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public String getIS_TOP() {
		return IS_TOP;
	}

	public void setIS_TOP(String is_top) {
		IS_TOP = is_top;
	}

	public ProblemService getProblemService() {
		return problemService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = problemService.topProblem(IDS,IS_TOP);
			//判断删除是否成功
			if(result){
				flag=true;
				message="问题置顶成功";
			}else{
				message="问题置顶失败";
			}
		}else{
			message="请选择要置顶问题";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}