package com.baizhi.problemanswer.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.userdynamic.dao.UserDynamicDao;
import com.baizhi.usernotice.dao.UserNoticeDao;
import com.baizhi.userscore.dao.UserScoreDao;

 /**
 * 类名：ProblemAnswerDao.java<br>
 * 描述：问题答案信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-14 10:39:37<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class ProblemAnswerDao extends DaoSupport{
	private UserNoticeDao userNoticeDao;
	private UserDynamicDao userDynamicDao; 
	private UserScoreDao userScoreDao; 
	
	public void setUserNoticeDao(UserNoticeDao userNoticeDao) {
		this.userNoticeDao = userNoticeDao;
	}

	public void setUserDynamicDao(UserDynamicDao userDynamicDao) {
		this.userDynamicDao = userDynamicDao;
	}
	
	public void setUserScoreDao(UserScoreDao userScoreDao) {
		this.userScoreDao = userScoreDao;
	}
	
	/**
	 * 新增或修改问题答案信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	@SuppressWarnings("unchecked")
	public String saveOrUpdateProblemAnswer(Element element) {
		//return this.saveOrUpdate(element, "ANSWER_ID");

		//是否为修改
		boolean isUpdate = StringUtils.isNotBlank(element.elementText("ANSWER_ID"));
		
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.saveOrUpdate(element);
			idValue = element.elementText("ANSWER_ID");
			if(isUpdate){ //如果是修改，而非新增，则保存后直接返回
				dom4jSession.getTransaction().commit();
				return idValue;
			}
			
			//给问题回答者添加积分
			userScoreDao.saveUserScore(NumberUtils.toInt(element.elementText("USER_ID")),NumberUtils.toInt(idValue),IConstants.DYNAMIC_TYPE_ADD_ANSWER,"",dom4jSession);
			
			//添加通知
			String sql = "select pa.USER_ID as USER_ID from t_problem_attention pa where pa.PROBLEM_ID=?";
			List<Map<String, Object>> resultList = setQueryParameters(session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP), new Object[]{element.elementText("PROBLEM_ID")}).list();
			if(resultList != null && !resultList.isEmpty()){
				int WAS_USER_ID = 0;
				for (Map<String, Object> map : resultList) {
					WAS_USER_ID = NumberUtils.toInt(map.get("USER_ID").toString());
					if(WAS_USER_ID > 0){
						//判断对方是否设置接收“我关注的问题有了新答案”的通知
						if(userNoticeDao.isUserNotice(WAS_USER_ID, IConstants.NOTICE_TYPE_NEW_ANSWER, dom4jSession)){
							userDynamicDao.saveUserDynamic(NumberUtils.toInt(element.elementText("USER_ID")), "", NumberUtils.toInt(idValue), ""+IConstants.NOTICE_TYPE_NEW_ANSWER, "关注的问题有了新回答", WAS_USER_ID, dom4jSession);
						}
					}
				}
			}
			
			String sql_1 = "select USER_ID from t_user_battention uba where uba.BRAND_ID in (select pa.TALK_ID from t_problem_talk pa where pa.PROBLEM_ID=? and pa.TALK_TYPE=?)";
			Object[] params = new Object[]{element.elementText("PROBLEM_ID"), IConstants.TALK_TYPE_BRAND};
			List<Map<String, Object>> resultList_1 = setQueryParameters(session.createSQLQuery(sql_1).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP), params).list();
			if(resultList_1 != null && !resultList_1.isEmpty()){
				int WAS_USER_ID = 0;
				for (Map<String, Object> map : resultList_1) {
					WAS_USER_ID = NumberUtils.toInt(map.get("USER_ID").toString());
					if(WAS_USER_ID > 0){
						//判断对方是否设置接收“我关注的品牌下的问题有了新答案”的通知
						if(userNoticeDao.isUserNotice(WAS_USER_ID, IConstants.NOTICE_TYPE_NEW_ANSWER_BRAND, dom4jSession)){
							userDynamicDao.saveUserDynamic(NumberUtils.toInt(element.elementText("USER_ID")), "", NumberUtils.toInt(idValue), ""+IConstants.NOTICE_TYPE_NEW_ANSWER_BRAND, "关注的品牌下的问题有了新回答", WAS_USER_ID, dom4jSession);
						}
					}
				}
			}
			dom4jSession.getTransaction().commit();
		} catch (Exception e) {
			dom4jSession.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return idValue;
	}
	
	/**
	 *　删除问题答案信息表信息
	 * 
	 * @param ANSWER_IDS   问题答案信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemAnswer(String ANSWER_IDS) {
		return this.delete("T_PROBLEM_ANSWER","ANSWER_ID", ANSWER_IDS);
	}
	
	/**
	 * 根据问题答案信息表ID获取问题答案信息表实体
	 * @param ANSWER_ID 问题答案信息表ID
	 * @return 返回问题答案信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemAnswerEleById(String ANSWER_ID){
		return this.getElementById("T_PROBLEM_ANSWER", "ANSWER_ID", ANSWER_ID);
	}
	
	/**
	 *　获取问题答案信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemAnswerCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM_ANSWER a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题答案信息表ID获取问题答案信息表信息
	 * @param ANSWER_ID 问题答案信息表ID
	 * @return 返回问题答案信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemAnswerMapById(String ANSWER_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.AGREE_COUNT as AGREE_COUNT,")//赞成数量
		   .append("a.DISAGREE_COUNT as DISAGREE_COUNT,")//反对数量
		   .append("a.THANK_COUNT as THANK_COUNT,")//感觉作者数量
		   .append("a.DISTHANK_COUNT as DISTHANK_COUNT,")//没有帮助数量
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ANSWER a WHERE a.ANSWER_ID=? ");
		return this.getById(sql.toString(), new Object[]{ANSWER_ID});
	}
	
	/**
	 * 获取问题答案信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题答案信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemAnswerList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.AGREE_COUNT as AGREE_COUNT,")//赞成数量
		   .append("a.DISAGREE_COUNT as DISAGREE_COUNT,")//反对数量
		   .append("a.THANK_COUNT as THANK_COUNT,")//感觉作者数量
		   .append("a.DISTHANK_COUNT as DISTHANK_COUNT,")//没有帮助数量
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ANSWER a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM_ANSWER", nowPage, onePageCount);
	}
	
	/**
     * 获取问题答案信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题答案信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemAnswerList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.AGREE_COUNT as AGREE_COUNT,")//赞成数量
		   .append("a.DISAGREE_COUNT as DISAGREE_COUNT,")//反对数量
		   .append("a.THANK_COUNT as THANK_COUNT,")//感觉作者数量
		   .append("a.DISTHANK_COUNT as DISTHANK_COUNT,")//没有帮助数量
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ANSWER a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

