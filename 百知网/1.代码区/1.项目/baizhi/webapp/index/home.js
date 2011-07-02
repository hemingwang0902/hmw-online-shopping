$(document).ready(function(){
	//获取数据列表
	//getDataList();
	
	//新增问题弹出框
	$("#item_a").fancybox({
		'width'				: 440,      //弹出框宽度
		'height'			: 290,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic'//弹出方式
	});
	
	$("#title").bind({
	  focus: function(){
	    if($(this).val() == "搜索问题、品牌或会员 >>"){
	    	$(this).val("");
	    }
	  },
	  blur: function(){
	     if($(this).val() == ""){
	    	$(this).val("搜索问题、品牌或会员 >>");
	    }
	  }
	}).autocomplete("getUserOrProblemByTitleList.go", {
		autoFill: false,
		selectFirst: false,
		dataType: "json",
		extraParams:{
			"nowPage": 1,
			"onePageCount": 10
		},
		formatItem: function(row, i, max) {
			var url = "javascript:void(0);";
			if(row.TYPE == '0'){ //查看搜索结果：XXX
				 url = "http://www.google.com";
			}else if(row.TYPE == '1'){ //会员
				 url = "http://news.163.com";
			}else if(row.TYPE == '2'){ //品牌
				 url = "http://news.qq.com";
			}else if(row.TYPE == '3'){ //问题
				 url = "http://news.sina.com.cn";
			}
			return "<a href='javascript:void(0);' onclick='document.location=\"" + url + "\"' style='width:100%;'>" + row.TITLE + "</a>";
		},
		parse:function(result){ //将从后台返回的数据转化为候选项数组
			var parsed = [];
			if(result != null && result != ''){
				var data = eval("("+result+")");
				if (data != null && data["list"] != null && data["list"].length > 0) {
					for(var i=0;i<data["list"].length;i++){
						var row = data["list"][i];
						parsed[parsed.length] = {
							data: row,
							value: row.TITLE,
							result: row.TITLE
						};
					}
				}
			}
			
			parsed[parsed.length] = {
				data: {ID:0, TITLE:"查看搜索结果：" + $("#title").val(), TYPE:'0'},
				value: "",
				result: ""
			};
			return parsed;
		}
	});
	
	
});

var count;
/* 获取数据列表*//*
function getDataList(){
	//设置全选"未选中"状态
	$.fn.setNoCheck();
	//删除原有记录
	$("tr").remove("#problemlist_tr");
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	var NAME = $("#NAME").val();
	var PROBLEM_TYPE = $("#PROBLEM_TYPE").val();
	var CONTENT = $("#CONTENT").val();
	var IS_ANONYMITY = $("#IS_ANONYMITY").val();
	var IS_REPORT = $("#IS_REPORT").val();
	var CREATE_TIME = $("#CREATE_TIME").val();
	var CREATE_TIME_END = $("#CREATE_TIME_END").val();
	$.post("getProblemList.go",{
		NAME: NAME,
		PROBLEM_TYPE: PROBLEM_TYPE,
		CONTENT: CONTENT,
		IS_ANONYMITY: IS_ANONYMITY,
		IS_REPORT: IS_REPORT,
		CREATE_TIME: CREATE_TIME,
		CREATE_TIME_END: CREATE_TIME_END,
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
					var PROBLEM_ID = ""; //问题ID
					var PROBLEM_TYPE_NAME = ""; //问题类型(字典：1普通、2我问的问题)
					var CONTENT = ""; //问题内容
					var IS_ANONYMITY = ""; //是否匿名(0否、1是)
					var RELEVANT_DETAILS = ""; //相关细节
					var USER_ID = ""; //用户ID
					var WAS_USERID = ""; //被问用户ID
					var ANSWER_COUNT = ""; //答案数量
					var REVIEW_COUNT = ""; //评论数量
					var ATTENTION_COUNT = ""; //关注数量
					var COLLECTION_COUNT = ""; //收藏数量
					var BROWSE_COUNT = ""; //浏览次数
					var IS_REPORT = ""; //是否举报(0否、1是)
					var REPORT_COUNT = ""; //举报次数
					var CREATE_TIME = ""; //创建时间
					var MODIFY_TIME = ""; //修改时间
			
					for(var i=0;i<data["list"].length;i++){
						PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
						PROBLEM_TYPE_NAME = data["list"][i]["PROBLEM_TYPE_NAME"];//问题类型(字典：1普通、2我问的问题)
						CONTENT = data["list"][i]["CONTENT"];//问题内容
						var tempContent="";
						if(CONTENT.length>20){
							tempContent=StringUnit.substring(CONTENT,20);
						}else{
							tempContent=CONTENT;
						}
						IS_ANONYMITY = data["list"][i]["IS_ANONYMITY"];//是否匿名(0否、1是)
						NAME = data["list"][i]["NAME"];//用户ID
						ANSWER_COUNT = data["list"][i]["ANSWER_COUNT"];//答案数量
						REVIEW_COUNT = data["list"][i]["REVIEW_COUNT"];//评论数量
						ATTENTION_COUNT = data["list"][i]["ATTENTION_COUNT"];//关注数量
						COLLECTION_COUNT = data["list"][i]["COLLECTION_COUNT"];//收藏数量
						BROWSE_COUNT = data["list"][i]["BROWSE_COUNT"];//浏览次数
						IS_REPORT = data["list"][i]["IS_REPORT"];//是否举报(0否、1是)
						REPORT_COUNT = data["list"][i]["REPORT_COUNT"];//举报次数
						CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
						MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
						
						var edithref = "getProblemById.go?PROBLEM_ID="+PROBLEM_ID;
						content += "<tr id='problemlist_tr'>";
						content += "  <td><input type='checkbox' value='"+PROBLEM_ID+"' /></td>";
						content += "  <td>";
						content += "    <a href='"+edithref+"' class='bj_btn' title='编辑'/>";
						content += "    <a href='javascript:;' class='sc_btn' title='删除' onclick=\"delData('"+PROBLEM_ID+"')\"/>";
						content += "  </td>";
						content += "  <td>"+PROBLEM_TYPE_NAME+"</td>";
						content += "  <td title='"+CONTENT+"'>"+tempContent+"</td>";
						content += "  <td>"+NAME+"</td>";
						content += "  <td>"+ANSWER_COUNT+"</td>";
						content += "  <td>"+REVIEW_COUNT+"</td>";
						content += "  <td>"+ATTENTION_COUNT+"</td>";
						content += "  <td>"+COLLECTION_COUNT+"</td>";
						content += "  <td>"+BROWSE_COUNT+"</td>";
						content += "  <td>"+IS_ANONYMITY+"</td>";
						content += "  <td>"+IS_REPORT+"</td>";
						content += "  <td>"+REPORT_COUNT+"</td>";
						content += "  <td>"+CREATE_TIME+"</td>";
						content += "  <td>"+MODIFY_TIME+"</td>";
						content += "</tr>"
					}
				}
			pagination(nowPage,onePageCount,count,content,getDataList);
	});
	return;
}
*/

