<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>企业简介 | 仪征志德叉车培训有限公司</title>
		<META name="keywords" content="" />
		<META name="description" content="" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	
	
		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">企业简介</span>  
		</div>
		<div class="jyfw">
			<ltdb:text2html><s:property value="cyb.jj" /></ltdb:text2html>
		</div>
		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">经营范围</span>  
		</div>
		<div class="jyfw">
			<ltdb:text2html><s:property value="cyb.jyfw" /></ltdb:text2html>
		</div>
		 
   	  

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 