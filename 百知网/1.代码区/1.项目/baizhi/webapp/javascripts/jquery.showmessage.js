//声明回调函数变量
var show_message_callmethod;
//显示消息
function show_showmessage(option){
	$("#show_page_loading").show();
	//获取标题
	var title=(option["title"]==null?"提示信息":option["title"]);
	//获取消息
	var message=(option["message"]==null?"":option["message"]);
	//获取消息类型　info、error、question、warning　根据消息类型显示不同样式
	var type=(option["type"]==null?"":option["type"]);
	var classtype="";
	if(type==""){
		classtype="";
	}else if(type=="info"){
		classtype="show_message_info";
	}else if(type=="error"){
		classtype="show_message_error";
	}else if(type=="question"){
		classtype="show_message_question";
	}else if(type=="warning"){
		classtype="show_message_warning";
	}
	
	//回调方法
	show_message_callmethod=option["callmethod"];
	//组织消息窗口
	var content="";
	content+="<div class='show_message_box'>";
	content+="	<div class='show_message_box_th1'>";
	content+="		<div class='show_message_box_th2'><h4><span>"+title+"</span></h4></div>";
	content+="	</div>";
	content+="	<div class='show_message_box_ct1'>";
	content+="		<div class='show_message_box_ct2'><div class='show_message_box_tx'><div class="+classtype+">"+message+"</div></div></div>";
	content+="	</div>";
	content+="	<div class='show_message_box_opr1'>";
	//判断是否需要执行函数,如果需要执行函数则显示确定、取消，否则不显示取消
	if($.isFunction(show_message_callmethod)){
		content+="				<input class='show_message_bt1' type='submit' onclick='show_closemessage(true)' value='确 定' />";
		content+="				<input class='show_message_bt1' type='reset'  onclick='show_closemessage(false)' value='取 消' />";
	}else{
		content+="				<input class='show_message_bt1' type='submit' onclick='show_closemessage()' value='确 定' />";
	}
	content+="	</div>";
	content+="	<div class='show_message_box_ft1'><div class='show_message_box_ft2'></div></div>";
	content+="</div>";
	//显示消息内容
	$("#show_page_loading").html(content);
	$("#show_message").click();
}

//关闭窗口
function show_closemessage(isconfirm){
	//将窗口内容设置为空
	$("#show_page_loading").hide();
	$("#show_page_loading").html("");
	$.fancybox.close();
	//判断是否执行回调函数
	if($.isFunction(show_message_callmethod)){
		show_message_callmethod(isconfirm);
	}
}

$(document).ready(function(){
	
	$("#show_message").fancybox({
		'titlePosition'		: 'inside', //弹出框类型
		'transitionIn'	    : 'none',//弹入方式
		'transitionOut'	    : 'none', //弹出方式
		onClosed : function(){
			$("#show_page_loading").html("");
			$("#show_page_loading").hide();
		}
	});
	
});