var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#problemanswerlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var ANSWER_ID = $("#ANSWER_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var CONTENT = $("#CONTENT").val();
	var USER_ID = $("#USER_ID").val();
	var AGREE_COUNT = $("#AGREE_COUNT").val();
	var DISAGREE_COUNT = $("#DISAGREE_COUNT").val();
	var THANK_COUNT = $("#THANK_COUNT").val();
	var DISTHANK_COUNT = $("#DISTHANK_COUNT").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getProblemAnswerList.go",{
		ANSWER_ID: window.encodeURI(ANSWER_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		CONTENT: window.encodeURI(CONTENT),
		USER_ID: window.encodeURI(USER_ID),
		AGREE_COUNT: window.encodeURI(AGREE_COUNT),
		DISAGREE_COUNT: window.encodeURI(DISAGREE_COUNT),
		THANK_COUNT: window.encodeURI(THANK_COUNT),
		DISTHANK_COUNT: window.encodeURI(DISTHANK_COUNT),
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
					var ANSWER_ID = ""; //问题答案ID
					var PROBLEM_ID = ""; //问题ID
					var CONTENT = ""; //内容
					var USER_ID = ""; //用户ID
					var AGREE_COUNT = ""; //赞成数量
					var DISAGREE_COUNT = ""; //反对数量
					var THANK_COUNT = ""; //感觉作者数量
					var DISTHANK_COUNT = ""; //没有帮助数量
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						ANSWER_ID = data["list"][i]["ANSWER_ID"];//问题答案ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						CONTENT = data["list"][i]["CONTENT"];//内容
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						AGREE_COUNT = data["list"][i]["AGREE_COUNT"];//赞成数量
						DISAGREE_COUNT = data["list"][i]["DISAGREE_COUNT"];//反对数量
						THANK_COUNT = data["list"][i]["THANK_COUNT"];//感觉作者数量
						DISTHANK_COUNT = data["list"][i]["DISTHANK_COUNT"];//没有帮助数量
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemAnswerById.go?ANSWER_ID="+ANSWER_ID;
						content += "<tr id='problemanswerlist_tr'>";
						content += "  <td><input type='checkbox' value='"+ANSWER_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+ANSWER_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+ANSWER_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+CONTENT+"</td>";
						content += "  <td>"+USER_ID+"</td>";
						content += "  <td>"+AGREE_COUNT+"</td>";
						content += "  <td>"+DISAGREE_COUNT+"</td>";
						content += "  <td>"+THANK_COUNT+"</td>";
						content += "  <td>"+DISTHANK_COUNT+"</td>";
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
		showmessage({message:"请选择问题答案信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delProblemAnswer.go",{
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