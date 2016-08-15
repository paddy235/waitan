//动态图是否控制全屏
var mainToFull = false;

var NODES = [];
var LINKS = [];

var HOME_PATH = '';
$(function(){

    //隐藏，显示图例说明
    var $img = $(".pic-tips").find(".t-img");
    var $GLOBAL = $("#GLOBAL");

    //套系设置
    var taoxi = $("#GLOBAL").attr("data-taoxi");
    //data.taoxi;
    if(taoxi == "A"){
        $(".levels[data-level='1']").addClass('level');
        $(".levels[data-level='2']").addClass('level');
    }else if(taoxi == "E"){
        $(".levels[data-level='1']").addClass('level');
        $(".levels[data-level='2']").addClass('level');
        $(".levels[data-level='3']").addClass('level');
    }else if(taoxi == "S"){
        $(".levels").addClass('level');
    }

    //收缩，展开说明图
    $(".pic-tips").on('click', function(event) {
        var $iconfont = $(this).find(".iconfont");
        if($img.is(':hidden')){
            $GLOBAL.attr("data-isopen",1);
            $img.show();
            $iconfont.removeClass("icon-shang").addClass('icon-xia');
        }else{
            $GLOBAL.attr("data-isopen",0);
            $img.hide();
            $iconfont.removeClass("icon-xia").addClass('icon-shang2');
        }
    });

    if(mtui.getQueryString("isopen") == 1 || mtui.getQueryString("isopen")==null){
        $GLOBAL.attr("data-isopen",1);
        $img.show();
    }else{
        $GLOBAL.attr("data-isopen",0);
        $img.hide();
    }


    //收缩侧边栏
    var $sidebox = $(".sidebox");
    var $canvasBox = $("#canvas-box");
    var $correlationTips = $(".correlation-tips");
    var setCanvasCenter = function(){
        //canvas-box 居中
        var $dragBox = $(".drag-box");
        var $newCavsBox = $("#canvas-box");
        var w = $newCavsBox.width();
        var h = $newCavsBox.height();
        var dw = $dragBox.width();
        var dh = $dragBox.height();
        $dragBox.css({
            "left":(w-dw)/2,
            "top":(h-dh)/2
        });
    };
    $(".sidebtn").on('click', function(event) {
        var speed = 500;
        if(parseInt($sidebox.css("right")) < 0){

            $(this).removeAttr('style');

            $correlationTips.animate({
                "right" : "300px"
            }, speed);
            $sidebox.animate({
                "right" : 6+"px"
            }, speed,function(){
                $canvasBox.css("margin-right","280px");
                setCanvasCenter();
            });
        }else{
            $(this).css({
                "-moz-transform":"scaleX(-1)",
                "-webkit-transform":"scaleX(-1)",
                "-o-transform":"scaleX(-1)",
                "transform":"scaleX(-1)"
            });
            
            $sidebox.animate({
                "right" : -280+"px"
            }, speed, function(){
                $canvasBox.css("margin-right","0");
                setCanvasCenter();
            });
            $correlationTips.animate({
                "right" : "30px"
            }, speed);
        }
    });
    
    // 路径配置
    // seajs.use("/build/relativeGraph/assets/script/main/guanliantu.js");

    $(".nav_right").removeClass("active").eq(0).addClass("active")

    //下载Excel
    //console.log(window.location);
    $(".down-excel").attr("href",HOME_PATH+'/show2/downloadExcel2.do?companyName='+mtui.getQueryString("companyName"));

    //下载每个的
    $("#allCompany").on('click', '.down', function(event) {
        location.href = HOME_PATH+'/show2/downloadExcel2Single.do?nodeName='+$(this).siblings('.item-name').attr("data-name")+'&companyName='+mtui.getQueryString("companyName");
    });

    //恢复默认
    $(".reset-old").on('click', function(event) {
        $.ajax({
            url: '/json/resetCompany.json',
            type: 'post',
            dataType: 'json',
            data: {targetCompanyName:mtui.getQueryString("companyName") },
            success:function(msg){
                if(msg.success == '1'){
                    var cback = function(){
                        //location.reload('/');
                        window.location.href = '/'
                    }
                    $.popup({
                        str:'恢复成功',
                        time: 1000,
                        showbtn:false,
                        height:130,
                        close: false,
                        closeback:cback
                    });
                }else{
                    $.popup({
                        str:msg.msg
                    })
                }
            }
        });
        
    });

});
