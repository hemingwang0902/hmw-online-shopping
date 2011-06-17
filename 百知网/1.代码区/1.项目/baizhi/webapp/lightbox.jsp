<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>baizhi</title>

<script type="text/javascript" src="javascripts/jquery.js"></script>
<script type="text/javascript" src="javascripts/jquery.lightbox.js"></script>
<script type="text/javascript" src="javascripts/jquery.lightboxmousewheel.js"></script>
<link href="styles/lightbox.css" rel="stylesheet" type="text/css"  media="screen"/>
<script type="text/javascript">
$(document).ready(function() {
	$("#demo1").fancybox({
		'width'				: 500,      //弹出框宽度
		'height'			: 500,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic' //弹出方式
	});
	
});
function aa(){
	alert("调用父类方法aa()");
}
	
</script>
</head>
<body>

<input type="text" value="11" id="value1" />
<a id="demo1" href="lightboxdemo.jsp">弹出框口，将方本框值传到弹出框口</a><input type="text" value="" id="value2" />

</body>
</html>
