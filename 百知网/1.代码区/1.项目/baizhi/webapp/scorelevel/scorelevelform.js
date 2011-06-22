$(document).ready(function(){
	$("#ScoreLevelForm").validate({
		rules:{
			NAME: {required: true, rangelength: [1,50],remote: {url: "checkName.go",type: "post",dataType: "json",data: {
				//传递参数
				NAME: function() {return  $("#NAME").val();},
				SCORELEVEL_ID: function() {return  $("#SCORELEVEL_ID").val();}
			}}},
			SOCRE_UP: {required: true, number:true,remote: {url: "checkScore.go",type: "post",dataType: "json",data: {
        		//传递参数
				SOCRE_UP: function() {return $("#SOCRE_UP").val();},
				SOCRE_DOWN: function() {return  $("#SOCRE_DOWN").val();},
				SCORELEVEL_ID: function() {return  $("#SCORELEVEL_ID").val();}
			}}},
			SOCRE_DOWN: {required: true, number:true,equalSize: "#SOCRE_UP",remote: {url: "checkScore.go",type: "post",dataType: "json",data: {
				//传递参数
				SOCRE_UP: function() {return $("#SOCRE_UP").val();},
				SOCRE_DOWN: function() {return  $("#SOCRE_DOWN").val();},
				SCORELEVEL_ID: function() {return  $("#SCORELEVEL_ID").val();}
			}}},
			REMARK: {max:1000}
		},
		messages:{
			NAME: {required: "请输入级别名称", rangelength: "长度为1或者50"},
			SOCRE_UP: {required: "请输入积分上限",number:"积分上限必须为整数"},
			SOCRE_DOWN: {required: "请输入积分下限",number:"积分下限必须为整数",equalSize: "积分下限不能小于积分上限，请重新输入"},
			REMARK: {max: "长度必须小于1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});