$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
});

/**
 * 更多
 */
function getMoreProblemList(){
	var onePageCount=parseInt($("#onePageCount").val());
	var nowPage=$("#nowPage").val();
	$.post("getListByTitleWithFull.go",{
		q:$("#span_q").text(),
		nowPage: nowPage,
		onePageCount: onePageCount
	}, function(result){
		//将 nowPage 的值加 1
		$("#nowPage").val(parseInt($("#nowPage").val()) + 1);
		
		if(result==null||result==''){
			$(".tiao").html("<span>更多 >></span>");
			return;
		}
		
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			var ID = ""; //ID
			var TITLE = ""; //标题
			var TYPE = ""; //类型
			var INTRODUCTION = ""; //介绍
			var IMAGE_PATH = ""; //Logo路径
			var WEBSITE = ""; //个性网址（用于会员）
			var ATTENTION_COUNT = ""; //关注次数
			
			var typeName = "未知";
			var defaultImagePath = "";
			var url = "javascript:void(0);";
	
			for(var i=0;i<data["list"].length;i++){
				ID = data["list"][i]["ID"];
				TITLE = data["list"][i]["TITLE"];
				TYPE = data["list"][i]["TYPE"];
				INTRODUCTION = data["list"][i]["INTRODUCTION"];
				IMAGE_PATH = data["list"][i]["IMAGE_PATH"];
				WEBSITE = data["list"][i]["WEBSITE"];
				ATTENTION_COUNT = data["list"][i]["ATTENTION_COUNT"];
				
				if(TYPE == '1'){ //会员
					typeName = "会员";
					defaultImagePath = "/images/main/rw_1.png";
					url = path.user.detail + ID;
				}else if(TYPE == '2'){ //品牌
					typeName = "品牌";
					defaultImagePath = "/images/main/pptp_1.png";
					url = path.brand.detail + ID;
				}else if(TYPE == '3'){ //问题
					typeName = "问题";
					defaultImagePath = "/images/main/hylb_1.jpg";
					url = path.problem.detail + ID;
				}else if(TYPE == '4'){ //话题
					typeName = "话题";
					defaultImagePath = "/images/main/xner.jpg";
					url = path.talk.detail + ID;
				}
				
				if(INTRODUCTION == null){
					INTRODUCTION = "&nbsp;";
				}
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=='' || IMAGE_PATH=="null"){
					IMAGE_PATH = defaultImagePath;
				}
				IMAGE_PATH = path.basePath + IMAGE_PATH;
				
				content += '<div class="title_xgwt">';
				content += '  <div class="title_xgwt_tu"><a href="'+url+'"><img src="'+IMAGE_PATH+'" width="74" height="74"/></a></div>';
				content += '  <div class="ssym">';
				content += '    <ul>';
				content += '  		<li class="tit"><a href="'+url+'">'+TITLE+'</a></li>';
				content += '  		<li class="tit_con">'+INTRODUCTION+'</li>';
				content += '  		<li class="ssym_hg">'+typeName+'｜ '+ATTENTION_COUNT+'个关注者</li>';
				content += '	</ul>';
				content += '  </div>';
				content += '  <div class="clear"></div>';
				content += '</div>';
			}
			$("#problemList").append(content);
		}
		
		if(data["list"].length < onePageCount){
			$(".tiao").html("<span>更多 &gt;&gt;</span>");
		} else{ //查询到的记录条数为空,禁用"更多"
			$(".tiao").html('<a href="javascript:void(0);" onclick="getMoreProblemList();">更多 &gt;&gt;</a>');
		}
	});
}