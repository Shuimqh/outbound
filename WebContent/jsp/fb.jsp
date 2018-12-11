<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="html5/top.jsp"%>
<jsp:include page="html5/Head.jsp" />
<TITLE>中国移动通信</TITLE>
<link href="commom/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="commom/index.css" rel="stylesheet" type="text/css"
	media="all" />
<style type="text/css">
.gb{
font-weight: bold;
font-size:20px;
}
.jiapuname{
	font-weight: bold;
	font-size: 20px;
	padding-top:50px;
	padding-right:20px;
}
.jiapu{
	float:right;
}
.jiapu ul{height:550px;overflow:hidden;list-style:none;} 
.jiapu ul li{float:right;display:inline;margin-left:4px;width:30px;height:100px;word-wrap:break-word;word-break:nomal;} 
.jiapunr{
	padding-top:110px;
	font-weight: bold;
	font-size:28px;
	color:Red;
	padding-right:30px;
}
</style>
<script src="js/jquery.min.js"></script>
  <script type="text/javascript">
	setInterval(function () {
		window.location.reload();
	}, 300000);	// 单位: 毫秒, 1000 = 1 秒
  </script>
<jsp:include page="html5/qeHead.jsp" />
<div class="container">
<div class="gb">
<marquee ><s:property value="p3" escape="false"/><s:iterator value="list5" status="sta"><s:property value="title" /></s:iterator></marquee>

</div>
	<div class="tabbox">

	<ul class="nav-list">
		<li mid="0" class="nav-0 nav-cus-0"><span><a href="today.action">今日统计</a></span></li>
		<li mid="1" class="nav-1"><span><a href="#">本周统计</a></span></li>
		<li mid="2" class="nav-2"><span><a href="#">本月统计</a></span></li>
		<li mid="3" class="nav-3"><span><a href="#">分组统计</a></span></li>
	</ul>

	<div class="contant">
		<div class="inner">
			<div class="contant-con con_list" mid="0" >
				<div class="contant-left">
					
					<div class="contant-left-bottom">
					 <div class="maquee">
						<ul>
						<s:iterator value="list1" status="sta">
							<li><div class="d1"><s:property value="Cname" /></div><div class="d2"><s:property value="numa" /></div><div class="d3"><s:property value="num" /></div><div class="d4"><s:property value="nums" /></div><div class="d5"><s:property value='{#sta.index+1}'/></div></li>
						</s:iterator>
						</ul>
					</div>
					</div>
				</div>
				
			</div>

			<div class="contant-con con_list" mid="1" >
				<div class="contant-left">
					
					<div class="contant-left-bottom">
					 <div class="maquee">
						<ul>
						<s:iterator value="list2" status="sta">
							<li><div class="d1"><s:property value="Cname" /></div><div class="d2"><s:property value="numa" /></div><div class="d3"><s:property value="num" /></div><div class="d4"><s:property value="nums" /></div><div class="d5"><s:property value='{#sta.index+1}'/></div></li>
						</s:iterator>
						</ul>
					</div>
					</div>
				</div>
				
			</div>

			<div class="contant-con con_list" mid="2" >
				<div class="contant-left">
					
					<div class="contant-left-bottom">
					 <div class="maquee">
						<ul>
						<s:iterator value="list3" status="sta">
							<li><div class="d1"><s:property value="Cname" /></div><div class="d2"><s:property value="numa" /></div><div class="d3"><s:property value="num" /></div><div class="d4"><s:property value="nums" /></div><div class="d5"><s:property value='{#sta.index+1}'/></div></li>
						</s:iterator>
						</ul>
					</div>
					</div>
				</div>
				
			</div>
			<div class="contant-con con_list" mid="3" >
				<div class="contant-left">
					
					<div class="contant-left-bottom">
					 <div class="maquee">
						<ul>
						<s:iterator value="list4" status="sta">
							<li><div class="d1"><s:property value="TelephonistGroupId" /></div><div class="d2"><s:property value="numa" /></div><div class="d3"><s:property value="num" /></div><div class="d4"><s:property value="nums" /></div></li>
						</s:iterator>
						</ul>
					</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
</div>
<div class="">
<div class="jiapu">
<ul> 
<li class="jiapuname"> 今日之星</li> 
<li class="jiapunr"> <s:property value="topname" /></li> 
</ul>
  
   
   
</div>
</div>
<script type="text/javascript" src="js/tabbedContent.js"></script>
<script type="text/javascript">
var n_c_ser = 0;//设置初始值为0；
function t_player(cur){
	$('ul.nav-list > li').eq(n_c_ser).removeClass("nav-cus-"+n_c_ser);
	if(cur==null){
		n_c_ser = ++n_c_ser % 4;   //递加函数
	}else{
		n_c_ser = cur;
	}
	if(n_c_ser !=0 ){
	}
	
	$('.inner').animate({marginLeft:(-1 * n_c_ser * 960) + 'px'});//下面内容的动画效果左移动960px；

	$('ul.nav-list > li').eq(n_c_ser).addClass("nav-cus-"+n_c_ser);
}

var n_t = setInterval('t_player()', 45000);//每隔35秒 执行一次

$('ul.nav-list > li span').hover(function(){//当我鼠标悬浮上去的时候
	var self = this;
	clearInterval(n_t);   //清除动画
	$('.inner').stop();
	var mid = $(this).parent().index()
	$('ul.nav-list > li').eq(n_c_ser).addClass("nav-cus-"+n_c_ser);
	t_player(mid);
},function(e){
	n_t = setInterval('t_player()', 45000);//当鼠标离开的时候  继续执行上面循环的函数
});
</script>

<script type="text/javascript"> 
	  function autoScroll(obj){  
			$(obj).find("ul").animate({  
				marginTop : "0px"  
			},500,function(){  
				$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);  
			})  
		}  
		$(function(){  
			setInterval('autoScroll(".maquee")',3000);
			setInterval('autoScroll(".apple")',2000);
			  
		}) 
		
</script> 

</div>

	<jsp:include page="html5/footer.jsp" />
	<jsp:include page="html5/foot.jsp" />