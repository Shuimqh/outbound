<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>������Ʒ</title>		
		
	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[id="editor_id"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
		
	
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
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">������Ʒ</span>  
		</div>	
		<s:form id="form_save" action="saveCp.action"  method="post" name="formT"  >

			
			<table>
			<tr><td>���ͣ�</td><td>
			<s:select theme="simple" name="cb.type"   id="newstypeid"
				list="#{1:'����',2:'����',3:'����'}"  headerKey="-1" headerValue="��ѡ������"/></td></tr>
			<tr><td>Ʒ�ƣ�</td><td>
			
			<select name="cb.pp" id="un" class="BigSelect">
							<option value="-1">
								��ѡ��Ʒ������
							</option>
							<s:iterator value="list1" status="number">
								<option value='<s:property value="id" />'>
									<s:property value="name" />
								</option>
							</s:iterator>
						</select>		
			
			</td></tr>
			<tr>
			<td>���ƣ�</td>
			<td>
				<s:textfield name="cb.name" theme="simple" size="25"/>
			</td>
			</tr>	
			<tr>
			<td>���</td>
			<td>
				<s:textfield name="cb.size" theme="simple" size="25"/>
			</td>
			</tr>		
			 <tr><td>�۸�</td><td>		 
					<s:textfield name="cb.price" theme="simple" size="45"/>
				</td>
			</tr>
			 <tr><td>��ַ��</td><td>		 
					<s:textfield name="cb.address" theme="simple" size="45"/>
				</td>
			</tr> 
			  
			
			<tr>
			
			<td>���ݣ�</td>
				<td> 
				<textarea id="editor_id" name="cb.jj" style="width:680px;height:300px;">

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
			 
			</s:form>
			
	</div>	
	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 
