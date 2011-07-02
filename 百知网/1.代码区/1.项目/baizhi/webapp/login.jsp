<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
</head>
<body>

<div class="login_bg">
	<div class="login_logo"><img src="images/main/login_logo.png" /></div>
    <div class="loginbar">
    	<div class="loginbar_l">
        	<div class="loginbar_l_t">邮箱&gt;&nbsp;
        	  <input name="input" type="text" class="login_text" tabindex="1"/>
        	</div>
          <div class="loginbar_l_j"><input id="remenberMe" name="" type="checkbox" value="" tabindex="4"/><label for="remenberMe">记住我</label></div>
        </div>
        <div class="loginbar_r">
        	<div class="loginbar_l_t">密码&gt;&nbsp;<input name="" type="password" class="login_pass" tabindex="2"/></div>
          <div class="loginbar_l_w"><a href="#" tabindex="5">忘记密码？</a></div>        
        </div>
        <div class="loginbar_d"><input name="" type="button" class="loginbar_but" value="" tabindex="3"/></div>
    </div>
    <div class="loginbar_toy">© 2011 百知问答平台 • 京ICP证110888号 </div>
</div>

</body>
</html>
