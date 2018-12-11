<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title><s:property value="type" /> | 树帜企业管理有限公司</title>
		<META name="keywords" content="树帜企业管理" />
		<META name="description" content="树帜企业管理有限公司" />
		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	
	
	<div class="lr">
			<img src="images/u_b.gif" border="0" /><span class="bt"><s:property value="type" /></span>
		  	</div>
		<table   width="100%" >
					<s:iterator value="list1" status="number">
					<tr>
						<s:if test="by2!=null && by2!='' " >
						<td width="23%" class="c_0528">
							<img src="kindeditor/attached/<s:property value="by2" /> " id="imager" width="100" height="70"/>
						</td>
						<td  width="77%" class="c_0528">
							<table width="100%">
								<tr>
									<td class="ye4">
									<a href="getNews.action?id=<s:property value="id" />"  >	
										<ltdb:subString length="38">														
										<s:property value="title" />
										</ltdb:subString>
									</a>
									</td>
								</tr>
								<tr>
									<td class="file2">
													<ltdb:subString length="40">
														<s:property value="file" />
													</ltdb:subString>
													<a href="getNews.action?id=<s:property value="id" />"  ><font class="xxxx">[详细信息]</font></a>
									</td>
								</tr>
								<tr>
									<td    align="right" > 
										<table class="news" width="60%" >
											<tr><td >栏目：<a href="moreLsNews.action?id2=<s:property value="type" />" ><span class="typetitle"><s:property value="by3" /></span></a></td>
							
											
											</tr>						
										</table>					
									</td>
								</tr>								
							</table>							
						</td>
						</s:if><s:else>
							<td  width="100%" class="c_0528" colspan="2" >
							<table width="100%" height="98">
								<tr>
									<td class="ye4">
									<a href="getNews.action?id=<s:property value="id" />" >	
										<ltdb:subString length="80">														
										<s:property value="title" />
										</ltdb:subString>
									</a>
									</td>
								</tr>
								<tr>
									<td class="file2">
													<ltdb:subString length="60">
														<s:property value="file" />
													</ltdb:subString>
													<a href="getNews.action?id=<s:property value="id" />"  ><font class="xxxx">[详细信息]</font></a>
									</td>
								</tr>
								<tr>
									<td    align="right" > 
										<table class="news" width="40%" >
											<tr><td >栏目：<span class="typetitle"><s:property value="by3" /></span></td>
							
											
											</tr>						
										</table>					
									</td>
								</tr>								
							</table>							
						</td>
						</s:else>
						
					</tr>				
     				</s:iterator>
     				<tr align="right" id="fy">
					<td colspan="9">
						共
						<s:property value="totalRows" />
						行&nbsp; 第
						<s:property value="currentPage" />
						页&nbsp; 共
						<s:property value="pager.getTotalPages()" />
						页&nbsp;

						<s:if test="currentPage==1">
    		   首页 上一页
    		   </s:if>
						<s:else>
							<a
								href="<s:url 

value="news.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
							<a
								href="<s:url 

value="news.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    			
    		</s:url>">上一页</a>
						</s:else><br>
						<s:if 

test="currentPage==pager.getTotalPages()">
    		  下一页 尾页
    		  </s:if>
						<s:else>
							<a
								href="<s:url 

value="news.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    			<s:param name="id2" value="s1"/>
    			
    		</s:url>">下一页</a>
							<a
								href="<s:url 

value="news.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    			
    			
    		</s:url>">尾页</a>
						</s:else>
					</td>
				</tr>
				</table>


	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 