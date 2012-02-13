var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#problemtalklist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var PROBLEMTALK_ID = $("#PROBLEMTALK_ID").val();
	var TALK_ID = $("#TALK_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getProblemTalkList.go",{
		PROBLEMTALK_ID: window.encodeURI(PROBLEMTALK_ID),
		TALK_ID: window.encodeURI(TALK_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
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
					var PROBLEMTALK_ID = ""; //问题话题ID
					var TALK_ID = ""; //话题ID
					var PROBLEM_ID = ""; //问题ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						PROBLEMTALK_ID = data["list"][i]["PROBLEMTALK_ID"];//问题话题ID
						TALK_ID = data["list"][i]["TALK_ID"];//话题ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemTalkById.go?PROBLEMTALK_ID="+PROBLEMTALK_ID;
						content += "<tr id='problemtalklist_tr'>";
						content += "  <td><input type='checkbox' value='"+PROBLEMTALK_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+PROBLEMTALK_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+PROBLEMTALK_ID+"</td>";
						content += "  <td>"+TALK_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
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
		showmessage({message:"请选择问题话题信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delProblemTalk.go",{
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