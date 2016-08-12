<%@ page language="java" pageEncoding="utf8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统数据表</title>
<%@include file="../common/js/easyUI.jsp" %>


<script>
	function showDetail(val,row){
		return "<a href='${ctx}/data/goTableData?tableName="+val+"' style='text-decoration:none;' >"+val+"</a>";
	}
</script>

</head>
<body>
<center>	

	<table class="easyui-datagrid" title="系统数据表" style="width:700px"
		   data-options="rownumbers:true,singleSelect:true,url:'${ctx}/data/tables',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'table_name',width:200,align:'center',halign:'center',formatter:showDetail">表名</th>
				<th data-options="field:'table_comment',width:300,align:'center',halign:'center'">表备注</th>
				<th data-options="field:'table_rows',width:100,align:'center',halign:'center'">记录数</th>
			</tr>
		</thead>
	</table>
	
</center>	



</body>
</html>