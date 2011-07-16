$(document).ready(function(){
	$("#AreaForm").validate({
		rules:{
			DIC_CODE: {required: true, rangelength: [1,30],remote: {url: "checkDicCode.go",type: "post",dataType: "json",data: {
        		//传递参数
				DIC_CODE: function() {return $("#DIC_CODE").val();},
				AREA_ID: function() {return  $("#AREA_ID").val();}
			}}},
			DIC_NAME: {required: true, rangelength: [1,50],remote: {url: "checkDicName.go",type: "post",dataType: "json",data: {
        		//传递参数
				DIC_NAME: function() {return $("#DIC_NAME").val();},
				AREA_ID: function() {return  $("#AREA_ID").val();}
			}}},
			PAREA_ID: {required: true, number:true},
			AREA_LEVEL: {required: true, rangelength: [1,10]},
		},
		messages:{
			DIC_CODE: {required: "请输入地区代码", rangelength: "长度为1至30"},
			DIC_NAME: {required: "请输入地区名称", rangelength: "长度为1至50"},
			PAREA_ID: {required: "请输入地区上级代码",number:"地区上级代码必须为整数"},
			AREA_LEVEL: {required: "请输入地区级别(字典：1省、2市、3县、4镇、5村)", rangelength: "长度为1至10"},
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	//获取城市清单数据
	if($("#AREA_ID").val()!=null&&$("#AREA_ID").val()!=""){
		getDataList();
	}
	//字典项新增
	$("#item_a").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic', //弹出方式
		onClosed : function(){
			getDataList();
		}
	});
	
	//字典项修改
	$("#item_a_modify").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic' //弹出方式
	});
	
	$("#DIC_NAME").blur(function(){
		$.post("../dicitem/getPinyin.go",{
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
	
	//如果用户ID不为空，则将Email、用户类型禁用
	if($("#AREA_ID").val()!=""){
		$("#DIC_CODE").addClass("readonly");
		$("#DIC_CODE").attr("readonly","readonly");
	}
	
	
});

//弹出修改
function lightbox_modify(href){
	$("#item_a_modify").attr("href",href);
	$("#item_a_modify").click();
}

var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#arealist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var PAREA_ID = $("#AREA_ID").val();
	$.post("getAreaList.go",{
		PAREA_ID:PAREA_ID,
		nowPage: nowPage,
		onePageCount: onePageCount},
		function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				var content = "";
				if (data != null && data["list"] != null && data["list"].length > 0) {
					if(nowPage==1){
						count=data["totalCount"] ;
					}
					var AREA_ID = ""; //地区ID
					var DIC_CODE = ""; //地区代码(根据级别制定规则定义)
					var DIC_NAME = ""; //地区名称
					var ALLPIN = ""; //地区全拼
					var SIMPLEPIN = ""; //地区简拼
					var ORDER_BY = ""; //显示顺序
					var IP_START = ""; //IP起始段
					var IP_END = ""; //IP终止段
					var AREA_LEVEL = ""; //地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
					AREA_ID = data["list"][i]["AREA_ID"];//地区ID
					DIC_CODE = data["list"][i]["DIC_CODE"];//地区代码(根据级别制定规则定义)
					DIC_NAME = data["list"][i]["DIC_NAME"];//地区名称
					ALLPIN = data["list"][i]["ALLPIN"];//地区全拼
					SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//地区简拼
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					REMARK = data["list"][i]["REMARK"];//备注
						
						var edithref = "getAreaById.go?AREA_ID="+AREA_ID;
						content += "<tr id='arealist_tr'>";
						content += "  <td><input type='checkbox' value='"+AREA_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='javascript:void(0);' class='bj_btn' title='编辑' onclick=\"lightbox_modify('"+edithref+"')\"/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+AREA_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+DIC_NAME+"</td>";
						content += "  <td>"+DIC_CODE+"</td>";
						content += "  <td>"+ALLPIN+"</td>";
						content += "  <td>"+SIMPLEPIN+"</td>";
						content += "  <td>"+ORDER_BY+"</td>";
						content += "  <td>"+REMARK+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}

/* 删除数据*/
function delData(ids){
	if(ids==null||ids==''){
		showmessage({message:"请选择要删除的城市",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("delArea.go",{
				IDS:ids
			},function(result){
				if(result==null||result==''){
					return;
				}
				var data = eval("("+result+")");
				if(data!=null&&data["flag"]==true){
					$("#nowPage").val(1);
					//查询
					getDataList();
				}else{
					showmessage({message:data["message"],type:"error"});
				}
			});
		}
	}});
	return;
}