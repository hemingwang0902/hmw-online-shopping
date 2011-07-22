<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_wgzdht.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="userId" value='<s:property value="userId"/>'>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="subMenu">
      <ul><li class="re" style="width: 500px;">
      	<a href="javascript:void(0);"><B><s:property value="#session.userinfo.NAME"/></B> 关注的话题</a>
      	</li></ul>
      </div>
      <div class="line_1"></div>
      <%@include file="../common/problemList.jsp" %>
  </div>
    <div class="c_right">
     	<div class="r_column">
          <div class="column">最新话题</div>
    	<s:iterator value="%{lastestTalkList}">
            <div class="column_contentgxq">
              <div class="colun_c_pptu">
              	<a href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>'>
              		<img width="60" height="53" src='${basePath }<s:property value="IMAGE_PATH"/>' onerror="load_brand_image_60_53(this);"/>
              	</a>
              </div>
              <div class=" colun_c_ppwz">
              	<div class="colun_c_xnr">
              		<a href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>'><s:property value="CONTENT"/></a>
              	</div>
                <div class="colun_c_xnrcon"><s:property value="INTRODUCTION"/></div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
    	</s:iterator>
     	</div>
     	
     	<div class="r_column">
          <div class="column">热点话题</div>
    	<s:iterator value="%{hottestTalkList}">
            <div class="column_contentgxq">
              <div class="colun_c_pptu">
              	<a href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>'>
              		<img width="60" height="53" src='${basePath }<s:property value="IMAGE_PATH"/>' onerror="load_brand_image_60_53(this);"/>
              	</a>
              </div>
              <div class=" colun_c_ppwz">
              	<div class="colun_c_xnr">
              		<a href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>'><s:property value="CONTENT"/></a>
              	</div>
                <div class="colun_c_xnrcon"><s:property value="INTRODUCTION"/></div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
    	</s:iterator>
    	</div>
        <div class="left_b_tp"><img src="../images/main/tupian.png" /></div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
