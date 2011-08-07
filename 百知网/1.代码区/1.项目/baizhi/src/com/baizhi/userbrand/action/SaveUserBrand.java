package com.baizhi.userbrand.action;

import java.io.File;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.component.FileUploadUtils;
import com.baizhi.commons.configure.UploadFilePath;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.ImageUtils;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userbrand.service.UserBrandService;
/**
 * 
 * 类名：UserBrandSave.java
 * 描述： 用户品牌信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-07-10 13:09:53
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserBrand extends UserBrandForm{
	
	private static final long serialVersionUID = 4944681253794157780L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	private File upload;// 封装上传文件
	
	private String uploadFileName;// 设置上传文件的文件名
	
	private FileUploadUtils fileUploadUtils;
	
	private UploadFilePath uploadFilePath;
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public FileUploadUtils getFileUploadUtils() {
		return fileUploadUtils;
	}

	public void setFileUploadUtils(FileUploadUtils fileUploadUtils) {
		this.fileUploadUtils = fileUploadUtils;
	}

	public UploadFilePath getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(UploadFilePath uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户品牌信息表ID为""，则为新增用户品牌信息表，否则更新用户品牌信息表
		if(StringUtils.isNotEmpty(this.getBRAND_ID())){
			
			element = userBrandService.getUserBrandEleById(this.getBRAND_ID());
			//如果图片修改，则上传
			boolean upload_success=true;
			//获取真实图片路径
			String real_image_path="";
			if(uploadFileName!=null&&!uploadFileName.trim().equals("")){
				upload_success=this.uploadModifyImage();
				real_image_path=element.elementText("IMAGE_PATH");
				Elements.setElementValue(element, "IMAGE_PATH", fileUploadUtils.getFileName());// 相片路径/LOGO路径
			}
			if(upload_success){
				Elements.setElementValue(element, "BRAND_ID", this.getBRAND_ID());// 品牌ID
				Elements.setElementValue(element, "NAME", this.getNAME());// 品牌名称
				Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());// 品牌介绍
				Elements.setElementValue(element, "SOURCE", this.getSOURCE());// 发源地(品牌特有)
				Elements.setElementValue(element, "PROVINCE", this.getPROVINCE());// 所在地区(省：地区信息表ID)
				Elements.setElementValue(element, "CITY", this.getCITY());// 所在地区(市：地区信息表ID)
				Elements.setElementValue(element, "INDUSTRY", this.getINDUSTRY());// 从事行业(字典)
				Elements.setElementValue(element, "LINK_NAME", this.getLINK_NAME());// 联系人姓名
				Elements.setElementValue(element, "LINK_MODE", this.getLINK_MODE());// 联系方式
				Elements.setElementValue(element, "EMAIL", this.getEMAIL());// 电子邮箱
				Elements.setElementValue(element, "STAUS", this.getSTAUS());// 状态(1：未申请、2：申请、3：通过、4：未通过)
				Elements.setElementValue(element, "BRAND_LABEL", this.getBRAND_LABEL());// 品牌标签
				Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
				Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
				
				//如果保存成功，返回主键
				keyid = userBrandService.saveOrUpdateUserBrand(element);
				//判断主键是否为空，如果不为空，则保存成功
				if(StringUtils.isNotEmpty(keyid)){
					this.setMessage("用户品牌信息表信息编辑成功");
					//删除原有图片
					this.delImage(real_image_path);
					return UPDATESUCCESS;
				}
			}
			
		}else{
			//判断上传图片是否成功
			if(uploadImage()){
				element = new DefaultElement("T_USER_BRAND");
				Elements.setElementValue(element, "USER_ID", this.getSessionUserId());// 用户ID
				Elements.setElementValue(element, "NAME", this.getNAME());// 品牌名称
				Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());// 品牌介绍
				Elements.setElementValue(element, "SOURCE", this.getSOURCE());// 发源地(品牌特有)
				Elements.setElementValue(element, "PROVINCE", this.getPROVINCE());// 所在地区(省：地区信息表ID)
				Elements.setElementValue(element, "CITY", this.getCITY());// 所在地区(市：地区信息表ID)
				Elements.setElementValue(element, "INDUSTRY", this.getINDUSTRY());// 从事行业(字典)
				Elements.setElementValue(element, "LINK_NAME", this.getLINK_NAME());// 联系人姓名
				Elements.setElementValue(element, "LINK_MODE", this.getLINK_MODE());// 联系方式
				Elements.setElementValue(element, "EMAIL", this.getEMAIL());// 电子邮箱
				Elements.setElementValue(element, "IMAGE_PATH", fileUploadUtils.getFileName());// 相片路径/LOGO路径
				Elements.setElementValue(element, "STAUS", this.getSTAUS());// 状态(1：未申请、2：申请、3：通过、4：未通过)
				Elements.setElementValue(element, "BRAND_LABEL", this.getBRAND_LABEL());// 品牌标签
				Elements.setElementValue(element, "CREATE_TIME",DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				
				Elements.setElementValue(element, "ATT_USER_COUNT","0");// 关注人数
				Elements.setElementValue(element, "PROBLEM_COUNT","0");// 问题数量
				Elements.setElementValue(element, "IS_COMMEND", "0");// 是否推荐(0：否、1：是)
				
				//如果保存成功，返回主键
				keyid = userBrandService.saveOrUpdateUserBrand(element);
				//判断主键是否为空，如果不为空，则保存成功
				if(StringUtils.isNotEmpty(keyid)){
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}
	
	/**
	 * 新增上传图片
	 * @return
	 * @throws Exception
	 */
	private boolean uploadImage() throws Exception{
		boolean flag=false;
		//上传相片
		String suffix=fileUploadUtils.getFileType(uploadFileName);
		//判断图片格式是否正确
		if(is_suffix(suffix)){
			//获取新文件名称
			String curmillis = System.currentTimeMillis()+"";
			String newfilename = curmillis+suffix;
			
			//文件上传,成功返回true,失败返回false
			boolean flag1 = fileUploadUtils.upload(upload, uploadFilePath.getBrand_path()+"/"+this.getSessionUserId(), newfilename);
			
			//生成不同格式文件名
			boolean flag2=createImage(suffix, curmillis);
			
			if(flag1&&flag2){
				flag=true;
			}else{
				this.setMessage("上传头像失败");
			}
		}
		return flag;
	}
	
	/**
	 * 修改上传图片
	 * @return
	 * @throws Exception
	 */
	private boolean uploadModifyImage() throws Exception{
		boolean flag=false;
		//上传相片
		String suffix=fileUploadUtils.getFileType(uploadFileName);
		//判断图片格式是否正确
		if(is_suffix(suffix)){
			//获取新文件名称
			String curmillis = System.currentTimeMillis()+"";
			String newfilename = curmillis+suffix;
			
			//文件上传,成功返回true,失败返回false
			boolean flag1 = fileUploadUtils.upload(upload, uploadFilePath.getBrand_path()+"/"+this.getSessionUserId(), newfilename);
			
			//生成不同格式文件名
			boolean flag2=createImage(suffix, curmillis);
			
			if(flag1&&flag2){
				flag=true;
			}else{
				this.setMessage("上传头像失败");
			}
		}
		return flag;
	}
	
	/**
	 * 判断图片格式是否正确
	 * @param suffix
	 * @return
	 */
	private boolean is_suffix(String suffix){
		//判断是否满足图片格式
		String[] suffix_array=new String[]{"jpg","gif","png"};
		boolean suffix_flag=false;
		String real_suffix=suffix.substring(1);
		for (int i = 0; i < suffix_array.length; i++) {
			if(suffix_array[i].equals(real_suffix)){
				suffix_flag=true;
			}
		}
		return suffix_flag;
	}
	
	/**
	 * 生成不同尺寸图片
	 * @param suffix    后缀名
	 * @param curmillis 新文件名
	 * @throws Exception 
	 */
	private boolean createImage(String suffix,String curmillis) throws Exception{
		//生成不同尺寸图片
		ImageUtils imageUtils=new ImageUtils();
		
		String realpath=ServletActionContext.getServletContext().getRealPath("")+fileUploadUtils.getFileName();
		
		String path_100_100=ServletActionContext.getServletContext().getRealPath("")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+curmillis+"_100_100"+suffix;
		String path_74_74=ServletActionContext.getServletContext().getRealPath("")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+curmillis+"_74_74"+suffix;
		String path_60_53=ServletActionContext.getServletContext().getRealPath("")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+curmillis+"_60_53"+suffix;
		
		imageUtils.scaledImage(realpath, 100, 100, path_100_100, suffix.substring(1));
		imageUtils.scaledImage(realpath, 74, 74, path_74_74, suffix.substring(1));
		imageUtils.scaledImage(realpath, 60, 53, path_60_53, suffix.substring(1));
		return true;
	}
	
	/**
	 * 删除磁盘图片
	 * @param IMAGE_PATH 图片路径
	 */
	private void delImage(String IMAGE_PATH){
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
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+imagename+"_100_100"+imagesuf);
			if(file.exists()){
				file.delete();
			}
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+imagename+"_74_74"+imagesuf);
			if(file.exists()){
				file.delete();
			}
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getBrand_path()+"/"+this.getSessionUserId()+"/"+imagename+"_60_53"+imagesuf);
			if(file.exists()){
				file.delete();
			}
		}
	}
}
