<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/basePath.jsp" %>
<%@ include file="common/jsCss.jsp" %>
<script type="text/javascript" language="javascript" src="${basePath }/areadata.js"></script>
<script type="text/javascript" language="javascript" src="${basePath }/city.js"></script>

<style type="text/css">
a:link {
	color: #000;
}

a:hover {
	color:#F00;
}
ul {
	padding:0;
	margin-bottom: 10px;
}
ul li {
	display:inline;
	position:relative;
}
#change_city {
	border:1px solid #000;
	margin:200px;
	padding:0.4em;
	width:4em;
	position:relative;
}
#show_provinces {
	height:320px;
	width:98%;
	position:absolute;
	top:2em;
	left:0;
	background-color:#FFFFD2;
	border:1px solid #D8D8D8;
	padding:1em;
	margin:0;
}
.sub_title {z-index: -2;font-size: 16px;margin-bottom: 10px;font-weight:bolder;}


.show_citys {
	width:100%;
	background-color:#D1F1E7;
	border:1px solid #CCC;
	padding-left:45px;
	padding-top:28px;
	height: 30px;
	text-align: left;
	font-size: 14px;
	color: blue;
	
}
</style>
<div id="show_provinces">
    <div style="margin-bottom:0.75em; font-weight:bolder;"><span>请选择您所在的城市:</span><span><s:property value="#session.userinfo.CITY_NAME"/></span></div>
    <!-- 可以从此处循环遍历一级菜单项和二级菜单项 -->
    <ul id="change_area_list">
    	
      <!--<li>
      	<span class="sub_title"><a href="#">安徽</a></span>
        <ul class="show_citys">
          <li><a href="#">合肥</a></li>
          <li><a href="#">芜湖</a></li>
          <li><a href="#">蚌埠</a></li>
          <li><a href="#">安庆</a></li>
          <li><a href="#">阜阳</a></li>
          <li><a href="#">滁州</a></li>
          <li><a href="#">亳州</a></li>
        </ul>
      </li>
      
      
    --></ul>
  </div>