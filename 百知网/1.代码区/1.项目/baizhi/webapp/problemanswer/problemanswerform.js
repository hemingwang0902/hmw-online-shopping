$(document).ready(function(){
	$("#ProblemAnswerForm").validate({
		rules:{
			PROBLEM_ID: {required: true, number:true},
			CONTENT: {required: true, rangelength: [1,1000]},
			USER_ID: {required: true, number:true},
			AGREE_COUNT: {required: true, number:true},
			DISAGREE_COUNT: {required: true, number:true},
			THANK_COUNT: {required: true, number:true},
			DISTHANK_COUNT: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			PROBLEM_ID: {required: "请输入问题ID",number:"问题ID必须为整数"},
			CONTENT: {required: "请输入内容", rangelength: "长度为1至1000"},
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			AGREE_COUNT: {required: "请输入赞成数量",number:"赞成数量必须为整数"},
			DISAGREE_COUNT: {required: "请输入反对数量",number:"反对数量必须为整数"},
			THANK_COUNT: {required: "请输入感觉作者数量",number:"感觉作者数量必须为整数"},
			DISTHANK_COUNT: {required: "请输入没有帮助数量",number:"没有帮助数量必须为整数"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});