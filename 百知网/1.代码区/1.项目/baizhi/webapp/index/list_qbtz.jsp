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
      	<ul>
            <li class="zui"><a href="#">未读通知</a></li>
            <li class="re"><a href="#">全部通知</a></li>
      	</ul>
      </div>
      <div class="line_1"></div>
      <div class="su" style="background:#f7ffe1;">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su" style="background:#f7ffe1;">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>
        <div class="su">
        <a href="#" class="qu">
        <img class="eu" src="img/rw_1.png" />
        </a>
        <div class="nu"><div class="x-d"><a href="#" class="x-a"> 姜文浩 </a>回答了问题 <a href="#">马化腾为什么不做天使投资？</a>
        <span class="x-c">09:54</span></div></div>
        </div>

        
      <div class="tiao"><a href="#">更多 >></a></div>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
                <li><a href="#">所有问题</a></li>
                <li><a href="#">我关注的问题</a></li>
                <li><a href="#">问我的问题</a></li>
                <li><a href="#">邀请我回答的问题</a></li>
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="#">邀请好友</a></div>
            <div class="column_content">
                <div class="coulumn_c_left">
                    <ul>
                        <li><a href="#">发送邮件邀请好友</a></li>
                        <li><a href="#">生成代码邀请好友</a></li>
                    </ul>
                </div>
                <div class="coulumn_c_right"><img src="img/youjian.png" /></div>	
            </div>
        </div>
        <div class="r_column">
            <div class="column">你可能感兴趣的人</div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="img/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="img/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="img/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="column_contentgxq" style="border:0; margin-bottom:0px;">
              <div class="colun_c_gxq">
                <div style="float:left;"><a href="#"><img src="img/rw_1.png" width="25" height="25" border="0" /></a></div>
                    <div class="colun_l"><a href="#">刘阳</a></div>
                </div>
                <div class=" colun_c_main">拉近远方的人的距离，却偶尔推远离，却偶尔推远</div>
          </div>
          <div class="more"><a href="#">更多 >></a></div>
        </div>
        </div>
	<div class="clear"></div>
</div>
<div class="footer">
	<div class="footer_nav"><a href="#">关于百知</a> <span class="STYLE1">?</span> <a href="#">新手入门</a>  <span class="STYLE1">?</span> <a href="#">百知指南</a> <span class="STYLE1">?</span>  <a href="#">百知协议</a> <span class="STYLE1">?</span>  <a href="#">联系我们</a>  <span class="STYLE1">?</span>  <a href="#">2011 百知</a></div>
</div>
</body>
</html>
