<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<script type="text/javascript" language="javascript"  src="userbasiclist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<input type="hidden" id="id" value="<s:property value="#parameters.id"/>" />
<input type="hidden" id="name" value="<s:property value="#parameters.name"/>" />
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserBasicList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">用户类型：</td>
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
						<td class="lightbox_title">姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(省)：</td>
						<td class="lightbox_content">
							<select  name="PROVINCE" id="PROVINCE"  class="select_box3" >
								<option value=""></option>
								<option value="1">北京</option>
							</select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(市)：</td>
						<td class="lightbox_content">
							<select  name="CITY" id="CITY"  class="select_box3"  >
								<option value=""></option>
								<option value="1">北京</option>
							</select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">从事行业：</td>
						<td class="lightbox_content">
							<!--<select id="INDUSTRY" name="INDUSTRY" class="select_box3"  >
								<option value=""></option>
					      		<option value="001">计算机</option>
					      		<option value="002">医药</option>
				      		</select>
				      	-->
				      	<input type="text" class="input_width3" name="INDUSTRY" id="INDUSTRY" />
				      	</td>
					</tr>
		   			<!--<tr>
						<td class="lightbox_title">所在年代：</td>
						<td class="lightbox_content">
							<select id="YEARS" name="YEARS" class="select_box3"  >
								<option value=""></option>
					      		<option value="01">60以前</option>
					      		<option value="02">60-69</option>
				      		</select>
						</td>
					</tr>
		   			--><tr>
						<td class="lightbox_title">联系方式：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="LINK_MODE" id="LINK_MODE" /> </td>
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
				<span class="font_span">会员信息列表</span>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="10%">操作</td>
		   				<td width="10%">用户类型</td>
		   				<td width="10%">姓名</td>
		   				<td width="10%">所在地区(省)</td>
		   				<td width="10%">所在地区(市)</td>
		   				<td width="10%">从事行业</td>
		   				<!--<td width="10%">所在年代</td>
		   				--><td width="10%">联系方式</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>