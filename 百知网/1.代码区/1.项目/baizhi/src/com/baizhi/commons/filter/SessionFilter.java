package com.baizhi.commons.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名：SessionFilter.java<br>
 * 描述：Session过滤器<br>
 * 创建者：江红<br>
 * 创建日期：2010-9-19<br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SessionFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		Map<String, Object> userinfo = (Map<String, Object>) request.getSession().getAttribute("userinfo");
		String requestURI = request.getRequestURI();
		
		//如果Session为空，则返回到主页面
		if(userinfo!=null&&userinfo.get("USER_ID")!=null&&!String.valueOf(userinfo.get("USER_ID")).equals("")){
			chain.doFilter(request, response);
		}else if(requestURI.equals(request.getContextPath()+"/login.jsp")||requestURI.equals(request.getContextPath()+"/login.go")){
			chain.doFilter(request, response);
		}else if(requestURI.equals(request.getContextPath()+"/blank.jsp")){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/blank.jsp");
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
