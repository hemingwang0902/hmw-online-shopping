var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#problemcollectionlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var COLLECTION_ID = $("#COLLECTION_ID").val();
	var PROBLEM_ID = $("#PROBLEM_ID").val();
	var IS_COLLECTION = $("#IS_COLLECTION").val();
	var USER_ID = $("#USER_ID").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getProblemCollectionList.go",{
		COLLECTION_ID: window.encodeURI(COLLECTION_ID),
		PROBLEM_ID: window.encodeURI(PROBLEM_ID),
		IS_COLLECTION: window.encodeURI(IS_COLLECTION),
		USER_ID: window.encodeURI(USER_ID),
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
					var COLLECTION_ID = ""; //问题收藏ID
					var PROBLEM_ID = ""; //问题ID
					var IS_COLLECTION = ""; //是否收藏(0否、1是)
					var USER_ID = ""; //用户ID
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						COLLECTION_ID = data["list"][i]["COLLECTION_ID"];//问题收藏ID
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						IS_COLLECTION = data["list"][i]["IS_COLLECTION"];//是否收藏(0否、1是)
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemCollectionById.go?COLLECTION_ID="+COLLECTION_ID;
						content += "<tr id='problemcollectionlist_tr'>";
						content += "  <td><input type='checkbox' value='"+COLLECTION_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+COLLECTION_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+COLLECTION_ID+"</td>";
						content += "  <td>"+PROBLEM_ID+"</td>";
						content += "  <td>"+IS_COLLECTION+"</td>";
						content += "  <td>"+USER_ID+"</td>";
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
		showmessage({message:"请选择问题收藏信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delProblemCollection.go",{
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