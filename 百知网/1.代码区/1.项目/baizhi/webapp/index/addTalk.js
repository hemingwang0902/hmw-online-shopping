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
		var content = $.trim($("#CONTENT").val());
		if(content){
			$.post(path.basePath + "/talk/saveTalkByAjax.go",{
				CONTENT: $("#CONTENT").val(),
				INTRODUCTION: $("#INTRODUCTION").val(),
				isAjax: true
			}, function(result){
				if(result==null||result==''){
					$("#error_1").text("添加话题失败！");
					return ;
				}
				
				var data = eval("("+result+")");
				var message_0 = data["message"];
				var talkId = data["id"];
				if(message_0){
					$("#error_1").text(message_0);
				}else{
					if (talkId != null && talkId.length > 0) {
						parent.document.location=path.talk.detail + talkId;
					}else{
						$("#error_1").text("添加话题失败！");
					}
				}
			});
		}else{
			$("#CONTENT").focus();
			$("#error_1").text("请输入问题内容");
		}
	});
});