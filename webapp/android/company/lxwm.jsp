<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>��ϵ���� | ����־�²泵��ѵ���޹�˾</title>
		<META name="keywords" content="" />
		<META name="description" content="" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	
	<section id="mainbody">
		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">��ϵ����</span>  
		</div>
		
		
		<div class="lxwm">
			<table>
			<s:iterator value="list1" status="number">
				<tr>
					<td width="20%" ><s:property value="zw" /></td>
					<td width="20%"><s:property value="name" /></td>
					<td width="20%"><s:property value="tel" /></td>
				</tr>	
				
			</s:iterator>
			</table>
		</div>
		<div>
			<p class="title"> <s:property value="cyb.name" /></p>			
		
			<p> ��ַ��<s:property value="cyb.address" /></p>
		</div>
	</section>   	 
   	  

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 