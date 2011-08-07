$(document).ready(function(){
	$("#ScoreForm").validate({
		rules:{
			SOCRE: {required: true, number:true},
			IS_VALID: {required: true, number:true},
			REMARK: { rangelength: [1,1000]}
		},
		messages:{
			SOCRE: {required: "请输入积分",number:"积分必须为整数"},
			IS_VALID: {required: "请输入是否禁用",number:"是否禁用必须为整数"},
			REMARK: { rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	//如果用户ID不为空
	if($("#SCORE_ID").val()!=""){
		$("#IS_VALID").val($("#IS_VALID_HIDDEN").val());
	}
	
});