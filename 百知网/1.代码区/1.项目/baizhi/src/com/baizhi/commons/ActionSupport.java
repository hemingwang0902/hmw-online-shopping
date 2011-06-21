package com.baizhi.commons;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.baizhi.commons.support.DateUtils;

import net.sf.json.JSONObject;


/**
 * 
 * 类名：ActionSupport<br>
 * 描述：动作支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public abstract class ActionSupport extends com.opensymphony.xwork2.ActionSupport implements Serializable {
	
	private static final long serialVersionUID = -2970252852004494764L;

	protected Logger log = Logger.getLogger(this.getClass());

	// json返回结果
	public static String JSONSUCCESS = "jsonsuccess";
	public static String UPDATESUCCESS = "update";
	public static String CONTEXTPATH="cpath";

	// 定义设置json数据格式 用于页面解析
	public String result;
	public String message;
	
	//分页
	private int nowPage;     // 当前页
	private int onePageCount;// 每页显示多少条
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static String getJSONSUCCESS() {
		return JSONSUCCESS;
	}

	public static void setJSONSUCCESS(String jsonsuccess) {
		JSONSUCCESS = jsonsuccess;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResult(Map<String, Object> jsonMap) {
		jsonMap.put(CONTEXTPATH, getContext_path());
		JSONObject jspn_obj = JSONObject.fromObject(jsonMap);
		result = jspn_obj.toString();
	}

	/**
	 * UTF-8转gbk
	 * @param str
	 * @return
	 */
	public String parseUTF2GBK(String str) {
		String string = "";
		try {
			string = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * 获取当前session用户
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSessionUserInfo() {
		return (Map<String, Object>) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	}

	/**
	 * 获取当前session用户ID
	 * 
	 * @return
	 */
	public long getSessionUserId() {
		return Long.parseLong(String.valueOf(getSessionUserInfo().get("USER_ID")));
	}

	/**
	 * 获取当前session用户名称
	 * 
	 * @return
	 */
	public String getSessionUserName() {
		return String.valueOf(getSessionUserInfo().get("USER_NAME"));
	}

	/**
	 * 获取当前session用户所属部门
	 * 
	 * @return
	 */
	public long getSessionDeptId() {
		return Long.parseLong(String.valueOf(getSessionUserInfo().get("DEPT_ID")));
	}

	/**
	 * 获取当前session用户所属部门名称
	 * 
	 * @return
	 */
	public String getSessionDeptName() {
		return String.valueOf(getSessionUserInfo().get("DEPT_NAME"));
	}

	/**
	 * 获取当前session用户所属单位
	 * 
	 * @return
	 */
	public long getSessionUnitId() {
		return Long.parseLong(String.valueOf(getSessionUserInfo().get("UNIT_ID")));
	}

	/**
	 * 获取当前session用户所属单位名称
	 * 
	 * @return
	 */
	public String getSessionUnitName() {
		return String.valueOf(getSessionUserInfo().get("UNIT_NAME"));
	}

	/**
	 * 获取当前session用户所能操作的品牌,如果存在多个品牌则以“，”间隔
	 * 
	 * @return
	 */
	public String getSessionBrands() {
		return String.valueOf(getSessionUserInfo().get("BRANDS"));
	}
	
	/**
	 * 获取当前session用户所能操作的机构,如果存在多个机构则以“，”间隔
	 * 
	 * @return
	 */
	public String getSessionOptUnit() {
		return String.valueOf(getSessionUserInfo().get("OPTUNIT"));
	}
	
	/**
	 * 获取当前session用户所能操作的组,如果存在多个组则以“，”间隔
	 * 
	 * @return
	 */
	public String getSessionOptGroup() {
		return String.valueOf(getSessionUserInfo().get("OPTGROUP"));
	}

	@Override
	public abstract String execute() throws Exception;

	/**
	 * 获取工程对应上下文路径
	 * @return
	 */
	public String getContext_path() {
		return ServletActionContext.getRequest().getContextPath();
	}
	
	/**
	 * 设置map值
	 * @param params 设置对象
	 * @param key　　 键
	 * @param value  值
	 */
	public  void setMap(Map<String, Object> params,String key,Object value) {
		//判断键是否为空
		if(key!=null&&!key.trim().equals("")){
			//判断值不为空则放在map中，否则不放入map中
			if(value!=null&&!String.valueOf(value).trim().equals("")){
				params.put(key, value);
			}
		}
	}
	
	/**
	 * 设置map值
	 * @param params 设置对象
	 * @param key　　 键
	 * @param value  值
	 * @param ischaracter 字符是否需要转换,true转换,false不转换
	 */
	public  void setMap(Map<String, Object> params,String key,Object value,boolean ischaracter) throws Exception{
		//判断键是否为空
		if(key!=null&&!key.trim().equals("")){
			//判断值不为空则放在map中，否则不放入map中
			if(value!=null&&!String.valueOf(value).trim().equals("")){
				if(ischaracter){
					params.put(key,URLDecoder.decode(String.valueOf(value),"UTF-8"));
				}else{
					params.put(key, value);
				}
			}
		}
	}
	
	/**
	 * 设置值
	 * @param map 取值对象
	 * @param key 键
	 * @return 返回键对应的值，如果为null则返回""
	 */
	public String getValue(Map<String, Object>  map,String key)  {
		String value="";
		if(map!=null&&map.size()>0){
			if(map.get(key)!=null){
				value=String.valueOf(map.get(key)).trim();
			}
		}
		return value;
	}
	
	/**
	 * 
	 * @param map   取值对象
	 * @param key   键
	 * @return
	 */
	public String getTime(Map<String, Object> map,String key){
		return getTime(map,key, "");
	}
	
	/**
	 * 
	 * @param map   取值对象
	 * @param key   键
	 * @param format格式
	 * @return
	 */
	public String getTime(Map<String, Object> map,String key,String format){
		String time="";
		if(map!=null){
			if(map.get(key)!=null&&!String.valueOf(map.get(key)).trim().equals("")){
				if(format.trim().equals("")){
					time=new SimpleDateFormat(DateUtils.SHOW_DATE_FORMAT).format(map.get(key));  
				}else{
					time=new SimpleDateFormat(format).format(map.get(key));  
				}
			}
		}
		return time;
	}
}
