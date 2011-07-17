$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
});

/**
 * 更多
 */
function getMoreProblemList(){
	getProblemList(path.talk.problemList+"?TALK_ID="+$("#TALK_ID").val(), true);
}

/**
 * 关注/取消关注品牌
 * @param {int} BRAND_ID 品牌ID
 */
function attentionBrand(domLink){
	var jqLink = $(domLink);
	var isDisAttention = jqLink.attr("isDisAttention");
	if(isDisAttention == "true"){ //取消关注
		$.post("../userattentiontalk/cancelUserAttentiontalk.go",{
			TALK_ID_ID: $("#TALK_ID").val()
		},function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			if(data!=null&&data["flag"]==true){
				jqLink.attr("isDisAttention", false).html("添加关注");
			}else{
				show_showmessage({message:data["message"],type:"error"});
			}
		});
	}else{ //添加关注
		$.post("../userattentiontalk/addUserAttentiontalk.go",{
			TALK_ID: $("#TALK_ID").val()
		},function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			if(data!=null&&data["flag"]==true){
				jqLink.attr("isDisAttention", true).html("取消关注");
			}else{
				show_showmessage({message:data["message"],type:"error"});
			}
		});
	}
}