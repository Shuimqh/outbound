<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ltdb" prefix="ltdb"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>话务员个人通话时长数据统计</title>
  <script src="js/jquery.min.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="layui/css/layui.css">
  <script src="laydate/laydate.js"></script>
  <script language="javascript">
      lay('#version').html('-v'+ laydate.v);
      laydate.render({
    	  elem: '#test1',
    	  type: 'datetime'
      });
      laydate.render({
    	  elem: '#test2',
    	  type: 'datetime'
      });
      function gradeChange() {
          var objS = document.getElementById("pid");
          var id = objS.options[objS.selectedIndex].value;
          var fomr1 = document.getElementById("form1");
          fomr1.action = 'testthsc.action?id=' + id;             
          fomr1.submit(); 
      }
  </script>
  <style type="text/css">
      body {
          font-family: "微软雅黑";
      }
      h1 {
          text-align: center;
          font-size: 20px;
          margin-top: 5px;
      }
      .rangeTime {
          width: 600px;
          margin-left: 5px;   
      }
      .demo-input {
          width: 200px;
          height: 38px;
          border: 1px solid #e6e6e6;
          margin-top: 20px;
          padding-left: 10px;
      }
      table th, td {
          text-align: center;
      }
</style>
</head>
  
<body>    
    <div class="abc">  
        <s:form id="form1" action="thsc.action" method="post" name="">
            <h1>话务员当日通话时长统计</h1>            
            <div class="rangeTime">
                <span class="text-muted">开始时间：</span><input type="text" class="demo-input" id="test1" name="call.time1" value="<s:property value='call.time1' />" readonly> - <span class="text-muted">结束时间：</span><input type="text" class="demo-input" id="test2" name="call.time2" value="<s:property value='call.time2' />" readonly>                                                               
            </div>           
        </s:form>
    <div style="text-align:center">     
    <table align="center" class="table">
        <thead>
            <tr>
                <th width="20%">排名</th>
                <th width="20%">工号</th>
                <th width="20%">姓名</th>
                <th width="20%">                      
                    <select name="p.newHouseId" id="pid" class="form-control"  onchange="gradeChange()">
                        <option value="my">小组</option>
                        <s:iterator value="list2" status="number">
                            <option value='<s:property value="id" />' <s:if test='p1==id'>selected="selected"</s:if>>
                                <s:property value="Cname" />
                            </option>
                        </s:iterator>
                    </select>                                                  
                </th>
                <th width="20%">时长</th>       
            </tr>
        </thead>
        <tbody>
            <s:iterator value="list1" status="sta">
                <tr>
                    <td class="c_0528"><s:property value='{#sta.index+1}'/></td>
                    <td class="c_0528"><s:property value="gh" /></td>
                    <td class="c_0528"><s:property value="Cname" /></td>
                    <td class="c_0528"><s:property value="TelephonistGroupId" /></td>
                    <td class="c_0528"><s:property value="num" /></td>
                </tr>
            </s:iterator>
        </tbody>        
    </table>
    </div>
    <script>
        
    </script>       
</div>
  </body>
  </html>

