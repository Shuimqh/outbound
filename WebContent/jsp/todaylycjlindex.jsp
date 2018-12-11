<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>成功量报表</title>
 <style type="text/css">
 .title{
 	font-size: 25px;
	color: #000000;
	padding-bottom:30px;
	font-weight: bold;
 }
	.hh{
	font-size: 18px;
	color: #1D991D;
	padding-left:10px;
	font-weight: bold;
	padding-bottom:20px;
	}

.dd {
	
		font-size:14px;
	border-style:dashed;
	border-color:#929292;
	border-top-width:0px;
	border-right-width:0px;
	border-left-width:0px;
	border-bottom-width:1px;
	color:#282726;
	height:40px;
	}
</style>
<link rel="stylesheet" href="js/date/bootstrap.min.css">
<link rel="stylesheet" href="js/date/font-awesome.min.css">
<link rel="stylesheet" href="js/date/bootstrapDatepickr-1.0.0.css">
<script src="js/date/jquery-1.7.2.min.js"></script>
<script src="js/date/bootstrap.min.js"></script>
<script src="js/date/bootstrapDatepickr-1.0.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#calendar").bootstrapDatepickr();
		$("#calendar1").bootstrapDatepickr({date_format: "Y-m-d"});
		$("#calendar2").bootstrapDatepickr({date_format: "l, do F Y"});
		$("#calendar3").bootstrapDatepickr({date_format: "Y-m-d"});
	});
</script>
<script language="javascript">
function submit2(){   

    var fomr1=document.getElementById("form1");	
	
		fomr1.submit();				
}
</script>
  </head>
  
  <body style="text-align:center;">
  <table align="center">
  	<tr><td  class="title">话务组统计报表</td></tr>
  </table>
  
  
  
  <s:form id="form1" action="todayLyCjl.action" method="post" name="">
		<table width="1200">
			<tr>
			
				<td width="10%">
					开始时间
				</td>
				<td  width="30%">
				<div class="row">
					<div class="col-md-4">
						<input type="text" id="calendar1" placeholder="开始时间" class="form-control" name="call.time1" value="<s:property value='call.time1' />">
					</div>
				</div>
				<!-- <input class="jcDate " name="call.time1" value="<s:property value='call.time1' />" style="width:200px; height:30px; line-height:10px; padding:4px;" />
				 -->
				</td>
				<td  width="10%">
					结束时间
				</td>
				<td width="30%">
				<div class="row">
					<div class="col-md-4">
						<input type="text" id="calendar3" placeholder="结束时间" class="form-control" name="call.time2" value="<s:property value='call.time2' />">
					</div>
				</div>
				<!--  <input class="jcDate " name="call.time2" value="<s:property value='call.time2' />" style="width:200px; height:30px; line-height:10px; padding:4px;" />
				 -->
				</td>
				<td  width="20%">
				<img border="0" src="images/search_button.gif"  width="60" height="30"
								 onclick="javaScript:submit2()" >
			</td>
				
			</tr>
			
		
		
		</table>
		
		</s:form>
<table width="100%">
<tr>
	<td class="hh">组名</td>
	<td class="hh">接通量</td>
	<td class="hh">成交量</td>
	<td class="hh">成交率</td>
	<td class="hh">办成功</td>
	<td class="hh">一分钟</td>
	<td class="hh">总条数</td>
	<td class="hh">比率</td>
	<td class="hh">总时长</td>	
</tr>
<s:iterator value="list4" status="sta">
<tr>
	<td class="dd"><s:property value="TelephonistGroupId" /></td>
	<td class="dd"><s:property value="numa" /></td>
	<td class="dd"><s:property value="num" /></td>
	<td class="dd"><s:property value="nums" /></td>
	<td class="dd"><s:property value="numss" /></td>
	
	<td class="dd"><s:property value="numa_" /></td>
	<td class="dd"><s:property value="nums_" /></td>
	<td class="dd"><s:property value="num_" /></td>
	<td class="dd"><s:property value="numss_" /></td>
		
</tr>
</s:iterator>
</table>

  </body>

  

</html>

