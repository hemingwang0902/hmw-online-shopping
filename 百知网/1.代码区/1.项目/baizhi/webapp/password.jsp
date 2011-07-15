<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="../styles/message.css" media="screen"/>
	<%@include file="common/jsCss.jsp" %>
	
	
	<script type="text/javascript" language="javascript" src="password.js"></script>
</head>

<body>
<div class="login_bg">
	<div class="login_logo"><img src="images/main/login_logo.png" /></div>
	
<form  id="UserForm" action="password.go" method="post">
  	<input type="hidden" id="EMAIL" name="EMAIL" value="<s:property value="#parameters.EMAIL"/>" />
  	<input type="hidden" id="TIMEOUT" name="TIMEOUT" value="<s:property value="#parameters.TIMEOUT"/>" />
	 
      
      
       <div class="loginbar" id="forget_form">
    	<div style="width:520px; height:70px; float:left; padding-right:15px;text-align: center;">
        	<div class="loginbar_l_t" style="width: 520px;">新的密码&gt;&nbsp;
        	  <input name="PASSWORD" type="password" id="PASSWORD"/>
        	</div>
        	<div class="loginbar_l_t" style="width: 520px;">确认密码&gt;&nbsp;
        	  <input name="CONFIRM_PASSWORD" type="password" id="CONFIRM_PASSWORD" />
        	</div>
          <div class="loginbar_l_j" style="width: 520px;">
          <div class="loginbar_d"  style="width: 470px;"><input name="" type="submit" class="list_kssc" value="设置密码" /></div>
          </div>
        </div>
    </div>
    
    
      
  </form>
</div>
</body>
</html>
