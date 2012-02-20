<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- /webapp/index/list_sz.jsp -->
<html>
<head>
	<link type="text/css" rel="stylesheet" href="../styles/message.css" />
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="../areadata.js"></script>
	<script type="text/javascript" language="javascript"  src="../javascripts/jquery.select.js"></script>
	<script type="text/javascript" language="javascript" src="../index/list_sz.js"></script>
	
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<input type="hidden" id="user_id" value='<s:property value="#session.userinfo.USER_ID"/>' />;
	<%@include file="/common/settingLeftNav.jsp" %>  
	<div class="c_left">
	  <div class="list_xgwt_xght_sz">请使用真实姓名，填写“个人介绍”好让大家了解你</div>
      <div class="title_xgwt_x_sz" style="margin-bottom:15px;">
        <div class="title_xgwt_tu_sz"><img src="${basePath }/${returnMap.IMAGE_PATH}" height="102px" width="102px" onerror="load_person_image_102_102(this)" /></div>
        <form action="uploadHeadImage.go" method="post" id="UPLOAD_FORM" enctype="multipart/form-data" >
        <div class="list_sz_1">
        	<ul>
            	<li class="list_sz_li1">
            	<input type="file"  id="upload" name="upload"  />
            	<input type="submit" class="list_kssc" value="开始上传" /></li>
                <li class="list_sz_li1">支持 jpg, gif, png 格式的图片，不要超过 2MB。建议图片尺寸大于 100×100</li>
                <li>
                	<textarea id="txt_mood" style="width: 100%;height: 40px;line-height: 20px;"></textarea><br>
                	<input type="button" id="btn_publish_mood" class="list_kssc" value="发表心情" style="margin-left: 345px;" />
				</li>
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
            	<li>地区：</li>
                <li>个人介绍：</li>
                <li>个性网址：</li>
            </ul>
        </div>
           <div class="title_xgwt_x_sz_3">
           	<ul>
            	<li><input name="NAME" id="NAME" type="text" value="${returnMap.NAME }" />一个月只能修改一次 </li>
            	<li>
            	<input type="hidden" id="PROVINCE_HIDDEN" name="PROVINCE_HIDDEN" value="${returnMap.PROVINCE }" />
                <input type="hidden" id="CITY_HIDDEN" name="CITY_HIDDEN" value="${returnMap.CITY}" />
    			<select id="PROVINCE" name="PROVINCE"  onchange="setSelectValue(this.selectedIndex,true,document.getElementById('CITY'));"></select>省
    			<select id="CITY" name="CITY"></select>市
            	</li>
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
