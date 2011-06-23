$(document).ready(function(){
	$("#UserInviteForm").validate({
		rules:{
			EMAIL: {required: true}
		},
		messages:{
			EMAIL: {required: "请输入邀请Email"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});