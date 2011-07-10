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
            	<li><a href="#" >基本资料</a></li>
				<li><a href="#" style="background-color:#CCDBA2;"><font color="#FF6633">品牌资料</font></a></li>
                <li><a href="#">账户设置</a></li>
                <li><a href="#">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">请使用真实企业品牌名称，填写“品牌介绍”好让大家了解该品牌
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
            	<li>名称：</li>
                <li>品牌介绍：</li>
                <li>发源地：</li>
				<li>所在地区：</li>
				<li>从事行业：</li>
				<li>联系人姓名：</li>
				<li>联系手机：</li>
				<li>电子邮箱：</li>
				<li>品牌标签：</li>
				<li>认证状态：</li>
            </ul>
        </div>
           <div class="title_xgwt_x_sz_3">
           	<ul>
            	<li><input name="" type="text" />一个月只能修改一次 </li>
                <li>
                  <textarea name="textarea" cols="" rows="1" class="list_sz_js"></textarea>
                </li>
               
             	<li><input name="Input" type="text" /> </li>
                <li>省：<input name="" type="text" />市：<input name="" type="text" /></li>
				<li><input name="" type="text" /></li>
				<li><input name="" type="text" /></li>
				<li><input name="" type="text" /></li>
				<li><input name="" type="text" /></li>
				<li><input name="" type="text" />（以逗号分开，做多可输入5个标签）</li>
				<li><input name="" type="text" /></li>
                <li><input name="" type="button" class="list_sz_an" value="新增品牌"/> <input name="" type="button" class="list_sz_an" value="修改品牌"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="" type="button" class="list_sz_an" value="申请认证"/></li>
           	</ul>
        </div>
      </div>
  </div>
	<div class="clear"></div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
