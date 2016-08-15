// 所有模块都通过 define 来定义
define(function(require, exports, module) {
    var conf = require('./guanliantu_conf');
    var zrender = require('../zrender/zrender');
    var Circle = require('../zrender/shape/Circle'); //圆
    var Line = require('../zrender/shape/Line'); //线
    var Rectangle = require('../zrender/shape/Rectangle'); //矩形
    var TextShape = require('../zrender/shape/Text'); //文本
    var Polygon = require('../zrender/shape/Polygon'); //多边形（箭头）

    /**
     * 计算圆坐标，矩形坐标是从左上角算起的。
     * @param center：圆心坐标
     * @param radius：圆半径
     * @param angle：角度
     */
    var cal_coordinate = function(center, radius, angle) {
        var new_x = center.x + radius * Math.cos(angle * Math.PI / 180);
        var new_y = center.y + radius * Math.sin(angle * Math.PI / 180);
        var c = new Coordinate(new_x, new_y)
        return c;
    };

    /**
     * 计算正方形坐标，通过圆心坐标做换算就可以了。目前没有用到
     * @param circle_coordinate，计算出来的圆心坐标
     * @param height，正方形高度
     */
    var cal_rect_coordinate = function(circle_coordinate, height) {
        circle_coordinate.x -= height / 2;
        circle_coordinate.y -= height / 2;
        return circle_coordinate;
    };

     /**
     * 按照图形、坐标、颜色创建zrender的节点
     * @param symbol
     * @param coordinate 坐标
     * @param color
     * @returns {*}
     */
    var create_node = function(symbol, coordinate, color, text) {
        var zr_node;

        //文字
        var zrtext = new TextShape({
            style : {
                x : coordinate.x,
                y : coordinate.y,
                brushType : 'fill',
                color : "#000000",
                text : text,
                textAlign : 'center'
            },
            position:[0,20],
            scale:[conf.scaleText, conf.scaleText, coordinate.x,coordinate.y],
            zlevel: conf.zlevel,
            hoverable: false,
            clickable : false,
            hoverable: false,
            draggable: false
        });

        //节点
        if (symbol == "rect") {
            zr_node = new Rectangle({
                style: {
                    x: coordinate.x - conf.rect_width / 2,
                    y: coordinate.y - conf.rect_width / 2,
                    width: conf.rect_width,
                    height: conf.rect_width,
                    radius: 0,
                    color: color
                    // text: text,
                    // textPosition: "bottom",
                    // textBaseline: 'middle',
                    // textColor: "#000000"
                },
                symbol : "rect",
                companyName : text,
                clicktype:'company',
                hoverable: false,
                clickable : true,
                hoverable: false,
                draggable: false,
                zlevel: conf.zlevel
            })
        } else if (symbol == "circle") {
            zr_node = new Circle({
                style: {
                    x: coordinate.x,
                    y: coordinate.y,
                    r: conf.circle_radius,
                    color: color
                },
                symbol : "circle",
                companyName : text,
                clicktype:'pepole',
                hoverable: false,
                clickable: true,
                hoverable: false,
                draggable: false,
                zlevel: conf.zlevel
            })
        } else {
            if (console && console.log) {
                console.log("Unknown symbol:" + category);
            }
        }
        return {node:zr_node,text:zrtext};
    };

    /**
     * 计算箭头的旋转角度
     * @param ang
     * @param startY 起点的Y坐标
     * @param endY 终点的Y坐标
     * @returns {number} 旋转的角度
     */
    var cal_rotate = function(ang, startY, endY) {
        var rotate = 0;
        ang = Math.atan(ang);
        if (endY - startY >= 0) {
            rotate = -ang;
        } else {
            rotate = Math.PI - ang;
        }
        return rotate;
    }

    /**
     * 创建箭头+线条图形
     * @param start 起始点坐标
     * @param end 结束点坐标
     * @returns {Arrow} arrow对象，包括zrender的线条对象和zrender的多边形对象。 addflag 是否有箭头
     */
    var create_arrow = function(start, end, dotted, addflag ,linecolor) {

        //console.log("start:",start,"end:",end,"dotted:",dotted,"addflag:",addflag);

        var line = new Line({
            style: {
                xStart: start.x,
                yStart: start.y,
                xEnd: end.x,
                yEnd: end.y,
                lineWidth: 1,
                strokeColor: linecolor
            },
            z: 10,
            zlevel: conf.zlevel,
            hoverable: false,
            draggable: false,
            clickable: false,
            draggable: false
        });
        if (dotted) {
            line.style.lineType = "dashed"
        }

        //如果有箭头
        if (!addflag) {
            //console.log("有箭头");
            line.style.addflag = false;
            var offset = 10;
            var ang = (end.x - start.x) / (end.y - start.y);
            var rotate = cal_rotate(ang, start.y, end.y);
            var polygon = new Polygon({
                style: {
                    pointList: [[-5 + end.x, -10 + end.y - offset], [0 + end.x, -5 + end.y - offset], [5 + end.x, -10 + end.y - offset], [0 + end.x, 0 + end.y - offset]],
                    brushType: 'both',
                    color: linecolor
                },
                zlevel: conf.zlevel,
                z: 10,
                hoverable: false,
                draggable: false,
                clickable: false,
                draggable: false,
                rotation: [-rotate, end.x, end.y]
            });
            return {line:line, polygon: polygon};
        } else {
            return {line:line, polygon: undefined};
        }
    };

    //初始化hover事件
    var iniHoverZr = function(){
        //事件方法初始化
        conf.zr.on('mouseover', function(e) {
            //
            if(conf.linksData[e.target.companyName] == undefined)return;

            if(conf.$cavHover.is(":hidden")){
               // console.log("鼠标进入zr 的DOM上，且执行一次");
                //在hover层上展示节点，画出线
                conf.zr_hover.clear();
                require('./guanliantu_hoverNodesClick').hoverNodes(e.target.companyName);
                //hoverShowFun();
                //hoverShow == "node";
                conf.$cavHover.show();
                conf.$cavMainHover.show();
                conf.$cavHoverNodes.show();
                conf.$cavLinks.css('opacity',1);
            }
        });
    };

    //初始化画布 对象
    var iniZrenderCav = function(){
        conf.zr = zrender.init(conf.$cavNodes[0]);
        conf.zr_links = zrender.init(conf.$cavLinks[0]);
        conf.zr_hover = zrender.init(conf.$cavHover[0]);
        conf.zr_text = zrender.init(conf.$cavNodesText[0]);

        iniHoverZr();
    };

    /**
    *   设置画布的尺寸
    *   @data degree 有几度 
    */
    var setCanvasSize = function(nodesObj){
        var $canvasBox = $("#canvas-box");
        var border = 0;

        //计算出周长
        for(level in nodesObj){
            //初始化每圈的宽度
            if(level == 0){
                border = 0;
            }else{
                border += conf.radius;
            }
            //节点总长
            var nodesLen = nodesObj[level];
            //计算周长
            var perimeter = 2*Math.PI*border;
            //每圈的数量//第一圈的情况也考虑到了
            var eachNum = parseInt(perimeter/conf.eachMargin);
                eachNum = eachNum==0?1:eachNum;
            //有几圈 能有多少圈？
            var maxLevel = Math.ceil(nodesLen/eachNum);

            if(maxLevel == 1){
                eachNum = nodesLen;
            }

            //遍历每圈数据，然后渲染出来
            for(var i=0; i<maxLevel; i++){
                //如果不是第一个点，每环上面以 conf.radiusInner 的宽度进行递增
                if(level != 0){
                    border+=conf.radiusInner;
                }
            }
        }
        //console.log(border);
        border *= 2;
        border += 300; //多留100空白

        conf.$cavNodes.css({
            width: border,
            height: border
        });

        conf.$cavLinks.css({
            width: border,
            height: border
        });

        conf.$cavHover.css({
            width: border,
            height: border
        });

        $(".drag-box").css({
            width: border,
            height: border,
            top: ($canvasBox.height() - border)/2,
            left : ($canvasBox.width() - border)/2
        });

        //初始化zrender
        iniZrenderCav();
    };


    //对外提供公用方法接口
    module.exports = {
        cal_coordinate : cal_coordinate,
        cal_rect_coordinate : cal_rect_coordinate,
        create_node : create_node,
        cal_rotate : cal_rotate,
        create_arrow : create_arrow,
        iniZrenderCav :iniZrenderCav,
        setCanvasSize : setCanvasSize,
        iniHoverZr : iniHoverZr
    }
});