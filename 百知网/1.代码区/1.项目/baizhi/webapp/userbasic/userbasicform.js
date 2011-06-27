$(document).ready(function(){
	$("#UserBasicForm").validate({
		rules:{
			USER_ID: {required: true, number:true},
			USER_TYPE: {required: true, rangelength: [1,10]},
			NAME: {required: true, rangelength: [1,50]},
			SOURCE: {required: true, rangelength: [1,50]},
			PROVINCE: {required: true, number:true},
			CITY: {required: true, number:true},
			INDUSTRY: {required: true, rangelength: [1,10]},
			YEARS: {required: true, rangelength: [1,10]},
			LINK_MODE: {required: true, rangelength: [1,20]},
			IS_OPEN: {required: true, number:true},
			INTRODUCTION: {required: true, rangelength: [1,1000]},
			MOTTO: {required: true, rangelength: [1,100]},
			IMAGE_PATH: {required: true, rangelength: [1,100]},
			WEBSITE: {required: true, rangelength: [1,100]},
			PRIVATE_SET: {required: true, rangelength: [1,10]},
			LEVEL: {required: true, number:true},
			SCORE: {required: true, number:true},
			REMARK: {required: true, rangelength: [1,1000]},
			CREATE_TIME: {required: true},
			MODIFY_TIME: {required: true}
		},
		messages:{
			USER_ID: {required: "请输入用户ID",number:"用户ID必须为整数"},
			USER_TYPE: {required: "请输入用户类型(字典：1用户、2品牌)冗余字段", rangelength: "长度为1或者10"},
			NAME: {required: "请输入姓名/品牌名称", rangelength: "长度为1或者50"},
			SOURCE: {required: "请输入发源地(品牌特有)", rangelength: "长度为1或者50"},
			PROVINCE: {required: "请输入所在地区(省：地区信息表ID)",number:"所在地区(省：地区信息表ID)必须为整数"},
			CITY: {required: "请输入所在地区(市：地区信息表ID)",number:"所在地区(市：地区信息表ID)必须为整数"},
			INDUSTRY: {required: "请输入从事行业(字典)", rangelength: "长度为1或者10"},
			YEARS: {required: "请输入所在年代(字典、用户特有)", rangelength: "长度为1或者10"},
			LINK_MODE: {required: "请输入联系方式", rangelength: "长度为1或者20"},
			IS_OPEN: {required: "请输入是否对外开放(0否、1是)",number:"是否对外开放(0否、1是)必须为整数"},
			INTRODUCTION: {required: "请输入个人介绍/品牌介绍", rangelength: "长度为1或者1000"},
			MOTTO: {required: "请输入人生格言(用户特有)", rangelength: "长度为1或者100"},
			IMAGE_PATH: {required: "请输入相片路径/LOGO路径", rangelength: "长度为1或者100"},
			WEBSITE: {required: "请输入个性网址", rangelength: "长度为1或者100"},
			PRIVATE_SET: {required: "请输入私信设置(字典：1所有人、2我关注的人)", rangelength: "长度为1或者10"},
			LEVEL: {required: "请输入级别",number:"级别必须为整数"},
			SCORE: {required: "请输入积分",number:"积分必须为整数"},
			REMARK: {required: "请输入备注", rangelength: "长度为1或者1000"},
			CREATE_TIME: {required: "请输入创建时间"},
			MODIFY_TIME: {required: "请输入修改时间"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});