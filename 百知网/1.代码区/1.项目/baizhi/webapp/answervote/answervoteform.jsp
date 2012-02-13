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
<script type="text/javascript" language="javascript" src="answervoteform.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="saveAnswerVote.go" method="post" id="AnswerVoteForm">
			<input type="hidden"  id="VOTE_ID" name="VOTE_ID" value='<s:property value="VOTE_ID"/>' />
			<s:token></s:token>
			<input type="hidden" id="ID" name="ID" value='<s:property value="ID"/>'/>
			<div class="lightbox_header"><span class="font_span">问题答案投票信息表表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='answervotelist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>问题答案ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="ANSWER_ID" name="ANSWER_ID" value='<s:property value="ANSWER_ID"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>问题ID(冗余字段)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="PROBLEM_ID" name="PROBLEM_ID" value='<s:property value="PROBLEM_ID"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="VOTE_TYPE" name="VOTE_TYPE" value='<s:property value="VOTE_TYPE"/>'/></td>
						<td class="lightbox_title"><span class="font_red">*</span>是否赞成、感谢(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="IS_AGREE" name="IS_AGREE" value='<s:property value="IS_AGREE"/>'/></td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width" id="USER_ID" name="USER_ID" value='<s:property value="USER_ID"/>'/></td>
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