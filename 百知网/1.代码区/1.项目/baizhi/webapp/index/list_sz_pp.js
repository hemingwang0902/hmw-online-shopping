$(document).ready(function(){
	$("#UserBrand_FORM").validate({
		rules:{
			NAME: {required: true, rangelength: [1,50],remote: {url: "../userbrand/checkName.go",type: "post",dataType: "json",data: {
				//传递参数
				NAME: function() {return  $("#NAME").val();},
				BRAND_ID: function() {return  $("#BRAND_ID").val();}
			}}},
			INTRODUCTION: { rangelength: [1,1000]},
			SOURCE: {required: true, rangelength: [1,50]},
			PROVINCE: {required: true},
			CITY: {required: true},
			INDUSTRY: {required: true, rangelength: [1,10]},
			LINK_NAME: {required: true, rangelength: [1,10]},
			LINK_MODE: {required: true, rangelength: [1,20],linkmode:true},
			EMAIL: {required: true,email:true, rangelength: [1,50]},
			upload: {required:true, rangelength: [1,100],isImageFormat:true},
			BRAND_LABEL: {required: true, rangelength: [1,100]}
		},
		messages:{
			NAME: {required: "请输入品牌名称", rangelength: "长度为1至50"},
			INTRODUCTION: { rangelength: "长度为1至1000"},
			SOURCE: {required: "请输入发源地", rangelength: "长度为1至50"},
			PROVINCE: {required: "请选择所在省"},
			CITY: {required: "请选择所在市"},
			INDUSTRY: {required: "请输入从事行业", rangelength: "长度为1至10"},
			LINK_NAME: {required: "请输入联系人姓名", rangelength: "长度为1至10"},
			LINK_MODE: {required: "请输入联系方式", rangelength: "长度为1至20",linkmode:"请输入正确的联系方式"},
			EMAIL: {required: "请输入电子邮箱",email:"请输入正确的邮件地址", rangelength: "长度为1至50"},
			upload: {required: "请选择上传图片", rangelength: "长度为1至100",isImageFormat:"请上传正确的图片格式"},
			BRAND_LABEL: {required: "请输入品牌标签", rangelength: "长度为1至100"}
		},
		submitHandler:function(form){
			form.submit();
        }   
	});
	
	//加载下拉框
	initSelect("PROVINCE","CITY",true);
});

function btn_submit(type){
	$("#STAUS").val(type);
	$("#UserBrand_FORM").submit();
}