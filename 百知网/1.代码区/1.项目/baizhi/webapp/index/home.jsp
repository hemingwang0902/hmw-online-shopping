<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<link rel="stylesheet" type="text/css" href="../styles/jquery.autocomplete.css" />
	<script type="text/javascript" src="../javascripts/jquery.autocomplete.min-1.1.js"></script>
	<script type="text/javascript" src="home.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="onePageCount" value="20">
	<input type="hidden" id="nowPage" value="1">
<div class="content">

	<div class="c_left">
	  <div class="search">
	  	<a href="addProblem.jsp" id="item_a"></a>
	    <input type="text" id="title" name="title" value="搜索问题、品牌或会员 >>" style="height:21px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:450px;"/>  
	    <input type="button" class="bot_t" value="" style=" bottom:0px; float:right;cursor: pointer;" onclick="$('#item_a').click();"/>
	  </div>
      <div class="subMenu">
      	<ul>
            <li class="zui"><a href="#">最新问题</a></li>
            <li class="re"><a href="#">热门问题</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      <div id="divList">
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电</a></div>
         </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      <div class="title">
      	<div class="tit_tit">
        	<div class="tit_tit_1"><a href="#">0</a></div>
        	<div class="tit_tit_2" ><span><a href="#"><img src="../images/main/rw_1.png" /></a></span><a href="#">“心静自然凉”到底有没有科学依据</a></div>        
        </div>
        <div class="tit_content">关于 DEC，有两本比较有权威的书。一是艾德加·施恩写的《DEC 已死，DEC 长存》[1]，另一本是电
脑世界两位编辑的作品：《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主
《伟大的企业家》[2]。施恩是斯隆管理学院的教授，他认为 DEC 的衰败主…</div>
         <div class="tit_bot">
       	   <div class="tit_bot_zl">张亮&nbsp;赞同该回答</div>
            <div class="tit_bot_gz"><a href="#">1 个答案</a> • <a href="#">5个关注</a> • <a href="#">收藏</a> • <a href="#">添加评论</a> • <a href="#">分享</a></div>
         </div>
      </div>
      </div>
      <div class="tiao"><a href="#">更多 &gt;&gt;</a></div>
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
        <div class="r_column">
          <div class="column">关注品牌</div>
            <div class="column_contentgxq">
              <div class="colun_c_pptu"><a href="#"><img src="../images/main/pptp_1.png" /></a>
                
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="#">香奈儿</a></div>
                    <div class="colun_c_xnrcon">流行稍纵即逝，风格永存</div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_pptu"><a href="#"><img src="../images/main/pptp_1.png" /></a>
                
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="#">香奈儿</a></div>
                    <div class="colun_c_xnrcon">流行稍纵即逝，风格永存</div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_pptu"><a href="#"><img src="../images/main/pptp_1.png" /></a>
                
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="#">香奈儿</a></div>
                    <div class="colun_c_xnrcon">流行稍纵即逝，风格永存</div>
              </div>
                <div style=" clear:both; font-size:0;"></div>
          </div>
          <div class="column_contentgxq" style="border:0; margin-bottom:0;">
              <div class="colun_c_pptu"><a href="#"><img src="../images/main/pptp_1.png" /></a>
                
              </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="#">香奈儿</a></div>
                    <div class="colun_c_xnrcon">流行稍纵即逝，风格永存</div>
              </div>
                <div style="clear:both; font-size:0;"></div>
          </div>
          <div class="more"><a href="#">更多 &gt;&gt;</a></div>
        </div>
        <div class="left_b_tp"><img src="../images/main/tupian.png" /></div>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
