$(document).ready(function(){
	$("#form1").validate({
		rules:{
			EMAIL:{required:true,email:true}
		},
		messages:{
			EMAIL:{required:"请输入邮件地址",email:"请输入正确的邮件地址"}
		},
		submitHandler:function(form){
			$.post("sendInviteEmail.go", {
				"email": $("#EMAIL").val(),
				"url": $("#url").val()
			}, function(){
				show_showmessage({message:"邀请邮件已经成功发送 (5秒钟后将自动跳转至首页).",type:"info"});
				window.setTimeout("document.location = 'home.jsp'", 5000);
			});
			return false;
        },
        errorPlacement: function(error, element) {
     		$("#error").append($(error));
   		},
	});
});
