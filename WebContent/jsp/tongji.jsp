<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>成功量报表</title>
   <link href="css/index6.css" rel="stylesheet" type="text/css"
	media="all" />

	<style type="text/css">

.red {
	color: #F06609;
	
	
}
</style> 
  </head>
  
  <body style="text-align:center;">
  <div class="gb">
<marquee ><s:property value="p3" escape="false"/><s:iterator value="list5" status="sta"><s:property value="title" /></s:iterator></marquee>

</div>
<!-- -------------排行榜---------------  -->
<div class="Top_Record">
	<div class="record_Top"><p>小组任务完成情况统计表</p></div>
    <div class="topRec_List">
  		<dl>
        	<dd>排名</dd>
        	<dd>小组名称</dd>
        	<dd>接通数量</dd>
        	<dd>成交数量</dd>
        	<dd>成交率</dd>
        	<dd>办理成功</dd>
        	<dd>目标数量</dd>
        	<dd>未完成量</dd>
        	<dd>完成率</dd>
        </dl>
        <div class="maquee">
            <ul>
           
            	
             <s:iterator value="list4" status="sta">
                <li class="group">
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="TelephonistGroupId" /></div>
                    <div><s:property value="numa" /></div>
                    <div class="red"><s:property value="num" /></div>
                    <div><s:property value="nums" /></div>
                    <div class="red"><s:property value="numss" /></div>
                    <div><s:property value="numee" /></div>
                     
                     <div class="red"><s:property value="numm" /></div>
                     <div><s:property value="numw" /></div>
                </li> 
            </s:iterator>  
            </ul>
        </div>
    </div>
</div> 

    
  </body>

  

</html>

