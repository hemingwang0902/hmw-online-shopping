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
	.current{
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
        	<img src='${basePath }<s:property value="userBasic.IMAGE_PATH"/>' width="100" height="100" onerror="load_person_image_102_102(this);"/>
        </div>
        <div class="title_xgwt_xner">
        	<ul>
            	<li class="tit"><a href="javascript:void(0);"><s:property value="userBasic.NAME"/></a></li>
            	<li style="list-style: none;"> <s:property value="userBasic.SCORE"/>个积分 (<b><s:property value="userBasic.LEVEL"/></b>)</li>
                <li class="tit_con"><s:property value="userBasic.INTRODUCTION"/></li>
            </ul>
        </div>
        <div class="clear"></div>
      </div>
      <s:if test="userId != #session.USER_ID">
      <div class="wtym_tjda">
          <div class="tit_hyym">问<s:property value="userBasic.NAME"/>一个问题（仅他能回答）</div>
          <div class="tit_wtym_daan">
          <textarea id="CONTENT" cols="0" rows="0" style="width:540px; height:130px;"></textarea>
          </div>
          <div class="tit_hyym_anniu"><input type="button" style="width:107px;cursor: pointer;" class="bot_xttw" onclick="addProblem();"/></div>
      </div>
      </s:if>
      <div class="tit_hyym_twwt">
      	<input type="hidden" id="problemType" value="wen">
     	<ul>
           	<li><a id="a_wenGuo" href="javascript:void(0);" onclick="getWenProblemList();" class="current">他问过的问题</a></li>
            <li><a id="a_daGuo" href="javascript:void(0);" onclick="getDaProblemList();">他回答的问题</a></li>
        </ul>
      </div>
     <%@include file="../common/problemList.jsp" %>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
            <s:if test="userBasic.ATTENTION>0">
            	 <li><a id="a_attention" href="javascript:void(0);" onclick="attentionUser()" isDisAttention="true">取消关注</a></li>
            </s:if>
            <s:else>
            	 <li><a id="a_attention" href="javascript:void(0);" onclick="attentionUser()" isDisAttention="false">添加关注</a></li>
            </s:else>
                <li>
                	<a id="a_sendPrivate" href="javascript:void(0);" onclick="$('#private_a').click();">给他发私信</a>
                		<a href="#private_window" id="private_a"></a>
	<div style="display: none;">
		<div style="height: 250px;width: 450px;" id="private_window">
			<div style="width:100%;text-align: left;margin-bottom: 10px;background-color: #98b012;height: 30px;padding-top: 10px;font-size: 15px;color: white;" >发送私信</div>
			<div style="width:100%; ">
				<div style="float: left;width: 70px;">
					<div style="text-align: right;padding-right: 15px;">内容：</div>
				</div>
				<div style="float: left;">
					<div><textarea style="width: 357px;margin-bottom: 10px;height: 80px;" id="PRIVATE_CONTENT"></textarea></div>
					<div >
						<div id="PRIVATE_MESSAGE" style="color: red;float: left;"></div>
						<div style="text-align: right;float: right;padding-right: 20px;">
							<input type="button" value="取消" onclick="$.fancybox.close();" />
							<input type="button" value="发送" onclick="sendPrivate()" />
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
                </li>
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="javascript:void(0);">会员搜索</a></div>
            <div class="column_hyym">
	            <form action="getUserListByName.go" method="post" onsubmit="return beforeSearchUser();">
	            	<input id="txt_userName" name="q" type="text" value="请输入会员姓名" style="height:22px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:130px;"/>  
		    		<input type="submit" value="" class="bot_hyss" style=" bottom:0px; float:right;cursor: pointer;" />
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
        	<s:if test="ATTENTION>0">
				<input id='gzht_<s:property value="TALK_ID"/>' type="button" value="取&nbsp;消" style="width:55px; height:25px; background-color:#dadade" isDisAttention="true" onclick="attentionTalk('<s:property value="TALK_ID"/>');"/>
			</s:if>
            <s:else>
				<input id='gzht_<s:property value="TALK_ID"/>' type="button" value="关&nbsp;注" style="width:55px; height:25px; background-color:#dadade" isDisAttention="false" onclick="attentionTalk('<s:property value="TALK_ID"/>');"/>
			</s:else>
        	</div>
        	<div class="clear"></div>
		</div>
		</s:iterator>
			<div class="more"><a href='initWgzdht.go?userId=<s:property value="userId"/>'>更多 &gt;&gt;</a></div>
		</div>
        <div class="r_column">
            <div class="column">关注的人</div>
            <div class="column_wtzt">关注他的人（<s:property value="wasAttentionUserSize"/>）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li>
              	<s:iterator value="%{wasAttentionUserList}">
              		<a href='${basePath }/index/initHyym.go?userId=<s:property value="USER_ID"/>' class="tooltips">
            		<s:if test="IMAGE_PATH==null or IMAGE_PATH==''">
            			<img src="${basePath }/<s:property value="IMAGE_PATH"/>" width="25" height="25" alt="<s:property value="NAME"/>" onerror="load_person_image_25_25(this)" />
            		</s:if>
            		<s:else>
            			<img src='${basePath }/<s:property value="IMAGE_PATH"/>' width="25" height="25" alt="<s:property value="NAME"/>" onerror="load_person_image_25_25(this)" />
            		</s:else>
            			<span><s:property value="NAME"/></span>
            		</a>
				</s:iterator>
				</li>
              </ul>
          </div>
          <div class="column_wtzt">他关注的人（<s:property value="attentionUserSize"/>）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li>
              	<s:iterator value="%{attentionUserList}">
              		<a href='${basePath }/index/initHyym.go?userId=<s:property value="USER_ID"/>' class="tooltips">
            		<s:if test="IMAGE_PATH==null or IMAGE_PATH==''">
            			<img src="${basePath }/<s:property value="IMAGE_PATH"/>" width="25" height="25" alt="<s:property value="NAME"/>" onerror="load_person_image_25_25(this)" />
            		</s:if>
            		<s:else>
            			<img src="${basePath }/<s:property value="IMAGE_PATH"/>" width="25" height="25" alt="<s:property value="NAME"/>" onerror="load_person_image_25_25(this)" />
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
