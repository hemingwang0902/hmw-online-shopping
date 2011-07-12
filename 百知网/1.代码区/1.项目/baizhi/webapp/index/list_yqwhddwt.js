$(document).ready(function(){
	//获取数据列表
	getMoreProblemList();
	getMayInterestedUserList();
	getAttentionUserList();
	
	//初始化 ZeroClipboard
	initZeroClipboard(); 
});

/**
 * 更多
 */
function getMoreProblemList(){
	getProblemList(path.problem.inviteList, true);
}