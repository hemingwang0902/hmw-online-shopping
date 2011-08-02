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
	$("#WAS_USER_ID").keyup(function(eve){
		if(eve.which ==13){
			changUserIds();
		}
	}).focus(changUserIds).autocomplete("getUserListByNameWithAjax.go", {
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
							value: row.USER_ID+","+row.NAME,
							result: row.USER_ID+","+row.NAME
						};
					}
				}
			}
			return parsed;
		}
	});
	
	$("#DEL_USER").click(function(){
		$("#div_USER").hide();
		$("#WAS_USER_ID").val("").show();
	});
});

function changUserIds(){
	var v = $("#WAS_USER_ID").val().split(",");
	if(v.length == 2){
		$("#WAS_USER_ID").hide().val(v[0]);
		$("#USER_NAME").text(v[1]);
		$("#div_USER").show();
	}
}

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
		content += '		<div class="title_wtym_con">';
		content += '		<span id="ANSWER_CONTENT_'+ANSWER_ID+'">' + CONTENT + '</span>';
		if(USER_ID == $("#loginUser_USER_ID").val()){
			$("#div_tjda").remove();
			content += '		<a id="updateLink" href="javascript:void(0);" onclick="$(\'#div_xgda\').show();$(\'#ANSWER_CONTENT_'+ANSWER_ID+',#updateLink\').hide();">修改</a>';
			content += '        <div id="div_xgda" class="wtym_tjda" style="display: none;">';
			content += '        <div class="tit_wtym_daan">';
			content += '			<textarea id="ANSWER_CONTENT" cols="0" rows="0" style="width:540px; height:130px;">'+CONTENT+'</textarea>';
			content += '		</div>';
			content += '		<div id="error_2" class="error" style="margin-right: 10px;float: left"></div>';
			content += '		<div class="tit_wtym_tjda_anniu">';
			content += '			<input type="button" style="width:88px;cursor: pointer;" onclick="updateAnswer(\''+ANSWER_ID+'\');" class="bot_tjda" />';
			content += '		</div>';
			content += '		</div>';
		}else{
			$("#div_tjda").show();
		}
		content += '		</div>';
		content += '	</div>';
		content += '	<div class="tit_bot_wtym">';
		content += '		<a href="javascript:void(0);" onclick="showAnswerReview(\''+ANSWER_ID+'\', \''+REVIEW_COUNT+'\');"><span id="pl_'+ANSWER_ID+'">'+REVIEW_COUNT+'</span> 条评论</a>';
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
		content += '	<div id="div_pinglun_'+ANSWER_ID+'"></div>';
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
	
	$("#error_2").text(" ");
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
 * 修改回复
 * @param {Object} ANSWER_ID
 */
function updateAnswer(ANSWER_ID){
	var ANSWER_CONTENT = $.trim($("#ANSWER_CONTENT").val());
	if(ANSWER_CONTENT == ''){
		$("#error_2").text("回复内容不能为空。");
		return false;
	}
	
	$("#error_2").text(" ");
	$.post("updateProblemAnswer.go",{
		"ANSWER_ID": ANSWER_ID,
		"CONTENT": $("#ANSWER_CONTENT").val()
	},function(result){
		if(result==null||result==''){
			return;
		}
		
		$('#div_xgda').hide();
		$('#ANSWER_CONTENT_'+ANSWER_ID).text(ANSWER_CONTENT).show();
		$('#updateLink').show();
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
function showAnswerReview(ANSWER_ID, REVIEW_COUNT){
	var jqPinglun = $("#div_pinglun_" + ANSWER_ID);
	if(jqPinglun.text()==''){
		$.post("getAnswerReviewListByAnswerId.go",{
			"ANSWER_ID": ANSWER_ID,
			"reviewCount": REVIEW_COUNT
		},function(result){
			if(result==null||result==''){
				return;
			}
			
			$("#div_pinglun_" + ANSWER_ID).html(result).show();
		});
	}else{
		jqPinglun.show();
	}
}

/**
 * 给回复添加评论
 */
function addAnswerReview(ANSWER_ID){
	var CONTENT = $.trim($("#txt_pl_" + ANSWER_ID).val());
	if(CONTENT == ''){
		$("#pl_error_" + ANSWER_ID).text("请输入评论内容");
		$("#txt_pl_" + ANSWER_ID).focus();
		return;
	}
	
	$.post("addAnswerReview.go",{
		"ANSWER_ID": ANSWER_ID,
		"CONTENT": CONTENT
	},function(result){
		$("#pl_error_" + ANSWER_ID).text(" ");
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["REVIEW_ID"]>0){
			var d = new Date();
			var s = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
			var html = '<div class="hwbj">'+CONTENT+'</div>';
			html += '<div class="fg_2011">';
			html += '	<a href="'+path.user.detail+$("#loginUser_USER_ID").val()+'">'+$("#loginUser_NAME").val()+'</a>';
			html += '	• ' + s;
			html += '</div>';
			$("#txt_pl_" + ANSWER_ID).val("")
			$("#pl_list_" + ANSWER_ID).append(html);
		}else{
			show_showmessage({message:"添加评论失败。",type:"error"});
		}
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
		$("#WAS_USER_ID").val("").show();
		$("#div_USER").hide();
	});
}
