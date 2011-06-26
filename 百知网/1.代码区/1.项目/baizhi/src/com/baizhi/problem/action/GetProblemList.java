package com.baizhi.problem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.problem.service.ProblemService;
/**
 * 类名： ProblemList.java<br>
 * 描述：  获取问题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetProblemList extends ProblemForm {
	
	private static final long serialVersionUID = 1380685447612376837L;
	
	private ProblemService problemService;//问题信息表业务类
	
	private String CREATE_TIME_END;// 创建时间(止)
	
	public ProblemService getProblemService() {
		return problemService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	public String getCREATE_TIME_END() {
		return CREATE_TIME_END;
	}

	public void setCREATE_TIME_END(String create_time_end) {
		CREATE_TIME_END = create_time_end;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "PROBLEM_TYPE=?", this.getPROBLEM_TYPE());// 问题类型(字典：1普通、2我问的问题)
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 问题内容
		this.setMap(params, "IS_ANONYMITY=?", this.getIS_ANONYMITY());// 是否匿名(0否、1是)
		this.setMap(params, "RELEVANT_DETAILS=?", this.getRELEVANT_DETAILS());// 相关细节
		//this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		//this.setMap(params, "WAS_USERID=?", this.getWAS_USERID());// 被问用户ID
		
		this.setMap(params, "IS_REPORT=?", this.getIS_REPORT());// 是否举报(0否、1是)
		this.setMap(params, "CREATE_TIME>=?", this.getCREATE_TIME());// 创建时间(起)
		this.setMap(params, "CREATE_TIME<=?", this.getCREATE_TIME_END());// 创建时间(止)
		// 查询问题信息表列表
		Map<String, Object> returnMap = problemService.getProblemList(params, this.getNowPage(), this.getOnePageCount());
		
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					String CREATE_TIME=getTime(newmap, "CREATE_TIME");
					String MODIFY_TIME=getTime(newmap, "MODIFY_TIME");
					
					String IS_ANONYMITY=getValue(newmap, "IS_ANONYMITY");
					String IS_REPORT=getValue(newmap, "IS_REPORT");
					
					newmap.put("CREATE_TIME", CREATE_TIME.equals("")?"&nbsp;":CREATE_TIME);
					newmap.put("MODIFY_TIME",MODIFY_TIME.equals("")?"&nbsp;":MODIFY_TIME);
					
					newmap.put("IS_ANONYMITY", IS_ANONYMITY.equals("1")?"是":"否");
					newmap.put("IS_REPORT", IS_REPORT.equals("1")?"是":"否");
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}