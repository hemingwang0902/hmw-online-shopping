var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#usermoodlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var id = $("#id").val();
	var user_id = $("#user_id").val();
	var descript = $("#descript").val();
	var publish_time = $("#publish_time").val();
	$.post("getUserMoodList.go",{
		id: window.encodeURI(id),
		user_id: window.encodeURI(user_id),
		descript: window.encodeURI(descript),
		publish_time: window.encodeURI(publish_time),
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
					var id = ""; //
					var user_id = ""; //用户ID
					var descript = ""; //心情随记的内容
					var publish_time = ""; //发表时间
			
					for(var i=0;i<data["list"].length;i++){
						id = data["list"][i]["id"];//
						user_id = data["list"][i]["user_id"];//用户ID
						descript = data["list"][i]["descript"];//心情随记的内容
						publish_time = data["list"][i]["publish_time"];//发表时间
						
						var edithref = "getUserMoodById.go?id="+id;
						content += "<tr id='usermoodlist_tr'>";
						content += "  <td><input type='checkbox' value='"+id+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+id+"')\"/>";
						content += "  </td>";
						content += "  <td>"+id+"</td>";
						content += "  <td>"+user_id+"</td>";
						content += "  <td>"+descript+"</td>";
						content += "  <td>"+publish_time+"</td>";
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
		showmessage({message:"请选择用户心情随记",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delUserMood.go",{
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