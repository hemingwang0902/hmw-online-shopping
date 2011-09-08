<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
	<script type="text/javascript" src="${basePath }/index/index.js"></script>
</head>
<body>
	<input type="hidden" id="basePath" value="${basePath }" />
	<div class="login_bg">
		<div class="login_logo"><img src="images/main/login_logo.png"  width="360px" height="145px"/></div>
		<div style="text-align: center;height: 30px;color: white;">${message }</div>
	    <div class="loginbar">
	    <form action="login.go" id="loginform" name="loginform" method="post">
	    	<input type="hidden" id="redirect" name="redirect" value="${param.redirect }">
	    	<div class="loginbar_l">
	        	<div class="loginbar_l_t">邮箱&gt;&nbsp;
	        	  <input type="text" id="username" name="username"  value="" class="login_text" tabindex="1"/>
	        	</div>
	          <div class="loginbar_l_j"><input id="remenberMe" name="remenberMe" type="checkbox" value="true" tabindex="4"/><label for="remenberMe">记住我</label></div>
	        </div>
	        <div class="loginbar_r">
	        	<div class="loginbar_l_t">密码&gt;&nbsp;<input type="password" id="userpwd" name="userpwd" value="" class="login_pass" tabindex="2"/></div>
	          <div class="loginbar_l_w"><a href="forget.jsp" tabindex="5">忘记密码？</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regiest.jsp" tabindex="5">注册</a></div>        
	        </div>
	        <div class="loginbar_d"><input type="submit" class="loginbar_but" tabindex="3" value="　　　"/></div>
	        </form>
	    </div>
	    <div class="loginbar_toy">© 2011 百知• 蒙ICP备11001704号-2 </div>
	</div>

	<script type="text/javascript">
		$(document).ready(loadpopup);
	</script>
</body>
</html>
