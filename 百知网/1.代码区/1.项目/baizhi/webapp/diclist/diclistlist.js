var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#diclistlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var NAME = $("#NAME").val();
	var CODE = $("#CODE").val();
	var ALLPIN = $("#ALLPIN").val();
	var SIMPLEPIN = $("#SIMPLEPIN").val();
	$.post("getDiclistList.go",{
		NAME: NAME,
		CODE: CODE,
		ALLPIN: ALLPIN,
		SIMPLEPIN: SIMPLEPIN,
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
					var DICLIST_ID = ""; //字典列表ID
					var NAME = ""; //字典名称
					var CODE = ""; //字典代码
					var ALLPIN = ""; //字典全拼
					var SIMPLEPIN = ""; //字典简拼
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
						DICLIST_ID = data["list"][i]["DICLIST_ID"];//字典列表ID
						NAME = data["list"][i]["NAME"];//字典名称
						CODE = data["list"][i]["CODE"];//字典代码
						ALLPIN = data["list"][i]["ALLPIN"];//字典全拼
						SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//字典简拼
						REMARK = data["list"][i]["REMARK"];//备注
						
						if(REMARK==null||REMARK==""){
							REMARK="&nbsp;";
						}
						
						var edithref = "getDiclistById.go?DICLIST_ID="+DICLIST_ID;
						content += "<tr id='diclistlist_tr'>";
						content += "  <td><input type='checkbox' value='"+DICLIST_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+DICLIST_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+CODE+"</td>";
						content += "  <td>"+ALLPIN+"</td>";
						content += "  <td>"+SIMPLEPIN+"</td>";
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
		showmessage({message:"请选择字典列表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delDiclist.go",{
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