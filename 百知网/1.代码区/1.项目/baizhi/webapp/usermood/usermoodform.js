$(document).ready(function(){
	$("#UserMoodForm").validate({
		rules:{
			user_id: {required: true, number:true},
			descript: {required: true, rangelength: [1,255]},
			publish_time: {required: true}
		},
		messages:{
			user_id: {required: "请输入用户ID",number:"用户ID必须为整数"},
			descript: {required: "请输入心情随记的内容", rangelength: "长度为1至255"},
			publish_time: {required: "请输入发表时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});