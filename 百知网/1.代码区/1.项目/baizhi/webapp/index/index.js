var path = {};

$(document).ready(function(){
	var basePath = $("#basePath").val();
	path = {
		basePath		: basePath,
		moviePath		: basePath + "/javascripts/zeroclipboard/ZeroClipboard.swf",
		
		problem: {
			detail		: basePath + "/index/wtymDetail.go?problemId=",
			attention	: basePath + "/index/attentionProblem.go?problemId=",
			attentionList:basePath + "/index/getAttentionProblemList.go",
			collection	: basePath + "/index/collectionProblem.go?problemId=",
			lastest		: basePath + "/index/getLatestProblemList.go",
			hottest		: basePath + "/index/getHottestProblemList.go",
			inviteList	: basePath + "/index/getInviteProblemList.go",
			askMeList	: basePath + "/index/getAskMeProblemList.go",
			nearList	: basePath + "/index/getNearProblemList.go?problemId=",
			all			: basePath + "/index/getAllProblemList.go"
		},
		
		user: {
			detail		: basePath + "/index/initHyym.go?userId=",
			interested	: basePath + "/index/getMayInterestedUser.go"
		},
		
		brand: {
			detail		: basePath + "/index/initPpym.go?BRAND_ID=",
			attention	: "",
			attentionList: basePath + "/index/getAttentionBrand.go"
		},
		talk: {
			detail		: basePath + "/index/initHtym.go?TALK_ID="
		},
		all: {
			query		: basePath + "/index/getUserOrProblemByTitleList.go"
		}
	}
	
	//新增问题弹出框
	$("#item_a").fancybox({
		'width'				: 450,      //弹出框宽度
		'height'			: 300,      //弹出框高度
		'type'				: 'iframe', //弹出框类型
		'transitionIn'	    : 'elastic',//弹入方式
		'transitionOut'	    : 'elastic'//弹出方式
	});
	
	$("#q").bind({
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
	}).autocomplete(path.all.query, {
		dataType: "json",
		extraParams:{
			"nowPage": 1,
			"onePageCount": 10
		},
		formatItem: function(row, i, max) {
			var eve = "";
			var id = row["ID"];
			if(row.TYPE == '0'){ //查看搜索结果：aaa
				 eve = "onclick=\"$('#searchForm').submit();\"";
			}else if(row.TYPE == '1'){ //会员
				 eve = "onclick=\"document.location='" + path.user.detail + id + "'\"";
			}else if(row.TYPE == '2'){ //品牌
				 eve = "onclick=\"document.location='" + path.brand.detaill + id + "'\"";
			}else if(row.TYPE == '3'){ //问题
				 eve = "onclick=\"document.location='" + path.problem.detail + id + "'\"";
			}else if(row.TYPE == '4'){ //话题
				 eve = "onclick=\"document.location='" + path.talk.detail + id + "'\"";
			}
			return "<a href='javascript:void(0);' "+eve+" style='width:100%;'>" + row.TITLE + "</a>";
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
				data: {ID:0, TITLE:"查看搜索结果：" + $("#q").val(), TYPE:'0'},
				value: "",
				result: ""
			};
			return parsed;
		}
	});
});

/**
 * 初始化 ZeroClipboard，用于复制链接至粘贴板
 */
function initZeroClipboard() {
	ZeroClipboard.setMoviePath(path.moviePath);
	
	// Create our clipboard object as per usual
	clip = new ZeroClipboard.Client();
	clip.setHandCursor( true );
	
	clip.addEventListener('load', function (client) {
		//alert("load");
	});
	
	clip.addEventListener('mouseOver', function (client) {
		clip.setText($("#invite").val());
	});
	
	clip.addEventListener('complete', function (client, text) {
		show_showmessage({message:"邀请链接已经复制至粘贴板!",type:"info"});
	});
	
	clip.glue( 'd_clip_button', 'd_clip_container' );
}

/**
 * 更多(该方法需要在各个列表页重写，在此声明主要是为了点“更多”时不报找不到方法的错误)
 */
function getMoreProblemList(){
	
}

/**
 * 关注
 */
function guanZhu(problemId){
	var gzCount = parseInt($("#gz_" + problemId).html()) + 1;
	$.get(path.problem.attention + problemId);
	$("#gz_sp_" + problemId).html(gzCount + "个关注");
}

/**
 * 收藏
 */
function shouCang(problemId){
	$.get(path.problem.collection + problemId);
	$("#sc_" + problemId).html("收藏");
}

/* 获取数据列表*/
function getProblemList(action, more){
	var onePageCount=parseInt($("#onePageCount").val());
	var nowPage=$("#nowPage").val();
	$.post(action,{
		nowPage: nowPage,
		onePageCount: onePageCount
	}, function(result){
		//将 nowPage 的值加 1
		$("#nowPage").val(parseInt($("#nowPage").val()) + 1);
		
		if(!more){ //如果不是点的更多, 则先将 problemList 的数据清空
			$("#problemList").html("&nbsp;");
		}
		
		if(result==null||result==''){
			$(".tiao").html("<span>更多 >></span>");
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
			
			var NAME = ""; //用户姓名
			var IMAGE_PATH = ""; //头像路径
			var WEBSITE = ""; //个性网址
	
			for(var i=0;i<data["list"].length;i++){
				PROBLEM_ID = data["list"][i]["PROBLEM_ID"];//问题ID
				PROBLEM_TYPE = data["list"][i]["PROBLEM_TYPE"];//问题类型(字典：1普通、2我问的问题)
				CONTENT = data["list"][i]["CONTENT"];//问题内容
				IS_ANONYMITY = data["list"][i]["IS_ANONYMITY"];//是否匿名(0否、1是)
				RELEVANT_DETAILS = data["list"][i]["RELEVANT_DETAILS"];
				USER_ID = data["list"][i]["USER_ID"];//用户ID
				ANSWER_COUNT = data["list"][i]["ANSWER_COUNT"];//答案数量
				REVIEW_COUNT = data["list"][i]["REVIEW_COUNT"];//评论数量
				ATTENTION_COUNT = data["list"][i]["ATTENTION_COUNT"];//关注数量
				COLLECTION_COUNT = data["list"][i]["COLLECTION_COUNT"];//收藏数量
				BROWSE_COUNT = data["list"][i]["BROWSE_COUNT"];//浏览次数
				IS_REPORT = data["list"][i]["IS_REPORT"];//是否举报(0否、1是)
				REPORT_COUNT = data["list"][i]["REPORT_COUNT"];//举报次数
				CREATE_TIME = data["list"][i]["CREATE_TIME"];//创建时间
				MODIFY_TIME = data["list"][i]["MODIFY_TIME"];//修改时间
				
				NAME = data["list"][i]["NAME"]; //用户姓名
				IMAGE_PATH = data["list"][i]["IMAGE_PATH"]; //头像路径
				WEBSITE = data["list"][i]["WEBSITE"]; //修改网址
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=="null"){
					IMAGE_PATH = "/images/main/rw_1.png";
				}
				IMAGE_PATH = path.basePath + IMAGE_PATH;
				
				content += "<div class='title'>";
				content += "  <div class='tit_tit'>";
				content += "    <div class='tit_tit_1'></div>";
				content += "    <div class='tit_tit_2' ><span><a href='"+path.user.detail+USER_ID+"'><img src='"+IMAGE_PATH+"' width='25' height='25'/></a></span><a href='"+path.problem.detail +PROBLEM_ID+"'>"+CONTENT+"</a></div>";
				content += "  </div>";
				content += "  <div class='tit_content'>"+RELEVANT_DETAILS+"</div>";
				content += "  <div class='tit_bot'>";
				content += "    <div class='tit_bot_zl'>&nbsp;</div>";
				content += "    <div class='tit_bot_gz'>"+ANSWER_COUNT+" 个答案 • <span id='gz_sp_"+PROBLEM_ID+"'><a href='javascript:void(0);' onclick='guanZhu("+PROBLEM_ID+")'><label id='gz_"+PROBLEM_ID+"'>"+ATTENTION_COUNT+"</label>个关注</a></span> • <span id='sc_"+PROBLEM_ID+"'><a href='javascript:void(0);' onclick='shouCang("+PROBLEM_ID+")'>收藏</a></span> • <a href='javascript:void(0);'>分享</a></div>";
				content += "  </div>";
				content += "</div>";
			}
			$("#problemList").append(content);
		}
		
		if(data["list"].length < onePageCount){
			$(".tiao").html("<span>更多 &gt;&gt;</span>");
		} else{ //查询到的记录条数为空,禁用"更多"
			$(".tiao").html('<a href="javascript:void(0);" onclick="getMoreProblemList();">更多 &gt;&gt;</a>');
		}
	});
	return;
}

/**
 * 你可能感兴趣的人
 */
function getMayInterestedUserList(){
	$.post(path.user.interested,{
		nowPage: 1,
		onePageCount: 4
	}, function(result){
		if(result==null||result==''){
			return;
		}
		
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			var USER_ID = ""; //用户ID
			var NAME = ""; //用户姓名
			var INTRODUCTION = ""; //介绍
			var IMAGE_PATH = ""; //头像路径
			var WEBSITE = ""; //个性网址
	
			for(var i=0;i<data["list"].length;i++){
				USER_ID = data["list"][i]["USER_ID"];
				NAME = data["list"][i]["NAME"]; //用户姓名
				INTRODUCTION = data["list"][i]["INTRODUCTION"];
				IMAGE_PATH = data["list"][i]["IMAGE_PATH"]; //头像路径
				WEBSITE = data["list"][i]["WEBSITE"]; //修改网址
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=="null"){
					IMAGE_PATH = "/images/main/rw_1.png";
				}
				IMAGE_PATH = path.basePath + "/images/main/rw_1.png";
				
				var url = path.user.detail+USER_ID;
				
				content += '<div class="column_contentgxq">';
				content += '	<div class="colun_c_gxq">';
				content += '		<div style="float:left;"><a href="'+url+'"><img src="'+IMAGE_PATH+'" width="25" height="25" border="0" /></a></div>';
				content += '    		<div class="colun_l"><a href="'+url+'">'+NAME+'</a></div>';
				content += '		</div>';
				content += '	<div class=" colun_c_main">'+INTRODUCTION+'</div>';
				content += '</div>';
			}
			$("#mayInterestedUserList").append(content);
		}
	});
}

/**
 * 关注品牌
 */
function getAttentionBrandList(userId){
	var jsonData = {
		nowPage: 1,
		onePageCount: 4
	};
	var userId = parseInt(userId);
	if(!!userId && userId > 0){
		jsonData.userId=userId;
	}
	
	$.post(path.brand.attentionList, jsonData, function(result){
		if(result==null||result==''){
			return;
		}
		
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			var BRAND_ID = ""; //用户ID
			var NAME = ""; //用户姓名
			var INTRODUCTION = ""; //介绍
			var IMAGE_PATH = ""; //头像路径
	
			for(var i=0;i<data["list"].length;i++){
				BRAND_ID = data["list"][i]["BRAND_ID"];
				NAME = data["list"][i]["NAME"]; //用户姓名
				INTRODUCTION = data["list"][i]["INTRODUCTION"];
				IMAGE_PATH = data["list"][i]["IMAGE_PATH"]; //头像路径
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=="null"){
					IMAGE_PATH = "/images/main/rw_1.png";
				}
				IMAGE_PATH = path.basePath + "/images/main/pptp_1.png";
				
				var url = path.brand.detail+BRAND_ID;
				
				content += '<div class="column_contentgxq" style="border:0; margin-bottom:0;">';
				content += '	<div class="colun_c_pptu"><a href="'+url+'"><img src="'+IMAGE_PATH+'" width="60" height="53"/></a>';
				content += '</div>';
				content += '<div class=" colun_c_ppwz">';
				content += '	<div class="colun_c_xnr"><a href="'+url+'">'+NAME+'</a></div>';
				content += '	<div class="colun_c_xnrcon">'+INTRODUCTION+'</div>';
				content += '</div>';
				content += '<div style="clear:both; font-size:0;"></div>';
			}
			$("#attentionUserList").append(content);
		}
	});
}