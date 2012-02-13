var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#answervotelist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var VOTE_ID = $("#VOTE_ID").val();
	var ANSWER_ID = $("#ANSWER_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var VOTE_TYPE = $("#VOTE_TYPE").val();
	var IS_AGREE = $("#IS_AGREE").val();
	var USER_ID = $("#USER_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getAnswerVoteList.go",{
		VOTE_ID: window.encodeURI(VOTE_ID),
		ANSWER_ID: window.encodeURI(ANSWER_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		VOTE_TYPE: window.encodeURI(VOTE_TYPE),
		IS_AGREE: window.encodeURI(IS_AGREE),
		USER_ID: window.encodeURI(USER_ID),
		CREATE_TIME: window.encodeURI(CREATE_TIME),
		MODIFY_TIME: window.encodeURI(MODIFY_TIME),
		nowPage: nowPage,
		onePageCount: onePageCount},
		function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				var content = "";
				if (data != null && data["list"] != null && data["list"].length > 0) {
					if(nowPage==1){
						count=data["totalCount"] ;
					}
					var VOTE_ID = ""; //问题答案投票ID
					var ANSWER_ID = ""; //问题答案ID
					var PROBLEM_ID = ""; //问题ID(冗余字段)
					var VOTE_TYPE = ""; //投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
					var IS_AGREE = ""; //是否赞成、感谢(0否、1是)
					var USER_ID = ""; //用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						VOTE_ID = data["list"][i]["VOTE_ID"];//问题答案投票ID
						ANSWER_ID = data["list"][i]["ANSWER_ID"];//问题答案ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID(冗余字段)
						VOTE_TYPE = data["list"][i]["VOTE_TYPE"];//投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
						IS_AGREE = data["list"][i]["IS_AGREE"];//是否赞成、感谢(0否、1是)
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getAnswerVoteById.go?VOTE_ID="+VOTE_ID;
						content += "<tr id='answervotelist_tr'>";
						content += "  <td><input type='checkbox' value='"+VOTE_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+VOTE_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+VOTE_ID+"</td>";
						content += "  <td>"+ANSWER_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+VOTE_TYPE+"</td>";
						content += "  <td>"+IS_AGREE+"</td>";
						content += "  <td>"+USER_ID+"</td>";
						content += "  <td>"+CREATE_TIME+"</td>";
						content += "  <td>"+MODIFY_TIME+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}

/* 删除数据*/
function delData(ids){
	if(ids==null||ids==''){
		showmessage({message:"请选择问题答案投票信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delAnswerVote.go",{
				IDS:ids
			},function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				if(data!=null&&data["flag"]==true){
					$("#nowPage").val(1);
					//查询
					getDataList();
				}else{
					showmessage({message:data["message"],type:"error"});
				}
			});
		}
	}});
	return;
}

$(document).ready(function(){
	//获取数据列表
	getDataList();
});  