<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>泰成集团信息化平台</title>
<script type="text/javascript" src="javascripts/jquery.js"></script>
<script type="text/javascript" src="javascripts/jquery.lightbox.js"></script>
<script type="text/javascript" src="javascripts/jquery.lightboxmousewheel.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#value1").val(parent.$("#value1").val());
	
	$("#btn_param").click(function(){
		parent.$("#value2").val($("#value2").val());
		parent.$.fancybox.close();
	});
	
	$("#btn_method").click(function(){
		parent.aa();
	});
});



</script>
</head>
<body>
<div id="light_top" class="light_top"></div>

<input type="text" id="value1" />
将值传给父窗口<input type="text" id="value2" value="22" />

<input type="button" id="btn_param" value="确定" />
<br>
<input type="button" id="btn_method" value="调用父类方法" />

<div id="light_tool" class="light_tool"></div>
</body>
</html>