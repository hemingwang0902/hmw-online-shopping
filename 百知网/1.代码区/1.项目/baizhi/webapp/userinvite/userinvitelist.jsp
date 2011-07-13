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
<script type="text/javascript" language="javascript"  src="userinvitelist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserInviteList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">是否邀请成功：</td>
						<td class="lightbox_content" >
							<select name="IS_SUCCESS" id="IS_SUCCESS" class="select_box3">
								<option value=""></option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">邀请Email：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="EMAIL" id="EMAIL" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">邀请时间(起)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="INVITE_TIME" id="INVITE_TIME" /> </td>
					</tr>
					<tr>
						<td class="lightbox_title">邀请时间(止)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="INVITE_TIME_END" id="INVITE_TIME_END" /> </td>
					</tr>
					<tr>
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
				<span class="font_span">用户邀请信息列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="邀请" class="button_box" onclick="location.href='initUserInviteForm.go';"/>
				<!-- <input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/> -->
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<!--<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>-->
		   				<td width="10%">姓名</td>
		   				<td width="10%">是否邀请成功</td>
		   				<td width="10%">邀请Email</td>
		   				<td width="10%">邀请时间</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>