<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>百知网</title>

	<style type="text/css">
	ul,li{ list-style:none;}
	#droplinebar {overflow: hidden; width:1240px;}
	.droplinebar ul{margin: 0;padding: 0;float: left;width:1240px; height:41px;font: bold 14px "\5B8B\4F53",san-serif;text-align:center;background:url(images/menu/pic_922tu.gif) no-repeat; }
	.droplinebar ul li{display: inline;}
	.droplinebar ul li a{float: left;display: block;color: white;width:90px;padding:11px 0;margin:0 5px;text-decoration: none;}
	.droplinebar ul li a:hover, .droplinebar ul li .current{color:#000;background: transparent url(images/menu/01.gif) 0 3px repeat-x;margin-top:2px;}
	.droplinebar ul li ul{position: absolute;color:#000;z-index: 100;padding:0 10px;background:transparent url(images/menu/22.gif) no-repeat; visibility: hidden;}
	.droplinebar ul li ul li a{font: normal 14px "\5B8B\4F53",san-serif;color:#000;margin:0;}
	.droplinebar ul li ul li a:hover{text-align:center;background:transparent url(images/menu/33.gif) 0 7px no-repeat;margin:0;}
	</style>
	
	<script type="text/javascript" src="javascripts/jquery-1.6.1.js"></script>
	<script type="text/javascript" src="javascripts/droplinemenu.js"></script>
	<script type="text/javascript">
	//build menu with DIV ID="myslidemenu" on page:
	droplinemenu.buildmenu("mydroplinemenu")
	</script>
</head>
<body scroll="no" style="overflow:hidden;width:100%;" background="images/main/bigbj.jpg">
	<div style="width:1240px; margin:0 auto; border:#0067CB 1px solid;">
		<div id="mydroplinemenu"  class="droplinebar" >
			<ul>
				<li><a href="index/home.jsp">网站首页</a></li>
				<li><a target="iframe_main" href="user/userlist.jsp" >会员管理</a></li>
				<li><a target="iframe_main" href="userinvite/userinvitelist.jsp" >邀请会员</a></li>
				<li><a target="iframe_main" href="score/scorelist.jsp" >积分设置</a></li>
				<li><a target="iframe_main" href="scorelevel/scorelevellist.jsp" >积分级别设置</a></li>
				<li><a target="iframe_main" href="talktype/talktypelist.jsp" >话题分类</a></li>
				<li><a target="iframe_main" href="talk/talklist.jsp" >话题管理</a></li> 
				
				<li><a target="iframe_main" href="problem/problemlist.jsp" >问题管理</a></li>
				<li><a target="iframe_main" href="area/provincelist.jsp" >地区设置</a></li>
				<li><a target="iframe_main" href="ad/adlist.jsp" >广告设置</a> </li>
				<li><a target="iframe_main" href="userbrand/userbrandlist.jsp" >品牌审核</a></li>
				<li><a target="iframe_main" href="userbrand/userbrandcommendlist.jsp" >推荐品牌</a></li>
				
			</ul>
		</div>  
		<iframe scrolling='yes' id="iframe_main"  name="iframe_main" frameborder='0' style='width:100%;overflow:hidden;height:700px;padding-bottom:10px;'></iframe>
        <div style=" clear:both;"></div>
	</div>
</body>
</html>