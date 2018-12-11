<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title><s:property value="nb.title" /> | 树帜企业管理有限公司</title>
		<META name="keywords" content="<s:property value="nb.pictitle" />" />
		<META name="description" content="<s:property value="nb.file" />" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	

		<div>
		<div class="divtitle">			
			<s:property value="nb.title" />
		</div>
		<div id="sj">
			<s:property value="nb.createTime" />　　<s:property value="nb.source" />			
		</div>
		
		<div id="file" >
			
			
				<s:if test="nb.file2!=null && nb.file2!='' " >
					<s:property value="nb.file2"  escape="false" />
				</s:if><s:else>
					<s:property value="nb.file"  escape="false" />
				</s:else>
			
		
			
		
		</div>
	
						
		</div>
 	 
   	 

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 