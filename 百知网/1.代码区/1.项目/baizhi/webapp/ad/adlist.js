var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#adlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var AD_ID = $("#AD_ID").val();
	var TITLE = $("#TITLE").val();
	var CONTENT = $("#CONTENT").val();
	var IMAGE = $("#IMAGE").val();
	var SHOW_TYPE = $("#SHOW_TYPE").val();
	var HREF = $("#HREF").val();
	var ORDER_BY = $("#ORDER_BY").val();
	var START_TIME = $("#START_TIME").val();
	var END_TIME = $("#END_TIME").val();
	var STATUS = $("#STATUS").val();
	var REMARK = $("#REMARK").val();
	$.post("getAdList.go",{
		AD_ID: window.encodeURI(AD_ID),
		TITLE: window.encodeURI(TITLE),
		CONTENT: window.encodeURI(CONTENT),
		IMAGE: window.encodeURI(IMAGE),
		SHOW_TYPE: window.encodeURI(SHOW_TYPE),
		HREF: window.encodeURI(HREF),
		ORDER_BY: window.encodeURI(ORDER_BY),
		START_TIME: window.encodeURI(START_TIME),
		END_TIME: window.encodeURI(END_TIME),
		STATUS: window.encodeURI(STATUS),
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
					var AD_ID = ""; //广告ID
					var TITLE = ""; //主题
					var CONTENT = ""; //内容(支持html内容)
					var IMAGE = ""; //图片
					var SHOW_TYPE = ""; //显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
					var HREF = ""; //链接地址
					var ORDER_BY = ""; //显示顺序
					var START_TIME = ""; //起始时间
					var END_TIME = ""; //终止时间
					var STATUS = ""; //状态(字典：1申请、2通过、3不通过)
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					AD_ID = data["list"][i]["AD_ID"];//广告ID
					TITLE = data["list"][i]["TITLE"];//主题
					CONTENT = data["list"][i]["CONTENT"];//内容(支持html内容)
					IMAGE = data["list"][i]["IMAGE"];//图片
					SHOW_TYPE = data["list"][i]["SHOW_TYPE"];//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
					HREF = data["list"][i]["HREF"];//链接地址
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					START_TIME = data["list"][i]["START_TIME"];//起始时间
					END_TIME = data["list"][i]["END_TIME"];//终止时间
					STATUS = data["list"][i]["STATUS"];//状态(字典：1申请、2通过、3不通过)
					REMARK = data["list"][i]["REMARK"];//备注
						
						var edithref = "getAdById.go?AD_ID="+AD_ID;
						content += "<tr id='adlist_tr'>";
						content += "  <td><input type='checkbox' value='"+AD_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+AD_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+AD_ID+"</td>";
						content += "  <td>"+TITLE+"</td>";
						content += "  <td>"+CONTENT+"</td>";
						content += "  <td>"+IMAGE+"</td>";
						content += "  <td>"+SHOW_TYPE+"</td>";
						content += "  <td>"+HREF+"</td>";
						content += "  <td>"+ORDER_BY+"</td>";
						content += "  <td>"+START_TIME+"</td>";
						content += "  <td>"+END_TIME+"</td>";
						content += "  <td>"+STATUS+"</td>";
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
		showmessage({message:"请选择广告信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delAd.go",{
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