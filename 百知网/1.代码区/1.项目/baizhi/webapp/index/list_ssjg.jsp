<%-- 搜索结果页 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="../common/jsCss.jsp"%>
		<script type="text/javascript" src="index.js"></script>
		<script type="text/javascript" src="list_ssjg.js"></script>
	</head>

	<body>
		<%@include file="../common/head.jsp"%>
		<div class="content">
			<div class="c_left">
				<%@include file="../common/search.jsp"%>
				<div style="font-weight: bold;"><span id="span_q" style="margin-right: 5px;background-color: #90EE90"><s:property escapeHtml="true" value="q"/></span>的搜索结果</div>
				<%@include file="../common/problemList.jsp"%>
			</div>
			<div class="c_right">
				<div class="r_column"></div>
			</div>
			<div class="clear"></div>
		</div>
		<%@include file="../common/foot.jsp"%>
	</body>
</html>
