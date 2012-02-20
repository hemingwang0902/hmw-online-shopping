$(document).ready(function(){
	//高亮显示左侧导航的“通知设置”
	$("#setting_left_nav a:eq(3)").attr("href", "javascript:;").css("color", "#f00");
	
	$("input:checkbox[id^='SET_TYPE_']").click(function(){
		var values="";
		$("input:checkbox[id^='SET_TYPE_']").each(function(){
			if($(this).attr("checked")=="checked"){
				values+=(values==""?"1":",1")
			}else{
				values+=(values==""?"0":",0")
			}
			
		});
		var val1="";
		$("input:radio[name='SET_RADIO_TYPE']").each(function(){
			if($(this).attr("checked")=="checked"){
				val1=$(this).val();
			}
		});
		
		$("#values").val(values+","+val1);
	});
	
	$("input:radio[name='SET_RADIO_TYPE']").click(function(){
		var val1="";
		$("input:radio[name='SET_RADIO_TYPE']").each(function(){
			if($(this).attr("checked")=="checked"){
				val1=$(this).val();
			}
		});
		var values="";
		$("input:checkbox[id^='SET_TYPE_']").each(function(){
			if($(this).attr("checked")=="checked"){
				values+=(values==""?"1":",1")
			}else{
				values+=(values==""?"0":",0")
			}
			
		});
		$("#values").val(values+","+val1);
	});
	
	if($("#type").val()=="1"){
		show_showmessage({message:"提醒通知保存成功",type:"info"});
	}
	
});