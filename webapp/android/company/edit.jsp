<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp"%>
<jsp:include page="../html5/Head.jsp" />
<title>企业管理</title>




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
			<span class="bt">企业简介</span>
		</div>
		<s:form id="form_save" action="updateCpmpany.action" method="post"
			name="formT">


			<table>
				<tr>
					<td>
						名称：
					</td>
					<td>
						<s:textfield name="cyb.name" theme="simple" size="25" />
					</td>
				</tr>
				<tr>
					<td>
						联系方式：
					</td>
					<td>
						<s:textfield name="cyb.tel" theme="simple" size="25" />
					</td>
				</tr>
				<tr>
					<td>
						地址：
					</td>
					<td>
						<s:textfield name="cyb.address" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						网址：
					</td>
					<td>
						<s:textfield name="cyb.web" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						E_mail：
					</td>
					<td>
						<s:textfield name="cyb.EMail" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						微信号：
					</td>
					<td>
						<s:textfield name="cyb.wx" theme="simple" size="45" />
					</td>
				</tr>

				<tr>
					<td>
						QQ：
					</td>
					<td>
						<s:textfield name="cyb.qq" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						邮政编码：
					</td>
					<td>
						<s:textfield name="cyb.yb" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						传真：
					</td>
					<td>
						<s:textfield name="cyb.cz" theme="simple" size="45" />
					</td>
				</tr>
				<tr>
					<td>
						经营范围：
					</td>
					<td>
						<textarea id="editor_id" name="cyb.jyfw" rows="5" cols="80"><s:property value="cyb.jyfw" />

				</textarea>

					</td>
				</tr>
				<tr>

					<td>
						企业简介：
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
						<input type="submit" name="butt" value="保存" id="save">
					</td>
				</tr>
			</table>
			<input type="hidden" value="<s:property value="cyb.id" />"
				name="cyb.id" />
		</s:form>

	</div>
	<jsp:include page="../html5/footer.jsp" />

	<jsp:include page="../html5/foot.jsp" />