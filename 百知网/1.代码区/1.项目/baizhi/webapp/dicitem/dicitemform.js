$(document).ready(function(){
	$("#DicitemForm").validate({
		rules:{
			DIC_CODE: {required: true, rangelength: [1,30],remote: {url: "../dicitem/checkCode.go",type: "post",dataType: "json",data: {
				//传递参数
				DIC_CODE: function() {return $("#DIC_CODE").val();},
				CODE: function() {return  $("#CODE").val();},
				DICITEM_ID: function() {return  $("#DICITEM_ID").val();}
			}}},
			DIC_NAME: {required: true, rangelength: [1,100]},
			ALLPIN: {required: true, rangelength: [1,100]},
			SIMPLEPIN: {required: true, rangelength: [1,30]},
			ORDER_BY: {required: true, number:true},
			REMARK: { rangelength: [1,1000]}
		},
		messages:{
			DIC_CODE: {required: "请输入字典代码", rangelength: "长度为1或者30"},
			DIC_NAME: {required: "请输入字典名称", rangelength: "长度为1或者100"},
			ALLPIN: {required: "请输入字典全拼", rangelength: "长度为1或者100"},
			SIMPLEPIN: {required: "请输入字典简拼", rangelength: "长度为1或者30"},
			ORDER_BY: {required: "请输入显示顺序",number:"显示顺序必须为整数"},
			REMARK: { rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
            parent.getDataList();
            parent.$.fancybox.close();
        }   
	});
	
	$("#DIC_NAME").blur(function(){
		$.post("getPinyin.go",{
			DIC_NAME: $("#DIC_NAME").val()
		},
		function(result){
			if(result==null||result==''){
				return;
			}
			var data = eval("("+result+")");
			if (data != null && data["ALLPIN"] != null && data["ALLPIN"].length > 0) {
				$("#ALLPIN").val(data["ALLPIN"]);
				$("#SIMPLEPIN").val(data["SIMPLEPIN"]);
			}
		});
	});
});