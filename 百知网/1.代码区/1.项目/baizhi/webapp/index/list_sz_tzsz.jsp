<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="../common/jsCss.jsp" %>
	<script type="text/javascript" language="javascript" src="../index/list_sz_tzsz.js"></script>
</head>

<body>
	<%@include file="../common/head.jsp" %>
<div class="content">
<div class="c_right_1">
  <div class="r_column">
          <div class="column_sz">设置选项</div>
          <div class="list_sz">
          	<ul>
            	<li><a href="../sz/initSzForm.go">基本资料</a></li>
            	<s:if test="#session.userinfo.USER_TYPE==2">
            	<li><a href="../index/list_sz_pplb.jsp" >品牌资料</a></li>
            	</s:if>
            	
                <li><a href="../index/list_sz_zhsz.jsp">账户设置</a></li>
                <li style="background-color:#CCDBA2;"><font color="#FF6633"><a href="javascript:;">通知设置</a></font></li>
            </ul>
          </div>
    </div>
  </div>
	<div class="c_left">
	<form action="../usernotice/saveUserNotice.go" method="post">
	<input type="hidden" id="values" name="values" value="${returnMap.values }" /> 
	<input type="hidden" id="message" value="${message }" />
	
	  <div class="list_xgwt_xght_sz">
	    请选择提醒通知
	  </div>
      <div class="line_1"></div>
      <div class="list_sz_tzsz">
      <s:if test="returnMap.SET_TYPE_1==1">
      	<input type="checkbox" checked="checked" id="SET_TYPE_1" />&nbsp;有人关注了我<br />
      </s:if>
      <s:else>
      	<input type="checkbox"  id="SET_TYPE_1" />&nbsp;有人关注了我<br />
      </s:else>
      <s:if test="returnMap.SET_TYPE_2==1">
      	<input type="checkbox" checked="checked" id="SET_TYPE_2" />&nbsp;有人问了我一个问题<br />
      </s:if>
      <s:else>
      	<input type="checkbox"  id="SET_TYPE_2" />&nbsp;有人问了我一个问题<br />
      </s:else>
      <s:if test="returnMap.SET_TYPE_3==1">
      	<input type="checkbox" checked="checked" id="SET_TYPE_3" />&nbsp;有人邀请我回答一个问题<br />
      </s:if>
      <s:else>
      	<input type="checkbox"  id="SET_TYPE_3" />&nbsp;有人邀请我回答一个问题<br />
      </s:else>
      <s:if test="returnMap.SET_TYPE_4==1">
      	<input type="checkbox" checked="checked" id="SET_TYPE_4" />&nbsp;我关注的问题有了新答案<br />
      </s:if>
      <s:else>
      	<input type="checkbox"  id="SET_TYPE_4" />&nbsp;我关注的问题有了新答案<br />
      </s:else>
      <s:if test="returnMap.SET_TYPE_5==1">
      	<input type="checkbox" checked="checked" id="SET_TYPE_5" />&nbsp;有人关注了我的品牌<br />
      </s:if>
      <s:else><input type="checkbox" id="SET_TYPE_5" />&nbsp;有人关注了我的品牌<br />
      	
      </s:else>
        
        
        
        
      </div>
      <div class="list_xgwt_xght_sz">
	    设置谁可以给我发私信
	  </div>
      <div class="line_1"></div>
      <div class="list_se_bcsz_1">
      <s:if test="returnMap.SET_TYPE_6==3">
      	<input name="SET_RADIO_TYPE"  type="radio" value="3" checked="checked" />所有人&nbsp;<input name="SET_RADIO_TYPE"  type="radio" value="4" />我关注的人
      </s:if>
      <s:else>
      	<input name="SET_RADIO_TYPE"  type="radio" value="3"  />所有人&nbsp;<input name="SET_RADIO_TYPE"  type="radio" value="4" checked="checked"/>我关注的人
      </s:else>
   	  </div>
      <div class="list_sz_zhsz_bcsz">
        <input name="input" type="submit" class="list_sz_bcmm" value="保存"/>
      </div>
       </form>
  </div>
 
	<div class="clear"></div>
</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>
