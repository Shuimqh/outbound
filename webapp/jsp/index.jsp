<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="html5/top.jsp" %>
<jsp:include  page="html5/Head.jsp" /> 
	<TITLE>中国移动通信</TITLE>
		<META name="keywords" content="" />
		<META name="description" content="" />
		<link rel="stylesheet" type="text/css" href="css/jcDate.css" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jQuery-jcDate.js" charset="GBK"></script>
<script type="text/javascript">
$(function (){
	$("input.jcDate").jcDate({					       
			IcoClass : "jcDateIco",
			Event : "click",
			Speed : 100,
			Left : 0,
			Top : 28,
			format : "-",
			Timeout : 100
	});
});

        </script>
	<jsp:include  page="html5/qeHead.jsp" /> 
	<div class="container">
		<div class="head">
   			<jsp:include  page="html5/header.jsp" /> 
   	 	</div>
   			
   	  	 	
	 <div class="p2">
   	  	<div class="lr">
		  	 			<img  src="images/u_b.gif" border="0" /><span class="bt">成交量查询</span>
		</div>
		<div>
		<table width="1200">
			<tr>
			
			<td>
			开始时间
			</td>
			<td>
			<input class="jcDate " name="xb.t1" value="<s:property value='xb.t1' />" style="width:200px; height:15px; line-height:10px; padding:4px;" />
			</td>
			<td>
			结束时间
			</td>
			<td>
			<input class="jcDate " name="xb.t2" value="<s:property value='xb.t2' />" style="width:200px; height:15px; line-height:10px; padding:4px;" />
			</td>
		</tr>
		</table>
		
			
				
			
		</div>	
   	  </div>	
  
	<jsp:include  page="html5/footer.jsp" /> 
<jsp:include  page="html5/foot.jsp" /> 

