<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title><s:property value="g.type" />工资</title>
   <link href="css/index2.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
	  <script type="text/javascript">
	setInterval(function () {
		window.location.reload();
	}, 300000);	// 单位: 毫秒, 1000 = 1 秒
  </script>
  </head>
  
  <body style="text-align:center;">
  <div class="gb">
<marquee ><s:property value="p3" escape="false"/><s:iterator value="list5" status="sta"><s:property value="title" /></s:iterator></marquee>

</div>
<!-- -------------排行榜---------------  -->
<div class="Top_Record">
	<div class="record_Top"><p><s:property value="g.type" />工资排行榜</p></div>
    <div class="topRec_List">
  		<dl>
        	<dd>排名</dd>
        	<dd>姓名</dd>        	
        	<dd>基数</dd>
        	<dd>加班工资</dd>
        	<dd>岗位津贴</dd>        	
        	<dd>保险</dd>
        	<dd>考核</dd>
        	<dd>个人所得税</dd>
        	<dd>实发</dd>
        </dl>
        <div class="maquee">
            <ul>
            <s:iterator value="list1" status="sta">
                <li>
                    <div><s:property value='{#sta.index+1}'/></div>
                    <div><s:property value="name" /></div>
                  
                    <div><s:property value="jbgz" /></div>
                    <div><s:property value="addgz" /></div>
                     <div><s:property value="gwjt" /></div>
                      
                       <div><s:property value="bx" /></div>
                        <div><s:property value="kh" /></div>
                         <div><s:property value="grsds" /></div>
                          <div><s:property value="gz" /></div>
                          
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

