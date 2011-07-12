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
		$("#IS_OPEN").val("");
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
	$("#nowPage").val(nowPage);
	nowPage=parseInt(nowPage);
	if(nowPage==1){
		$("#userdynamiclist").html("");
	}
	var onePageCount=parseInt($("#onePageCount").val());
	
	//删除原有记录
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
				content += "<div class='su' style='background:#f7ffe1;'>";
				content += "	<a href='#' class='qu'>";
				content += "		<img class='eu' src='"+data.cpath+"/"+map.IMAGE_PATH+"' />";
				content += "	</a>";
				content += "	<div class='nu'><div class='x-d'>";
				content += "		<a href='#' class='x-a'> "+map.USER_NAME+" </a>回答了问题 <a href='#'>"+map.CONTENT+"</a>";
				content += "		<span class='x-c'>"+map.CREATE_TIME+"</span>";
				content += "	</div></div>";
				content += "</div>";
				
			}
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
		showmessage({message:"已经是最后一页信息",type:"info"});
	}else{
		getDataList(nowPage+1);
	}
}
