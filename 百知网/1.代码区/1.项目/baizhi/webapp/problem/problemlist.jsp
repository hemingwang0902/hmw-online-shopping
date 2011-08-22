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
<script type="text/javascript" language="javascript"  src="problemlist.js"></script>
</head>
<body background='../images/main/mixbj.jpg;'>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="ProblemList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
				<%--
		   			<tr>
						<td class="lightbox_title">问题类型：</td>
						<td class="lightbox_content">
							<select id="PROBLEM_TYPE" name="PROBLEM_TYPE" class="select_box3"  >
								<option value=""></option>
					      		<option value="1">普通</option>
					      		<option value="2">我问的问题</option>
				      		</select>
						</td>
					</tr>
					--%>
					<tr>
						<td class="lightbox_title">姓名：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">问题内容：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="CONTENT" id="CONTENT" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">是否匿名：</td>
						<td class="lightbox_content">
							<select  name="IS_ANONYMITY" id="IS_ANONYMITY"  class="select_box3">
								<option value=""></option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">是否举报：</td>
						<td class="lightbox_content">
							<select  name="IS_REPORT" id="IS_REPORT"  class="select_box3">
								<option value=""></option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="lightbox_title">是否置顶：</td>
						<td class="lightbox_content">
							<select  name="IS_TOP" id="IS_TOP"  class="select_box3">
								<option value=""></option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
		   			<tr>
						<td class="lightbox_title">创建时间(起)：</td>
						<td class="lightbox_content">
							<input type="text" class="input_width3 Wdate"  onclick="WdatePicker()" name="CREATE_TIME" id="CREATE_TIME" /> 
						</td>
					</tr>
					<tr>
						<td class="lightbox_title">创建时间(止)：</td>
						<td class="lightbox_content">
							<input type="text" class="input_width3 Wdate"  onclick="WdatePicker()" name="CREATE_TIME_END" id="CREATE_TIME_END" /> 
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
				<span class="font_span">问题信息列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="新增" class="button_box" onclick="location.href='initProblemForm.go';"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
				<input type="button"  value="置顶" class="button_box" onclick="topData($.fn.getCheckValue())"/>
				<input type="button"  value="取消置顶" class="button_box" onclick="cancelTopData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%"><div style="width:60px;">操作</div></td>
		   				<%--<td width="10%">问题类型</td>--%>
		   				<td width="10%">问题内容</td>
		   				<td width="10%">姓名</td>
		   				<td width="10%">答案数量</td>
		   				<td width="10%">评论数量</td>
		   				<td width="10%">关注数量</td>
		   				<td width="10%">收藏数量</td>
		   				<td width="10%">浏览次数</td>
		   				<td width="10%">是否置顶</td>
		   				<td width="10%">是否匿名</td>
		   				<td width="10%">是否举报</td>
		   				<td width="10%">举报次数</td>
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