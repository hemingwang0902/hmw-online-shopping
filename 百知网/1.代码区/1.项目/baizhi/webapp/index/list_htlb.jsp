<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" language="javascript"  src="list_htlb.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <%@include file="../common/search.jsp" %>
      <div class="line_1"></div>
      <input type="hidden" id="nowPage" name="nowPage" value="1" />
      <input type="hidden" id="onePageCount" name="onePageCount" value="10" />
      <div id="list_pqlb">
      
      </div>
      <div style="color: red;padding-left: 10px;" id="more_tip_message"></div>
      <div class="tiao"><a href="javascript:;" id="list_pqlb_more">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
    <div class="r_column">
            <div class="column">热点话题</div>
            
          <s:iterator value="returnMap.hotlist" var="hotlist">
          <s:if test="#hotlist!=null&&#hotlist.TALK_ID!=''">
	          <div class="column_contentgxq">
					<div class="colun_c_pptu">
						<div style="float:left;"><a href="initHtym.go?TALK_ID=${hotlist.TALK_ID }">
	                	<img src="${cpath }/${hotlist.IMAGE_PATH }" onerror="load_brand_image_60_53(this)" width="60" height="53" border="0" />
	                	</a></div>
	                </div>
	                <div class=" colun_c_ppwz">
	                    <div class="colun_c_xnr"><a href="initHtym.go?TALK_ID=${hotlist.TALK_ID }">${hotlist.NAME }</a></div>
	                    <div class="colun_c_xnrcon">${hotlist.INTRODUCTION}</div>
	              </div>
	                <div style=" clear:both;font-size:0;"></div>
	          	</div>
          </s:if>
			
            </s:iterator>
          	<!--<div class="more"><a href="#">更多 &gt;&gt;</a></div>
        --></div>
        <div class="r_column">
            <div class="column">最新话题</div>
          
          <s:iterator value="returnMap.newlist" var="newlist">
           <s:if test="#newlist!=null&&#newlist.TALK_ID!=''">
          <div class="column_contentgxq">
				<div class="colun_c_pptu">
					<div style="float:left;"><a href="initHtym.go?TALK_ID=${newlist.TALK_ID }">
                	<img src="${cpath }/${newlist.IMAGE_PATH }" onerror="load_brand_image_60_53(this)" width="60" height="53" border="0" />
                	</a></div>
                </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="initHtym.go?TALK_ID=${newlist.TALK_ID }">${newlist.NAME }</a></div>
                    <div class="colun_c_xnrcon">${newlist.INTRODUCTION}</div>
              </div>
                <div style=" clear:both;font-size:0;"></div>
          	</div>
			</s:if>
            </s:iterator>
          
          <!--<div class="more"><a href="#">更多 &gt;&gt;</a></div>
        --></div>
 
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
