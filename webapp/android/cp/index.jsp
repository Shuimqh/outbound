<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>��֤���� | ����־�²泵��ѵ���޹�˾</title>
		<META name="keywords" content="�����˷�" />
		<META name="description" content="�����˷�" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	
	<section id="mainbody">
	<div class="lr">
			<img src="images/u_b.gif" border="0" /><span class="bt">��֤����</span>
	</div>
		<table   width="100%" >
					<s:iterator value="list1" status="number">
					<tr>
						
						<td width="23%" class="c_0528">
							<img src="kindeditor/attached/<s:property value="picSmall" /> " id="imager" width="150" height="70"/>
						</td>
						<td  width="77%" class="c_0528">
							<table width="100%">
								<tr>
									<td class="ye4">
									<a href="getCp.action?id=<s:property value="id" />"  >	
										<ltdb:subString length="50">														
										<s:property value="name" />
										</ltdb:subString>
									</a>
									</td>
								</tr>
								<tr>
									<td class="file2">
													
													<a href="getCp.action?id=<s:property value="id" />"  ><font class="xxxx">[��ϸ��Ϣ]</font></a>
									</td>
								</tr>
								<tr>
									<td    align="right" > 
										<table class="news" width="40%" >
											<tr>
							
											<td><span class="date"><s:property value="timec" /></span></td>
											</tr>						
										</table>					
									</td>
								</tr>								
							</table>							
						</td>
						
						
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

value="product.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">��ҳ</a>
							<a
								href="<s:url 

value="product.action">
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

value="product.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    			<s:param name="id2" value="s1"/>
    			
    		</s:url>">��һҳ</a>
							<a
								href="<s:url 

value="product.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    			
    			
    		</s:url>">βҳ</a>
						</s:else>
					</td>
				</tr>
				</table>
	</section>   	 
   	   

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 