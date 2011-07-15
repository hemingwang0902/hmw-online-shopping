$(document).ready(function(){
	$("#UserForm").validate({
		rules:{
			PASSWORD: {required: true,rangelength: [6,14]},
            CONFIRM_PASSWORD: {required: true,rangelength: [6,14],equalTo: "#PASSWORD"}
		},
		messages:{
			PASSWORD:{required:"请输入密码",rangelength: "密码长度在{0}-{1}之间"} ,
            CONFIRM_PASSWORD:{required:"请输入确认密码",rangelength: "确认密码长度在{0}-{1}之间" ,equalTo:"确认密码与密码不一致，请重新输入"}
		},
		submitHandler:function(form){
			form.submit();
        }   
	});
	
});



