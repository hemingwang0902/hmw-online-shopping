package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.WtymtitDao;

public class WtymtitService  extends ServiceSupport{
	
	private static final long serialVersionUID = 6665001478560038725L;
	
	private WtymtitDao wtymtitDao;
	
	public WtymtitDao getWtymtitDao() {
		return wtymtitDao;
	}

	public void setWtymtitDao(WtymtitDao wtymtitDao) {
		this.wtymtitDao = wtymtitDao;
	}
}
