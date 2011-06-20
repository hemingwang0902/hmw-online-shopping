$(document).ready(function(){
	$("#TalkForm").validate({
		rules:{
			CONTENT: {required: true, rangelength: [1,1000]},
			USER_ID: {required: true, number:true},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			CONTENT: {required: "请选择内容", rangelength: "长度为1或者1000"},
			USER_ID: {required: "请选择用户ID",number:"用户ID必须为整数"},
			CREATE_TIME: {required: "请选择创建时间"},
			MODIFY_TIME: {required: "请选择修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});