<%@ page language="java"  pageEncoding="gbk"%>
<%@ include file="html5/top.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">≈‡—µœÓƒø</span>  
</div>
<s:iterator value="list2" status="number">
<div>
	
				<span>
					<a href="getPp.action?id=<s:property value="id" />" target="_blank" >
					<img src="kindeditor/attached/<s:property value="picsmall" /> " id="imager" width="180" height="90"/>
					</a>
				</span>	
				<span class="zy">					
					<ltdb:subString length="60"><s:property value="zy" /></ltdb:subString>
				</span>
	
</div>
</s:iterator>
	