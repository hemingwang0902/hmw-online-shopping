var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#arealist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var DIC_CODE = $("#DIC_CODE").val();
	var DIC_NAME = $("#DIC_NAME").val();
	var PAREA_ID = $("#PAREA_ID").val();
	var ALLPIN = $("#ALLPIN").val();
	var SIMPLEPIN = $("#SIMPLEPIN").val();
	$.post("getAreaList.go",{
		DIC_CODE: window.encodeURI(DIC_CODE),
		DIC_NAME: window.encodeURI(DIC_NAME),
		PAREA_ID: window.encodeURI(PAREA_ID),
		ALLPIN: window.encodeURI(ALLPIN),
		SIMPLEPIN: window.encodeURI(SIMPLEPIN),
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
					var AREA_ID = ""; //地区ID
					var DIC_CODE = ""; //地区代码(根据级别制定规则定义)
					var DIC_NAME = ""; //地区名称
					var ALLPIN = ""; //地区全拼
					var SIMPLEPIN = ""; //地区简拼
					var ORDER_BY = ""; //显示顺序
					var IP_START = ""; //IP起始段
					var IP_END = ""; //IP终止段
					var AREA_LEVEL = ""; //地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					AREA_ID = data["list"][i]["AREA_ID"];//地区ID
					DIC_CODE = data["list"][i]["DIC_CODE"];//地区代码(根据级别制定规则定义)
					DIC_NAME = data["list"][i]["DIC_NAME"];//地区名称
					ALLPIN = data["list"][i]["ALLPIN"];//地区全拼
					SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//地区简拼
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					REMARK = data["list"][i]["REMARK"];//备注
						
						var edithref = "getAreaById.go?AREA_ID="+AREA_ID;
						content += "<tr id='arealist_tr'>";
						content += "  <td><input type='checkbox' value='"+AREA_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+AREA_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+DIC_NAME+"</td>";
						content += "  <td>"+DIC_CODE+"</td>";
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
		showmessage({message:"请选择要删除的城市",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delArea.go",{
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