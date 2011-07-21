package com.baizhi.talk.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.WtymtitDao;
import com.baizhi.talk.dao.TalkDao;
/**
 * 
 * 类名：TalkService.java
 * 描述： 话题信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class TalkService extends ServiceSupport{
	
	private static final long serialVersionUID = 2573394938773844538L;
	
	private WtymtitDao wtymtitDao;
	private TalkDao talkDao;
	
	public void setWtymtitDao(WtymtitDao wtymtitDao) {
		this.wtymtitDao = wtymtitDao;
	}

	public void setTalkDao(TalkDao talkDao) {
		this.talkDao = talkDao;
	}
	
	/**
	 * 新增或修改话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateTalk(Element element) {
		String talkId = null;
		Map<String, Object> talk = wtymtitDao.getTalkByContent(element.elementTextTrim("CONTENT"));
		if(talk == null){ //如果该话题不存在，则新增
			talkId = talkDao.saveOrUpdateTalk(element);
		}else{
			talkId = "" + talk.get("TALK_ID");
		}
		return talkId;
	}
	
	/**
	 *　删除话题信息表信息
	 * 
	 * @param TALK_IDS  话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteTalk(String TALK_IDS) {
		return talkDao.deleteTalk(TALK_IDS);
	}
	
	/**
	 * 根据话题信息表ID获取话题信息表实体
	 * @param TALK_ID 话题信息表ID
	 * @return 返回话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getTalkEleById(String TALK_ID){
		return talkDao.getTalkEleById(TALK_ID);
	}
	
	/**
	 *　获取话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getTalkCount(Map<String, Object> params) {
		return talkDao.getTalkCount(params);
	}
	
	/**
	 * 根据话题信息表ID获取话题信息表信息
	 * @param TALK_ID 话题信息表ID
	 * @return 返回话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getTalkMapById(String TALK_ID){
		return talkDao.getTalkMapById(TALK_ID);
	}
	
	/**
	 * 获取话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalkList(Map<String, Object> params,int nowPage,int onePageCount){
		return talkDao.getTalkList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getTalkList(Map<String, Object> params){
		return talkDao.getTalkList(params);
	}

}
