<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>新增品牌</title>		
		
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
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">新增品牌</span>  
		</div>	
		<s:form id="form_save" action="savePp.action"  method="post" name="formT"  >

			
			<table>
			
			<tr>
			<td>名称：</td>
			<td>
				<s:textfield name="pb.name" theme="simple" size="25"/>
			</td>
			</tr>	
			<tr>
			  	<td>简要：</td><td>		
			  	<textarea name="pb.zy"  rows="4"
												cols="94" class="input_long"><s:property value="pb.zy" /></textarea> 
					
				</td></tr>
			
			<tr>
			
			<td>内容：</td>
				<td> 
				<textarea id="editor_id" name="pb.jj" style="width:680px;height:300px;">

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
			 
			</s:form>
			
	</div>	
	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 
