<%@ page language="java" pageEncoding="utf-8"%>

<% 

   Object unaex = request.getAttribute("unauthorizedEx");
   if(unaex != null){
	   out.println(unaex.toString());
   }else{
	   
	   unaex =  request.getAttribute("ex");
	   Exception e = (Exception)unaex;
	   out.println(unaex.toString());
	   e.printStackTrace();
   }
   
%>