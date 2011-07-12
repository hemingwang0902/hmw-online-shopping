$(document).ready(function(){
	$("#RegiestForm").validate({
		rules:{
			NAME:{required: true,rangelength: [2,20]},
			INTRODUCTION:{required: true,rangelength: [0,200]},
			EMAIL:{required:true,email:true,remote: {url: "user/checkEmail.go",type: "post",dataType: "json",data: {
        		//传递参数
				EMAIL: function() {return $("#EMAIL").val();}
			}}} ,
			PASSWORD: {required: true,rangelength: [6,14]},
            CONFIRM_PASSWORD: {required: true,rangelength: [6,14],equalTo: "#PASSWORD"}
		},
		messages:{
			NAME:{required:"请输入姓名",rangelength:"姓名长度在{0}-{1}之间"} ,
			INTRODUCTION:{required:"请输入简介",email:"简介长度在{0}-{1}之间"} ,
			EMAIL:{required:"请输入邮件地址",email:"请输入正确的邮件地址"} ,
			PASSWORD:{required:"请输入密码",rangelength: "密码长度在{0}-{1}之间"} ,
            CONFIRM_PASSWORD:{required:"请输入确认密码",rangelength: "确认密码长度在{0}-{1}之间" ,equalTo:"确认密码与密码不一致，请重新输入"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});