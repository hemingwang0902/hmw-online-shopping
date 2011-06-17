<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link rel="stylesheet" type="text/css" href="styles/common.css" />
<script type="text/javascript" language="javascript" src="javascripts/jquery.js"></script>
<script type="text/javascript" language="javascript"  src="javascripts/pagination.js"></script>
<script type="text/javascript" language="javascript" src="javascripts/common.deal.js"></script>
<script type="text/javascript" language="javascript"  src="deptlist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="deptform" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td nowrap="nowrap" class="lightbox_title">部门名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="DEPT_NAME" id="DEPT_NAME" /> </td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td style="padding-top:5px; padding-bottom:5px;">
							<input type="button"  value="查询"  class="button_box" id="btn_search"/>
							<input  type="reset"  value="重置"  class="button_box" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="table_box">
			<div class="lightbox_header">
				<span class="font_span"> 部门列表</span>
			</div>
			<div class="lightbox_opt">
				<a href="deptTurn.go" class="button_box">新增</a>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="15%">操作</td>
						<td width="20%">部门名称</td>
						<td width="65%">部门描述</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>