$(document).ready(function(){
	$("#AreaForm").validate({
		rules:{
			DIC_CODE: {required: true, rangelength: [1,30]},
			DIC_NAME: {required: true, rangelength: [1,50]},
			PAREA_ID: {required: true, number:true},
			ALLPIN: {required: true, rangelength: [1,100]},
			SIMPLEPIN: {required: true, rangelength: [1,30]},
			ORDER_BY: {required: true, number:true},
			IP_START: {required: true, rangelength: [1,20]},
			IP_END: {required: true, rangelength: [1,20]},
			AREA_LEVEL: {required: true, rangelength: [1,10]},
			REMARK: {required: true, rangelength: [1,1000]}
		},
		messages:{
			DIC_CODE: {required: "请选择地区代码(根据级别制定规则定义)", rangelength: "长度为1或者30"},
			DIC_NAME: {required: "请选择地区名称", rangelength: "长度为1或者50"},
			PAREA_ID: {required: "请选择地区上级代码",number:"地区上级代码必须为整数"},
			ALLPIN: {required: "请选择地区全拼", rangelength: "长度为1或者100"},
			SIMPLEPIN: {required: "请选择地区简拼", rangelength: "长度为1或者30"},
			ORDER_BY: {required: "请选择显示顺序",number:"显示顺序必须为整数"},
			IP_START: {required: "请选择IP起始段", rangelength: "长度为1或者20"},
			IP_END: {required: "请选择IP终止段", rangelength: "长度为1或者20"},
			AREA_LEVEL: {required: "请选择地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级", rangelength: "长度为1或者10"},
			REMARK: {required: "请选择备注", rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});