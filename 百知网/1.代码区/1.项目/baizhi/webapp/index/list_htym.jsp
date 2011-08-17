<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@include file="../common/basePath.jsp" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="index.js"></script>
	<script type="text/javascript" language="javascript"  src="list_htym.js"></script>
	<style type="text/css">
		.error{color: #ff0000;}
	</style>
</head>

<body>
	<input type="hidden" id="TALK_ID" value='<s:property value="talk.TALK_ID"/>' />
 	<a href='${basePath }/index/updateTalkImage.jsp?TALK_ID=<s:property value="talk.TALK_ID"/>' id="item_talkImage"></a>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="line_1"></div>
      <div class="tit_1">
      		<div class="tit_google">
      		<img width="100" height="100" src='${basePath }<s:property value="talk.IMAGE_PATH"/>' onerror="load_brand_image_100_100(this);" style="cursor: pointer;" onclick="$('#item_talkImage').click();"/>
      		</div>
            <div class="tit_google_con" >
            	<ul>
                	<li><a href="javascript:void(0);"><s:property value="talk.CONTENT"/></a></li>
                    <li class="tit_google_conter">
                    	<div id="DIV_TALK_INTRODUCTION_0">
                    	<span id="SPAN_TALK_INTRODUCTION"><s:property value="talk.INTRODUCTION" escapeHtml="false"/></span>
                    	<a href="javascript:void(0);" onclick="$('#DIV_TALK_INTRODUCTION_0').hide();$('#DIV_TALK_INTRODUCTION_1').show();">
                    	<s:if test='"" eq talk.INTRODUCTION'>添加描述</s:if>
                    	<s:else>修改</s:else>
                    	</a>
						</div>
		<div id="DIV_TALK_INTRODUCTION_1" style="display: none;">
			<textarea  id="TALK_INTRODUCTION" style="width: 420px;height:100px"><s:property value="talk.INTRODUCTION"/></textarea>
			<% 
			CKEditorConfig settings = new CKEditorConfig();
			settings.addConfigValue("width", "500");
			settings.addConfigValue("toolbar", "Brand");
			%>
            <ckeditor:replace basePath="${jsBasePath}/ckeditor/" config="<%=settings %>" replace="TALK_INTRODUCTION" />
			<div id="error_3" class="error"></div>
			<input type="button" id="btnSaveTalk" value="保存" onclick="updateTalkIntroduction();">
		</div>
                    </li>
                </ul>
            </div>
            <div class="clear"></div>
      </div>
      <%@include file="../common/problemList.jsp" %>
  </div>
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
            <s:if test="talk.ATTENTION>0">
            	 <li><a href="javascript:void(0);" isDisAttention="true" onclick="attentionBrand(this);">取消关注</a></li>
            </s:if>
            <s:else>
            	 <li><a href="javascript:void(0);" isDisAttention="false" onclick="attentionBrand(this);">添加关注</a></li>
            </s:else>
               
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="javascript:void(0);">关注该话题的人</a></div>
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
