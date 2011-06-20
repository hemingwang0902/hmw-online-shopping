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
<script type="text/javascript" language="javascript" src="adform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveAd.go" method="post" id="AdForm">
			<input type="hidden"  id="AD_ID" name="AD_ID" value='<s:property value="AD_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">广告信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='adlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>主题：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="TITLE" name="TITLE" value='<s:property value="TITLE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>内容(支持html内容)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CONTENT" name="CONTENT" value='<s:property value="CONTENT"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>图片：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IMAGE" name="IMAGE" value='<s:property value="IMAGE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SHOW_TYPE" name="SHOW_TYPE" value='<s:property value="SHOW_TYPE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>链接地址：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="HREF" name="HREF" value='<s:property value="HREF"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>显示顺序：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ORDER_BY" name="ORDER_BY" value='<s:property value="ORDER_BY"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>起始时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="START_TIME" name="START_TIME" value='<s:property value="START_TIME"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>终止时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="END_TIME" name="END_TIME" value='<s:property value="END_TIME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>状态(字典：1申请、2通过、3不通过)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="STATUS" name="STATUS" value='<s:property value="STATUS"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>备注：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REMARK" name="REMARK" value='<s:property value="REMARK"/>'/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>