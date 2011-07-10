<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<link rel="stylesheet" type="text/css" href="../styles/jquery.autocomplete.css" />
	<script type="text/javascript" src="../javascripts/jquery.autocomplete.min-1.1.js"></script>
	<script type="text/javascript" src="home.js"></script>
	<style type="text/css">
	a.checked{
		background-color: #888888;
	}
	</style>
</head>
<%--
最新问题：getLatestProblemList.go
热门问题：getHottestProblemList.go
你可能感兴趣的人：getMayInterestedUser.go?userType=1
关注品牌：getAttentionUser.go?userType=2
--%>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="onePageCount" value="20">
	<input type="hidden" id="nowPage" value="1">
	<input type="hidden" id="problemType" value="zui">
	
<div class="content">
	<div class="c_left">
	  <div class="search">
	  	<a href="addProblem.jsp" id="item_a"></a>
	    <input type="text" id="title" name="title" value="搜索问题、品牌或会员 >>" style="height:21px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:450px;"/>  
	    <input type="button" class="bot_t" value="" style=" bottom:0px; float:right;cursor: pointer;" onclick="$('#item_a').click();"/>
	  </div>
      <div class="subMenu">
      	<ul>
            <li class="zui"><a href="javascript:void(0);" class="checked" onclick="getLastestProblemList();">最新问题</a></li>
            <li class="re"><a href="javascript:void(0);" onclick="getHottestProblemList();">热门问题</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      <div id="divList">
      </div>
      <div class="tiao"><a href="javascript:void(0);" onclick="getMoreProblemList();">更多 &gt;&gt;</a></div>
  </div>
    
    <div class="c_right">
    	<%@include file="../common/navigationMenu.jsp" %>
        <div class="r_column">
            <div class="column"><a href="javascript:void(0);">邀请好友</a></div>
            <div class="column_content">
                <div class="coulumn_c_left">
                    <ul>
                        <li><a href="invite.jsp">发送邮件邀请好友</a></li>
                        <li>
						<div id="d_clip_container" style="position:relative"> 
							<input id="invite" type="hidden" value="${basePath }/regiest.jsp?invite=${USER_ID}">
                        	<a id="d_clip_button" href="javascript:void(0);">生成代码邀请好友</a>
						</div> 
                        </li>
                    </ul>
                </div>
                <div class="coulumn_c_right"><img src="../images/main/youjian.png" /></div>	
            </div>
        </div>
        <div class="r_column">
            <div class="column">你可能感兴趣的人</div>
            <div id="mayInterestedUserList"></div>
          <div class="more"><a href="javascript:void(0);">更多 &gt;&gt;</a></div>
        </div>
        <div class="r_column">
          <div class="column">关注品牌</div>
          <div id="attentionUserList"></div>
          <div class="more"><a href="javascript:void(0);">更多 &gt;&gt;</a></div>
        </div>
        <div class="left_b_tp"><img src="../images/main/tupian.png" /></div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
