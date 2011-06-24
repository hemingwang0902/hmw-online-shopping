$(document).ready(function(){
	$("#${className}Form").validate({
		rules:{
			<#list lis as being>
			<#if being.columnkey != "PRI">
			<#if being_index != (totalcount-1)>
			<#if being.datatype == "java.util.Date">
			${being.oldCl}: {required: true},
			<#elseif  being.datatype == "int">
			${being.oldCl}: {required: true, number:true},
			<#else>
			${being.oldCl}: {required: true, rangelength: [1,${being.len}]},
			</#if>
			<#else>
			<#if being.datatype == "java.util.Date">
			${being.oldCl}: {required: true}
			<#elseif  being.datatype == "int">
			${being.oldCl}: {required: true, number:true}
			<#else>
			${being.oldCl}: {required: true, rangelength: [1,${being.len}]}
			</#if>
			</#if>
			</#if>
			</#list>
		},
		messages:{
			<#list lis as being>
			<#if being.columnkey != "PRI">
			<#if being_index != (totalcount-1)>
			<#if being.datatype == "java.util.Date">
			${being.oldCl}: {required: "请输入${being.content}"},
			<#elseif being.datatype == "int">
			${being.oldCl}: {required: "请输入${being.content}",number:"${being.content}必须为整数"},
			<#else>
			${being.oldCl}: {required: "请输入${being.content}", rangelength: "长度为1至${being.len}"},
			</#if>
			<#else>
			<#if being.datatype == "java.util.Date">
			${being.oldCl}: {required: "请输入${being.content}"}
			<#elseif being.datatype == "int">
			${being.oldCl}: {required: "请输入${being.content}",number:"${being.content}必须为整数"}
			<#else>
			${being.oldCl}: {required: "请输入${being.content}", rangelength: "长度为1至${being.len}"}
			</#if>
			</#if>
			</#if>
			</#list>
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
});