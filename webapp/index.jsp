<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="jsp/html5/top.jsp" %>
<jsp:include  page="jsp/html5/Head.jsp" /> 
	<TITLE>����Ա��¼</TITLE>
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
					<img src="images/u_b.gif" border="0" /><span class="bt">����Ա��¼</span>
		  		</div>
		  		<div>
		  			<div><s:property value="error" /></div>
		  		<s:form id="form1" action="finduser.action" method="post" name="">
		  			<table>
		  				<tr>
		  					<td>�� �� ��:</td><td><input  type="text" name="ub.byname"  maxlength="11" placeholder="�������û���"/></td>
		  				</tr>
		  				<tr>
		  					<td>�ܡ�����:</td><td><input  type="password"  name="ub.password"  maxlength="16"  placeholder="��������6-16����ĸ�����ֺͷ�����ɣ����ִ�Сд"/></td>
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
