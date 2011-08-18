package com.baizhi.answerreview.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.answerreview.service.AnswerReviewService;

/**
 * 类名：AnswerReviewDel.java<br>
 * 描述： 删除问题答案评论信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-14 16:22:27<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelAnswerReview extends ActionSupport{
	private static final long serialVersionUID = -3358389522786805342L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private AnswerReviewService answerReviewService;//问题答案评论信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public AnswerReviewService getAnswerReviewService() {
		return answerReviewService;
	}

	public void setAnswerReviewService(AnswerReviewService answerReviewService) {
		this.answerReviewService = answerReviewService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = answerReviewService.deleteAnswerReview(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="问题答案评论删除成功";
			}else{
				message="问题答案评论删除失败";
			}
		}else{
			message="请选择要删除的问题答案评论";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}