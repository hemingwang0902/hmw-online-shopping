<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- /webapp/index/list_sz_zhsz.jsp -->
<html>
<head>
<link type="text/css" rel="stylesheet" href="../styles/message.css" media="screen"/>
	<%@include file="../common/jsCss.jsp" %>
	
	
	<script type="text/javascript" language="javascript" src="../index/list_sz_zhsz.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<%@include file="/common/settingLeftNav.jsp" %>
  <form  id="UserForm">
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">
	    建议使用字母和数字组合，增强安全性
	  </div>
      <div class="list_sz_zhsz">
      	<ul>
        	<li>当前密码： <input name="R_PASSWORD" type="password" id="R_PASSWORD"/></li>
            <li>新的密码： <input name="PASSWORD" type="password" id="PASSWORD"/></li>
            <li>确认密码： <input name="CONFIRM_PASSWORD" type="password" id="CONFIRM_PASSWORD" /></li>
        </ul>
      </div>
      <div class="list_sz_zhsz_bcsz">
        <input name="input" type="submit" class="list_sz_bcmm" value="保存密码"/>
      </div>
  </div>
  </form>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
