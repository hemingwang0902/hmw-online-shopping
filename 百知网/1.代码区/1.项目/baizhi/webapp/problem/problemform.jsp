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
<script type="text/javascript" language="javascript" src="problemform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveProblem.go" method="post" id="ProblemForm">
			<input type="hidden"  id="PROBLEM_ID" name="PROBLEM_ID" value='<s:property value="PROBLEM_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">问题信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='problemlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>问题类型(字典：1普通、2我问的问题)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="PROBLEM_TYPE" name="PROBLEM_TYPE" value='<s:property value="PROBLEM_TYPE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>问题内容：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CONTENT" name="CONTENT" value='<s:property value="CONTENT"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>是否匿名(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IS_ANONYMITY" name="IS_ANONYMITY" value='<s:property value="IS_ANONYMITY"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>相关细节：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="RELEVANT_DETAILS" name="RELEVANT_DETAILS" value='<s:property value="RELEVANT_DETAILS"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="USER_ID" name="USER_ID" value='<s:property value="USER_ID"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>被问用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="WAS_USERID" name="WAS_USERID" value='<s:property value="WAS_USERID"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>答案数量：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ANSWER_COUNT" name="ANSWER_COUNT" value='<s:property value="ANSWER_COUNT"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>评论数量：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REVIEW_COUNT" name="REVIEW_COUNT" value='<s:property value="REVIEW_COUNT"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>关注数量：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ATTENTION_COUNT" name="ATTENTION_COUNT" value='<s:property value="ATTENTION_COUNT"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>收藏数量：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="COLLECTION_COUNT" name="COLLECTION_COUNT" value='<s:property value="COLLECTION_COUNT"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>浏览次数：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="BROWSE_COUNT" name="BROWSE_COUNT" value='<s:property value="BROWSE_COUNT"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>是否举报(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IS_REPORT" name="IS_REPORT" value='<s:property value="IS_REPORT"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>举报次数：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="REPORT_COUNT" name="REPORT_COUNT" value='<s:property value="REPORT_COUNT"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>创建时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="CREATE_TIME" name="CREATE_TIME" value='<s:property value="CREATE_TIME"/>'/></td>
					</tr>
					<tr>
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