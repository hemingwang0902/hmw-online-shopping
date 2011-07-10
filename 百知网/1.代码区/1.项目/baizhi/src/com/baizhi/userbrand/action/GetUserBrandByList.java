package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.userbrand.service.UserBrandService;

/**
 * 类名： GetUserBrandByList.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 下午06:23:53<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserBrandByList extends UserBrandForm {
	
	private static final long serialVersionUID = 7579460749892363961L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	private String USER_NAME;
	
	
	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String user_name) {
		USER_NAME = user_name;
	}
	
	@SuppressWarnings("all")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		if(USER_NAME!=null&&!USER_NAME.trim().equals("")){
			this.setMap(params, "b.NAME like ?", "%"+USER_NAME+"%");// 品牌ID
		}
		if(getNAME()!=null&&!getNAME().trim().equals("")){
			this.setMap(params, "a.NAME like ?", "%"+this.getNAME()+"%");// 品牌名称
		}
		if(getSOURCE()!=null&&!getSOURCE().trim().equals("")){
			this.setMap(params, "a.SOURCE like ?", "%"+this.getSOURCE()+"%");// 发源地
		}
		
		this.setMap(params, "a.PROVINCE=?", this.getPROVINCE());// 所在地区(省：地区信息表ID)
		this.setMap(params, "a.CITY=?", this.getCITY());// 所在地区(市：地区信息表ID)
		
		if(getINDUSTRY()!=null&&!getINDUSTRY().trim().equals("")){
			this.setMap(params, "a.INDUSTRY=?", "%"+this.getINDUSTRY()+"%");// 从事行业(字典)
		}
		if(getLINK_NAME()!=null&&!getLINK_NAME().trim().equals("")){
			this.setMap(params, "a.LINK_NAME=?", "%"+this.getLINK_NAME()+"%");// 联系人姓名
		}
		
		this.setMap(params, "a.LINK_MODE=?", this.getLINK_MODE());// 联系方式
		this.setMap(params, "a.EMAIL=?", this.getEMAIL());// 电子邮箱
		this.setMap(params, "a.STAUS=?", this.getSTAUS());// 状态(1：未申请、2：申请、3：通过、4：未通过)
		// 查询用户品牌信息表列表
		Map<String, Object> returnMap = userBrandService.getUserBrandList(params,this.getNowPage(),this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() > 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("AUDIT_TIME", getTime(newmap, "AUDIT_TIME"));
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}
