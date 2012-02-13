<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="../styles/message.css" />
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_sz_pplb.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
<div class="c_right_1">
  <div class="r_column">
          <div class="column_sz">设置选项</div>
          <div class="list_sz">
          	<ul>
            	<li><a href="../sz/initSzForm.go" style="font-weight:bold;">基本资料</a></li>
            	<li><a href="javascript:;" ><font color="#276399" style="font-weight:bold;">品牌资料</font></a></li>
                <li><a href="../index/list_sz_zhsz.jsp" style="font-weight:bold;">账户设置</a></li>
                <li><a href="../usernotice/getUserNoticeList.go" style="font-weight:bold;">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">品牌列表信息
	  	<span style="float: right;margin-right: 12px;">
	  		<input type="button" value="新增品牌" style="width:100px; height:25px; background-color:#dadade;" onclick="location.href='../index/list_sz_pp.jsp'" />
	  	</span>
	  </div>
      <div class="line_1"></div>
      
      
      <div id="userbrandlist">
        <div class="title_xgwt_x">
        <div class="title_xgwt_tu"><img src="../images/main/xner.jpg" /></div>
        <div class="title_xgwt_xner">
        	<ul>
            	<li class="tit"><a href="#">LG</a></li>
                <li class="tit_con">电信行业的我，如何进入互联网行业公司工作</li>
            </ul>
        </div>
        <div class="title_xgwt_anniu">
          <p><input name="" type="button" value="编辑" style="width:100px; height:25px; background-color:#dadade" /></p>
          <p><input name="" type="button" value="删除" style="width:100px; height:25px; background-color:#dadade" /></p>
        </div>
        <div class="clear"></div>
      </div>
      
      </div>
     
      
  </div>
	<div class="clear"></div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
