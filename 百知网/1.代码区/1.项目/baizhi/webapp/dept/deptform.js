$(document).ready(function(){
	$("#deptform").validate({
		rules:{
			DEPT_NAME: {required: true,remote: {url: "checkDeptName.go",type: "post",dataType: "json",data: {
        		//传递参数
				DEPT_NAME: function() {return window.encodeURI($("#DEPT_NAME").val());},
				DEPT_ID: function() {return  $("#DEPT_ID").val();}
			}}}
		},
		messages:{
			DEPT_NAME: {required: "请输入部门名称",remote:""}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
});