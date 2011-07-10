<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="${basePath }/head.js"></script>

<div class="top">
	<div class="top_big">
		<div class="logo">
			<img src="${imgBasePath }/main/logo.png" />
		</div>
		<div class="nav">
			<a href="${basePath }/index/home.jsp">首页</a>&nbsp;&nbsp;
			<a href="${basePath }/qbtz/initQbtzForm.go">通知</a>&nbsp;&nbsp;
			<a href="${basePath }/wdzx/initWdzxForm.go">私信<span id="userprivate_count"></span></a>&nbsp;&nbsp;
			<a href="${basePath }/sz/initSzForm.go">设置</a>&nbsp;&nbsp;
			<a href="${basePath }/regiest.jsp">注册</a>
		</div>
	</div>
</div>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>