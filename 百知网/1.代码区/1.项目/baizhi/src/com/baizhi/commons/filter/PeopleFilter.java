package com.baizhi.commons.filter;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.baizhi.commons.SpringContext;
import com.baizhi.userbasic.service.UserBasicService;

/**
 * 个人主页过滤器
 * 类名： PeopleFilter<br>
 * 描述：<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-9-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class PeopleFilter implements Filter,Serializable {

	private static final long serialVersionUID = 2409828866445759241L;
	private final String PREFIX = "/people/";
	private UserBasicService userBasicService;

	public void init(FilterConfig cfg) throws ServletException {
		SpringContext.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(cfg.getServletContext()));
		userBasicService = (UserBasicService) SpringContext.getBean("userBasicService");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		/*
		 * 请求 http://127.0.0.1:8080/baizhi/home.jsp?&a=1&b=2 时
		 * request.getRequestURL()： http://127.0.0.1:8080/baizhi/home.jsp
		 * request.getContextPath()： /baizhi
		 * request.getServletPath()：/home.jsp
		 * request.getRequestURI()：  /baizhi/home.jsp
		 * request.getQueryString()：a=1&b=2
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String webSite = servletPath.substring(PREFIX.length());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("WEBSITE=?", webSite);
		List<Map<String,Object>> list = userBasicService.getUserBasicList(params);
		if(list == null || list.isEmpty()){
			response.sendRedirect(contextPath + "/index/baizhi404.jsp");
		}else{
			response.sendRedirect(contextPath + "/index/initHyym.go?userId=" + list.get(0).get("USER_ID"));
//			request.getRequestDispatcher("/index/initHyym.go?userId=" + list.get(0).get("USER_ID")).forward(req, res);
		}
	}

	public void destroy() {

	}

}
