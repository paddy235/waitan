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
        <em>个案预测</em>
    </div>
    <div class="page-main">
        <div class="col-group">
            <div class="col-7">
                <div class="dl-box2 mg-m">
                    <div class="dt">选择预测条件</div>
                    <div class="dd" style="height:380px;">
                        <div class="form-box">
                            <div class="form-tr">
                                <div class="form-th">案件事实：</div>
                                <div class="form-td">
                                    <a href="javascript:void(null)" type="button" class="btn btn-s mt-modal-btn" id="tabdaData" data-modal="{
                                        target:'#selectEventTpl',
                                        clickbgclose:'true',
                                        width:800,
                                        height:655}"
                                       id="selectEventBtn">选择案件事实</a>&nbsp;<img  src="/assets/img/warning.png">
                                    <span class="tabdaDataVal" id="tabdaDataVal"></span>
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">地域：</div>
                                <div class="form-td">
                                    <select class="select relativeSelect" style="width:147px;" name="province" id="selOption">

                                    </select>
                                    <select class="select relativeSelect" style="width:146px;" id="selectCity" value="" name="city" select-value="${condition.city}">
                                        <option>市</option>
                                    </select>
                                    <img  src="/assets/img/warning.png">
                                </div>
                            </div>
                            <%--<div class="form-tr">--%>
                                <%--<div class="form-th">法院：</div>--%>
                                <%--<div class="form-td">--%>
                                    <%--<select class="select relativeSelect" style="width:299px;" name="court" id="court" >--%>
                                        <%--<option>法院</option>--%>
                                    <%--</select>--%>
                                    <%--<img  src="/assets/img/warning.png">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-tr">
                                <div class="form-th">法条：</div>
                                <div class="form-td">
                                    <input type="text" style="width:299px;" class="ipt ipt-l" name="law" id="law" />
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">当事人：</div>
                                <div class="form-td">
                                    <div class="mgt-s">
                                        <label class="label"><input type="radio" name="plaintiff" id="plaintiff1" value="true" checked="checked">原告</label>
                                        <label class="label"><input type="radio" name="plaintiff" id="plaintiff2" value="false">被告</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">律师：</div>
                                <div class="form-td">
                                    <div class="mgt-s">
                                        <label class="label"><input type="radio" name="lawer" id="lawer1" value="0" checked="checked"> 无律师</label>
                                        <label class="label"><input type="radio" name="lawer" id="lawer2" value="1"> 普通律师</label>
                                        <label class="label"><input type="radio" name="lawer" id="lawer3" value="2"> 资深律师</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">审理程序：</div>
                                <div class="form-td">
                                    <div class="mgt-s">
                                        <label class="label"><input type="radio" name="tr_proc" id="chengxu0" value="全部" checked="checked"> 全部</label>
                                        <label class="label"><input type="radio" name="tr_proc" id="chengxu1" value="一审"> 一审</label>
                                        <label class="label"><input type="radio" name="tr_proc" id="chengxu2" value="二审"> 二审</label>
                                        <label class="label"><input type="radio" name="tr_proc" id="chengxu3" value="再审"> 再审</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">民事赔偿期望：</div>
                                <div class="form-td">
                                    <input type="text" style="width:299px;" class="ipt ipt-l" name="apAmount" id="apAmount" value=""/>
                                </div>
                            </div>
                            <div class="form-tr">
                                <div class="form-th">自定义：</div>
                                <div class="form-td">
                                    <input type="text" style="width:299px;" class="ipt ipt-l" name="body" id="body" value=""/>
                                </div>
                            </div>
                            <!--position: absolute;right: 100px;bottom: 10px;-->
                            <div class="form-tr" >
                                <div class="form-th"></div>
                                <div class="form-td">
                                    <a href="javascript:void(null)" type="submit" class="btn" id="btn-click">预测</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-5">
                <div class="dl-box2 mg-m">
                    <div class="dt">预测结果</div>
                    <div class="dd text-center" style="height: 200px;">
                        <div class="text-xxl" style="padding: 50px;">
                            胜诉率预测<br>
                            <span class="color-orange">${winRate}%-${winRentM}%</span>
                        </div>
                    </div>
                    <div class="dd text-center" style="height: 180px;">
                        <div class="text-xxl" style="padding-top:50px">
                            赔偿金额<br>
                            <span class="color-orange1">${start}-${end}元</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="dl-box2 mg-m ng-scope" id="listApp" >
            <div class="dt">
                <div class="pageLIst f_right" id="pageList1" style="display: none">
                    <span><span class="currentPage"></span> / <span class="totalPage"></span> 页</span>
                    <ul class="pagination">
                        <li><a class="homePage"><i class="iconfont icon-page-start"></i></a></li>
                        <li><a class="prevPage"><i class="iconfont icon-page-prev"></i></a></li>
                        <li><a class="nextPage"><i class="iconfont icon-page-next"></i></a></li>
                        <li><a class="endPage"><i class="iconfont icon-page-end"></i></a></li>
                    </ul>
                </div>
                裁判文书详情
            </div>
            <div class="dd">
                <table class="table-list table-list-center">
                    <thead>
                    <tr>
                        <th>案件号</th>
                        <th>法院</th>
                        <th>案件结果</th>
                        <th>获得赔偿金额</th>
                        <th>审判员</th>
                        <th>文书详情</th>
                    </tr>
                    </thead>
                    <tbody id="cause-list">
                    <tr><td colspan="6">暂无相关数据!</td></tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>

<div id="selectEventTpl" class="mt-modal-dialog">
    <div class="btn-close mt-modal-close">×</div>
    <div class="pd-v-m pdl-l text-m line">案件事实</div>
    <div class="pd-l" style="width: 800px;" ng-controller="selectEventCtrl">
        <div class="form-box select-event">

            <div class="form-tr">
                <div class="form-th form-th-s" id="reCaum">案由</div>
                    <div class="form-td"><input type="text"  class="ipt ipt-block" id="anyouIpt"/>
                        <div class="jf-popup">
                            <img  src="/assets/img/warning.png">
                        </div>
                </div>
            </div>
            <div class="form-tr">
                <div class="form-th form-th-s" id="caCause">情节</div>
                <div class="form-td">
                    <div class="col-group border">
                        <div class="col-6" tree-list>
                            <div class="mg-s">
                                <input type="text" class="ipt ipt-block" placeholder="情节搜索" ng-model="searchStr" id="searchStr" />
                            </div>
                            <div class="tree-list">
                                <ul ng-if="treeList.length" id="treeList">
                                    <span style="color: #29aef1;">loading...</span>
                                </ul>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="col-group2">
                                <div class="change">
                                    <span class="point" ng-click="selectOne()"><i class="iconfont icon-right"></i></span>
                                </div>
                                <div class="col">
                                    <div class="mg-s" style="line-height: 36px;">
                                        选择的项
                                    </div>
                                    <div>
                                        <div class="tree-list tree-list-2">
                                            <ul id="selectList">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pd-l text-right">
            <a href="javascript:void(null)"   class="btn btn-gray closeDialog" id="cancel">取消</a>
            <a href="javascript:void(null)"   class="btn jf-remove" ng-click="submitForm()" id="determine">确定</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="/assets/js/common/cause_index.js"></script>
</body>
</html>
