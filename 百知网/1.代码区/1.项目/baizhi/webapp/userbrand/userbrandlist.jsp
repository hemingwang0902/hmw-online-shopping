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
<script type="text/javascript" language="javascript"  src="../areadata.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.select.js"></script>
<script type="text/javascript" language="javascript"  src="userbrandlist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserBrandList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">会员姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="USERNAME" id="USERNAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">品牌名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">发源地：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="SOURCE" id="SOURCE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(省)：</td>
						<td class="lightbox_content">
							<select  name="PROVINCE" id="PROVINCE"  class="select_box3"  onchange="setSelectValue(this.selectedIndex,false,document.getElementById('CITY'));"></select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(市)：</td>
						<td class="lightbox_content">
							<select  name="CITY" id="CITY"  class="select_box3"  ></select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">从事行业：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="INDUSTRY" id="INDUSTRY" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">联系人姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="LINK_NAME" id="LINK_NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">联系方式：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="LINK_MODE" id="LINK_MODE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">电子邮箱：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="EMAIL" id="EMAIL" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">状态：</td>
						<td class="lightbox_content">
							<select   name="STAUS" id="STAUS"  class="select_box3" >
								<option value=""></option>
								<option value="1">未提交申请</option>
								<option value="2">申请</option>
								<option value="3">审核通过</option>
								<option value="4">审核未通过</option>
							</select>
						</td>
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
				<span class="font_span">用户品牌信息表列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="通过" class="button_box" onclick="agreeData($.fn.getCheckValue())"/>
				<input type="button"  value="不通过" class="button_box" onclick="disagreeData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%"><div style="width: 60px;">操作</div></td>
		   				<td width="10%">会员姓名</td>
		   				<td width="10%">品牌名称</td>
		   				<td width="10%">品牌介绍</td>
		   				<td width="10%">发源地</td>
		   				<td width="10%">所在地区(省)</td>
		   				<td width="10%">所在地区(市)</td>
		   				<td width="10%">从事行业</td>
		   				<td width="10%">联系人姓名</td>
		   				<td width="10%">联系方式</td>
		   				<td width="10%">电子邮箱</td>
		   				<td width="10%">状态</td>
		   				<td width="10%">审核人</td>
		   				<td width="10%">审核时间</td>
		   				<td width="10%">不通过原因</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>