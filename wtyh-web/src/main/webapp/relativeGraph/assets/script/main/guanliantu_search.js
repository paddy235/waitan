// 所有模块都通过 define 来定义
define(function(require, exports, module) {
    var conf = require('./guanliantu_conf');
    
    //搜索公司
    var $indexSearchContent = $('.index-search-content');
    /**获得焦点的时候*/
    $("#searchCompanyLocal").on("keyup",function (event) {
        html ='';
        var search=$(this).val();
        var rst= company_match(search);
        console.log(search);
        if (event.keyCode == 13 && search != "" && rst.length == 0) {
           // $('.index-search-content').empty();
           if(conf.taoxi == "A") return;
            $.ajax({
                type: "POST",
                url: HOME_PATH+"/show/fatherOfDynamicQuery.do",
                data: {routeCompany : search},
                async: false,  //关键
                success: function(data){
                    var jsonData = JSON.parse(data);
                    var i = 0;
                    if (jsonData.obj.length != 0) {
                         for (i; i < jsonData.obj.length; i++) {
                            html+= '<span class="list"><a class="list-url" href="javascript:;" title='+jsonData.obj[i].companyName+'>'+(jsonData.obj[i].companyName.length>11?(jsonData.obj[i].companyName.substr(0,10)+'...'):jsonData.obj[i].companyName)+'</a><a class="add-this-company mt-btn-blue" companyname='+jsonData.obj[i].companyName+'>添加</a></span>';
                        }
                     }
                     //A套系没有添加公司的需求
                    html+='<button type="button" class="add-new-company mt-btn-blue">没有公司请点击手动添加</button>';
                    $indexSearchContent.html(html).show();
                }
            });
        }else if(search != ""){
           // $('.index-search-content').empty();
            html ='';
            if(rst.length>0) {
                for (var i in rst) {
                    html += '<span class="list"><a class="list-url" href="javascript:;" title=' + rst[i] + '>' + (rst[i].length > 17 ? (rst[i].substr(0, 16) + '...') : rst[i]) + '</a></span>'
                }
                if(conf.taoxi != "A"){
                    html += '<button type="button" class="add-new-company mt-btn-blue">没有公司请点击手动添加</button>';
                }
                $indexSearchContent.html(html).show();
            }
        }else{
            $indexSearchContent.html("").hide();
        }
    });

    /**
     * 模糊匹配图谱中有的公司，并以数组形式返回
     * @param company 公司名称 (返回当前图中所有与之相关的公司)
     * */
    function company_match(company){
        //console.log("++",conf.linksData);
        //company = $.trim(company);
        var rst=[] ;
        if(company && company!="")
            for(var i = 0; i<NODES.length;i++){
                if(NODES[i].name.indexOf(company) != -1){
                    rst.push(NODES[i].name);
                }
            }
           // console.log(rst);
        return rst;
    };

    //添加公司
    var addNewCompany = function(companyName){
        if($(".del-add-company").length >= 5){
            $.popup({
                str:'最多只能添加5个公司',
                icon: "danger"
            });
            return;
        }
        var data = {
            targetCompanyName : mtui.getQueryString("companyName"),
            companyName : companyName,
            version : mtui.getQueryString("version")
        };
        //console.log(data);
        $.ajax({
            url: '/json/addCompany.json',
            type: 'POST',
            dataType: 'json',
            data: data,
            success: function(msg){
                //console.log(msg);
                if (msg.success == '0') {
                    $.popup({
                        str:msg.msg,
                        icon: "danger",
                        height:'auto'
                    });
                } else {
                    //return
                    location.reload();
                }
            }
        });
        
    };

    /**
    *   添加未知的公司
    */
    $indexSearchContent.on('click', '.add-new-company', function(event) {
        event.stopPropagation();
        var name = $(this).parent().siblings('#searchCompanyLocal').val();
        addNewCompany(name);
    });


    /**
    *   添加回车回来的公司
    */
    $indexSearchContent.on('click', '.add-this-company', function(event) {
        event.stopPropagation();
        var name = $(this).attr("companyname");
        addNewCompany(name);
    });
    
    /**
    *   删除添加的公司
    */
    $("#allCompany").on("click",".del-add-company",function(e){
        e.stopPropagation();
        var companyName = $(this).siblings('.item-name').attr("data-name");
        var data = {
            targetCompanyName : mtui.getQueryString("companyName"),
            companyName : companyName
        };
        $.ajax({
            url: '/json/delCompany.json',
            type: 'POST',
            dataType: 'json',
            data: data,
            success: function(msg){
                console.log(msg);
                //href.reload();
                if(msg.success == "1"){
                    $.popup({
                        str:'删除成功,2秒后自动刷新',
                        icon:"success",
                        showbtn:false,
                        time:2000,
                        closeback:function(){
                            location.reload();
                        }
                    });
                }else{
                    $.popup({
                        str:msg.msg,
                        icon:"danger",
                        showbtn:false,
                        time:2000
                    });
                }
            }
        });
    });
    
});