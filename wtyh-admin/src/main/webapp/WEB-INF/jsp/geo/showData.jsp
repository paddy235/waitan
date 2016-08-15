<%@ page language="java" pageEncoding="utf8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统数据表</title>
<%@include file="../common/js/easyUI.jsp" %>


<script>


$(function(){
	
	
	
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = "0"+(date.getMonth()+1);
		var d = "0"+date.getDate();
		m = m.substring(m.length-2);
		d = d.substring(d.length-2);
		return y+"-"+m+"-"+d;
	}
	
	$.extend($.fn.datagrid.methods, {
		editCell: function(jq,param){
			return jq.each(function(){
				var opts = $(this).datagrid('options');
				var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
				for(var i=0; i<fields.length; i++){
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor1 = col.editor;
					if (fields[i] != param.field){
						col.editor = null;
					}
				}
				$(this).datagrid('beginEdit', param.index);
                var ed = $(this).datagrid('getEditor', param);
                if (ed){
                    if ($(ed.target).hasClass('textbox-f')){
                        $(ed.target).textbox('textbox').focus();
                    } else {
                        $(ed.target).focus();
                    }
                    
                    $(ed.target).closest("td").find("input:eq(1)").blur(function(){
                    	var updateField = $(this).closest("td[field]").attr("field");
                    	var tr = $(this).closest("tr[datagrid-row-index]");
                    	var idTd = tr.find("td[field]:eq(0)");
                    	var idField = idTd.attr("field");
                    	var idValue = idTd.text();
                    	
                    	var value = $(this).val();
                    	                    	
                    	$.post("${ctx}/data/updateTableData",
                    			{idField:idField,
	                    		 tableName:'${param.tableName}',
	                    		 updateField:updateField,
	                    		 idValue:idValue,
	                    		 value:value},
                    			 function(){
	                    			// $(".pagination-load").trigger('click');
                    		     });
                    	
                    });
                    
//                     $(ed.target).closest("td").on("mouseout",function(){  
               			
//                     	var updateField = $(this).closest("td[field]").attr("field");
//                     	var tr = $(this).closest("tr[datagrid-row-index]");
//                     	var idTd = tr.find("td[field]:eq(0)");
//                     	var idField = idTd.attr("field");
//                     	var idValue = idTd.text();
                    	
//                     	var value = $(this).text();
//                     	if(value == ""){
//                     		value = $(this).find("input:eq(1)").val();
//                     	}
                    	
//                     	if(value == $(this).find("input:eq(0)").val()){
//                     		return;
//                     	}
                    	
//                     	$.post("${ctx}/data/updateTableData",
//                     			{idField:idField,
// 	                    		 tableName:'${param.tableName}',
// 	                    		 updateField:updateField,
// 	                    		 idValue:idValue,
// 	                    		 value:value},
//                     			 function(){
// 	                    			// $(".pagination-load").trigger('click');
//                     		     });
                    	
//                     });
                }
				for(var i=0; i<fields.length; i++){
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor = col.editor1;
				}
			});
		},
        enableCellEditing: function(jq){
            return jq.each(function(){
                var dg = $(this);
                var opts = dg.datagrid('options');
                opts.oldOnClickCell = opts.onClickCell;
                opts.onClickCell = function(index, field){
                	
                	var fisrt = ( $("td[field='"+field+"']").closest("tr").find("td:eq(0)").attr("field") );
                	
                	if(fisrt==field || field=="create_by" || field=="create_date" || field=="update_by" || field=="update_date" ){
                		return;
                	}
                	
                	
                    if (opts.editIndex != undefined){
                        if (dg.datagrid('validateRow', opts.editIndex)){
                            dg.datagrid('endEdit', opts.editIndex);
                            opts.editIndex = undefined;
                        } else {
                            return;
                        }
                    }
                    dg.datagrid('selectRow', index).datagrid('editCell', {
                        index: index,
                        field: field
                    });
                    opts.editIndex = index;
                    opts.oldOnClickCell.call(this, index, field);
                }
            });
        }
	});

	

	
	$('#dg').datagrid().datagrid('enableCellEditing');
	
});

</script>

</head>
<body>
<center>	

	<table id="dg" class="easyui-datagrid" title="${param.tableName}" 
		   data-options="pageSize:30,rownumbers:true,pagination:true,singleSelect:true,url:'${ctx}/data/getTableData?tableName=${param.tableName}',method:'get'">
		<thead>
			<tr>
			
				<c:forEach items="${columns}" var="col" >
					<c:if test="${col.colKey=='PK'}">
						<th data-options="field:'${col.colName}',width:100,align:'center',halign:'center',editor:{type:'numberbox',disabled:true}">${col.colName}[${col.colComment}]</th>
					</c:if>
				</c:forEach>
			
				<c:forEach items="${columns}" var="col" >
					<c:if test="${col.colKey!='PK'}">
					<c:choose>
						<c:when test="${col.dataType=='int'}">
							<th data-options="field:'${col.colName}',width:200,align:'center',halign:'center',editor:{type:'numberbox',max:10,precision:0}">
						</c:when>
						<c:when test="${col.dataType=='date'}">
							<th data-options="field:'${col.colName}',width:200,align:'center',halign:'center',editor:{type:'datebox',formatter:'yyyy-MM-dd'}">
						</c:when>
						<c:otherwise>
							<th data-options="field:'${col.colName}',width:200,align:'center',halign:'center',editor:'text'">
						</c:otherwise>
					</c:choose>
						${col.colName}[${col.colComment}]
					</th>
					</c:if>
				</c:forEach>
				
			</tr>
		</thead>
	</table>
	
</center>	



</body>
</html>