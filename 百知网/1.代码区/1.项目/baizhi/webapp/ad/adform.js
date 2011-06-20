$(document).ready(function(){
	$("#AdForm").validate({
		rules:{
			TITLE: {required: true, rangelength: [1,50]},
			CONTENT: {required: true, rangelength: [1,2000]},
			IMAGE: {required: true, rangelength: [1,100]},
			SHOW_TYPE: {required: true, rangelength: [1,10]},
			HREF: {required: true, rangelength: [1,100]},
			ORDER_BY: {required: true, number:true},
			START_TIME: {required: true},
			END_TIME: {required: true},
			STATUS: {required: true, rangelength: [1,10]},
			REMARK: {required: true, rangelength: [1,1000]}
		},
		messages:{
			TITLE: {required: "请选择主题", rangelength: "长度为1或者50"},
			CONTENT: {required: "请选择内容(支持html内容)", rangelength: "长度为1或者2000"},
			IMAGE: {required: "请选择图片", rangelength: "长度为1或者100"},
			SHOW_TYPE: {required: "请选择显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)", rangelength: "长度为1或者10"},
			HREF: {required: "请选择链接地址", rangelength: "长度为1或者100"},
			ORDER_BY: {required: "请选择显示顺序",number:"显示顺序必须为整数"},
			START_TIME: {required: "请选择起始时间"},
			END_TIME: {required: "请选择终止时间"},
			STATUS: {required: "请选择状态(字典：1申请、2通过、3不通过)", rangelength: "长度为1或者10"},
			REMARK: {required: "请选择备注", rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});