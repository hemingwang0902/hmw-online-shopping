<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@include file="../common/basePath.jsp" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="../areadata.js"></script>
	<script type="text/javascript" language="javascript"  src="../javascripts/jquery.select.js"></script>
	<script type="text/javascript" language="javascript" src="../index/list_sz_pp.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
<div class="c_right_1">
  <div class="r_column">
          <div class="column_sz">设置选项</div>
          <div class="list_sz">
          	<ul>
            	<li><a href="../sz/initSzForm.go" >基本资料</a></li>
				<li><a href="../index/list_sz_pplb.jsp" style="background-color:#CCDBA2;"><font color="#FF6633">品牌资料</font></a></li>
                <li><a href="../index/list_sz_zhsz.jsp">账户设置</a></li>
                <li><a href="../usernotice/getUserNoticeList.go">通知设置</a></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	 <form action="../userbrand/saveUserBrand.go" method="post" id="UserBrand_FORM" enctype="multipart/form-data" >
	 	<input type="hidden" id="BRAND_ID" name="BRAND_ID" value="${BRAND_ID }"/>
	  <div class="list_xgwt_xght_sz">请使用真实企业品牌名称，填写“品牌介绍”好让大家了解该品牌</div>
      <div class="line_1"></div>
      <div class="title_xgwt_x_sz" style="margin-bottom:15px;">
        <div class="title_xgwt_tu_sz"><img src="${IMAGE_PATH}" onerror='load_brand_image_74_74(this)' height="74px" width="74px"/></div>
        <div class="list_sz_1">
        	<ul>
            	<li class="list_sz_li1"><input type="file"  id="upload" name="upload"  /></li>
                <li class="list_sz_li1">支持 jpg, gif, png 格式的图片，不要超过 2MB。建议图片尺寸大于 100×100</li>
            </ul>
        </div>
        <div class="clear"></div>
      </div>
      <div class="title_xgwt_x_sz">
      	   <div class="title_xgwt_x_sz_2">
           	<ul>
            	<li>名称：</li>
                <li style="height:500px;">品牌介绍：</li>
                <li style="margin-top: 12px;">发源地：</li>
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
            	<li style="margin-top: 12px;">
            		<input name="NAME" id="NAME" type="text" value="${NAME }" />
            	</li>
                <li style="margin-top: 10px;">
                  <textarea name="INTRODUCTION" cols="" rows="1" class="list_sz_js" style="width:420px;" id="INTRODUCTION" >${INTRODUCTION }</textarea>
					<% 
					CKEditorConfig settings = new CKEditorConfig();
					settings.addConfigValue("width", "500");
					settings.addConfigValue("toolbar", "Brand");
					%>
                  <ckeditor:replace basePath="${jsBasePath}/ckeditor/" config="<%=settings %>" replace="INTRODUCTION" />
                </li>
               
             	<li style="margin-top: 18px;"><input name="SOURCE" type="text" id="SOURCE" value="${SOURCE }"/> </li>
                <li style="margin-top: 10px;">
                <select id="PROVINCE" name="PROVINCE"  onchange="setSelectValue(this.selectedIndex,true,document.getElementById('CITY'));"></select>省
                <select id="CITY" name="CITY"></select>市
                </li>
				<li style="margin-top: 10px;"><input name="INDUSTRY" id="INDUSTRY" value="${INDUSTRY }" type="text" /></li>
				<li style="margin-top: 18px;"><input name="LINK_NAME" id="LINK_NAME" value="${LINK_NAME }" type="text" /></li>
				<li style="margin-top: 23px;"><input name="LINK_MODE" id="LINK_MODE" value="${LINK_MODE }" type="text" /></li>
				<li style="margin-top: 20px;"><input name="EMAIL" id="EMAIL" value="${EMAIL }" type="text" /></li>
				<li style="margin-top: 10px;"><input name="BRAND_LABEL" id="BRAND_LABEL" value="${BRAND_LABEL }" type="text" />（以逗号分开，做多可输入5个标签）</li>
				<li >${STAUS_NAME}&nbsp;<span style="color:red;">${REASON}</span></li>
				<li>
				    
				    <s:if test="STAUS==null||STAUS==''||STAUS==1||STAUS==4">
				    	<input type="button" class="list_sz_an" onclick="btn_submit(1);" value="保存" /> &nbsp;&nbsp;&nbsp;&nbsp;
				    	<input type="button" class="list_sz_an" onclick="btn_submit(2);" value="申请认证"/>
				    	<input type="hidden" id="STAUS" name="STAUS" value="1" />
					</s:if>
				    	
				</li>
				
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
