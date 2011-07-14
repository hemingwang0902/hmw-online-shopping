$(document).ready(function(){
	//添加关注
	$("#a_attention").one("click", function(){
		$.get(path.problem.attention + $("#problemId").val(), function(){
			$(this).parent().css({"background-color":"#555555"});
		});
	}); 

	//添加收藏
	$("#a_collection").one("click", function(){
		$.get(path.problem.collection + $("#problemId").val(), function(){
			$(this).parent().css({"background-color":"#555555"});
		});
	}); 
	
});
