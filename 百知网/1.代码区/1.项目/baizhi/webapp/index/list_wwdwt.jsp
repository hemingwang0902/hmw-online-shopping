<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_wwdwt.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="subMenu">
      <ul><li class="re"><a href="javascript:void(0);">问我的问题</a></li></ul>
      </div>
      <div class="line_1"></div>
      <%@include file="../common/problemList.jsp" %>
  </div>
    
    
    <div class="c_right">
    	<%@include file="../common/navigationMenu.jsp" %>
    	<%@include file="../common/inviteFriends.jsp" %>
    	<%@include file="../common/interestUsers.jsp" %>
    	<%@include file="../common/attentionBrands.jsp" %>
        <iframe frameborder="0" width="200" height="200" scrolling="no" src="${basePath}/index/getAdByPosition.go?SHOW_TYPE=2" style="margin: 0;padding: 0"></iframe>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
