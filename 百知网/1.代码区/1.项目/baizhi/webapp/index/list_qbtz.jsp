<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_qbtz.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <div class="subMenu">
      	<ul>
            <li class="zui" id="noreadmessage"><a href="javascript:;">未读通知</a></li>
            <li class="re" id="allreadmessage"><a href="javascript:;">全部通知</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      	<input type="hidden" id="nowPage" name="nowPage" value="1" />
      	<input type="hidden" id="onePageCount" name="onePageCount" value="10" />
      	<input type="hidden" id="IS_OPEN" value="0" />
      	<div id="userdynamiclist">
      	
      	</div>
        
       
        
        
      <div class="tiao"><a href="javascript:;" id="list_pqlb_more">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
                <li><a href="#">所有问题</a></li>
                <li><a href="#">我关注的问题</a></li>
                <li><a href="#">问我的问题</a></li>
                <li><a href="#">邀请我回答的问题</a></li>
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="#">邀请好友</a></div>
            <div class="column_content">
                <div class="coulumn_c_left">
                    <ul>
                        <li><a href="#">发送邮件邀请好友</a></li>
                        <li><a href="#">生成代码邀请好友</a></li>
                    </ul>
                </div>
                <div class="coulumn_c_right"><img src="../images/main/youjian.png" /></div>	
            </div>
        </div>
        <div class="r_column">
            <div class="column">你可能感兴趣的人</div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="../images/main/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="../images/main/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="../images/main/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq" style="border:0; margin-bottom:0px;">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="../images/main/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="more"><a href="#">更多 &gt;&gt;</a></div>
        </div>
        </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
