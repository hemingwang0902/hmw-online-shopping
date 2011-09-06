package com.baizhi.userbrand.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.configure.UploadFilePath;
import com.baizhi.userbrand.service.UserBrandService;
/**
 * 
 * 类名：UserBrandDel.java<br>
 * 描述： 删除用户品牌信息表信息
 * 创建者：江红
 * 创建日期：2011-07-10 13:09:53
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserBrand extends ActionSupport{
	
	private static final long serialVersionUID = -6058507806150510094L;

	private String BRAND_ID;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	private UploadFilePath uploadFilePath;
	
	
	public String getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(String brand_id) {
		BRAND_ID = brand_id;
	}

	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	public UploadFilePath getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(UploadFilePath uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		boolean bool=false;
		//判断参数是否为空
		if(BRAND_ID!=null&&!BRAND_ID.trim().equals("")){
			List<Map<String, Object>> list = userBrandService.getUserBrandList(BRAND_ID);
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> realmap = list.get(i);
					String IMAGE_PATH=this.getValue(realmap, "IMAGE_PATH");
					//将图片删除
					bool=delImage(IMAGE_PATH);
				}
			}
			
			if(bool){
				//删除品牌
				boolean result = userBrandService.deleteUserBrand(BRAND_ID);
				//判断删除是否成功
				if(result){
					flag=true;
					message="品牌删除成功";
				}else{
					message="品牌删除失败";
				}
			}else{
				message="删除品牌图片失败";
			}
			
		}else{
			message="请选择要删除的品牌";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
	/**
	 * 删除磁盘图片
	 * @param IMAGE_PATH 图片路径
	 */
	private boolean delImage(String IMAGE_PATH){
		if(!IMAGE_PATH.equals("")){
			String[] imagesuffix_arr=IMAGE_PATH.split("/");
			String imagesuffix=imagesuffix_arr[imagesuffix_arr.length-1];
			int index=imagesuffix.indexOf(".");
			
			String imagename=imagesuffix.substring(0,index);
			String imagesuf=imagesuffix.substring(index);
			
			File file=new File(ServletActionContext.getServletContext().getRealPath("/")+IMAGE_PATH);
			if(file.exists()){
				file.delete();
			}
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+imagename+"_102_102"+imagesuf);
			if(file.exists()){
				file.delete();
			}
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+imagename+"_74_74"+imagesuf);
			if(file.exists()){
				file.delete();
			}
		}
		return true;
	}
	
}