<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css" />
<script type="text/javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.pagination.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.checkbox.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript"  src="userlist.js"></script>
</head>
<body background='../images/main/mixbj.jpg;'>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td nowrap="nowrap" class="lightbox_title">会员类型：</td>
						<td class="lightbox_content">
							<select id="USER_TYPE" name="USER_TYPE" class="select_box3"  >
								<option value=""></option>
					      		<option value="1">会员</option>
					      		<option value="2">品牌</option>
					      		<option value="3">系统</option>
				      		</select>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">Email：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="EMAIL" id="EMAIL" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">注册时间(起)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="REG_TIME" id="REG_TIME" onclick="WdatePicker()" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">注册时间(止)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="REG_TIME_END" id="REG_TIME_END" onclick="WdatePicker()" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">登录时间(起)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="LAST_LOGINTIME" id="LAST_LOGINTIME" onclick="WdatePicker()" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">登录时间(止)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="LAST_LOGINTIME_END" id="LAST_LOGINTIME_END" onclick="WdatePicker()" /> </td>
					</tr><!--
					<tr>
						<td nowrap="nowrap" class="lightbox_title">冻结时间(起)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="LAST_FREEZETIME" id="LAST_FREEZETIME" onclick="WdatePicker()" /> </td>
					</tr>
					<tr>
						<td nowrap="nowrap" class="lightbox_title">冻结时间(止)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate" name="LAST_FREEZETIME_END" id="LAST_FREEZETIME_END" onclick="WdatePicker()" /> </td>
					</tr>
					--><tr>
						<td>&nbsp;</td>
						<td style="padding-top:5px; padding-bottom:5px;">
							<input type="button"  value="查询"  class="button_box" onclick="getDataList()"/>
							<input  type="reset"  value="重置"  class="button_box" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="table_box">
			<div class="lightbox_header">
				<span class="font_span">会员信息列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="新增" class="button_box" onclick="location.href='initUserForm.go';"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>
						<td width="10%">会员类型</td>
						<td width="10%">姓名</td>
						<td width="10%">Email</td>
						<td width="10%">注册时间</td>
						<td width="10%">最后登录时间</td>
						<!--<td width="10%">冻结时间</td>
					--></tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>