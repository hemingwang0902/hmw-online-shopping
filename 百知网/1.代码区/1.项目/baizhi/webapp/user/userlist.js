var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#userList_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var USER_ID = $("#USER_ID").val();
	var USER_TYPE = $("#USER_TYPE").val();
	var EMAIL = $("#EMAIL").val();
	var PASSWORD = $("#PASSWORD").val();
	var REG_TIME = $("#REG_TIME").val();
	var LAST_LOGINTIME = $("#LAST_LOGINTIME").val();
	var IP = $("#IP").val();
	var MAC = $("#MAC").val();
	var LAST_FREEZETIME = $("#LAST_FREEZETIME").val();
	$.post("getUserList.go",{
		USER_ID: USER_ID,
		USER_TYPE: USER_TYPE,
		EMAIL: EMAIL,
		PASSWORD: PASSWORD,
		REG_TIME: REG_TIME,
		LAST_LOGINTIME: LAST_LOGINTIME,
		IP: IP,
		MAC: MAC,
		LAST_FREEZETIME:LAST_FREEZETIME,
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
					var USER_ID = ""; //用户ID
					var USER_TYPE = ""; //用户类型(字典：1用户、2品牌)
					var EMAIL = ""; //Email
					var PASSWORD = ""; //密码
					var REG_TIME = ""; //注册时间
					var LAST_LOGINTIME = ""; //最后登录时间
					var IP = ""; //最后登录IP
					var MAC = ""; //最后登录MAC
					var LAST_FREEZETIME = ""; //最后冻结时间
			
					for(var i=0;i<data["list"].length;i++){
					USER_ID = data["list"][i]["USER_ID"];//用户ID
					USER_TYPE = data["list"][i]["USER_TYPE"];//用户类型(字典：1用户、2品牌)
					EMAIL = data["list"][i]["EMAIL"];//Email
					PASSWORD = data["list"][i]["PASSWORD"];//密码
					REG_TIME = data["list"][i]["REG_TIME"];//注册时间
					LAST_LOGINTIME = data["list"][i]["LAST_LOGINTIME"];//最后登录时间
					IP = data["list"][i]["IP"];//最后登录IP
					MAC = data["list"][i]["MAC"];//最后登录MAC
					LAST_FREEZETIME = data["list"][i]["LAST_FREEZETIME"];//最后冻结时间
						
						var edithref = "getUserById.go?USER_ID="+USER_ID;
						content += "<tr id='userList_tr'>";
						content += "  <td><input type='checkbox' value='"+USER_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+USER_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+USER_ID+"</td>";
						content += "  <td>"+USER_TYPE+"</td>";
						content += "  <td>"+EMAIL+"</td>";
						content += "  <td>"+PASSWORD+"</td>";
						content += "  <td>"+REG_TIME+"</td>";
						content += "  <td>"+LAST_LOGINTIME+"</td>";
						content += "  <td>"+IP+"</td>";
						content += "  <td>"+MAC+"</td>";
						content += "  <td>"+LAST_FREEZETIME+"</td>";
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
		showmessage({message:"请选择用户",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delUser.go",{
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