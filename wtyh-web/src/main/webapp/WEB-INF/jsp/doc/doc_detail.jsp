<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="../common/meta.jsp" %>
</head>
<body pagename="sidebarTop">
<jsp:include page="../common/header.jsp" flush="true"/>
<!-- Main -->
<div class="page-wrap wrapper jf-width">
    <div class="page-tt">
       <!--<a href="/cause/cause_index.php" class="back"><i class="iconfont icon-back"></i> 返回</a>-->

        <%--<a href="javascript:history.go(-1)" class="back"><i class="iconfont icon-back"></i> 返回</a>--%>

        <%--<span class="crumb"><a href="/">首页</a> &gt;<a href="/doc/doc_search">检索视图</a>  &gt;<a href="/doc">文书检索</a>  &gt; 详情</span>--%>
    </div>
    <div class="page-side">
        <div class="doc-tree" style="width: 192px; height: 420px; position: relative; top: 0px;">
            <div class="tt">快速目录</div>
            <div class="list">
                <div>文书正文</div>
                <div class="ul">
                   <c:forEach var="item" items="${contents}" varStatus="sta">  
                      <a href="#item_${sta.index}" class="li side${sta.index}">${item.key}</a>
                   </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="page-main" style="margin-right: 192px;">
        <div class="doc-details">
            <div class="title">${information.title}</div>
            <div class="title-sub" canum_key=${information.ca_num} >${information.court}&nbsp;${information.ca_num}</div>
            <div class="doc-meta">
            
              <c:if test="${!empty information.ca_cause}">
                <div class="tr">
                    <div class="th">【案 由】</div>
                    <div class="td">${information.ca_cause}</div>
                </div>
              </c:if>  
              
               <c:if test="${!empty information.ju_date}">
                <div class="tr">
                    <div class="th">【审结日期】</div>
                    <div class="td">${information.ju_date}</div>
                </div>
               </c:if> 
               
               <c:if test="${!empty information.court}">
                <div class="tr">
                    <div class="th">【审理法院】</div>
                    <div class="td">${information.court}</div>
                </div>
               </c:if>
               
               <c:if test="${!empty information.tr_proc}">
                <div class="tr">
                    <div class="th">【审理程序】</div>
                    <div class="td">${information.tr_proc}</div>
                </div>
               </c:if>

                <c:if test="${information.datasource == '中国最高人民法院网' || information.datasource == '中国最高人民检察院网'}">
                    <div class="tr">
                        <div class="th">【指导案例来源】</div>
                        <div class="td">${information.datasource}</div>
                    </div>
                </c:if>
               
               
               <c:if test="${!empty information.guide}">
                <div class="tr">
                    <div class="th">【指导案例编号】</div>
                    <div class="td">${information.guide}</div>
                </div>
               </c:if>
                
               <c:if test="${!empty information.update}">
                <div class="tr">
                    <div class="th">【发布日期】</div>
                    <div class="td">${information.update}</div>
                </div>
               </c:if>
               
               <c:if test="${!empty information.keyword}"> 
                <div class="tr">
                    <div class="th">【关键词】</div>
                    <div class="td">${information.keyword}</div>
                </div>
               </c:if>
               
                <c:if test="${!empty information.re_canum}"> 
                <div class="tr">
                    <div class="th">【关联案件】</div>
                    <div class="td">${information.re_court}&nbsp;${information.re_canum}
                     <a href="javascript:;" style="margin-left: 5px;" id="whole" canum="${information.re_canum}" class="btn btn-s btn-brown mt-modal-btn" data-modal="{target:'#modalTest', clickbgclose:false, width:600, height:400}">查看全部</a>
                    </div>
                </div>
               </c:if>
                
            </div>
            <div class="mg-m">
                <a href="/doc/downloadPDF?doc_type=${information.doc_type}&court=${information.court}&ca_num=${information.ca_num}" class="btn btn-o"><i class="iconfont icon-download"></i> 下载</a>
            </div>

            
            
            <c:forEach var="item" items="${contents}" varStatus="sta">   
            <div class="dl" id="item_${sta.index}">
                <div class="dt"><em>${item.key}</em></div>
                <div class="dd">${item.value}<br></div>
            </div>
            </c:forEach>
            
        </div>
    </div>
    <div class="doc_detail sidebar">
        <a class="backtop" href="javascript:void (null);"  style="visibility: hidden">
            <img src="/assets/img/gotop.png" width="40px" height="40px">
        </a>
    </div>
</div>











<div class="mt-modal-dialog" id="modalTest">
    <div class="mt-dialog-title">
        关联案件
        <a href="javascript:;" class="mt-modal-close">╳</a>
    </div>
    <div class="mt-dialog-content modal-timeline">
        <ul id="list-ul">
            
        </ul>
    </div>

</div>
<jsp:include page="../common/footer.jsp" flush="true"/>

<script type="text/javascript" src="/assets/js/common/common.js"> </script>
<script src="/assets/js/jquery.mousewheel.js"></script>
<script src="/assets/js/doc/doc_detail.js"></script>

</body>
</html>

