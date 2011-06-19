<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<title>百知网</title>
	<link rel="stylesheet" type="text/css" href="styles/index.css" />
	<link rel="stylesheet" type="text/css" href="styles/menu.css"  />
	<link rel="stylesheet" type="text/css" href="styles/lightbox.css" />
	<script type="text/javascript" src="javascripts/jquery-1.6.1.js"></script>
	<script type="text/javascript" src="javascripts/jquery.menu.js"></script>
	<script type="text/javascript" src="javascripts/jquery.lightbox.js"></script>
	<script type="text/javascript" src="javascripts/jquery.lightboxmousewheel.js"></script>
	<script type="text/javascript" src="index.js"></script>
	
</head>
<body scroll="no" style="overflow:hidden;width:100%;">
	<div style="width:1003px; margin:0 auto; border:#0067CB 1px solid;">
		<s:include value="header.jsp"></s:include> 
		<div id="myjquerymenu" class="jquerycssmenu">
			
		</div>
        <div style=" clear:both;"></div>
		<div id="tt" style="height:auto;overflow:hidden;text-align: center;display:none;">
		</div>
		
        <div style=" clear:both;"></div>
	</div>
</body>
<script>
	document.getElementById('portal').style.height = document.documentElement.clientHeight - 93 + 'px';
</script>
</html>