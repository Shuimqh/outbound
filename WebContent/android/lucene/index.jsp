<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>证书查询 | 仪征志德叉车培训</title>
	<META name="keywords" content="证书查询" />
	<META name="description" content="" />
	<style type="text/css">
	
	.lucene_tit{
	 font-size: 25px; 
	 color:#ffffff;
	 
	}
	.lucene_list{
	margin-top:5px;
	font-size: 15px; 
	 color:#383a39;
	}
	.lucene_list_lenth{
	margin-top:15px;
	font-size: 13px; 
	 color:#383a39;
	}
	.lucene_list ul  li{
	display:inline;	
	}
	.cp{cursor:pointer;}
	.f14{font-size:14px;}
	.searchIpt{width:60%;font-family:"微软雅黑";border: 1 none;box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.25);-webkit-box-shadow:1px 1px 3px rgba(0, 0, 0, 0.25);height: 20px; line-height: 20px; padding: 10px 9px 10px 7px;margin-right:3px;}
.btn{background: #DDDDDD;background:-moz-linear-gradient(top,#ffffff,#dddddd);background:-webkit-linear-gradient(top,#ffffff,#dddddd);background:linear-gradient:(top, #ffffff, #dddddd);border: 0 none;font-size: 16px;font-family:"微软雅黑";height: 40px;line-height:40px;
margin-left:5px;margin-top:5px;
width: 105px;box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.35);-webkit-box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.35);}
	.c_052{
	font-size:14px;
	border-style:dashed;
	border-color:#929292;
	border-top-width:0px;
	border-right-width:0px;
	border-left-width:0px;
	border-bottom-width:1px;
	color:#282726;
	padding-left: 5px; 
	height:60px;
	padding-top: 10px; 
}
	</style>	
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script language="JavaScript">
 	 $(document).ready(function(){
 	 	  $(':button').click(function(){ 	 	
		 	 	var fomr1=document.getElementById("form1");		
				fomr1.submit();		   		
		   });				   
 	  });
 	
 </script>
<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	<div class="lr">
			<img src="images/u_b.gif" border="0" /><span class="bt">证书查询</span>
		  	</div>
	<div class="top5">
		 <div class="searchBox">
	  	 <s:form id="form1" action="ss.action" method="post" name="">
					<input type="text" class="searchIpt f14" name="lb.title" value="<s:property value="lb.title" />" maxlength="60" autocomplete="off" placeholder="输入您的身份证号码？"/>
					<input type="submit" class="btn cp" value="证书查询" />
				</s:form>
	  </div>
	</div>
	  <div class="lucene_list_lenth">
	  仪征志德叉车培训为您找到相关结果约<span class="red"><s:property value="max" /></span>个
	  </div>
	   <section id="mainbody">
	  <div class="">
	  	<ul>
	  		<s:iterator value="list1" status="number">
	  		
	  		<li class="c_052">
	  			 <p>
	  			 <span class="title">
			  		<a href="getzhengshu.action?id=<s:property value="id" />"
												target="_blank">
						<img src="kindeditor/attached/<s:property value="pics" /> " id="imager" width="150" height="98"/>
			  			<ltdb:subString length="180">														
								<s:property value="bk1" escape="false"  />				<s:property value="name" escape="false"  />
						</ltdb:subString>
					</a>
				</span>
				</p>
				
	  		</li>
	  		</s:iterator>
	  	</ul>
	  </div>

	  	 	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 