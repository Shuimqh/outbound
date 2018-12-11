<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title><s:property value="cb.name" /> | 仪征志德叉车培训有限公司</title>
		<META name="keywords" content="" />
		<META name="description" content="" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	
	<section id="mainbody">
		<div>
			<div class="lr">
		  	 <img src="images/u_b.gif" border="0" /><span class="bt"><s:property value="cb.name" /></span>  
			</div>
			
			
			<div id="file" >	
						<s:property value="cb.jj"  escape="false" />
			</div>					
		</div>
	</section>   	 
   	 

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 