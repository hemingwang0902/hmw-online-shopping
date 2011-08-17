$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
	
		//新增问题弹出框
	$("#item_talkImage").fancybox({
		'width'				: 450,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic'//弹出方式
	});
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
			TALK_ID: $("#TALK_ID").val()
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

/**
 * 修改话题描述
 */
function updateTalkIntroduction(){
	var TALK_INTRODUCTION = $.trim($(CKEDITOR.instances.TALK_INTRODUCTION.getData()).html());
	if(TALK_INTRODUCTION == null || TALK_INTRODUCTION.replace(/&nbsp;|\s/g, "") == ""){
		$("#error_3").text("话题描述不能为空");
		return false;
	}
	
	$("#error_3").text(" ");
	$.post("updateTalk.go",{
		TALK_ID: $("#TALK_ID").val(),
		"INTRODUCTION": TALK_INTRODUCTION
	},function(){
		$("#SPAN_TALK_INTRODUCTION").html(TALK_INTRODUCTION);
		$("#DIV_TALK_INTRODUCTION_0").show();
		$("#DIV_TALK_INTRODUCTION_1").hide();
	});
}
