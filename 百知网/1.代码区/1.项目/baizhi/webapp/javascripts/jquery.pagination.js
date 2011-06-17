var method;
function pagination(nowPage,onePageCount,totalcount,datalist,callmethod){
	
	if(totalcount==null||totalcount==''){
		totalcount=0;
	}else if(totalcount!=''&&datalist==''){
		totalcount=0;
	}
	
	//定义分页文本
	var content="";
	//计算总页数
	var totalpage=parseInt((totalcount/onePageCount))+((totalcount%onePageCount)>0?1:0);
	method=callmethod;
	
	//显示文本
	content+="<div style='float:left; padding:3px 0 0 5px;'>查询结果："+totalcount+"条</div>";
	content+="<div style='float:left; padding:3px 0 0 5px;'>["+nowPage+"/"+totalpage+"]</div>";
	content+="<div style='float:left;'>";
	if(nowPage==1){
		//首页
		content+="<span class='none_link prev' id='start'>首页</span>";
		//上一页
		content+="<span class='none_link prev' id='prev'>上一页</span>";
	}else{
		//首页
		content+="<a href='javascript:void(0);' class='prev' onclick=\"currpage('1','"+onePageCount+"')\">首页</a>";
		//上一页
		content+="<a href='javascript:void(0);' class='prev' onclick=\"pervpage('"+nowPage+"','"+onePageCount+"')\">上一页</a>";
	}
	content+="</div>";
	
	//计算显示链接开始、终止值
	var starthref=0;
	var endhref=0;
	var counthref=5;
	if(parseInt(nowPage%5)!=0){
		starthref=(parseInt(nowPage/5)*5)+1;
	}else{
		starthref=(parseInt(nowPage/5)-1)*5+1;
	}
	if(parseInt(nowPage%5)!=0){
		endhref=(parseInt(nowPage/5)+1)*5;
		if(endhref>totalpage){
			endhref=totalpage;
		}
	}else{
		endhref=nowPage;
	}
	
	content+="<div style='float:left;'>";
	
	//上一页
	if(starthref!=1){
		content+="<a href='javascript:void(0);' class='prev' onclick=\"currpage('"+((parseInt(starthref/5)-1)*5+1)+"','"+onePageCount+"')\">...</a>";
	}
	content+="</div>";
	
	content+="<div style='float:left;'>";
	
	
	//显示链接
	for(var i=starthref ;i<=endhref ;i++){
		if(i==nowPage){
			content+="<span class='current'>"+i+"</span>";
		}else{
			content+="<a href='javascript:void(0);' onclick=\"currpage('"+i+"','"+onePageCount+"')\" >"+i+"</a>";
		}
	}
	content+="</div>";
	
	content+="<div style='float:left;'>";
	
	
	//下一页
	if(endhref<totalpage){
		content+="<a href='javascript:void(0);' class='next' onclick=\"currpage('"+(parseInt(endhref)+1)+"','"+onePageCount+"')\">...</a>";	
	}
	content+="</div>";
	
	content+="<div style='float:left;'>";
	
	
	if(nowPage>=totalpage){
		//下一页
		content+="<span class='none_link next' id='next'>下一页</span>";	
		//尾页
		content+="<span class='none_link next' id='end'>尾页</span>";
	}else{
		//下一页
		content+="<a href='javascript:void(0);' class='next' onclick=\"nextpage('"+nowPage+"','"+onePageCount+"')\">下一页</a>";
		//尾页
		content+="<a href='javascript:void(0);' class='next' onclick=\"currpage('"+totalpage+"','"+onePageCount+"')\">尾页</a>";
	}
	content+="</div>";
	
	content+="<div style='float:left;'>";
	
	
	//每页显示多少条
	content+="<span style='padding:3px 0 0 5px;'>每页显示</span>";
	if(onePageCount==10){
		content+="<span class='current'>10</span>";
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','20')\">20</a>" ;
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','50')\">50</a>" ;
	}else if(onePageCount==20){
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','10')\">10</a>" ;
		content+="<span class='current'>20</span>";
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','50')\">50</a>" ;
	}else if(onePageCount==50){
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','10')\">10</a>" ;
		content+="<a href='javascript:void(0);' onclick=\"currpage('1','20')\">20</a>" ;
		content+="<span class='current' >50</span>";
	}
	content+="<span style='padding:3px 0 0 5px;'>条</span>";
	content+="</div>";
	
	content+="<div style='float:left;'>";
	
	
	$("#Pagination_content").html(content);
	$("#datalist").append(datalist);
}

function currpage(nowPage,onePageCount){
	$("#nowPage").val(nowPage);
	$("#onePageCount").val(onePageCount);
	method();
}
function pervpage(nowPage,onePageCount){
	$("#nowPage").val((parseInt(nowPage)-1));
	$("#onePageCount").val(onePageCount);
	method();
}
function nextpage(nowPage,onePageCount){
	$("#nowPage").val((parseInt(nowPage)+1));
	$("#onePageCount").val(onePageCount);
	method();
}
function currcount(obj){
	$("#nowPage").val(1);
	$("#onePageCount").val(obj.options[obj.selectedIndex].value);
}

$(document).ready(function(){
	var content="";
	content+="<div id='Pagination_all' class='height:100%;'>";
	content+="	<div style='float:left;'>";
	content+="		<input id='onePageCount' name='onePageCount' value='10' type='hidden'/>";
	content+="		<input id='nowPage' name='nowPage' value='1' type='hidden'/>";
	content+="	</div>";
	content+="	<div style='float:left;' id='Pagination_content'></div>";
	content+="</div>";		
	$("#Pagination").html(content);
});


