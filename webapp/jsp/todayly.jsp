<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>成功量报表</title>
   <link href="css/index4.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
	  <script type="text/javascript">
	setInterval(function () {
		window.location.reload();
	}, 3000000);	// 单位: 毫秒, 1000 = 1 秒
  </script>
  </head>
  
  <body style="text-align:center;">
  <div class="gb">
<marquee ><s:property value="p3" escape="false"/><s:iterator value="list5" status="sta"><s:property value="title" /></s:iterator></marquee>

</div>
<!-- -------------排行榜---------------  -->
<div class="Top_Record">
	<div class="record_Top"><p>今日录音榜</p></div>
    <div class="topRec_List">
  		<dl>
        	<dd>排名</dd>
        	<dd>姓名</dd>
        	<dd>一分钟以上</dd>
        	<dd>总条数</dd>
        	<dd>比率</dd>
        	<dd>总时长</dd>
        </dl>
        <div class="maquee">
            <ul>
            <s:iterator value="list1" status="sta">
                <li>
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="name" /></div>
                    <div><s:property value="numa" /></div>
                    <div><s:property value="nums" /></div>
                     <div><s:property value="num" /></div>
                     <div><s:property value="numss" /></div>
                </li> 
            </s:iterator>  
            	
             <s:iterator value="list4" status="sta">
                <li class="group">
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="name" /></div>
                    <div><s:property value="numa" /></div>
                    <div><s:property value="nums" /></div>
                     <div><s:property value="num" /></div>
                     <div><s:property value="numss" /></div>
                </li> 
            </s:iterator>  
            </ul>
        </div>
    </div>
</div> 

    
  </body>

  <script type="text/javascript"> 
	  function autoScroll(obj){  
			$(obj).find("ul").animate({  
				marginTop : "-59px"  
			},500,function(){  
				$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);  
			})  
		}  
		$(function(){  
			setInterval('autoScroll(".maquee")',2000);
			setInterval('autoScroll(".apple")',1000);
			  
		}) 
		
</script> 

</html>

