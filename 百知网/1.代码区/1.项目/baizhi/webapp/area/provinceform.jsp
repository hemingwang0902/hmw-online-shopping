<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>需知网</title>
	<link href="../styles/style.css" rel="stylesheet" type="text/css"/>
	<link href="../styles/lightbox.css" rel="stylesheet" type="text/css"  media="screen"/>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.pagination.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.checkbox.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.validate.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.message.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightbox.js"></script>
	<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightboxmousewheel.js"></script>
	<script type="text/javascript" language="javascript" src="provinceform.js"></script>
</head>
<body background='../images/main/mixbj.jpg;'>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<a href="initAreaForm.go?AREA_LEVEL=2&PAREA_ID=<s:property value="AREA_ID"/>" id="item_a"></a>
		<a href="" id="item_a_modify"></a>
		<form action="saveArea.go" method="post" id="AreaForm">
			<input type="hidden"  id="AREA_ID" name="AREA_ID" value='<s:property value="AREA_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">地区信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='provincelist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<%-- 地区上级代码 --%>
				<input type="hidden" id="PAREA_ID" name="PAREA_ID" value='0'/>
				<%-- IP起始段 --%>
				<input type="hidden" id="IP_START" name="IP_START" value='<s:property value="IP_START"/>'/>
				<%-- IP终止段 --%>
				<input type="hidden" id="IP_END" name="IP_END" value='<s:property value="IP_END"/>'/>
				<%-- 省份级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级 --%>
				<input type="hidden" id="AREA_LEVEL" name="AREA_LEVEL" value='1'/>
				
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>省份名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="DIC_NAME" name="DIC_NAME" value='<s:property value="DIC_NAME"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>省份代码：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="DIC_CODE" name="DIC_CODE" value='<s:property value="DIC_CODE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title">省份全拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ALLPIN" name="ALLPIN" value='<s:property value="ALLPIN"/>'/></td>
						<td class="lightbox_title">省份简拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SIMPLEPIN" name="SIMPLEPIN" value='<s:property value="SIMPLEPIN"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title">显示顺序：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ORDER_BY" name="ORDER_BY" value='<s:property value="ORDER_BY"/>'/></td>
						<td class="lightbox_title">备注：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REMARK" name="REMARK" value='<s:property value="REMARK"/>'/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<!--字典列表-->
	<s:if test="AREA_ID != null">
		<div class="content">
			<!--表头-->
			<div class="lightbox_header"><span class="font_span"><s:property value="DIC_NAME"/>下的城市列表</span></div>
			<!--操作按钮-->
			<div class="btn_box">
				<input type="button"  value="新增" class="button_box" onclick="$('#item_a').click();"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
			</div>
			<!--显示分页 -->
			<div id="Pagination" class="pagination"></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>
		   				<td width="10%">城市名称</td>
		   				<td width="10%">城市代码</td>
		   				<td width="10%">城市全拼</td>
		   				<td width="10%">城市简拼</td>
		   				<td width="10%">显示顺序</td>
		   				<td width="10%">备注</td>
					</tr>
				</table> 
			</div>   
		</div>
	</s:if>
</div>
</body>
</html>