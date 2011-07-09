$(document).ready(function(){
	$("#UserForm").validate({
		rules:{
			R_PASSWORD:{required:true,remote: {url: "../user/checkPassword.go",type: "post",dataType: "json",data: {
        		//传递参数
				R_PASSWORD: function() {return $("#R_PASSWORD").val();}
			}}} ,
			PASSWORD: {required: true,rangelength: [6,14]},
            CONFIRM_PASSWORD: {required: true,rangelength: [6,14],equalTo: "#PASSWORD"}
		},
		messages:{
			R_PASSWORD:{required:"请输入当前密码",remote:""} ,
			PASSWORD:{required:"请输入密码",rangelength: "密码长度在{0}-{1}之间"} ,
            CONFIRM_PASSWORD:{required:"请输入确认密码",rangelength: "确认密码长度在{0}-{1}之间" ,equalTo:"确认密码与密码不一致，请重新输入"}
		},
		submitHandler:function(form){
			saveData();
        }   
	});
	
});


function saveData(){
	$.post("../user/modifyPassword.go",{
		PASSWORD:$("#PASSWORD").val()
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
			showmessage({message:data["message"],type:"info"});
			document.forms['UserForm'].reset(); 

		}else{
			showmessage({message:data["message"],type:"error"});
		}
	});
	return;
}
