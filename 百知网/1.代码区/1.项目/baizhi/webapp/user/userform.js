$(document).ready(function(){
	$("#UserForm").validate({
		rules:{
			USER_ID: {required: true, number:true, rangelength: [1,11]},
			USER_TYPE: {required: true, number:true, rangelength: [1,10]},
			EMAIL: {required: true, number:true, rangelength: [1,50]},
			PASSWORD: {required: true, number:true, rangelength: [1,50]},
			REG_TIME: {required: true, number:true, rangelength: [1,11]},
			LAST_LOGINTIME: {required: true, number:true, rangelength: [1,14]},
			IP: {required: true, number:true, rangelength: [1,30]},
			MAC: {required: true, number:true, rangelength: [1,50]},
			LAST_FREEZETIME: {required: true, number:true, rangelength: [1,14]}
		},
		messages:{
			USER_ID: {required: "请选择用户ID", number: "用户ID是整数", rangelength: "长度为1或者11"},
			USER_TYPE: {required: "请选择用户类型(字典：1用户、2品牌)", number: "用户类型(字典：1用户、2品牌)是整数", rangelength: "长度为1或者10"},
			EMAIL: {required: "请选择Email", number: "Email是整数", rangelength: "长度为1或者50"},
			PASSWORD: {required: "请选择密码", number: "密码是整数", rangelength: "长度为1或者50"},
			REG_TIME: {required: "请选择注册时间", number: "注册时间是整数", rangelength: "长度为1或者"},
			LAST_LOGINTIME: {required: "请选择最后登录时间", number: "最后登录时间是整数", rangelength: "长度为1或者"},
			IP: {required: "请选择最后登录IP", number: "最后登录IP是整数", rangelength: "长度为1或者30"},
			MAC: {required: "请选择最后登录MAC", number: "最后登录MAC是整数", rangelength: "长度为1或者50"},
			LAST_FREEZETIME: {required: "请选择最后冻结时间", number: "最后冻结时间是整数", rangelength: "长度为1或者"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});