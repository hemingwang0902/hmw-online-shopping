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
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="ProblemList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">问题ID：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="PROBLEM_ID" id="PROBLEM_ID" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">问题类型：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="PROBLEM_TYPE" id="PROBLEM_TYPE" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">问题内容：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="CONTENT" id="CONTENT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">是否匿名：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="IS_ANONYMITY" id="IS_ANONYMITY" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">相关细节：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="RELEVANT_DETAILS" id="RELEVANT_DETAILS" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">用户ID：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="USER_ID" id="USER_ID" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">被问用户ID：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="WAS_USERID" id="WAS_USERID" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">答案数量：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="ANSWER_COUNT" id="ANSWER_COUNT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">评论数量：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="REVIEW_COUNT" id="REVIEW_COUNT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">关注数量：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="ATTENTION_COUNT" id="ATTENTION_COUNT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">收藏数量：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="COLLECTION_COUNT" id="COLLECTION_COUNT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">浏览次数：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="BROWSE_COUNT" id="BROWSE_COUNT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">是否举报：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="IS_REPORT" id="IS_REPORT" /> </td>
	
					</tr>
		   			<tr>
						<td class="lightbox_title">举报次数：</td>
					
						<td class="lightbox_content"><input type="text" class="input_width3" name="REPORT_COUNT" id="REPORT_COUNT" /> </td>
	
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
							<input type="button"  value="查询"  class="button_box" onclick="getDataList()"/>
							<input  type="reset"  value="重置"  class="button_box" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="table_box">
			<div class="lightbox_header">
				<span class="font_span">问题信息表列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="新增" class="button_box" onclick="location.href='initProblemForm.go';"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>
		   				<td width="10%">问题ID</td>
		   				<td width="10%">问题类型</td>
		   				<td width="10%">问题内容</td>
		   				<td width="10%">是否匿名</td>
		   				<td width="10%">相关细节</td>
		   				<td width="10%">用户ID</td>
		   				<td width="10%">被问用户ID</td>
		   				<td width="10%">答案数量</td>
		   				<td width="10%">评论数量</td>
		   				<td width="10%">关注数量</td>
		   				<td width="10%">收藏数量</td>
		   				<td width="10%">浏览次数</td>
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