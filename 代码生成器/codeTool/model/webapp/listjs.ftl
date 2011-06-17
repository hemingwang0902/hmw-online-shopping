var count;
/* 列表${tabCon}*/
function get${className}List(){
	$("tr").remove("#${packageName}List_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
<#list lis as being>
	var ${being.oldCl} = $("#NAMES").val();
</#list>
	$.post("${packageName}List.go",{
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
						
						var edithref = "get${className}.go?ID="+id;
						content += "<tr id='${packageName}List_tr'>";
						content += "  <td><input type='checkbox' value='"+id+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"${packageName}Del('"+id+"')\"/>";
						content += "  </td>";
<#list lis as being>
						content += "  <td>"+${being.fistLow}+"</td>";
</#list>
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,get${className}List);
	});
	return;
}

/* 删除${tabCon}*/
function ${packageName}Del(ids){
		$("#tip_message").html("");
		if(ids==null||ids==''){
				//$.messager.alert('删除用户','请选择用户!','error');
				$("#tip_message").html("请选择用户");
				return ;
		}
		$.post("${packageName}Del.go",{
			ID:ids
		},function(result){
			if(result==null||result==''){
					return;
			}
			var data = eval("("+result+")");
			if(data!=null&&data["flag"]==true){
					$("#tip_message").html(data["message"]);
					//查询
					get${className}List();
			}else{
					$.messager.alert('删除${tabCon}',data["message"],'error');
					$("#tip_message").html(data["message"]);
			}
		});
		return;
}

$(document).ready(function(){
		//查询 ${tabCon}
		get${className}List();
		//点击 "查询" 查询${tabCon}
		$("#btn_search").click(function(){
				$("#tip_message").html("");
				get${className}List();
		});
		//点击"删除"删除用户
		$("#del${className}").click(function(){
				${packageName}Del($.fn.getCheckValue());
		});
});  