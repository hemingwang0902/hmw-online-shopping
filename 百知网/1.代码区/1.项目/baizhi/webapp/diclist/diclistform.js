$(document).ready(function(){
	$("#DiclistForm").validate({
		rules:{
			NAME: {required: true, rangelength: [1,50],remote: {url: "checkName.go",type: "post",dataType: "json",data: {
				//传递参数
				NAME: function() {return  $("#NAME").val();},
				DICLIST_ID: function() {return  $("#DICLIST_ID").val();}
			}}},
			CODE: {required: true, rangelength: [1,50],remote: {url: "checkCode.go",type: "post",dataType: "json",data: {
				//传递参数
				CODE: function() {return  $("#CODE").val();},
				DICLIST_ID: function() {return  $("#DICLIST_ID").val();}
			}}},
			ALLPIN: {required: true, rangelength: [1,100]},
			SIMPLEPIN: {required: true, rangelength: [1,30]},
			REMARK: { rangelength: [1,1000]}
		},
		messages:{
			NAME: {required: "请输入字典名称", rangelength: "长度为1或者50"},
			CODE: {required: "请输入字典代码", rangelength: "长度为1或者50"},
			ALLPIN: {required: "请输入字典全拼", rangelength: "长度为1或者100"},
			SIMPLEPIN: {required: "请输入字典简拼", rangelength: "长度为1或者30"},
			REMARK: { rangelength: "长度为1或者1000"}
		},
		submitHandler:function(form){
            form.submit();
        }   
	});
	
	//获取字典清单数据
	if($("#DICLIST_ID").val()!=null&&$("#DICLIST_ID").val()!=""){
		getDataList();
	}
	//字典项新增
	$("#item_a").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic' //弹出方式
	});
	
	//字典项修改
	$("#item_a_modify").fancybox({
		'width'				: 1000,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic' //弹出方式
	});
	
	
});

var count;
/* 获取数据列表*/
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#dicitemlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var CODE = $("#CODE").val();
	$.post("../dicitem/getDicitemList.go",{
		CODE:CODE,
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
					var DICITEM_ID = ""; //列表字典ID
					var CODE = ""; //列表字典代码
					var DIC_CODE = ""; //字典代码
					var DIC_NAME = ""; //字典名称
					var ALLPIN = ""; //字典全拼
					var SIMPLEPIN = ""; //字典简拼
					var ORDER_BY = ""; //显示顺序
					var REMARK = ""; //备注
			
					for(var i=0;i<data["list"].length;i++){
						DICITEM_ID = data["list"][i]["DICITEM_ID"];//字典代码
						DIC_CODE = data["list"][i]["DIC_CODE"];//字典代码
						DIC_NAME = data["list"][i]["DIC_NAME"];//字典名称
						ALLPIN = data["list"][i]["ALLPIN"];//字典全拼
						SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//字典简拼
						ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
						REMARK = data["list"][i]["REMARK"];//备注
						
						if(REMARK==null||REMARK==""){
							REMARK="&nbsp;";
						}
						
						var edithref = "../dicitem/getDicitemById.go?DICITEM_ID="+DICITEM_ID;
						content += "<tr id='dicitemlist_tr'>";
						content += "  <td><input type='checkbox' value='"+DICITEM_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='javascript:;' class='bj_btn' title='编辑' onclick=\"lightbox_modify('"+edithref+"')\"/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+DICITEM_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+DIC_CODE+"</td>";
						content += "  <td>"+DIC_NAME+"</td>";
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

//弹出修改
function lightbox_modify(href){
	$("#item_a_modify").attr("href",href);
	$("#item_a_modify").click();
}

/* 删除数据*/
function delData(ids){
	if(ids==null||ids==''){
		showmessage({message:"请选择字典列表清单",type:"info"});
		return ;
	}
	showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("../dicitem/delDicitem.go",{
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