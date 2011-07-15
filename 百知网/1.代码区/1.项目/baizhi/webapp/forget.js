$(document).ready(function(){
	$("#forgetform").validate({
		rules:{
			EMAIL:{required:true,email:true,remote: {url: "isEmail.go",type: "post",dataType: "json",data: {
        		//传递参数
				EMAIL: function() {return $("#EMAIL").val();},
			}}} 
		},
		messages:{
			EMAIL:{required:"请输入邮件地址",email:"请输入正确的邮件地址"} 
		},
		submitHandler:function(form){
			forgetPassword();
        }   
	});
	
});


//提交
function forgetPassword(){
	$.post("forget.go",{
		EMAIL:$("#EMAIL").val()
	},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		if(data!=null&&data["flag"]==true){
			$("#forget_form").hide();
			$("#forget_message").show();
			$("#message").html("邮件发送成功!请到邮箱查收邮件!");
		}else{
			$("#forget_form").hide();
			$("#forget_message").show();
			$("#message").html("邮件发送失败,请重新<a href='forget.jsp'>发送邮件</a>!");
		}
	});
}