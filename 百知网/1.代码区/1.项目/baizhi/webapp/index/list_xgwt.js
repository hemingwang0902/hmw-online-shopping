$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
	getMayInterestedUserList();
	getAttentionBrandList(0);
	
	//初始化 ZeroClipboard
	initZeroClipboard(); 
});

/**
 * 更多
 */
function getMoreProblemList(){
	getProblemList(path.problem.nearList+$("#problemId").val(), true);
}