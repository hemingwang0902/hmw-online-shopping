<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="com.ckeditor.EventHandler"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
						<td class="lightbox_title"><span class="font_red">*</span>显示方式：</td>
						<td class="lightbox_content">
						<%--<input type="text" class="input_width" id="SHOW_TYPE" name="SHOW_TYPE" value='<s:property value="SHOW_TYPE"/>'/>--%>
							<select id="SHOW_TYPE" name="SHOW_TYPE" class="input_width" initValue='<s:property value="SHOW_TYPE"/>'>
								<option value="1">左边悬浮</option>
								<option value="2">中间悬浮</option>
								<option value="3">右边悬浮</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>起始时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="START_TIME" id="START_TIME" value='<s:property value="START_TIME"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>终止时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" id="END_TIME" name="END_TIME" value='<s:property value="END_TIME"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>状态：</td>
						<td class="lightbox_content">
							<%--<input type="text" class="input_width" id="STATUS" name="STATUS" value='<s:property value="STATUS"/>'/>--%>
							<select id="STATUS" name="STATUS" class="input_width" initValue='<s:property value="STATUS"/>'>
								<option value="1">申请</option>
								<option value="2" selected="selected">通过</option>
								<option value="3">不通过</option>
							</select>
						</td>
						<td class="lightbox_title">显示顺序：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ORDER_BY" name="ORDER_BY" value='<s:property value="ORDER_BY"/>'/></td>
					</tr>

					<tr>
						<td class="lightbox_title" colspan="4">
							<span class="font_red"></span>备注：
							<div class="lightbox_content" style="width: 100%;"><textarea class="input_width" id="REMARK" name="REMARK" style="width:100%;height:60px;border:#CCC solid 1px;line-height:18px;"><s:property value="REMARK"/></textarea></div>
						</td>
					</tr>
					<tr>
						<td class="lightbox_title" colspan="4">
							<span class="font_red"></span>广告内容：<br>
						<%
						// CKeditor 配置对象
						CKEditorConfig settings = new CKEditorConfig();
						// 设置皮肤
						settings.addConfigValue("skin", "office2003"); 
						// 移除皮肤配置（恢复默认配置）
						//settings.removeConfigValue("skin");
						// 设置UI主题颜色
						settings.addConfigValue("uiColor", "#ADE82E");
						// 设置工具栏按钮
						//settings.addConfigValue("toolbar", "[['Format'],['Bold','Italic','Underline','Strike','-','Subscript','Superscript']]");
						// 事件句柄
						EventHandler eventHandler = new EventHandler(); 
						// 添加完成CKeditor实例初始化的事件监听
						//eventHandler.addEventHandler("instanceReady", "function (ev) { alert(\"Loaded: \" + ev.editor.name); }");
						String value = (String)request.getAttribute("CONTENT");
						%>
						
						<ckeditor:editor basePath="../javascripts/ckeditor/" value='<%=(value == null) ? "" : value %>' config="<%=settings %>" editor="CONTENT" events="<%=eventHandler %>"/>
						
						<%--
						<textarea cols="80" id="editor2" name="editor2" rows="10">&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>
						<ckeditor:replace basePath="../javascripts/ckeditor/" config="<%=settings %>" replace="editor2" />
						--%>
			
						</td>
					</tr>
						
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>