$(function(){
	$('#tt').tabs();
	//获取功能菜单
	$.ajax({url:"getFunctionList.go",type: "POST",data:"",async: false,success:function(result){
		var data = eval("("+result+")");
		if (data != null ) {
			$("#myjquerymenu").html(data["content"]);
			jquerycssmenu.buildmenu("myjquerymenu", arrowimages);
		}
	}});
	
});




/**
 * 获取窗体内容
 * param　title 标题
 * param　href  链接地址
 */
function getContent(href){
	var date=new Date();
	var time=date.getTime();
	
	var contents="";
	contents+="<div closable='true' style='padding:0px;float:left;width:100%;overflow:hidden;' cache='false' >";
	contents+="	<iframe scrolling='yes' id=\"iframe_"+time+"\" frameborder='0'　 onload=\"turnHeight('iframe_"+time+"');\"  src='"+href+"' style='width:100%;overflow:hidden;;height:600px;padding-bottom:20px;'></iframe>";
	contents+="</div>";
	return contents;
}

/**
 * 获取窗体内容
 * param　title 标题
 * param　href  链接地址
 */
function addTab(title,href){
	$("#tt").css("display","block");
	//$("#tt").css("width",(window.screen.width-1));
	$("#tt").css("width",1002);
	//关闭窗口
	$('#tt').tabs('close',title);
	
	//添加窗口
	$('#tt').tabs('add',{
		title:title,
		content: getContent(href),
		closable:true
	});
}

//自动适应高度
function turnHeight(iframe){
   /* var frm = document.getElementById(iframe);   
    var subWeb = document.frames ? document.frames[iframe].document : frm.contentDocument;   
    if(frm != null && subWeb != null){ 
    	var height = subWeb.body.scrollHeight + 20;
    	frm.height=height<600?600:height;
    }   */
}

