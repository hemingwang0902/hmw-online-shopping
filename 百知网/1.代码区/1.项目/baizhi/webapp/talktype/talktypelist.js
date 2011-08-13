var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#talktypelist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var TYPE_NAME = $("#TYPE_NAME").val();
	$.post("getTalktypeList.go",{
		TYPE_NAME: TYPE_NAME,
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
					var TALKTYPE_ID = ""; //话题类型ID
					var TYPE_NAME = ""; //类型名称
					var REMARK = ""; //备注
					var TALK_COUNT="";
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						TALKTYPE_ID = data["list"][i]["TALKTYPE_ID"];//话题类型ID
						TYPE_NAME = data["list"][i]["TYPE_NAME"];//类型名称
						REMARK = data["list"][i]["REMARK"];//备注
						TALK_COUNT=data["list"][i]["TALK_COUNT"];
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getTalktypeById.go?TALKTYPE_ID="+TALKTYPE_ID;
						content += "<tr id='talktypelist_tr'>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='relationlist.jsp?TALKTYPE_ID="+TALKTYPE_ID+"' class='hc_btn' title='关联话题'/>";
						content += "    <a href='cancellist.jsp?TALKTYPE_ID="+TALKTYPE_ID+"' class='qx_btn' title='取消关联'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+TALKTYPE_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+TYPE_NAME+"</td>";
						content += "  <td>"+TALK_COUNT+"</td>";
						content += "  <td>"+REMARK+"</td>";
						content += "  <td>"+CREATE_TIME+"</td>";
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
		showmessage({message:"请选择话题类型表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delTalktype.go",{
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