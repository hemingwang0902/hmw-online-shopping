package com.baizhi.diclist.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.diclist.dao.DiclistDao;
/**
 * 
 * 类名：DiclistService.java
 * 描述： 字典列表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-22 21:19:11
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class DiclistService extends ServiceSupport{
	
	private static final long serialVersionUID = -2397366841244146337L;
	
	private DiclistDao diclistDao;
	
	public DiclistDao getDiclistDao() {
		return diclistDao;
	}

	public void setDiclistDao(DiclistDao diclistDao) {
		this.diclistDao = diclistDao;
	}
	
	/**
	 * 新增或修改字典列表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateDiclist(Element element) {
		return diclistDao.saveOrUpdateDiclist(element);
	}
	
	/**
	 *　删除字典列表信息
	 * 
	 * @param DICLIST_IDS  字典列表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteDiclist(String DICLIST_IDS) {
		return diclistDao.deleteDiclist(DICLIST_IDS);
	}
	
	/**
	 * 根据字典列表ID获取字典列表实体
	 * @param DICLIST_ID 字典列表ID
	 * @return 返回字典列表实体,如果无查询记录则返回null
	 */
	public  Element getDiclistEleById(String DICLIST_ID){
		return diclistDao.getDiclistEleById(DICLIST_ID);
	}
	
	/**
	 *　获取字典列表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getDiclistCount(Map<String, Object> params) {
		return diclistDao.getDiclistCount(params);
	}
	
	/**
	 * 根据字典列表ID获取字典列表信息
	 * @param DICLIST_ID 字典列表ID
	 * @return 返回字典列表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getDiclistMapById(String DICLIST_ID){
		return diclistDao.getDiclistMapById(DICLIST_ID);
	}
	
	/**
	 * 获取字典列表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回字典列表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getDiclistList(Map<String, Object> params,int nowPage,int onePageCount){
		return diclistDao.getDiclistList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取字典列表信息
     * 
     * @param  params 参数
     * @return 成功返回字典列表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getDiclistList(Map<String, Object> params){
		return diclistDao.getDiclistList(params);
	}

}
