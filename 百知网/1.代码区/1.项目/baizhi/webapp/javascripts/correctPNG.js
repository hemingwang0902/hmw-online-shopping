$(document).ready(function() {
	// correctly handle PNG transparency in Win IE 5.5 & 6. 
	var arVersion = navigator.appVersion.split("MSIE")
	var version = parseFloat(arVersion[1])
	if ((version >= 5.5) && (document.body.filters)) {
		for ( var j = 0; j < document.images.length; j++) {
			var img = document.images[j]
			var imgName = img.src.toUpperCase()
			if (imgName.substring(imgName.length - 3, imgName.length) == "PNG") {
				var imgID = (img.id) ? "id='" + img.id + "' " : ""
				var imgClass = (img.className) ? "class='" + img.className + "' " : ""
				var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
				var imgStyle = "display:inline-block;" + img.style.cssText
				if (img.align == "left")
					imgStyle = "float:left;" + imgStyle
				if (img.align == "right")
					imgStyle = "float:right;" + imgStyle
				if (img.parentElement.href)
					imgStyle = "cursor:hand;" + imgStyle
				var strNewHTML = "<span " + imgID + imgClass + imgTitle + " style=\""
						+ "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
						+ "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src=\'" + img.src
						+ "\', sizingMethod='scale');\"></span>"
				img.outerHTML = strNewHTML
				j = j - 1
			}
		}
	}
});

//25*25 尺寸 头像
function load_person_image_25_25(obj){
	obj.src='../images/main/rw_1.png';
}

//74*74 尺寸 头像
function load_person_image_74_74(obj){
	obj.src='../images/main/rw_1.png';
}

//102*102 尺寸 头像
function load_person_image_102_102(obj){
	obj.src='../images/main/rw_1.jpg';
}

//60*53 尺寸 品牌
function load_brand_image_60_53(obj){
	obj.src='../images/main/xner.jpg';
}

//74*74 尺寸 品牌
function load_brand_image_74_74(obj){
	obj.src='../images/main/xner.jpg';
}

//100*100 尺寸 品牌
function load_brand_image_100_100(obj){
	obj.src='../images/main/google.jpg';
}