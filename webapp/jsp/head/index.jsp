<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
	<TITLE>中国移动通信</TITLE>
		<META name="keywords" content="" />
		<META name="description" content="" />
		<script language="javascript">
function submit2(){   

    var fomr1=document.getElementById("form1");	
	
		fomr1.submit();				
}
</script>
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
	<jsp:include  page="../html5/qeHead.jsp" /> 
	<div class="container">
		<div class="head">
   			<jsp:include  page="../html5/header.jsp" /> 
   	 	</div>
   			
   	  	 	
	 <div class="p2">
   	  	<div class="lr">
		  	 			<img  src="images/u_b.gif" border="0" /><span class="bt">成交量查询</span>
		</div>
		<div>
		<s:form id="form1" action="dtdata.action" method="post" name="">
		<table width="1200">
			<tr>
			
				<td>
					开始时间
				</td>
				<td>
				<input class="jcDate " name="call.time1" value="<s:property value='call.time1' />" style="width:200px; height:15px; line-height:10px; padding:4px;" />
				</td>
				<td>
					结束时间
				</td>
				<td>
				<input class="jcDate " name="call.time2" value="<s:property value='call.time2' />" style="width:200px; height:15px; line-height:10px; padding:4px;" />
				</td>
			</tr>
			<tr><td></td>
			<td colspan="3">
				<img border="0" src="images/search_button.gif" 
								 onclick="javaScript:submit2()" >
			</td>
		</tr>
		
		
		</table>
		
		</s:form>	
		<table width="1200">
			<tr>
				<td>排名</td>
				<td>姓名</td>
				<td>接通量</td>
				<td>成交量</td>
				<td>成交率</td>
				<td>办成功</td>
			</tr>
			
			
			 <s:iterator value="list1" status="sta">
			 <tr>
				<td class="c_0528"><s:property value='{#sta.index+1}'/></td>
				<td class="c_0528"><s:property value="Cname" /></td>
				<td class="c_0528"><s:property value="numa" /></td>
				<td class="c_0528"><s:property value="num" /></td>
				<td class="c_0528"><s:property value="nums" /></td>
				<td class="c_0528"><s:property value="numss" /></td>
			</tr>
                
            </s:iterator>  
		</table>		
			
		</div>	
   	  </div>	
  
	<jsp:include  page="../html5/footer.jsp" /> 
<jsp:include  page="../html5/foot.jsp" /> 

