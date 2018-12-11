<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>在线报名</title>		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
		
		
		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">在线报名</span>  
		</div>	
		<s:form id="form_save" action="saveOnlineUser.action"  method="post" name="formT"  >

			
			<table width="100%">
			<tr>
			<td >报名课程：</td>
			<td >
				<s:textfield name="oub.bk1" theme="simple" size="25"/>
			</td>
			</tr>
			<tr>
			<td>姓名：</td>
			<td>
				<s:textfield name="oub.name" theme="simple" size="25"/>
			</td>
			</tr>
			<tr><td>性别：</td><td>
			<s:select theme="simple" name="oub.sex"   id="newstypeid"
				list="#{1:'男',2:' 女'}"  headerKey="-1" /></td></tr>
			<tr>
			<td>年龄：</td>
			<td>
				<s:textfield name="oub.nl" theme="simple" size="4" maxlength="3"/>
			</td>
			</tr>	
			<tr>
			<td>电话：</td>
			<td>
				<s:textfield name="oub.tel" theme="simple" size="25"/>
			</td>
			</tr>				  
			 
			<tr>
			<td>内容：</td>
				<td> 
				<textarea id="editor_id" name="oub.files" rows="3" cols="24"></textarea>
				</td>
			</tr>
			</table>				
			<table width="" border="0" cellspacing="0" cellpadding="0"
								height="20">
				<tr align="">									
					<td id="save">
						<input type="submit" name="butt" value="保存" id="save">
					</td>
				</tr>
			</table>	
			 
			</s:form>
			</div>
		
	<jsp:include  page="../html5/footer.jsp" /> 

<jsp:include  page="../html5/foot.jsp" /> 
