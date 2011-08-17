<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="${basePath}/index/index.js"></script>
	<script type="text/javascript" src="${basePath}/index/htgc.js"></script>
</head>
<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
		<%@include file="../common/search.jsp" %>
  		<div class="xor">
			<div class="xnr">
			<s:iterator value="talkTypeAndTalkList" var="talkType">
				<div class="xrk">${talkType.TYPE_NAME }</div>
				<div class="xxj xv">
					<div class="xxe xuk">
					<s:iterator value="#talkType.TALKS" var="talk">
						<a class="xao" href="${basePath }/index/initHtym.go?TALK_ID=${talk.TALK_ID}" >${talk.CONTENT }</a>
					</s:iterator>
					</div>
				</div>
			</s:iterator>
			</div>
		</div>
	</div>
    <div class="c_right">
		<div class="r_column">
			<div class="column">热门话题</div>
			<div class="dzsw_rmht">
				<ul class="xhp">
				<s:iterator value="hottestTalkList" var="talk_1">
					<li class="xqk"><a class="xao" href="${basePath }/index/initHtym.go?TALK_ID=${talk_1.TALK_ID}">${talk_1.CONTENT }</a></li>
            	</s:iterator>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
