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
            	<li><a href="../index/list_sz.jsp">基本资料</a></li>
                <li><a href="javascript:;">账户设置</a></li>
                <li><a href="../usernotice/getUserNoticeList.go">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">
	    建议使用字母和数字组合，增强安全性
	  </div>
      <div class="line_1"></div>
      <div class="list_sz_zhsz">
      	<ul>
        	<li>当前密码： <input name="" type="text" /></li>
            <li>新的密码： <input name="" type="text" /></li>
            <li>确认密码： <input name="" type="text" /></li>
        </ul>
      </div>
      <div class="list_sz_zhsz_bcsz">
        <input name="input" type="button" class="list_sz_bcmm" value="保存密码"/>
      </div>
  </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
