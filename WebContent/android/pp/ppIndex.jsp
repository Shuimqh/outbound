<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp"%>
<jsp:include page="../html5/Head.jsp" />
<TITLE>管理中心</TITLE>
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
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">品牌管理</span>  <a href="addPp.action" >新增</a>
		</div>
		<table width="760" border="0" cellpadding="0" cellspacing="1">

			<thead>
				<tr bgcolor="#A6B1A3">
					<td width="10%">
						<span class="style4"><strong>编号</strong> </span>
					</td>
					<td width="50%">
						<span class="style4"><strong>名称</strong> </span>
					</td>
					

					<td width="20%">
						<span class="style4"><strong>详细</strong> </span>
					</td>
					<td width="20%">
						<span class="style4"><strong>功能列表</strong>
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
							
							<a href="getPp.action?id=<s:property value="id" />" target="_blank" >查询</a>
						</td>
						<td>
							<a href="delPp.action?id=<s:property value="id" />">删除</a>
							<a href="editPp.action?id=<s:property value="id" />">修改</a>
							
						</td>
					</tr>
				</s:iterator>
				<tr align="right">
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
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">上一页</a>
						</s:else>
						<s:if test="currentPage==pager.getTotalPages()">
    		  下一页 尾页
    		  </s:if>
						<s:else>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">下一页</a>
							<a
								href="<s:url value="newsback.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">尾页</a>
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

