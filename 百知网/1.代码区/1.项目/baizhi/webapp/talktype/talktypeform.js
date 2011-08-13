$(document).ready(function(){
	$("#TalktypeForm").validate({
		rules:{
			TYPE_NAME: {required: true, rangelength: [1,1000]},
			REMARK: {required: true, rangelength: [1,1000]},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			TYPE_NAME: {required: "请输入类型名称", rangelength: "长度为1或者1000"},
			REMARK: {required: "请输入备注", rangelength: "长度为1或者1000"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});