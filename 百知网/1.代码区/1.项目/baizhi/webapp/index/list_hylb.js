var count;
/* 获取数据列表*/
function getDataList(nowPage){
	//清空消息
	$("#more_tip_message").html("");
	$("#nowPage").val(nowPage);
	nowPage=parseInt(nowPage);
	if(nowPage==1){
		$("#list_hylb").html("");
	}
	var onePageCount=parseInt($("#onePageCount").val());
	
	$.post("getHylbList.go",{nowPage: nowPage,onePageCount: onePageCount},function(result){
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
				content+="	<div class='title_xgwt_tu'><a href='../index/initHyym.go?userId="+map.USER_ID+"'><img src='"+path.basePath+map.IMAGE_PATH+"' heigth='74' width='74' onerror=\"load_person_image_74_74(this)\"  /></a></div>";
				content+="	<div class='title_xgwt_xner'>";
				content+="		<ul>";
				content+="			<li class='tit'><a href='../index/initHyym.go?userId="+map.USER_ID+"'>"+map.NAME+"</a></li>";
				content+="			<li class='tit_con'>"+map.INTRODUCTION+"</li>";
				content+="		</ul>";
				content+="	</div>";
				content+="	<div class='title_xgwt_anniu'>";
				if(map.IS_ATTENTION<=0){
					content+="		<p><input name='' id='USER_ATT_"+map.USER_ID+"' type='button' value='添加关注' class='baizhi_button_1' onclick=\"user_att("+map.USER_ID+");\" /></p>";
				}else{
					content+="		<p><input name='' id='USER_ATT_"+map.USER_ID+"' type='button' value='取消关注' class='baizhi_button_1' onclick=\"user_att("+map.USER_ID+");\" /></p>";
				}
				content+="	</div>";
				content+="	<div class='clear'></div>";
				content+="</div>";
				
			}
		}else{
			$("#more_tip_message").html("无数据");
		}
		$("#list_hylb").append(content);
	});
	return;
}

function user_att(WAS_USERID){
	if($("#USER_ATT_"+WAS_USERID).val()=="添加关注"){
		saveUserAttention(WAS_USERID);
		$("#USER_ATT_"+WAS_USERID).val("取消关注");
	}else{
		cancelUserAttention(WAS_USERID);
		$("#USER_ATT_"+WAS_USERID).val("添加关注");
	}
	
}


//添加关注
function saveUserAttention(WAS_USERID){
	$.post("../userattention/saveUserAttention.go",{
		WAS_USERID:WAS_USERID
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
function cancelUserAttention(WAS_USERID){
	$.post("../userattention/cancelUserAttention.go",{
		WAS_USERID:WAS_USERID
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
	
	$("#list_hylb_more").click(function(){
		getMoreDataList();
	});
});  