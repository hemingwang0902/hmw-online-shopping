<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="${basePath }/head.js"></script>

<div class="top">
	<div class="top_big">
		<div class="logo">
			<img src="${imgBasePath }/main/logo.png" />
		</div>
		<div class="nav">
			<a href="${basePath }/index/home.jsp">首页</a>&nbsp;&nbsp;
			<a href="${basePath }/index/initPqlbPage.go">品牌</a>&nbsp;&nbsp;
			<a href="${basePath }/index/initHtgc.go">话题</a>&nbsp;&nbsp;
			<a href='${basePath }/index/initHyym.go?userId=<s:property value="#session.userinfo.USER_ID"/>'><s:property value="#session.userinfo.NAME"/></a>&nbsp;&nbsp;
			<s:property value="#session.userinfo.CITY_NAME"/>&nbsp;<a href="${basePath }/city.jsp" id="city_a">切换城市</a>&nbsp;&nbsp;
			<a href="${basePath }/qbtz/initQbtzForm.go">通知<span id="userdynamic_count"></span></a>&nbsp;&nbsp;
			<a href="${basePath }/wdzx/initWdzxForm.go">私信<span id="userprivate_count"></span></a>&nbsp;&nbsp;
			<a href="${basePath }/sz/initSzForm.go">设置</a>&nbsp;&nbsp;
			<a href="${basePath }/destroy.go">退出</a>
		</div>
	</div>
</div>
<input type="hidden" id="basePath" value="${basePath }" />
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div id="show_page_loading" class="show_page_loading"></div>
<a href="#show_page_loading" id="show_message"></a>