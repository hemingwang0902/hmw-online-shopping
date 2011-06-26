$(document).ready(function(){
	$("#UserForm").validate({
		rules:{
			USER_TYPE: {required: true},
			EMAIL:{required:true,email:true,remote: {url: "checkEmail.go",type: "post",dataType: "json",data: {
        		//传递参数
				EMAIL: function() {return $("#EMAIL").val();},
				USER_ID: function() {return  $("#USER_ID").val();}
			}}} ,
			PASSWORD: {required: true,rangelength: [6,14]},
            CONFIRM_PASSWORD: {required: true,rangelength: [6,14],equalTo: "#PASSWORD"}
		},
		messages:{
			USER_TYPE: {required: "请选择用户类型"},
			EMAIL:{required:"请输入邮件地址",email:"请输入正确的邮件地址"} ,
			PASSWORD:{required:"请输入密码",rangelength: "密码长度在{0}-{1}之间"} ,
            CONFIRM_PASSWORD:{required:"请输入确认密码",rangelength: "确认密码长度在{0}-{1}之间" ,equalTo:"确认密码与密码不一致，请重新输入"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	//如果用户ID不为空，则将Email、用户类型禁用
	if($("#USER_ID").val()!=""){
		$("#USER_TYPE").addClass("readonly");
		$("#USER_TYPE").attr("readonly","readonly");
		$("#EMAIL").addClass("readonly");
		$("#EMAIL").attr("readonly","readonly");
		
		$("#USER_TYPE").val($("#USER_TYPE_HIDDEN").val());
		
	}
	
});