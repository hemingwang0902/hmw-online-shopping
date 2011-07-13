<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link href="../styles/style.css" rel="stylesheet" type="text/css"/>
<link href="../styles/lightbox.css" rel="stylesheet" type="text/css"  media="screen"/>
<script type="text/javascript" language="javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.validate.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightbox.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery.lightboxmousewheel.js"></script>
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
			<div class="lightbox_header"><span class="font_span">问题信息表单</span></div>
			<div class="btn_box">
				<input type="submit" value="保存" class="button_box"/>
				<input type="button" value="返回" onclick="location.href='problemlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>问题类型：</td>
						<td class="lightbox_content">
							<input type="hidden" class="input_width" id="PROBLEM_TYPE_HIDDEN" name="PROBLEM_TYPE_HIDDEN" value='<s:property value="PROBLEM_TYPE"/>'/>
							<select id="PROBLEM_TYPE" name="PROBLEM_TYPE" class="select_box"  >
					      		<option value="1">普通</option>
					      		<option value="2">我问的问题</option>
					      	</select>
						</td>
						<td class="lightbox_title"><span class="font_red">*</span>是否匿名(0否、1是)：</td>
						<td class="lightbox_content">
							<input type="hidden" class="input_width" id="IS_ANONYMITY_HIDDEN" name="IS_ANONYMITY_HIDDEN" value='<s:property value="IS_ANONYMITY"/>'/>
							<select  name="IS_ANONYMITY" id="IS_ANONYMITY"  class="select_box">
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="lightbox_title">&nbsp;回答人：</td>
						<td class="lightbox_content" colspan="3">
							<a id="basic_a" href="userbasiclist.jsp?id=WAS_USERID&name=WAS_USERID_TEXT"></a>
							<input type="text" class="input_width Wlightbox" id="WAS_USERID_TEXT" name="WAS_USERID_TEXT"  onclick="$('#basic_a').click();" />
							<input type="hidden" id="WAS_USERID" name="WAS_USERID" value='<s:property value="WAS_USERID"/>' />
						</td>
					</tr>
					<tr>
						<td class="lightbox_title"><span class="font_red">*</span>内容：</td>
						<td colspan="3" class="lightbox_content"><textarea  class="textarea_box"  id="CONTENT" name="CONTENT" ><s:property value="CONTENT"/></textarea></td>
					</tr>
					<tr>
						<td class="lightbox_title">&nbsp;相关细节：</td>
						<td colspan="3" class="lightbox_content"><textarea  class="textarea_box"  id="RELEVANT_DETAILS" name="RELEVANT_DETAILS" ><s:property value="RELEVANT_DETAILS"/></textarea></td>
					</tr>
					
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>