var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#talklist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var CONTENT = $("#CONTENT").val();
	var USER_ID = $("#USER_ID").val();
	$.post("getTalkList.go",{
		CONTENT: CONTENT,
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
					var TALK_ID = ""; //话题ID
					var CONTENT = ""; //内容
					var NAME = ""; //用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						TALK_ID = data["list"][i]["TALK_ID"];//话题ID
						CONTENT = data["list"][i]["CONTENT"];//内容
						NAME = data["list"][i]["NAME"];//用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						if(MODIFY_TIME==null||MODIFY_TIME==""){
							MODIFY_TIME="&nbsp;";
						}
						
						var edithref = "getTalkById.go?TALK_ID="+TALK_ID;
						content += "<tr id='talklist_tr'>";
						content += "  <td><input type='checkbox' value='"+TALK_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+TALK_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+CONTENT+"</td>";
						content += "  <td>"+NAME+"</td>";
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
		showmessage({message:"请选择话题信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delTalk.go",{
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