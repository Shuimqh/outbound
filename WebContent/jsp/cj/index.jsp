<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>�ɼ��绰����</title>
		<META name="keywords" content="" />
		<META name="description" content="" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	<div class="head">
		
	</div>
	<section id="mainbody">
	<div class="lr">
			<img src="images/u_b.gif" border="0" /><span class="bt">
			<s:property value="type" />
			
			
			</span>
		  	</div>
		<table   width="100%" >
					<s:iterator value="list1" status="number">
					<tr>
						<td><s:property value="tel" /></td>
						
					</tr>				
     				</s:iterator>
     				<tr align="right" id="fy">
					<td colspan="9">
						��
						<s:property value="totalRows" />
						��&nbsp; ��
						<s:property value="currentPage" />
						ҳ&nbsp; ��
						<s:property value="pager.getTotalPages()" />
						ҳ&nbsp;

						<s:if test="currentPage==1">
    		   ��ҳ ��һҳ
    		   </s:if>
						<s:else>
							<a
								href="<s:url 

value="findtel.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">��ҳ</a>
							<a
								href="<s:url 

value="findtel.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    			
    		</s:url>">��һҳ</a>
						</s:else>
						<s:if 

test="currentPage==pager.getTotalPages()">
    		  ��һҳ βҳ
    		  </s:if>
						<s:else>
							<a
								href="<s:url 

value="findtel.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    			<s:param name="id2" value="s1"/>
    			
    		</s:url>">��һҳ</a>
							<a
								href="<s:url 

value="findtel.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    			
    			
    		</s:url>">βҳ</a>
						</s:else>
					</td>
				</tr>
				</table>
	</section>   	 
   	  <aside id="sidebar">
   	 
   	  </aside>  

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 