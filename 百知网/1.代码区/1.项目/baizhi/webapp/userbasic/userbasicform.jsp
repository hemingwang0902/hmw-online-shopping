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
<script type="text/javascript" language="javascript" src="userbasicform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveUserBasic.go" method="post" id="UserBasicForm">
			<input type="hidden"  id="BASIC_ID" name="BASIC_ID" value='<s:property value="BASIC_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">用户基本信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='userbasiclist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="USER_ID" name="USER_ID" value='<s:property value="USER_ID"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>用户类型(字典：1用户、2品牌)冗余字段：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="USER_TYPE" name="USER_TYPE" value='<s:property value="USER_TYPE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>姓名/品牌名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="NAME" name="NAME" value='<s:property value="NAME"/>'/></td>
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
						<td class="lightbox_title"><span class="font_red">*</span>所在年代(字典、用户特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="YEARS" name="YEARS" value='<s:property value="YEARS"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>联系方式：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="LINK_MODE" name="LINK_MODE" value='<s:property value="LINK_MODE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>是否对外开放(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IS_OPEN" name="IS_OPEN" value='<s:property value="IS_OPEN"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>个人介绍/品牌介绍：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="INTRODUCTION" name="INTRODUCTION" value='<s:property value="INTRODUCTION"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>人生格言(用户特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="MOTTO" name="MOTTO" value='<s:property value="MOTTO"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>相片路径/LOGO路径：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IMAGE_PATH" name="IMAGE_PATH" value='<s:property value="IMAGE_PATH"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>个性网址：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="WEBSITE" name="WEBSITE" value='<s:property value="WEBSITE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>私信设置(字典：1所有人、2我关注的人)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="PRIVATE_SET" name="PRIVATE_SET" value='<s:property value="PRIVATE_SET"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>级别：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="LEVEL" name="LEVEL" value='<s:property value="LEVEL"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>积分：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="SCORE" name="SCORE" value='<s:property value="SCORE"/>'/></td>
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