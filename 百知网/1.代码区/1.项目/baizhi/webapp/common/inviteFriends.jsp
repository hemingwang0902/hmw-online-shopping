<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 邀请好友 -->
<div class="r_column">
	<div class="column"><a href="javascript:void(0);">邀请好友</a></div>
	<div class="column_content">
		<div class="coulumn_c_left">
			<ul>
				<li><a href="invite.jsp">发送邮件邀请好友</a></li>
				<li>
					<div id="d_clip_container" style="position:relative"> 
						<input id="invite" type="hidden" value="${basePath }/regiest.jsp?USER_ID=${USER_ID_ENCODE}">
	                  	<a id="d_clip_button" href="javascript:void(0);">生成代码邀请好友</a>
					</div> 
				</li>
			</ul>
		</div>
		<div class="coulumn_c_right"><img src="../images/main/youjian.png" /></div>	
	</div>
</div>