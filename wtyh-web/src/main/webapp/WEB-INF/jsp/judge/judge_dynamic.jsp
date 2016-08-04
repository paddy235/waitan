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
<div class="page-wrap wrapper">
    <div class="page-tt">
        <em>法官动态分析</em>
    </div>
    <div class="page-main">
        <div class="mg-m relative">
            <form>
                 <select class="select province-selct" name="province" id="relativeOne">
                </select>
                <select class="select  court-selct" name="court"   id="relativeOne2" style="width: 186px">
                </select>
                <div class="key-word">
                    <input type="text" class="ipt ipt-l autocomplete"placeholder="输入法官关键词检索" id="autocomplete"/>
                    <div class="key-word-child" >
                        <div class="key-result-item" id="key-word-child">

                        </div>
                        <%--<span class="key-result-item"><em>陈</em>利鹏</span>--%>
                    </div>
                </div>
                <input type="text" id="startDate" class="ipt ipt-m dateinput" value="" placeholder="请选择起点日期"/>
                <input type="text" id="endDate" class="ipt ipt-m dateinput" value="" placeholder="请选择结束日期"/>
                <a href="javascript:void(null)" class="btn" id="relation-search"><i class="iconfont icon-search"></i> 搜索</a>
                <div style="display: inline-block;margin-left: 10px" id="anjianNum"></div>
            </form>
        </div>
        
        <div class="col-group mgb" style="display:none">
            <div class="col-8">       
                <div class="dl-box2">
                    <div class="dt">关联方图谱</div>
                    <div class="dd">
                        <div class="relative" id="dynamic-pic">
                            <div id="relativeChart" class="relativeChart" style="height: 557px;"></div>
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
                                <div class="pos-br mg-s mgr-s text-xl">
                                <a href="javascript:;" id="seeMax" class="color-gray"><i class="iconfont icon-fangda"></i></a>
                            </div>
                        </div>
                    </div>
                </div>               
            </div>
            <div class="col-4">
				
                <div class="dl-box2">
                	<form method="post" action="/judge/relation/compare">
                        <div class="dt">
                        <span class="fr">
                            <input type="text" class="ipt ipt-sm" id="compareAutocomplete"/>
                            <a href="javascript:void(null);" class="btn btn-s btn-gray" id="addCompare"><i class="iconfont icon-plus"></i></a>
                            <a  href="javascript:void(null);" class="btn btn-s" id="compareBtn">对比</a>
                        </span>
                            对比栏
                        </div>
                        <div class="dd">
                            <div class="list-wrap" id="compareList">
                                <%--<div class="li"><span class="del iconfont icon-close"></span> 滚</div>--%>
                            </div>
                        </div>
                    </form>
                </div>
               
               
				
                <div class="dl-box2 mgt">
                    <div class="dt">案例类型TOP10</div>
                    <div class="dd pd-m">
                        <div style="height: 280px" id="barBox"></div>
                    </div>
                    <div class="dd">
                        <div class="col-group">
                            <div class="col-4">
                                <div  style="margin-top:30px;    padding: 20px 0px 0px 22px;">文书出错量：</div>
                            </div>
                            <div class="col-5">
                                <div id="progressChart1"  data-color="#ff5a47" data-size="16" style="height: 130px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
               
            </div>
        </div>
        <div class="col-group mgb-l" style="display:none">
            <div class="col-8">
                <div class="dl-box2">
                    <!-- <div class="dt">强关系列表</div> -->
                    <div class="dd pd-m">
                        <div class="col-group">
                            <div class="col-6">
                                <div class="mg-m">律师事务所在该法官处结案情况</div>
                                <div>
                                    <table class="table-list table-list-center">
                                        <thead>
                                        <tr>
                                            <th width="40%">律师事务所</th>
                                            <th>关系案件数</th>
                                            <th>胜诉率</th>
                                        </tr>
                                        </thead>
                                    </table>
                                    <div class="contentHolder" style="height:153px;background: rgba(255, 255, 255, 0.1);" id="scroll1">
                                        <table class="table-list table-list-center">
                                            <tbody class="win-list content" id="lawfirmWin-list">

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="mg-m">律师在该法官处结案情况</div>
                                <div>
                                    <table class="table-list table-list-center">
                                        <thead>
                                        <tr>
                                            <th width="40%">律师</th>
                                            <th>关系案件数</th>
                                            <th>胜诉率</th>
                                        </tr>
                                        </thead>
                                    </table>
                                    <div class="contentHolder" style="height:153px;background: rgba(255, 255, 255, 0.1);" id="scroll2">
                                        <table class="table-list table-list-center content" >
                                            <tbody class="win-list" id="lawyerWin-list">

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="mgt-l mgb-m">
                            <div class="mg-m">结案量走势</div>
                            <div style="height:306px" id="barBox2"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="dl-box2">
                    <div class="dt">审判质效指标</div>
                    <div class="dd">
                        <table class="table-list table-list-center">
                            <thead>
                            <tr>
                                <th>类型</th>
                                <th>指标</th>
                                <th>结果</th>
                                <th>得分</th>
                            </tr>
                            </thead>
                            <tbody id="shenpanId">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>

<!--走势图-->
<div class="dialog-model" style="height:400px; width:800px;" id="zrend">
    <div class="header-title">
        <span>走势图</span>
        <a href="javascript:;" class="mt-modal-close"><i class="iconfont icon-close"></i></a>
        
    </div>
    <div class="zrend-content" id="zrend-content" style="width: 800px;height: 350px;">
       
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
                            <tr><th style="width: 20%">律师名称</th><th  style="width: 20%">律所名称</th><th  style="width: 20%">关系强度</th><th  style="width: 20%">胜诉率</th><th style="width: 20%">操作</th></tr>
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
                            <tr><th style="width: 25%">律所名称</th><th style="width: 25%">关系强度</th><th style="width: 25%">胜诉率</th><th style="width: 25%">操作</th></tr>
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
        <div class="text-right" style="margin-top: 10px"><a href="javascript:void(0);" class="btn zrend-export-table" id="zrend-export-table">导出表格 <i class="iconfont icon-right"></i></a></div>
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
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/judge/judge_dynamic.js"></script>
<script>

$(function() {

    $('#seeMax').on('click', function (e) {
        var startDate = $('#startDate').val();
        var endDate = $('#endDate').val();
        var autocomplete = $('#autocomplete').val();
        var relativeOne = $('#relativeOne').val();
        var relativeOne2 = $('#relativeOne2').val();
        var court = $("#relativeOne2").val();
        var judgeName = $("#autocomplete").val();
        var province = $("#relativeOne").val();
        var url = '/judge/showDetailPicture?' +
                '&startDate=' + startDate +
                '&endDate=' + endDate +
                '&autocomplete=' + autocomplete +
                '&relativeOne=' + relativeOne +
                '&relativeOne2=' + relativeOne2 +
                '&province=' + province +
                '&court=' + court +
                '&judgeName=' + judgeName
        '&from=judge_dynamic'
        window.open(url);
    });
})
</script>
</body>
</html>



