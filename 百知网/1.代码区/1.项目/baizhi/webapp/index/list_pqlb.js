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
	
	$.post("getPqlbList.go",{type:$("#type").val(),nowPage: nowPage,onePageCount: onePageCount},function(result){
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
				content+="	<div class='title_xgwt_tu'><a href='initPpym.go?BRAND_ID="+map.BRAND_ID+"'><img src='"+data.cpath+map.IMAGE_PATH+"' height='77' width='77' onerror=\"load_brand_image_74_74(this)\" /></a></div>";
				content+="	<div class='title_xgwt_xner'style='width:345px;'>";
				content+="		<ul>";
				content+="			<li class='tit'><a href='initPpym.go?BRAND_ID="+map.BRAND_ID+"'>"+map.NAME+"</a></li>";
				content+="			<li class='tit_con'>"+map.INTRODUCTION==null?"":map.INTRODUCTION+"</li>";
				content+="		</ul>";
				content+="	</div>";
				content+="	<div class='title_xgwt_anniu' >";
				if(map.IS_ATTENTION<=0){
					content+="		<p><input name='' id='BRAND_ATT_"+map.BRAND_ID+"' type='button' value='添加关注' class='baizhi_button_1' onclick=\"brand_att("+map.BRAND_ID+");\" /></p>";
				}else{
					content+="		<p><input name='' id='BRAND_ATT_"+map.BRAND_ID+"' type='button' value='取消关注' class='baizhi_button_1' onclick=\"brand_att("+map.BRAND_ID+");\" /></p>";
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


function brand_att(BRAND_ID){
	if($("#BRAND_ATT_"+BRAND_ID).val()=="添加关注"){
		saveUserAttention(BRAND_ID);
		$("#BRAND_ATT_"+BRAND_ID).val("取消关注");
	}else{
		cancelUserAttention(BRAND_ID);
		$("#BRAND_ATT_"+BRAND_ID).val("添加关注");
	}
	
}

//添加关注
function saveUserAttention(BRAND_ID){
	$.post("../userbattention/addUserBAttention.go",{
		BRAND_ID:BRAND_ID
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
function cancelUserAttention(BRAND_ID){
	$.post("../userbattention/cancelBUserAttention.go",{
		BRAND_ID:BRAND_ID
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