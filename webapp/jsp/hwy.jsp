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
<style type="text/css">
        *{
            margin: 0;padding: 0;
        }
        ul{
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            width: 1000px;margin: 0 auto;
            list-style-type: none;
            border: 1px solid red;
        }
        li{
            width: 15%;
            background-color: #eee;
            margin: 5px 0;
            height: 40px;
            padding-top:10px;
        }
    </style>
  </head>
  
  <body style="text-align:center;">
  	<div class="Top_Record">
	<div class="record_Top"><p>话务组成员</p></div>
	</div>
  	 <ul>
  	 <s:iterator value="list1" status="number">	
        <li><a href="gr.action?id=<s:property value="id" />" target="_blank"><s:property value="Cname" /></a></li>
      </s:iterator>  
    </ul>
    
  </body>



</html>

