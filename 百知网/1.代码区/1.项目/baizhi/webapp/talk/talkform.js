$(document).ready(function(){
	$("#TalkForm").validate({
		rules:{
			CONTENT: {required: true, rangelength: [1,1000]}
		},
		messages:{
			CONTENT: {required: "请输入话题名称", rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});