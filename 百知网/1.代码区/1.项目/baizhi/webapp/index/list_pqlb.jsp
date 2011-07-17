<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript"  src="list_htlb.js"></script>
</head>

<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
	<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <div class="search">
	    <input name="text" type="text" value="请在此添加你的问题 &gt;&gt;" size="" style="height:21px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:450px;" onfocus="javascript:this.value='';" onblur="javascript:this.value='请在此添加你的问题 &gt;&gt;';"/>  
	    <input type="button" class="bot_t" value=""  style=" bottom:0px; float:right;" />
	  </div>
      <div class="subMenu"><input name="" type="button" class="bot_tjht"  value="" />
      </div>
      <div class="line_1"></div>
      <input type="hidden" id="nowPage" name="nowPage" value="1" />
      <input type="hidden" id="onePageCount" name="onePageCount" value="10" />
      <div id="list_pqlb">
      
      </div>
      
      <div class="tiao"><a href="javascript:;" id="list_pqlb_more">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
    <div class="r_column">
            <div class="column">热点品牌</div>
            
          <s:iterator value="returnMap.hotlist" var="hotlist">
          <s:if test="#hotlist!=null&&#hotlist.BRAND_ID!=''">
	          <div class="column_contentgxq">
					<div class="colun_c_pptu">
						<div style="float:left;"><a href="../index/initHyym.go?userId=">
	                	<img src="${cpath }/${hotlist.IMAGE_PATH }" onerror="load_brand_image_60_53(this)" width="60" height="53" border="0" />
	                	</a></div>
	                </div>
	                <div class=" colun_c_ppwz">
	                    <div class="colun_c_xnr"><a href="../index/initHyym.go?userId=">${hotlist.NAME }</a></div>
	                    <div class="colun_c_xnrcon">${hotlist.INTRODUCTION}</div>
	              </div>
	                <div style=" clear:both;font-size:0;"></div>
	          	</div>
          </s:if>
			
            </s:iterator>
          	<!--<div class="more"><a href="#">更多 &gt;&gt;</a></div>
        --></div>
        <div class="r_column">
            <div class="column">最新品牌</div>
          
          <s:iterator value="returnMap.newlist" var="newlist">
           <s:if test="#newlist!=null&&#newlist.BRAND_ID!=''">
          <div class="column_contentgxq">
				<div class="colun_c_pptu">
					<div style="float:left;"><a href="../index/initHyym.go?userId=">
                	<img src="${cpath }/${newlist.IMAGE_PATH }" onerror="load_brand_image_60_53(this)" width="60" height="53" border="0" />
                	</a></div>
                </div>
                <div class=" colun_c_ppwz">
                    <div class="colun_c_xnr"><a href="../index/initHyym.go?userId=">${newlist.NAME }</a></div>
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
