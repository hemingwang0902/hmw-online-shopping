$(document).ready(function(){
	$("#SETTING_FORM").validate({
		rules:{
			NAME: {required: true, rangelength: [1,10]},
			INTRODUCTION: {required: true, rangelength: [1,50]},
			WEBSITE: {required: true, rangelength: [4,20]}
		},
		messages:{
			TITLE: {required: "请输入姓名", rangelength: "长度为1至10"},
			INTRODUCTION: { rangelength: "长度为1至50"},
			WEBSITE: {required: "请输入个性网址", rangelength: "长度为4至20"}
		},
		submitHandler:function(form){
            saveData();
        }   
	});
	
	$("#UPLOAD_FORM").validate({
		rules:{
			upload: {required: true,isImageFormat:true}
		},
		messages:{
			upload: {required:"请选择上传文件",isImageFormat:"请上传正确的图片格式"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	//加载下拉框
	initSelect("PROVINCE","CITY",true,$("#PROVINCE_HIDDEN").val(),$("#CITY_HIDDEN").val());
});


/* 保存数据*/
function saveData(){
	$.post("saveBasic.go",{
		NAME:$("#NAME").val(),
		INTRODUCTION:$("#INTRODUCTION").val(),
		WEBSITE:$("#WEBSITE").val(),
		PROVINCE:$("#PROVINCE").val(),
		CITY:$("#CITY").val()
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
			show_showmessage({message:data["message"],type:"info"});
		}else{
			show_showmessage({message:data["message"],type:"error"});
		}
	});
	return;
}