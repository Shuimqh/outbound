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
	<div class="record_Top"><p>话务组 <s:property value="cb.Cname" /></p></div>
	</div>
	<div class="d1">
	  <s:form id="form1" action="group.action" method="post" name="">
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
	</div>
	
	
	<table  width="100%"><tr>
		<td width="75%" >
		
			<!-- 为ECharts准备一个具备大小（宽高）的Dom -->  
    <div id="main" style="width: 75%;height:400px;"></div>  
    <script type="text/javascript"> 
   // alert(document.getElementById('p1').value()); 
    var p1=document.getElementById("p1").value;
    var p2=document.getElementById('p2').value;
   	var arr1=p1.split(","); 
   	var arr2=p2.split(","); 
   
        // 基于准备好的dom，初始化echarts实例  
        var myChart = echarts.init(document.getElementById('main'));  
        // 指定图表的配置项和数据  
     var option = {  
            title: {  
                text: '柱状图'  
            },  
            tooltip: {},  
            legend: {  
                data:['成交量']  
            },  
            xAxis: {  
                data: arr1
            },  
            yAxis: {},  
            series: [{  
                name: '成交量',  
                type: 'bar',  
                data: arr2 
            }]  
        }; 
        /*  
        var option2 = {  
            title: {  
                text: '折线图'  
            },  
            tooltip: {  
                trigger: 'axis'  
            },  
            legend: {  
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']  
            },  
            grid: {  
                left: '3%',  
                right: '4%',  
                bottom: '3%',  
                containLabel: true  
            },  
            toolbox: {  
                feature: {  
                    saveAsImage: {}  
                }  
            },  
            xAxis: {  
                type: 'category',  
                boundaryGap: false,  
                data: ['2017-12-1','2017-12-2','周三','周四','周五','周六','周日','12-2','12-3']  
            },  
            yAxis: {  
                type: 'value'  
            },  
            series: [  
                {  
                    name:'邮件营销',  
                    type:'line',  
                    stack: '总量',  
                    itemStyle : { normal: {label : {show: true}}},  
                    data:[120, 132, 101, 134, 90, 230, 210,220,220]  
                },  
                {  
                    name:'联盟广告',  
                    type:'line',  
                    stack: '总量',  
                    itemStyle : { normal: {label : {show: true}}},  
                    data:[220, 182, 191, 234, 290, 330, 310,220,2201]  
                },  
                {  
                    name:'视频广告',  
                    type:'line',  
                    stack: '总量',  
                    itemStyle : { normal: {label : {show: true}}},  
                    data:[150, 232, 201, 154, 190, 330, 410,220,220]  
                },  
                {  
                    name:'直接访问',  
                    type:'line',  
                    stack: '总量',  
                    itemStyle : { normal: {label : {show: true}}},  
                    data:[320, 332, 301, 334, 390, 330, 320,420,220]  
                },  
                {  
                    name:'搜索引擎',  
                    type:'line',  
                    stack: '总量',  
                    itemStyle : { normal: {label : {show: true}}},  
                    data:[820, 932, 901, 934, 1290, 1330, 1320,2203,2204]  
                }  
            ]  
        };  */ 
        // 使用刚指定的配置项和数据显示图表  
        myChart.setOption(option);  
    </script>  
		
		<table width="80%" class="tab1">
			<tr>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=08">八点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=09">九点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=10">十点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=11">十一点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=14">十四点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=15">十五点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=16">十六点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=17">十七点</a></td>
				<td><a href="group.action?p3=<s:property value="call.time1" />&p4=18">十八点</a></td>
				
				
				
			</tr>
		</table>
		
		
		</td>
		
		<td width="25%" style="display:inline;vertical-align:top">
			<table width="100%" >
		  		<tr>
		  			<td width="50%" class="tr1">组名</td>
		  			<td width="25%" class="tr1">成交量</td>
		  			<td width="25%" class="tr1">平均值</td>
		  		</tr>
		  		 <s:iterator value="list2" status="sta">
			  		<tr><td class="d2">
			  		<a href="groupName.action?id=<s:property value="TelephonistGroupId" />" target="_blank">
			  		<s:property value="Cname" />
			  		<span class="red">（<s:property value="nums" /> 人）</span>
			  		</a>
			  		</td>
			  		<td><s:property value="num" /></td>
			  		<td><s:property value="numa" /></td>
			  	</tr>
		  		</s:iterator>
		  	</table>
		
		</td>
	
	</tr>
	</table>
	
	  
  	
    
  </body>



</html>

