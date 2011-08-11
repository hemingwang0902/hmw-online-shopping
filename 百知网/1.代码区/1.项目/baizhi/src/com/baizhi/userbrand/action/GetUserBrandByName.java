package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.IConstants;
import com.baizhi.userbrand.service.UserBrandService;

/**
 * 类名： GetUserBrandByName<br>
 * 描述：根据品牌名称模糊查询品牌<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-8-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserBrandByName extends UserBrandForm {
	
	private static final long serialVersionUID = 7579460749892363961L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	private String q;

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@SuppressWarnings("all")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		this.setMap(params, "a.NAME like ?", q+"%");// 品牌名称
		this.setMap(params, "a.STAUS=?", IConstants.BRAND_STAUS_PASSED);
		
		// 查询用户品牌信息表列表
		Map<String, Object> returnMap = userBrandService.getUserBrandList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() > 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("AUDIT_TIME", getTime(newmap, "AUDIT_TIME"));
					if(newmap.get("COMMEND_TIME")!=null&&!String.valueOf(newmap.get("COMMEND_TIME")).trim().equals("")){
						newmap.put("COMMEND_TIME", getTime(newmap, "COMMEND_TIME"));
					}
				}
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}
