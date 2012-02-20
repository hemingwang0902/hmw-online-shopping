package com.baizhi.usermood.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.usermood.service.UserMoodService;

/**
 * 类名： UserMoodList.java<br>
 * 描述：  获取用户心情随记列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2012-02-19 15:00:28<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserMoodList extends UserMoodForm {
	
    private static final long serialVersionUID = 3501446089688214569L;
    private UserMoodService userMoodService;//用户心情随记业务类
	
	public UserMoodService getUserMoodService() {
		return userMoodService;
	}

	public void setUserMoodService(UserMoodService userMoodService) {
		this.userMoodService = userMoodService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "id=?", this.getId());// 
		this.setMap(params, "user_id=?", this.getUser_id());// 用户ID
		this.setMap(params, "descript=?", this.getDescript());// 心情随记的内容
		this.setMap(params, "publish_time=?", this.getPublish_time());// 发表时间
		// 查询用户心情随记列表
		Map<String, Object> returnMap = userMoodService.getUserMoodList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	/**
	 * 查询最新的一条心情随记
	 * @return
	 * @throws Exception
	 */
	public String getLastMood() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        //设置查询条件
        this.setMap(params, "id=?", this.getId());// 
        this.setMap(params, "user_id=?", this.getUser_id());// 用户ID
        this.setMap(params, "descript=?", this.getDescript());// 心情随记的内容
        this.setMap(params, "publish_time=?", this.getPublish_time());// 发表时间
        // 查询用户心情随记列表
        Map<String, Object> returnMap = userMoodService.getUserMoodList(params, this.getNowPage(), this.getOnePageCount());
        //判断是否存在查询记录
        if (returnMap != null && returnMap.size() != 0) {
            this.setResult(returnMap);
        }
        return JSONSUCCESS;
    }
	
}