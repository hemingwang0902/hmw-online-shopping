<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript">
	//获取页面路径
	var url=location.href;
	//获取新地址
	var newurl=url.substring(0,url.indexOf("blank.jsp"))+"login.jsp";
	window.open(newurl,"_parent");
</script>
</head>
<body>
</body>
</html>
