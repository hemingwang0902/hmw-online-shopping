$(document).ready(function(){
	$("#AreaForm").validate({
		rules:{
			DIC_CODE: {required: true, rangelength: [1,30]},
			DIC_NAME: {required: true, rangelength: [1,50]},
			PAREA_ID: {required: true, number:true},
			AREA_LEVEL: {required: true, rangelength: [1,10]},
		},
		messages:{
			DIC_CODE: {required: "请选输入区代码", rangelength: "长度为1至30"},
			DIC_NAME: {required: "请选输入区名称", rangelength: "长度为1至50"},
			PAREA_ID: {required: "请选输入区上级代码",number:"地区上级代码必须为整数"},
			AREA_LEVEL: {required: "请选输入区级别(字典：1省、2市、3县、4镇、5村)", rangelength: "长度为1至10"},
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	
	$("#DIC_NAME").blur(function(){
		$.post("../dicitem/getPinyin.go",{
			DIC_NAME: $("#DIC_NAME").val()
		},
		function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			if (data != null && data["ALLPIN"] != null && data["ALLPIN"].length > 0) {
				$("#ALLPIN").val(data["ALLPIN"]);
				$("#SIMPLEPIN").val(data["SIMPLEPIN"]);
			}
		});
	});
});