<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>百知网</title>
	<script type="text/javascript">
		<s:if test="#{isCookie}">window.open("index/getAdByPosition.go?SHOW_TYPE=10","ad");</s:if>
		location.href = '${basePath}<s:property value="redirect"/>';
	</script>
</head>
<body>
</body>
</html>
