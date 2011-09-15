<!-- /index/list_ppym.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="index.js"></script>
	<script type="text/javascript" language="javascript"  src="list_ppym.js"></script>
</head>

<body>
	<input type="hidden" id="BRAND_ID" value='<s:property value="brand.BRAND_ID"/>' />
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="line_1"></div>
      <div class="tit_1">
      		<div class="tit_google">
      			<img width="100" height="100" src='${basePath }<s:property value="brand.IMAGE_PATH"/>' onerror="load_brand_image_100_100(this);"/>
      		</div>
            <div class="tit_google_con">
            	<ul>
                	<li><a href="javascript:void(0);"><s:property value="brand.NAME"/></a></li>
                    <li class="tit_google_conter"><s:property escapeHtml="false" value="brand.INTRODUCTION"/></li>
                </ul>
            </div>
            <div class="clear"></div>
      </div>
      <%@include file="../common/problemList.jsp" %>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
            <s:if test="brand.ATTENTION>0">
            	 <li><a href="javascript:void(0);" isDisAttention="true" onclick="attentionBrand(this);">取消关注</a></li>
            </s:if>
            <s:else>
            	 <li><a href="javascript:void(0);" isDisAttention="false" onclick="attentionBrand(this);">添加关注</a></li>
            </s:else>
               
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="javascript:void(0);">关注该品牌的人</a></div>
            <div class="column_xgwt_hy">
              <ul>
              	<li>
              	<s:iterator value="%{wasAttentionUserList}">
              		<a href="${basePath }/index/initHyym.go?userId=<s:property value="USER_ID"/>" class="tooltips">
		      		<s:if test="IMAGE_PATH==null">
		      			<img src="../images/main/hy_1.jpg" alt='<s:property value="NAME"/>' width="25" height="25"/>
		      		</s:if>
		      		<s:else>
		      			<img src='${basePath }<s:property value="IMAGE_PATH"/>' alt='<s:property value="NAME"/>' width="25" height="25"/>
		      		</s:else>
              			<span><s:property value="NAME"/></span>
              		</a>
              	</s:iterator>
              	</li>
              </ul>
          </div>
        </div>
        
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
