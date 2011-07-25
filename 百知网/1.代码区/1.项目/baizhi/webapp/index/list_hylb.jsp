<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="../index/index.js"></script>
	<script type="text/javascript" language="javascript"  src="../index/list_hylb.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      
      <div class="line_1"></div>
      <input type="hidden" id="nowPage" name="nowPage" value="1" />
      <input type="hidden" id="onePageCount" name="onePageCount" value="10" />
      <div id="list_hylb">
      
      
      </div>
      <div style="color: red;padding-left: 10px;" id="more_tip_message"></div>
      <div class="tiao"><a href="javascript:;" id="list_hylb_more">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
  <div class="r_column">
            <div class="column">热点会员</div>
            
            <s:iterator value="returnMap.hotlist" var="hotlist">
            <s:if test="#hotlist!=null&&#hotlist.USER_ID!=''">
            <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="../index/initHyym.go?userId=${hotlist.USER_ID }"><img src="${basePath }/${hotlist.IMAGE_PATH }" onerror="load_person_image_25_25(this)" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="../index/initHyym.go?userId=${hotlist.USER_ID }">${hotlist.NAME }</a></div>
                </div>
                <div class=" colun_c_main">${hotlist.INTRODUCTION}</div>
          	</div>
          	</s:if>
            </s:iterator><!--
            
            <div class="more"><a href="#">更多 &gt;&gt;</a></div>
        --></div>
        <div class="r_column">
            <div class="column">最新会员</div>
              
          	<s:iterator value="returnMap.newlist" var="newlist">
          	<s:if test="#newlist!=null&&#newlist.USER_ID!=''">
            <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="../index/initHyym.go?userId=${newlist.USER_ID }"><img src="${basePath }/${newlist.IMAGE_PATH }" onerror="load_person_image_25_25(this)" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="../index/initHyym.go?userId=${newlist.USER_ID }">${newlist.NAME }</a></div>
                </div>
                <div class=" colun_c_main">${newlist.INTRODUCTION}</div>
          	</div>
          	</s:if>
            </s:iterator>
          	
          	
          	
          	
            <!--<div class="more"><a href="#">更多 &gt;&gt;</a></div>
        --></div>
        
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
