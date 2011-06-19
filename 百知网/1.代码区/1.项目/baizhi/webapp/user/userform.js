$(document).ready(function(){
	$("#UserForm").validate({
		rules:{
			USER_TYPE: {required: true, rangelength: [1,10]},
			EMAIL: {required: true, rangelength: [1,50]},
			PASSWORD: {required: true, rangelength: [1,50]},
			REG_TIME: {required: true},
			LAST_LOGINTIME: {required: true},
			IP: {required: true, rangelength: [1,30]},
			MAC: {required: true, rangelength: [1,50]},
			LAST_FREEZETIME: {required: true}
		},
		messages:{
			USER_TYPE: {required: "请选择用户类型(字典：1用户、2品牌)", rangelength: "长度为1或者10"},
			EMAIL: {required: "请选择Email", rangelength: "长度为1或者50"},
			PASSWORD: {required: "请选择密码", rangelength: "长度为1或者50"},
			REG_TIME: {required: "请选择注册时间"},
			LAST_LOGINTIME: {required: "请选择最后登录时间"},
			IP: {required: "请选择最后登录IP", rangelength: "长度为1或者30"},
			MAC: {required: "请选择最后登录MAC", rangelength: "长度为1或者50"},
			LAST_FREEZETIME: {required: "请选择最后冻结时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});