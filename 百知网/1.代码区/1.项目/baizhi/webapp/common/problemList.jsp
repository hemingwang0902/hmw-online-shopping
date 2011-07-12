<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 问题列表 -->
<input type="hidden" id="onePageCount" value="20">
<input type="hidden" id="nowPage" value="1">
 <div id="problemList"></div>
<div class="tiao"><a href="javascript:void(0);" onclick="getMoreProblemList();">更多 &gt;&gt;</a></div>