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
            	<li><a href="javascript:;">基本资料</a></li>
                <li><a href="../index/list_sz_zhsz.jsp">账户设置</a></li>
                <li><a href="../usernotice/getUserNoticeList.go">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">请使用真实姓名，填写“个人介绍”好让大家了解你
</div>
      <div class="line_1"></div>
      <div class="title_xgwt_x_sz" style="margin-bottom:15px;">
        <div class="title_xgwt_tu_sz"><img src="../images/main/list_sz.png" /></div>
        <div class="list_sz_1">
        	<ul>
            	<li class="list_sz_li1"><input name="" type="text" />&nbsp;<input name="" type="button" value="浏览…" /></li>
                <li class="list_sz_li1">支持 jpg, gif, png 格式的图片，不要超过 2MB。建议图片尺寸大于 100×100</li>
                <li><input name="" type="button" class="list_kssc" value="开始上传" /></li>
            </ul>
        </div>
        <div class="clear"></div>
      </div>
      <div class="title_xgwt_x_sz">
      	   <div class="title_xgwt_x_sz_2">
           	<ul>
            	<li>姓名：</li>
                <li>个人介绍：</li>
                <li>个性网址：</li>
            </ul>
        </div>
           <div class="title_xgwt_x_sz_3">
           	<ul>
            	<li><input name="" type="text" />一个月只能修改一次 </li>
                <li><textarea cols="" rows="1" class="list_sz_js"></textarea>
                </li>
                <li>http://www.zhihu.com/people/&nbsp;<input name="" type="text" /></li>
                <li>可输入 4~20 位的英文或数字 , 30 天内只能修改一次（3周前修改过）</li>
                <li><input name="" type="button" class="list_sz_an" value="保存设置"/></li>
           	</ul>
           </div>
      </div>
  </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
