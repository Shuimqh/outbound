<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>���߱���</title>		
<jsp:include page="../html5/qeHead.jsp" />
<div class="container5">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
		
		
		<div class="lr">
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">���߱���</span>  
		</div>	
		<s:form id="form_save" action="saveOnlineUser.action"  method="post" name="formT"  >

			
			<table width="100%">
			<tr>
			<td >�����γ̣�</td>
			<td >
				<s:textfield name="oub.bk1" theme="simple" size="25"/>
			</td>
			</tr>
			<tr>
			<td>������</td>
			<td>
				<s:textfield name="oub.name" theme="simple" size="25"/>
			</td>
			</tr>
			<tr><td>�Ա�</td><td>
			<s:select theme="simple" name="oub.sex"   id="newstypeid"
				list="#{1:'��',2:' Ů'}"  headerKey="-1" /></td></tr>
			<tr>
			<td>���䣺</td>
			<td>
				<s:textfield name="oub.nl" theme="simple" size="4" maxlength="3"/>
			</td>
			</tr>	
			<tr>
			<td>�绰��</td>
			<td>
				<s:textfield name="oub.tel" theme="simple" size="25"/>
			</td>
			</tr>				  
			 
			<tr>
			<td>���ݣ�</td>
				<td> 
				<textarea id="editor_id" name="oub.files" rows="3" cols="24"></textarea>
				</td>
			</tr>
			</table>				
			<table width="" border="0" cellspacing="0" cellpadding="0"
								height="20">
				<tr align="">									
					<td id="save">
						<input type="submit" name="butt" value="����" id="save">
					</td>
				</tr>
			</table>	
			 
			</s:form>
			</div>
		
	<jsp:include  page="../html5/footer.jsp" /> 

<jsp:include  page="../html5/foot.jsp" /> 
