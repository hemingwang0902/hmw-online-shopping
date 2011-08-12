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
	
	//“添加品牌”按钮的单击事件
	$("#btnShowAddBrand").toggle(function () {
    	$("#divAddBrand").show();
  	}, function () {
    	$("#divAddBrand").hide();
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
	
	//给问题添加品牌时，根据输入的内容自动提示
	$("#BRAND_ID").keyup(function(eve){
		if(eve.which ==13){
			changBrandIds();
		}
	}).focus(changBrandIds).autocomplete("getUserBrandByName.go", {
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
							value: row.BRAND_ID+","+row.NAME,
							result: row.BRAND_ID+","+row.NAME
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
	}).focus(changUserIds).autocomplete("getUserListByName.go", {
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
	
	//删除已选择的人员（邀请他人回答）
	$("#DEL_USER").click(function(){
		$("#div_USER").hide();
		$("#WAS_USER_ID").val("").show();
	});
	
	//删除已选择的品牌（给问题添加品牌）
	$("#DEL_BRAND").click(function(){
		$("#div_BRAND").hide();
		$("#BRAND_ID").val("").show();
	});
});

function changUserIds(){
	var v = $("#WAS_USER_ID").val().split(",");
	if(v.length == 2){
		$("#WAS_USER_ID").hide().val(v[0]);
		$("#USER_NAME").text(v[1]);
		$("#div_USER").show();
	}else{
		$("#WAS_USER_ID").val("");
	}
}

function changBrandIds(){
	var v = $("#BRAND_ID").val().split(",");
	if(v.length == 2){
		$("#BRAND_ID").hide().val(v[0]);
		$("#BRAND_NAME").text(v[1]);
		$("#div_BRAND").show();
	}else{
		$("#BRAND_ID").val("");
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
			dispalyAnswerTextarea(true, null);
			return;
		}
		
		var data = eval("("+result+")");
		if (data != null && data["list"] != null && data["list"].length > 0) {
			_showAnswer(data["list"]);
		}else{
			dispalyAnswerTextarea(true, null);
		}
		
		if(data["list"].length < onePageCount){
			$(".tiao").html("<span>更多 &gt;&gt;</span>");
		} else{ //查询到的记录条数为空,禁用"更多"
			$(".tiao").html('<a href="javascript:void(0);" onclick="getProblemAnswerList();">更多 &gt;&gt;</a>');
		}
	});	
}

/**
 * 显示添加回复的文本框
 * @param {Object} isAdd 是否为添加回复（如果已经回答过了，则只能修改）
 */
function dispalyAnswerTextarea(isAdd){
	if(isAdd){
		$("#div_tjda").show();
	}else{
		$("#div_tjda").remove();
	}
	
	if (CKEDITOR.instances['ANSWER_CONTENT']) {
		 // with or without this line of code - rise an error. Uncaught [CKEDITOR.editor] The instance "ANSWER_CONTENT" already exists.
		CKEDITOR.remove(CKEDITOR.instances['ANSWER_CONTENT']);
	}
	CKEDITOR.replace('ANSWER_CONTENT', {"toolbar":"Answer","width":"550"});
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
	
	//当前登录的用户没有回答过这个问题
	if($("#div_xgda").length == 0){
		dispalyAnswerTextarea(true);
	}else{
		dispalyAnswerTextarea(false);
	}
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
	$("#div_xght a").each(function(i, domEle){
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
				$("#div_xght").append('<a href="initHtym.go?TALK_ID='+data["TALK_ID"]+'" style="margin-right: 5px;">'+TALK_CONTENT+'</a>');
			}else{
				show_showmessage({message:"添加话题失败。",type:"error"});
			}
		});
	}
}

/**
 * 给问题添加品牌
 */
function addBrand(){
	var BRAND_ID = $.trim($("#BRAND_ID").val());
	if(BRAND_ID == ''){
		$("#error_5").text("请选择需要关联的品牌。");
		return false;
	}
	
	if($("#div_xgpp a[BRAND_ID='"+BRAND_ID+"']").length > 0){
		$("#error_5").text("该问题已经添加了该品牌“");
		return false;
	}

	$("#error_5").text(" ");
	$.post("addBrandForProblem.go",{
		PROBLEM_ID: $("#problemId").val(),
		BRAND_ID: BRAND_ID
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null && data["flag"]){
			$("#BRAND_ID").val("").show();
			$("#divAddBrand,#div_BRAND").hide();
			$("#div_xgpp").append('<a href="'+path.brand.detail+BRAND_ID+'" style="margin-right: 5px;">'+$("#BRAND_NAME").text()+'</a>');
		}else{
			show_showmessage({message:"添加品牌失败。",type:"error"});
		}
	});
}

/**
 * 添加回复
 */
function addAnswer(){
//	var ANSWER_CONTENT = $.trim($("#ANSWER_CONTENT").val());
	var ANSWER_CONTENT = $.trim(CKEDITOR.instances.ANSWER_CONTENT.getData());
		
	if(!$.trim($(ANSWER_CONTENT).html().replace(/&nbsp;/g, ""))){
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
			//$("#ANSWER_CONTENT").val("");
			//$("#div_tjda").remove();
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
	//var ANSWER_CONTENT = $.trim($("#ANSWER_CONTENT").val());
	var ANSWER_CONTENT = $.trim(CKEDITOR.instances.ANSWER_CONTENT.getData());
		
	if(ANSWER_CONTENT == $.trim($(ANSWER_CONTENT).html())){
		$("#error_2").text("回复内容不能为空。");
		return false;
	}
	
	$("#error_2").text(" ");
	$.post("updateProblemAnswer.go",{
		"ANSWER_ID": ANSWER_ID,
		"CONTENT": ANSWER_CONTENT
	},function(result){
		if(result==null||result==''){
			return;
		}
		
		$('#div_xgda').hide();
		$('#ANSWER_CONTENT_'+ANSWER_ID).html(ANSWER_CONTENT).show();
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

/**
 * 修改问题标题
 */
function updateProblemContent(){
	var CONTENT = $.trim($("#PROBLEM_CONTENT").val());
	if(CONTENT == ''){
		$("#error_3").text("问题不能为空");
		$("#PROBLEM_CONTENT").focus();
		return;
	}
	
	$("#error_3").text(" ");
	$.post("updateProblem.go",{
		"PROBLEM_ID": $("#problemId").val(),
		"CONTENT": CONTENT
	},function(){
		$("#span_problem_content").text(CONTENT);
		$("#div_problem_content_0").show();
		$("#div_problem_content_1").hide();
	});
}

/**
 * 修改问题细节
 */
function updateProblemDetail(){
	var RELEVANT_DETAILS = $.trim($("#PROBLEM_RELEVANT_DETAILS").val());
	if(RELEVANT_DETAILS == ''){
		$("#error_4").text("细节不能为空");
		$("#PROBLEM_RELEVANT_DETAILS").focus();
		return;
	}
	
	$("#error_4").text(" ");
	$.post("updateProblem.go",{
		"PROBLEM_ID": $("#problemId").val(),
		"RELEVANT_DETAILS": RELEVANT_DETAILS
	},function(){
		$("#span_problem_DETAILS_0").text(RELEVANT_DETAILS);
		$("#div_problem_DETAILS_0").show();
		$("#div_problem_DETAILS_1").hide();
	});
}
