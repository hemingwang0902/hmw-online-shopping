$(document).ready(function(){
	var q = parent.$("#q").val();
	if(q != "搜索问题、品牌或会员 >>"){
		$("#CONTENT").val(q);
	}
		
	$("#save").click(function(){
		var content = $.trim($("#CONTENT").val());
		if(content){
			$.post("../problem/saveProblemByAjax.go",{
				PROBLEM_TYPE: "1", 
				CONTENT: content,
				IS_ANONYMITY: $("#IS_ANONYMITY").attr("checked") ? "1" : "0",
				RELEVANT_DETAILS: $("#RELEVANT_DETAILS").val(),
				isAjax: true,
				TALK_ID: parent.$("#TALK_ID").val(),
				BRAND_ID: parent.$("#BRAND_ID").val()
			}, function(result){
				if(result==null||result==''){
					$("#error_1").text("添加问题失败！");
					return ;
				}

				var data = eval("("+result+")");
				var message_0 = data["message"];
				var problemId = data["id"];
				if(message_0){
					$("#error_1").text(message_0);
				}else{
					if (problemId != null && problemId.length > 0) {
						parent.document.location="wtymDetail.go?problemId=" + problemId;
					}else{
						$("#error_1").text("添加问题失败！");
					}
				}
			});
		}else{
			$("#CONTENT").focus();
			$("#error_1").text("请输入问题内容");
		}
	});
});