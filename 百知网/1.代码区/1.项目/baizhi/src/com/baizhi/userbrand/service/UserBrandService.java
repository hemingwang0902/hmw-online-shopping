package com.baizhi.userbrand.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userbrand.dao.UserBrandDao;
/**
 * 
 * 类名：UserBrandService.java
 * 描述： 用户品牌信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-07-10 13:09:53
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserBrandService extends ServiceSupport{
	
	private static final long serialVersionUID = 7236904932509563168L;
	
	private UserBrandDao userBrandDao;
	
	public UserBrandDao getUserBrandDao() {
		return userBrandDao;
	}

	public void setUserBrandDao(UserBrandDao userBrandDao) {
		this.userBrandDao = userBrandDao;
	}
	
	/**
	 * 新增或修改用户品牌信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserBrand(Element element) {
		return userBrandDao.saveOrUpdateUserBrand(element);
	}
	
	/**
	 *　删除用户品牌信息表信息
	 * 
	 * @param BRAND_IDS  用户品牌信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserBrand(String BRAND_IDS) {
		return userBrandDao.deleteUserBrand(BRAND_IDS);
	}
	
	/**
	 *　审核
	 * 
	 * @param BRAND_IDS   用户品牌信息表ID值集合以","分隔
	 * @param REASON   原因
	 * @param TYPE   类型 3同意,4不同意
	 * @param USER_ID   用户ID
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean audit(String BRAND_IDS,String REASON,int TYPE,int USER_ID) {
		return userBrandDao.audit(BRAND_IDS, REASON,TYPE,USER_ID);
	}
	
	/**
	 * 根据用户品牌信息表ID获取用户品牌信息表实体
	 * @param BRAND_ID 用户品牌信息表ID
	 * @return 返回用户品牌信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserBrandEleById(String BRAND_ID){
		return userBrandDao.getUserBrandEleById(BRAND_ID);
	}
	
	/**
	 *　获取用户品牌信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserBrandCount(Map<String, Object> params) {
		return userBrandDao.getUserBrandCount(params);
	}
	
	/**
	 * 根据用户品牌信息表ID获取用户品牌信息表信息
	 * @param BRAND_ID 用户品牌信息表ID
	 * @return 返回用户品牌信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBrandMapById(String BRAND_ID){
		return userBrandDao.getUserBrandMapById(BRAND_ID);
	}
	
	/**
	 * 获取用户品牌信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户品牌信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserBrandList(Map<String, Object> params,int nowPage,int onePageCount){
		return userBrandDao.getUserBrandList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户品牌信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户品牌信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserBrandList(Map<String, Object> params){
		return userBrandDao.getUserBrandList(params);
	}

}
