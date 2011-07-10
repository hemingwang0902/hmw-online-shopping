$(document).ready(function(){
	$("#UserBrandForm").validate({
		rules:{
			USER_ID: {required: true, number:true},
			NAME: {required: true, rangelength: [1,50]},
			INTRODUCTION: {required: true, rangelength: [1,1000]},
			SOURCE: {required: true, rangelength: [1,50]},
			PROVINCE: {required: true, number:true},
			CITY: {required: true, number:true},
			INDUSTRY: {required: true, rangelength: [1,10]},
			LINK_NAME: {required: true, rangelength: [1,10]},
			LINK_MODE: {required: true, rangelength: [1,20]},
			EMAIL: {required: true, rangelength: [1,50]},
			IMAGE_PATH: {required: true, rangelength: [1,100]},
			STAUS: {required: true, number:true},
			AUDIT_ID: {required: true, number:true},
			AUDIT_TIME: {required: true},
			REASON: {required: true, rangelength: [1,1000]},
			REMARK: {required: true, rangelength: [1,1000]},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			NAME: {required: "请输入品牌名称", rangelength: "长度为1或者50"},
			INTRODUCTION: {required: "请输入品牌介绍", rangelength: "长度为1或者1000"},
			SOURCE: {required: "请输入发源地(品牌特有)", rangelength: "长度为1或者50"},
			PROVINCE: {required: "请输入所在地区(省：地区信息表ID)",number:"所在地区(省：地区信息表ID)必须为整数"},
			CITY: {required: "请输入所在地区(市：地区信息表ID)",number:"所在地区(市：地区信息表ID)必须为整数"},
			INDUSTRY: {required: "请输入从事行业(字典)", rangelength: "长度为1或者10"},
			LINK_NAME: {required: "请输入联系人姓名", rangelength: "长度为1或者10"},
			LINK_MODE: {required: "请输入联系方式", rangelength: "长度为1或者20"},
			EMAIL: {required: "请输入电子邮箱", rangelength: "长度为1或者50"},
			IMAGE_PATH: {required: "请输入相片路径/LOGO路径", rangelength: "长度为1或者100"},
			STAUS: {required: "请输入状态(1：未申请、2：申请、3：通过、4：未通过)",number:"状态(1：未申请、2：申请、3：通过、4：未通过)必须为整数"},
			AUDIT_ID: {required: "请输入审核人",number:"审核人必须为整数"},
			AUDIT_TIME: {required: "请输入审核时间"},
			REASON: {required: "请输入不通过原因", rangelength: "长度为1或者1000"},
			REMARK: {required: "请输入备注", rangelength: "长度为1或者1000"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});