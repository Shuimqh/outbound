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
	<table width="100%">
		<tr>
		<td width="20%">小类</td>
		<td width="20%">号码</td>
		<td width="20%">时间</td>
		<td width="40%">项目</td>
		</tr>
	 <s:iterator value="list1" status="sta">
		<tr>
		<td><s:property value="BizSubType" /></td>
		<td><s:property value="num" /></td>
		<td><s:property value="CreateDate" /></td>
		<td><s:property value="Cname" /></td>
	</tr>
	</s:iterator>
	</table>    
  </body>
  </html>

