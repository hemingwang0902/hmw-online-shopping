$(document).ready(function(){
	$("#noreadmessage").click(function(){
		$(this).attr("class","zui");
		$("#allreadmessage").attr("class","re");
		$("#IS_OPEN").val(0);
		getDataList(1);
	});
	
	$("#allreadmessage").click(function(){
		$(this).attr("class","zui");
		$("#noreadmessage").attr("class","re");
		$("#IS_OPEN").val(1);
		getDataList(1);
	});
	
	$("#list_pqlb_more").click(function(){
		getMoreDataList();
	});
	
	//获取数据列表
	getDataList(1);
});


var count;
/* 获取数据列表*/
function getDataList(nowPage){
	$("#more_tip_message").html("");
	$("#nowPage").val(nowPage);
	nowPage=parseInt(nowPage);
	if(nowPage==1){
		$("#userdynamiclist").html("");
	}
	var onePageCount=parseInt($("#onePageCount").val());
	
	$.post("../userdynamic/getUserDynamicList.go",{IS_OPEN:$("#IS_OPEN").val(),nowPage: nowPage,onePageCount: onePageCount},function(result){
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
				if(map.DYNAMIC_TYPE==1){
					content += "<div class='su' style='background:#f7ffe1;'>";
					content += "	<a href='../index/initHyym.go?userId="+map.USER_ID+"' class='qu' onclick=\"modifyIsOpen("+map.DYNAMIC_ID+")\">";
					content += "		<img class='eu' src='"+data.cpath+"/"+map.IMAGE_PATH+"' height='25' width='25' onerror='load_person_image_25_25(this)' />";
					content += "	</a>";
					content += "	<div class='nu'><div class='x-d'>";
					content += "		<a href='../index/initHyym.go?userId="+map.USER_ID+"' class='x-a' onclick=\"modifyIsOpen("+map.DYNAMIC_ID+")\"> "+map.USER_NAME+" </a>"+map.CONTENT;
					content += "		<span class='x-c'>"+map.CREATE_TIME+"</span>";
					content += "	</div></div>";
					content += "</div>";
				}else{
					content += "<div class='su' style='background:#f7ffe1;'>";
					content += "	<a href='../index/initHyym.go?userId="+map.USER_ID+"' class='qu' >";
					content += "		<img class='eu' src='"+data.cpath+"/"+map.IMAGE_PATH+"' height='25' width='25' onerror='load_person_image_25_25(this)' />";
					content += "	</a>";
					content += "	<div class='nu'><div class='x-d'>";
					content += "		<a href='../index/initHyym.go?userId="+map.USER_ID+"' class='x-a' > "+map.USER_NAME+" </a>&nbsp;<a href='javascript:;' onclick=\"modifyIsOpen("+map.DYNAMIC_ID+")\">"+map.CONTENT+"</a>";
					content += "		<span class='x-c'>"+map.CREATE_TIME+"</span>";
					content += "	</div></div>";
					content += "</div>";
				}
				
				
			}
		}else{
			$("#more_tip_message").html("无数据");
		}
		$("#userdynamiclist").append(content);
	});
	return;
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

//修改未读通知数量
function modifyIsOpen(DYNAMIC_ID){
	var IS_OPEN=$("#IS_OPEN").val();
	if(IS_OPEN!=1){
		$.post("../userdynamic/modifyIsOpen.go",{DYNAMIC_ID:DYNAMIC_ID},function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			//查询记录
			getDataList(1);
			//查询消息总数
			getUserDynamicCount();
		});
	}
	
	
	return;
}
