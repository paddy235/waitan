<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
    <style>
        .dl-box2{
            display: none;
        }
    </style>
</head>
<body>
<!-- Header -->
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div class="page-wrap wrapper">
    <div class="page-tt">
        <em>法官对比分析</em>
        <div class="fr" style="display: inline-block" style="top:-5px">
            <input type="text" id="startDate" value="" class="ipt ipt-m dateinput"  placeholder="请选择起点日期"/>
            <input type="text" id="endDate" value=""   class="ipt ipt-m dateinput"  placeholder="请选择结束日期"/>
            
        </div>
    </div>
    <div class="page-main" >
        <div class="mgb-m">
            <div class="col-group">
                <div class="mg-m relative col-6" id="slectZSDataLeft" data="">
                        <select class="select province-selct province-selct-left" name="province" id="relativeleft">

                        </select>
                        <select class="select court-selct-left" name="court"  id="relativeleft-city" style="width: 186px">

                        </select>
                        <div class="key-word key-word-left">
                            <input type="text" class="ipt ipt-l autocomplete"placeholder="输入法官关键词检索" id="autocompleteleft"/>
                            <div class="key-word-child" >
                                <div class="key-result-item" >

                                </div>
                                <%--<span class="key-result-item"><em>陈</em>利鹏</span>--%>
                            </div>
                        </div>
                        <a  style="visibility: hidden" href="javascript:void(null)" id="relation-searchleft" class="btn"><i class="iconfont icon-search"></i> 搜索</a>
                </div>
                
                <div class="mg-m relative col-6" id="slectZSDataRight" data="">
                        <select class="select province-selct province-selct-right" name="province" id="relativeright">

                        </select>
                        <select class="select court-selct-right" name="court"  id="relativeright-city" style="width: 186px">

                        </select>
                        <div class="key-word key-word-right">
                            <input type="text" class="ipt ipt-l autocomplete"placeholder="输入法官关键词检索" id="autocompleteright"/>
                            <div class="key-word-child" >
                                <div class="key-result-item" >

                                </div>
                                <%--<span class="key-result-item"><em>陈</em>利鹏</span>--%>
                            </div>
                        </div>
                        <a href="javascript:void(null)" id="relation-searchright" class="btn"><i class="iconfont icon-search"></i> 搜索</a>
                </div>
            </div>
        </div>
       	<div class="dl-box2 mg-m">
            <div class="dt">关联方图谱
                <a href="javascript:void(null)" id="common-relationship"  class="btn btn-s  canCompareBtn ">共有关系</a>
            </div>
            <div class="dd">
                <div class="col-group">
                    <div class="col-6" id="compare-left">
                        <div id="relativeChart" class="relativeChart" style="height: 520px;"></div>
                        <div class="pos-lt mgt-s mgl-s" >

                                <div class="relative-info"   style="display: none;">
                                    <div class="lname"></div>
                                    共同参与次数：<span class="num1 totlenum" >0</span><br>
                                    胜：<span class="num2 winnum" >0</span><br>
                                    胜率：<span class="num3 winnump" >0</span><br>
                                    <div class="mgt-s">
                                        <a class="btn btn-s url1 relative_book" href="javascript:void(null)"  >查看文书</a>
                                        <a  href="javascript:void(null);" target="_blank" id="wenshuzrend-left" class="wenshuzrend btn btn-s dialogBtn url2" >查看趋势</a>
                                    </div>
                                </div>
                        </div>
                        <div class="pos-tr mgt-s mgr-s">
                            <%--<a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-sws">隐藏事务所名</a>--%>
                            <%--<a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-ls">隐藏律师名</a>--%>
                                <div id="anjianNumLeft"></div>
                            <a  href="javascript:void(null);"  style="float: right" class="btn btn-s dialogBtn relative_detail" id="leftBanner">查看详情</a>
                        </div>
                        <div class="pos-br mg-s mgr-s text-xl">
                            <a target="_blank" href="javascript:void(null)" class="color-gray seeMax">
                            <i class="iconfont icon-fangda"></i>
                            </a>
                        </div>
                    </div>
                    <div class="col-6 line-l2" id="compare-right">
                        <div id="relativeChart2" class="relativeChart" style="height: 520px;"></div>
                        <div class="pos-lt mgt-s mgl-s" >
                                <div class="relative-info"  style="display: none;">
                                    <div class="lname"></div>
                                    共同参与次数：<span class="num1 totlenum" id="totlenum">0</span><br>
                                    胜：<span class="num2 winnum" id="winnum">0</span><br>
                                    胜率：<span class="num3 winnump" id="winnump">0</span><br>
                                    <div class="mgt-s">
                                        <a class="btn btn-s url1 relative_book" href="javascript:void(null)" >查看文书</a>
                                        <a  href="javascript:void(null);" target="_blank" id="wenshuzrend-right" class="wenshuzrend btn btn-s dialogBtn url2" >查看趋势</a>
                                    </div>
                                </div>
                            </div>
                        <div class="pos-tr mgt-s mgr-s">
                            <%--<a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-sws">隐藏事务所名</a>--%>
                            <%--<a  href="javascript:void(null);" class="btn btn-s dialogBtn "  id="hide-ls">隐藏律师名</a>--%>
                                <div  id="anjianNumRight"></div>
                            <a  href="javascript:void(null);"  style="float: right" class="btn btn-s dialogBtn relative_detail"  id="rightBanner">查看详情</a>

                        </div>
                        <div style="right:10px;" class="pos-br mg-s mgr-s text-xl">
                            <a target="_blank" href="javascript:void(null)" class="color-gray seeMax">
                                <i class="iconfont icon-fangda"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="dl-box2 mg-m">
            <div class="dt">案件类型TOP10</div>
            <div class="dd">
                <div class="col-group">
                    <div class="col-6 pd-l">
                        <div style="height: 280px" id="barBox"></div>
                    </div>
                    <div class="col-6 pd-l line-l2">
                        <div style="height: 280px" id="barBox2"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="dl-box2 mg-m">
            <div class="dt">结案量走势</div>
            <div class="dd">
                <div style="height: 300px" id="barBox3"></div>
            </div>
        </div>
		<div class="dl-box2 mg-m">
            <div class="dt">审判质效指标</div>
            <div class="dd">
                <table class="table-list table-list-center" id="judge-table">
                    <thead>
                    <tr>
                        <th>类型</th>
                        <th>指标名称</th>
                        <th>/</th>
                        <th>/</th>
                    </tr>
                    </thead>
                    <tbody id="judeg-listone"></tbody>
                </table>
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
    <div class="zrend-content" id="zrend-content" style="width: 100%;height: 350px;">
       
    </div>
</div>


<div class="dialog-model zrendList" style="width:460px;" id="modalCompare">
    <div class="header-title">
        <span>共有关系</span>
        <a href="javascript:;" class="mt-modal-close"><i class="iconfont icon-close"></i></a>
    </div>
    <div class="mt-tabs" style="margin:10px;" data-tabs="{autoh:false,drag:true}">
        <ul class="mt-tabs-header">
            <li class="mt-tabs-active"><a href="javascript: void(0)">律师事务所</a></li>
            <li class=""><a href="javascript: void(0)">律师</a></li>
        </ul>
        <div class="mt-tabs-content" style="width: 440px">
            <div class="mt-tabs-wrap">
                <div class="mt-tabs-item mt-tabs-active"  style="padding: 0px">
                    <table>
                        <tbody>
                            <th style="width: 40%">律师事务所</th>
                            <th class="modalCompareA"></th>
                            <th class="modalCompareB"></th>
                        </tbody>
                    </table>
                    <div class="contentHolder" style="width:440px;height:300px;position: relative;overflow: hidden;" id="scroll1">
                        <table>
                            <tbody id="common-one"  style="height:400px;overflow-y: scroll;">

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="mt-tabs-item">
                    <table>
                        <tbody>
                        <th style="width: 40%">律师</th>
                        <th class="modalCompareA"></th>
                        <th class="modalCompareB"></th>
                        </tbody>
                    </table>
                    <div class="contentHolder" style="width:440px;height:300px;position: relative;overflow: hidden;" id="scroll2">
                        <table>
                            <tbody id="common-two"  style="height:400px;overflow-y: scroll;">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--结案量走势详情-->
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
<script src="/assets/js/judge/judge_compare.js"></script>
<script>

    $(function() {
        var stardata = $("#startDate").val(),
                enddate = $("#endDate").val();

        var _startSplitDate = stardata == "" ? "" : stardata.split("-"),
                _endDSplitate = enddate == "" ? "" : enddate.split("-");
        var _startDate = _startSplitDate == "" ? "" : _startSplitDate[0] + _startSplitDate[1],
                _endDate = _endDSplitate == "" ? "" : _endDSplitate[0] + _endDSplitate[1];

        $('#compare-left .seeMax').on('click', function (e) {
            var stardata = $("#startDate").val(),
                    enddate = $("#endDate").val();

            var _startSplitDate = stardata == "" ? "" : stardata.split("-"),
                    _endDSplitate = enddate == "" ? "" : enddate.split("-");
            var _startDate = _startSplitDate == "" ? "" : _startSplitDate[0] + _startSplitDate[1],
                    _endDate = _endDSplitate == "" ? "" : _endDSplitate[0] + _endDSplitate[1];

            var autocomplete = $('#autocompleteleft').val();
            var court = $("#relativeleft-city").val();
            var judgeName = $("#autocompleteleft").val();
            var province = $("#relativeleft").val();
            var url = '/judge/showDetailPicture?' +
                    '&startDate=' + _startDate +
                    '&endDate=' + _endDate +
                    '&autocomplete=' + autocomplete +
                    '&province=' + province +
                    '&court=' + court +
                    '&judgeName=' + judgeName
                    '&from=judge_compare'
            window.open(url);
        });
        $('#compare-right .seeMax').on('click', function (e) {
            var stardata = $("#startDate").val(),
                    enddate = $("#endDate").val();

            var _startSplitDate = stardata == "" ? "" : stardata.split("-"),
                    _endDSplitate = enddate == "" ? "" : enddate.split("-");
            var _startDate = _startSplitDate == "" ? "" : _startSplitDate[0] + _startSplitDate[1],
                    _endDate = _endDSplitate == "" ? "" : _endDSplitate[0] + _endDSplitate[1];

            var autocomplete = $('#autocompleteright').val();
            var court = $("#relativeright-city").val();
            var judgeName = $("#autocompleteright").val();
            var province = $("#relativeright").val();
            var url = '/judge/showDetailPicture?' +
                    '&startDate=' + _startDate +
                    '&endDate=' + _endDate +
                    '&autocomplete=' + autocomplete +
                    '&province=' + province +
                    '&court=' + court +
                    '&judgeName=' + judgeName
            '&from=judge_compare'
            window.open(url);
        });
    })
</script>
</body>
</html>

