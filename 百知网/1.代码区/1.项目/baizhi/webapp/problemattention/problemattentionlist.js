var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#problemattentionlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var ATTENTION_ID = $("#ATTENTION_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var IS_ATTENTION = $("#IS_ATTENTION").val();
	var USER_ID = $("#USER_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getProblemAttentionList.go",{
		ATTENTION_ID: window.encodeURI(ATTENTION_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		IS_ATTENTION: window.encodeURI(IS_ATTENTION),
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
					var ATTENTION_ID = ""; //问题关注ID
					var PROBLEM_ID = ""; //问题ID
					var IS_ATTENTION = ""; //是否关注(0否、1是)
					var USER_ID = ""; //用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						ATTENTION_ID = data["list"][i]["ATTENTION_ID"];//问题关注ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						IS_ATTENTION = data["list"][i]["IS_ATTENTION"];//是否关注(0否、1是)
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemAttentionById.go?ATTENTION_ID="+ATTENTION_ID;
						content += "<tr id='problemattentionlist_tr'>";
						content += "  <td><input type='checkbox' value='"+ATTENTION_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+ATTENTION_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+ATTENTION_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+IS_ATTENTION+"</td>";
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
		showmessage({message:"请选择问题关注信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delProblemAttention.go",{
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