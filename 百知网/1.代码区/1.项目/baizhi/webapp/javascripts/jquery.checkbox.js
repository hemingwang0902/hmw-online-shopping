/**
 * 返回选中的数组
 */
$.fn.getCheckArrayValue=function(){
	var $checkedBoxs = $("table#datalist tr:gt(0)").find(">td:first :checkbox:checked");
	var Ids = [];
	$checkedBoxs.each(function(){
		Ids.push($(this).val());
	});
	return Ids;
}

/**
 * 返回选中的字符串，以","分隔
 */
$.fn.getCheckValue=function(){
	return $.fn.getCheckArrayValue().join(",");
}

/**
 * 将值设置到隐藏域中
 * param id 隐藏域ID
 */
$.fn.setCheckValue=function(id){
	return $("#"+id).val($.fn.getCheckValue());
}

/**
 * 设置全选择操作为未选中状态
 */
$.fn.setNoCheck=function(){
	return $("table#datalist tr:eq(0) :checkbox").attr("checked",false);
}

$(document).ready(function(){
	/**
	 * checkbox全选事件
	 */
	$("table#datalist tr:eq(0) :checkbox").click(function(){
		var checked = this.checked;
		var $checkedBoxs = $("table#datalist tr:gt(0)").find(">td:first :checkbox");
		$checkedBoxs.attr("checked",checked);
	});
});