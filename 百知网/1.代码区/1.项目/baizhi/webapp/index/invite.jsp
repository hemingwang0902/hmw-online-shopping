<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="invite.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="login_home" style="background:#ccdba2;">
	<div class="login_h_logo"><img src="../images/main/login_h_l.png"/></div>
  <div class="login_h_jj">一个有趣的网络问答社区，分享知识，发现价值</div>
  	<form id="form1">
  		<input id="url" type="hidden" value="${basePath }/regiest.jsp?USER_ID=">
  		<div id="error" style="text-align: center;width: 100%;color: #ff0000;" ></div>
  		 <div class="login_h_e">
  		 	<img src="../images/main/e_mail.png" />
  		 	<input id="EMAIL" name="EMAIL" type="text" class="login_h_text" />
			<input name="" type="submit" class="login_h_an" value="" style="cursor: pointer;"/>
		</div>
  	</form>
   
   
    <div class="login_h_dz">请留下您的E-mail地址，我们会在第一时间通知您项目的进展情况，邀请您参与测试。</div>
    <div class="login_h_jq"><img src="../images/main/jqqd.png" /></div>
</div>

<%@include file="../common/foot.jsp" %>
</body>
</html>
