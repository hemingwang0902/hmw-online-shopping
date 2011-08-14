var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#scorelevellist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var NAME = $("#NAME").val();
	$.post("getScoreLevelList.go",{
		NAME:NAME,
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
					var SCORELEVEL_ID = ""; //积分级别ID
					var NAME = ""; //级别名称
					var SOCRE_UP = ""; //积分上限
					var SOCRE_DOWN = ""; //积分下限
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
						SCORELEVEL_ID = data["list"][i]["SCORELEVEL_ID"];//积分级别ID
						NAME = data["list"][i]["NAME"];//级别名称
						SOCRE_UP = data["list"][i]["SOCRE_UP"];//积分上限
						SOCRE_DOWN = data["list"][i]["SOCRE_DOWN"];//积分下限
						REMARK = data["list"][i]["REMARK"];//备注
						
						if(REMARK==null||REMARK==""){
							REMARK="&nbsp;";
						}
							
						var edithref = "getScoreLevelById.go?SCORELEVEL_ID="+SCORELEVEL_ID;
						content += "<tr id='scorelevellist_tr'>";
						content += "  <td><input type='checkbox' value='"+SCORELEVEL_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+SCORELEVEL_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+SOCRE_DOWN+"</td>";
						content += "  <td>"+SOCRE_UP+"</td>";
						content += "  <td>"+REMARK+"</td>";
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
		showmessage({message:"请选择积分级别信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delScoreLevel.go",{
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