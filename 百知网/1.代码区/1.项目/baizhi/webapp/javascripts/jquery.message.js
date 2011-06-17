//声明回调函数变量
var message_callmethod;
//显示消息
function showmessage(option){
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
		classtype="message_info";
	}else if(type=="error"){
		classtype="message_error";
	}else if(type=="question"){
		classtype="message_question";
	}else if(type=="warning"){
		classtype="message_warning";
	}
	
	//回调方法
	message_callmethod=option["callmethod"];
	//显示阴隐div
	$("#page_shadow").css("display","block");
	//组织消息窗口
	var content="";
	content+="<div class='message_box'>";
	content+="	<div class='message_box_th1'>";
	content+="		<div class='message_box_th2'><h4><span>"+title+"</span><a  href='javascript:;' onclick='closemessage()'>关闭</a></h4></div>";
	content+="	</div>";
	content+="	<div class='message_box_ct1'>";
	content+="		<div class='message_box_ct2'><div class='message_box_tx'><div class="+classtype+">"+message+"</div></div></div>";
	content+="	</div>";
	content+="	<div class='message_box_opr1'>";
	content+="		<div class='message_box_opr2'>";
	content+="			<div class='message_box_oprtx'>";
	//判断是否需要执行函数,如果需要执行函数则显示确定、取消，否则不显示取消
	if($.isFunction(message_callmethod)){
		content+="				<input class='message_bt1' type='submit' onclick='closemessage(true)' value='确 定' />";
		content+="				<input class='message_bt1' type='reset'  onclick='closemessage(false)' value='取 消' />";
	}else{
		content+="				<input class='message_bt1' type='submit' onclick='closemessage()' value='确 定' />";
	}
	content+="			</div>";
	content+="		</div>";
	content+="	</div>";
	content+="	<div class='message_box_ft1'><div class='message_box_ft2'></div></div>";
	content+="</div>";
	//显示消息内容
	$("#page_loading").html(content);
	//淡入显示
	$("#page_loading").fadeIn("fast");
}

//关闭窗口
function closemessage(isconfirm){
	//隐藏阴影DIV
	$("#page_shadow").css("display","none");
	//淡出隐藏
	$("#page_loading").fadeOut("normal");
	//将窗口内容设置为空
	$("#page_loading").html("");
	//判断是否执行回调函数
	if($.isFunction(message_callmethod)){
		message_callmethod(isconfirm);
	}
}

