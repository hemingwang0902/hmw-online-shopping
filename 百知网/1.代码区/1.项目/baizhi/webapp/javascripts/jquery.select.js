/**
 *初始化省市下拉框
 *id1 id值
 *id2 id值
 *isRequired  是否必输,true为必输,false为非必输
 *selectValue1 选择值
 *selectValue2 选择值
 */
function initSelect(id1,id2,_isRequired,selectValue1,selectValue2){
	isRequired=_isRequired;
	//如果非必输项，则第一值加载为空
	var loadindex=0;
	var start=0;
	if(!isRequired){
		document.getElementById(id1).options[start]=new Option("", "");
		start++;
		loadindex=-1;
	}
	//加载第一个下拉框
	for(var i=0;i<data[0].list.length;i++){
		document.getElementById(id1).options[start] =new Option(data[0].list[i].name, data[0].list[i].value);
		if(data[0].list[i].value==selectValue1){
			document.getElementById(id1).options[start].selected = true;
			loadindex=start;
		}
		start++;
	}

	//如果非必输项，则第二值加载为空 
	start=0;
	if(!isRequired){
		document.getElementById(id2).options[start]=new Option("", "");
		start++;
	}
	if(loadindex!=-1){
		var list=data[0].list[loadindex].childnode;
		//加载第二个下拉框
		for(var i=0;i<list.length;i++){
			document.getElementById(id2).options[start] =new Option(list[i].name, list[i].value);
			if(list[i].value==selectValue2){
				document.getElementById(id2).options[start].selected = true;  
			}
			start++;
		}
	}
}

/*
 * 第二个下拉框change事件
 * loadindex  索引
 * isRequired 是否必输,true为必输,false为非必输
 * obj        加载对象
 * */
function setSelectValue(loadindex,isRequired,obj){
	obj.options.length=0;
	var start=0;
	if(!isRequired){
		obj.options[start]=new Option("", "");
		start++;
		loadindex--;
	}
	if(loadindex>=0){
		var list=data[0].list[loadindex].childnode;
		//加载第二个下拉框
		for(var i=0;i<list.length;i++){
			obj.options[start] =new Option(list[i].name, list[i].value);
			start++;
		}
	}
}