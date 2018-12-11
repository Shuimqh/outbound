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
	}, 300000);	// 单位: 毫秒, 1000 = 1 秒
  </script>
  </head>
  
  <body style="text-align:center;">
  
<!-- -------------排行榜---------------  -->
<div class="Top_Record">
	<div class="record_Top"><p>本周成交量排行榜</p></div>
    <div class="topRec_List">
  		<dl>
        	<dd>排名</dd>
        	<dd>姓名</dd>
        	<dd>接通量</dd>
        	<dd>成交量</dd>
        	<dd>成交率</dd>
        	<dd>办成功</dd>
        </dl>
        <div class="maquee">
            <ul>
            <s:iterator value="list2" status="sta">
                <li>
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="Cname" /></div>
                    <div><s:property value="numa" /></div>
                    <div><s:property value="num" /></div>
                     <div><s:property value="nums" /></div>
                     <div><s:property value="numss" /></div>
                </li> 
            </s:iterator>  
            
             <s:iterator value="list4" status="sta">
                <li class="group">
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="TelephonistGroupId" /></div>
                    <div><s:property value="numa" /></div>
                    <div><s:property value="num" /></div>
                    <div><s:property value="nums" /></div>
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
			setInterval('autoScroll(".maquee")',3000);
			setInterval('autoScroll(".apple")',2000);
			  
		}) 
		
</script> 

</html>

