<%--会员页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_hyym.js"></script>
	<style type="text/css">
	a.checked{
		background-color: #888888;
	}
	</style>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="userId" value="<s:property value="userId"/>">
<div class="content">
	<div class="c_left">
		<%@include file="../common/search.jsp" %>
      <div class="subMenu_hyym">
      </div>
      <div class="line_1"></div>
      <div class="title_xgwt" style="border:0;">
        <div class="title_xgwt_tu">
        	<s:if test="#userBasic.IMAGE_PATH==null || #userBasic.IMAGE_PATH==''">
        		<img src="../images/main/rw_1.jpg" width="100" height="100" />
        	</s:if>
        	<s:else>
        		<img src='${basePath }<s:property value="userBasic.IMAGE_PATH"/>' width="100" height="100" />
        	</s:else>
        </div>
        <div class="title_xgwt_xner">
        	<ul>
            	<li class="tit"><a href="javascript:void(0);"><s:property value="userBasic.NAME"/></a></li>
                <li class="tit_con"><s:property value="userBasic.INTRODUCTION"/></li>
            </ul>
        </div>
        <div class="clear"></div>
      </div>
      <div class="wtym_tjda">
          <div class="tit_hyym">问<s:property value="userBasic.NAME"/>一个问题（仅他能回答）</div>
          <div class="tit_wtym_daan">
          <textarea id="CONTENT" cols="0" rows="0" style="width:540px; height:130px;"></textarea>
          </div>
          <div class="tit_hyym_anniu"><input type="button" style="width:107px;" class="bot_xttw" onclick="addProblem();"/></div>
      </div>
      <div class="tit_hyym_twwt">
      	<input type="hidden" id="problemType" value="wen">
     	<ul>
           	<li><a href="javascript:void(0);" onclick="getWenProblemList();" class="checked">他问过的问题</a></li>
            <li><a href="javascript:void(0);" onclick="getDaProblemList();">他回答的问题</a></li>
        </ul>
      </div>
     <%@include file="../common/problemList.jsp" %>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
            <s:if test="#userBasic.ATTENTION>0">
            	 <li><a id="a_attention" href="javascript:void(0);" onclick="attentionUser()" isDisAttention="true">取消关注</a></li>
            </s:if>
            <s:else>
            	 <li><a id="a_attention" href="javascript:void(0);" onclick="attentionUser()" isDisAttention="false">添加关注</a></li>
            </s:else>
                <li><a id="a_sendPrivate" href="javascript:void(0);">给他发私信</a></li>
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="javascript:void(0);">会员搜索</a></div>
            <div class="column_hyym">
	            <form action="getUserListByName.go" method="post" onsubmit="beforeSearchUser();">
	            	<input id="txt_userName" name="q" type="text" value="请输入会员姓名" style="height:22px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:130px;"/>  
		    		<input type="submit" class="bot_hyss" style=" bottom:0px; float:right;" />
	            </form>
            </div>
        </div>
		<div class="r_column">
            <div class="column">关注的话题</div>
			<s:iterator value="%{attentionTalkList}">
			<div class="column_hyym_1">
				<div class="title_hyym">
	        		<ul>
	            		<li class="tit"><a href='initHtym.go?TALK_ID=<s:property value="TALK_ID"/>'><s:property value="CONTENT"/></a></li>
	                	<li class="tit_con"></li>
	            	</ul>
				</div>
        	<div class="title_hyym_anniu">
				<input type="button" value="取&nbsp;消" style="width:55px; height:25px; background-color:#dadade" isDisAttention="true" onclick="attentionTalk('<s:property value="TALK_ID"/>');"/>
        	</div>
        	<div class="clear"></div>
		</div>
		</s:iterator>
			<div class="more"><a href='getTalkListByUserId.go?userId=<s:property value="userId"/>'>更多 &gt;&gt;</a></div>
		</div>
        <div class="r_column">
            <div class="column">关注的人</div>
            <div class="column_wtzt">关注他的人（15）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li>
              	<s:iterator value="%{wasAttentionUserList}">
              		<a href='${basePath }/index/initHyym.go?userId=<s:property value="USER_ID"/>' class="tooltips">
            		<s:if test="#IMAGE_PATH==null or #IMAGE_PATH==''">
            			<img src="../images/main/hy_1.jpg" width="25" height="25" alt="<s:property value="NAME"/>" />
            		</s:if>
            		<s:else>
            			<img src='<s:property value="IMAGE_PATH"/>' width="25" height="25" alt="<s:property value="NAME"/>" />
            		</s:else>
            			<span><s:property value="NAME"/></span>
            		</a>
				</s:iterator>
				</li>
              </ul>
          </div>
          <div class="column_wtzt">他关注的人（15）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li>
              	<s:iterator value="%{attentionUserList}">
              		<a href='${basePath }/index/initHyym.go?userId=<s:property value="USER_ID"/>' class="tooltips">
            		<s:if test="#IMAGE_PATH==null or #IMAGE_PATH==''">
            			<img src="../images/main/hy_1.jpg" width="25" height="25" alt="<s:property value="NAME"/>" />
            		</s:if>
            		<s:else>
            			<img src='<s:property value="IMAGE_PATH"/>' width="25" height="25" alt="<s:property value="NAME"/>" />
            		</s:else>
            			<span><s:property value="NAME"/></span>
            		</a>
				</s:iterator>
				</li>
              </ul>
          </div>
        </div>
        <%@include file="../common/attentionBrands.jsp" %>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
