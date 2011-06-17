package com.baizhi.commons;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * 
 * 类名：ServiceSupport<br>
 * 描述：服务支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public abstract class ServiceSupport implements Serializable {
	
	private static final long serialVersionUID = -8567180250822380359L;
	
	protected Logger log=Logger.getLogger(this.getClass());
	
}
