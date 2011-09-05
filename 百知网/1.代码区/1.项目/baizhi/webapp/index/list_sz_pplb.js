var count;
/* 获取数据列表*/
function getDataList(){
	//删除原有记录
	$("#userbrandlist").html("");
	
	$.post("../userbrand/getUserBrandList.go",{},function(result){
		if(result==null||result==''){
			return;
		}
		var data = eval("("+result+")");
		var content = "";
		if (data != null && data["list"] != null && data["list"].length > 0) {
			
			var map;
			for(var i=0;i<data["list"].length;i++){
				map=data["list"][i];
				
				var STAUS_NAME="";
				if(map.STAUS==4){
					STAUS_NAME="审核未通过";
				}else if(map.STAUS==3){
					STAUS_NAME="审核通过";
				}else if(map.STAUS==2){
					STAUS_NAME="正在审核中";
				}else{
					STAUS_NAME="未提交申请";
				}
				
				content+="<div class='title_xgwt_x'>";
				content+="	<div class='title_xgwt_tu'><img height='74px' width='74px' src='"+data.cpath+map.IMAGE_PATH+"' onerror='load_brand_image_74_74(this)' /></div>";
				content+="	<div class='title_xgwt_xner'>";
				content+="		<ul>";
				content+="			<li class='tit'>"+map.NAME+"("+STAUS_NAME+")</li>";
				content+="			<li class='tit_con' style='line-height:20px;'>"+map.INTRODUCTION+"</li>";
				content+="		</ul>";
				content+="	</div>";
				content+="	<div class='title_xgwt_anniu'>";
				
				if(map.STAUS==1){
					content+="		<p><input type='button' value='编辑' onclick=\"location.href='../userbrand/getUserBrandById.go?BRAND_ID="+map.BRAND_ID+"';\" style='width:100px; height:25px; background-color:#dadade' /></p>";
					content+="		<p><input type='button' value='删除' onclick='delData("+map.BRAND_ID+")' style='width:100px; height:25px; background-color:#dadade' /></p>";	
				}else{
					content+="		<p><input type='button' value='查看' onclick=\"location.href='../userbrand/getUserBrandById.go?BRAND_ID="+map.BRAND_ID+"';\" style='width:100px; height:25px; background-color:#dadade' /></p>";
					
				}
				content+="	</div>";
				content+="	<div class='clear'></div>";
				content+="</div>";
			}
		}
		$("#userbrandlist").html(content);
	});
	return;
}

/* 删除数据*/
function delData(BRAND_ID){
	show_showmessage({message:"是否删除?",type:"error",callmethod:function(flag){
		if(flag){
			$.post("../userbrand/delUserBrand.go",{
				BRAND_ID:BRAND_ID
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
					show_showmessage({message:data["message"],type:"error"});
				}
			});
		}
	}});
	return;
}

$(document).ready(function(){
	//获取数据列表
	getDataList();
});  