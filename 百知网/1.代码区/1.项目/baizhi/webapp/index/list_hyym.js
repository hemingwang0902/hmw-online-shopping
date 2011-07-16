$(document).ready(function(){
	//获取数据列表
	getWenProblemList();
	getAttentionBrandList($("#userId").val());
	
	$("#txt_userName").focus(function(){
		if($.trim($(this).val()) == '请输入会员姓名'){
			$(this).val('');
		}
	}).blur(function(){
		if($.trim($(this).val()) == ''){
			$(this).val('请输入会员姓名');
		}
	});
});

/**
 * 他问过的问题
 */
function getWenProblemList(){
	$('#problemType').val('wen');
	$('#nowPage').val(1);
	getProblemList(path.problem.listByUserId+$("#userId").val(), false);	
	$(".tit_hyym_twwt a").removeClass("checked");
	$(this).addClass("checked");
}

/**
 * 他回答的问题
 */
function getDaProblemList(){
	$('#problemType').val('da');
	$('#nowPage').val(1);
	getProblemList(path.problem.answeredList+$("#userId").val(), false);	
	$(".tit_hyym_twwt a").removeClass("checked");
	$(this).addClass("checked");
}

/**
 * 更多
 */
function getMoreProblemList(){
	var action = ($('#problemType').val() == 'wen') ? (path.problem.listByUserId+$("#userId").val()) : (path.problem.answeredList+$("#userId").val());
	getProblemList(action, true);
}

/**
 * 提问
 */
function addProblem(){
	var CONTENT = $.trim($("#CONTENT").val());
	if(CONTENT != ''){
		$.post("../problem/saveProblemByAjax.go",{
			PROBLEM_TYPE: "1", 
			CONTENT: CONTENT,
			WAS_USERID: $("#userId").val(),
			isAjax: true
		}, function(result){
			if(result==null||result==''){
				showmessage({message:"添加问题失败！",type:"error"});
			}
			var data = eval("("+result+")");
			var content = "";
			if (data != null && data["id"] != null && data["id"].length > 0) {
				showmessage({message:"添加问题成功",type:"info"});
				$("#CONTENT").val("")
			}else{
				showmessage({message:"添加问题失败！",type:"error"});
			}
		});
	}		
}

/**
 * 添加(取消)关注会员
 * @param isDisAttention 为 true 表示取消关注
 */
function attentionUser(){
	var isDisAttention = $(this).attr("isDisAttention");
	$.post("attentionUser.go",{
		"WAS_USER_ID": $("#userId").val(),
		"isDisAttention": isDisAttention
	}, function(result){
		if(isDisAttention){
			$(this).attr("isDisAttention", false).html("添加关注");
		}else{
			$(this).attr("isDisAttention", true).html("取消关注");
		}
	});
}

/**
 * 提交“搜索会员”的表单前的校验
 */
function beforeSearchUser(){
	var userName = $.trim($("#txt_userName").val());
	return (userName != '请输入会员姓名' && userName !='');
}

/**
 * 添加(取消)关注话题
 * @param isDisAttention 为 true 表示取消关注
 */
function attentionTalk(TALK_ID){
	var isDisAttention = $(this).attr("isDisAttention");
	$.post("attentionTalk.go",{
		"TALK_ID": TALK_ID,
		"isDisAttention": isDisAttention
	}, function(result){
		if(isDisAttention){
			$(this).attr("isDisAttention", false).html("关&nbsp;注");
		}else{
			$(this).attr("isDisAttention", true).html("取&nbsp;消");
		}
	});
}