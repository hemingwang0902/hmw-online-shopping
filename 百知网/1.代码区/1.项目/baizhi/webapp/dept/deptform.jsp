<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>baizhi</title>
<link href="../../../styles/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" src="../../../javascripts/jquery.validate.js"></script>
<script type="text/javascript" src="deptform.js"></script>
</head>
<body>  	
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div id="tip_message" class="tip_message" ><s:property value="message"/></div>
		<form action="deptSave.go" method="post" id="deptform">
			<s:token></s:token>
			<input type="hidden" id="DEPT_ID" name="DEPT_ID" value='<s:property value="DEPT_ID"/>'/>
			<div class="lightbox_header"><span class="font_span">职能部门表单</span></div>
			<div class="btn_box">
				<input type="submit"  value="保存" class="button_box"/>
				<input type="button"  value="返回" onclick="location.href='deptlist.jsp';" class="button_box"/>
			</div>
			<div class="form_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
				    	<td class="lightbox_title"><span class="font_red">*</span>职能部门名称：</td>
				        <td class="lightbox_content" colspan="3">
				        	<input type="text" class="input_width" id="DEPT_NAME" name="DEPT_NAME" value= '<s:property value="DEPT_NAME"/>'/>
				        </td>
				        
				    </tr>
					<tr>
				        <td class="lightbox_title ">&nbsp;职能部门描述：</td>
				        <td colspan="3" class="lightbox_content"><textarea  class="textarea_box"  id="DEPT_REMARK" name="DEPT_REMARK" ><s:property value="DEPT_REMARK"/></textarea></td>
				    </tr>  
				    <tr>
					    <td class="lightbox_title">&nbsp;创建人：</td>
					    <td class="lightbox_content"><input  id="CURR_CREATE_BY" name="CURR_CREATE_BY" readonly="readonly"  class="input_width readonly"  value="${CURR_CREATE_BY }" /> </td>
					    <td class="lightbox_title">&nbsp;创建时间：</td>
					    <td class="lightbox_content"><input  id="CURR_CREATE_TIME" name="CURR_CREATE_TIME" readonly="readonly"   class="input_width readonly"  value="${CURR_CREATE_TIME }" /> </td>
					</tr>
				    <tr>
				        <td class="lightbox_title">&nbsp;修改人：</td>
				        <td class="lightbox_content"><input  id="CURR_MODIFY_BY" name="CURR_MODIFY_BY" readonly="readonly"  class="input_width readonly"  value="${CURR_MODIFY_BY }" /> </td>
				        <td class="lightbox_title">&nbsp;修改时间：</td>
				        <td class="lightbox_content"><input  id="CURR_MODIFY_TIME" name="CURR_MODIFY_TIME" readonly="readonly"   class="input_width readonly"  value="${CURR_MODIFY_TIME }" /> </td>
				    </tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>