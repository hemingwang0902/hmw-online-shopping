package com.baizhi.problem.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.userbasic.action.UserBasicForm;
import com.baizhi.userbasic.service.UserBasicService;

/**
 * 类名： UserBasicList.java<br>
 * 描述：  获取用户基本信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserBasicList  extends UserBasicForm {
	
	private static final long serialVersionUID = -9198632796526537340L;
	
	private UserBasicService userBasicService;//用户基本信息表业务类
	
	public UserBasicService getUserBasicService() {
		return userBasicService;
	}

	public void setUserBasicService(UserBasicService userBasicService) {
		this.userBasicService = userBasicService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "USER_TYPE=?", this.getUSER_TYPE());// 用户类型(字典：1用户、2品牌)冗余字段
		this.setMap(params, "NAME=?", this.getNAME());// 姓名/品牌名称
		this.setMap(params, "PROVINCE=?", this.getPROVINCE());// 所在地区(省：地区信息表ID)
		this.setMap(params, "CITY=?", this.getCITY());// 所在地区(市：地区信息表ID)
		this.setMap(params, "INDUSTRY=?", this.getINDUSTRY());// 从事行业(字典)
		this.setMap(params, "YEARS=?", this.getYEARS());// 所在年代(字典、用户特有)
		this.setMap(params, "LINK_MODE=?", this.getLINK_MODE());// 联系方式
		
		// 查询用户基本信息表列表
		Map<String, Object> returnMap = userBasicService.getUserBasicList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
}