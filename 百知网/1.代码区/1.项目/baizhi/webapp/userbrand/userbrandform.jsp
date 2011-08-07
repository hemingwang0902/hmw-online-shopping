<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link href="../styles/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.validate.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript" src="userbrandform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveUserBrand.go" method="post" id="UserBrandForm">
			<input type="hidden"  id="BRAND_ID" name="BRAND_ID" value='<s:property value="BRAND_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">用户品牌表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='userbrandlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="USER_ID" name="USER_ID" value='<s:property value="USER_ID"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>品牌名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="NAME" name="NAME" value='<s:property value="NAME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>品牌介绍：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="INTRODUCTION" name="INTRODUCTION" value='<s:property value="INTRODUCTION"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>发源地(品牌特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SOURCE" name="SOURCE" value='<s:property value="SOURCE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>所在地区(省：地区信息表ID)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="PROVINCE" name="PROVINCE" value='<s:property value="PROVINCE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>所在地区(市：地区信息表ID)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CITY" name="CITY" value='<s:property value="CITY"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>从事行业(字典)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="INDUSTRY" name="INDUSTRY" value='<s:property value="INDUSTRY"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>联系人姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="LINK_NAME" name="LINK_NAME" value='<s:property value="LINK_NAME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>联系方式：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="LINK_MODE" name="LINK_MODE" value='<s:property value="LINK_MODE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>电子邮箱：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="EMAIL" name="EMAIL" value='<s:property value="EMAIL"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>相片路径/LOGO路径：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IMAGE_PATH" name="IMAGE_PATH" value='<s:property value="IMAGE_PATH"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>状态(1：未申请、2：申请、3：通过、4：未通过)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="STAUS" name="STAUS" value='<s:property value="STAUS"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>审核人：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="AUDIT_ID" name="AUDIT_ID" value='<s:property value="AUDIT_ID"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>审核时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="AUDIT_TIME" name="AUDIT_TIME" value='<s:property value="AUDIT_TIME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>不通过原因：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REASON" name="REASON" value='<s:property value="REASON"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>备注：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REMARK" name="REMARK" value='<s:property value="REMARK"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>创建时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CREATE_TIME" name="CREATE_TIME" value='<s:property value="CREATE_TIME"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>修改时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="MODIFY_TIME" name="MODIFY_TIME" value='<s:property value="MODIFY_TIME"/>'/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>