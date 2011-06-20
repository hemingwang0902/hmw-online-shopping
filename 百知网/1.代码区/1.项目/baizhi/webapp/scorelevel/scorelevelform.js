$(document).ready(function(){
	$("#ScoreLevelForm").validate({
		rules:{
			NAME: {required: true, rangelength: [1,50]},
			SOCRE_UP: {required: true, number:true},
			SOCRE_DOWN: {required: true, number:true},
			REMARK: {required: true, rangelength: [1,1000]}
		},
		messages:{
			NAME: {required: "请选择级别名称", rangelength: "长度为1或者50"},
			SOCRE_UP: {required: "请选择积分上限",number:"积分上限必须为整数"},
			SOCRE_DOWN: {required: "请选择积分下限",number:"积分下限必须为整数"},
			REMARK: {required: "请选择备注", rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});