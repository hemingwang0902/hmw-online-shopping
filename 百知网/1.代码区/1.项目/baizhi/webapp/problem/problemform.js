$(document).ready(function(){
	$("#ProblemForm").validate({
		rules:{
			PROBLEM_TYPE: {required: true, rangelength: [1,10]},
			CONTENT: {required: true, rangelength: [1,3000]},
			IS_ANONYMITY: {required: true, number:true},
			RELEVANT_DETAILS: {required: true, rangelength: [1,1000]},
			USER_ID: {required: true, number:true},
			WAS_USERID: {required: true, number:true},
			ANSWER_COUNT: {required: true, number:true},
			REVIEW_COUNT: {required: true, number:true},
			ATTENTION_COUNT: {required: true, number:true},
			COLLECTION_COUNT: {required: true, number:true},
			BROWSE_COUNT: {required: true, number:true},
			IS_REPORT: {required: true, number:true},
			REPORT_COUNT: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			PROBLEM_TYPE: {required: "请选择问题类型(字典：1普通、2我问的问题)", rangelength: "长度为1或者10"},
			CONTENT: {required: "请选择问题内容", rangelength: "长度为1或者3000"},
			IS_ANONYMITY: {required: "请选择是否匿名(0否、1是)",number:"是否匿名(0否、1是)必须为整数"},
			RELEVANT_DETAILS: {required: "请选择相关细节", rangelength: "长度为1或者1000"},
			USER_ID: {required: "请选择用户ID",number:"用户ID必须为整数"},
			WAS_USERID: {required: "请选择被问用户ID",number:"被问用户ID必须为整数"},
			ANSWER_COUNT: {required: "请选择答案数量",number:"答案数量必须为整数"},
			REVIEW_COUNT: {required: "请选择评论数量",number:"评论数量必须为整数"},
			ATTENTION_COUNT: {required: "请选择关注数量",number:"关注数量必须为整数"},
			COLLECTION_COUNT: {required: "请选择收藏数量",number:"收藏数量必须为整数"},
			BROWSE_COUNT: {required: "请选择浏览次数",number:"浏览次数必须为整数"},
			IS_REPORT: {required: "请选择是否举报(0否、1是)",number:"是否举报(0否、1是)必须为整数"},
			REPORT_COUNT: {required: "请选择举报次数",number:"举报次数必须为整数"},
			CREATE_TIME: {required: "请选择创建时间"},
			MODIFY_TIME: {required: "请选择修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});