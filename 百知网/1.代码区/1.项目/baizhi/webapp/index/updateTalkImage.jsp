<!-- /webapp/index/updateTalkImage.jsp -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../common/jsCss.jsp" %>
		<script type="text/javascript" src="updateTalkImage.js"></script>
		<link type="text/css" rel="stylesheet" href="${cssBasePath }/dialog.css" />
	</head>

	<body>
		<input type="hidden" id="basePath" value="${basePath }" />
		<div class="modal-dialog">
			<div class="modal-dialog-title modal-dialog-title-draggable" id=":0">
				<span class="modal-dialog-title-text">修改话题图片</span><span
					class="modal-dialog-title-close"></span>
			</div>
			<div class="modal-dialog-content">
				<form action="uploadTalkImage.go" method="post" id="UPLOAD_FORM" enctype="multipart/form-data" target="_parent">
					<input type="hidden" id="TALK_ID" name="TALK_ID" value="${param.TALK_ID}">
				<div class="tr temphooker">
					<input type="file" id="upload" name="upload">
				</div>
				<div class="fs">支持 jpg, gif, png 格式的图片，不要超过 2MB。建议图片尺寸大于 100×100</div>
				<div class="ty">
					<a href="javascript:void(0);" id="cancel" class="sy" onclick="parent.$.fancybox.close();">取消</a>
					<a href="javascript:void(0);" id="save" class="wq" onclick='$("#UPLOAD_FORM").submit();'>开始上传</a>
				</div>
				</form>
			</div>
		</div>
	</body>
</html>
