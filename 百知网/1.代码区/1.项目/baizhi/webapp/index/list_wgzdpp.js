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
	$.post(path.brand.attentionList,{
		nowPage: nowPage,
		onePageCount: onePageCount,
		"userId": $("#USER_ID").val()
	}, function(result){
		if(result==null||result==''){
			$(".tiao").html("<span>更多 >></span>");
			return;
		}
		
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			var BRAND_ID = "";
			var NAME = "";
			var INTRODUCTION = "";
			var IMAGE_PATH = "";
			var ATTENTION = "";
	
			for(var i=0;i<data["list"].length;i++){
				BRAND_ID = data["list"][i]["BRAND_ID"];
				NAME = data["list"][i]["NAME"]; //用户姓名
				INTRODUCTION = data["list"][i]["INTRODUCTION"];
				IMAGE_PATH = data["list"][i]["IMAGE_PATH"]; //头像路径
				ATTENTION = data["list"][i]["ATTENTION"];
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=="null"){
					IMAGE_PATH = "/images/main/xner.jpg";
				}
				IMAGE_PATH = path.basePath + IMAGE_PATH;
				
				var url = path.brand.detail+BRAND_ID;
				
				content += '<div class="title_xgwt_x">';
				content += '	<div class="title_xgwt_tu"><a href="'+url+'"><img src="'+IMAGE_PATH+'" /></a></div>';
				content += '	<div class="title_xgwt_xner">';
				content += '		<ul>';
				content += '			<li class="tit"><a href="'+url+'">'+NAME+'</a></li>';
				content += '			<li class="tit_con">'+INTRODUCTION+'</li>';
				content += '		</ul>';
				content += '	</div>';
				content += '	<div class="title_xgwt_anniu">';
				if(ATTENTION > 0){
					content += '<p><input type="button" value="取消关注" style="width:100px; height:25px; background-color:#dadade" isDisAttention="true" onclick="attentionBrand(\''+BRAND_ID+'\', this);" /></p>';
				}else{
					content += '<p><input type="button" value="添加关注" style="width:100px; height:25px; background-color:#dadade" isDisAttention="false" onclick="attentionBrand(\''+BRAND_ID+'\', this);"/></p>';
				}
				
				content += '	</div>';
				content += '	<div class="clear"></div>';
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

/**
 * 关注/取消关注品牌
 * @param {int} BRAND_ID 品牌ID
 */
function attentionBrand(BRAND_ID, dombtn){
	var jqbtn = $(dombtn);
	var isDisAttention = jqbtn.attr("isDisAttention");
	
	$.post(path.brand.attention, {
		"disAttention": isDisAttention,
		"BRAND_ID": BRAND_ID
	}, function(){
		if(isDisAttention == "true"){
			jqbtn.attr("isDisAttention", false).val("添加关注");;
		}else{
			jqbtn.attr("isDisAttention", true).val("取消关注");;
		}
	});
	
}