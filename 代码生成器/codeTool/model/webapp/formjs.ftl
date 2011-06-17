$(document).ready(function(){
	$("#${packageName}Form").validate({
		rules:{
			NAME: {required: true,remote: {url: "check${packageName}.go",type: "post",dataType: "json",data: {
        		//传递参数
				NAME: function() {return window.encodeURI($("#NAME").val());},
				ID: function() {return  $("#ID").val();}
			}}},
<#list lis as being>
			${being.oldCl}: {required: true, number:true, rangelength: [1,${being.len}]},
</#list>
		},
		messages:{
<#list lis as being>
			${being.oldCl}: {required: "请选择${being.content}", number: "${being.content}是整数", rangelength: "长度为1或者${being.len}"}
</#list>
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	/*
	$("#cname").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 700,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic' //弹出方式
	});*/
});