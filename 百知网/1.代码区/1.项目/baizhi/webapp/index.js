$(function(){
	//获取功能菜单
	/*$.ajax({url:"functionlist/getFunctionlistList.go",type: "POST",data:"",async: false,success:function(result){
		var data = eval("("+result+")");
		if (data != null ) {
			$("#myjquerymenu").html(data["content"]);
			jquerycssmenu.buildmenu("myjquerymenu", arrowimages);
		}
	}});*/
	$("#menu_list").show();
});


/**
 * 获取窗体内容
 * param　title 标题
 * param　href  链接地址
 */
function addTab(title,href){
	$('#menu_list').hide();
	$("#tt").css("display","block");
	$("#tt").css("width",1002);
	$('#iframe_main').attr("src",href);
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

