<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../styles/style_home.css" rel="stylesheet" type="text/css" />
<script language="JavaScript"> 
function correctPNG() // correctly handle PNG transparency in Win IE 5.5 & 6. 
{ 
    var arVersion = navigator.appVersion.split("MSIE") 
    var version = parseFloat(arVersion[1]) 
    if ((version >= 5.5) && (document.body.filters)) 
    { 
       for(var j=0; j<document.images.length; j++) 
       { 
          var img = document.images[j] 
          var imgName = img.src.toUpperCase() 
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG") 
          { 
             var imgID = (img.id) ? "id='" + img.id + "' " : "" 
             var imgClass = (img.className) ? "class='" + img.className + "' " : "" 
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' " 
             var imgStyle = "display:inline-block;" + img.style.cssText 
             if (img.align == "left") imgStyle = "float:left;" + imgStyle 
             if (img.align == "right") imgStyle = "float:right;" + imgStyle 
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle 
             var strNewHTML = "<span " + imgID + imgClass + imgTitle 
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";" 
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" 
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" 
             img.outerHTML = strNewHTML 
             j = j-1 
          } 
       } 
    }     
} 
window.attachEvent("onload", correctPNG); 
</script>
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
</style>
</head>

<body>
<div class="top">
	<div class="top_big">
   	  <div class="logo"><img src="img/logo.png" /></div>
        <div class="nav"><a href="#">首页</a>&nbsp;&nbsp;<a href="#">通知</a>&nbsp;&nbsp;<a href="#">私信</a>&nbsp;&nbsp;<a href="#">设置</a>&nbsp;&nbsp;<a href="#">登录</a>&nbsp;&nbsp;<a href="#">注册</a></div>
    </div>
</div>
<div class="content">
	<div class="c_left">
	  <div class="subMenu">
      	<div class="subMenu_wdzx_1">我的私信<span>(共一条)</span></div><div class="subMenu_wdzx_2"><input name="" type="button" value="写私信" style="width:70px; height:30px; background-color:#dadade; line-height:30px;" /></div>
      </div>
      <div class="line_1"></div>
        <div class="wdzx">
        	<div class="wdzx_1"><img src="img/rw_zx.png" /></div>
            <div class="wdzx_2">
           	  <div class="wdzx_3"><a href="#" class="mo">Daniel Wang?</a>：颜梅香@创业吧?</div>
                <div class="wdzx_4">6月2日 14:23 &nbsp;<span><a href="#">共1条对话</a> | <a href="#">回复</a> | <a href="#">删除</a> </span> </div>
            </div>
        </div>
        
  </div>
    
    
    <div class="c_right">
    	<div class="av">担心骚扰？可以<a href="/settings/notify">设置</a>为只接收「我关注的人」给我发私信。</div>
  
        </div>
	<div class="clear"></div>
</div>
<div class="footer">
	<div class="footer_nav"><a href="#">关于百知</a> <span class="STYLE1">?</span> <a href="#">新手入门</a>  <span class="STYLE1">?</span> <a href="#">百知指南</a> <span class="STYLE1">?</span>  <a href="#">百知协议</a> <span class="STYLE1">?</span>  <a href="#">联系我们</a>  <span class="STYLE1">?</span>  <a href="#">2011 百知</a></div>
</div>
</body>
</html>
