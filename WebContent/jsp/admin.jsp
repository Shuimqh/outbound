<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="html5/top.jsp" %>
<jsp:include  page="html5/Head.jsp" /> 
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
	<jsp:include  page="html5/qeHead.jsp" /> 
	<div class="container">
		<div class="head">
   			<jsp:include  page="html5/header.jsp" /> 
   	 	</div>
   	 	
   	 	 <div>
   	 	 	<div class="">
   	 	 		 <div class="lr">
					<img src="images/u_b.gif" border="0" /><span class="bt">����Ա��¼</span>
		  		</div>
		  		<div>
		  			<div><s:property value="error" /></div>
		  		<s:form id="form1" action="finduser.action" method="post" name="">
			 		<p>
	                      <span class="signup_lb">�� �� ��</span>
	                    <input id="txt_mobile" type="text" name="ub.byname" class="J-validate signup_txt" validate-name="_mobile" validate-type="mobileExist" maxlength="11" placeholder="�������û���"/>
	                     <span id="tel"></span>
	          		</p>                
						
	                    <p>
	                        <span class="signup_lb">�ܡ�����</span>
	                        <input id="txt_newpwd" type="password"  name="ub.password"  maxlength="16" class="J-validate signup_txt" validate-name="_password" validate-type="newpwd" placeholder="��������6-16����ĸ�����ֺͷ�����ɣ����ִ�Сд"/>    
	                   		<span id="password"></span>
	                    </p>	
	                    <p>
	                    	<img   src="images/t_34.gif" onclick="javaScript:submit2()"/>
	                    </p>
	                </s:form>	
				</div>
   	 	 	</div>	 	
		  	
   	 	</div>		
   	 </div>	
   	
	<jsp:include  page="html5/footer.jsp" /> 
<jsp:include  page="html5/foot.jsp" /> 
