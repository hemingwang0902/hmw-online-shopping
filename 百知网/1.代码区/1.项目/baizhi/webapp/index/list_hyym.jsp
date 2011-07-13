<%--会员页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" src="index.js"></script>
	<script type="text/javascript" src="list_hyym.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
	<input type="hidden" id="userId" value="<s:property value="userId"/>">
<div class="content">
	<div class="c_left">
		<%@include file="../common/search.jsp" %>
      <div class="subMenu_hyym">
      </div>
      <div class="line_1"></div>
      <div class="title_xgwt" style="border:0;">
        <div class="title_xgwt_tu"><img src="../images/main/rw_1.jpg" width="100" height="100" /></div>
        <div class="title_xgwt_xner">
        	<ul>
            	<li class="tit"><a href="#">Thyme</a></li>
                <li class="tit_con">电信行业的我，如何进入互联网行业公司工作</li>
            </ul>
        </div>
        <div class="clear"></div>
      </div>
      <div class="wtym_tjda">
          <div class="tit_hyym">问易晓杰一个问题（仅他能回答）</div>
          <div class="tit_wtym_daan"><textarea cols="0" rows="0" style="width:540px; height:130px;"></textarea>
          </div>
          <div class="tit_hyym_anniu"><input name="" type="button" style="width:107px;" value=""  class="bot_xttw" /></div>
      </div>
      <div class="tit_hyym_twwt">
      		<ul>
            	<li><a href="#">他问过的问题</a></li>
                <li><a href="#">他回答的问题</a></li>
            </ul>
      </div>
      <div id="divList">
      </div>
      <div class="tiao"><a href="#">更多 &gt;&gt;</a></div>
  </div>
    
    
    <div class="c_right">
    	<div class="right_subMenu">
            <ul>
                <li><a href="#">添加关注</a></li>
                <li><a href="#">给他发私信</a></li>
            </ul>
        </div>
        <div class="r_column">
            <div class="column"><a href="#">会员搜索</a></div>
            <div class="column_hyym">
                <input name="text" type="text" value="请输入关键字" size="" style="height:22px; float:left; color:#999; padding-top:5px;  padding-left:5px; width:130px;" onfocus="javascript:this.value='';" onblur="javascript:this.value='请输入关键字';"/>  
	    <input type="button" class="bot_hyss" value=""  style=" bottom:0px; float:right;" />
            </div>
        </div>
        <div class="r_column">
            <div class="column">关注的话题</div>
          <div class="column_hyym_1">
              <div class="title_hyym">
        	<ul>
            	<li class="tit"><a href="#">Thyme</a></li>
                <li class="tit_con">电信行业的我，如何进入互联网行业公司工作</li>
            </ul>
        </div>
        <div class="title_hyym_anniu">
          <input name="" type="button" value="取&nbsp;消" style="width:55px; height:25px; background-color:#dadade" />
        </div>
        <div class="clear"></div>
          </div>
          <div class="column_hyym_1">
              <div class="title_hyym">
        	<ul>
            	<li class="tit"><a href="#">Thyme</a></li>
                <li class="tit_con">电信行业的我，如何进入互联网行业公司工作</li>
            </ul>
        </div>
        <div class="title_hyym_anniu">
          <input name="" type="button" value="取&nbsp;消" style="width:55px; height:25px; background-color:#dadade" />
        </div>
        <div class="clear"></div>
          </div>
          <div class="column_hyym_1" style="border:0; margin-bottom:0px;">
              <div class="title_hyym">
        	<ul>
            	<li class="tit"><a href="#">Thyme</a></li>
                <li class="tit_con">电信行业的我，如何进入互联网行业公司工作</li>
            </ul>
        </div>
        <div class="title_hyym_anniu">
          <input name="" type="button" value="取&nbsp;消" style="width:55px; height:25px; background-color:#dadade" />
        </div>
        <div class="clear"></div>
          </div>
          <div class="more"><a href="#">更多 &gt;&gt;</a></div>
        </div>
        <div class="r_column">
            <div class="column">关注的人</div>
            <div class="column_wtzt">关注他的人（15）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
               
              </ul>
          </div>
          <div class="column_wtzt">他关注的人（15）</div>
            <div class="column_xgwt_hy">
              <ul>
              	<li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                <li><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a><a href="#" class="tooltips"><img src="../images/main/hy_2.jpg" /><span>百知2</span></a><a href="#" class="tooltips"><img src="../images/main/hy_1.jpg" alt="枫叶" /><span>百知1</span></a></li>
                
              </ul>
          </div>
        </div>
        <%@include file="../common/attentionBrands.jsp" %>
    </div>
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
