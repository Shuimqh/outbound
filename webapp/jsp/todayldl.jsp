<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>成功量报表</title>
   <link href="css/index3.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
	  <script type="text/javascript">
	setInterval(function () {
		window.location.reload();
	}, 3000);	// 单位: 毫秒, 1000 = 1 秒
  </script>
  </head>
  
  <body style="text-align:center;">
  <div class="gb">
<marquee ><s:property value="p3" escape="false"/><s:iterator value="list5" status="sta"><s:property value="title" /></s:iterator></marquee>

</div>
<!-- -------------排行榜---------------  -->
<div class="Top_Record">
	<div class="record_Top"><p>今日成交量排行榜</p></div>
    <div class="topRec_List">
  		<dl>
        	<dd>排名</dd>
        	<dd>姓名</dd>        	
        	<dd>成交量</dd> 
        	<dd>总量</dd>        	
        </dl>
        <div class="maquee">
            <ul>
            <s:iterator value="list1" status="sta">
                <li>
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="Cname" /></div>
                    
                    <div><s:property value="num" /></div>
                    <div><s:property value="numa" /></div>
                   
                </li> 
            </s:iterator>  
            	
           
            </ul>
        </div>
    </div>
</div> 

    
  </body>



</html>

