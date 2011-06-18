package com.baizhi.commons.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.struts2.ServletActionContext;

import com.baizhi.exception.BaizhiException;

/**
 * 类名： FileUploadUtils<br>
 * 描述：文件上传帮助类<br>
 * 创建者：江红<br>
 * 创建日期：2011-4-8 <br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class FileUploadUtils implements Serializable {
	
	private static final long serialVersionUID = 4774240444217317171L;
	
	/** 读取文件大小 */
	private int size = 1024;
	
	private String fileName="";
	
	/**
	 * 上传文件
	 * @param file 上传文件对象
	 * @param directory 存取目录
	 * @param filename 自定义存取文件名称
	 * @return
	 */
	public boolean upload(File file, String directory, String filename) {
		boolean flag = false;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 获取上下文路径
			String contextpath = ServletActionContext.getServletContext().getRealPath("/");
			File dir = new File(contextpath, directory);
			//判断目录是否存在，如果不存在则创建
			if (!dir.exists()) {
				dir.mkdirs();
			}
			fos = new FileOutputStream(new File(dir, filename));
			fis = new FileInputStream(file);
			byte[] buffer = new byte[size];
			int len = 0;
			// 读取文件
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			
			//手动将文件删除
			flag = true;
			this.setFileName(directory + "/" + filename);
		} catch (Exception e) {
			throw new BaizhiException(e);
		} finally {
			file.deleteOnExit();
			
			//关闭文件流
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.flush();
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * 获取文件后缀名称
	 * @param fileName 文件名称
	 * @return
	 */
	public String getFileType(String fileName) {
		String type = "";
		if (fileName != null && !fileName.equals("")
				&& fileName.lastIndexOf(".") != -1) {
			type = fileName.substring(fileName.lastIndexOf("."));
		}
		return type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
