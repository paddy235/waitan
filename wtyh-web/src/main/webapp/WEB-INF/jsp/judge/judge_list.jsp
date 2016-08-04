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
        <em>法官异常关系预警</em>
    </div>
    <div class="page-main">
        <div class="mg-m">

            <div class="fr"><div class="btn btn-green daochu-table">导出表格 <i class="iconfont icon-right"></i></div></div>

            <select class="select relativeSelect province-selct" name="province" id="province" >

            </select>
            <select class="select relativeSelect city-selct" name="province" id="city" >

            </select>
            <select class="select relativeSelect court-selct" name="court" id="court" style="width: 186px">

            </select>
            <div class="key-word">
                <input type="text" class="ipt ipt-l autocomplete"placeholder="输入法官关键词检索" id="autocomplete"/>
                <div class="key-word-child" >
                    <div class="key-result-item">

                    </div>
                </div>
            </div>
            <select class="select relativeSelect select-year" name="court" id="select-year">
                <option value="full">一年</option>
                <option value="half">半年</option>
                <option value="two">两年</option>
            </select>

            <select class="select relativeSelect select-data" name="court" id="select-data">

            </select>
            <a href="javascript:void(null)" id="searchSubmit" class="btn"><i class="iconfont icon-search"></i> 搜索</a>
        </div>

        <div class="warning-content tab-change" style="display: none">
            <div class="tab-wrap">
                <a data-id="tab1" href="javascript:void(null)" class="tab1 on">律师事务所</a>
                <a data-id="tab2" href="javascript:void(null)" class="tab2">律 师</a>
            </div>
            <div class="tab-content">
                <div class="tab-items ">
                    <table  class="table-list table-list-center mgb-l" >
                        <thead>
                        <tr>
                            <td>序 号</td>
                            <td>法 院</td>
                            <td>法 官</td>
                            <td>律师事务所</td>
                            <td>关系案件数</td>
                            <td>胜诉案件数</td>
                            <td>胜诉率</td>
                        </tr>
                        </thead>
                        <tbody id="judeg-listone"></tbody>
                    </table>
                    <div style="clear: both"></div>
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

                <div class="tab-items">
                    <table id="tab1" class="table-list table-list-center mgb-l" >
                        <thead>
                        <tr>
                            <td>序 号</td>
                            <td>法 院</td>
                            <td>法 官</td>
                            <td>律师</td>
                            <td>关系案件数</td>
                            <td>胜诉案件数</td>
                            <td>胜诉率</td>
                        </tr>
                        </thead>
                        <tbody id="judeg-listtwo"></tbody>
                    </table>
                    <div class="pageLIst" id="pageList2">
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
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" flush="true"/>
</div>

</body>
<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/judge/judge_list.js"></script>
</html>

