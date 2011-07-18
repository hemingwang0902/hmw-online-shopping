<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="../styles/message.css" />
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_wdzx.js"></script>
</head>

<body>
<%@include file="../common/head.jsp" %>
<div class="content">
	<div class="c_left">
	  <div class="subMenu">
      	<div class="subMenu_wdzx_1">我的私信<span>(共<span id="private_count">0</span>条)</span></div><div class="subMenu_wdzx_2"><input name="" type="button" value="写私信" onclick="$('#private_a').click();" style="width:70px; height:30px; background-color:#dadade; line-height:30px;" /></div>
      </div>
      <div class="line_1"></div>
      	<div id="userprivatelist">
      		
      	</div>
        
        
  </div>
    
    
    <div class="c_right">
    	<div class="av">担心骚扰？可以<a href="../usernotice/getUserNoticeList.go">设置</a>为只接收「我关注的人」给我发私信。</div>
  
        </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
	<a href="#private_window" id="private_a"></a>
	<div style="display: none;">
		<div style="height: 250px;width: 450px;" id="private_window">
			<div style="width:100%;text-align: left;margin-bottom: 10px;background-color: #98b012;height: 30px;padding-top: 10px;font-size: 15px;color: white;" >发送私信</div>
			<div style="width:100%; ">
				<div style="float: left;width: 70px;">
					<div style="text-align: right;padding-right: 15px;margin-bottom: 10px;">发给：</div>
					<div style="text-align: right;padding-right: 15px;">内容：</div>
				</div>
				<div style="float: left;">
					<div style="width: 360px;">
					
					<input type="text" style="width: 355px;margin-bottom: 10px;display: none;" id="USER_IDS" />
					<div style="width:355px;border: solid 1px;height: 26px;padding-bottom: 2px;padding-top: 2px;margin-bottom: 5px;padding-left: 2px;">
						<div style="clear: both;height: 25px;background-color: gray;float: left;border: solid 1px;">
							<div style="height: 25px;float: left;margin-right: 5px;">aaaaaaaaaaa</div>
							<div style="float: left;background:url(../images/main/hlcr_btn.gif) no-repeat;width: 16px;height: 16px;"></div>
						</div>
					</div>
					</div>
					<div style="clear: both;"><textarea style="width: 357px;margin-bottom: 10px;height: 80px;" id="PRIVATE_CONTENT"></textarea></div>
					<div >
						<div id="PRIVATE_MESSAGE" style="color: red;float: left;"></div>
						<div style="text-align: right;float: right;padding-right: 20px;">
							<input type="button" value="取消" onclick="$.fancybox.close();" />
							<input type="button" value="发送" onclick="saveData()" />
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
