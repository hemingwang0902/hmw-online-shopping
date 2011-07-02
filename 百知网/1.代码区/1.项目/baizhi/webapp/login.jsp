<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/jsCss.jsp" %>
	<style type="text/css">
		td{height: 40px;}
	</style>
</head>
<body>
	<%@include file="common/head.jsp" %>
	<div class="content">
		<div style="height:400px; text-align: center;">
			<form action="login.go" id="loginform" name="loginform" method="post">
				<table>
					<tr>
						<td style="width: 100px;" align="right">用户名：</td>
						<td align="left"><input type="text" class="input_width" id="username" name="username"  value="bb@qq.com" /><span class="error" id="message"><s:property value="message" /></span></td>
					</tr>
					<tr>
						<td align="right">密码：</td>
						<td align="left"><input type="password" class="input_width" id="userpwd" name="userpwd" value="111111" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input id="btn_login" type="submit" class="baizhi_button_1" value="登录" />
							<input id="btn_reset" type="reset" class="baizhi_button_1" value="重置" />
						</td>
					</tr>
				</table>
			</form>				
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="common/foot.jsp" %>
</body>
</html>
