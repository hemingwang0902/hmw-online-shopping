$(document).ready(function(){
	$("#UPLOAD_FORM").validate({
		rules:{
			upload: {required: true,isImageFormat:true}
		},
		messages:{
			IMAGE_PATH: {required:"请选择上传文件",isImageFormat:"请上传正确的图片格式"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});