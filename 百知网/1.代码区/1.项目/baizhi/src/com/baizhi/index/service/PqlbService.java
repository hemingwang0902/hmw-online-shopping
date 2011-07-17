package com.baizhi.index.service;

import java.util.Map;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.index.dao.PqlbDao;
import com.baizhi.userbasic.dao.UserBasicDao;
import com.baizhi.userbattention.dao.UserBattentionDao;
/**
 * 
 * 类名：PqlbService.java
 * 描述： 品牌列表服务类
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class PqlbService  extends ServiceSupport{
	
	private static final long serialVersionUID = -4352096706327491213L;
	
	private PqlbDao pqlbDao;
	private UserBasicDao userBasicDao;
	private UserBattentionDao userBattentionDao;

	public void setPqlbDao(PqlbDao pqlbDao) {
		this.pqlbDao = pqlbDao;
	}
	
	public void setUserBasicDao(UserBasicDao userBasicDao) {
		this.userBasicDao = userBasicDao;
	}

	public void setUserBattentionDao(UserBattentionDao userBattentionDao) {
		this.userBattentionDao = userBattentionDao;
	}

	/**
	 * 根据用户ID查询其姓名
	 * @param userId
	 * @return
	 */
	public String getUserNameByUserId(int userId){
		Element userBasic = userBasicDao.getUserBasicEleByUserId(userId);
		if(userBasic == null)
			return null;
		return userBasic.elementTextTrim("NAME");
	}
	
	public Map<String, Object> getHottestBrand(int nowPage, int onePageCount){
		return pqlbDao.getHottestBrand(nowPage, onePageCount);
	}
	
	public Map<String, Object> getLastestBrand(int nowPage, int onePageCount){
		return pqlbDao.getLastestBrand(nowPage, onePageCount);
	}
	
	public void attentionBrand(int USER_ID, int BRAND_ID, boolean disAttention){
		Element element = userBattentionDao.getUserBattentionEleById(USER_ID, BRAND_ID);
		if(disAttention){ //取消关注
			if(element != null){
				userBattentionDao.deleteUserBattention(element.elementTextTrim("BATTENTION_ID"));
			}
		}else{
			if(element == null){
				element = new DefaultElement("T_USER_BATTENTION");
				Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
				Elements.setElementValue(element, "BRAND_ID", BRAND_ID);// 被关注品牌
				Elements.setElementValue(element, "IS_ATTENTION", 0);// 是否关注(0否、1是)
				Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
				userBattentionDao.saveOrUpdateUserBattention(element);
			}
		}
	}
}
