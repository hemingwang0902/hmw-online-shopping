$(document).ready(function(){
	$("#ProblemTalkForm").validate({
		rules:{
			TALK_ID: {required: true, number:true},
			PROBLEM_ID: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			TALK_ID: {required: "请输入话题ID",number:"话题ID必须为整数"},
			PROBLEM_ID: {required: "请输入问题ID",number:"问题ID必须为整数"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});