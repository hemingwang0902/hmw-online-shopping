package com.baizhi.commons.filter;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.IConstants;

/**
 * 类名：SessionFilter.java<br>
 * 描述：Session过滤器<br>
 * 创建者：江红<br>
 * 创建日期：2010-9-19<br>
 * 版本：<br>
 * 修改者：       何明旺 <br>
 * 修改日期：  2011-07-21 <br>
 */
public class SessionFilter implements Filter,Serializable {
	
	private static final long serialVersionUID = -6581639359476909375L;
	// 不需要进行过滤的 servlet
	private static Set<String> excepServlets = new HashSet<String>();
	
	public void init(FilterConfig cfg) throws ServletException {
		excepServlets.add("/login.jsp");
		excepServlets.add("/login.go");
		excepServlets.add("/blank.jsp");
		excepServlets.add("/forget.jsp");
		excepServlets.add("/forget.go");
		excepServlets.add("/forgetPassword.go");
		excepServlets.add("/password.go");
		excepServlets.add("/isEmail.go");
		excepServlets.add("/forgeterror.jsp");
		excepServlets.add("/regiest.jsp");
		excepServlets.add("/regiest.go");
		excepServlets.add("/user/checkEmail.go");
		excepServlets.add("/ajaxRequest.go");
		excepServlets.add("/index/getAdByPosition.go");
	}

	@SuppressWarnings("unchecked")
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
		
		Map<String, Object> userinfo = (Map<String, Object>) request.getSession().getAttribute(IConstants.SESSION_USERINFO);
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
	
		
		//如果Session为空，则返回到主页面
		if(userinfo !=null && userinfo.get("USER_ID") != null && StringUtils.isNotBlank("" + userinfo.get("USER_ID"))){
			//请求后台管理首页
			if("/index.jsp".equals(servletPath)){
				//用户类型为“管理员”
				if(NumberUtils.toInt("" + userinfo.get("USER_TYPE")) == IConstants.USER_TYPE_ADMIN){
					chain.doFilter(request, response);
				}else{
					// 如果是普通会员，则将其重定向至 /index/home.jsp
					response.sendRedirect(contextPath + "/index/home.jsp");
				}
			}else{
				chain.doFilter(request, response);
			}
		}else{
			//请求的 servlet 为不需要过滤的servlet
			if(excepServlets.contains(servletPath)){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect(contextPath + "/login.go?redirect=" + (servletPath + "?" + StringUtils.defaultString(request.getQueryString())));
			}
		}
	}

	public void destroy() {

	}

}
