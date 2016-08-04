<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
</head>
<body>
<!-- Header -->
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div style="display: none;">
    <input class="select province-selct" name="province" id="relativeOne"/> 
    <input class="select  court-selct" name="court"  id="relativeOne2"/>
    <input type="text" class="ipt ipt-l autocomplete"placeholder="输入法官关键词检索" id="autocomplete"/>
    <input type="text" id="startDate" class="ipt ipt-m dateinput" value="" placeholder="请选择起点日期"/>
    <input type="text" id="endDate" class="ipt ipt-m dateinput" value="" placeholder="请选择结束日期"/>
</div>
<!-- Main -->
<div class="page-wrap wrapper">
    <div class="page-tt">
        <%--<a href="javascript:;" onclick="history.go(-1)" class="back"><i class="iconfont icon-back"></i> 返回</a>--%>
        <span class="crumb">首页 &gt; 法官 &gt; <span id="mulu-name"></span>  &gt; 关系方图谱</span>
    </div>
    <div class="page-main">
        <div class="relative" id="dynamic-pic">
            <div id="relativeChart" class="relativeChart" style="height: 900px;"></div>
            <div class="pos-lt mgt-s mgl-s" >
                <div class="relative-info"  id="relative-info" style="display: none;">
                    <div class="lname"></div>
                    共同参与次数：<span class="num1 totlenum" id="totlenum">0</span><br>
                    胜：<span class="num2 winnum" id="winnum">0</span><br>
                    胜率：<span class="num3 winnump" id="winnump">0</span><br>
                    <div class="mgt-s">
                        <a class="btn btn-s url1 relative_book" href="javascript:void(null)" id="relative_book">查看文书</a>
                        <a  href="javascript:void(null);" target="_blank" class="wenshuzrend btn btn-s dialogBtn url2" >查看趋势</a>
                    </div>
                </div>
            </div>
            <div class="pos-tr mgt-s mgr-s">
                <a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-sws">隐藏事务所名</a>
                <a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-ls">隐藏律师名</a>
                <a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="relative_detail">查看详情</a>
            </div>
        </div>
    </div>
</div>

<!--法官弹出窗-->
<div class="dialog-model zrendList" style="width:460px;" id="zrendList">
    <div class="header-title" style="background: #fff">
        <span class="tip-crunt-name"></span>
        <a href="javascript:;" class="mt-modal-close"><i class="iconfont icon-close"></i></a>
    </div>
    <div class="mt-tabs" style="margin:10px;" data-tabs="{autoh:false,drag:true}">
        <ul class="mt-tabs-header">
            <li class="mt-tabs-active"><a href="javascript: void(0)">法官-律师</a></li>
            <li class=""><a href="javascript: void(0)">法官-律所</a></li>
        </ul>
        <div class="mt-tabs-content" style="width: 440px">
            <div class="mt-tabs-wrap">
                <div class="mt-tabs-item mt-tabs-active" style="padding: 0px" >
                    <table>
                        <tbody>
                        <tr><th style="width: 35%">律师名称</th><th>关系强度</th><th>胜诉率</th><th>操作</th></tr>
                        </tbody>
                    </table>
                    <div class="contentHolder" style="width:440px;height:300px;position: relative;overflow: hidden;" id="scroll3">
                        <table>
                            <tbody id="wenshu-tab1"  style="height:400px;overflow-y: scroll;">

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="mt-tabs-item" style="padding: 0px">
                    <table>
                        <tbody>
                        <tr><th style="width: 35%">律所名称</th><th>关系强度</th><th>胜诉率</th><th>操作</th></tr>
                        </tbody>
                    </table>
                    <div class="contentHolder" style="width:440px;height:300px;position: relative;overflow: hidden;" id="scroll4">
                        <table>
                            <tbody id="wenshu-tab2"  style="height:400px;overflow-y: scroll;">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-right" style="margin-top: 10px"><a href="javascript:void(0);" class="btn" id="zrend-export-table">导出表格 <i class="iconfont icon-right"></i></a></div>
    </div>
</div>


 <!--结案量走势详情-->
<div class="dialog-model jalTrend" style="height:400px; width:800px;" id="jalZrend">
    <div class="header-title">
        <span>结案量走势详情</span>
        <a href="javascript:;" class="mt-modal-close"><i class="iconfont icon-close"></i></a> 
    </div>
    <div class="zrend-content" id="jalZrend-content" style="width: 800px;height: 422px;background: #f0f4f7">
        <div id="jalZrend-left"  class="jalZrendChart">

        </div>
        <div id="jalZrend-right"  class="jalZrendChart right">

        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp" flush="true"/>
</body>
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/judge/judge_dynamic.js"></script>
<script type="text/javascript">
$(function(){
    $("#relativeOne").val(getQueryString('relativeOne'));
    $("#relativeOne2").val(getQueryString('relativeOne2'));
    $("#autocomplete").val(getQueryString('autocomplete'));
    $("#startDate").val(getQueryString('startDate'));
    $("#endDate").val(getQueryString('endDate'));
    if(getQueryString('from')=="judge_compare"){
        $("#mulu-name").html("法官对比分析");
    }else{
        $("#mulu-name").html("法官动态分析");
    }
})
</script>
</html>

