$(document).ready(function(){
	//获取数据列表
	getLastestProblemList();
	getMayInterestedUserList();
	getAttentionBrandList(0);
	
	//初始化 ZeroClipboard
	initZeroClipboard(); 
});


/**
 * 最新问题
 */
function getLastestProblemList(){
	$('#problemType').val('zui');
	$('#nowPage').val(1);
	getProblemList(path.problem.lastest, false);	
	$(".subMenu a").removeClass("checked");
	$(".zui>a").addClass("checked");
}

/**
 * 热门问题
 */
function getHottestProblemList(){
	$('#problemType').val('re');
	$('#nowPage').val(1);
	getProblemList(path.problem.hottest, false);	
	$(".subMenu a").removeClass("checked");
	$(".re>a").addClass("checked");
}

/**
 * 更多
 */
function getMoreProblemList(){
	var action = ($('#problemType').val() == 'zui') ? path.problem.lastest : path.problem.hottest;
	getProblemList(action, true);
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
			var CONTENT = ""; //问题内容
			var RELEVANT_DETAILS = ""; //相关细节
			var USER_ID = ""; //用户ID
			var WAS_USERID = ""; //被问用户ID
			var ANSWER_COUNT = ""; //答案数量
			var ATTENTION_COUNT = ""; //关注数量
			var COLLECTION_COUNT = ""; //收藏数量
			var IS_ATTENTION = 0;
			var IS_COLLECTION = 0;
			
			var NAME = ""; //用户姓名
			var IMAGE_PATH = ""; //头像路径
			var WEBSITE = ""; //个性网址
			var ANSWER_ID=""; //最新回答的ID
			var ANSWER_CONTENT="";//最新回答的内容
			var ANSWER_USER_ID="";//最新回答的用户ID
			var ANSWER_USER_NAME="";//最新回答的用户姓名
			var ANSWER_USER_INTRODUCTION="";//最新回答的用户介绍
	
			var record = null;
			for(var i=0;i<data["list"].length;i++){
				record = data["list"][i];
				PROBLEM_ID = record["PROBLEM_ID"];//问题ID
				CONTENT = record["CONTENT"];//问题内容
				RELEVANT_DETAILS = record["RELEVANT_DETAILS"];
				USER_ID = record["USER_ID"];//用户ID
				ANSWER_COUNT = record["ANSWER_COUNT"];//答案数量
				ATTENTION_COUNT = record["ATTENTION_COUNT"];//关注数量
				COLLECTION_COUNT = record["COLLECTION_COUNT"];//收藏数量
				IS_ATTENTION = record["IS_ATTENTION"];
				IS_COLLECTION = record["IS_COLLECTION"];
			
				NAME = record["NAME"]; //用户姓名
				IMAGE_PATH = record["IMAGE_PATH"]; //头像路径
				WEBSITE = record["WEBSITE"]; //个性网址
				ANSWER_ID=record["ANSWER_ID"]; //最新回答的ID
				ANSWER_CONTENT=$("<div>"+record["ANSWER_CONTENT"]+"</div>").text();//最新回答的内容
				ANSWER_USER_ID=record["ANSWER_USER_ID"];//最新回答的用户ID
				ANSWER_USER_NAME=record["ANSWER_USER_NAME"];//最新回答的用户姓名
				ANSWER_USER_INTRODUCTION=record["ANSWER_USER_INTRODUCTION"];//最新回答的用户介绍
				
				if(IMAGE_PATH==null || IMAGE_PATH==undefined || IMAGE_PATH=="null"){
					IMAGE_PATH = "/images/main/rw_1.png";
				}
				IMAGE_PATH = path.basePath + IMAGE_PATH;
				
				content += "<div class='title'>";
				content += "  <div class='tit_tit'>";
				content += "    <div class='tit_tit_1'></div>";
				content += "    <div class='tit_tit_2' ><span><a href='"+path.user.detail+USER_ID+"'><img src='"+IMAGE_PATH+"' width='25' height='25'/></a></span><a href='"+path.problem.detail +PROBLEM_ID+"'>"+CONTENT+"</a></div>";
				content += "  </div>";
				// 有最新回答
				if(ANSWER_ID){
					var ANSWER_CONTENT_SHORT = "";
					if(ANSWER_CONTENT && ANSWER_CONTENT.length > 100){
						ANSWER_CONTENT_SHORT = ANSWER_CONTENT.substr(0, 97) + "...<a href='javascript:void(0);' onclick='showFullAnswerContent("+ANSWER_ID+");'>[显示全部]</a>";
					}else{
						ANSWER_CONTENT_SHORT = ANSWER_CONTENT;
					}
					content += "  <div class='tit_content'>";
					content += "	<div><b><a href='"+path.user.detail+ANSWER_USER_ID+"'>"+ANSWER_USER_NAME+"</a>，"+ANSWER_USER_INTRODUCTION+"</b></div>";
					content += "	<div>";
					content += "		<span id='DIV_ANSWER_"+ANSWER_ID+"'>"+ANSWER_CONTENT_SHORT+"</span>";
					content += "		<span id='DIV_ANSWER_FULL_"+ANSWER_ID+"' style='display:none;'>"+ANSWER_CONTENT+"</span>";
					content += "		<a href='"+path.problem.detail +PROBLEM_ID+"'>[更多]</a>";
					content += "	</div>";
					content += "</div>";
				}
				content += "  <div class='tit_bot'>";
				content += "    <div class='tit_bot_zl'>&nbsp;</div>";
				content += "    <div class='tit_bot_gz'>"+ANSWER_COUNT+" 个答案";
				if(IS_ATTENTION){
					content += "  		 • <span id='gz_sp_"+PROBLEM_ID+"'><label id='gz_"+PROBLEM_ID+"'>"+ATTENTION_COUNT+"</label>个关注</span>";
				}else{
					content += "  		 • <span id='gz_sp_"+PROBLEM_ID+"'><a href='javascript:void(0);' onclick='guanZhu("+PROBLEM_ID+")'><label id='gz_"+PROBLEM_ID+"'>"+ATTENTION_COUNT+"</label>个关注</a></span>";
				}
				if(IS_COLLECTION){
					content += "  		 • <span id='sc_"+PROBLEM_ID+"'>收藏</span>";
				}else{
					content += "  		 • <span id='sc_"+PROBLEM_ID+"'><a href='javascript:void(0);' onclick='shouCang("+PROBLEM_ID+")'>收藏</a></span>";
				}
				content += "  		 • <a href='javascript:void(0);'>分享到</a>";
				content += "  		 <img src='../images/ico_sina.gif' alt='新浪微博' width='16' height='16' hspace='2' align='absmiddle' style='cursor:pointer;' onclick='window.open('http://v.t.sina.com.cn/share/share.php?appkey=2684493555&url='+location)' />";
				content += "  		 <img src='../images/ico_qq_t.png' alt='腾讯微博' width='16' height='16' hspace='2' align='absmiddle'  style='cursor:pointer;' onclick='javascript:window.open('http://v.t.qq.com/share/share.php?url='+location)'/>";
				content += "  		<img src='../images/ico_msn.png' alt='MSN' width='16' height='16' hspace='2' align='absmiddle' style='cursor:pointer;' onclick='javascript:window.open('http://profile.live.com/Badge/?wa='+location)'/>";
				content += "  		 <img src='../images/ico_renren.gif' alt='人人网' width='16' height='16' hspace='2' align='absmiddle'style='cursor:pointer;' onclick='javascript:window.open('http://share.renren.com/share/buttonshare.do?link='+location)' />";
				content += "  		<img src='../images/ico_dou_16x16.png' alt='豆瓣' width='16' height='16' hspace='2' align='absmiddle' style='cursor:pointer;' onclick='javascript:window.open('http://www.douban.com/recommend/?url='+location+'&title=yunlab')'/>";
				content += "  		 <img src='../images/ico_kaixin.gif' alt='开心网' width='16' height='16' hspace='2' align='absmiddle' style='cursor:pointer;' onclick='javascript:window.open('http://www.kaixin001.com/repaste/share.php?rtitle=云计算&rurl='+location)'/>";
				content += "  	</div>";
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
 * 显示最新回答的全部内容
 */
function showFullAnswerContent(ANSWER_ID){
	var fullAnswer = $("#DIV_ANSWER_FULL_"+ANSWER_ID).html();
	$("#DIV_ANSWER_"+ANSWER_ID).html(fullAnswer);
}
