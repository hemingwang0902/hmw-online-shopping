$(document).ready(function(){
	//获取数据列表
	getLastestProblemList();
	getMayInterestedUserList();
	getAttentionUserList();
	
	//初始化 ZeroClipboard
	initZeroClipboard(); 
});


/**
 * 最新问题
 */
function getLastestProblemList(){
	$('#problemType').val('zui');
	$('#nowPage').val(1);
	getProblemList(path.problem.lastest, false);	
	$(".subMenu a").removeClass("checked");
	$(".zui>a").addClass("checked");
}

/**
 * 热门问题
 */
function getHottestProblemList(){
	$('#problemType').val('re');
	$('#nowPage').val(1);
	getProblemList(path.problem.hottest, false);	
	$(".subMenu a").removeClass("checked");
	$(".re>a").addClass("checked");
}

/**
 * 更多
 */
function getMoreProblemList(){
	var action = ($('#problemType').val() == 'zui') ? path.problem.lastest : path.problem.hottest;
	getProblemList(action, true);
}