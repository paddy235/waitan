<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%@include file="common/meta.jsp" %>
</head>
<body>
<jsp:include page="common/header.jsp" flush="true"/>


<!-- Main -->
<div class="wrapper">
    <div class="home-search">
        <div class="search-box" style="position: relative;z-index: 9999;">
            <select class="select" name="Select" id="selectType">
                <option selected="selected" value="body">全文</option>
                <option value="title">标题</option>
                <option value="tr_content">审理经过</option>
                <option value="co_think">本院认为</option>
                <option value="law">法条</option>
            </select>
            <input type="text" class="ipt" placeholder="输入文书关键词检索" name="formName" id="autocomplete"/>
            <button type="button" class="btn search-btn" id="search-btn">
                <i class="iconfont icon-search"></i> 搜索
            </button>
        </div>
    </div>
    <div class="home-wrap">
        <div class="left">
            <div class="dl-box">
                <div class="dt">法官画像</div>
                <div class="dd" style="height: 292px;">
                        <ul class="list" id="rendeing"></ul>
                </div>
            </div>
            <div class="dl-box">
                <div class="dt">律师画像</div>
                <div class="dd" style="height: 177px;">
                    <ul class="list" id="renderIng"></ul>
                </div>
                <div class="dd" style="height: 177px;">
                    <ul class="list" id="renderFrere"></ul>
                </div>
            </div>
        </div>
        <div class="home-main">
            <div class="title">
                <div class="count" id="docCount">&nbsp;</div>
                <div>文书总量</div>
            </div>
            <div class="map-box" id="mapBox" style="top: -75px;"></div>
        </div>
        <div class="right">
            <div class="dl-box">
                <div class="dt">当事人画像</div>
                <div class="dd">
                    <ul class="list">
                        <li><a href="javascript:void(0)">工商信息</a></li>
                        <li><a href="javascript:void(0)">诉讼情况</a></li>
                        <!-- 本期此功能，暂时屏蔽入口 -->
                        <!-- <li><a href="javascript:void();">现金流水与公诉结合</a></li> -->
                        <li><a href="javascript:void(0)">法院执行曝光情况</a></li>
                    </ul>
                </div>
            </div>
            <div class="dl-box dl-box-red">
                <div class="dt">预警平台</div>
                <div class="dd">
                    <ul class="list">
                        <li><a href="javascript:void(0);">案件突发异常预警</a></li>
                        <li><a href="javascript:void(0);">审判尺度异常预警</a></li>
                    </ul>
                </div>
            </div>
            <div class="dl-box">
                <a href="javascript:void(0);" class="dt">鉴定机构画像</a>
                <a href="/cause/cause_index" class="dt">个案预测</a>
                <a href="javascript:void(0);" class="dt">律所画像</a>
                <a href="javascript:void(0);" class="dt">法院画像</a>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp" flush="true"/>
</div>

<script type="text/javascript" src="/assets/js/common/index.js"></script>

</body>
</html>
