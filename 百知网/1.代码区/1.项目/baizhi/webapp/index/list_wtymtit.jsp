<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_wtymtit.js"></script>
	
	<script type="text/javascript" src="${jsBasePath}/ckeditor/ckeditor.js"></script>
	<style type="text/css">
		.btn_wc{ width:66px; height:30px; background:url(../images/main/an_wc.jpg); border:0;}
		.error{color: #ff0000;}
	</style>
	
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="problemId" value='<s:property value="problemId"/>'>
	<input type="hidden" id="loginUser_USER_ID" value='<s:property value="#session.userinfo.USER_ID"/>'>
	<input type="hidden" id="loginUser_NAME" value='<s:property value="#session.userinfo.NAME"/>'>
	<input type="hidden" id="loginUser_INTRODUCTION" value='<s:property value="#session.userinfo.INTRODUCTION"/>'>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div id="div_xght" class="list_xgwt_xght">话题：
      	<s:iterator value="%{talkList}" >
      		<a  href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>' style="font-weight:100;text-decoration:underline; margin-right: 5px;color:#292a2b;"><s:property value="CONTENT"/></a>
      	</s:iterator>
      </div>
      <div id="error_1" class="error"></div>
      <div class="list_hylb">
      	<input id="btnShowAddTalk" type="button" class="bot_tjht" style="cursor: pointer;display: none;"/>
      	<span id="divAddTalk" style="display: none;">
	      	<input id="TALK_CONTENT" type="text" style="height:21px; padding-top:5px; padding-left:5px; width:370px;" />
	      	<input type="button" class="btn_wc" onclick="addTalk();" style="cursor: pointer;"/>
      	</span>
      </div>
      
      <div id="div_xgpp" class="list_xgwt_xght" style="display: none;">品牌：
      	<s:iterator value="%{brandList}" >
      		<a href='${basePath }/index/initPpym.go?BRAND_ID=<s:property value="BRAND_ID"/>' style="margin-right: 5px;" BRAND_ID='<s:property value="BRAND_ID"/>'><s:property value="NAME"/></a>
      	</s:iterator>
      </div>
      <div id="error_5" class="error"></div>
      <div class="list_hylb">
      	<input  id="btnShowAddBrand" type="button" class="bot_tjht" style="float: left;cursor: pointer;display: none;background-image: url(../images/main/tjpp.png)"/>
      	<div id="divAddBrand" style="display: none;float: left;">
	      	<input id="BRAND_ID" type="text" style="height:26px; padding-top:5px; padding-left:5px; width:370px;" />
			<div id="div_BRAND" style="border: solid 1px;height: 26px;padding:0;margin:0;display: none;">
				<div style="clear: both;height: 25px;background-color: gray;float: left;border: solid 1px;">
					<div id="BRAND_NAME" style="height: 25px;float: left;margin:0;">test</div>
					<div id="DEL_BRAND" style="float: left;background:url(../images/main/hlcr_btn.gif) no-repeat;width: 16px;height: 16px;cursor: pointer;"></div>
				</div>
			</div>
	      	<input type="button" class="btn_wc" onclick="addBrand();" style="cursor: pointer;"/>
      	</div>
      </div>
      
      <div class="subMenu_hylb">
		<div id="div_problem_content_0" class="title_wtym_tit" >
			<span id="span_problem_content" style="font-weight:bold;color:#276399;"><s:property value="problem.CONTENT"/></span>
			<a href="javascript:void(0);" onclick="$('#div_problem_content_0').hide();$('#div_problem_content_1').show();">修改</a>
		</div>
		<div id="div_problem_content_1" class="title_wtym_tit" style="display: none;">
			<textarea id="PROBLEM_CONTENT" style="width: 420px;height:100px"><s:property value="problem.CONTENT"/></textarea>
			<div id="error_3" class="error"></div>
			<input type="button" id="btnSaveProblem_0" value="保存" onclick="updateProblemContent();">
		</div>
		
        <div id="div_problem_DETAILS_0" class="title_wtym_con">
            <span id="span_problem_DETAILS_0"><s:property value="problem.RELEVANT_DETAILS"/></span>
            <a href="javascript:void(0);" onclick="$('#div_problem_DETAILS_0').hide();$('#div_problem_DETAILS_1').show();">修改</a>
        </div>
        <div id="div_problem_DETAILS_1" class="title_wtym_con" style="display: none;">
            <textarea id="PROBLEM_RELEVANT_DETAILS" style="width: 420px;height:100px"><s:property value="problem.RELEVANT_DETAILS"/></textarea>
            <div id="error_4" class="error"></div>
            <input type="button" id="btnSaveProblem_1" value="保存" onclick="updateProblemDetail();">
        </div>
      </div>
      <div class="line_1"></div>
 	<%@include file="../common/problemList.jsp" %>
       <div id="div_tjda" class="wtym_tjda" style="display: none;width: 540px;height:370px">
          <div class="tit_wtym_tjda">添加答案</div>
          <div class="tit_wtym_daan" >
          	<textarea id="ANSWER_CONTENT" cols="0" rows="0" style="width:240px; height:100px;"></textarea>
          </div>
          <div id="error_2" class="error" style="margin-right: 10px;float: left"></div>
          <div class="tit_wtym_tjda_anniu">
          	<input type="button" style="width:88px;cursor: pointer;" onclick="addAnswer();" class="bot_tjda" />
          </div>
      </div>
  </div>
	<div class="c_right">
		<div class="right_subMenu">
			<ul>
            <s:if test="problem.ATTENTION>0">
            	 <li><a id="a_attention" href="javascript:void(0);" isDisAttention="true">取消关注</a></li>
            </s:if>
            <s:else>
            	 <li><a id="a_attention" href="javascript:void(0);" isDisAttention="false">添加关注</a></li>
            </s:else>
            <s:if test="problem.COLLECTION>0">
            	 <li><a id="a_collection" href="javascript:void(0);" isDisAttention="true">取消收藏</a></li>
            </s:if>
            <s:else>
            	 <li><a id="a_collection" href="javascript:void(0);" isDisAttention="false">添加收藏</a></li>
            </s:else>
            </ul>
		</div>
		<div class="r_column">
			<div class="column">相关问题</div>
			<div class="column_xgwt">
				<ul>
				<s:iterator value="%{nearProblemList}">
      				<li><a href="${basePath }/index/wtymDetail.go?problemId=<s:property value="PROBLEM_ID"/>"><s:property value="CONTENT"/></a></li>
      			</s:iterator>
				</ul>
			</div>
            <div class="more"><a href='list_xgwt.jsp?problemId=<s:property value="problemId"/>'>更多 &gt;&gt;</a></div>
        </div>
        <div class="r_column">
            <div class="column_yqtr">
            	<a href="javascript:void(0);" id="a_invite">邀请他人回答（<span id="INVITE_COUNT"><s:property value="problem.INVITE_COUNT"/></span>）</a>
            	<div id="div_invite" style="display: none;clear: both; background-color:#adc318;">
            		<input id="WAS_USER_ID" ><br>
					<div id="div_USER" style="border: solid 1px;height: 26px;padding:0;margin:0;display: none;">
						<div style="clear: both;height: 25px;background-color: gray;float: left;border: solid 1px;">
							<div id="USER_NAME" style="height: 25px;float: left;margin:0;">test</div>
							<div id="DEL_USER" style="float: left;background:url(../images/main/hlcr_btn.gif) no-repeat;width: 16px;height: 16px;cursor: pointer;"></div>
						</div>
					</div>
            		<input type="button" class="btn_wc" style="cursor: pointer;" onclick="addProblemInvite();"/>
            	</div>	
            </div>
      </div>
        <div class="r_column" style="padding-top:60px;">
          <div class="column_wtzt">问题状态</div>
            <div class="column_wt_blr">被浏览 <s:property value="problem.BROWSE_COUNT"/> 次，相关话题关注者  <s:property value="talkUserCount"/> 人</div>
            <div class="column_xgwt_hy">
            	<s:iterator value="%{talkUserList}">
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
          </div>
          </div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
