<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
</head>
<script src="/assets/js/lawyer/lawyerPic.js"></script>
<link rel="stylesheet" href="/assets/css/lawyer.css">
<body>
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div class="page-wrap wrapper">
    <div class="page-tt">
        <em>律师画像</em>
    </div>
    <div class="page-main">
        <div class="mgb-m clearfix">
            <form method="post" action="#" style="line-height: 34px;">
                <div class="fl">
                    <select class="select" id="yearsSlect" name="year">
                        <option value="">请选择</option>
                        <option value="2008">2008年</option>
                        <option value="2009">2009年</option>
                        <option value="2010">2010年</option>
                        <option value="2011">2011年</option>
                        <option value="2012">2012年</option>
                        <option value="2013">2013年</option>
                        <option value="2014">2014年</option>
                        <option value="2015">2015年</option>
                        <option value="2016">2016年</option>
                    </select>
                    <input name="office" type="hidden" id="searchType" value="${office}"/>
                    <input name="lawyerName" type="hidden" id="lawyerName" value="${name}"/>
                    <a href="javascript:void(null);"  id="search_btn" class="btn"><i class="iconfont icon-search"></i>搜索</a>
                </div>
                <span class="mgl-l mgt-s">
                    <span class=""><span class="color-red lawyer_name text-l"></span></span>
                     <span class=""><span class="lawyer-office"></span></span>
                    <span>文书总量：</span>
                    <span class="color-red"><span class="text-l" id="ws-total-num"></span>篇</span>
                    <span>胜诉率：</span>
                    <span class="color-red"><span class="text-l" id="rate"></span>%</span>
                </span>
            </form>
        </div>
        <div class="warning-content">
            <div class="tab-wrap tab-change">
                <a href="#" class="on guanlian">关联关系</a>
                <a href="#">代理情况</a>
            </div>
            <!-- 关联关系 -->
            <div class="col-group mgb-m  tab-switch">
                <div class="col-8">
                    <div class="dl-box2">
                        <div class="dd">
                        <!-- 图谱父元素 -->
                            <div class="relative" id="dynamic-pic">
                                <!-- 图谱本身 -->
                                <div id="relativeChart" class="relativeChart" style="height: 557px;"></div>
                                <div class="pos-lt mgt-s mgl-s" >
                                    <div class="relative-info"  id="relative-info" style="display: none;">
                                        <div class="lname"></div>
                                        共同参与次数：<span class="num1 totlenum" id="totlenum">0</span><br>
                                        胜：<span class="num2 winnum" id="winnum">0</span><br>
                                        胜率：<span class="num3 winnump" id="winnump">0</span><br>
                                        <div class="mgt-s">
                                            <a class="btn btn-s url1 relative_book" href="javascript:void(null)" id="relative_book">查看文书</a>
                                            <a  href="javascript:;" class="wenshuzrend btn btn-s dialogBtn url2" >查看趋势</a>
                                        </div>
                                    </div>
                                </div>
                                <%--<div class="pos-tr mgt-s mgr-s">--%>
                                    <%--<a  href="javascript:void(null);" class="btn btn-s dialogBtn " id="relative_detail">查看详情</a>--%>
                                <%--</div>--%>
                                <div class="pos-br mg-s mgr-s text-xl">
                                <a id="seeMax" href="javascript:;" class="color-gray"><i class="iconfont icon-fangda"></i></a>
                                </div>
                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="dl-box2">
                        <div class="dd pd-m" >
                            <div class="text-m">对手律师</div>
                            <div id="csy-lawyerList-u">

                            </div>
                            <!-- <div class="mg-m text-s">
                                <div id="lawyer-list">四川省A律所-B律师</div>
                                <div class="progress-wrap"><i class="progress" style="width: 80%"></i></div>
                            </div> -->
                        </div>
                    </div>
                    <div class="dl-box2 mgt">
                        <div class="dd pd-m">
                            <div class="text-m">当事人</div>
                            <div id="csy-lawyerList-me">

                            </div>
<!--                             <div class="mg-m text-s">
                                <div>A 企业</div>
                                <div class="progress-wrap"><i class="progress" style="width: 30%"></i></div>
                            </div>
                            <div class="mg-m text-s">
                                <div>B 企业</div>
                                <div class="progress-wrap"><i class="progress" style="width: 40%"></i></div>
                            </div>
                            <div class="mg-m text-s">
                                <div>C 企业</div>
                                <div class="progress-wrap"><i class="progress" style="width: 20%"></i></div>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
            <!--  代理情况 -->
            <div class="col-agent tab-switch">
                <!-- 图一 -->
                <div class="tab">
                    <div class="header-one"><span>案例类型TOP10</span></div>
                    <div class="content">
                        <div class="echarts" id="echarts-one"></div>
                    </div>
                </div>
                <!-- 图二 -->
                <div class="tab left">
                    <div class="header-one"><span>代理类型</span></div>
                    <div class="content" style="position:relative;">
                        <div class="echarts" id="echarts-two"></div>
                        <div class="twoBoxL twoBox">
                            <div class="zAll zhuL">
                                <div class="son">
                                    <p></p>
                                </div>
                            </div>
                            <span class="text">原告胜诉率</span>
                        </div>
                        <div class="twoBoxR twoBox">
                            <div class="zAll zhuR">
                                <div class="son">
                                    <p></p>
                                </div>
                            </div>
                            <span class="text">被告胜诉率</span>
                        </div>
                    </div>
                </div>
                <!-- 图三 -->
                <div class="tab left">
                    <div class="header-one"><span>当事人性质</span></div>
                    <div class="content">
                        <div class="echarts" id="echarts-three"></div>
                    </div>
                </div>
                <!-- 图四 -->
                <div class="tab tab-hear">
                    <div class="header-one"><span>审理程序</span></div>
                    <div class="content  contents">
                        <div class="echarts wid" id="echarts-four" style="width:95%; height:155px;"></div>
                    </div>
                </div>
                <!-- 图五  表格 -->
                <div class="tab table">
                    <div class="header-one">
                        <span>常去法院</span>
                        <div class="pageLIst right" id="pageList1" style="display: inline-block; float: right;">
                            <span><span class="currentPage"></span> /<span class="totalPage" style="margin-left: 0px"></span> 页</span>
                            <ul class="pagination">
                                <li><a class="homePage"><i class="iconfont icon-page-start"></i></a></li>
                                <li><a class="prevPage"><i class="iconfont icon-page-prev"></i></a></li>
                                <li><a class="nextPage"><i class="iconfont icon-page-next"></i></a></li>
                                <li><a class="endPage"><i class="iconfont icon-page-end"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="content contents">
                        <table class="table-list table-list-center mgb-l height">
                            <tbody id="cause-list">


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
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
                <div class="mt-tabs-item mt-tabs-active" >
                    <table>
                        <tbody>
                        <tr><th>律师名称</th><th>关系强度</th><th>胜诉率</th><th>操作</th></tr>
                        </tbody>
                    </table>
                    <table>
                        <tbody id="wenshu-tab1">

                        </tbody>
                    </table>
                </div>
                <div class="mt-tabs-item">
                    <table>
                        <tbody>
                        <tr><th>律所名称</th><th>关系强度</th><th>胜诉率</th><th>操作</th></tr>
                        </tbody>
                    </table>
                    <table>
                        <tbody id="wenshu-tab2">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="text-right" style="margin-top: 10px"><a href="javascript:void(0);" class="btn" id="zrend-export-table">导出表格 <i class="iconfont icon-right"></i></a></div>
    </div>
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
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script>


$(function(){
    var  lawyerName = getQueryString('lawyerName');
    var  lawyerOffice = getQueryString('lawyerOffice');
  
    var year = $('#yearsSlect').val();
      var $seeMax = $('#seeMax');
        // var court = getQueryString('court');
        //var judgeName = getQueryString('judgeName');
    var url = '/lawyer/figure/showDetailPicture?'+'&lawyerOffice='+lawyerOffice+'&year='+year+'&lawyerName='+lawyerName
    $seeMax.on('click', function(e) {
        $(this).attr('href',url);
    });

})
</script>
</body>
</html>
