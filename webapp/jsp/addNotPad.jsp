<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="html5/top.jsp" %>
<jsp:include  page="html5/Head.jsp" /> 
	<TITLE>�й��ƶ�ͨ��</TITLE>
		<META name="keywords" content="" />
		<META name="description" content="" />
		
	<jsp:include  page="html5/qeHead.jsp" /> 
	<div class="container">
		<div class="head">
   			<jsp:include  page="html5/header.jsp" /> 
   	 	</div>
   			
   	  	 	
	 <div class="p2">
   	  	<div class="lr">
		  	 			<img  src="images/u_b.gif" border="0" /><span class="bt">������Ϣ</span>
		</div>
		<s:form id="form_save" action="saveNotPad.action"  method="post" name="formT"  >
		
		<div>
		<table>
			<tr>
				<td>���ݣ�<s:textfield name="np.title"  size="100"/></td>
			</tr>
			<tr><td><input type="submit" name="butt" value="����" id="save"></td></tr>
		</table>
		
			
		</div>	
		
		</s:form>
   	  </div>	
  
	<jsp:include  page="html5/footer.jsp" /> 
<jsp:include  page="html5/foot.jsp" /> 

