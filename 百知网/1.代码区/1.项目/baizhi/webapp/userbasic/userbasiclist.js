var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#userbasiclist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var BASIC_ID = $("#BASIC_ID").val();
	var USER_ID = $("#USER_ID").val();
	var USER_TYPE = $("#USER_TYPE").val();
	var NAME = $("#NAME").val();
	var SOURCE = $("#SOURCE").val();
	var PROVINCE = $("#PROVINCE").val();
	var CITY = $("#CITY").val();
	var INDUSTRY = $("#INDUSTRY").val();
	var YEARS = $("#YEARS").val();
	var LINK_MODE = $("#LINK_MODE").val();
	var IS_OPEN = $("#IS_OPEN").val();
	var INTRODUCTION = $("#INTRODUCTION").val();
	var MOTTO = $("#MOTTO").val();
	var IMAGE_PATH = $("#IMAGE_PATH").val();
	var WEBSITE = $("#WEBSITE").val();
	var PRIVATE_SET = $("#PRIVATE_SET").val();
	var LEVEL = $("#LEVEL").val();
	var SCORE = $("#SCORE").val();
	var REMARK = $("#REMARK").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var MODIFY_TIME = $("#MODIFY_TIME").val();
	$.post("getUserBasicList.go",{
		BASIC_ID: window.encodeURI(BASIC_ID),
		USER_ID: window.encodeURI(USER_ID),
		USER_TYPE: window.encodeURI(USER_TYPE),
		NAME: window.encodeURI(NAME),
		SOURCE: window.encodeURI(SOURCE),
		PROVINCE: window.encodeURI(PROVINCE),
		CITY: window.encodeURI(CITY),
		INDUSTRY: window.encodeURI(INDUSTRY),
		YEARS: window.encodeURI(YEARS),
		LINK_MODE: window.encodeURI(LINK_MODE),
		IS_OPEN: window.encodeURI(IS_OPEN),
		INTRODUCTION: window.encodeURI(INTRODUCTION),
		MOTTO: window.encodeURI(MOTTO),
		IMAGE_PATH: window.encodeURI(IMAGE_PATH),
		WEBSITE: window.encodeURI(WEBSITE),
		PRIVATE_SET: window.encodeURI(PRIVATE_SET),
		LEVEL: window.encodeURI(LEVEL),
		SCORE: window.encodeURI(SCORE),
		REMARK: window.encodeURI(REMARK),
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
					var BASIC_ID = ""; //用户基本信息ID
					var USER_ID = ""; //用户ID
					var USER_TYPE = ""; //用户类型(字典：1用户、2品牌)冗余字段
					var NAME = ""; //姓名/品牌名称
					var SOURCE = ""; //发源地(品牌特有)
					var PROVINCE = ""; //所在地区(省：地区信息表ID)
					var CITY = ""; //所在地区(市：地区信息表ID)
					var INDUSTRY = ""; //从事行业(字典)
					var YEARS = ""; //所在年代(字典、用户特有)
					var LINK_MODE = ""; //联系方式
					var IS_OPEN = ""; //是否对外开放(0否、1是)
					var INTRODUCTION = ""; //个人介绍/品牌介绍
					var MOTTO = ""; //人生格言(用户特有)
					var IMAGE_PATH = ""; //相片路径/LOGO路径
					var WEBSITE = ""; //个性网址
					var PRIVATE_SET = ""; //私信设置(字典：1所有人、2我关注的人)
					var LEVEL = ""; //级别
					var SCORE = ""; //积分
					var REMARK = ""; //备注
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						BASIC_ID = data["list"][i]["BASIC_ID"];//用户基本信息ID
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						USER_TYPE = data["list"][i]["USER_TYPE"];//用户类型(字典：1用户、2品牌)冗余字段
						NAME = data["list"][i]["NAME"];//姓名/品牌名称
						SOURCE = data["list"][i]["SOURCE"];//发源地(品牌特有)
						PROVINCE = data["list"][i]["PROVINCE"];//所在地区(省：地区信息表ID)
						CITY = data["list"][i]["CITY"];//所在地区(市：地区信息表ID)
						INDUSTRY = data["list"][i]["INDUSTRY"];//从事行业(字典)
						YEARS = data["list"][i]["YEARS"];//所在年代(字典、用户特有)
						LINK_MODE = data["list"][i]["LINK_MODE"];//联系方式
						IS_OPEN = data["list"][i]["IS_OPEN"];//是否对外开放(0否、1是)
						INTRODUCTION = data["list"][i]["INTRODUCTION"];//个人介绍/品牌介绍
						MOTTO = data["list"][i]["MOTTO"];//人生格言(用户特有)
						IMAGE_PATH = data["list"][i]["IMAGE_PATH"];//相片路径/LOGO路径
						WEBSITE = data["list"][i]["WEBSITE"];//个性网址
						PRIVATE_SET = data["list"][i]["PRIVATE_SET"];//私信设置(字典：1所有人、2我关注的人)
						LEVEL = data["list"][i]["LEVEL"];//级别
						SCORE = data["list"][i]["SCORE"];//积分
						REMARK = data["list"][i]["REMARK"];//备注
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getUserBasicById.go?BASIC_ID="+BASIC_ID;
						content += "<tr id='userbasiclist_tr'>";
						content += "  <td><input type='checkbox' value='"+BASIC_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+BASIC_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+BASIC_ID+"</td>";
						content += "  <td>"+USER_ID+"</td>";
						content += "  <td>"+USER_TYPE+"</td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+SOURCE+"</td>";
						content += "  <td>"+PROVINCE+"</td>";
						content += "  <td>"+CITY+"</td>";
						content += "  <td>"+INDUSTRY+"</td>";
						content += "  <td>"+YEARS+"</td>";
						content += "  <td>"+LINK_MODE+"</td>";
						content += "  <td>"+IS_OPEN+"</td>";
						content += "  <td>"+INTRODUCTION+"</td>";
						content += "  <td>"+MOTTO+"</td>";
						content += "  <td>"+IMAGE_PATH+"</td>";
						content += "  <td>"+WEBSITE+"</td>";
						content += "  <td>"+PRIVATE_SET+"</td>";
						content += "  <td>"+LEVEL+"</td>";
						content += "  <td>"+SCORE+"</td>";
						content += "  <td>"+REMARK+"</td>";
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
		showmessage({message:"请选择用户基本信息表",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delUserBasic.go",{
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