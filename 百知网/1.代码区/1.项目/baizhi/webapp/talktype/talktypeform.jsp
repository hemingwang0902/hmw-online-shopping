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
<script type="text/javascript" language="javascript" src="talktypeform.js"></script>
</head>
<body background='../images/main/mixbj.jpg;'>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveTalktype.go" method="post" id="TalktypeForm">
			<input type="hidden"  id="TALKTYPE_ID" name="TALKTYPE_ID" value='<s:property value="TALKTYPE_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">话题类型表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='talktypelist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>类型名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="TYPE_NAME" name="TYPE_NAME" value='<s:property value="TYPE_NAME"/>'/></td>
						<td class="lightbox_title">&nbsp;</td>
						<td class="lightbox_content">&nbsp;</td>
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