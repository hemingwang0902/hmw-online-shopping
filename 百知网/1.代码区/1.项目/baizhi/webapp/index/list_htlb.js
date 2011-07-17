var count;
/* 获取数据列表*/
function getDataList(nowPage){
	//清空消息
	$("#more_tip_message").html("");
	
	$("#nowPage").val(nowPage);
	nowPage=parseInt(nowPage);
	if(nowPage==1){
		$("#list_pqlb").html("");
	}
	var onePageCount=parseInt($("#onePageCount").val());
	
	$.post("getHtlbList.go",{nowPage: nowPage,onePageCount: onePageCount},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			if(nowPage==1){
				count=data["totalCount"] ;
			}
			var map;
			
			for(var i=0;i<data["list"].length;i++){
				map=data["list"][i];
				content+="<div class='title_xgwt'>";
				content+="	<div class='title_xgwt_tu'><a href='initHtym.go?TALK_ID="+map.TALK_ID+"'><img src='"+map.IMAGE_PATH+"' height='77' width='77' onerror=\"load_brand_image_74_74(this)\" /></a></div>";
				content+="	<div class='title_xgwt_xner'style='width:345px;'>";
				content+="		<ul>";
				content+="			<li class='tit'><a href='initHtym.go?TALK_ID="+map.TALK_ID+"'>"+map.NAME+"</a></li>";
				content+="			<li class='tit_con'>"+map.INTRODUCTION==null?"":map.INTRODUCTION+"</li>";
				content+="		</ul>";
				content+="	</div>";
				content+="	<div class='title_xgwt_anniu' >";
				if(map.IS_ATTENTION<=0){
					content+="		<p><input name='' id='TALK_ATT_"+map.TALK_ID+"' type='button' value='添加关注' class='baizhi_button_1' onclick=\"talk_att("+map.TALK_ID+");\" /></p>";
				}else{
					content+="		<p><input name='' id='TALK_ATT_"+map.TALK_ID+"' type='button' value='取消关注' class='baizhi_button_1' onclick=\"talk_att("+map.TALK_ID+");\" /></p>";
				}
				content+="	</div>";
				content+="	<div class='clear'></div>";
				content+="</div>";
			}
		}else{
			$("#more_tip_message").html("无数据");
		}
		$("#list_pqlb").append(content);
	});
	return;
}

function talk_att(TALK_ID){
	if($("#TALK_ATT_"+TALK_ID).val()=="添加关注"){
		saveUserAttention(TALK_ID);
		$("#TALK_ATT_"+TALK_ID).val("取消关注");
	}else{
		cancelUserAttention(TALK_ID);
		$("#TALK_ATT_"+TALK_ID).val("添加关注");
	}
	
}

//添加关注
function saveUserAttention(TALK_ID){
	$.post("../userattentiontalk/addUserAttentiontalk.go",{
		TALK_ID:TALK_ID
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
		}else{
			show_showmessage({message:data["message"],type:"error"});
		}
	});
}

//取消关注
function cancelUserAttention(TALK_ID){
	$.post("../userattentiontalk/cancelUserAttentiontalk.go",{
		TALK_ID:TALK_ID
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
		}else{
			show_showmessage({message:data["message"],type:"error"});
		}
	});
}

//查看更多
function getMoreDataList(){
	var nowPage=parseInt($("#nowPage").val());
	var onePageCount=parseInt($("#onePageCount").val());
	if((nowPage*onePageCount)>=count){
		$("#more_tip_message").html("已经是最后一页");
	}else{
		getDataList(nowPage+1);
	}
}


$(document).ready(function(){
	//获取数据列表
	getDataList(1);
	
	$("#list_pqlb_more").click(function(){
		getMoreDataList();
	});
});  