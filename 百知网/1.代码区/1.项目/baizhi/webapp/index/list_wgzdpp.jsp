<%-- 他关注的品牌 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="index.js"></script>
	<script type="text/javascript" language="javascript"  src="list_wgzdpp.js"></script>
</head>

<body>
	<input type="hidden" id="USER_ID" value='<s:property value="USER_ID"/>'>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="subMenu"><s:property value="USER_NAME"/> 关注的品牌</div>
      <div class="line_1"></div>
       <%@include file="../common/problemList.jsp" %>
  </div>
    
    
    <div class="c_right">
    	<div class="r_column">
            <div class="column">热点品牌</div>
        <s:iterator value="%{hottestBrandList}">
          <div class="column_contentgxq">
              <div class="colun_c_pptu">
              	<a href='initPpym.go?BRAND_ID=<s:property value="BRAND_ID"/>'>
              	<s:if test="IMAGE_PATH == null">
              		<img src='${basePath }<s:property value="IMAGE_PATH"/>' />
              	</s:if>
              	<s:else>
              		<img src="../images/main/pptp_1.png" />
              	</s:else>
              	</a>
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href='initPpym.go?BRAND_ID=<s:property value="BRAND_ID"/>'><s:property value="NAME"/></a></div>
                    <div class="colun_c_xnrcon"><s:property value="INTRODUCTION"/></div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
        </s:iterator>    
          <div class="more"><a href="list_pqlb.jsp">更多 &gt;&gt;</a></div>
        </div>
        
        <div class="r_column">
            <div class="column">最新品牌</div>
        <s:iterator value="%{LastestBrandList}">
          <div class="column_contentgxq">
              <div class="colun_c_pptu">
              	<a href='initPpym.go?BRAND_ID=<s:property value="BRAND_ID"/>'>
              	<s:if test="IMAGE_PATH == null">
              		<img src='${basePath }<s:property value="IMAGE_PATH"/>' />
              	</s:if>
              	<s:else>
              		<img src="../images/main/pptp_1.png" />
              	</s:else>
              	</a>
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href='initPpym.go?BRAND_ID=<s:property value="BRAND_ID"/>'><s:property value="NAME"/></a></div>
                    <div class="colun_c_xnrcon"><s:property value="INTRODUCTION"/></div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
        </s:iterator>   
          <div class="more"><a href="list_pqlb.jsp">更多 &gt;&gt;</a></div>
        </div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
