package com.baizhi.answervote.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.answervote.service.AnswerVoteService;

/**
 * 类名：AnswerVoteDel.java<br>
 * 描述： 删除问题答案投票信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-14 16:22:26<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelAnswerVote extends ActionSupport{
	private static final long serialVersionUID = 3994740268803282128L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private AnswerVoteService answerVoteService;//问题答案投票信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public AnswerVoteService getAnswerVoteService() {
		return answerVoteService;
	}

	public void setAnswerVoteService(AnswerVoteService answerVoteService) {
		this.answerVoteService = answerVoteService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = answerVoteService.deleteAnswerVote(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="问题答案投票删除成功";
			}else{
				message="问题答案投票删除失败";
			}
		}else{
			message="请选择要删除的问题答案投票";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}