<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_wtymtit.js"></script>
	<style type="text/css">
		.btn_wc{ width:66px; height:30px; background:url(../images/main/an_wc.jpg); border:0;}
	</style>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="problemId" value='<s:property value="problemId"/>'>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="list_xgwt_xght">话题：
      	<s:iterator value="%{talkList}" >
      		<a href='${basePath }/index/initHtym.go?TALK_ID=<s:property value="TALK_ID"/>' style="margin-right: 5px;"><s:property value="CONTENT"/></a>
      	</s:iterator>
      </div>
      <div class="list_hylb">
      	<input type="button" class="bot_tjht"/>
      	<div id="addTalk" style="display: none;">
	      	<input id="talkId" type="hidden"/>
	      	<input id="talkName" type="text" style="height:21px; padding-top:5px; padding-left:5px; width:370px;" />
	      	<input type="button" class="btn_wc" />
      	</div>
      </div>
      <div class="subMenu_hylb">
		<div class="title_wtym_tit"><s:property value="problem.CONTENT"/></div>
           <div class="title_wtym_con">
               <p><s:property value="problem.RELEVANT_DETAILS"/></p>
           </div>
      </div>
      <div class="line_1"></div>
      <div style=" margin-top:15px;">
          <div class="title_wtym">
            <div class="title_wtym_tit"><a href="javascript:void(0);">为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品</a></div>
            <div class="title_wtym_con">
                <p>为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品为什么人们貌似能接受劣质的互联网产品，却不能为什么。</p>
                <p>人们貌似能接受劣质的互联网产品为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品为什么人们貌似能接受劣质的互联网产品，却不能为什么人们貌似能接受劣质的互联网产品。</p>
            </div>
          </div>
          
            <div class="tit_bot_wtym"><a href="javascript:void(0);">1 个答案</a> • <a href="javascript:void(0);">5个关注</a> • <a href="javascript:void(0);">收藏</a> • <a href="javascript:void(0);">添加评论</a> • <a href="javascript:void(0);">分享</a></div>
            <div class="clear"></div>
      </div>
      <div class="wtym_tjda">
          <div class="tit_wtym_tjda">添加答案</div>
          <div class="tit_wtym_daan"><textarea cols="0" rows="0" style="width:540px; height:130px;"></textarea>
          </div>
          <div class="tit_wtym_tjda_anniu"><input name="" type="button" style="width:88px;" value=""  class="bot_tjda" /></div>
      </div>
  </div>
    
    
	<div class="c_right">
		<div class="right_subMenu">
			<ul>
                <li ><a id="a_attention" href="javascript:void(0);">添加关注</a></li>
                <li><a id="a_collection" href="javascript:void(0);">添加收藏</a></li>
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
            	<a href="javascript:void(0);">邀请他人回答（<s:property value="problem.INVITE_COUNT"/>）</a>
            	<div style="display: none;">
            		<input type="hidden" id="userId">
            		<input id="userName">
            	</div>	
            </div>
      </div>
        <div class="r_column">
          <div class="column_wtzt">问题状态</div>
            <div class="column_wt_blr">被浏览 <s:property value="problem.BROWSE_COUNT"/> 次，相关话题关注者  <s:property value="talkUserCount"/> 人</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="javascript:void(0);" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
              </ul>
          </div>
          </div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
