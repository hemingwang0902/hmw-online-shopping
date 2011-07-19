$(document).ready(function(){
	var q = parent.$("#q").val();
	if(q != "搜索问题、品牌或会员 >>"){
		$("#CONTENT").val(q);
	}
	
	$("#ProblemForm").validate({
		rules:{
			CONTENT: {required: true}
		},
		messages:{
			CONTENT: {required: "请输入话题名称"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	$("#save").click(function(){
		if($("#ProblemForm").valid()){
			$.post(path.basePath + "/talk/saveTalkByAjax.go",{
				CONTENT: $("#CONTENT").val(),
				INTRODUCTION: $("#INTRODUCTION").val(),
				isAjax: true
			}, function(result){
				if(result==null||result==''){
					showmessage({message:"添加话题失败！",type:"error"});
				}
				var data = eval("("+result+")");
				var content = "";
				if (data != null && data["id"] != null && data["id"].length > 0) {
					parent.document.location=path.talk.detail + data["id"];
				}else{
					showmessage({message:"添加问题失败！",type:"error"});
				}
			});
		}		
	});
});