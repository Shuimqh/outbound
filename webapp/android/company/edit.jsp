<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp"%>
<jsp:include page="../html5/Head.jsp" />
<title>��ҵ����</title>




<jsp:include page="../html5/qeHead.jsp" />
<div class="container">
	<div class="head">
		<jsp:include page="../html5/header.jsp" />
	</div>
	<div class="left">
		<jsp:include page="../left.jsp" />
	</div>
	<div class="right">

		<div class="lr">
			<img src="images/u_b.gif" border="0" />
			<span class="bt">��ҵ���</span>
		</div>
		<s:form id="form_save" action="updateCpmpany.action" method="post"
			name="formT">


			<table>
				<tr>
					<td>
						���ƣ�
					</td>
					<td>
						<s:textfield name="cyb.name" theme="simple" size="25" />
					</td>
				</tr>
				<tr>
					<td>
						��ϵ��ʽ��
					</td>
					<td>
						<s:textfield name="cyb.tel" theme="simple" size="25" />
					</td>
				</tr>
				<tr>
					<td>
						��ַ��
					</td>
					<td>
						<s:textfield name="cyb.address" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						��ַ��
					</td>
					<td>
						<s:textfield name="cyb.web" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						E_mail��
					</td>
					<td>
						<s:textfield name="cyb.EMail" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						΢�źţ�
					</td>
					<td>
						<s:textfield name="cyb.wx" theme="simple" size="45" />
					</td>
				</tr>

				<tr>
					<td>
						QQ��
					</td>
					<td>
						<s:textfield name="cyb.qq" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						�������룺
					</td>
					<td>
						<s:textfield name="cyb.yb" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						���棺
					</td>
					<td>
						<s:textfield name="cyb.cz" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						��Ӫ��Χ��
					</td>
					<td>
						<textarea id="editor_id" name="cyb.jyfw" rows="5" cols="80"><s:property value="cyb.jyfw" />

				</textarea>

					</td>
				</tr>
				<tr>

					<td>
						��ҵ��飺
					</td>
					<td>
				<textarea id="editor_id" name="cyb.jj" rows="10" cols="80"><s:property value="cyb.jj" />
				</textarea>


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
			<input type="hidden" value="<s:property value="cyb.id" />"
				name="cyb.id" />
		</s:form>

	</div>
	<jsp:include page="../html5/footer.jsp" />

	<jsp:include page="../html5/foot.jsp" />