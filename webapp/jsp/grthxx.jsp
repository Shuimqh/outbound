<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>话务员个人通话时长数据统计</title>
  <link href="css/index4.css" rel="stylesheet" type="text/css"
	media="all" />
	<script src="js/date/jquery-1.7.2.min.js"></script>
	<style type="text/css">
	body{ text-align:center}
 .tab{
 	padding-left:50px;
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
.abc{margin:0 auto;
	width:800px;
}
</style>

<script language="javascript">
function gradeChange(){
        var objS = document.getElementById("pid");
        var id = objS.options[objS.selectedIndex].value;
       
          var fomr1=document.getElementById("form1");
         fomr1.action='thsc.action?id='+id;         
     
	// alert(fomr1.action);
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

<link rel="stylesheet" href="js/date/bootstrap.min.css">
<link rel="stylesheet" href="js/date/font-awesome.min.css">
<link rel="stylesheet" href="js/date/bootstrapDatepickr-1.0.0.css">
<script src="js/date/jquery-1.7.2.min.js"></script>
<script src="js/date/bootstrap.min.js"></script>
<script src="js/date/bootstrapDatepickr-1.0.0.min.js"></script>
  </head>
  
  <body >
  <div class="abc">
 
  
  <input type="hidden" id="p1"
									value="<s:property value="p1" />" name="p1">
	<input type="hidden" id="p2"
									value="<s:property value="p2" />" name="p2">
	<s:form id="form1" action="thsc.action" method="post" name="">
  	<div class="Top_Record">
		<div class="record_Top"><p>话务员通话时长统计</p></div>
		
	</div>
	<div class="row">
					<div class="col-md-4">
						<input type="text"  id="calendar1" placeholder="查询时间" class="form-control" name="call.time1" value="<s:property value='call.time1' />" style="cursor:hand" readonly >
					</div>
					</div>
	</s:form>
	<div style="text-align:center"> 	
	<table width="90%" align="center" class="tab">
		<tr>
		<td width="20%">排名</td>
		<td width="20%">工号</td>
		<td width="20%">姓名</td>
		<td width="20%">
			<select name="p.newHouseId" id="pid" class="BigSelect"  onchange="gradeChange()"
							>
							<option value="my">
								小组
							</option>
							<s:iterator value="list2" status="number">
								<option value='<s:property value="id" />'
								<s:if test='p1==id'>
								selected="selected"
								</s:if>
								>
									<s:property value="Cname" />
								</option>
							</s:iterator>
						</select>
		
		</td>
		<td width="20%">时长</td>
		
		</tr>
	 	<s:iterator value="list1" status="sta">
		<tr>
		<td class="c_0528"><s:property value='{#sta.index+1}'/></td>
		<td class="c_0528"><s:property value="gh" /></td>
		<td class="c_0528"><s:property value="Cname" /></td>
		<td class="c_0528"><s:property value="TelephonistGroupId" /></td>
		<td class="c_0528"><s:property value="num" /></td>
		</tr>
		</s:iterator>
	</table>
	</div>    
	
</div>
  </body>
  </html>

