$(document).ready(function(){
	$("#AreaForm").validate({
		rules:{
			DIC_CODE: {required: true, rangelength: [1,30]},
			DIC_NAME: {required: true, rangelength: [1,50]},
			PAREA_ID: {required: true, number:true},
			AREA_LEVEL: {required: true, rangelength: [1,10]},
		},
		messages:{
			DIC_CODE: {required: "请输入地区代码", rangelength: "长度为1至30"},
			DIC_NAME: {required: "请输入地区名称", rangelength: "长度为1至50"},
			PAREA_ID: {required: "请输入地区上级代码",number:"地区上级代码必须为整数"},
			AREA_LEVEL: {required: "请输入地区级别(字典：1省、2市、3县、4镇、5村)", rangelength: "长度为1至10"},
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});