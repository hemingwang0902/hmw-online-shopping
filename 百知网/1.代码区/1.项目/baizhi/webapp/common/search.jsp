<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 搜索会员、品牌或问题 -->
 <div class="search">
 	<a href="${basePath }/index/addProblem.jsp" id="item_a"></a>
	<input type="text" id="title" name="title" value="搜索问题、品牌或会员 >>" style="height:21px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:450px;"/>  
	<input type="button" class="bot_t" value="" style=" bottom:0px; float:right;cursor: pointer;" onclick="$('#item_a').click();"/>
 </div>

