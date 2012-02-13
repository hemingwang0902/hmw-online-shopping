<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>需知网</title>
<link href="../styles/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.validate.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript" src="dicitemform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="../dicitem/saveDicitem.go" method="post" id="DicitemForm">
			<input type="hidden"  id="DICITEM_ID" name="DICITEM_ID" value='<s:property value="DICITEM_ID"/>' />
			<input type="hidden"  id="CODE" name="CODE" value='<s:property value="#parameters.CODE"/>' />
			<input type="hidden"  id="M_CODE" name="M_CODE" value='<s:property value="CODE"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">字典列表清单表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>字典代码：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="DIC_CODE" name="DIC_CODE" value='<s:property value="DIC_CODE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>字典名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="DIC_NAME" name="DIC_NAME" value='<s:property value="DIC_NAME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>字典全拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ALLPIN" name="ALLPIN" value='<s:property value="ALLPIN"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>字典简拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SIMPLEPIN" name="SIMPLEPIN" value='<s:property value="SIMPLEPIN"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>显示顺序：</td>
						<td class="lightbox_content" colspan="3"><input type="text" class="input_width" id="ORDER_BY" name="ORDER_BY" value='<s:property value="ORDER_BY"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title">&nbsp;备注：</td>
						<td colspan="3" class="lightbox_content"><textarea  class="textarea_box"  id="REMARK" name="REMARK" ><s:property value="REMARK"/></textarea></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>