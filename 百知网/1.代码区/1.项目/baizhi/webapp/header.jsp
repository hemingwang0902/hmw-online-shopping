<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="top_menu">
	<div class="logo"><img src="" /></div>
	<div class="handle_box">
		<div class="welfont_box">欢迎您使用百知后台管理平台！！！</div>
		<div class="current_user">当前用户：<s:property value="#session.userinfo.USER_NAME"/>  [<a href="destroy.go" class="font_blue">退出</a>]</div>
		<div class="handlebox_link"><a href="javascript:;">使用手册</a>|<a href="hotkeys.jsp" id="hotkeys">快捷方式</a>|<a href="setting.jsp" id="setting">个性化设置</a>|<a href="index.jsp">工作平台</a></div>
	</div>
</div>