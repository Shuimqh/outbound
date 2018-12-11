<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>话务小组数据统计</title>
   
   
   <link rel="stylesheet" type="text/css" href="docs/assets/css/normalize.css" media="screen">
<link rel="stylesheet" type="text/css" href="docs/assets/css/bootstrap.min.css" media="screen">
<link rel="stylesheet" type="text/css" href="docs/assets/css/frappe_theme.css" media="screen">
<link rel="stylesheet" type="text/css" href="docs/assets/css/index.css" media="screen">
<link rel="stylesheet" type="text/css" href="docs/assets/css/default.css" media="screen">

<script src="docs/assets/js/highlight.pack.js"></script>
<script>hljs.initHighlightingOnLoad();</script>




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
 <style type="text/css">
 .d1{
 	padding-top:20px;
 	}
 
</style>
</head>
  
  <body >
  <input type="hidden" id="p1"
									value="<s:property value="p1" />" name="p1">
	<input type="hidden" id="p2"
									value="<s:property value="p2" />" name="p2">

  	
	<div class="d1">
	  <s:form id="form1" action="findTime.action" method="post" name="">
		<table width="70%" align="center">
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
	</div>
	
	
	<div class="container">
  <div class="row hero" style="padding-top: 1px; padding-bottom: 0px;">
	<div class="jumbotron" style="background: transparent;">
	  <h1>所有小组统计折线图</h1>
	  <p class="mt-2">按时间统计成交量</p>	 
	</div>

	<div class="col-sm-10 push-sm-1 later" style="font-size: 14px;">
	  <div id="chart-composite-1" class="border"><svg height="225"></svg></div>
	  <p class="mt-1">Click or use arrow keys to navigate data points</p>
	</div>
	
  </div>

  
  </div>


	<script type="text/javascript" src="docs/assets/js/frappe-charts.min.js"></script>
	
<script type="text/javascript"> 

	function arrAverageNum2(arr){
    var sum = eval(arr.join("+"));
    return ~~(sum/arr.length*100)/100;
	}
	var p1=document.getElementById("p1").value;
    var p2=document.getElementById('p2').value;
   	var arr1=p1.split(","); 
   	var arr2=p2.split(",");    
    var sum =arrAverageNum2(arr2);
	let reportCountList = arr2;
	let lineCompositeData = {
		labels: arr1,
		yMarkers: [
		{
			label: "平均值: "+sum,
			value: sum,
		}
		],
		datasets: [{
		"name": "Events",
		"values": reportCountList
		}]
	};
let monthNames = arr2;
let c1 = document.querySelector("#chart-composite-1");
let lineCompositeChart = new Chart (c1, {
	title: "Fireball/Bolide Events - Yearly (reported)",
	data: lineCompositeData,
	type: 'line',
	height: 190,
	colors: ['green'],
	isNavigable: 1,
	valuesOverPoints: 1,

	lineOptions: {
		dotSize: 8
	},
	 yAxisMode: 'tick',
	 regionFill: 1
});


lineCompositeChart.parent.addEventListener('data-select', (e) => {
	let i = e.index;
	barCompositeChart.updateDatasets([
		fireballOver25[i], fireball_5_25[i], fireball_2_5[i]
	]);
});

</script>
	  
  	
    
  </body>



</html>

