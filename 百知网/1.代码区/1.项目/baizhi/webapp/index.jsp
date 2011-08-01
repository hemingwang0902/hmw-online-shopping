<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>百知网</title>
	<link rel="stylesheet" type="text/css" href="styles/index.css" />
	<link rel="stylesheet" type="text/css" href="styles/lightbox.css" />
	<script type="text/javascript" src="javascripts/jquery-1.6.1.js"></script>
	<script type="text/javascript" src="javascripts/jquery.lightbox.js"></script>
	<script type="text/javascript" src="javascripts/jquery.lightboxmousewheel.js"></script>
	<script type="text/javascript" src="index.js"></script>
	
</head>
<body scroll="no" style="overflow:hidden;width:100%;">
	<div style="width:1003px; margin:0 auto; border:#0067CB 1px solid;">
		<s:include value="header.jsp"></s:include> 
		
        <div id="menu_list">
        	<div onclick="addTab('会员管理','user/userlist.jsp')" style="cursor: pointer;">会员管理</div>
        	<div onclick="addTab('邀请会员','userinvite/userinvitelist.jsp')" style="cursor: pointer;">邀请会员</div>
        	<div onclick="addTab('积分级别设置','scorelevel/scorelevellist.jsp')" style="cursor: pointer;">积分级别设置</div>
        	<div onclick="addTab('话题管理','talk/talklist.jsp')" style="cursor: pointer;">话题管理</div>
        	<div onclick="addTab('问题管理','problem/problemlist.jsp')" style="cursor: pointer;">问题管理</div>
        	<div onclick="addTab('地区设置','area/provincelist.jsp')" style="cursor: pointer;">地区设置</div>
        	<div onclick="addTab('广告设置','ad/adlist.jsp')" style="cursor: pointer;">广告设置</div>
        	<div onclick="addTab('品牌审核','userbrand/userbrandlist.jsp')" style="cursor: pointer;">品牌审核</div>
        </div>
		<div id="tt" style="height:auto;overflow:hidden;text-align: center;display:none;">
			<div closable='true' style='padding:0px;float:left;width:100%;overflow:hidden;' cache='false' >
				<iframe scrolling='yes' id="iframe_main" frameborder='0'　 onload="turnHeight('iframe_main');"   style='width:100%;overflow:hidden;;height:600px;padding-bottom:20px;'></iframe>
			</div>
		</div>
        <div style=" clear:both;"></div>
	</div>
</body>

</html>