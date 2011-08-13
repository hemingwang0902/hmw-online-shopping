package com.baizhi.talktype.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.talktype.dao.TalktypeDao;
/**
 * 
 * 类名：TalktypeService.java
 * 描述： 话题类型表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-08-13 22:34:26
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class TalktypeService extends ServiceSupport{
	
	private static final long serialVersionUID = -4610670419013059440L;
	
	private TalktypeDao talktypeDao;
	
	public TalktypeDao getTalktypeDao() {
		return talktypeDao;
	}

	public void setTalktypeDao(TalktypeDao talktypeDao) {
		this.talktypeDao = talktypeDao;
	}
	
	/**
	 * 新增或修改话题类型表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateTalktype(Element element) {
		return talktypeDao.saveOrUpdateTalktype(element);
	}
	
	/**
	 *　删除话题类型表信息
	 * 
	 * @param TALKTYPE_IDS  话题类型表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteTalktype(String TALKTYPE_IDS) {
		return talktypeDao.deleteTalktype(TALKTYPE_IDS);
	}
	
	/**
	 *　设置取消话题类型
	 * 
	 * @param TALK_IDS   话题ID值集合以","分隔
	 * @param TYPE       类型
	 * @param TALKTYPE_ID　话题类型
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public int setTalktype(String TALK_IDS,String TYPE,String TALKTYPE_ID) {
		return talktypeDao.setTalktype(TALK_IDS, TYPE, TALKTYPE_ID);
	}
	
	/**
	 * 根据话题类型表ID获取话题类型表实体
	 * @param TALKTYPE_ID 话题类型表ID
	 * @return 返回话题类型表实体,如果无查询记录则返回null
	 */
	public  Element getTalktypeEleById(String TALKTYPE_ID){
		return talktypeDao.getTalktypeEleById(TALKTYPE_ID);
	}
	
	/**
	 *　获取话题类型表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getTalktypeCount(Map<String, Object> params) {
		return talktypeDao.getTalktypeCount(params);
	}
	
	/**
	 * 根据话题类型表ID获取话题类型表信息
	 * @param TALKTYPE_ID 话题类型表ID
	 * @return 返回话题类型表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getTalktypeMapById(String TALKTYPE_ID){
		return talktypeDao.getTalktypeMapById(TALKTYPE_ID);
	}
	
	/**
	 * 获取话题类型表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题类型表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalktypeList(Map<String, Object> params,int nowPage,int onePageCount){
		return talktypeDao.getTalktypeList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取话题类型表信息
     * 
     * @param  params 参数
     * @return 成功返回话题类型表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getTalktypeList(Map<String, Object> params){
		return talktypeDao.getTalktypeList(params);
	}

}
