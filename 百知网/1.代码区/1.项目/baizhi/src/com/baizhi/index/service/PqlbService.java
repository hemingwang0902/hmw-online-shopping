package com.baizhi.index.service;

import java.util.Map;

import org.dom4j.Element;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.PqlbDao;
import com.baizhi.userbasic.dao.UserBasicDao;
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

	public void setPqlbDao(PqlbDao pqlbDao) {
		this.pqlbDao = pqlbDao;
	}
	
	public void setUserBasicDao(UserBasicDao userBasicDao) {
		this.userBasicDao = userBasicDao;
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
}
