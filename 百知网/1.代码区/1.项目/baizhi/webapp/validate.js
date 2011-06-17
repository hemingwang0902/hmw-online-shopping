$(document).ready(function(){
	
	
	
	$("#validateform").validate({
		rules:{
			NAME: {required: true,rangelength: [2,8]},
            AGE:{required:true ,range:[1,120]},
            NUMBER:{required:true, number:true},
            EMAIL:{required:true,email:true} ,
            PHONE:{required:true,phone:true},
            MOBILE:{required:true,mobile:true},
            LINKMODE:{required:true,linkmode:true},
            IDCARD:{required:true,idcard:true} ,
            ENGLISH:{required:true,english:true},
            DIGITS:{required:true,digits:true},
            SEX:{required:true },
            PASSWORD: {required: true,rangelength: [6,14]},
            CONFIRM_PASSWORD: {required: true,rangelength: [6,14],equalTo: "#PASSWORD"},
            MIN:{required:true, number:true},
            MAX:{required:true, number:true,equalSize: "#MIN"},
            URL:{required:true,url:true},
            ACCEPT:{required:true,accept:"gif|png|jpg"},
            ZIPCODE:{required:true,zipcode:true},
            AJAX:{required:true,remote: {url: "/faapplybuy/checkId.go",type: "post",dataType: "json",data: {
            		//传递参数
            		AJAX: function() {return window.encodeURI($("#AJAX").val());}
			}}}
		},
		messages:{
			NAME: {required: "请输入姓名",rangelength: "姓名长度在{0}-{1}之间"},
            AGE:{required: "请输入年龄",range: "年龄大小在{0}-{1}之间"},
            NUMBER:{required:"请输入数字",number:"请输入正确的数字"},
            EMAIL:{required:"请输入邮件地址",email:"请输入正确的邮件地址"} ,
            PHONE:{required:"请输入电话",phone:"请输入正确的电话"} ,
            MOBILE:{required:"请输入手机",mobile:"请输入正确的手机"} ,
            LINKMODE:{required:"请输入联系方式",linkmode:"请输入正确的联系方式"} ,
            IDCARD:{required:"请输入身份证",idcard:"请输入正确的身份证"} ,
            ENGLISH:{required:"请输入字母",english:"请输入字母"} ,
            DIGITS:{required:"请输入整数",digits:"请输入整数"},
            SEX:{required:"请选择性别"},
            PASSWORD:{required:"请输入密码",rangelength: "密码长度在{0}-{1}之间"} ,
            CONFIRM_PASSWORD:{required:"请输入确认密码",rangelength: "确认密码长度在{0}-{1}之间" ,equalTo:"确认密码与密码不一致，请重新输入"} ,
            MIN:{required:"请输入数字",number:"请输入正确的数字"},
            MAX:{required:"请输入数字",number:"请输入正确的数字",equalSize:"最大值不能小于最小值，请重新输入"},
            URL:{required:"请输入网址",url:"请输入正确的网址"} ,
            ACCEPT:{required:"请输入图片文件名",accept:"请输入正确的图片文件名"},
            ZIPCODE:{required:"请输入邮编地址",zipcode:"请输入正确的邮编地址"} 
		},
		submitHandler:function(form){
            alert("submitted");   
            form.submit();
        }   
	});
	
	
});



