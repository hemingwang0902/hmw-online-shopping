$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
});

/**
 * 更多
 */
function getMoreProblemList(){
	getProblemList(path.brand.problemList+"?BRAND_ID="+$("#BRAND_ID").val(), true);
}

/**
 * 关注/取消关注品牌
 * @param {int} BRAND_ID 品牌ID
 */
function attentionBrand(domLink){
	var jqLink = $(domLink);
	var isDisAttention = jqLink.attr("isDisAttention");
	
	$.post(path.brand.attention, {
		"disAttention": isDisAttention,
		"BRAND_ID": $("#BRAND_ID").val()
	}, function(){
		if(isDisAttention == "true"){
			jqLink.attr("isDisAttention", false).html("添加关注");;
		}else{
			jqLink.attr("isDisAttention", true).html("取消关注");;
		}
	});
}