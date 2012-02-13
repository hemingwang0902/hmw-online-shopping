<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="../index/index.js"></script>
	<script type="text/javascript" language="javascript" src="../index/list_qbtz.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <div class="subMenu">
      	<ul>
            <li class="zui" id="noreadmessage"><a href="javascript:;">未读通知</a></li>
            <li class="re" id="allreadmessage"><a href="javascript:;">已读通知</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      	<input type="hidden" id="nowPage" name="nowPage" value="1" />
      	<input type="hidden" id="onePageCount" name="onePageCount" value="10" />
      	<input type="hidden" id="IS_OPEN" value="0" />
      	<div id="userdynamiclist">
      	
      	</div>
        <div style="color: red;padding-left: 10px;" id="more_tip_message"></div>
      <div class="tiao"><a href="javascript:;" id="list_pqlb_more">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
    	<%@include file="../common/navigationMenu.jsp" %>
    	<%@include file="../common/inviteFriends.jsp" %>
    	<%@include file="../common/interestUsers.jsp" %>
        </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
