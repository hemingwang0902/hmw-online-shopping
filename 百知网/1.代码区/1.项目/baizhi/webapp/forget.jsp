<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="forget.js"></script>
</head>
<body>

<div class="login_bg">
	<div class="login_logo"><img src="images/main/login_logo.png" /></div>
    <div class="loginbar" id="forget_form">
    <form id="forgetform" name="forgetform">
    	<div style="width:520px; height:70px; float:left; padding-right:15px;text-align: center;">
        	<div class="loginbar_l_t" style="width: 520px;">邮箱&gt;&nbsp;
        	  <input type="text" id="EMAIL" name="EMAIL"  value="" class="login_text" tabindex="1"/>
        	</div>
          <div class="loginbar_l_j" style="width: 520px;">
          <div class="loginbar_d"  style="width: 470px;"><input name="" type="submit" class="list_kssc" value="忘记密码" tabindex="3"/></div>
          </div>
        </div>
        </form>
    </div>
    <div class="loginbar" id="forget_message" style="display: none;"> 
    	<div style="color: red;text-align: center;font-size: 16px;" id="message"></div>
    </div>
    <div class="loginbar_toy">© 2011 百知问答平台 • 京ICP证110888号 </div>
</div>

</body>
</html>
