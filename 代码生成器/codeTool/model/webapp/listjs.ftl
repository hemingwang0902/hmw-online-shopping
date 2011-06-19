var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#${packageName}list_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	<#list lis as being>
	var ${being.oldCl} = $("#${being.oldCl}").val();
	</#list>
	$.post("get${className}List.go",{
		<#list lis as being>
		${being.oldCl}: window.encodeURI(${being.oldCl}),
		</#list>
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
					<#list lis as being>
					var ${being.fistLow} = ""; //${being.content}
					</#list>	
			
					for(var i=0;i<data["list"].length;i++){
					<#list lis as being>
					${being.fistLow} = data["list"][i]["${being.oldCl}"];//${being.content}
					</#list>
						
						var edithref = "get${className}ById.go?${PK_KEY}="+${PK_KEY};
						content += "<tr id='${packageName}list_tr'>";
						content += "  <td><input type='checkbox' value='"+${PK_KEY}+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+${PK_KEY}+"')\"/>";
						content += "  </td>";
						<#list lis as being>
						content += "  <td>"+${being.fistLow}+"</td>";
						</#list>
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
		showmessage({message:"请选择${tabCon}",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("del${className}.go",{
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