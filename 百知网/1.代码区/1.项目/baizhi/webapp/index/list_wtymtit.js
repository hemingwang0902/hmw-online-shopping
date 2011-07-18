$(document).ready(function(){
	//获取问题回答列表
	getProblemAnswerList();
	
	//添加关注 or 取消关注
	$("#a_attention").click(function(){
		var isDisAttention = $(this).attr("isDisAttention");
		$.post(path.problem.attention, {
			"disAttention": isDisAttention,
			"problemId": $("#problemId").val()
		}, function(){
			if(isDisAttention == "true"){
				$("#a_attention").attr("isDisAttention", false).html("添加关注");
			}else{
				$("#a_attention").attr("isDisAttention", true).html("取消关注");
			}
		});
	}); 

	//添加收藏 or 取消收藏
	$("#a_collection").click(function(){
		var isDisAttention = $(this).attr("isDisAttention");
		$.post(path.problem.collection, {
			"disCollection": isDisAttention,
			"problemId": $("#problemId").val()
		}, function(){
			if(isDisAttention == "true"){
				$("#a_collection").attr("isDisAttention", false).html("添加收藏");
			}else{
				$("#a_collection").attr("isDisAttention", true).html("取消收藏");
			}
		});
	}); 
	
	//“添加话题”按钮的单击事件
	$("#btnShowAddTalk").toggle(function () {
    	$("#divAddTalk").show();
  	}, function () {
    	$("#divAddTalk").hide();
  	}); 
	
	//“邀请他人回答”按钮的单击事件
	$("#a_invite").toggle(function () {
    	$("#div_invite").show();
  	}, function () {
    	$("#div_invite").hide();
  	}); 
	
	//添加话题时，根据输入的内容自动提示
	$("#TALK_CONTENT").autocomplete("getTalklistByContent.go", {
		dataType: "json",
		extraParams:{
			"nowPage": 1,
			"onePageCount": 10
		},
		formatItem: function(row, i, max) {
			return row.CONTENT;
		},
		parse:function(result){ //将从后台返回的数据转化为候选项数组
			var parsed = [];
			if(result != null && result != ''){
				var data = eval("("+result+")");
				if (data != null && data["list"] != null && data["list"].length > 0) {
					for(var i=0;i<data["list"].length;i++){
						var row = data["list"][i];
						parsed[parsed.length] = {
							data: row,
							value: row.CONTENT,
							result: row.CONTENT
						};
					}
				}
			}
			return parsed;
		}
	});
	
	//邀请他人回答时，根据输入的姓名自动提示
	$("#WAS_USER_ID").autocomplete("getUserListByNameWithAjax.go", {
		dataType: "json",
		extraParams:{
			"nowPage": 1,
			"onePageCount": 10,
			"ajax": "true"
		},
		formatItem: function(row, i, max) {
			return row.NAME;
		},
		parse:function(result){ //将从后台返回的数据转化为候选项数组
			var parsed = [];
			if(result != null && result != ''){
				var data = eval("("+result+")");
				if (data != null && data["list"] != null && data["list"].length > 0) {
					for(var i=0;i<data["list"].length;i++){
						var row = data["list"][i];
						parsed[parsed.length] = {
							data: row,
							value: row.NAME,
							result: row.NAME
						};
					}
				}
			}
			return parsed;
		}
	});
});

/**
 * 获取问题回复列表
 */
function getProblemAnswerList(){
	var onePageCount=parseInt($("#onePageCount").val());
	var nowPage=$("#nowPage").val();
	$.post("getProblemAnswerList.go",{
		nowPage: nowPage,
		onePageCount: onePageCount,
		problemId:$("#problemId").val()
	}, function(result){
		//将 nowPage 的值加 1
		$("#nowPage").val(parseInt($("#nowPage").val()) + 1);

		if(result==null||result==''){
			$(".tiao").html("<span>更多 >></span>");
			return;
		}
		
		var data = eval("("+result+")");
		if (data != null && data["list"] != null && data["list"].length > 0) {
			_showAnswer(data["list"]);
		}
		
		if(data["list"].length < onePageCount){
			$(".tiao").html("<span>更多 &gt;&gt;</span>");
		} else{ //查询到的记录条数为空,禁用"更多"
			$(".tiao").html('<a href="javascript:void(0);" onclick="getProblemAnswerList();">更多 &gt;&gt;</a>');
		}
	});	
}

function _showAnswer(answers){
	var ANSWER_ID = ""; 
	var PROBLEM_ID = ""; 
	var CONTENT = ""; 
	var USER_ID = ""; 
	var AGREE_COUNT = ""; 
	var DISAGREE_COUNT = ""; 
	var THANK_COUNT = ""; 
	var DISTHANK_COUNT = ""; 
	var REVIEW_COUNT = ""; 
	var CREATE_TIME = ""; //创建时间
	var MODIFY_TIME = ""; //修改时间
	
	var AGREE = ""; 
	var DISAGREE = ""; 
	var THANK = ""; 
	var DISTHANK = ""; 
	var NAME = ""; 
	var INTRODUCTION = "";
	
	var content = "";
	for(var i=0;i<answers.length;i++){
		ANSWER_ID = answers[i]["ANSWER_ID"];
		PROBLEM_ID = answers[i]["PROBLEM_ID"];
		CONTENT = answers[i]["CONTENT"];
		USER_ID = answers[i]["USER_ID"];//用户ID
		AGREE_COUNT = answers[i]["AGREE_COUNT"];
		DISAGREE_COUNT = answers[i]["DISAGREE_COUNT"];
		THANK_COUNT = answers[i]["THANK_COUNT"];
		DISTHANK_COUNT = answers[i]["DISTHANK_COUNT"];
		REVIEW_COUNT = answers[i]["REVIEW_COUNT"];
		CREATE_TIME = answers[i]["CREATE_TIME"];//创建时间
		MODIFY_TIME = answers[i]["MODIFY_TIME"];//修改时间
		AGREE = parseInt(answers[i]["AGREE"]); 
		DISAGREE = parseInt(answers[i]["DISAGREE"]); 
		THANK = parseInt(answers[i]["THANK"]); 
		DISTHANK = parseInt(answers[i]["DISTHANK"]); 
		NAME = answers[i]["NAME"];
		INTRODUCTION = answers[i]["INTRODUCTION"];

		content += '<div style=" margin-top:15px;">';
		content += '	<div class="title_wtym">';
		content += '		<div class="title_wtym_tit"><a href="'+path.user.detail+USER_ID+'">'+NAME+'</a>， '+INTRODUCTION+'</div>';
		content += '		<div class="title_wtym_con">'+CONTENT+'</div>';
		content += '	</div>';
		content += '	<div class="tit_bot_wtym">';
		content += '		<a href="javascript:void(0);" onclick="showAnswerReview(\''+ANSWER_ID+'\');"><span id="pl_'+ANSWER_ID+'">'+REVIEW_COUNT+'</span> 条评论</a>';
		if(AGREE){
			content += '		 • <span>赞同</span>';
		}else{
			content += '		 • <span id="zt_'+ANSWER_ID+'"><a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Agree\', this);">赞同</a></span>';
		}
		if(DISAGREE){
			content += '		 • <span>反对</span>';
		}else{
			content += '		 • <span id="fd_'+ANSWER_ID+'"><a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'DisAgree\', this);">反对</a></span>';
		}
		if(THANK){
			content += '		 • <span>感谢作者</span>';
		}else{
			content += '		 • <span id="gx_'+ANSWER_ID+'"><a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Thank\', this);">感谢作者</a></span>';
		}
		if(DISTHANK){
			content += '		 • <span>没有帮助</span>';
		}else{
			content += '		 • <span id="my_'+ANSWER_ID+'"><a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Disthank\', this);">没有帮助</a></span>';
		}
		content += '	</div>';
		content += '	<div id="div_pinglun_'+ANSWER_ID+'" style="display:none;"><div id="pl_list_'+ANSWER_ID+'">评论列表</div></div>';
		content += '	<div class="clear"></div>';
		content += '</div>';
	
	}
	$("#problemList").append(content);
}

/**
 * 给问题添加话题
 */
function addTalk(){
	var TALK_CONTENT = $.trim($("#TALK_CONTENT").val());
	if(TALK_CONTENT == ''){
		$("#error_1").text("请输入话题内容。");
		return false;
	}
	
	var result = true;
	$(".list_xgwt_xght a").each(function(i, domEle){
		if($.trim($(domEle).text()) == TALK_CONTENT){
			$("#error_1").text("该问题已经添加了话题“"+TALK_CONTENT+"”。");
			result = false;
			return false;
		}
	});
	
	if(result){
		$("#error_1").text(" ");
		$.post("addTalkForProblem.go",{
			PROBLEM_ID: $("#problemId").val(),
			CONTENT: TALK_CONTENT
		},function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			if(data!=null&&data["TALK_ID"]>0){
				$("#TALK_CONTENT").val("");
				$("#divAddTalk").hide();
				$(".list_xgwt_xght").append('<a href="initHtym.go?TALK_ID='+data["TALK_ID"]+'" style="margin-right: 5px;">'+TALK_CONTENT+'</a>');
			}else{
				show_showmessage({message:"添加话题失败。",type:"error"});
			}
		});
	}
}

/**
 * 添加回复
 */
function addAnswer(){
	var ANSWER_CONTENT = $.trim($("#ANSWER_CONTENT").val());
	if(ANSWER_CONTENT == ''){
		$("#error_2").text("回复内容不能为空。");
		return false;
	}
	
	$("#error_2").text("&nbsp;");
	$.post("saveProblemAnswer.go",{
		problemId: $("#problemId").val(),
		CONTENT: ANSWER_CONTENT
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["ANSWER_ID"]>0){
			var answers = [{
				ANSWER_ID: data["ANSWER_ID"],
				PROBLEM_ID: $("#problemId").val(), 
				CONTENT: ANSWER_CONTENT, 
				USER_ID: $("#loginUser_USER_ID").val(), 
				AGREE_COUNT: 0,
				DISAGREE_COUNT: 0, 
				THANK_COUNT: 0,
				DISTHANK_COUNT: 0, 
				REVIEW_COUNT: 0, 
				CREATE_TIME: "",
				MODIFY_TIME: "",
				AGREE: 0, 
				DISAGREE: 0, 
				THANK: 0, 
				DISTHANK: 0, 
				NAME: $("#loginUser_NAME").val(),
				INTRODUCTION: $("#loginUser_INTRODUCTION").val()
			}];
			_showAnswer(answers);
			$("#ANSWER_CONTENT").val("")
		}else{
			show_showmessage({message:"添加回复失败。",type:"error"});
		}
	});
}

/**
 * 对回复进行操作：赞同、反对、感谢作者、对我没帮助
 */
function answerVote(ANSWER_ID, voteField, domLink){
	$.post("answerVote.go",{
		"ANSWER_ID": ANSWER_ID,
		"voteField": voteField
	},function(){
		domLink.parentNode.innerHTML = domLink.innerText;
	});
}

/**
 * 显示评论列表
 */
function showAnswerReview(){
	//TODO 通过 Ajax 加载评论列表，并显示到页面
}

/**
 * 给回复添加评论
 */
function addAnswerReview(ANSWER_ID, CONTENT){
	$.post("addAnswerReview.go",{
		"ANSWER_ID": ANSWER_ID,
		"CONTENT": CONTENT
	},function(){
		// TODO 更新页面展示
	});
}

/**
 * 邀请他人回答
 */
function addProblemInvite(){
	var WAS_USER_ID = $.trim($("#WAS_USER_ID").val());
	if(WAS_USER_ID == ''){
		return false;
	}
	
	$.post("addProblemInvite.go",{
		"PROBLEM_ID": $("#problemId").val(),
		"WAS_USER_ID": WAS_USER_ID
	},function(){
		$("#INVITE_COUNT").text(parseInt($("#INVITE_COUNT").text())+1);
		$("#div_invite").hide();
		$("#WAS_USER_ID").val("")
	});
}
