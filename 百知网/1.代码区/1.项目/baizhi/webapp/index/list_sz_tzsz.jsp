<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
<div class="c_right_1">
  <div class="r_column">
          <div class="column_sz">设置选项</div>
          <div class="list_sz">
          	<ul>
            	<li><a href="#">基本资料</a></li>
                <li><a href="#">账户设置</a></li>
                <li><a href="#">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">
	    建议使用字母和数字组合，增强安全性
	  </div>
      <div class="line_1"></div>
      <div class="list_sz_tzsz">
      	<input type="checkbox" checked="checked" />&nbsp;有人关注了我<br />
        <input type="checkbox" checked="checked" />&nbsp;有人关注了我<br />
        <input type="checkbox" checked="checked" />&nbsp;有人关注了我<br />
        <input type="checkbox" checked="checked" />&nbsp;有人关注了我<br />
        <input type="checkbox" checked="checked" />&nbsp;有人关注了我<br />
      </div>
      <div class="list_xgwt_xght_sz">
	    设置谁可以给我发私信
	  </div>
      <div class="line_1"></div>
      <div class="list_se_bcsz_1">
   	  <input name="" type="radio" value="" checked="checked" />
   	  所有人&nbsp; <input name="" type="radio" value="" />我关注的人     </div>
      <div class="list_sz_zhsz_bcsz">
        <input name="input" type="button" class="list_sz_bcmm" value="保存密码"/>
      </div>
  </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
