package com.baizhi.userinvite.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.userinvite.service.UserInviteService;
/**
 * 类名： UserInviteList.java<br>
 * 描述：  获取用户邀请信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:20:22
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserInviteList extends UserInviteForm {
	
	private static final long serialVersionUID = 7597097537974602196L;
	
	private UserInviteService userInviteService;//用户邀请信息表业务类
	
	private String INVITE_TIME_END;
	
	private String NAME;
	
	public UserInviteService getUserInviteService() {
		return userInviteService;
	}

	public void setUserInviteService(UserInviteService userInviteService) {
		this.userInviteService = userInviteService;
	}
	
	public String getINVITE_TIME_END() {
		return INVITE_TIME_END;
	}

	public void setINVITE_TIME_END(String invite_time_end) {
		INVITE_TIME_END = invite_time_end;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "NAME like ? ", NAME);// 会员名称
		this.setMap(params, "IS_SUCCESS=?", this.getIS_SUCCESS());// 是否邀请成功(0否、1是)
		this.setMap(params, "EMAIL like ?", this.getEMAIL());// 邀请Email
		this.setMap(params, "INVITE_TIME>=?", this.getINVITE_TIME());// 邀请时间(始)
		this.setMap(params, "INVITE_TIME<=?", INVITE_TIME_END);// 邀请时间(止)
		// 查询用户邀请信息表列表
		Map<String, Object> returnMap = userInviteService.getUserInviteList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					String INVITE_TIME=getTime(newmap, "INVITE_TIME");
					String IS_SUCCESS=getTime(newmap, "IS_SUCCESS");
					if(IS_SUCCESS!=null&&IS_SUCCESS.trim().equals("1")){
						IS_SUCCESS="是";
					}else{
						IS_SUCCESS="否";
					}
					newmap.put("INVITE_TIME", INVITE_TIME.equals("")?"&nbsp;":INVITE_TIME);
					newmap.put("IS_SUCCESS", IS_SUCCESS);
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}