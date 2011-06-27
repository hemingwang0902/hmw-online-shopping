<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百知网</title>
<link rel="stylesheet" type="text/css" href="../styles/style.css" />
<script type="text/javascript" src="../calendar/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="../javascripts/jquery-1.6.1.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.pagination.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.checkbox.js"></script>
<script type="text/javascript" language="javascript"  src="../javascripts/jquery.message.js"></script>
<script type="text/javascript" language="javascript"  src="userbasiclist.js"></script>
</head>
<body>
<div id="page_shadow" class="page_shadow"></div>
<div id="page_loading" class="page_loading"></div>
<div class="container">
	<div class="content">
		<div class="find_box">
			<div class="lightbox_header"><span class="font_span">查询条件</span></div>
			<form id="UserBasicList" >
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table">
		   			<tr>
						<td class="lightbox_title">用户基本信息ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="BASIC_ID" id="BASIC_ID" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">用户ID：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="USER_ID" id="USER_ID" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">用户类型(字典：1用户、2品牌)冗余字段：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="USER_TYPE" id="USER_TYPE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">姓名/品牌名称：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="NAME" id="NAME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">发源地(品牌特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="SOURCE" id="SOURCE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(省：地区信息表ID)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="PROVINCE" id="PROVINCE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在地区(市：地区信息表ID)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="CITY" id="CITY" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">从事行业(字典)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="INDUSTRY" id="INDUSTRY" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">所在年代(字典、用户特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="YEARS" id="YEARS" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">联系方式：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="LINK_MODE" id="LINK_MODE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">是否对外开放(0否、1是)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="IS_OPEN" id="IS_OPEN" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">个人介绍/品牌介绍：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="INTRODUCTION" id="INTRODUCTION" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">人生格言(用户特有)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="MOTTO" id="MOTTO" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">相片路径/LOGO路径：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="IMAGE_PATH" id="IMAGE_PATH" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">个性网址：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="WEBSITE" id="WEBSITE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">私信设置(字典：1所有人、2我关注的人)：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="PRIVATE_SET" id="PRIVATE_SET" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">级别：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="LEVEL" id="LEVEL" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">积分：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="SCORE" id="SCORE" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">备注：</td>
						<td class="lightbox_content"><input type="text" class="input_width3" name="REMARK" id="REMARK" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">创建时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="CREATE_TIME" id="CREATE_TIME" /> </td>
					</tr>
		   			<tr>
						<td class="lightbox_title">修改时间：</td>
						<td class="lightbox_content"><input type="text" class="input_width3 Wdate"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true})" name="MODIFY_TIME" id="MODIFY_TIME" /> </td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td style="padding-top:5px; padding-bottom:5px;">
							<input type="button"  value="查询"  class="button_box" onclick="getDataList()"/>
							<input  type="reset"  value="重置"  class="button_box" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="table_box">
			<div class="lightbox_header">
				<span class="font_span">用户基本信息表列表</span>
			</div>
			<div class="lightbox_opt">
				<input type="button"  value="新增" class="button_box" onclick="location.href='initUserBasicForm.go';"/>
				<input type="button"  value="删除" class="button_box" onclick="delData($.fn.getCheckValue())"/>
			</div>
			<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
			<div class="list_style">
				<table width="100%;" border="0" cellspacing="0" cellpadding="0" class="lightbox_table" id="datalist">
					<tr class="tr_bg">
						<td width="6%"><input type="checkbox" /></td>
						<td width="10%">操作</td>
		   				<td width="10%">用户基本信息ID</td>
		   				<td width="10%">用户ID</td>
		   				<td width="10%">用户类型(字典：1用户、2品牌)冗余字段</td>
		   				<td width="10%">姓名/品牌名称</td>
		   				<td width="10%">发源地(品牌特有)</td>
		   				<td width="10%">所在地区(省：地区信息表ID)</td>
		   				<td width="10%">所在地区(市：地区信息表ID)</td>
		   				<td width="10%">从事行业(字典)</td>
		   				<td width="10%">所在年代(字典、用户特有)</td>
		   				<td width="10%">联系方式</td>
		   				<td width="10%">是否对外开放(0否、1是)</td>
		   				<td width="10%">个人介绍/品牌介绍</td>
		   				<td width="10%">人生格言(用户特有)</td>
		   				<td width="10%">相片路径/LOGO路径</td>
		   				<td width="10%">个性网址</td>
		   				<td width="10%">私信设置(字典：1所有人、2我关注的人)</td>
		   				<td width="10%">级别</td>
		   				<td width="10%">积分</td>
		   				<td width="10%">备注</td>
		   				<td width="10%">创建时间</td>
		   				<td width="10%">修改时间</td>
					</tr>
				</table> 
			</div>   
		</div>
	</div>
</div>
</body>
</html>