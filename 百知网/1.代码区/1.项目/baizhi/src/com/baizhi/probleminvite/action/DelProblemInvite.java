package com.baizhi.probleminvite.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.probleminvite.service.ProblemInviteService;

/**
 * 类名：ProblemInviteDel.java<br>
 * 描述： 删除问题邀请人信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-12 11:03:45<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelProblemInvite extends ActionSupport{
	private static final long serialVersionUID = 2836642981041223146L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private ProblemInviteService problemInviteService;//问题邀请人信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public ProblemInviteService getProblemInviteService() {
		return problemInviteService;
	}

	public void setProblemInviteService(ProblemInviteService problemInviteService) {
		this.problemInviteService = problemInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = problemInviteService.deleteProblemInvite(IDS);
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