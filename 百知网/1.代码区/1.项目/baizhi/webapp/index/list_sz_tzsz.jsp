<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- /webapp/index/list_sz_tzsz.jsp -->
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<%--<script type="text/javascript" language="javascript" src="../index/list_sz_tzsz.js"></script>--%>
	<script type="text/javascript" language="javascript">
	$(document).ready(function(){
		//高亮显示左侧导航的“通知设置”
		$("#setting_left_nav a:eq(3)").attr("href", "javascript:;").css("color", "#f00");
		
		var noticeTypes = ${result };
		$(":checkbox, :radio").each(function(i, ele){
			var setType = noticeTypes[ele.name];
			if(setType == ele.value){
				ele.checked = true;
			} else if(setType == 0){
				ele.checked = false;
			}
		});
		
		$("#btn_save").click(function(){
			var values = "";
			
			$(":checkbox").each(function(i, ele){
				var key = ele.name.substr(ele.name.lastIndexOf("_") + 1);
				var val = ele.checked ? ele.value : "0";
				values += ("," + key + "=" + val);
			});
			
			$(":radio:checked").each(function(i, ele){
				var key = ele.name.substr(ele.name.lastIndexOf("_") + 1);
				values += ("," + key + "=" + ele.value);
			});
			
			$.getJSON("${basePath}/usernotice/saveUserNotice.go", {"values": values.substr(1)}, function(jsonStr){
				var jsonObject = eval("("+jsonStr+")");
				if(jsonObject.flag){
					show_showmessage({message:"提醒通知保存成功",type:"info"});
				}else{
					show_showmessage({message:"提醒通知保存失败",type:"error"});
				}
			})
		});
	});
	</script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<div class="content">
		<%@include file="/common/settingLeftNav.jsp" %>
		<div class="c_left">
			  <div class="list_xgwt_xght_sz">请选择提醒通知</div>
		      <div class="list_sz_tzsz">
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_1" name="SET_TYPE_1" value="1"/>&nbsp;有人关注了我</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_2" name="SET_TYPE_2" value="1"/>&nbsp;有人问了我一个问题</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_3" name="SET_TYPE_3" value="1"/>&nbsp;有人邀请我回答一个问题</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_4" name="SET_TYPE_4" value="1"/>&nbsp;我关注的问题有了新答案</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_5" name="SET_TYPE_5" value="1"/>&nbsp;有人关注了我的品牌</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_7" name="SET_TYPE_7" value="1"/>&nbsp;有人关注了我的品牌下的问题</label> <br />
		      	<label><input type="checkbox" checked="checked" id="SET_TYPE_8" name="SET_TYPE_8" value="1"/>&nbsp;我关注的品牌下的问题有了新答案</label> <br />
		      </div>
		      
		      <div class="list_xgwt_xght_sz">设置谁可以给我发私信</div>
		      <div class="list_se_bcsz_1">
		      	<label><input name="SET_TYPE_6" id="SET_TYPE_6_3" type="radio" value="3" />所有人</label>&nbsp;
		      	<label><input name="SET_TYPE_6" id="SET_TYPE_6_4" type="radio" value="4" checked="checked"/>我关注的人<label>
		   	  </div>
		      
		      <div class="list_xgwt_xght_sz">私信可见性设置</div>
		      <div class="list_se_bcsz_1">
			      	<input name="SET_TYPE_9" id="SET_TYPE_9_3" type="radio" value="3" />全站可见
			      	<input name="SET_TYPE_9" id="SET_TYPE_9_5" type="radio" value="5" checked="checked" />好友可见
			      	<input name="SET_TYPE_9" id="SET_TYPE_9_0" type="radio" value="0" />自己可见
		   	  </div>
		      
		      <div class="list_xgwt_xght_sz">心情可见性设置</div>
		      <div class="list_se_bcsz_1">
			      	<input name="SET_TYPE_10" id="SET_TYPE_10_3" type="radio" value="3" />全站可见
			      	<input name="SET_TYPE_10" id="SET_TYPE_10_5" type="radio" value="5" checked="checked" />好友可见
			      	<input name="SET_TYPE_10" id="SET_TYPE_10_0" type="radio" value="0" />自己可见
		   	  </div>
		   	  
		      <div class="list_sz_zhsz_bcsz">
		        <input id="btn_save" type="button" class="list_sz_bcmm" value="保存"/>
		      </div>
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>