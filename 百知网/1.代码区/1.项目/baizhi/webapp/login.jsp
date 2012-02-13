<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识平台-需知网
<style type="text/css">
<!--
-->
</style>
<a href="http://www.xuzhiwang.com">需知网</a></title>
<link href="styles/layout.css" rel="stylesheet" type="text/css" />
<meta name="需知" content="需知网" />
<meta name="" content="需知网" />
<meta name="知识平台" content="需知网" />
<meta name="需知" content="需知网" />
<%@include file="common/jsCss.jsp" %>
	<script type="text/javascript" src="${basePath }/index/index.js"></script>
</head>

<body>
 <form action="login.go" id="loginform" name="loginform" method="post">
<input type="hidden" id="redirect" name="redirect" value="${param.redirect }">
<input type="hidden" id="basePath" value="${basePath }" />
<div id="all" style="height: 176px;">
<div id="container">
  <div id="header">
  
	<div style="padding-left:110px;padding-top:103px; "><img src="images/main/xuzhi.jpg" width="164" height="73" />&nbsp;
	<img src="images/main/ziti.png" width="217" height="43" /></div>
  </div>
 
  <div id="mainContent">
<div class="row">
<div class="left" style="margin-left:100px;">
 <div>
        <p ><img src="images/main/userlogin.png" width="88" height="28" /></p>
       
      </div>
	  
     <ul class="tb">
  
   <li style="width:70px;"> <img src="images/main/emaillogin.png" width="55" height="22" /></li>
   <li style="width:220px;">
      <input type="text" id="username" name="username"  value="" class="login_text" tabindex="1"/>
   </li>
     </ul> 
     <p>&nbsp;</p>
     <ul class="tb">
  
   <li style="width:70px;  "><img src="images/main/password.png" width="58" height="22" /></li>
   <li style="width:170px;"><input type="password" id="userpwd" name="userpwd" value="" class="login_pass" tabindex="2"/>
   </li>
   </ul> 
     <p>&nbsp;</p>
     <ul class="tb">
  
   <li style="width:100px; height:25px; padding-left:5px;">
    <input id="remenberMe" name="remenberMe" type="checkbox" value="true" tabindex="4"/>
	<label for="remenberMe">记住我</label>
	
</li>
   <li style="width:65px; height:25px;"><input type="submit" class="loginbar_but" tabindex="3" value="　　"/></li>
    <li style="width:100px; height:25px;"><input type="submit" class="loginbar_but" tabindex="3" value="    "/></li>
</ul> <div style="text-align: center;height: 30px;color: red;">${message }</div>
</div>
<div class="right" style="margin-right:100px;">
<div>
    <p ><img src="images/main/newuser.png" width="74" height="25" /></p>
    
  </div>
 <div style="font-size:14px;font-family:Arial, Helvetica, sans-serif; line-height:20px; padding-left:13px;">只是找答案请点进入浏览!</div>
  <div style="font-size:14px; font-family:Arial, Helvetica, sans-serif; padding-left:13px;">加入需知，请在此<a href="regiest.jsp" tabindex="5">注册</a>！亲，欢迎你的加入！</div>
</div>
</div>

  </div>
 
  <div id="footer">
    <hr />
  </div>
  </div>
</div></form>
<script type="text/javascript">
		$(document).ready(loadpopup);
	</script>
</body>
</html>