package com.baizhi.commons.configure;

import java.io.Serializable;

/**
 * 类名：FilePath<br>
 * 描述：上传文件路径常量类<br>
 * 创建者：江红<br>
 * 创建日期：2011-3-29 <br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class UploadFilePath implements Serializable {
	
	private static final long serialVersionUID = 989841478710329753L;
	
	//上传照片、Logo
	public String logo_path ;
	
	//上传品牌照片
	public String brand_path ;
	
	
	public void init(){}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getBrand_path() {
		return brand_path;
	}

	public void setBrand_path(String brand_path) {
		this.brand_path = brand_path;
	}
	
}
