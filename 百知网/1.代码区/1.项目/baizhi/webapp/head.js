var userprivate_count=-1;
//获取未读私信息数量
function getUserPrivateCount(){
	$.post("../userprivate/getUserPrivateCount.go",{},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null){
			if(data["count"]>0){
				$("#userprivate_count").text("("+data["count"]+")");
			}else{
				$("#userprivate_count").text("");
			}
		}
	});
	return;
}

var useruserdynamic_count=-1;
//获取未读通知数量
function getUserDynamicCount(){
	$.post("../userdynamic/getUserDynamicCount.go",{IS_OPEN: 0},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null){
			if(data["count"]>0){
				$("#userdynamic_count").text("("+data["count"]+")");
			}else{
				$("#userdynamic_count").text("");
			}
		}
	});
	return;
}

$(document).ready(function(){
	if(userprivate_count==-1){
		//获取未读私信息数量
		getUserPrivateCount();
	}
	
	if(useruserdynamic_count==-1){
		//获取未读通知数量
		getUserDynamicCount();
	}
	
	//切换城市
	$("#city_a").fancybox({
		'width'				: '75%',
		'height'			: '75%',
		'autoScale'			: false,
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'type'				: 'iframe'
	});
	
});