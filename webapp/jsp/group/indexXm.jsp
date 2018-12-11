<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>话务小组数据统计</title>
   
   
   
   <style type="text/css">
 .d1{
 	padding-left:50px;
 	}
  .d2{
 	 line-height:30px
 	}		
 .red{
 	color:#f37c33;
	
	font-size:15px;
 }
 .tab1{
 	margin-left: 60px; 
 	
 }
 .tr1{
	font-size: 20px;
	font-weight: bold;
	color: #515158;
	padding-bottom:20px;
}

.c_0528{
	padding-top:10px;
	height:40px;
	font-size:16px;
	border-style:dashed;
	border-color:#929292;
	border-top-width:0px;
	border-right-width:0px;
	border-left-width:0px;
	border-bottom-width:1px;
	color:#282726;
}
</style>
  <link href="css/index4.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/echarts-all.js"></script>


<link rel="stylesheet" href="js/date/bootstrap.min.css">
<link rel="stylesheet" href="js/date/font-awesome.min.css">
<link rel="stylesheet" href="js/date/bootstrapDatepickr-1.0.0.css">
<script src="js/date/jquery-1.7.2.min.js"></script>
<script src="js/date/bootstrap.min.js"></script>
<script src="js/date/bootstrapDatepickr-1.0.0.min.js"></script>

<script language="javascript">
function submit2(){   

    var fomr1=document.getElementById("form1");	
	
		fomr1.submit();				
}
</script>
<script>
	$(document).ready(function() {
		$("#calendar").bootstrapDatepickr();
		$("#calendar1").bootstrapDatepickr({date_format: "Y-m-d"});
		$("#calendar2").bootstrapDatepickr({date_format: "l, do F Y"});
		$("#calendar3").bootstrapDatepickr({date_format: "Y-m-d"});
	});
</script>


  </head>
  
  <body >
  <input type="hidden" id="p1"
									value="<s:property value="p1" />" name="p1">
	<input type="hidden" id="p2"
									value="<s:property value="p2" />" name="p2">
  	<div class="Top_Record">
	<div class="record_Top"><p>根据项目名称统计</p></div>
	</div>
	<div class="d1">
	  <s:form id="form1" action="findName.action" method="post" name="">
		<table width="70%" >
			<tr>
				<td width="30%">查询时间：</td>
				<td width="60%">
					<div class="row">
					<div class="col-md-4">
						<input type="text" id="calendar1" placeholder="查询时间" class="form-control" name="call.time1" value="<s:property value='call.time1' />">
					</div>
					</div>
				</td>
				<td  width="10%">
				<img border="0" src="images/search_button.gif"  width="60" height="30"
								 onclick="javaScript:submit2()" >
			</td>
			</tr>
		</table>
	   </s:form>
	   <table width="100%"  align="center">
		  		<tr>
		  			<td width="70%" class="tr1">项目名</td>
		  			<td width="30%" class="tr1">成交量</td>
		  		
		  		</tr>
		  		<tr><td class="c_0528">
			  		共：
			  		<s:property value="p1" />
			  		个项目
			  		
			  		</td>
			  		<td class="c_0528">
			  		成交：
			  		<s:property value="p2" />
			  		单
			  		</td>
			  		
			  	</tr>
		  		 <s:iterator value="list1" status="sta">
			  		<tr><td class="c_0528">
			  		
			  		<s:property value="Cname" />
			  		
			  		
			  		</td>
			  		<td class="c_0528"><s:property value="num" /></td>
			  		
			  	</tr>
		  		</s:iterator>
		  		
		  	</table>
	</div>
	
	
			
		
		
	  
  	
    
  </body>



</html>

