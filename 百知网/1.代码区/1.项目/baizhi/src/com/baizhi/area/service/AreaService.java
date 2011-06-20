package com.baizhi.area.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.area.dao.AreaDao;
/**
 * 
 * 类名：AreaService.java
 * 描述： 地区信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-19 23:15:19
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class AreaService extends ServiceSupport{
	private static final long serialVersionUID = -3875467587785827359L;
	private AreaDao areaDao;
	
	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	
	/**
	 * 新增或修改地区信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateArea(Element element) {
		return areaDao.saveOrUpdateArea(element);
	}
	
	/**
	 *　删除地区信息表信息
	 * 
	 * @param AREA_IDS  地区信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteArea(String AREA_IDS) {
		return areaDao.deleteArea(AREA_IDS);
	}
	
	/**
	 * 根据地区信息表ID获取地区信息表实体
	 * @param AREA_ID 地区信息表ID
	 * @return 返回地区信息表实体,如果无查询记录则返回null
	 */
	public  Element getAreaEleById(String AREA_ID){
		return areaDao.getAreaEleById(AREA_ID);
	}
	
	/**
	 *　获取地区信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAreaCount(Map<String, Object> params) {
		return areaDao.getAreaCount(params);
	}
	
	/**
	 * 根据地区信息表ID获取地区信息表信息
	 * @param AREA_ID 地区信息表ID
	 * @return 返回地区信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAreaMapById(String AREA_ID){
		return areaDao.getAreaMapById(AREA_ID);
	}
	
	/**
	 * 获取地区信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回地区信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAreaList(Map<String, Object> params,int nowPage,int onePageCount){
		return areaDao.getAreaList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取地区信息表信息
     * 
     * @param  params 参数
     * @return 成功返回地区信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAreaList(Map<String, Object> params){
		return areaDao.getAreaList(params);
	}

}
