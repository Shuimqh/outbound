<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="html5/top.jsp" %>
<jsp:include  page="html5/Head.jsp" /> 
		<TITLE>���ݲ泵��ѵ | ���������ѵ | ����������ҵ��ѵ | ����־�²泵��ѵ���޹�˾</TITLE>
		<META name="keywords" content="�����泵��ѵ,���������ѵ,�������ʱ�׼,�����纸��ѵ,����������ҵ��ѵ,�����繤��ѵ,����ѧ����ƾ����" />
		<META name="description" content="־����ѵ���� 3��7����֤�� ��ѵ��֤����ѯ����18014458555 �泵��ѵ �г���ѵ �繤��ѵ �纸��ѵ������ѵ �ھ����ѵ��װ�ػ���ѵ�������泵��ѵ,�����泵��֤,�����г���ѵ,����������֤,�����纸��ѵ,���������纸֤,�����ھ����ѵ,�����繤��ѵ,�����纸��֤��" />
		<link href="ad/androidnews/swiper3.08.min.css" type="text/css" rel="stylesheet" />		
		<link href="ad/androidnews/iindex_patch_v1.1.css" type="text/css" rel="stylesheet" />	
		<script type="text/javascript" src="ad/androidnews/jquery-1.9.1.min.js"></script>  
   		 <script src="ad/androidnews/swiper.min.js"></script>
   		 <link href="ad/androidnews/index.css" type="text/css" rel="stylesheet" />
   		 <style type="text/css">
   		.top10{
   		 padding-top:10px;
   		 }
		</style>
	<jsp:include  page="html5/qeHead.jsp" /> 
	<div class="">
		<div class="head">
   			<jsp:include  page="html5/header.jsp" /> 
   	 	</div>
   	 	<div class="p1">
   	 		<!--banner-->
		        <div class="slBanr swiper-container"> 
		            <div class="swiper-wrapper">
		            <s:iterator value="list1" status="number">
					    <div class="swiper-slide">
					        <a href="getNews.action?id=<s:property value="id" />">
					            <img height="250" src="kindeditor/attached/<s:property value="pic" /> " alt="<s:property value="title" />" />
					            <div class="slBanrTxt"><s:property value="title" /></div>
					        </a>
					    </div>
		    		</s:iterator>
		            </div>
		            <div class="slBanr-pagination">
		            </div>
		            <div class="allIdx">
		                /
		            </div>
		        </div>
		
				<script>
		    (function() {
		        //Menu
		        /*var ifgMenu = document.getElementById("ifgMenu"),
		            ifgMenuSpan = ifgMenu.getElementsByTagName("span"),
		            main = document.getElementById("main"),
		            ifgNavBox = document.getElementById("ifgNavBox")
		        ifgMenu.addEventListener('touchend', function() {
		            if (this.clientHeight == 17) {
		                this.style.height = 16 + "px";
		                ifgMenuSpan[0].style.webkitTransform = "rotate(45deg) translate(5px,5px)";
		                ifgMenuSpan[1].style.opacity = 0;
		                ifgMenuSpan[2].style.webkitTransform = "rotate(-45deg) translate(5px,-5px)";
		                ifgNavBox.style.left = 0;
		                main.style.height = ifgNavBox.offsetHeight + 50 + "px";
		            } else {
		                this.style.height = 17 + "px";
		                ifgMenuSpan[0].style.webkitTransform = "rotate(0deg) translate(0px,0px)";
		                ifgMenuSpan[1].style.opacity = 1;
		                ifgMenuSpan[2].style.webkitTransform = "rotate(0deg) translate(0px,0px)";
		                ifgNavBox.style.left = 100 + "%";
		                main.style.height = "auto";
		            }
		        }, false);*/
		        //nav
		        var ifgNavMore = document.getElementById("ifgNavMore"),
		            ifgNavLis = document.getElementById("ifgNavLis"),
		            ifgNavLisUl = ifgNavLis.getElementsByTagName("ul");
		        ifgNavMore.addEventListener('touchend', function(event) {
		            if (ifgNavLis.clientHeight == 24) {
		                this.style.backgroundPosition = "-394px 10px";
		                ifgNavLis.style.height = ifgNavLisUl.length * 24 + "px";
		                event.stopPropagation();
		                event.preventDefault();
		            } else {
		                this.style.backgroundPosition = "-294px 10px";
		                ifgNavLis.style.height = 24 + "px";
		                event.stopPropagation();
		                event.preventDefault();
		            };
		        }, false);
		        //banner
		        //���㽹��ͼ֡��
		        $(".slBanr").find(".allIdx").html("/ " + $(".slBanr").find(".swiper-slide").length);
		
		        var slBanr = new Swiper(".slBanr", {
		            loop: true,
		            autoplay: 5000,
		            pagination: '.slBanr-pagination',
		            paginationBulletRender: function(index, className) {
		                return '<span class="' + className + '">' + (index + 1) + '</span>';
		            },
		            noSwiping: true,
		            noSwipingClass: 'stop-swiping',
		        });
		
		        //tiyu tab
		        var ifgBoxTab = new Swiper(".ifgBoxTab", {
		            loop: true,
		            //autoplay : 3000,
		            pagination: '.tab-pagination',
		        });
		        
		    })();//����ͼ�͵���JS
		    </script>
			</div>
				<div class="p2">
					<div class="p2_1">	
					<c:set var="number" value="0"></c:set>				
						<ul>
							<s:iterator value="list3" status="number">
							<c:set var="number" value="${number + 1 }"></c:set>
								<li>
									<div class="a${number}">
										<a  href="getNews.action?id=<s:property value="id" />"><ltdb:subString length="18"><s:property value="title" /></ltdb:subString></a>
									</div>
									
								</li>
							</s:iterator>												
						</ul>
					</div>	
					<div class="p2_2">	
				<div class="lrr">
					<span class="bt">��ϵ����</span>
			  	</div>
			  	<div class="lxwm">
					<table>
					<s:iterator value="list2" status="number">
						<tr>
							<td class="zw" colspan="2"><s:property value="title" /></td>
						</tr>
						<tr>
							<td>��ϵ��:</td><td><s:property value="name" /></td>
						</tr>
						<tr>
							<td>��ѯ����:</td><td><s:property value="tel" /></td>
						</tr>
						<tr>
							<td>����:</td><td><s:property value="tel3" /></td>
						</tr>
						<tr>
							<td>��ַ:</td><td><s:property value="address" /></td>
						</tr>						
					</s:iterator>
					</table>
				</div>
				
				
			</div>
				</div>
			</div>
			 	
   	 	
	<jsp:include  page="html5/footer.jsp" /> 
<jsp:include  page="html5/foot.jsp" /> 
