var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#scorelist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var NAME = $("#NAME").val();
	var IS_VALID = $("#IS_VALID").val();
	$.post("getScoreList.go",{
		NAME: NAME,
		IS_VALID: IS_VALID,
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
					var SCORE_ID = ""; //积分ID
					var NAME = ""; //积分名称
					var SOCRE_TYPE = ""; //积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
					var SOCRE = ""; //积分
					var IS_VALID = ""; //是否禁用
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
						SCORE_ID = data["list"][i]["SCORE_ID"];//积分ID
						NAME = data["list"][i]["NAME"];//积分名称
						SOCRE_TYPE = data["list"][i]["SOCRE_TYPE"];//积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
						SOCRE = data["list"][i]["SOCRE"];//积分
						IS_VALID = data["list"][i]["IS_VALID"];//是否禁用
						REMARK = data["list"][i]["REMARK"];//备注
						var edithref = "getScoreById.go?SCORE_ID="+SCORE_ID;
						//类型
						if(SOCRE_TYPE==1){
							SOCRE_TYPE="邀请朋友";
						}else if(SOCRE_TYPE==2){
							SOCRE_TYPE="提问题";
						}else if(SOCRE_TYPE==3){
							SOCRE_TYPE="回答问题";
						}
						//是否禁用
						var temp_IS_VALID="";
						if(IS_VALID==0){
							temp_IS_VALID="否"
						}else{
							temp_IS_VALID="是"
						}
						
						if(REMARK==null){
							REMARK="";
						}
						
						var edithref = "getScoreById.go?SCORE_ID="+SCORE_ID;
						content += "<tr id='scorelist_tr'>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						//content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+SCORE_ID+"',"+IS_VALID+")\"/>";
						content += "  </td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+SOCRE_TYPE+"</td>";
						content += "  <td>"+SOCRE+"</td>";
						content += "  <td>"+temp_IS_VALID+"</td>";
						content += "  <td>"+REMARK+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}

/* 删除数据*/
function delData(ids,IS_VALID){
	showmessage({message:"是否禁用?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delScore.go",{
				IDS:ids,
				IS_VALID:IS_VALID
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