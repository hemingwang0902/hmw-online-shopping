package com.baizhi.problemattention.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.problemattention.service.ProblemAttentionService;

/**
 * 类名：ProblemAttentionDel.java<br>
 * 描述： 删除问题关注信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-10 13:47:14<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelProblemAttention extends ActionSupport{
	private static final long serialVersionUID = 8282715888615962415L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private ProblemAttentionService problemAttentionService;//问题关注信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public ProblemAttentionService getProblemAttentionService() {
		return problemAttentionService;
	}

	public void setProblemAttentionService(ProblemAttentionService problemAttentionService) {
		this.problemAttentionService = problemAttentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = problemAttentionService.deleteProblemAttention(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="问题关注删除成功";
			}else{
				message="问题关注删除失败";
			}
		}else{
			message="请选择要删除的问题关注信息";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}