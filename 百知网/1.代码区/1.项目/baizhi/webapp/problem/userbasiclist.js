var count;
/* 获取数据列表*/
function getDataList(){
	//删除原有记录
	$("tr").remove("#userbasiclist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var USER_TYPE = $("#USER_TYPE").val();
	var NAME = $("#NAME").val();
	var PROVINCE = $("#PROVINCE").val();
	var CITY = $("#CITY").val();
	var INDUSTRY = $("#INDUSTRY").val();
	var YEARS = $("#YEARS").val();
	var LINK_MODE = $("#LINK_MODE").val();
	
	$.post("getUserBasicList.go",{
		USER_TYPE: USER_TYPE,
		NAME: NAME,
		PROVINCE: PROVINCE,
		CITY: CITY,
		INDUSTRY: INDUSTRY,
		YEARS: YEARS,
		LINK_MODE: LINK_MODE,
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
					var USER_TYPE = ""; //用户类型(字典：1用户、2品牌)冗余字段
					var NAME = ""; //姓名/品牌名称
					var PROVINCE = ""; //所在地区(省：地区信息表ID)
					var CITY = ""; //所在地区(市：地区信息表ID)
					var INDUSTRY = ""; //从事行业(字典)
					var YEARS = ""; //所在年代(字典、用户特有)
					var LINK_MODE = ""; //联系方式
			
					for(var i=0;i<data["list"].length;i++){
						USER_ID = data["list"][i]["USER_ID"];//用户ID
						USER_TYPE = data["list"][i]["USER_TYPE"];//用户类型(字典：1用户、2品牌)冗余字段
						NAME = data["list"][i]["NAME"];//姓名/品牌名称
						PROVINCE = data["list"][i]["PROVINCE"];//所在地区(省：地区信息表ID)
						CITY = data["list"][i]["CITY"];//所在地区(市：地区信息表ID)
						INDUSTRY = data["list"][i]["INDUSTRY"];//从事行业(字典)
						YEARS = data["list"][i]["YEARS"];//所在年代(字典、用户特有)
						LINK_MODE = data["list"][i]["LINK_MODE"];//联系方式
						
						
						content += "<tr id='userbasiclist_tr'>";
						content += "  <td>";
						content += "    <a  href='javascript:;' onclick=\"setValues('"+USER_ID+"','"+NAME+"')\" class='qd_btn' title='选择'/>";
						content += "  </td>";
						content += "  <td>"+USER_TYPE+"</td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+PROVINCE+"</td>";
						content += "  <td>"+CITY+"</td>";
						content += "  <td>"+INDUSTRY+"</td>";
						/*content += "  <td>"+YEARS+"</td>";*/
						content += "  <td>"+LINK_MODE+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}

//选择数据
function setValues(USER_ID,NAME){
	parent.$("#"+$("#id").val()).val(USER_ID);
	parent.$("#"+$("#name").val()).val(NAME);
	parent.$.fancybox.close();
}

$(document).ready(function(){
	//获取数据列表
	getDataList();
});  