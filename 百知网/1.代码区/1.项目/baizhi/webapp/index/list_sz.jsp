<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="../styles/message.css" />
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_sz.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
<div class="c_right_1">
  <div class="r_column">
          <div class="column_sz">设置选项</div>
          <div class="list_sz">
          	<ul>
            	<li><a href="javascript:;"  style="background-color:#CCDBA2;"><font color="#FF6633">基本资料</font></a></li>
            	<s:if test="#session.userinfo.USER_TYPE==2">
            	<li><a href="../index/list_sz_pplb.jsp" >品牌资料</a></li>
            	</s:if>
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
        <div class="title_xgwt_tu_sz"><img src="${basePath }/${returnMap.IMAGE_PATH}" height="102px" width="102px" onerror="load_person_image_102_102(this)" /></div>
        <form action="uploadHeadImage.go" method="post" id="UPLOAD_FORM" enctype="multipart/form-data" >
        <div class="list_sz_1">
        	<ul>
            	<li class="list_sz_li1"><input type="file"  id="upload" name="upload"  /></li>
                <li class="list_sz_li1">支持 jpg, gif, png 格式的图片，不要超过 2MB。建议图片尺寸大于 100×100</li>
                <li><input type="submit" class="list_kssc" value="开始上传" /></li>
            </ul>
        </div>
        </form>
        <div class="clear"></div>
      </div>
      
      <form  id="SETTING_FORM">
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
            	<li><input name="NAME" id="NAME" type="text" value="${returnMap.NAME }" />一个月只能修改一次 </li>
                <li><textarea cols="" rows="1" id="INTRODUCTION" name="INTRODUCTION" class="list_sz_js">${returnMap.INTRODUCTION }</textarea>
                </li>
                <li>http://www.100zhi.cn/people/&nbsp;<input name="WEBSITE" id="WEBSITE" type="text" value="${returnMap.WEBSITE }" /></li>
                <li>可输入 4~20 位的英文或数字 , 一个月只能修改一次${returnMap.WEBSITE_NAME} </li>
                <li><input name="" type="submit" class="list_sz_an" value="保存设置"/></li>
           	</ul>
           </div>
      </div>
       </form>
  </div>
 
  
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
