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
<script type="text/javascript" language="javascript"  src="userattentiontalklist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserAttentiontalkList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">用户关注话题ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="ATTENTIONTALK_ID" id="ATTENTIONTALK_ID" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="USER_ID" id="USER_ID" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">问题话题ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="TALK_ID" id="TALK_ID" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">是否关注(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="IS_ATTENTION" id="IS_ATTENTION" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">创建时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="CREATE_TIME" id="CREATE_TIME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">修改时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="MODIFY_TIME" id="MODIFY_TIME" /> </td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td style="padding-top:5px; padding-bottom:5px;">
							<input type="button"  value="查询"  class="button_box" onclick="$('#nowPage').val('1');getDataList();"/>
							<input  type="reset"  value="重置"  class="button_box" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="table_box">
			<div class="lightbox_header">
				<span class="font_span">用户关注话题信息表列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="新增" class="button_box" onclick="location.href='initUserAttentiontalkForm.go';"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>
		   				<td width="10%">用户关注话题ID</td>
		   				<td width="10%">用户ID</td>
		   				<td width="10%">问题话题ID</td>
		   				<td width="10%">是否关注(0否、1是)</td>
		   				<td width="10%">创建时间</td>
		   				<td width="10%">修改时间</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>