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
<script type="text/javascript" language="javascript" src="userform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveUser.go" method="post" id="UserForm">
			<input type="hidden"  id="USER_ID" name="USER_ID" value='<s:property value="USER_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">用户信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='userlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
				  <tr>
				    	<td class="lightbox_title"><span class="font_red">*</span>用户类型(字典：1用户、2品牌):</td>
				      <td class="lightbox_content"><input type="text" class="input_width" id="USER_TYPE" name="USER_TYPE" value='<s:property value="USER_TYPE"/>'/></td>
				 
				    	<td class="lightbox_title"><span class="font_red">*</span>Email:</td>
				      <td class="lightbox_content"><input type="text" class="input_width" id="EMAIL" name="EMAIL" value='<s:property value="EMAIL"/>'/></td>
				   </tr>
				  <tr>
				    	<td class="lightbox_title"><span class="font_red">*</span>密码:</td>
				      <td class="lightbox_content"><input type="text" class="input_width" id="PASSWORD" name="PASSWORD" value='<s:property value="PASSWORD"/>'/></td>
				    	<td class="lightbox_title"><span class="font_red">*</span>注册时间:</td>
				      <td class="lightbox_content"><input type="text" class="input_width Wdate" id="REG_TIME" name="REG_TIME"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" value='<s:property value="REG_TIME"/>'/></td>
				  </tr>
				  <tr>
				    	<td class="lightbox_title"><span class="font_red">*</span>最后登录时间:</td>
				      <td class="lightbox_content"><input type="text" class="input_width Wdate" id="LAST_LOGINTIME" name="LAST_LOGINTIME"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})"  value='<s:property value="LAST_LOGINTIME"/>'/></td>
				    	<td class="lightbox_title"><span class="font_red">*</span>最后登录IP:</td>
				      <td class="lightbox_content"><input type="text" class="input_width" id="IP" name="IP" value='<s:property value="IP"/>'/></td>
				  </tr>
				  <tr>
				    	<td class="lightbox_title"><span class="font_red">*</span>最后登录MAC:</td>
				      <td class="lightbox_content"><input type="text" class="input_width" id="MAC" name="MAC" value='<s:property value="MAC"/>'/></td>
				    	<td class="lightbox_title"><span class="font_red">*</span>最后冻结时间:</td>
				      <td class="lightbox_content"><input type="text" class="input_width Wdate" id="LAST_FREEZETIME" name="LAST_FREEZETIME"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" value='<s:property value="LAST_FREEZETIME"/>'/></td>
				  </tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>