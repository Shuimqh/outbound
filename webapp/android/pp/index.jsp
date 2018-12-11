<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title><s:property value="pb.name" /> | 仪征志德叉车培训有限公司</title>
		<META name="keywords" content="仪征志德叉车" />
		<META name="description" content="仪征志德叉车" />
		<style type="text/css">		
		.news{
		font-size: 14px;
		}
		.header{width:100%;margin:0 auto;font-size: 14px;font-family:\5fae\8f6f\96c5\9ed1;text-align: left;}
		.header .tit{width:100%;overflow: hidden;}
		.header .tit1{margin:10px 0 40px;font-size: 46px;color:#346890;font-weight: bold;float: left;}
		.header .tit1 span{font-weight: normal;padding:0 10px;}
		.header .tit2{width:1px;height: 40px;overflow: hidden;font-size: 0;float: left;margin:18px 16px 0;background: #346890;}
		.header .tit3{float: left;margin-top:0px;}
		.header .tit3 p{line-height: 18px;color:#346890;font-weight: bold;}
		.header .con{width:80%;overflow: hidden;clear: both;}
		.header .con_l{float: left;background: url(images/icon1.gif) no-repeat;width:44px;height: 24px;line-height: 24px;padding-left:6px;color:#fff;margin:8px 16px 0 0;}
		
		.red20{
		font-size:2em;
		}
		 #thenceThen{font-size:2em;}
		</style>
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	<div class="header">
		<div class="tit">
		<div class="tit1"><s:property value="pb.name" /></div>
		
		</div>
		<div class="con">
			<div class="con_l">摘 要</div>
			<div class="con_r"><s:property value="pb.zy" /></div>
		</div>
	　</div>
	<section id="mainbody">
	<div class="lr">
			<img src="images/u_b.gif" border="0" /><span class="bt"><s:property value="pb.name" />产品</span>
	</div>
		<table   width="100%" >
					<s:iterator value="list1" status="number">
					<tr>
						
						<td width="40%" class="c_0528">
							<img src="kindeditor/attached/<s:property value="picSmall" /> " id="imager" width="300" height="98"/>
						</td>
						<td  width="60%" class="c_0528">
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
													
													<a href="getCp.action?id=<s:property value="id" />"  ><font class="xxxx">[详细信息]</font></a>
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

value="getPp.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
							<a
								href="<s:url 

value="getPp.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    			
    		</s:url>">上一页</a>
						</s:else>
						<s:if 

test="currentPage==pager.getTotalPages()">
    		  下一页 尾页
    		  </s:if>
						<s:else>
							<a
								href="<s:url 

value="getPp.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    			<s:param name="id2" value="s1"/>
    			
    		</s:url>">下一页</a>
							<a
								href="<s:url 

value="getPp.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    			
    			
    		</s:url>">尾页</a>
						</s:else>
					</td>
				</tr>
				</table>
	</section>   	 
   	 

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 