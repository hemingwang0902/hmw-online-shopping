package com.baizhi.problem.dao;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.constant.Diclist;
import com.baizhi.userdynamic.dao.UserDynamicDao;
import com.baizhi.usernotice.dao.UserNoticeDao;
import com.baizhi.userscore.dao.UserScoreDao;
 /**
 * 
 * 类名：ProblemDao.java
 * 描述：问题信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-21 00:45:57
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ProblemDao extends DaoSupport{
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
	 * 新增或修改问题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblem(Element element) {
		//return this.saveOrUpdate(element, "PROBLEM_ID");
		
		//是否为修改
		boolean isUpdate = StringUtils.isNotBlank(element.elementText("PROBLEM_ID"));
		
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.saveOrUpdate(element);
			idValue = element.elementText("PROBLEM_ID");
			if(isUpdate){ //如果是修改，而非新增，则保存后直接返回
				dom4jSession.getTransaction().commit();
				return idValue;
			}
			
			//给问题发布者增加积分
			userScoreDao.saveUserScore(NumberUtils.toInt(element.elementText("USER_ID")),NumberUtils.toInt(idValue),IConstants.DYNAMIC_TYPE_ADD_PROBLEM,"",dom4jSession);
			
			//给相关用户添加通知
			int WAS_USERID = NumberUtils.toInt(element.elementText("WAS_USERID"));
			if(WAS_USERID > 0){
				//判断对方是否设置接收有人问我问题的通知
				if(userNoticeDao.isUserNotice(WAS_USERID, IConstants.NOTICE_TYPE_ASK_ME, dom4jSession)){
					userDynamicDao.saveUserDynamic(NumberUtils.toInt(element.elementText("USER_ID")), "", NumberUtils.toInt(idValue), ""+IConstants.NOTICE_TYPE_ASK_ME, "问了你一个问题", WAS_USERID, dom4jSession);
				}
			}
			
			dom4jSession.getTransaction().commit();
		} catch (Exception e) {
			dom4jSession.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return idValue;
	}
	
	/**
	 *　删除问题信息表信息
	 * 
	 * @param PROBLEM_IDS   问题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblem(String PROBLEM_IDS) {
		return this.delete("T_PROBLEM","PROBLEM_ID", PROBLEM_IDS);
	}
	
	/**
	 *　置顶问题信息表信息
	 * 
	 * @param PROBLEM_IDS   问题信息表ID值集合以","分隔
	 * @param IS_TOP 是否置顶(0：否、1：是)
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean topProblem(String PROBLEM_IDS,String IS_TOP) {
		Session session = getSession();
		boolean flag = false;
		try {
			session.beginTransaction();
			setQueryParameters(session.createQuery("update T_PROBLEM set IS_TOP="+IS_TOP+" where PROBLEM_ID "+getSplitStr(PROBLEM_IDS)),
					PROBLEM_IDS.split(",")).executeUpdate();
			session.getTransaction().commit();
			flag=true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表实体
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemEleById(String PROBLEM_ID){
		return this.getElementById("T_PROBLEM", "PROBLEM_ID", PROBLEM_ID);
	}
	
	/**
	 *　获取问题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表信息
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemMapById(String PROBLEM_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.PROBLEM_TYPE as PROBLEM_TYPE,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.RELEVANT_DETAILS as RELEVANT_DETAILS,")//相关细节
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USERID as WAS_USERID,")//被问用户ID
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME)")//修改时间
		   .append("FROM T_PROBLEM a WHERE a.PROBLEM_ID=? ");
		return this.getById(sql.toString(), new Object[]{PROBLEM_ID});
	}
	
	/**
	 * 根据问题ID和登录用户ID查询问题详细信息（用于问题详细页面）
	 * @param PROBLEM_ID
	 * @param USER_ID
	 * @return
	 */
	public Map<String, Object> getProblemMapById(int PROBLEM_ID, int USER_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.PROBLEM_TYPE as PROBLEM_TYPE,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.RELEVANT_DETAILS as RELEVANT_DETAILS,")//相关细节
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USERID as WAS_USERID,")//被问用户ID
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME,")//修改时间
		   .append("(select count(pa.ATTENTION_ID) from T_PROBLEM_ATTENTION pa where pa.USER_ID=? and pa.PROBLEM_ID=a.PROBLEM_ID) as ATTENTION, ")//当前登录用户是否关注了该问题
		   .append("(SELECT COUNT(pc.COLLECTION_ID) FROM T_PROBLEM_COLLECTION pc where pc.USER_ID=? and pc.PROBLEM_ID=a.PROBLEM_ID) as COLLECTION, ")//当前登录用户是否收藏了该问题
		   .append("(SELECT COUNT(pi.INVITE_ID) FROM T_PROBLEM_INVITE pi WHERE pi.PROBLEM_ID=a.PROBLEM_ID) as INVITE_COUNT) ")//邀请回答的次数
		   .append("FROM T_PROBLEM a WHERE a.PROBLEM_ID=? ");
		Object[] params = new Object[]{
				USER_ID, USER_ID,PROBLEM_ID 
		};
		return this.getById(sql.toString(), params);
	}
	
	/**
	 * 获取问题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("(select DIC_NAME from T_DICITEM where a.PROBLEM_TYPE=DIC_CODE and CODE='"+Diclist.BZ000002+"') as PROBLEM_TYPE_NAME,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("(select NAME from T_USER_BASIC where USER_ID=a.USER_ID) as NAME,")//会员姓名
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.IS_TOP as IS_TOP,")//是否置顶(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM a ");
		//判断会员姓名是否为空
		if(params.get("NAME like ?")!=null&&!String.valueOf(params.get("NAME like ?")).trim().equals("")){
			sql.append(",T_USER_BASIC b where  a.USER_ID=b.USER_ID ");
		}else{
			sql.append(" WHERE 1=1 ");
		}
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM", nowPage, onePageCount);
	}
	
	/**
     * 获取问题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.PROBLEM_TYPE as PROBLEM_TYPE,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.RELEVANT_DETAILS as RELEVANT_DETAILS,")//相关细节
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USERID as WAS_USERID,")//被问用户ID
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}

}