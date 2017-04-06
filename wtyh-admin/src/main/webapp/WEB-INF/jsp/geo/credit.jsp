<%@ page language="java" pageEncoding="utf8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公司信用信息查询</title>
<%@include file="../common/js/easyUI.jsp" %>



	<style type="text/css">
		table.gridtable {
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		table.gridtable th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #dedede;
		}
		table.gridtable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
		}


		table.gridtable .space td {
			border-width: 1px;
			padding: 1px;
			border-style: solid;
			height: 2px;
			border-color: #666666;
			background-color: #3d3d3d;
		}



	</style>

</head>
<body>
<center>

	<br/>
	<br/>
	<br/>




	<form action="${ctx}/credit/info.do" method="post" >
 		企业名称：<input name="companyName" style="width: 250px;" value="${param.companyName}" /> <input type="submit" value="查询" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input onclick="window.location.href='${ctx}/data/showTables.do'" value="返回至基础数据修改" type="button" />
	</form>


	<br/>
	<br/>
	<br/>
	<table class="gridtable">

		<c:forEach items="${list}" var="map" >
			<tr class="space" ><td colspan="2">&nbsp;</td></tr>
			<c:forEach items="${map}" var="kv" >
			<tr><td>${kv.key}</td><td>${kv.value}</td></tr>
			</c:forEach>
		</c:forEach>
	</table>

</center>
</body>
</html>