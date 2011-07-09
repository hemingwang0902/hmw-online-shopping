$(document).ready(function(){
	$("#private_a").fancybox({
		'titlePosition'		: 'inside', //弹出框类型
		'transitionIn'	    : 'none',//弹入方式
		'transitionOut'	    : 'none' //弹出方式
	});
	
	getDataList();
	
	//获取未阅读记录数
	getUserPrivateCount();
});

/* 保存数据*/
function saveData(){
	var USER_ID=$("#USER_IDS").val();
	var PRIVATE_CONTENT=$("#PRIVATE_CONTENT").val();
	if(USER_ID==null||USER_ID==''){
		$("#PRIVATE_MESSAGE").text("提示：请选择发送私信姓名");
		return ;
	}
	if(PRIVATE_CONTENT==null||PRIVATE_CONTENT==''){
		$("#PRIVATE_MESSAGE").text("提示：请输入发送私信内容");
		return ;
	}
	$.post("../userprivate/saveUserPrivate.go",{
		USER_ID:USER_ID,
		CONTENT:PRIVATE_CONTENT
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
			$("#USER_IDS").val("");
			$("#PRIVATE_CONTENT").val("");
			$.fancybox.close();
			//查询
			getDataList();
		}else{
			showmessage({message:data["message"],type:"error"});
		}
	});
	return;
}

var count;
/* 获取数据列表*/
function getDataList(){
	//删除原有记录
	$("#userprivatelist").html("");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	$.post("../userprivate/getUserPrivateList.go",{nowPage: nowPage,onePageCount: onePageCount},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			if(nowPage==1){
				count=data["totalCount"] ;
			}
			$("#private_count").text(data["list"].length);
			
			var map;
			for(var i=0;i<data["list"].length;i++){
				map=data["list"][i];
				var desc="";
				if(map.IS_MYSELF==0){
					desc="我发送给&nbsp;";
				}
				var show_read_text="";
				if(map.NO_PRIVATE_COUNT>0){
					show_read_text=map.NO_PRIVATE_COUNT+"条未阅读记录"
				}else{
					show_read_text="共"+map.PRIVATE_COUNT+"条对话";
				}
				content+="<div class='wdzx'>";
				content+="	<div class='wdzx_1'><img src='"+data["cpath"]+"/"+map["IMAGE_PATH"]+"' height='25px' width='25px'  onerror='load_person_image_25_25(this)'  /></div>";
				content+="	<div class='wdzx_2'>";
				content+="		<div class='wdzx_3'>"+desc+"<a href='javascript:;' class='mo'>"+map.NAME+"</a>："+map.CONTENT+"</div>";
				content+="		<div class='wdzx_4'>"+map.CREATE_TIME+" &nbsp;";
				content+="			<span>";
				content+="				<a href='initWdzxDetailForm.go?SEND_ID="+map.SEND_ID+"&NO_PRIVATE_COUNT="+map.NO_PRIVATE_COUNT+"'>"+show_read_text+"</a> | ";
				content+="				<a href='javascript:;' onclick='review("+map.SEND_ID+")'>回复</a> | ";
				content+="				<a href='javascript:;' onclick='delData("+map.SEND_ID+")'>删除</a> ";
				content+="			</span>";
				content+="		 </div>";
				content+="	</div>";
				content+="</div>";
			}
		}
		$("#userprivatelist").html(content);
	});
	return;
}

//回复
function review(SEND_ID){
	$("#USER_IDS").val(SEND_ID);
	$("#private_a").click();
}

//删除
function delData(SEND_ID){
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("../userprivate/delUserPrivate.go",{
				SEND_ID:SEND_ID
			},function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				if(data!=null&&data["flag"]==true){
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