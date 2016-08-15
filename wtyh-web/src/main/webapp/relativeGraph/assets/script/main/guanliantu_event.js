// 所有模块都通过 define 来定义
define(function(require, exports, module) {

    var conf = require('./guanliantu_conf');
    var mark = 'default';
    var $company = $(".all-company");

    //对外提供接口
    exports.iniEvent = function(){

        //拖动方法
        var mousedownFun = function(ev){
            //hoverShow='move';
            // conf.$cavLinks.hide();
        }
        var mouseUpFun = function(ev){
            //conf.$cavNodes.show();
            //hoverShow='move';
            //conf.$cavLinks.show();

        }
        var mouseMoveFun = function(ev,change){
            //conf.$cavLinks.hide();
            //hoverShow='move';
            // console.log(change);
            if(change != 0){
                mark = 'move';
            }
        }
        $(".drag-box").dragMt({down_callback:mousedownFun, up_callback:mouseUpFun, move_callback:mouseMoveFun, dragStartDom:"#canvas-box"});

        //设置侧面栏目，展开内容
        var setNodeItem = function(name){
            var $item = $("#allCompany").find(".item[data-name='"+name+"']");
            $(".company-item-detail").remove();
            var shtml = '<div class="company-item-detail" data-name="'+name+'"><ul>';
            // var num = conf.linksData[name].num;
            var ins = conf.linksData[name].ins,
                outs = conf.linksData[name].outs;

            //console.log("++++++++++",conf.linksData[name]);
            for(var i=0; i<ins.length; i++){
                //console.log(ins[i]);
                shtml += '<li>\
                            <span class="color" style="background:'+ins[i].arrow.line.style.strokeColor+';"></span>\
                            <span class="name">'+ins[i].name+'</span>\
                            <span class="links">'+ins[i].guanlian+'</span>\
                          </li>';
            }
            for(var i=0; i<outs.length; i++){
                //console.log(outs[i]);
                shtml += '<li>\
                            <span class="color" style="background:'+outs[i].arrow.line.style.strokeColor+';"></span>\
                            <span class="name">'+outs[i].name+'</span>\
                            <span class="links">'+outs[i].guanlian+'</span>\
                          </li>';
            }
            shtml+='</ul></div>';
            conf.$allCompany.scrollTop($item.index()*31);

            $(".ajax-links-data").remove();
            $item.after(shtml);
            hoverShowFun();
        }

        //显示hover层
        var hoverShowFun = function(){
            conf.$cavHover.show();
            conf.$cavMainHover.show();
            conf.$cavHoverNodes.show();
            conf.$cavLinks.css('opacity',1);
        }

        //隐藏hover层
        var hoverHideFun = function(){
            conf.$cavHover.hide();
            conf.$cavMainHover.hide();
            conf.$cavHoverNodes.hide();
            conf.$cavLinks.css('opacity',0.2);
            //hoverShow="block";
            if($(".company-item-detail")[0]){
                $(".company-item-detail").remove();
            }
            if($(".ajax-links-data")[0]){
                $(".ajax-links-data").remove();
            }
            //隐藏左上角的弹窗
            if(!$("#show-company-info").is(":hidden")){
                $("#show-company-info").hide();
            }
        }

        //鼠标点击空白区域，隐藏hover层
        $(document).off('click.hover').on('click.hover', function(e) {
            //e.stopPropagation();
            //console.log(e);
            // console.log(mark);
            if(e.target.className.indexOf('zrnode') != -1){
                return;
            }
            if(mark == 'move'){
                mark = 'default';
                return;
            }
            hoverHideFun();
            $(".index-search-content").hide();
        });

        //点击弹窗，不关闭
        $(".show-company-info").off('click.showinfo').on('click.showinfo', function(e) {
            e.stopPropagation();
        });

        //鼠标离开DOM执行, 正常情况下，鼠标离开时，hover层消失
        conf.$cavHoverNodes.off("mouseout").on('mouseout', '.zrnode', function(e) {
            e.stopPropagation();
            if(!$(".company-item-detail")[0] && !$(".ajax-links-data")[0]){
                hoverHideFun();
            }else{
                hoverShowFun();
            }

        });

        //鼠标点击点的时候
        $("#show-company-info").off('click.idshowinfo').on('click.idshowinfo', '.close', function(event) {
            $(this).parent().hide();
        });

        //鼠标点击点的情况
        conf.$cavHoverNodes.off('click.zrnode').on('click.zrnode', '.zrnode', function(event) {
            //第一次点击的时候，zrnodeMark 设置为 false, 如果zrnodeMark = false, 在拖动里面鼠标弹起时，hover层不消失
            //console.log("点击了：zrnode");
            event.stopPropagation();
            if(event.target.className == "name"){
                hoverHideFun();
                return;
            }
            //conf.$cavHover.show();
            var $this = $(this);
            var name = $this.attr("data-name");

            //如果按钮存在
            if($(".nodes-hover-btn")[0]){ // $(".company-item-detail").attr("data-name") != name
                //console.log("按钮存在~");
                var ajaxDo = 0;
                $(".nodes-hover-btn").remove();
                //重绘hover层
                conf.zr_hover.clear();
                require('./guanliantu_hoverNodesClick').hoverNodes(name);
                $(".zrnode[data-name='"+name+"']").trigger('click');
            }

            if($(".ajax-links-data")[0]){
                //重绘hover层
                conf.zr_hover.clear();
                require('./guanliantu_hoverNodesClick').hoverNodes(name);
            }

            //显示隐藏，还是显示扩展
            // if($(".company-check[value='"+name+"']").is(':checked')){
            //     var str = '隐藏';
            // }else{
            //     var str = '扩展';
            // }
            // var onlyShow = function(){
            //     $this.append('<div style=" width: 120px; position: absolute; left: -50px; text-align: center; top: 40px;" class="nodes-hover-btn"><a style="font-size:12px;" data-name="'+name+'" class="mt-btn-green hidden-btn" href="javascript:;">'+str+'</a></div>');
            // }
            // var twoShow = function(){
            //     if(mainToFull){
            //         $this.append('<div style=" width: 120px; position: absolute; left: -50px; text-align: center; top: 40px;" class="nodes-hover-btn">\
            //             <a style="font-size:12px;" data-name="'+name+'" class="mt-btn-green hidden-btn" href="javascript:;">'+str+'</a>\
            //             </div>');
            //     }else{
            //         $this.append('<div style=" width: 120px; position: absolute; left: -50px; text-align: center; top: 40px;" class="nodes-hover-btn"><a href="javascript:;" style="margin-right:10px; font-size:12px;" data-name="'+name+'" class="mt-btn-green detail-btn">详情</a><a style="font-size:12px;" data-name="'+name+'" class="mt-btn-green hidden-btn" href="javascript:;">'+str+'</a></div>');
            //     }
            // }
            //显示详情和隐藏
            // if(conf.linksData[name].category <= 3 && $this.attr("class").indexOf("circle") != -1){
            //     //小于3度的人，只有隐藏按钮
            //     onlyShow();
            // }else{
            //     if( conf.linksData[name].category != 0 && conf.linksData[name].category <= 3 && !$this.find(".nodes-hover-btn")[0]){
            //         twoShow();
            //     }else if(conf.linksData[name].category == 4 || conf.linksData[name].category == 0){//四度
            //         $this.append('<div style=" width: 120px; position: absolute; left: -50px; text-align: center; top: 40px;" class="nodes-hover-btn"></div>');
            //     }
            // }
            //设置详情信息
            $("#companyName-info").html(name);

            setNodeItem(name);

            if(ajaxDo==0)return;
            //人没有弹窗
            //console.log("====>",conf.linksData[name].symbol);
            if(conf.linksData[name].symbol == "circle"){
                $("#show-company-info").hide();
                return;
            }

            //加载公司的详情
            $.ajax({
                url: '/json/queryCompanyDetail.json',
                type: 'POST',
                dataType: 'json',
                data: {companyName: mtui.getQueryString("companyName"),routeCompany:name,level:$("#GLOBAL").attr("data-taoxi"),version:mtui.getQueryString("version"),degree:conf.level},
                success:function(msg){
                    // console.log(msg);
                    //显示弹窗
                    var str = '<table>\
                                <tr>\
                                    <td>注册资本</td>\
                                    <td>'+(msg.capital==undefined?'':msg.capital)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>登记状态</td>\
                                    <td>'+(msg.registation==undefined?'':msg.registation)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>关联方法人节点数</td>\
                                    <td>'+(msg.legalPersonNodes==undefined?'':msg.legalPersonNodes)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>关联方自然人节点数</td>\
                                    <td>'+(msg.naturalPersonNode==undefined?'':msg.naturalPersonNode)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>自然人股东数</td>\
                                    <td>'+(msg.naturalPersonShareholders==undefined?'':msg.naturalPersonShareholders)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>法人股东数</td>\
                                    <td>'+(msg.legalPersonShareholders==undefined?'':msg.legalPersonShareholders)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>子公司数</td>\
                                    <td>'+(msg.subsidiarys==undefined?'':msg.subsidiarys)+'</td>\
                                </tr>\
                                <tr>\
                                    <td>诉讼记录</td>\
                                    <td>'+(msg.litigationRecord==undefined?'':msg.litigationRecord)+'</td>\
                                </tr>\
                            </table>';
                    $("#companyName-des-info").html(str);
                    $("#show-company-info").show();
                }
            });


        });

        //鼠标点击节点的详情：
        $("#click-detail-show").showWindow({id:"click-detail-show"});
        conf.$cavHoverNodes.off('click.detailbtn').on('click.detailbtn', '.detail-btn', function(event) {
            event.stopPropagation();
            //getRelatedCompanyData.do
            var $this = $(this);
            var p = "";
            $.ajax({
                url: HOME_PATH+'/json/getRelatedCompanyData.json',
                type: 'POST',
                dataType: 'json',
                data: {companyName: $this.attr("data-name")},
                beforeSend : function(){
                    p = $.popup({
                        str:'详情数据加载中',
                        icon:"loading",
                        height:140,
                        showbtn:false
                    });
                },
                success:function(msg){
                    p.close();
                    
                    //console.log(msg);
                    if(msg.success != 1){
                        $.popup({
                            str:'数据分析中',
                            icon:"danger"
                        });
                        return;
                    }

                    var rst = msg.obj;

                    //股东投资
                    var gudong = "";
                    for (var i = 0; rst.basicData.shareholderDatas != null && i < rst.basicData.shareholderDatas.length; i++){
                        gudong+='<tr><td>'+rst.basicData.shareholderDatas[i].shareholderName+'</td><td>'+rst.basicData.shareholderDatas[i].shareholderType+'</td></tr>';
                    }

                    //董事会
                    var dongshihui = "";
                    for (var i = 0; rst.basicData.dsvo != null && i < rst.basicData.dsvo.length; i++) {
                        dongshihui+='<tr><td>'+rst.basicData.dsvo[i].name+'</td><td>'+(rst.basicData.dsvo[i].position==undefined?'':rst.basicData.dsvo[i].position)+'</td></tr>';
                    }

                    //监事会
                    var jianshihui = "";
                    for (var i = 0; rst.basicData.jsvo != null && i < rst.basicData.jsvo.length; i++) {
                        jianshihui+='<tr><td>'+rst.basicData.jsvo[i].name+'</td><td>'+(rst.basicData.jsvo[i].position==undefined?"":rst.basicData.jsvo[i].position)+'</td></tr>';
                    }

                    //高级管理人员
                    var gaojiguanli = "";
                    for (var i = 0; rst.basicData.jlvo != null && i < rst.basicData.jlvo.length; i++) {
                        gaojiguanli+='<tr><td>'+rst.basicData.jlvo[i].name+'</td><td>'+(rst.basicData.jlvo[i].position==undefined?'':rst.basicData.jlvo[i].position)+'</td></tr>';
                    }

                    //是否已经购买过了
                    if(!rst.buyFlag){
                        var btnStr = '<p><a href="'+HOME_PATH+'/show/buyReport.do?companyName='+rst.basicData.enterpriseData.encName+'&hisKey='+rst.basicData.enterpriseData.name+'" class="buy-btn mt-btn-green">购买报告</a></p>';
                    }else{
                        var btnStr = '<p><a href="'+HOME_PATH+'/show/getBasicData.do?companyName='+rst.basicData.enterpriseData.encName+'" class="buy-btn mt-btn-green">查看报告</a></p>'
                    }
                    if(rst.basicData.enterpriseData.companyType.indexOf('合伙') == -1){
                        var daiBiaoRen = '法定代表人';
                        var qiXian = '营业期限自';
                        var qiXian2 = '营业期限至';
                    }else{
                        var daiBiaoRen = '执行合伙人';
                        var qiXian = '合伙期限自';
                        var qiXian2 = '合伙期限至';
                    }
                    var str = '<div class="item">\
                                <h2>工商资料</h2>\
                                <table>\
                                    <tr>\
                                        <td>注册号</td><td>'+(rst.basicData.enterpriseData.regNo==undefined?"":rst.basicData.enterpriseData.regNo)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>名称</td><td>'+(rst.basicData.enterpriseData.companyName==undefined?'':rst.basicData.enterpriseData.companyName)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>类型</td><td>'+(rst.basicData.enterpriseData.companyType==undefined?'':rst.basicData.enterpriseData.companyType)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>'+daiBiaoRen+'</td><td>'+(rst.basicData.enterpriseData.frName==undefined?'':rst.basicData.enterpriseData.frName)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>注册资本</td><td>'+(rst.basicData.enterpriseData.regCap==null?"":rst.basicData.enterpriseData.regCap)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>成立日期</td><td>'+(rst.basicData.enterpriseData.esDate==undefined?'':rst.basicData.enterpriseData.esDate)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>住所</td><td>'+(rst.basicData.enterpriseData.address==undefined?'':rst.basicData.enterpriseData.address)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>'+qiXian+'</td><td>'+(rst.basicData.enterpriseData.openFrom==null?"":rst.basicData.enterpriseData.openFrom)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>'+qiXian2+'</td><td>'+(rst.basicData.enterpriseData.openTo==null?"":rst.basicData.enterpriseData.openTo)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>经营范围</td><td>'+(rst.basicData.enterpriseData.operateScope==undefined?'':rst.basicData.enterpriseData.operateScope)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>登记机关</td><td>'+(rst.basicData.enterpriseData.regOrg==undefined?'':rst.basicData.enterpriseData.regOrg)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>核准日期</td><td>'+(rst.basicData.enterpriseData.approvalDate==undefined?'':rst.basicData.enterpriseData.approvalDate)+'</td>\
                                    </tr>\
                                    <tr>\
                                        <td>登记状态</td><td>'+(rst.basicData.enterpriseData.enterpriseStatus==undefined?'':rst.basicData.enterpriseData.enterpriseStatus)+'</td>\
                                    </tr>\
                                </table>\
                            </div>\
                            <div class="item">\
                                <h2>股东情况</h2>\
                                <table>\
                                    <tr>\
                                        <th>投资方</th><th>股东类型</th>\
                                    </tr>'+gudong+'\
                                </table>\
                            </div>\
                            <div class="item">\
                                <h2>董事会情况</h2>\
                                <table>\
                                    <tr>\
                                        <th>姓名</th><th>职务</th>\
                                    </tr>'+dongshihui+'\
                                </table>\
                            </div>\
                            <div class="item">\
                                <h2>监事会情况</h2>\
                                <table>\
                                    <tr>\
                                        <th>姓名</th><th>职务</th>\
                                    </tr>'+jianshihui+'\
                                </table>\
                            </div>\
                            <div class="item">\
                                <h2>高级管理人员情况</h2>\
                                <table>\
                                    <tr>\
                                        <th>姓名</th><th>职务</th>\
                                    </tr>'+gaojiguanli+'\
                                </table>\
                            </div>\
                            <div class="more-detail">\
                                <p>更多信息，请点击</p>'+btnStr+'\
                            </div>';
                    $(".detail-content").html(str);
                    $("#click-detail-show").trigger('click');
                }//end success
            });

        });

        //checkbox选择的时候显示hover
        var showHoverWhenCheck = function($this,name){
            //console.log("===>",$this.is(":checked"));
            if(!$this.is(":checked")){
                //console.log("fun:showHoverWhenCheck, data:显示");
                if(conf.linksData[name] == undefined){
                    return
                }else{
                    var ins = conf.linksData[name].ins;
                    var outs = conf.linksData[name].outs;
                }
                var newArr = ins.concat(outs);
                var num = conf.linksData[name].num;
                var dataArr = []; //存放去掉的数据
                for(var i=0; i<newArr.length; i++){
                    var nameNew = newArr[i].name;
                    var thisLink = conf.linksData[nameNew];
                    if((thisLink.ins.length+thisLink.outs.length) == 1){
                        var num = thisLink.num;
                        dataArr.push(conf.thisNodes[num]);
                        conf.thisNodes.splice(num,1,"null");
                        //取消掉cleck事件
                        var $check = $(".company-check[value='"+nameNew+"']");
                        $check.attr("checked",false).attr("disabled","disabled");
                    }
                }
                $this.data("dataArr",dataArr);
                $this.data("newArr", newArr);
            }else{
                //console.log("fun:showHoverWhenCheck, data:隐藏");
                var newArr = $this.data("newArr");
                //如果勾上，恢复数据
                for(var i=0; i<newArr.length; i++){
                    //还原cleck事件
                    $(".company-check[value='"+newArr[i].name+"']").removeAttr('disabled').prop('checked',true);
                }
                dataArr = $this.data("dataArr");
                conf.thisNodes = conf.thisNodes.concat(dataArr);
            }
            conf.zr.clear();
            require('./guanliantu.js').iniNodes();
        };

        //鼠标点击节点的隐藏：
        conf.$cavHoverNodes.off('click.hiddenbtn').on('click.hiddenbtn', '.hidden-btn', function(event) {
            event.stopPropagation();
            //getRelatedCompanyData.do
            var $this = $(this);
            var name = $this.attr("data-name");
            var tNodes = conf.linksData[name];
            //console.log(tNodes);
            var $check = $(".company-check[value='"+name+"']");

            //重绘关系图
            if($check.is(':checked')){
                $check.attr("checked",false);
            }else{
                $check.prop('checked',true)
            }
            showHoverWhenCheck($check,name);

            //重绘hover层
            conf.zr_hover.clear();
            //require('./guanliantu_hoverNodes').hoverNodes(name);
            require('./guanliantu_hoverNodesClick').hoverNodes(name);
            $(".zrnode[data-name='"+name+"']").trigger('click');

            //设置隐藏显示
            if($check.is(':checked')){
                $(".zrnode[data-name='"+name+"']").find(".hidden-btn").html('隐藏');
                //$this.html("显示");
            }else{
                $(".zrnode[data-name='"+name+"']").find(".hidden-btn").html('扩展');
                //隐藏时，要把其他单节点的checkbox都删掉
            }
        });

        //checkbox,点击公司checkbox
        conf.$allCompany.off('click.companycheck').on('click.companycheck', '.company-check', function(e) {
            e.stopPropagation();
            //allFun();
            var $this = $(this);
            var name = $this.val();
            showHoverWhenCheck($this,name);
            hoverHideFun();
        });

        //鼠标点击节点，触发右边的点击
        conf.$allCompany.off('click.itemname').on('click.itemname', '.item-name', function(e) {
            var $this = $(this);
            var name = $this.attr("data-name");

            //如果没有打钩，点击后不响应
            if($this.siblings('.company-check')[0] && !$this.siblings('.company-check').is(":checked")){
                return false;
            }
            e.stopPropagation();

            if(!$(".company-item-detail[data-name='"+name+"']")[0]){
                //清除hover层的线，重绘
                conf.zr_hover.clear();
                require('./guanliantu_hoverNodesClick').hoverNodes(name);
                //require('./guanliantu_hoverNodes').hoverNodes(name);
                $(".zrnode[data-name='"+name+"']").trigger('click');
            }else{
                $(".company-item-detail").remove();
                hoverHideFun();
            }
        });

        //数组去重
        var unique = function(arr){
            //console.log(arr);
            var res = [];
            var json = {};
            for(var i = 0; i < arr.length; i++){
                //console.log(arr[i].name);
                if(arr[i]!=undefined && !json[arr[i].name]){
                    res.push(arr[i]);
                    json[arr[i].name] = 1;
                }
            }
            return res;
        };

        //点击 全部,股东投资，直接投资，董监高 的按钮做切换
        var showOrHideCompanyList = function(objs){
            if(objs != null){
                var $allCompany = $("#allCompany");
                $allCompany.find(".item").css("display","none");
                for(var i=0,len=objs.length; i<len; i++){
                    $allCompany.find(".item[data-name='"+objs[i].name+"']").css("display","block");
                }
                //重新设置序号
                var num = 0;
                $("#allCompany").find(".item").each(function(index, el) {
                    if(!$(this).is(':hidden')){
                        num++;
                        $(this).find('.num').html(num);
                    }
                });
            }else{
                $("#allCompany").find(".item").each(function(index, el) {
                    $(this).css("display","block").find(".num").html(index+1);
                });
            }
        };

        //显示全部
        function allFun(){
            //$(".all-company").hide();
            conf.thisNodes = deepClone(NODES);
            // conf.linksData = conf.linksData;
            //conf.allCompanyStr = [];
            conf.zr.clear();
            require('./guanliantu.js').iniNodes();
            hoverHideFun();

            //显示公司List
            showOrHideCompanyList(null);
        };

        //股东投资
        var shareholderFun = function(){
            allFun();
            conf.allCompanyStr = [];
            var centerName = conf.centerCompanyName;
            var newArr = [];
            newArr.push(conf.thisNodes[conf.linksData[centerName].num]);

            var pushArr = function(allins){
                for(var i=0; i<allins.length; i++){
                    var color = allins[i].arrow.line.style.strokeColor;
                    var line = allins[i].arrow.line.style.lineType;
                    //判断该节点是否有实线
                    if(line != 'dashed'){
                        var num = conf.linksData[allins[i].name].num;
                        newArr.push(conf.thisNodes[num]);
                    }
                    //console.log(color);
                }
            }

            //一度
            pushArr(conf.linksData[centerName].ins);
            //console.log(conf.linksData[centerName].ins);

            //二度
            var ains1 = conf.linksData[centerName].ins;
            for(var i=0; i<ains1.length; i++){
                var ains2 = conf.linksData[ains1[i].name].ins;
                // console.log(ains2);
                ains2 = ains2.concat(ains1);
                pushArr(ains2);

                //三度
                for(var j=0; j<ains2.length; j++){
                    var ains3 = conf.linksData[ains2[j].name].ins;
                    //console.log(ains3);
                    ains3 = ains3.concat(ains2);
                    pushArr(ains3);

                    //四度
                    for(var k=0; k<ains3.length; k++){
                        var ains4 = conf.linksData[ains3[k].name].ins;
                        //console.log(ains4);
                        ains4 = ains4.concat(ains3);
                        pushArr(ains4);
                    }
                }

            }
            // console.log(newArr);
            // console.log(unique(newArr));
            conf.thisNodes = unique(newArr);
            console.log(conf.thisNodes);

            conf.zr.clear();
            require('./guanliantu.js').iniNodes();
            hoverHideFun();

            //显示公司List
            showOrHideCompanyList(conf.thisNodes);

        };

        //直接投资
        var directFun = function(){
            allFun();
            //conf.thisNodes = conf.thisNodes.slice(0,20);
            //conf.thisNodes = NODES;
            // conf.linksData = conf.linksData;
            conf.allCompanyStr = [];

            var centerName = conf.centerCompanyName;
            //var linksData = conf.linksData[centerName];
            //var nowLevel = $(".active-level").attr("data-level");
            var newArr = [];

            newArr.push(conf.thisNodes[conf.linksData[centerName].num]);
            var pushArr = function(allins){
                for(var i=0; i<allins.length; i++){
                    var num = conf.linksData[allins[i].name].num;
                    newArr.push(conf.thisNodes[num]);
                }
            }

            //一度
            pushArr(conf.linksData[centerName].outs);

            //二度
            var ains1 = conf.linksData[centerName].outs;
            for(var i=0; i<ains1.length; i++){
                var ains2 = conf.linksData[ains1[i].name].outs;
                pushArr(ains2);

                //三度
                for(var j=0; j<ains2.length; j++){
                    var ains3 = conf.linksData[ains2[j].name].outs;
                    pushArr(ains3);

                    //四度
                    for(var k=0; k<ains3.length; k++){
                        var ains4 = conf.linksData[ains3[k].name].outs;
                        pushArr(ains4);
                    }
                }

            }

            conf.thisNodes = unique(newArr);

            console.log(conf.thisNodes);
            // var $company = $("#zjCompany");
            // if($company.find(".item-loading")[0]){
            //     $company.html(iniOtherList(conf.thisNodes));
            // }
            // $company.show();

            conf.zr.clear();
            require('./guanliantu.js').iniNodes();
            hoverHideFun();

            //显示公司List
            showOrHideCompanyList(conf.thisNodes);
        };

        //董监高
        var leaderFun = function(){
            allFun();
            //conf.thisNodes = NODES;
            //  conf.linksData = conf.linksData;
            conf.allCompanyStr = [];

            var centerName = conf.centerCompanyName;
            //var linksData = conf.linksData[centerName];
            //var nowLevel = $(".active-level").attr("data-level");
            var newArr = [];

            newArr.push(conf.thisNodes[conf.linksData[centerName].num]);
            //一度
            //pushArr(conf.linksData[centerName].ins);

            //二度 
            var ains1 = conf.linksData[centerName].ins;
            for(var i=0; i<ains1.length; i++){
                // console.log(ains1[i].guanlian);
                var symbol = conf.linksData[ains1[i].name].symbol;
                if(symbol == "circle"){
                    var num = conf.linksData[ains1[i].name].num;
                    //自然人不是股东
                    if(ains1[i].guanlian != '自然人' && ains1[i].guanlian != '自然人股东'){
                        newArr.push(conf.thisNodes[num]);
                    }
                }
            };

            conf.thisNodes = unique(newArr);

            //console.log(conf.thisNodes);

            conf.zr.clear();
            require('./guanliantu.js').iniNodes();
            hoverHideFun();

            //显示公司List
            showOrHideCompanyList(conf.thisNodes);
        };

        //选择类型
        var $tz = $(".tz");
        $tz.off("click").on('click', function(event) {
            $tz.removeClass('active');
            $(this).addClass('active');
            switch($(this).attr("data-type")) {
                case 'all': {//全部
                    //console.log("all");
                    allFun();
                    //$("#allCompany").show();
                };
                    break;
                case 'shareholder': { //股东投资
                    //console.log("shareholder");
                    shareholderFun();
                };
                    break;
                case 'direct': {//直接投资
                    //console.log("direct");
                    directFun();
                }
                    break;
                case 'leader': {//董监高
                    //console.log("leader");
                    leaderFun();
                };
                    break;
            }
        });

        //点击search 的结果
        $(".index-search-content").off('click.listurl').on("click.listurl", ".list-url", function(e){
            var name = $(this).attr("title");
            $(".item-name[data-name='"+name+"']").siblings('.links').trigger('click');
            $(".index-search-content").hide();
            e.stopPropagation();
        });

        //点击时间轴
        $(".dateul").off('click.dateul').on('click.dateul', 'li', function(event) {
            var midCode = mtui.getQueryString("mid");
            var companyNameCode = mtui.getQueryString("companyName");
            var level = $(".active-level").attr("data-level");
            var type = $(".select-nav .active").attr("data-type");
            var href = window.location.pathname+'?companyName='+companyNameCode+'&mid='+midCode+'&version='+$(this).attr("data-ver")+'&isopen='+$("#GLOBAL").attr("data-isopen")+"&level="+level+"&type="+type;
            window.location.href=href;
        });

        //显示关联关系
        //DomShap 对象
        function DomShap(color,symbol,coordinate,name){
            this.color = color;
            this.coordinate = coordinate;
            this.symbol = symbol;
            this.name = name;
        }
        //设置HTML代码
        var setHtml = function(zrshape){
            //console.log(zrshape);
            //如果是圆
            var domShap = new DomShap(zrshape.style.color,zrshape.symbol,{x:zrshape.style.x, y:zrshape.style.y},zrshape.companyName);
            var marginStr = "";
            if(zrshape.symbol == "circle"){
                marginStr = 'margin:-'+conf.circle_radius+'px 0 0 -'+conf.circle_radius+'px;';
            }
            return '<div data-name="'+domShap.name+'" class="zrnode '+domShap.symbol+'" style="\
            top:'+domShap.coordinate.y+'px;\
            left:'+domShap.coordinate.x+'px;\
            width:'+conf.rect_width+'px;\
            height:'+conf.rect_width+'px;'+marginStr+'\
            background:'+domShap.color+';">\
            <span class="name">'+domShap.name+'</span>\
            </div>';
        };

        var setPathHtml = function(arr,sHtml){
            var linksData = conf.linksData;// $(document).data("linksData") ;//conf.linksData;//cloneObj(conf.linksDataStatic);
            for(var i=0; i<arr.length; i++){
                var d = linksData[arr[i]];
                console.log(d);
                for(var j=0; j<d.outs.length; j++){
                    // console.log(arr[i+1]);
                    if(d.outs[j].name == arr[i+1]){
                        //console.log(d.outs[j]);
                        //绘制线,没有箭头的情况也要考虑
                        if(d.outs[j].arrow.polygon != undefined){
                            conf.zr_hover.addShape(d.outs[j].arrow.polygon);
                        }
                        conf.zr_hover.addShape(d.outs[j].arrow.line);
                        //return;
                    }
                }
                for(var j=0; j<d.ins.length; j++){
                    // console.log(arr[i+1]);
                    if(d.ins[j].name == arr[i+1]){
                        //console.log(d.outs[j]);
                        //绘制线，没有箭头的情况也要考虑
                        if(d.ins[j].arrow.polygon != undefined){
                            conf.zr_hover.addShape(d.ins[j].arrow.polygon);
                        }
                        conf.zr_hover.addShape(d.ins[j].arrow.line);
                        //return;
                    }
                }
                //绘制点
                sHtml += setHtml(d.zr_shape);
            }
            return sHtml;
        }

        conf.$allCompany.off('click.links').on('click.links', '.links', function(e) {
            //$(".item-name[data-name='"+conf.centerCompanyName+"']").trigger('click');

            //如果不可选，links无效
            if($(this).siblings('.company-check[disabled]')[0]){
                return
            }

           // allFun();
            $("#allCompany").show();
            $(".tz").removeClass('active');
            $(".tz[data-type='all']").addClass('active')

            $("#show-company-info").hide();
            e.stopPropagation();
            var $this = $(this);
            var data = {};
            data.origCompanyName = $this.siblings('.item-name').attr("data-name");
            data.targCompanyName = conf.centerCompanyName;
            data.level = conf.level;
            data.version = mtui.getQueryString("version");

            if($(".ajax-links-data[data-name='"+data.origCompanyName+"']")[0]){
                hoverHideFun();
                $(".ajax-links-data").remove();
                return;
            }

            conf.$allCompany.scrollTop($(this).parent().index()*31);

            //获取关联信息
            $.ajax({
                url: '/json/queryRelationLine.json',
                type: 'post',
                dataType: 'json',
                data:data,
                success : function(msg){
                    //console.log(msg);
                    var sHtml = "";
                    var str = "";
                    conf.zr_hover.clear();
                    $(".ajax-links-data").remove();
                    for(var k=0; k<msg.obj.length; k++){
                        var arr=[];
                        arr = msg.obj[k].split("->");
                        //console.log(arr);
                        str +='<span class="cpath" data-path="'+msg.obj[k]+'">路线'+(k+1)+"</span>";
                        str +='<p>'+msg.obj[k]+"</p>";
                        sHtml += setPathHtml(arr,sHtml);
                    }//end for
                    $this.parent().after('<div class="ajax-links-data" data-name="'+data.origCompanyName+'" style="padding:10px; font-size:12px; background:#fff;">'+str+'</div>');
                    $(".company-item-detail").remove();
                    conf.$cavHoverNodes.html(sHtml);
                    hoverShowFun();
                }//end success
            });

            //点击路线 1,2,3,4...
            conf.$allCompany.off('click.cpath2').on('click.cpath2', '.cpath', function(e) {
                e.stopPropagation();
                conf.zr_hover.clear();
                var data = $(this).attr("data-path");
                var arr = data.split("->");
                var sHtml = setPathHtml(arr,"");
                conf.$cavHoverNodes.html(sHtml);
                hoverShowFun();
            });
        });

    };//END exports

});