<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- /webapp/index/list_wdzxdetail.jsp -->
<html>
<head>
	<link type="text/css" rel="stylesheet" href="../styles/message.css" />
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_wdzxdetail.js"></script>
</head>

<body>
<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <div class="subMenu">
      	<div class="subMenu_wdzx_1"><a href="initWdzxForm.go">返回私信首页</a></div>
      </div>
      <input type="hidden" id="SEND_ID" name="SEND_ID" value="${SEND_ID }" />
      <div class="line_1">发私信给&nbsp;${returnMap.NAME }：</div>
      <div>
      	<textarea style="width: 566px;margin-bottom: 10px;height: 80px;" id="PRIVATE_CONTENT"></textarea>
      	<div id="div_facelist" style="width: 566px;">
			<s:iterator id="number" begin="1" end="32" step="1"  status='st'>
				<img class="face" src='${basePath }/images/face/<s:property value='#st.count'/>.gif' onclick="insertFace('<s:property value="#st.count"/>');">
			</s:iterator>
		</div>
      </div>
      <div>
      		<div id="PRIVATE_MESSAGE" style="color: red;float: left;"></div>
      		<div  style="float: right;text-align: right;">
      			<input type="button" value="发送" onclick="saveData()" class="button_2" />
      		</div>
      </div>
      <div class="subMenu"></div>
      <div id="userprivatelist"></div>
  </div>
    <div class="c_right">
    	<div class="av">担心骚扰？可以<a href="../usernotice/getUserNoticeList.go">设置</a>为只接收「我关注的人」给我发私信。</div>
  	</div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
	<a href="#private_window" id="private_a"></a>
</body>
</html>
