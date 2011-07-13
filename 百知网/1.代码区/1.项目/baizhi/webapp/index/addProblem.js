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
			CONTENT: {required: "请输入问题内容"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
		
	$("#save").click(function(){
		if($("#ProblemForm").valid()){
			$.post("../problem/saveProblemByAjax.go",{
				PROBLEM_TYPE: "1", 
				CONTENT: $("#CONTENT").val(),
				IS_ANONYMITY: $("#IS_ANONYMITY").attr("checked") ? "1" : "0",
				RELEVANT_DETAILS: $("#RELEVANT_DETAILS").val(),
				isAjax: true
			}, function(result){
				if(result==null||result==''){
					showmessage({message:"添加问题失败！",type:"error"});
				}
				var data = eval("("+result+")");
				var content = "";
				if (data != null && data["id"] != null && data["id"].length > 0) {
					//showmessage({message:"添加问题成功",type:"info"});
					//parent.$.fancybox.close();
					parent.document.location="wtymDetail.go?problemId=" + data["id"];
				}else{
					showmessage({message:"添加问题失败！",type:"error"});
				}
			});
		}		
	});
});