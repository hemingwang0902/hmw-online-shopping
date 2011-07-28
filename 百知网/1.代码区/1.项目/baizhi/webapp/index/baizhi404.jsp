<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
</head>

<body style="background:#fcfff2">
<div class="bz_404">
	<div class="bz_404_lg"><img src="${imgBasePath}/main/logo_404.png" /></div>
    <div class="bz_404_bj">
    	<div class="bz_404_zs">你似乎来到了没有知识存在的荒原...</div>
        <div class="bz_404_ly">来源链接是否正确？用户、话题或问题是否存在？</div>
        <div class="bz_404_ho"><a href="${basePath}/index/home.jsp">返回首页</a> 或者 <a href="javascript:void(0);" onclick="window.history.go(-1);">返回上页</a> </div> 
    </div>
</div>
</body>
</html>
