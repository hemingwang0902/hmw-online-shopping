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
<script type="text/javascript" language="javascript" src="scoreform.js"></script>
</head>
<body background='../images/main/mixbj.jpg;'>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveScore.go" method="post" id="ScoreForm">
			<input type="hidden"  id="SCORE_ID" name="SCORE_ID" value='<s:property value="SCORE_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">积分表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='scorelist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>积分名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width readonly" id="NAME" name="NAME" value='<s:property value="NAME"/>' readonly="readonly"/></td>
						<td class="lightbox_title"><span class="font_red">*</span>积分类型</td>
						<td class="lightbox_content">
							<input type="hidden" id="SOCRE_TYPE" name="SOCRE_TYPE" value='<s:property value="SOCRE_TYPE"/>'/>
							<input type="text" class="input_width readonly" value='<s:property value="SOCRE_TYPE_NAME"/>' readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>积分：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SOCRE" name="SOCRE" value='<s:property value="SOCRE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>是否禁用：</td>
						<td class="lightbox_content">
							<input type="hidden" class="input_width"  id="IS_VALID_HIDDEN" name="IS_VALID_HIDDEN"  value='<s:property value="IS_VALID"/>'/>
					      	<select id="IS_VALID" name="IS_VALID" class="select_box"  >
					      		<option value="0">否</option>
					      		<option value="1">是</option>
					      	</select>
						</td>
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