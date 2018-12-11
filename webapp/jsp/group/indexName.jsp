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
	.t2{
 	margin-left:50px;
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
 	margin-top:30px;
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
 <style>
        body, html {
            width: 100%;
            height: 100%;
        }
        .section {
            width: 915px;
            border: 1px solid #ccc;
        }
        #barsDemo {
            width: 100%;
            height: 400px;
        }
    </style>

  </head>
  
  <body >
  <input type="hidden" id="p1"
									value="<s:property value="p1" />" name="p1">
	<input type="hidden" id="p2"
									value="<s:property value="p2" />" name="p2">
	<input type="hidden" id="p5"
									value="<s:property value="p5" />" name="p5">
  	<div class="Top_Record">
	<div class="record_Top"><p> <s:property value="gi.Cname" /></p></div>
	</div>
	<div class="d1">
	  <s:form id="form1" action="groupName.action" method="post" name="">
	   <input type="hidden" id="p3"
									value="<s:property value="id" />" name="id">
		<table width="70%" >
			<tr>
				<td width="20%">查询时间：</td>
				<td width="60%">
					<div class="row">
					<div class="col-md-4">
						<input type="text" id="calendar1" placeholder="查询时间" class="form-control" name="call.time1" value="<s:property value='call.time1' />">
					
					</div>
					</div>
				</td>
				<td width="10%"><s:property value="p4" /></td>
				<td  width="10%">
				<img border="0" src="images/search_button.gif"  width="60" height="30"
								 onclick="javaScript:submit2()" >
			</td>
			</tr>
		</table>
	   </s:form>
	</div>
	
	
	<table><tr>
		<td width="70%" >
		
			
    
    <div class="section">
    		<div id="barsDemo"></div>
    </div>
    
    <script>
    $(function () {
        initData();
    });

    //生成数据
    function initData() {
    
    var p1=document.getElementById("p1").value;
    var p2=document.getElementById('p2').value;
    var p5=document.getElementById('p5').value;
  // alert(p2);
   	var arr1=p1.split(","); 
   	var arr2=p2.split(","); 
   	var arr5=p5.split(",");
   var v=[arr5,arr2];
   //	alert(arr2);
        var legendData = ['接通', '成交'];
        var bgColorList = ['#FBB730', '#31BDF2'];
        var axisLabel = arr1;
        var seriesValue =[];

        for (var i = 0; i < legendData.length; i++) {
            var arrData = v[i];
            var seriesDataVal = null;
            for (var j = 0; j < axisLabel.length; j++) {
                arrData.push(Math.floor(Math.random() * 100));
            }
            seriesDataVal = {
                barWidth: 20,//柱状条宽度
                name:legendData[i],
                type:'bar',
                itemStyle: {
                    normal: {
                        show: true,//鼠标悬停时显示label数据
                        barBorderRadius: [10, 10, 10, 10],//柱形图圆角，初始化效果
                         color: bgColorList[i]
                    }
                },
                label: {
                    normal: {
                        show: true, //显示数据
                        position: 'top'//显示数据位置 'top/right/left/insideLeft/insideRight/insideTop/insideBottom'
                    }
                } ,
                data:arrData
            };
            seriesValue.push(seriesDataVal);
        }

        buildChart(legendData, axisLabel, seriesValue);

    }

    //生成Echarts图形
    function buildChart(legendData, axisLabel, seriesValue) {
        var chart = document.getElementById('barsDemo');
        var echart = echarts.init(chart);
        var option = {
            title: {
                text: "话务员数据统计",//正标题
                x: "center", //标题水平方向位置
                y: "0", //标题竖直方向位置
                textStyle: {
                    fontSize: 30,
                    fontWeight: 'normal',
                    color: '#666'
                }
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'//阴影，若需要为直线，则值为'line'
                }
            },
            toolbox: {
                show: true,
                feature: {
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data: legendData,
                y: 'bottom'//图例说明文字设置

            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '10%',
                top:'10%',
                containLabel: true
            },
            xAxis: [{
                min: 0,
                type: 'category', //纵向柱状图，若需要为横向，则此处值为'value'， 下面 yAxis 的type值为'category'
                data: axisLabel
            }],
            yAxis: [{
                min: 0,
                type: 'value',
                splitArea: {show: false}
            }],
            label: {
                normal: { //显示bar数据
                    show: true,
                    position: 'top'
                }
            },
            series: seriesValue
        };

        echart.setOption(option);
    }
</script>
    
		
		<table width="80%" class="tab1">
			<tr>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=08&id=<s:property value="id" />">八点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=09&id=<s:property value="id" />">九点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=10&id=<s:property value="id" />">十点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=11&id=<s:property value="id" />">十一点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=14&id=<s:property value="id" />">十四点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=15&id=<s:property value="id" />">十五点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=16&id=<s:property value="id" />">十六点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=17&id=<s:property value="id" />">十七点</a></td>
				<td><a href="groupName.action?p3=<s:property value="call.time1" />&p4=18&id=<s:property value="id" />">十八点</a></td>
				
				
				
			</tr>
		</table>
		
		
		</td>
		
		<td width="30%" style="display:inline;vertical-align:top">
			<table width="100%" class="t2">
		  		<tr>		  		
		  			<td width="20%" class="tr1">姓名</td>
		  			<td width="20%" class="tr1">成交量</td>
		  			<td width="20%" class="tr1">接通量</td>
		  			<td width="40%" class="tr1">成交率</td>
		  		</tr>
		  		 <s:iterator value="list2" status="sta">
			  		<tr><td class="d2">
			  		<a href="grhour.action?day=<s:property value="call.time1" />&id=<s:property value="id" />" >
			  		<s:property value="Cname" />
			  		</a>
			  		</td><td class="red"><s:property value="num" /></td>
			  		<td><s:property value="numa" /></td>
			  		<td><s:property value="nums" /></td>
			  	</tr>
		  		</s:iterator>
		  	</table>
		
		</td>
	
	</tr>
	</table>
	
	  
  	
    
  </body>



</html>

