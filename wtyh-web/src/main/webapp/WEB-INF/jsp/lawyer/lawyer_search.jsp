<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
    <link rel="stylesheet" href="/assets/css/percircle.css">
    <link rel="stylesheet" href="/assets/css/lawyer.css">
    <script src="/assets/js/lawyer/lawyer.js"></script>
</head>
<body pagename="sidebarTop">
<!-- Header -->
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->

<div class="page-wrap wrapper" >
    <!-- 搜索框 -->
    <div class="page-tt">
        <em>律师检索</em>
        
        <div class="fr" ng-init="type='content'" id="csy-search">
            <input type="text" class="ipt ipt-l" style="width: 250px" placeholder="输入案件类型、律师、律师事务所" ng-model="searchStr" id="autocomplete"/>
            <a href="javascript:void(null)" class="btn search_btn" ><i class="iconfont icon-search"></i>搜索</a>
        </div>
    </div>
    <div class="page-main">
        <!-- 搜索框返回的字段条件 -->
        <div class="filter-tt mgb-m" ng-if="filterConditions.list.length">
            搜索条件：
        </div>
        <!-- 通过点击筛选的条件 -->
        <div class="filter-condition">
            <!-- 按照地域 -->
            <div class="dl">
                <div class="dt">按地域：</div>
                <div class="dd">
                    <select class="select" name="province" id="Province">
                        <option value="">选择地域</option>
                        <option value="辽宁省">辽宁省</option>
                        <option value="广东省">广东省</option>
                    </select>
                    <select class="select" name="city" id="City">
                        <option value="">选择市</option>
                    </select>
                    <select class="select"  name="court" id="Court">
                        <option value="">选择法院</option>
                    </select>
                </div>
            </div>
            <!-- 诉讼方 -->
            <div class="dl" id="conditionA">
                <div class="dt">按诉讼方：</div>
               <div class="dd">
                    <span class="condition" data-key="ssf"><span class="text">原告律师</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="ssf"><span class="text">被告律师</span><span class="color-blue"></span></span>
                </div>
            </div>
            <!-- 律师事务所  接口-->
            <div class="dl" id="conditionB">
                <div class="dt">按律师事务所：</div>
               <div class="dd">
                    <span class="condition" style="opacity:0">ss<span class="color-blue"></span></span>
                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
            <!-- 程序 -->
            <div class="dl" id="conditionC">
                <div class="dt">按程序：</div>
                <div class="dd">
                    <span class="condition" data-key="cx"><span class="text">一审</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="cx"><span class="text">二审</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="cx"><span class="text">再审</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="cx"><span class="text">其他</span><span class="color-blue"></span></span>
                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
            <!-- 法院 -->
            <div class="dl" id="conditionD">
                <div class="dt">按法院：</div>
                <div class="dd">
                    <span class="condition" data-key="fy"><span class="text">最高人民法院</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="fy"><span class="text">高级人民法院</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="fy"><span class="text">中级人民法院</span><span class="color-blue"></span></span>
                    <span class="condition" data-key="fy"><span class="text">基层人民法院</span><span class="color-blue"></span></span>
                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
            <!-- 年份  接口-->
            <div class="dl"id="conditionE" >
                <div class="dt">按年份：</div>
                <div class="dd" ng-show="totalCount != 0">
                    <span class="condition" style="opacity:0">ss<span class="color-blue"></span></span>
                </div>
                <!-- <a href="javascript:;" class="ddMax-btn">更多</a> -->
            </div>
        </div>
        <div class="filter-content">
            <div class="tab" style="width:100%">
                <!-- 搜索结果总量 -->
                <span class="fr">共找到<span class="color-re" id="lawyer_list_count">  </span>个结果</span>
                <!-- 搜索结果排序方式 -->
                <span class="order totalNum on" >关注类型更多 <i class="iconfont icon-down"></i></span>
                <span class="order ca_cause" >文书总量更多 <i class="iconfont icon-down"></i></span>
            </div>
            <div class="content" id="lawyerContent">
            <h4 style="padding: 10px;">暂无搜索结果。</h4>
                <!-- 返回的每一个律师的信息 -->
<!--                 <div class="row csy-row" >
                    <div class="avatar">
                        <img src="//ui.quteam.com/puhuifazhi/img/avatar.png" class=""/>
                    </div>
                    <div class="info">
                        <div class="name"><a href="#" target="_blank">鲈鱼大律师</a></div>
                        <div>上海市某律师事务所</div>
                        <div class="mgt-s">
                            <span ><i class="icon icon-hammer"></i>  上海市杨浦区人民法院</span>
                        </div>
                    </div>
                    <div class="col">
                        <span class="file-count"><i class="iconfont icon-2"></i> 文书总量 <span class="book-count">100</span></span>
                    </div>
                    <div id="bluecircle" class="c100 p70 small">
                        <p>关注类型</p>
                        <span>17%</span>
                        <div class="slice">     
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>
                    <div id="bluecircle" class="c100 p70 small">
                        <p>担任原告律师</p>
                        <span>25%</span>
                        <div class="slice">     
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>
                </div> -->
            </div>
        </div>
        <!-- 分页 -->
		<div class="foot">
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
    </div>
    <div class="sidebar">
        <a class="backtop" href="javascript:void (null);"  style="visibility: hidden">
            <img src="/assets/img/gotop.png" width="40px" height="40px">
        </a>
    </div>
</div>


<script type="text/javascript" src="/assets/js/common/common.js"> </script>
</body>
</html>


