<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
</head>
<body pagename="sidebarTop">
<!-- Header -->
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div class="page-wrap wrapper">
    <div class="page-tt">
        <%--<a href="javascript:window.history.go(-1)" class="back"><i class="iconfont icon-back"></i> 返回</a>--%>
        <span class="crumb">首页 &gt; 法官 &gt; 法官动态分析 &gt; 查看文书</span>
    </div>
    <div class="page-main">
        <div class="mgb-s clearfix">
            <%--<label class="fl pd-s pdl-m">--%>
                <%--<input type="checkbox" class="selectAll" name="down"/> 全选--%>
            <%--</label>--%>
            <div class="fr">共找到<span class="color-red" id="totle-reuslt"></span>个结果 <!--<a href="#" class="btn btn-green"><i class="iconfont icon-download"></i> 批量下载</a>--></div>
        </div>

        <div class="search-list" id="wenShuList">
                
        </div>
        <div class="pageLIst" id="pageList1">
            <span><span class="currentPage"></span> / <span class="totalPage"></span> 页</span>
            <ul class="pagination">
                <li><a class="homePage"><i class="iconfont icon-page-start"></i></a></li>
                <li><a class="prevPage"><i class="iconfont icon-page-prev"></i></a></li>
                <li><a class="nextPage"><i class="iconfont icon-page-next"></i></a></li>
                <li><a class="endPage"><i class="iconfont icon-page-end"></i></a></li>
            </ul>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
    <div class="sidebar">
        <a class="backtop" href="javascript:void (null);"  style="visibility: hidden">
            <img src="/assets/img/gotop.png" width="40px" height="40px">
        </a>
    </div>
</div>
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/judge/judge_dynamic_wenan_list.js"></script>
</body>
</html>

