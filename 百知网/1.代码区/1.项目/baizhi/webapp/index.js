$(function(){
	//获取功能菜单
	$.ajax({url:"functionlist/getFunctionlistList.go",type: "POST",data:"",async: false,success:function(result){
		var data = eval("("+result+")");
		if (data != null ) {
			$("#myjquerymenu").html(data["content"]);
			jquerycssmenu.buildmenu("myjquerymenu", arrowimages);
		}
	}});
	
	// 查询框的自动补全功能
	$("#q").autocomplete("dicitem/getDicitemByKeyword.go", {
		autoFill: false,
		selectFirst: false,
		extraParams:{
			//"DIC_NAME": window.encodeURI($("#q").val()),
			//"ALLPIN": window.encodeURI($("#q").val()),
			//"SIMPLEPIN": window.encodeURI($("#q").val()),
			"nowPage": 1,
			"onePageCount": 10
		},
		formatItem: function(row, i, max) {
			return i + "/" + max + ": " + row.DIC_NAME;
		},
		formatMatch: function(row, i, max) {// 对每一行数据使用此函数格式化需要查询的数据格式. 返回值是给内部搜索算法使用的. （走缓存时使用）
			return row.DIC_NAME;
		},
	    /*
	    formatResult: function(row) {	// 和formatItem类似,但可以把将要输入到input文本框内的值进行格式化.同样有三个参数,和formatItem一样.Default: none,表示要么是只有数据,要么是使用formatItem提供的值.
	        return row.DIC_NAME;
	    },
	    */
		parse:function(result){ //将从后台返回的数据转化为候选项数组
			var parsed = [];
			if(result==null||result==''){
				return parsed;
			}
			var data = eval("("+result+")");
			var content = "";
			if (data != null && data["list"] != null && data["list"].length > 0) {
				for(var i=0;i<data["list"].length;i++){
					/*
					DICITEM_ID = data["list"][i]["DICITEM_ID"];//字典清单ID
					CODE = data["list"][i]["CODE"];//列表字典代码
					DIC_CODE = data["list"][i]["DIC_CODE"];//字典代码
					DIC_NAME = data["list"][i]["DIC_NAME"];//字典名称
					PDIC_CODE = data["list"][i]["PDIC_CODE"];//字典上级代码
					ALLPIN = data["list"][i]["ALLPIN"];//字典全拼
					SIMPLEPIN = data["list"][i]["SIMPLEPIN"];//字典简拼
					ORDER_BY = data["list"][i]["ORDER_BY"];//显示顺序
					REMARK = data["list"][i]["REMARK"];//备注
					*/
					var row = data["list"][i];
					parsed[parsed.length] = {
						data: row,
						value: row.DIC_NAME,
						result: row.DIC_NAME
					};
				}
			}
			return parsed;
	},
	dataType: "json"
	});
});


/**
 * 获取窗体内容
 * param　title 标题
 * param　href  链接地址
 */
function addTab(title,href){
	$("#tt").css("display","block");
	$("#tt").css("width",1002);
	$('#iframe_main').attr("src",href);
}

//自动适应高度
function turnHeight(iframe){
   /* var frm = document.getElementById(iframe);   
    var subWeb = document.frames ? document.frames[iframe].document : frm.contentDocument;   
    if(frm != null && subWeb != null){ 
    	var height = subWeb.body.scrollHeight + 20;
    	frm.height=height<600?600:height;
    }   */
}

