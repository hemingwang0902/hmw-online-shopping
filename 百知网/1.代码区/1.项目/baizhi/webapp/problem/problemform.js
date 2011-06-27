$(document).ready(function(){
	$("#ProblemForm").validate({
		rules:{
			PROBLEM_TYPE: {required: true},
			IS_ANONYMITY: {required: true},
			CONTENT: {required: true, rangelength: [1,3000]},
			RELEVANT_DETAILS: {rangelength: [1,1000]}
		},
		messages:{
			PROBLEM_TYPE: {required: "请选择问题类型"},
			IS_ANONYMITY: {required: "请选择是否匿名"},
			CONTENT: {required: "请输入问题内容", rangelength: "长度为1或者3000"},
			RELEVANT_DETAILS: {rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	if($("#PROBLEM_ID").val()!=""){
		$("#PROBLEM_TYPE").val($("#PROBLEM_TYPE_HIDDEN").val());
		$("#IS_ANONYMITY").val($("#IS_ANONYMITY_HIDDEN").val());
		
	}
	
	$("#basic_a").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 700,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic'//弹出方式
	});
	
});