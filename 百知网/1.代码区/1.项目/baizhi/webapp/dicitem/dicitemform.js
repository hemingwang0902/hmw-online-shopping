$(document).ready(function(){
	$("#DicitemForm").validate({
		rules:{
			CODE: {required: true, rangelength: [1,50]},
			DIC_CODE: {required: true, rangelength: [1,30]},
			DIC_NAME: {required: true, rangelength: [1,100]},
			PDIC_CODE: {required: true, rangelength: [1,30]},
			ALLPIN: {required: true, rangelength: [1,100]},
			SIMPLEPIN: {required: true, rangelength: [1,30]},
			ORDER_BY: {required: true, number:true},
			REMARK: {required: true, rangelength: [1,1000]}
		},
		messages:{
			CODE: {required: "请选择列表字典代码", rangelength: "长度为1或者50"},
			DIC_CODE: {required: "请选择字典代码", rangelength: "长度为1或者30"},
			DIC_NAME: {required: "请选择字典名称", rangelength: "长度为1或者100"},
			PDIC_CODE: {required: "请选择字典上级代码", rangelength: "长度为1或者30"},
			ALLPIN: {required: "请选择字典全拼", rangelength: "长度为1或者100"},
			SIMPLEPIN: {required: "请选择字典简拼", rangelength: "长度为1或者30"},
			ORDER_BY: {required: "请选择显示顺序",number:"显示顺序必须为整数"},
			REMARK: {required: "请选择备注", rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});