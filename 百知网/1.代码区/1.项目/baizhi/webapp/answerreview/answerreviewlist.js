var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#answerreviewlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var REVIEW_ID = $("#REVIEW_ID").val();
	var ANSWER_ID = $("#ANSWER_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var CONTENT = $("#CONTENT").val();
	var PREVIEW_ID = $("#PREVIEW_ID").val();
	var USER_ID = $("#USER_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getAnswerReviewList.go",{
		REVIEW_ID: window.encodeURI(REVIEW_ID),
		ANSWER_ID: window.encodeURI(ANSWER_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		CONTENT: window.encodeURI(CONTENT),
		PREVIEW_ID: window.encodeURI(PREVIEW_ID),
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
					var REVIEW_ID = ""; //问题答案评论ID
					var ANSWER_ID = ""; //问题答案ID
					var PROBLEM_ID = ""; //问题ID(冗余字段)
					var CONTENT = ""; //内容
					var PREVIEW_ID = ""; //问题答案评论ID父ID
					var USER_ID = ""; //用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						REVIEW_ID = data["list"][i]["REVIEW_ID"];//问题答案评论ID
						ANSWER_ID = data["list"][i]["ANSWER_ID"];//问题答案ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID(冗余字段)
						CONTENT = data["list"][i]["CONTENT"];//内容
						PREVIEW_ID = data["list"][i]["PREVIEW_ID"];//问题答案评论ID父ID
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getAnswerReviewById.go?REVIEW_ID="+REVIEW_ID;
						content += "<tr id='answerreviewlist_tr'>";
						content += "  <td><input type='checkbox' value='"+REVIEW_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+REVIEW_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+REVIEW_ID+"</td>";
						content += "  <td>"+ANSWER_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+CONTENT+"</td>";
						content += "  <td>"+PREVIEW_ID+"</td>";
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
		showmessage({message:"请选择问题答案评论信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delAnswerReview.go",{
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