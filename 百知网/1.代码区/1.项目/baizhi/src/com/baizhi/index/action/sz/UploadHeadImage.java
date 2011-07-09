package com.baizhi.index.action.sz;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.component.FileUploadUtils;
import com.baizhi.commons.configure.UploadFilePath;
import com.baizhi.commons.support.ImageUtils;
import com.baizhi.index.service.SzService;

/**
 * 类名： UploadHeadImage.java<br>
 * 描述：上传头像<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-9 上午11:17:12<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class UploadHeadImage extends ActionSupport{
	
	private static final long serialVersionUID = 3260882221407072189L;
	
	private SzService szService;
	
	public SzService getSzService() {
		return szService;
	}
	
	public void setSzService(SzService szService) {
		this.szService = szService;
	}
	
	private File upload;// 封装上传文件
	
	private String uploadFileName;// 设置上传文件的文件名
	
	private FileUploadUtils fileUploadUtils;
	
	private UploadFilePath uploadFilePath;
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public void setFileUploadUtils(FileUploadUtils fileUploadUtils) {
		this.fileUploadUtils = fileUploadUtils;
	}

	public void setUploadFilePath(UploadFilePath uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Override
	public String execute() throws Exception {
		String suffix=fileUploadUtils.getFileType(uploadFileName);
		//判断图片格式是否正确
		if(is_suffix(suffix)){
			//获取新文件名称
			String curmillis = System.currentTimeMillis()+"";
			String newfilename = curmillis+suffix;
			
			//文件上传,成功返回true,失败返回false
			boolean flag = fileUploadUtils.upload(upload, uploadFilePath.getLogo_path()+"/"+this.getSessionUserId(), newfilename);
			
			//生成不同格式文件名
			boolean flag2=createImage(suffix, curmillis);
			Map<String, Object> imagemap = szService.getUserBasicMapById(this.getSessionUserId());
			
			if(flag&&flag2){
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("IMAGE_PATH", fileUploadUtils.getFileName());
				//更新上传图片路径
				int count=szService.updateUserBasic(params, this.getSessionUserId());
				if(count>0){
					this.setMessage("头像设置成功");
					//将原有图片删除
					delImage(this.getValue(imagemap, "IMAGE_PATH"));
					
				}else{
					this.setMessage("头像设置失败");
				}
			}else{
				this.setMessage("上传头像失败");
			}
		}
		
		
		return SUCCESS;
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
		
		String path_102_102=ServletActionContext.getServletContext().getRealPath("")+uploadFilePath.getLogo_path()+"/"+this.getSessionUserId()+"/"+curmillis+"_102_102"+suffix;
		String path_25_25=ServletActionContext.getServletContext().getRealPath("")+uploadFilePath.getLogo_path()+"/"+this.getSessionUserId()+"/"+curmillis+"_25_25"+suffix;
		
		imageUtils.scaledImage(realpath, 102, 102, path_102_102, suffix.substring(1));
		imageUtils.scaledImage(realpath, 25, 25, path_25_25, suffix.substring(1));
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
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getLogo_path()+"/"+this.getSessionUserId()+"/"+imagename+"_102_102"+imagesuf);
			if(file.exists()){
				file.delete();
			}
			file=new File(ServletActionContext.getServletContext().getRealPath("/")+uploadFilePath.getLogo_path()+"/"+this.getSessionUserId()+"/"+imagename+"_25_25"+imagesuf);
			if(file.exists()){
				file.delete();
			}
		}
	}
	
}
