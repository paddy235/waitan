<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<input type="hidden" id="LOOKWENSHU" value="">
<div class="header">
    <div class="wrapper">
        <div class="logo"></div>
        <div class="right">
            <ul class="nav">
                   <li><a href="/" class="n1">首页</a></li>
                
                
                  <shiro:hasPermission name="/judge/judge_list or /judge/judge_dynamic or /judge/judge_compare" >
                   <li>
	                    <a href="javascript:void(0);" class="n2">法官</a>
	                    <div class="sub">
	                        <ul>
	                            <shiro:hasPermission name="/judge/judge_list" >
	                            	<li><a href="/judge/judge_list">法官异常关系预警</a></li>
	                            </shiro:hasPermission>
	                            <shiro:hasPermission name="/judge/judge_dynamic" >
	                           		<li><a href="/judge/judge_dynamic">法官动态分析</a></li>
	                            </shiro:hasPermission>
	                            <shiro:hasPermission name="/judge/judge_compare" >
	                            	<li><a href="/judge/judge_compare">法官对比分析</a></li>
	                            </shiro:hasPermission>
	                        </ul>
	                    </div>
                    </li>
                   </shiro:hasPermission>
                
                
                	<shiro:hasPermission name="/lawyer/lawyer_search" >
                    	<li><a href="/lawyer/lawyer_search" class="n3">律师</a></li>
                    </shiro:hasPermission>
                
                <shiro:hasPermission name="/doc/doc_search" >
               		<li><a href="/doc/doc_search"  class="n4">检索视图</a></li>
               	</shiro:hasPermission>
               	<shiro:hasPermission name="/cause/cause_index" >
                	<li><a id="gerenyuan" href="/cause/cause_index" class="n5">个案预测</a></li>
                </shiro:hasPermission>
            </ul>
            <div class="user">
                <span class="avatar"><i class="iconfont icon-avatar"></i></span>
                <a href="#"><shiro:principal/></a> | <a href="/logout">退出</a>
            </div>
        </div>
    </div>
</div>
<script>

    var judge_list = false;
    var lawyer_search=false;
    <shiro:hasPermission name="/judge/judge_list" >
    judge_list = true;
    </shiro:hasPermission>
    <shiro:hasPermission name="/lawyer/lawyer_search" >
    lawyer_search=true;
    </shiro:hasPermission>
    $(function(){
        var url = window.location.pathname;
//        console.log(url);
        if(url.indexOf('judge') != -1){
            $(".n2").addClass('color');
        }else if(url.indexOf('lawyer') != -1){
            $(".n3").addClass('color');
        }else if(url.indexOf('doc') != -1) {
            $(".n4").addClass('color');
        }else if(url.indexOf('cause') != -1) {
            $(".n5").addClass('color');
        }else{
            $(".n1").addClass('color');
        }
    })



</script>



