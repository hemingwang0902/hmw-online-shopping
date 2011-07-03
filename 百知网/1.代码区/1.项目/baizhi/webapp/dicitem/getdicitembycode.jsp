<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css" />
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
</head>
<body>
<select id="dicitem" name="dicitem">
	<option selected="selected"></option>
</select>

</body>
</html>

<script type="text/javascript">

function loadSelect(id,codeVal){
	if(!$.trim(codeVal))return ;
	var code = "",check = 0;
	if(codeVal.indexOf(",") != -1){
		var arr = codeVal.split(",");
		code = arr[0];
		check = arr[1];
	}else {
		code = codeVal;
	}
	var url = "getDicitemByCode.go";
	var data = "CODE=" + code;
	$.get(url,data,function(response){
		var result = eval("("+response+")");
		var returnMapList = result.returnMapList;
		$("#" + id).empty();
		
		$(returnMapList).each(function(i){
			if(check!=0 && (i + 1) == check ){
					$("#" + id).append('<option value="' + this.DIC_CODE + '" selected="selected">' + this.DIC_NAME + '</option>');
			}else{
				  $("#" + id).append('<option value="' + this.DIC_CODE + '">' + this.DIC_NAME + '</option>');
			}
			
		});
	},"json");
	
}

$(function(){
	loadSelect("dicitem","LSL,2");
});
</script>