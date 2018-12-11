<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>话务员个人数据统计</title>
  <link href="css/index4.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/echarts-all.js"></script>
<script src="js/jquery.js"></script>
  </head>
  
  <body >
  <input type="hidden" id="p1"
									value="<s:property value="p1" />" name="p1">
	<input type="hidden" id="p2"
									value="<s:property value="p2" />" name="p2">
  	<div class="Top_Record">
	<div class="record_Top"><p>话务员 <s:property value="u.Cname" /></p></div>
	</div>
	<table><tr>
		<td width="80%">
		
			<!-- 为ECharts准备一个具备大小（宽高）的Dom -->  
    <div id="main" style="width: 1100px;height:400px;"></div>  
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
        }; /*  
        var option = {  
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
		
		
		
		
		</td>
		
		<td width="20%">
			<table width="100%">
		  		<tr><td width="60%">月份</td><td width="40%">成交量</td></tr>
		  		 <s:iterator value="list2" status="sta">
		  		<tr><td>
		  		<a href="grhour.action?id=<s:property value="u.id" />&day=<s:property value="CreateDate" />" target="_blank">
		  		<s:property value="CreateDate" />
		  		</a>
		  		</td><td><s:property value="num" /></td></tr>
		  		</s:iterator>
		  	</table>
		
		</td>
	
	</tr>
	</table>
	
	  
  	
    
  </body>



</html>

