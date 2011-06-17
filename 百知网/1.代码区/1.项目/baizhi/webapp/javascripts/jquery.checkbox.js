/**
 * ����ѡ�е�����
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
 * ����ѡ�е��ַ�������","�ָ�
 */
$.fn.getCheckValue=function(){
	return $.fn.getCheckArrayValue().join(",");
}

/**
 * ��ֵ���õ���������
 * param id ������ID
 */
$.fn.setCheckValue=function(id){
	return $("#"+id).val($.fn.getCheckValue());
}

/**
 * ����ȫѡ�����Ϊδѡ��״̬
 */
$.fn.setNoCheck=function(){
	return $("table#datalist tr:eq(0) :checkbox").attr("checked",false);
}

$(document).ready(function(){
	/**
	 * checkboxȫѡ�¼�
	 */
	$("table#datalist tr:eq(0) :checkbox").click(function(){
		var checked = this.checked;
		var $checkedBoxs = $("table#datalist tr:gt(0)").find(">td:first :checkbox");
		$checkedBoxs.attr("checked",checked);
	});
});