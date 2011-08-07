var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#userbrandlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	
	$.post("getUserBrandByList.go",{
		USER_NAME: $("#USER_NAME").val(),
		NAME:$("#NAME").val(),
		SOURCE: $("#SOURCE").val(),
		PROVINCE: $("#PROVINCE").val(),
		CITY:$("#CITY").val(),
		INDUSTRY: $("#INDUSTRY").val(),
		LINK_NAME:  $("#LINK_NAME").val(),
		LINK_MODE:$("#LINK_MODE").val(),
		EMAIL:$("#EMAIL").val(),
		STAUS: 3,
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
					var BRAND_ID = ""; //品牌ID
					var USER_NAME = ""; //用户ID
					var NAME = ""; //品牌名称
					var INTRODUCTION = ""; //品牌介绍
					var SOURCE = ""; //发源地(品牌特有)
					var PROVINCE = ""; //所在地区(省：地区信息表ID)
					var CITY = ""; //所在地区(市：地区信息表ID)
					var INDUSTRY = ""; //从事行业(字典)
					var LINK_NAME = ""; //联系人姓名
					var LINK_MODE = ""; //联系方式
					var EMAIL = ""; //电子邮箱
					var IMAGE_PATH = ""; //相片路径/LOGO路径
					var STAUS = ""; //状态(1：未申请、2：申请、3：通过、4：未通过)
					var AUDIT_NAME = ""; //审核人
					var AUDIT_TIME = ""; //审核时间
					var REASON = ""; //不通过原因
					var REMARK = ""; //备注
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
					var IS_COMMEND = ""; //是否推荐
			
					for(var i=0;i<data["list"].length;i++){
						BRAND_ID = data["list"][i]["BRAND_ID"];//品牌ID
						USER_NAME = data["list"][i]["USER_NAME"];//用户姓名
						NAME = data["list"][i]["NAME"];//品牌名称
						INTRODUCTION = data["list"][i]["INTRODUCTION"];//品牌介绍
						SOURCE = data["list"][i]["SOURCE"];//发源地(品牌特有)
						PROVINCE = data["list"][i]["PROVINCE"];//所在地区(省：地区信息表ID)
						CITY = data["list"][i]["CITY"];//所在地区(市：地区信息表ID)
						INDUSTRY = data["list"][i]["INDUSTRY"];//从事行业(字典)
						LINK_NAME = data["list"][i]["LINK_NAME"];//联系人姓名
						LINK_MODE = data["list"][i]["LINK_MODE"];//联系方式
						EMAIL = data["list"][i]["EMAIL"];//电子邮箱
						IMAGE_PATH = data["list"][i]["IMAGE_PATH"];//相片路径/LOGO路径
						AUDIT_NAME = data["list"][i]["AUDIT_NAME"];//审核人
						AUDIT_TIME = data["list"][i]["AUDIT_TIME"];//审核时间
						REASON = data["list"][i]["REASON"];//不通过原因
						REMARK = data["list"][i]["REMARK"];//备注
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						IS_COMMEND = data["list"][i]["IS_COMMEND"];//是否推荐
						
						var edithref = "getUserBrandById.go?BRAND_ID="+BRAND_ID;
						var commend_text="";
						
						content += "<tr id='userbrandlist_tr'>";
						
						content += "  <td>";
						if(IS_COMMEND==1){
							content += "    <a href='javascript:;' class='sc_btn' title='解除' onclick=\"agreeData('"+BRAND_ID+"',0)\"/>";
							commend_text="是";
						}else{
							content += "    <a href='javascript:;' class='qrfp_btn' title='推荐' onclick=\"agreeData('"+BRAND_ID+"',1)\"/>";
							commend_text="否";
						}
						
						content += "  </td>";
						content += "  <td>"+USER_NAME+"</td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+commend_text+"</td>";
						content += "  <td>"+SOURCE+"</td>";
						content += "  <td>"+PROVINCE+"</td>";
						content += "  <td>"+CITY+"</td>";
						content += "  <td>"+INDUSTRY+"</td>";
						content += "  <td>"+LINK_NAME+"</td>";
						content += "  <td>"+LINK_MODE+"</td>";
						content += "  <td>"+EMAIL+"</td>";
						content += "  <td>"+AUDIT_NAME+"</td>";
						content += "  <td>"+AUDIT_TIME+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}

/* 推荐*/
function agreeData(ids,IS_COMMEND){
	if(ids==null||ids==''){
		showmessage({message:"请选择用户品牌信息",type:"info"});
		return ;
	}
	var tip_info="";
	if(IS_COMMEND==1){
		tip_info="是否推推荐到首页?";
	}else{
		tip_info="是否取消推荐到首页?";
	}
	showmessage({message:tip_info,type:"error",callmethod:function(flag){
		if(flag){
			$.post("commendBrand.go",{
				BRAND_ID:ids,
				IS_COMMEND:IS_COMMEND
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
	
	//加载下拉框
	initSelect("PROVINCE","CITY",false);
});  