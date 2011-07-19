<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>

<div id='pl_list_<s:property value="ANSWER_ID"/>'>
<s:iterator value="%{answerReviewList}">
	<div class="hwbj"><s:property value="CONTENT"/></div>
    <div class="fg_2011"><a href='${basePath}/index/initHyym.go?userId=<s:property value="USER_ID"/>'><s:property value="NAME"/></a> • <s:property value="CREATE_TIME"/></div>
</s:iterator>
</div>
<div class="tex"><textarea id='txt_pl_<s:property value="ANSWER_ID"/>' class="texta"></textarea></div>
<div class="guanbi">
	<span id='pl_error_<s:property value="ANSWER_ID"/>' class="error"></span>
	<a href="javascript:void(0);" onclick="$('#div_pinglun_<s:property value="ANSWER_ID"/>').hide();">关闭</a>
	<input type="button" class="an_pl" value="" onclick="addAnswerReview('<s:property value="ANSWER_ID"/>');"/>
</div>
<div class="line_1"></div>

        


