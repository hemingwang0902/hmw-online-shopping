package com.baizhi.probleminvite.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.probleminvite.dao.ProblemInviteDao;

/**
 * 类名：ProblemInviteService.java<br>
 * 描述： 问题邀请人信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-12 11:03:45<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ProblemInviteService extends ServiceSupport{
	private static final long serialVersionUID = 4923774206169789684L;
	private ProblemInviteDao problemInviteDao;
	
	public ProblemInviteDao getProblemInviteDao() {
		return problemInviteDao;
	}

	public void setProblemInviteDao(ProblemInviteDao problemInviteDao) {
		this.problemInviteDao = problemInviteDao;
	}
	
	/**
	 * 新增或修改问题邀请人信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemInvite(Element element) {
		return problemInviteDao.saveOrUpdateProblemInvite(element);
	}
	
	/**
	 *　删除问题邀请人信息表信息
	 * 
	 * @param INVITE_IDS  问题邀请人信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemInvite(String INVITE_IDS) {
		return problemInviteDao.deleteProblemInvite(INVITE_IDS);
	}
	
	/**
	 * 根据问题邀请人信息表ID获取问题邀请人信息表实体
	 * @param INVITE_ID 问题邀请人信息表ID
	 * @return 返回问题邀请人信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemInviteEleById(String INVITE_ID){
		return problemInviteDao.getProblemInviteEleById(INVITE_ID);
	}
	
	/**
	 *　获取问题邀请人信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemInviteCount(Map<String, Object> params) {
		return problemInviteDao.getProblemInviteCount(params);
	}
	
	/**
	 * 根据问题邀请人信息表ID获取问题邀请人信息表信息
	 * @param INVITE_ID 问题邀请人信息表ID
	 * @return 返回问题邀请人信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemInviteMapById(String INVITE_ID){
		return problemInviteDao.getProblemInviteMapById(INVITE_ID);
	}
	
	/**
	 * 获取问题邀请人信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题邀请人信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemInviteList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemInviteDao.getProblemInviteList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题邀请人信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题邀请人信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemInviteList(Map<String, Object> params){
		return problemInviteDao.getProblemInviteList(params);
	}

}
