<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>

</head>
<body style="overflow-y: visible;width:1003px; height:700px;">
	<div style="overflow-y: visible;width:1003px; height:700px; float:left;border: 1px solid #0067CB">
	<div class="top_menu">
        <div class="logo"><img src="images/logo.gif" /></div>
        <div class="handle_box">
        <div class="welfont_box">&nbsp;</div>
        <div class="handlebox_link">百知网</div>
        </div>
	</div>
	<div style="width: 100%;height: 100%;text-align: center;">
		<form action="login.go" id="loginform" name="loginform" method="post">
				<table  >
					<tr>
						<td style="width: 100px;" align="right">用户名：</td>
						<td style="width: 400px;" align="left"><input type="text" class="input_width" id="username" name="username"  value="123123" /><span class="error" id="message"><s:property value="message" /></span></td>
						<td></td>
					</tr>
					<tr>
						<td align="right">密码：</td>
						<td align="left"><input type="password" class="input_width" id="userpwd" name="userpwd" value="111111" /></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3" style="padding-left: 100px;padding-top: 20px;" align="left">
							<input type="submit" id="btn_login"  class="button_box"   value="登录" />　<input type="reset"  class="button_box"   id="btn_reset"  value="重置" />
						</td>
					</tr>
				</table>
			</form>
	</div>
	</div>
</body>
</html>
