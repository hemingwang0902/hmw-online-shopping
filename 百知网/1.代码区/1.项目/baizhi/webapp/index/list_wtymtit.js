$(document).ready(function(){
	//获取问题回答列表
	getProblemAnswerList();
	
	//添加关注
	$("#a_attention").one("click", function(){
		$.get(path.problem.attention + $("#problemId").val(), function(){
			$(this).parent().css({"background-color":"#555555"});
		});
	}); 

	//添加收藏
	$("#a_collection").one("click", function(){
		$.get(path.problem.collection + $("#problemId").val(), function(){
			$(this).parent().css({"background-color":"#555555"});
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
			"onePageCount": 10
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
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
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
			for(var i=0;i<data["list"].length;i++){
				ANSWER_ID = data["list"][i]["ANSWER_ID"];
				PROBLEM_ID = data["list"][i]["PROBLEM_ID"];
				CONTENT = data["list"][i]["CONTENT"];
				USER_ID = data["list"][i]["USER_ID"];//用户ID
				AGREE_COUNT = data["list"][i]["AGREE_COUNT"];
				DISAGREE_COUNT = data["list"][i]["DISAGREE_COUNT"];
				THANK_COUNT = data["list"][i]["THANK_COUNT"];
				DISTHANK_COUNT = data["list"][i]["DISTHANK_COUNT"];
				REVIEW_COUNT = data["list"][i]["REVIEW_COUNT"];
				CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
				MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间

				content += '<div style=" margin-top:15px;">';
				content += '	<div class="title_wtym">';
				content += '		<div class="title_wtym_con">'+CONTENT+'</div>';
				content += '	</div>';
				content += '	<div class="tit_bot_wtym">';
				content += '		<a href="javascript:void(0);">'+REVIEW_COUNT+' 条评论</a>';
				content += '		 • <a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Thank\');">感谢作者</a>';
				content += '		 • <a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Disthank\');">没有帮助</a>';
				content += '		 • <a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'Agree\');">赞同</a>';
				content += '		 • <a href="javascript:void(0);" onclick="answerVote('+ANSWER_ID+', \'DisAgree\');">反对</a>';
				content += '	</div>';
				content += '	<div class="clear"></div>';
				content += '</div>';
			
			}
			$("#problemList").append(content);
		}
		
		if(data["list"].length < onePageCount){
			$(".tiao").html("<span>更多 &gt;&gt;</span>");
		} else{ //查询到的记录条数为空,禁用"更多"
			$(".tiao").html('<a href="javascript:void(0);" onclick="getProblemAnswerList();">更多 &gt;&gt;</a>');
		}
	});	
}

/**
 * 给问题添加话题
 */
function addTalk(){
	var TALK_CONTENT = $.trim($("#TALK_CONTENT").val());
	if(TALK_CONTENT == ''){
		return false;
	}
	
	$.post("addTalkForProblem.go",{
		PROBLEM_ID: $("#problemId").val(),
		CONTENT: TALK_CONTENT
	},function(){
		$("#TALK_CONTENT").val("");
		// TODO 显示到页面
	});
	
}

/**
 * 添加回复
 */
function addAnswer(){
	var ANSWER_CONTENT = $.trim($("#ANSWER_CONTENT").val());
	if(ANSWER_CONTENT == ''){
		return false;
	}
	
	$.post("saveProblemAnswer.go",{
		problemId: $("#problemId").val(),
		CONTENT: ANSWER_CONTENT
	},function(){
		// TODO 显示到页面
	});
}

/**
 * 对回复进行操作：赞同、反对、感谢作者、对我没帮助
 */
function answerVote(ANSWER_ID, voteField){
	$.post("answerVote.go",{
		"ANSWER_ID": ANSWER_ID,
		"voteField": voteField
	},function(){
		// TODO 更新页面展示
	});
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
		// TODO 更新页面展示
	});
}
