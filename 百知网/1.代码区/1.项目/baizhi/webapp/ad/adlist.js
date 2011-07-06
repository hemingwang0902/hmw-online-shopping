var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#adlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var TITLE = $("#TITLE").val();
	var SHOW_TYPE = $("#SHOW_TYPE").val();
	var START_TIME = $("#START_TIME").val();
	var END_TIME = $("#END_TIME").val();
	var STATUS = $("#STATUS").val();
	$.post("getAdList.go",{
		TITLE: window.encodeURI(TITLE),
		SHOW_TYPE: window.encodeURI(SHOW_TYPE),
		START_TIME: window.encodeURI(START_TIME),
		END_TIME: window.encodeURI(END_TIME),
		STATUS: window.encodeURI(STATUS),
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
					var SHOW_TYPE = ""; //显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
					var START_TIME = ""; //起始时间
					var END_TIME = ""; //终止时间
					var STATUS = ""; //状态(字典：1申请、2通过、3不通过)
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					AD_ID = data["list"][i]["AD_ID"];//广告ID
					TITLE = data["list"][i]["TITLE"];//主题
					SHOW_TYPE = data["list"][i]["SHOW_TYPE"];//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
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
						content += "  <td>"+TITLE+"</td>";
						content += "  <td>"+SHOW_TYPE+"</td>";
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