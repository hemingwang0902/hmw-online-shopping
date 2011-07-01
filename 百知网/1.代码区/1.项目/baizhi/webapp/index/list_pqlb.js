var count;
/* 获取数据列表*/
function getDataList(nowPage){
	$("#nowPage").val(nowPage);
	nowPage=parseInt(nowPage);
	if(nowPage==1){
		$("#list_pqlb").html("");
	}
	var onePageCount=parseInt($("#onePageCount").val());
	
	$.post("../pqlb/getPqlbList.go",{nowPage: nowPage,onePageCount: onePageCount},function(result){
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
				content+="	<div class='title_xgwt_tu'><img src='"+map.IMAGE_PATH+"' /></div>";
				content+="	<div class='title_xgwt_xner'>";
				content+="		<ul>";
				content+="			<li class='tit'><a href='javascript:;'>"+map.NAME+"</a></li>";
				content+="			<li class='tit_con'>"+map.INTRODUCTION+"</li>";
				content+="		</ul>";
				content+="	</div>";
				content+="	<div class='title_xgwt_anniu'>";
				if(map.IS_ATTENTION<=0){
					content+="		<p><input name='' type='button' value='添加关注' class='baizhi_button_1' onclick=\"saveUserAttention("+map.USER_ID+");\" /></p>";
				}else{
					content+="		<p><input name='' type='button' value='取消关注' class='baizhi_button_1' onclick=\"cancelUserAttention("+map.USER_ID+");\" /></p>";
				}
				content+="	</div>";
				content+="	<div class='clear'></div>";
				content+="</div>";
				
			}
		}
		$("#list_pqlb").append(content);
	});
	return;
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
			//查询
			getDataList(1);
			showmessage({message:data["message"],type:"info"});
		}else{
			showmessage({message:data["message"],type:"error"});
		}
	});
}

//取消关注
function cancelUserAttention(WAS_USERID){
	showmessage({message:"是否取消关注?",type:"info",callmethod:function(flag){
		if(flag){
			$.post("../userattention/cancelUserAttention.go",{
				WAS_USERID:WAS_USERID
			},function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				if(data!=null&&data["flag"]==true){
					//查询
					getDataList(1);
					showmessage({message:data["message"],type:"info"});
				}else{
					showmessage({message:data["message"],type:"error"});
				}
			});
		}
	}});
}

//查看更多
function getMoreDataList(){
	var nowPage=parseInt($("#nowPage").val());
	var onePageCount=parseInt($("#onePageCount").val());
	if((nowPage*onePageCount)>=count){
		showmessage({message:"已经是最后一页信息",type:"info"});
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