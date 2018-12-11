<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="../html5/top.jsp" %>
<jsp:include  page="../html5/Head.jsp" /> 
		<title>新增产品</title>		
		
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
	  	 <img src="images/u_b.gif" border="0" /><span class="bt">新增产品</span>  
		</div>	
		<s:form id="form_save" action="saveCp.action"  method="post" name="formT"  >

			
			<table>
			<tr><td>类型：</td><td>
			<s:select theme="simple" name="cb.type"   id="newstypeid"
				list="#{1:'电气',2:'工具',3:'其它'}"  headerKey="-1" headerValue="请选择类型"/></td></tr>
			<tr><td>品牌：</td><td>
			
			<select name="cb.pp" id="un" class="BigSelect">
							<option value="-1">
								请选择品牌名称
							</option>
							<s:iterator value="list1" status="number">
								<option value='<s:property value="id" />'>
									<s:property value="name" />
								</option>
							</s:iterator>
						</select>		
			
			</td></tr>
			<tr>
			<td>名称：</td>
			<td>
				<s:textfield name="cb.name" theme="simple" size="25"/>
			</td>
			</tr>	
			<tr>
			<td>规格：</td>
			<td>
				<s:textfield name="cb.size" theme="simple" size="25"/>
			</td>
			</tr>		
			 <tr><td>价格：</td><td>		 
					<s:textfield name="cb.price" theme="simple" size="45"/>
				</td>
			</tr>
			 <tr><td>地址：</td><td>		 
					<s:textfield name="cb.address" theme="simple" size="45"/>
				</td>
			</tr> 
			  
			
			<tr>
			
			<td>内容：</td>
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
						<input type="submit" name="butt" value="保存" id="save">
					</td>
				</tr>
			</table>	
			 
			</s:form>
			
	</div>	
	<jsp:include  page="../html5/footer.jsp" /> 
</div>
<jsp:include  page="../html5/foot.jsp" /> 
