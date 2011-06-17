<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<script type="text/javascript"  src="calendar/WdatePicker.js"></script>
<script type="text/javascript" src="javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" src="javascripts/jquery.validate.js"></script>
<script type="text/javascript" src="javascripts/jquery.select.js"></script>
<script type="text/javascript" src="validate.js"></script>
</head>
<body>
<div class='dicter_window' ></div>
<div class="container">
	<div class="content">
		<form action="" id="validateform" method="post" >
			<div class="lightbox_header"><span class="font_span">表单效验</span></div>
			<div class="btn_box"><input type="submit" id="btn_submit" value="保存" class="button_box"/></div>
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>姓名：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="NAME" name="NAME" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>年龄：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="AGE" name="AGE" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>数字：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="NUMBER" name="NUMBER" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>邮箱地址：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="EMAIL" name="EMAIL" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>电话：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="PHONE" name="PHONE" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>手机：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="MOBILE" name="MOBILE" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>联系方式：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="LINKMODE" name="LINKMODE" />
				        </td>
				        <td >&nbsp;</td>
				        <td >&nbsp;</td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>身份证：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="IDCARD" name="IDCARD" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>字母：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="ENGLISH" name="ENGLISH" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>整数：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="DIGITS" name="DIGITS" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>性别：</td>
				        <td class="lightbox_content">
				        	<select id="SEX" name="SEX" class="select_box" >
				        		<option ></option>
					        	<option value="1">男</option>
					            <option value="2">女</option>
				          	</select>
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>密码：</td>
				        <td class="lightbox_content">
				        	<input type="password" class="input_width" id="PASSWORD" name="PASSWORD" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>确认密码：</td>
				        <td class="lightbox_content">
				        	<input type="password" class="input_width" id="CONFIRM_PASSWORD" name="CONFIRM_PASSWORD" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>最小值：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="MIN" name="MIN" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>最大值：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="MAX" name="MAX" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>网址：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="URL" name="URL" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>图片文件名(gif|png|jpg)：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="ACCEPT" name="ACCEPT" />
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title "><span class="font_red">*</span>邮编地址：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="ZIPCODE" name="ZIPCODE" />
				        </td>
				        <td class="lightbox_title "><span class="font_red">*</span>AJAX效验：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width" id="AJAX" name="AJAX" />
				        </td>
					</tr>
					
					<tr>
						<td class="lightbox_title ">日期：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width " id="DATE1" name="DATE1" onclick="WdatePicker()"/>
				        </td>
				        <td class="lightbox_title ">日期(样式)：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width Wdate" id="DATE2" name="DATE2"  onclick="WdatePicker()"/>
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title ">日期(自定义格式)：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width  Wdate" id="DATE3" name="DATE3" onclick="WdatePicker({dateFmt:'yyyyMMddHHmmss',autoPickDate:true})"/>
				        </td>
				        <td class="lightbox_title "></td>
				        <td class="lightbox_content">
				        </td>
					</tr>
					<tr>
						<td class="lightbox_title ">起始日期：</td>
				        <td class="lightbox_content">
				        	<input type="text" class="input_width  Wdate" id="STARTDATE" name="STARTDATE" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'ENDDATE\')}'})"/>
				        </td>
				        <td class="lightbox_title ">终止日期：</td>
				       <td class="lightbox_content">
				       		<input type="text" class="input_width  Wdate" id="ENDDATE" name="ENDDATE" onclick="WdatePicker({minDate:'#F{$dp.$D(\'STARTDATE\')}'})"/>
				       </td>
					</tr>
					
				</table>
		</form>
	</div>
</div>
</body>
</html>
