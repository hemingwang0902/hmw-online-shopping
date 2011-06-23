var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#userinvitelist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var NAME = $("#NAME").val();
	var IS_SUCCESS = $("#IS_SUCCESS").val();
	var EMAIL = $("#EMAIL").val();
	var INVITE_TIME = $("#INVITE_TIME").val();
	var INVITE_TIME_END = $("#INVITE_TIME_END").val();
	$.post("getUserInviteList.go",{
		NAME: NAME,
		IS_SUCCESS: window.encodeURI(IS_SUCCESS),
		EMAIL: EMAIL,
		INVITE_TIME: INVITE_TIME,
		INVITE_TIME_END: INVITE_TIME_END,
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
					var INVITE_ID = ""; //用户邀请ID
					var NAME = ""; //会员名称
					var IS_SUCCESS = ""; //是否邀请成功(0否、1是)
					var EMAIL = ""; //邀请Email
					var INVITE_CODE = ""; //邀请码
					var INVITE_TIME = ""; //邀请时间
					var INVITE_USERID = ""; //邀请用户ID
			
					for(var i=0;i<data["list"].length;i++){
						INVITE_ID = data["list"][i]["INVITE_ID"];//用户邀请ID
						NAME = data["list"][i]["NAME"];//用户ID
						IS_SUCCESS = data["list"][i]["IS_SUCCESS"];//是否邀请成功(0否、1是)
						EMAIL = data["list"][i]["EMAIL"];//邀请Email
						INVITE_TIME = data["list"][i]["INVITE_TIME"];//邀请时间
						
						var edithref = "getUserInviteById.go?INVITE_ID="+INVITE_ID;
						content += "<tr id='userinvitelist_tr'>";
					/*	content += "  <td><input type='checkbox' value='"+INVITE_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+INVITE_ID+"')\"/>";
						content += "  </td>";*/
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+IS_SUCCESS+"</td>";
						content += "  <td>"+EMAIL+"</td>";
						content += "  <td>"+INVITE_TIME+"</td>";
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
		showmessage({message:"请选择用户邀请信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delUserInvite.go",{
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