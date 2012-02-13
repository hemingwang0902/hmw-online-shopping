package com.baizhi.talktype.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.baizhi.commons.ActionSupport;

public class FileUploadAction extends ActionSupport {
	
	 private static final long serialVersionUID = -7887613751080170362L; 
	    private String title;//设置上传文件的标题 
	    private File upload;//封装上传文件 
	    private String uploadFileName;//设置上传文件的文件名 
	    private String uploadContentType;//上传文件的类型 
	    private String savePath;//上传文件的保存路径 
	    public String getTitle() { 
	        return title; 
	    } 
	    public void setTitle(String title) { 
	        this.title = title; 
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
	    public String getUploadContentType() { 
	        return uploadContentType; 
	    } 
	    public void setUploadContentType(String uploadContentType) { 
	        this.uploadContentType = uploadContentType; 
	    } 
	    public String getSavePath() { 
	        System.out.println(ServletActionContext.getServletContext().getRealPath(savePath)); 
	        return ServletActionContext.getServletContext().getRealPath(savePath); 
	    } 
	    public void setSavePath(String savePath) { 
	        this.savePath = savePath; 
	        System.out.println("savePath: "+savePath); 
	    } 
	    public String execute()throws Exception{ 
	        FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+getUploadFileName()); 
	        FileInputStream fis=new FileInputStream(getUpload()); 
	        byte[] buffer=new byte[1024]; 
	        int len=0; 
	        while((len=fis.read(buffer))>0){ 
	            fos.write(buffer, 0, len); 
	        } 
	        return SUCCESS; 
	    } 
}
