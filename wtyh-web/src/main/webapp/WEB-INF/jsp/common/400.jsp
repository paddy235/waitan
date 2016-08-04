<%@ page language="java" pageEncoding="utf-8" import="java.util.regex.*" %>

<%
	Object msg = request.getAttribute("javax.servlet.error.message");
    
	Pattern p = Pattern.compile("('.*')");
	Matcher m = p.matcher(msg.toString());
	if(m.find(0)){
		out.println("{\"success\":false,\"msg\":\"参数 "+m.group(0)+" 为必传参数\",\"content\":\""+m.group(0)+"\"}" );
	}else{
		request.getAttribute("ex");
	}
	
    
%>