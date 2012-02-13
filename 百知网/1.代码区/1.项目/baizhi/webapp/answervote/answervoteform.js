$(document).ready(function(){
	$("#AnswerVoteForm").validate({
		rules:{
			ANSWER_ID: {required: true, number:true},
			PROBLEM_ID: {required: true, number:true},
			VOTE_TYPE: {required: true, rangelength: [1,10]},
			IS_AGREE: {required: true, number:true},
			USER_ID: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			ANSWER_ID: {required: "请输入问题答案ID",number:"问题答案ID必须为整数"},
			PROBLEM_ID: {required: "请输入问题ID(冗余字段)",number:"问题ID(冗余字段)必须为整数"},
			VOTE_TYPE: {required: "请输入投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)", rangelength: "长度为1至10"},
			IS_AGREE: {required: "请输入是否赞成、感谢(0否、1是)",number:"是否赞成、感谢(0否、1是)必须为整数"},
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});