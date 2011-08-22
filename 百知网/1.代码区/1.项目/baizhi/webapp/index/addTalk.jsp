<!-- /webapp/index/addTalk.jsp -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../common/jsCss.jsp" %>
		<script type="text/javascript" src="index.js"></script>
		<script type="text/javascript" src="addTalk.js"></script>
		<style type="text/css">
body,input,textarea,select,button {
	font: 13px/ 22px 'Helvetica Neue', Helvetica, Arial, Sans-serif;
	padding: 0;
	margin: 0;
	color: #222;
	word-wrap: break-word;
}

textarea {
	border: 0;
	border: none;
	-moz-outline: none;
	outline: none;
	overflow: auto;
	resize: none;
}

a,a:active,a:visited,a:focus {
	color: #105CB6;
	-moz-outline: none;
	outline: none;
	text-decoration: none;
}

.modal-dialog {
	position: absolute;
	padding: 10px;
	border: none;
	background: url("../images/main/gray.png") repeat scroll 0 0 transparent;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	-o-border-radius: 10px;
	border-radius: 10px;
	width: 420px;
	z-index: 99;
}

.modal-dialog-title {
	cursor: pointer;
	font-weight: 700;
	position: relative;
	background: #B3D563;
	background: -webkit-gradient(linear, left top, left bottom, from(#1A85CB), to(#105E99) ); background : -moz-linear-gradient( top, #1A85CB,
	#105E99);
	filter: progid :   DXImageTransform.Microsoft.gradient (startColorstr = '#1a85cb', endColorstr =   '#105e99' );
	-moz-box-shadow: 0 0 1px #eee inset; -webkit-box-shadow : 0 0 1px #eee
	inset; -o-box-shadow : 0 0 1px #eee inset;
	box-shadow: 0 0 1px #eee inset;
	border: 1px solid #0F5C98;
	color: white;
	height: 33px;
	line-height: 33px;
	padding: 0 0 0 15px;
	font-size: 14px;
	text-shadow: 0 -1px 0 #0B3F61;
	-webkit-box-shadow: 0 0 1px #eee inset;
	-o-box-shadow: 0 0 1px #eee inset;
	background: -moz-linear-gradient(top, #1A85CB, #105E99);
}

.modal-dialog-content {
	background: white;
	padding: 8px 8px 0 8px;
}

.tr {
	border: 1px solid #999;
	padding: 4px;
}

.it {
	width: 100%;
	font-weight: bold;
	min-height: 66px;
	padding: 0;
	margin: 0;
	border: none;
}

.ty {
	padding: 10px 0;
	text-align: right;
}

.sy {
	margin: 0 15px 0 0;
	text-decoration: none;
	cursor: pointer;
}

.q {
	background: #3C8AE0;
	filter: progid : DXImageTransform.Microsoft.gradient ( startColorstr = '#3d92e6', endColorstr = '#3a7fd6' );
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#3D92E6), to(#3A7FD6) );
	background: -moz-linear-gradient(top, #3D92E6, #3A7FD6);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset, 0 1px 0 rgba(0, 0, 0, .3);
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset, 0 1px 0 rgba(0, 0, 0, .3);
	-o-box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset, 0 1px 0 rgba(0, 0, 0, .3);
	box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset, 0 1px 0 rgba(0, 0, 0, .3);
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .55);
	border: 1px solid #35649D;
	color: white !important;
}

.q,.p,.o {
	font: normal 14px/ 22px "Helvetica Neue", Arial, sans-serif;
	text-decoration: none !important;
	vertical-align: middle;
	display: inline-block;
	text-align: center;
	padding: 4px 10px;
	cursor: pointer;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-o-border-radius: 3px;
	border-radius: 3px;
}

.w {
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-o-border-radius: 3px;
	border-radius: 3px;
}
</style>
	</head>

	<body>
		<input type="hidden" id="basePath" value="${basePath }" />
		<div class="modal-dialog">
			<div class="modal-dialog-title modal-dialog-title-draggable" id=":0">
				<span class="modal-dialog-title-text">添加话题</span><span
					class="modal-dialog-title-close"></span>
			</div>
			<div class="modal-dialog-content">
				<form id="ProblemForm">
				<div id="error_1" style="color: #f00;"></div>
				<div class="tr temphooker">
					<textarea id="CONTENT" name="CONTENT" class="it label-input-label" title="在这里输入话题名称"></textarea>
				</div>
				<div class="fs" style="display: none"></div>
				<strong>可选：</strong>话题介绍
				<div class="tr">
					<textarea id="INTRODUCTION" name="INTRODUCTION" class="it"></textarea>
					
				</div>
				<div class="ty">
					<a href="javascript:void(0);" id="cancel" class="sy" onclick="parent.$.fancybox.close();">取消</a>
					<a href="javascript:void(0);" id="save" class="wq">添加话题</a>
				</div>
				</form>
			</div>
		</div>
	</body>
</html>
