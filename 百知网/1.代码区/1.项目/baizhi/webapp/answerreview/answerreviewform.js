$(document).ready(function(){
	$("#AnswerReviewForm").validate({
		rules:{
			ANSWER_ID: {required: true, number:true},
			PROBLEM_ID: {required: true, number:true},
			CONTENT: {required: true, rangelength: [1,1000]},
			PREVIEW_ID: {required: true, number:true},
			USER_ID: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			ANSWER_ID: {required: "请输入问题答案ID",number:"问题答案ID必须为整数"},
			PROBLEM_ID: {required: "请输入问题ID(冗余字段)",number:"问题ID(冗余字段)必须为整数"},
			CONTENT: {required: "请输入内容", rangelength: "长度为1至1000"},
			PREVIEW_ID: {required: "请输入问题答案评论ID父ID",number:"问题答案评论ID父ID必须为整数"},
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});