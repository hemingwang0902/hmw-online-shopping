$(document).ready(function(){
	$("#ProblemInviteForm").validate({
		rules:{
			PROBLEM_ID: {required: true, number:true},
			IS_ATTENTION: {required: true, number:true},
			USER_ID: {required: true, number:true},
			WAS_USER_ID: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			PROBLEM_ID: {required: "请输入问题ID",number:"问题ID必须为整数"},
			IS_ATTENTION: {required: "请输入是否回答(0否、1是)",number:"是否回答(0否、1是)必须为整数"},
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			WAS_USER_ID: {required: "请输入被邀请的用户ID",number:"被邀请的用户ID必须为整数"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});