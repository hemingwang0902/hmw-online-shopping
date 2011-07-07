$(document).ready(function(){
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
	
	if($("#message").val()!=""){
		showmessage({message:$("#message").val(),type:"info"});
	}
	
});