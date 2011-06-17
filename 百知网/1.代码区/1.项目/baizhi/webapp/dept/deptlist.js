var count;
function getDeptList(){
	$.fn.setNoCheck();
	$("tr").remove("#deptlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var DEPT_NAME = $("#DEPT_NAME").val();
	$.post("deptList.go",{
		DEPT_NAME:window.encodeURI(DEPT_NAME),
		nowPage:nowPage,
		onePageCount:onePageCount},
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
					var deptid = "";
					var deptname = "";
					var deptremark = "";				
					for(var i=0;i<data["list"].length;i++){
						deptid = data["list"][i]["DEPT_ID"];
						deptname = data["list"][i]["DEPT_NAME"]?data["list"][i]["DEPT_NAME"]:"&nbsp;";
						deptremark = data["list"][i]["DEPT_REMARK"]?data["list"][i]["DEPT_REMARK"]:"&nbsp;";
						var edithref = "getDept.go?DEPT_ID="+deptid;
	
						content += "<tr id='deptlist_tr'>";
						content += "  <td><input type='checkbox' value='"+deptid+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"deptDel('"+deptid+"')\"/>";
						content += "  </td>";
						content += "  <td>"+noNullerShow(deptname)+"</td>";
						content += "  <td>"+noNullerShow(deptremark)+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDeptList);
	});
	return;
}
//滤掉空值
function noNullerShow(str){
	str = str.toString();
	if(str==null||$.trim(str)==""){
		return "&nbsp;";
	}else{
		return str;
	}
}

/*删除部门*/
function deptDel(ids){
	if(ids==null||ids==''){
		showmessage({message:"请选择删除部门",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("deptDel.go",{
				DEPT_IDS:ids
			},function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				if(data!=null&&data["flag"]==true){
					$("#nowPage").val(1);
					//查询
					getDeptList();
				}else{
					showmessage({message:data["message"],type:"error"});
				}
			});
		}
	}});
	return;
}

$(document).ready(function(){
	//查询部门
	getDeptList();
	
	//点击“查询”查询部门
	$("#btn_search").click(function(){
		$("#nowPage").val(1);
		getDeptList();
	});
	
	//点击"删除"删除部门
	$("#deldept").click(function(){
		deptDel($.fn.getCheckValue());
	});
});