var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#dicitemlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var DICITEM_ID = $("#DICITEM_ID").val();
	var CODE = $("#CODE").val();
	var DIC_CODE = $("#DIC_CODE").val();
	var DIC_NAME = $("#DIC_NAME").val();
	var PDIC_CODE = $("#PDIC_CODE").val();
	var ALLPIN = $("#ALLPIN").val();
	var SIMPLEPIN = $("#SIMPLEPIN").val();
	var ORDER_BY = $("#ORDER_BY").val();
	var REMARK = $("#REMARK").val();
	$.post("getDicitemList.go",{
		DICITEM_ID: window.encodeURI(DICITEM_ID),
		CODE: window.encodeURI(CODE),
		DIC_CODE: window.encodeURI(DIC_CODE),
		DIC_NAME: window.encodeURI(DIC_NAME),
		PDIC_CODE: window.encodeURI(PDIC_CODE),
		ALLPIN: window.encodeURI(ALLPIN),
		SIMPLEPIN: window.encodeURI(SIMPLEPIN),
		ORDER_BY: window.encodeURI(ORDER_BY),
		REMARK: window.encodeURI(REMARK),
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
					var DICITEM_ID = ""; //字典清单ID
					var CODE = ""; //列表字典代码
					var DIC_CODE = ""; //字典代码
					var DIC_NAME = ""; //字典名称
					var PDIC_CODE = ""; //字典上级代码
					var ALLPIN = ""; //字典全拼
					var SIMPLEPIN = ""; //字典简拼
					var ORDER_BY = ""; //显示顺序
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					DICITEM_ID = data["list"][i]["DICITEM_ID"];//字典清单ID
					CODE = data["list"][i]["CODE"];//列表字典代码
					DIC_CODE = data["list"][i]["DIC_CODE"];//字典代码
					DIC_NAME = data["list"][i]["DIC_NAME"];//字典名称
					PDIC_CODE = data["list"][i]["PDIC_CODE"];//字典上级代码
					ALLPIN = data["list"][i]["ALLPIN"];//字典全拼
					SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//字典简拼
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					REMARK = data["list"][i]["REMARK"];//备注
						
						var edithref = "getDicitemById.go?DICITEM_ID="+DICITEM_ID;
						content += "<tr id='dicitemlist_tr'>";
						content += "  <td><input type='checkbox' value='"+DICITEM_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+DICITEM_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+DICITEM_ID+"</td>";
						content += "  <td>"+CODE+"</td>";
						content += "  <td>"+DIC_CODE+"</td>";
						content += "  <td>"+DIC_NAME+"</td>";
						content += "  <td>"+PDIC_CODE+"</td>";
						content += "  <td>"+ALLPIN+"</td>";
						content += "  <td>"+SIMPLEPIN+"</td>";
						content += "  <td>"+ORDER_BY+"</td>";
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
		showmessage({message:"请选择字典列表清单",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delDicitem.go",{
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