<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
</head>

<body>
<div class="top">
	<div class="top_big">
   	  <div class="logo"><img src="images/main/logo.png" /></div>
        <div class="nav"></div>
    </div>
</div>

<div class="login"></div>	
<div class="login_1">
    <div class="login_2">
     <div class="login_3" >
   <div class="login_4">邀请码</div>
    <input class="login_5" value="" />
    </div>
    <div class="login_3">
    <div class="login_4">姓名（请使用真实姓名）</div>
    <input class="login_5" value=""/>
    </div>
    <div class="login_3">
    <div class="login_4">一句话介绍（ 公司/职业，专业领域、兴趣爱好等）</div>
    <textarea class="login_5" style="height:76px;"></textarea>
    </div>
    <div class="login_3">
    <div class="login_4">常用邮箱</div>
    <input class="login_5" value="" />
    </div>
    <div class="login_3">
    <div class="login_4">密码（至少6位）</div>
    <input class="login_5" type="password" />
    </div>
    <div class="login_3">
    <div class="login_4">确认密码</div>
    <input class="login_5" type="password" />
    </div>
    <div class="login_3">
    <div class="login_6">
    <div class="login_7" style="margin:5px 0 0">
    <label><input checked type="checkbox" name="terms" />同 意&nbsp;&nbsp; <a href="#">百知协议</a></label>
    </div>
      <a href="#" class="login_8" style="margin:0 210px 0 0">下一步</a>    </div>
    </div>
    </div>
</div>
<div class="clear"></div>
<%@include file="common/foot.jsp" %>
</body>
</html>
