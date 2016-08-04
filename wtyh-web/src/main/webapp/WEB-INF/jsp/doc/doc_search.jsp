<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
    <style type="text/css">

        .input-content {
            width: 300px;
            background: #fff;
            position: absolute;
            left: 0;
            top: 36px;
            z-index: 999;
        // display: none
        }
        .input-content h4 {
            color: #000;
            font-size: 14px;
            font-weight: bold;
            padding-left: 10px;
        }
        .input-content  li {
            text-align: left;
            font-size: 12px;
            height: 30px;
            line-height: 30px;
            color: #999;
            text-indent: 17px;
            cursor: pointer
        }
        .input-content  li:hover {
            background: #e6e6e6
        }
        .c100 p {
            font-size: 12px;
            position: absolute;
            top: 29px;    /* left: 15px; */
            color: #fff;
            z-index: 999;
            width: 100%;
            text-align: center;
        }
        .c100 {
            margin: 0px;
            margin-left: 62px;
        }
        .csy-row {
            padding-right: 20px !important;
        }
        .book-count {
            color: #25a2e4
        }
        .blue {
            color: darkblue
        }
    </style>
</head>
<body pagename="sidebarTop">
<!-- Header -->
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div class="page-wrap wrapper doc-page">
    <div class="page-tt">
        <div class="tab tab-wrap">
            <a href="javascript:void(null)" class="on visual">数据可视化</a>
            <a href="javascript:void(null)" class="retrieve ">文书检索</a>
        </div>
        <div class="fr"  style="display: inline-block" id="doc-search-wrap">
            <select class="select" name="Select" id="selectType">
                <option selected="selected" value="body">全文</option>
                <option value="title">标题</option>
                <option value="tr_content">审理经过</option>
                <option value="co_think">本院认为</option>
                <option value="law">法条</option>
            </select>
            <input type="text" class="ipt" placeholder="输入文书关键词检索" name="formName" id="autocomplete"/>
            <a href="javascript:void(null)" class="btn doc-search-btn" id="doc-search-btn"><i class="iconfont icon-search"></i>搜索</a>
        </div>
    </div>
    <div style="clear: both;"></div>
    <div class="page-main" >
        <div class="filter-tt mgb-m" >
            搜索条件：
        </div>
        <div class="filter-condition">
            <div class="dl">
                <div class="dt">按地域：</div>
                <div class="dd">
                    <select class="select" name="province" id="Province">

                    </select>
                    <select class="select" name="city" id="City">

                    </select>
                    <select class="select"  name="court" id="Court">

                    </select>
                </div>
            </div>

            <!-- 按指导性案列 -->
            <div class="dl" id="guide">
                <div class="dt">按指导性案列：</div>
                <div class="dd">

                </div>
            </div>

            <!-- 按程序-->
            <div class="dl" id="tr_proc">
                <div class="dt">按程序：</div>
                <div class="dd">

                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
            <!-- 按法院层级 -->
            <div class="dl" id="tier">
                <div class="dt">按法院层级：</div>
                <div class="dd">
                    <%--<span class="condition" data-key="cx">一审<span class="color-blue">(0)</span></span>--%>
                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>

            <!-- 年份  接口-->
            <div class="dl" id="year" >
                <div class="dt">按年份：</div>
                <div class="dd">

                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
        </div>
    </div>

    <!--数据可视化-->
    <div class="filter-content" >
        <div class="content">
            <div class="search-dl">
                <div class="dt"><em>按地域分</em></div>
                <div class="dd">
                    <div style="height:800px;" id="mapBox"></div>
                </div>
            </div>
            <div class="search-dl">
                <div class="dt"><em>按类型分</em></div>
                <div class="dd">
                    <div style="height:420px" id="barBox"></div>
                </div>
            </div>
            <div class="col-group">
                <div class="col-6">
                    <div class="search-dl">
                        <div class="dt"><em>按法院层级分</em></div>
                        <div class="dd" id="pieclickL" >
                            <div style="height:300px;width: 80%;display: inline-block" id="pieBox"></div>
                            <div style=" height: 270px;width: 179px;position:absolute;top: 44px;right: 15px;"  class="line-l" id="pieBox-1">
                                <div class="title" style="font-size: 24px;text-align: center">所有法院</div>
                                <div style="color: #bcbdbf;font-size: 16px;text-align: center;margin: 15px 0px 5px 0px">案件数</div>
                                <div class="nums" style="font-size: 38px;text-align: center;">1208</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <div class="search-dl">
                        <div class="dt"><em>按案件结果分</em></div>
                        <div class="dd"id="pieclickR" >
                            <div style="height:300px;;width: 80%;display: inline-block" id="pieBox2"></div>
                            <div style=" height: 270px;width: 179px;position:absolute;top: 44px;right: 15px;"  class="line-l" id="pieBox2-1">
                                <div class="title" style="font-size: 24px;text-align: center">所有结果</div>
                                <div style="color: #bcbdbf;font-size: 16px;text-align: center;margin: 15px 0px 5px 0px">案件数</div>
                                <div class="nums" style="font-size: 38px;text-align: center;">1208</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="search-dl">
                <div class="dt"><em>按审理程序分</em></div>
                <div class="dd">
                    <div class="col-group">
                        <div class="col-4">
                            <div id="progressChart1"   style="height: 200px;"></div>
                            <div id="barChart1"  style="height: 200px;margin:0 0px;"></div>
                        </div>
                        <div class="col-4 line-l">
                            <div id="progressChart2" style="height: 200px;"></div>
                            <div id="barChart2" style="height: 200px;margin:0 0px;"></div>
                        </div>
                        <div class="col-4 line-l">
                            <div id="progressChart3" style="height: 200px;"></div>
                            <div id="barChart3" style="height: 200px;margin:0 0px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="search-dl">
                <div class="dt"><em>按是否获得赔偿</em></div>
                <div class="dd">
                    <div class="col-group">
                        <div class="col-7">
                            <div class="col-group">
                                <div class="col-4">
                                    <div id="progressChart4"  style="height: 250px;"></div>
                                </div>
                                <div class="col-4">
                                    <div id="progressChart5"  style="height: 250px;"></div>
                                </div>
                                <div class="col-4">
                                    <div id="progressChart6"  style="height: 250px;"></div>
                                </div>
                            </div>
                            <div class="pd-m color-gray">
                                申请赔偿比例=Σ(申请赔偿金额标记）/案件总量*100%<br>
                                给付率=Σ(实际赔偿金额标记）/Σ(申请赔偿金额标记）*100%<br>
                                给付支持率=Σ(实际赔偿金额）/Σ(申请赔偿金额）*100%
                            </div>
                        </div>
                        <div class="col-5">
                            <div style="height:330px" id="barBox2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--文书检测-->
    <div class="filter-content" >
        <div class="tab">
        <span class="fr">共找到<span class="color-red" id="totle_reuslt">  </span>个结果</span>
        <span class="order on order-related">相关性 <!--<i class="iconfont icon-down"></i>--></span>
        <span class="order order-time">裁判日期 <!--<i class="iconfont icon-down"></i>--></span>
        </div>

        <div class="content">
            <div class="search-list" id="doc-search-list"></div>
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
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>

    <div class="sidebar">
        <a class="backtop" href="javascript:void (null);"  style="visibility: hidden">
            <img src="/assets/img/gotop.png" width="40px" height="40px">
        </a>
    </div>
</div>


<!--省市详情-->
<div class="dialog-model" style="height:400px; width:800px;" id="zrend-bar">
    <div class="header-title">
        <span class="chart-name-city"></span>
        <a href="javascript:;" class="mt-modal-close"><i class="iconfont icon-close"></i></a>
        
    </div>
    <div class="zrend-content" id="zrend-bar-content" style="width: 800px;height: 350px;">
       
    </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/doc/doc_search.js"></script>
</html>

