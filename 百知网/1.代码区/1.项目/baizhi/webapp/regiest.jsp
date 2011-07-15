<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="${basePath }/regiest.js"></script>
</head>

<body>
<div class="top">
	<div class="top_big">
   	  <div class="logo"><img src="images/main/logo.png" /></div>
        <div class="nav"></div>
    </div>
</div>

<div class="login"></div>	
<form action="user/regiest.go" method="post" id="RegiestForm" name="RegiestForm">
<div class="login_1">
    <div class="login_2">
     <div class="login_3" >
   <div class="login_4">邀请码</div>
    <input class="login_5"  name="INVITE_CODE" id="INVITE_CODE" />
    </div>
    <div class="login_3">
    <div class="login_4">姓名（请使用真实姓名）</div>
    <input class="login_5" name="NAME" id="NAME"/>
    </div>
    <div class="login_3">
    <div class="login_4">一句话介绍（ 公司/职业，专业领域、兴趣爱好等）</div>
    <textarea class="login_5" style="height:76px;"  name="INTRODUCTION" id="INTRODUCTION"></textarea>
    </div>
    <div class="login_3">
    <div class="login_4">常用邮箱</div>
    <input class="login_5" name="EMAIL" id="EMAIL"/>
    </div>
    <div class="login_3">
    <div class="login_4">密码（至少6位）</div>
    <input class="login_5" type="password" name="PASSWORD" id="PASSWORD" />
    </div>
    <div class="login_3">
    <div class="login_4">确认密码</div>
    <input class="login_5" type="password" name="CONFIRM_PASSWORD" id="CONFIRM_PASSWORD" />
    </div>
    <div class="login_3">
    <div class="login_6">
    <div class="login_7" style="margin:5px 0 0">
    <input  type="checkbox" name="terms" id="agreement" />同 意&nbsp;&nbsp; <a href="javascript:;">百知协议</a><input type="hidden" id="AGREEMENTID" name="AGREEMENTID" value="" />
    </div>
      </div>
    <div  class="login_6"> <a href="javascript:;" class="login_8" style="margin:0 210px 0 0" onclick="$('#RegiestForm').submit();">下一步</a>   </div>
    </div>
    </div>
</div>
</form>
<div class="clear"></div>
<%@include file="common/foot.jsp" %>
</body>
</html>
