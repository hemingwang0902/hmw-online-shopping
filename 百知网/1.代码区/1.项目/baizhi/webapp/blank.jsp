<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="common/jsCss.jsp" %>
	<script type="text/javascript" src="${basePath }/index/index.js"></script>
</head>
<body>
	<input type="hidden" id="basePath" value="${basePath }" />
	<script type="text/javascript">
		//window.open("index/getAdByPosition.go?SHOW_TYPE=10","ad");
		<s:if test="#{isCookie}">loadpopup();</s:if>
		location.href = '${basePath}<s:property value="redirect"/>';
	</script>
</body>
</html>
