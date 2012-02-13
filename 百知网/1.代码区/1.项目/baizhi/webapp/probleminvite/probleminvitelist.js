var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#probleminvitelist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var INVITE_ID = $("#INVITE_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var IS_ATTENTION = $("#IS_ATTENTION").val();
	var USER_ID = $("#USER_ID").val();
	var WAS_USER_ID = $("#WAS_USER_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getProblemInviteList.go",{
		INVITE_ID: window.encodeURI(INVITE_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		IS_ATTENTION: window.encodeURI(IS_ATTENTION),
		USER_ID: window.encodeURI(USER_ID),
		WAS_USER_ID: window.encodeURI(WAS_USER_ID),
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
					var INVITE_ID = ""; //问题邀请人ID
					var PROBLEM_ID = ""; //问题ID
					var IS_ATTENTION = ""; //是否回答(0否、1是)
					var USER_ID = ""; //用户ID
					var WAS_USER_ID = ""; //被邀请的用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						INVITE_ID = data["list"][i]["INVITE_ID"];//问题邀请人ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						IS_ATTENTION = data["list"][i]["IS_ATTENTION"];//是否回答(0否、1是)
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						WAS_USER_ID = data["list"][i]["WAS_USER_ID"];//被邀请的用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemInviteById.go?INVITE_ID="+INVITE_ID;
						content += "<tr id='probleminvitelist_tr'>";
						content += "  <td><input type='checkbox' value='"+INVITE_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+INVITE_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+INVITE_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+IS_ATTENTION+"</td>";
						content += "  <td>"+USER_ID+"</td>";
						content += "  <td>"+WAS_USER_ID+"</td>";
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
		showmessage({message:"请选择问题邀请人信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delProblemInvite.go",{
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