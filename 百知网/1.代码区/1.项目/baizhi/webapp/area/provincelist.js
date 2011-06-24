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
	var ALLPIN = $("#ALLPIN").val();
	var SIMPLEPIN = $("#SIMPLEPIN").val();
	$.post("getAreaList.go",{
		DIC_CODE: window.encodeURI(DIC_CODE),
		DIC_NAME: window.encodeURI(DIC_NAME),
		ALLPIN: window.encodeURI(ALLPIN),
		SIMPLEPIN: window.encodeURI(SIMPLEPIN),
		AREA_LEVEL: "1",
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
					var AREA_ID = ""; //省份ID
					var DIC_CODE = ""; //省份代码(根据级别制定规则定义)
					var DIC_NAME = ""; //省份名称
					var ALLPIN = ""; //省份全拼
					var SIMPLEPIN = ""; //省份简拼
					var ORDER_BY = ""; //显示顺序
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					AREA_ID = data["list"][i]["AREA_ID"];//省份ID
					DIC_CODE = data["list"][i]["DIC_CODE"];//省份代码(根据级别制定规则定义)
					DIC_NAME = data["list"][i]["DIC_NAME"];//省份名称
					ALLPIN = data["list"][i]["ALLPIN"];//省份全拼
					SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//省份简拼
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					REMARK = data["list"][i]["REMARK"];//备注
						
						var edithref = "getAreaById.go?AREA_ID="+AREA_ID;
						content += "<tr id='arealist_tr'>";
						content += "  <td><input type='checkbox' value='"+AREA_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+AREA_ID+"')\"/>";
						content += "  </td>";
						//content += "  <td><a href='citylist.jsp?PAREA_ID=" + AREA_ID + "'>"+DIC_NAME+"</a></td>";
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
		showmessage({message:"请选择要删除的省份",type:"info"});
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