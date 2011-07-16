$(document).ready(function(){
	loadChangeArea();
});

function loadChangeArea(){
	var change_area_content=""
	for(var i=0;i<data[0].list.length;i++){
		var list=data[0].list[i].childnode;
		change_area_content+="<li>";
		change_area_content+="	<span class='sub_title'><a href='javascript:;' onclick=\"changeCity('"+data[0].list[i].value+"','"+data[0].list[i].name+"');\">"+data[0].list[i].name+"</a></span>";
		change_area_content+="	<ul class='show_citys'>";
		if(list!=null&&list.length>0){
			for(var j=0;j<list.length;j++){
				change_area_content+="<li><a href='javascript:;' onclick=\"changeCity('"+list[j].value+"','"+list[j].name+"');\">"+list[j].name+"</a></li>&nbsp;";
			}
		}
		change_area_content+="	</ul>";
		change_area_content+="</li>";
	}
	$("#change_area_list").html(change_area_content);
}

function changeCity(value,name){
	$.post("changeCity.go",{
		CITY:value,
		CITY_NAME:name
	},function(result){
		parent.location.href="index/home.jsp";
		parent.$.fancybox.close();
	});
}