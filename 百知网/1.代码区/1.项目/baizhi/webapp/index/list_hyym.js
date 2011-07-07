$(document).ready(function(){
	//获取数据列表
	getLatestProblemList();
	
	//新增问题弹出框
	$("#item_a").fancybox({
		'width'				: 450,      //弹出框宽度
		'height'			: 300,      //弹出框高度
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

/* 获取数据列表*/
function getLatestProblemList(){
	var onePageCount=$("#onePageCount").val();
	var nowPage=$("#nowPage").val();
	$.post("getProblemListByUserId.go",{
		userId: $("#userId").val(),
		nowPage: nowPage,
		onePageCount: onePageCount
	}, function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			var PROBLEM_ID = ""; //问题ID
			var PROBLEM_TYPE = ""; //问题类型(字典：1普通、2我问的问题)
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
				PROBLEM_TYPE = data["list"][i]["PROBLEM_TYPE"];//问题类型(字典：1普通、2我问的问题)
				CONTENT = data["list"][i]["CONTENT"];//问题内容
				IS_ANONYMITY = data["list"][i]["IS_ANONYMITY"];//是否匿名(0否、1是)
				RELEVANT_DETAILS = data["list"][i]["RELEVANT_DETAILS"];//用户ID
				ANSWER_COUNT = data["list"][i]["ANSWER_COUNT"];//答案数量
				REVIEW_COUNT = data["list"][i]["REVIEW_COUNT"];//评论数量
				ATTENTION_COUNT = data["list"][i]["ATTENTION_COUNT"];//关注数量
				COLLECTION_COUNT = data["list"][i]["COLLECTION_COUNT"];//收藏数量
				BROWSE_COUNT = data["list"][i]["BROWSE_COUNT"];//浏览次数
				IS_REPORT = data["list"][i]["IS_REPORT"];//是否举报(0否、1是)
				REPORT_COUNT = data["list"][i]["REPORT_COUNT"];//举报次数
				CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
				MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
				
				content += "<div class='title'>";
				content += "  <div class='tit_tit'>";
				content += "    <div class='tit_tit_1'><a href='#'>0</a></div>";
				content += "    <div class='tit_tit_2' ><span><a href='#'><img src='../images/main/rw_1.png' /></a></span><a href='#'>"+CONTENT+"</a></div>";
				content += "  </div>";
				content += "  <div class='tit_content'>"+RELEVANT_DETAILS+"</div>";
				content += "  <div class='tit_bot'>";
				content += "    <div class='tit_bot_zl'>张亮&nbsp;赞同该回答</div>";
				content += "    <div class='tit_bot_gz'><a href='#'>"+ANSWER_COUNT+" 个答案</a> • <a href='#'>"+ATTENTION_COUNT+"个关注</a> • <a href='#'>收藏</a> • <a href='#'>添加评论</a> • <a href='#'>分享</a></div>";
				content += "  </div>";
				content += "</div>";
			}
			$("#divList").append(content);
		}
	});
	return;
}


