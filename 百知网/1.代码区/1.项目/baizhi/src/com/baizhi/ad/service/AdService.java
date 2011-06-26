package com.baizhi.ad.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.ad.dao.AdDao;
/**
 * 
 * 类名：AdService.java
 * 描述： 广告信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-21 00:52:07
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class AdService extends ServiceSupport{

	private static final long serialVersionUID = -560886660821262868L;
	private AdDao adDao;
	
	public AdDao getAdDao() {
		return adDao;
	}

	public void setAdDao(AdDao adDao) {
		this.adDao = adDao;
	}
	
	/**
	 * 新增或修改广告信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateAd(Element element) {
		return adDao.saveOrUpdateAd(element);
	}
	
	/**
	 *　删除广告信息表信息
	 * 
	 * @param AD_IDS  广告信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteAd(String AD_IDS) {
		return adDao.deleteAd(AD_IDS);
	}
	
	/**
	 * 根据广告信息表ID获取广告信息表实体
	 * @param AD_ID 广告信息表ID
	 * @return 返回广告信息表实体,如果无查询记录则返回null
	 */
	public  Element getAdEleById(String AD_ID){
		return adDao.getAdEleById(AD_ID);
	}
	
	/**
	 *　获取广告信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAdCount(Map<String, Object> params) {
		return adDao.getAdCount(params);
	}
	
	/**
	 * 根据广告信息表ID获取广告信息表信息
	 * @param AD_ID 广告信息表ID
	 * @return 返回广告信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAdMapById(String AD_ID){
		return adDao.getAdMapById(AD_ID);
	}
	
	/**
	 * 获取广告信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回广告信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAdList(Map<String, Object> params,int nowPage,int onePageCount){
		return adDao.getAdList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取广告信息表信息
     * 
     * @param  params 参数
     * @return 成功返回广告信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAdList(Map<String, Object> params){
		return adDao.getAdList(params);
	}

}
