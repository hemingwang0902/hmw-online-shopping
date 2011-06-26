$(document).ready(function(){
	$("#ProblemForm").validate({
		rules:{
			PROBLEM_TYPE: {required: true},
			IS_ANONYMITY: {required: true},
			CONTENT: {required: true, rangelength: [1,3000]},
			RELEVANT_DETAILS: {rangelength: [1,1000]}
		},
		messages:{
			PROBLEM_TYPE: {required: "请选择问题类型"},
			IS_ANONYMITY: {required: "请选择是否匿名"},
			CONTENT: {required: "请输入问题内容", rangelength: "长度为1或者3000"},
			RELEVANT_DETAILS: {rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	if($("#PROBLEM_ID").val()!=""){
		$("#PROBLEM_TYPE").val($("#PROBLEM_TYPE_HIDDEN").val());
		$("#IS_ANONYMITY").val($("#IS_ANONYMITY_HIDDEN").val());
		
	}
	
});