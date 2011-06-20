package com.baizhi.dicitem.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.dicitem.dao.DicitemDao;
/**
 * 
 * 类名：DicitemService.java
 * 描述： 字典列表清单服务类，负责增删改查
 * 创建者：何明旺
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class DicitemService extends ServiceSupport{
	
	private DicitemDao dicitemDao;
	
	public DicitemDao getDicitemDao() {
		return dicitemDao;
	}

	public void setDicitemDao(DicitemDao dicitemDao) {
		this.dicitemDao = dicitemDao;
	}
	
	/**
	 * 新增或修改字典列表清单信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateDicitem(Element element) {
		return dicitemDao.saveOrUpdateDicitem(element);
	}
	
	/**
	 *　删除字典列表清单信息
	 * 
	 * @param DICITEM_IDS  字典列表清单ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteDicitem(String DICITEM_IDS) {
		return dicitemDao.deleteDicitem(DICITEM_IDS);
	}
	
	/**
	 * 根据字典列表清单ID获取字典列表清单实体
	 * @param DICITEM_ID 字典列表清单ID
	 * @return 返回字典列表清单实体,如果无查询记录则返回null
	 */
	public  Element getDicitemEleById(String DICITEM_ID){
		return dicitemDao.getDicitemEleById(DICITEM_ID);
	}
	
	/**
	 *　获取字典列表清单数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getDicitemCount(Map<String, Object> params) {
		return dicitemDao.getDicitemCount(params);
	}
	
	/**
	 * 根据字典列表清单ID获取字典列表清单信息
	 * @param DICITEM_ID 字典列表清单ID
	 * @return 返回字典列表清单信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getDicitemMapById(String DICITEM_ID){
		return dicitemDao.getDicitemMapById(DICITEM_ID);
	}
	
	/**
	 * 获取字典列表清单列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回字典列表清单列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getDicitemList(Map<String, Object> params,int nowPage,int onePageCount){
		return dicitemDao.getDicitemList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取字典列表清单信息
     * 
     * @param  params 参数
     * @return 成功返回字典列表清单信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getDicitemList(Map<String, Object> params){
		return dicitemDao.getDicitemList(params);
	}

}
