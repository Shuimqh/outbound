<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp"%>
<jsp:include page="../html5/Head.jsp" />
<TITLE>��������</TITLE>
<META name="keywords" content="" />
<META name="description" content="" />
<style type="text/css">
</style>

<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
   	<div>   	
   	<div class="left">
					<jsp:include page="../left.jsp" />
				</div>
	<div class="right">
   		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">Ʒ�ƹ���</span>  <a href="addPp.action" >����</a>
		</div>
		<table width="760" border="0" cellpadding="0" cellspacing="1">

			<thead>
				<tr bgcolor="#A6B1A3">
					<td width="10%">
						<span class="style4"><strong>���</strong> </span>
					</td>
					<td width="50%">
						<span class="style4"><strong>����</strong> </span>
					</td>
					

					<td width="20%">
						<span class="style4"><strong>��ϸ</strong> </span>
					</td>
					<td width="20%">
						<span class="style4"><strong>�����б�</strong>
						</span>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="number" value="0"></c:set>
				<s:iterator value="list1" status="number">
					<c:set var="number" value="${number + 1 }"></c:set>
					<tr
						style="background-color:<s:if test='#number.index%2==0'>#FFFFFF</s:if><s:else>#e6e6e6</s:else>">
						<td align="center">
							${number}
							<input type="hidden" name="id" value="<s:property value="id" />" />
						</td>
						<td>
							<ltdb:subString length="10"><s:property value="name" /></ltdb:subString>
						</td>
						
						<td>
							
							<a href="getPp.action?id=<s:property value="id" />" target="_blank" >��ѯ</a>
						</td>
						<td>
							<a href="delPp.action?id=<s:property value="id" />">ɾ��</a>
							<a href="editPp.action?id=<s:property value="id" />">�޸�</a>
							
						</td>
					</tr>
				</s:iterator>
				<tr align="right">
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
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">��ҳ</a>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">��һҳ</a>
						</s:else>
						<s:if test="currentPage==pager.getTotalPages()">
    		  ��һҳ βҳ
    		  </s:if>
						<s:else>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">��һҳ</a>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">βҳ</a>
						</s:else>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" id="hid"
									value="news" name="type">
			<div
				style="top:0;left:0;width:560;height:120;overflow-y:auto;border:0px;position:absolute;">
				<form id="form" action="2" method="post" name="form"/>
				
			</div>
		
		
		</div>
	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 

