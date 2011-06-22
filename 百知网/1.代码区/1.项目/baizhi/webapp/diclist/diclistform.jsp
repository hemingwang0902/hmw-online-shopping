<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link href="../styles/style.css" rel="stylesheet" type="text/css"/>
<link href="../styles/lightbox.css" rel="stylesheet" type="text/css"  media="screen"/>
<script type="text/javascript" language="javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.pagination.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.checkbox.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.validate.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightbox.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightboxmousewheel.js"></script>
<script type="text/javascript" language="javascript" src="diclistform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<a href="../dicitem/initDicitemForm.go?CODE=<s:property value="CODE"/>" id="item_a"></a>
		<a href="" id="item_a_modify"></a>
		<form action="saveDiclist.go" method="post" id="DiclistForm">
			<input type="hidden"  id="DICLIST_ID" name="DICLIST_ID" value='<s:property value="DICLIST_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">字典列表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='diclistlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>字典名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="NAME" name="NAME" value='<s:property value="NAME"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>字典代码：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CODE" name="CODE" value='<s:property value="CODE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>字典全拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ALLPIN" name="ALLPIN" value='<s:property value="ALLPIN"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>字典简拼：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SIMPLEPIN" name="SIMPLEPIN" value='<s:property value="SIMPLEPIN"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title">&nbsp;备注：</td>
						<td colspan="3" class="lightbox_content"><textarea  class="textarea_box"  id="REMARK" name="REMARK" ><s:property value="REMARK"/></textarea></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<!--字典列表-->
	<s:if test="DICLIST_ID!=null">
		<div class="content">
			<!--表头-->
			<div class="lightbox_header"><span class="font_span">字典列表清单列表</span></div>
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
		   				<td width="10%">字典代码</td>
		   				<td width="10%">字典名称</td>
		   				<td width="10%">字典全拼</td>
		   				<td width="10%">字典简拼</td>
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