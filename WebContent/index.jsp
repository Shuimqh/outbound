<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="jsp/html5/top.jsp" %>
<jsp:include  page="jsp/html5/Head.jsp" /> 
	<TITLE>管理员登录</TITLE>
		<META name="keywords" content="" />
		<META name="description" content="" />		
		<style type="text/css">				
			
		</style>
		<script language="JavaScript">
function submit2(){	
 var fomr1=document.getElementById("form1");			
	fomr1.submit();	
}
</script>
	<jsp:include  page="jsp/html5/qeHead.jsp" /> 
	<div class="container">
		<div class="head">
   			<jsp:include  page="jsp/html5/header.jsp" /> 
   	 	</div>
   	 	
   	 	 <div>
   	 	 	<div class="">
   	 	 		 <div class="lr">
					<img src="images/u_b.gif" border="0" /><span class="bt">管理员登录</span>
		  		</div>
		  		<div>
		  			<div><s:property value="error" /></div>
		  		<s:form id="form1" action="finduser.action" method="post" name="">
		  			<table>
		  				<tr>
		  					<td>用 户 名:</td><td><input  type="text" name="ub.byname"  maxlength="11" placeholder="请输入用户名"/></td>
		  				</tr>
		  				<tr>
		  					<td>密　　码:</td><td><input  type="password"  name="ub.password"  maxlength="16"  placeholder="密码需由6-16个字母、数字和符号组成，区分大小写"/></td>
		  				</tr>
		  			</table>
		  			
			 			
	                    <div>
	                    	<img   src="images/t_34.gif" onclick="javaScript:submit2()"/>
	                    </div>
	                </s:form>	
				</div>
   	 	 	</div>	 	
		  	
   	 	</div>		
   	 </div>	
   	
	<jsp:include  page="jsp/html5/footer.jsp" /> 
<jsp:include  page="jsp/html5/foot.jsp" /> 
