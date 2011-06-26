$(document).ready(function(){
	$("#SHOW_TYPE").val($("#SHOW_TYPE").attr("initValue"));
	$("#STATUS").val($("#SHOW_TYPE").attr("initValue"));
	
	$("#AdForm").validate({
		rules:{
			TITLE: {required: true, rangelength: [1,50]},
			//CONTENT: {required: true},
			SHOW_TYPE: {required: true, rangelength: [1,10]},
			START_TIME: {required: true},
			END_TIME: {required: true},
			STATUS: {required: true, rangelength: [1,10]},
		},
		messages:{
			TITLE: {required: "请输入主题", rangelength: "长度为1至50"},
			//CONTENT: {required: "请输入内容"},
			SHOW_TYPE: {required: "请输入显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)", rangelength: "长度为1至10"},
			START_TIME: {required: "请输入起始时间"},
			END_TIME: {required: "请输入终止时间"},
			STATUS: {required: "请输入状态(字典：1申请、2通过、3不通过)", rangelength: "长度为1至10"},
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});