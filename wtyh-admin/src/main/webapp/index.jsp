<%@ page language="java" pageEncoding="utf8"%>
<%@include file="WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统数据表</title>
<%@include file="WEB-INF/jsp/common/js/easyUI.jsp" %>

</head>


<body>
<center>
<br/><br/>
	<h2>用户登录</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" class="easyui-form" method="post" data-options="novalidate:true" action="${ctx}/login" >
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="name" style="width:100%" data-options="label:'Name:',required:true">
			</div>
			
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" type="password"  name="password" style="width:100%" data-options="label:'Subject:',required:true">
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
			
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					if(data.success){
						window.location.href="${ctx}/"+data.content;
					}else{
						alert("用户名或密码错误！");
					}
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</center>
</body>
</html>




