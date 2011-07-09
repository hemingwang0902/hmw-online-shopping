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
			}
		}
	});
	return;
}
$(document).ready(function(){
	if(userprivate_count==-1){
		//获取未读私信息数量
		getUserPrivateCount()
	}
});