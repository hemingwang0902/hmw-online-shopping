package com.baizhi.commons.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	/**
	 * 取得名称为 <code>cookieName</code> 的 Cookie 对象
	 * @param request
	 * @return 如果有对应的Cookie，则将其返回，否则返回 null
	 */
	public static Cookie getCookie(HttpServletRequest request, String cookieName){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieName)){
				return cookie;
			}
		}
		return null;
	}
	
	/**
	 * 移除名称为 <code>cookieName</code> 的 Cookie
	 * @param request
	 * @param cookieName
	 */
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName){
		Cookie cookie = CookieUtils.getCookie(request, cookieName);
		if(cookie != null){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
