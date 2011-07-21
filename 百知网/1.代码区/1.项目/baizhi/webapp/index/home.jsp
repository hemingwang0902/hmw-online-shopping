<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="${basePath}/index/index.js"></script>
	<script type="text/javascript" src="${basePath}/index/home.js"></script>
	<style type="text/css">
	a.checked{
		background-color: #888888;
	}
	</style>
</head>
<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="problemType" value="zui">
	
<div class="content">
	<div class="c_left">
		<%@include file="../common/search.jsp" %>
      <div class="subMenu">
      	<ul>
            <li class="zui"><a href="javascript:void(0);" class="checked" onclick="getLastestProblemList();">最新问题</a></li>
            <li class="re"><a href="javascript:void(0);" onclick="getHottestProblemList();">热门问题</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      <%@include file="../common/problemList.jsp" %>
  </div>
    
    <div class="c_right">
    	<%@include file="../common/navigationMenu.jsp" %>
    	<%@include file="../common/inviteFriends.jsp" %>
    	<%@include file="../common/interestUsers.jsp" %>
    	<%@include file="../common/attentionBrands.jsp" %>
        <div class="left_b_tp"><img src="${basePath}/images/main/tupian.png" /></div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
