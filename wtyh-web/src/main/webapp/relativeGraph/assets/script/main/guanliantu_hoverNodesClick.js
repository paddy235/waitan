// 所有模块都通过 define 来定义
define(function(require, exports, module) {
	/**
    *   点击的时候 绘制一度线条 and 点 ， 点使用dom画，线条使用canvas
    */
    var conf = require('./guanliantu_conf');

    //DomShap 对象
    function DomShap(color,symbol,coordinate,name){
        this.color = color;
        this.coordinate = coordinate;
        this.symbol = symbol;
        this.name = name;
    }
    //设置HTML代码
    var setHtml = function(zrshape,center){
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
        width:'+conf.rect_width+'px;'+(center?'z-index:100;':'')+'\
        height:'+conf.rect_width+'px;'+marginStr+'\
        background:'+domShap.color+';">\
        <span class="name">'+domShap.name+'</span>\
        </div>';
    };

    exports.hoverNodes = function(companyName){
        //console.log(conf.linksData[companyName]);
        //console.log("hoverNodesClick",conf.linksData);

        var nowLinksData = conf.linksData;

       // console.log(nowLinksData);

        if(nowLinksData[companyName] == undefined){
            return
        }else{
            var ins = nowLinksData[companyName].ins;
            var outs = nowLinksData[companyName].outs;
        }
        var nowRadius = 0;
        var sHtml = "";

        //绘制原点
        nowLinksData[companyName].zr_shape.style.color = "#F00";
        sHtml += setHtml(nowLinksData[companyName].zr_shape,true);

        //从外指向里面的线 and 点
        for(var i=0; i<ins.length; i++){
            //绘制线
            //如果是圈圈，判断是否是股东
            if(nowLinksData[ins[i].name].zr_shape.symbol != 'circle'){
                var color = "#0030af";
            }else{ //不是股东就是高官咯
                if(ins[i].guanlian.indexOf('股东' == -1 && ins[i].guanlian.indexOf('自然人')) == -1){
                    var color = "#80c26a";
                }else{
                    var color = "#0030af";
                }
            }
            ins[i].arrow.line.style.strokeColor = color;
            if(ins[i].arrow.polygon != undefined){
                ins[i].arrow.polygon.style.color = color;
                conf.zr_hover.addShape(ins[i].arrow.polygon);
            }
            conf.zr_hover.addShape(ins[i].arrow.line);

            //绘制点
            if(nowLinksData[ins[i].name].zr_shape.symbol != 'circle'){
                // 如果点不是圈圈，是公司就是蓝色的
                nowLinksData[ins[i].name].zr_shape.style.color = '#0030af';
            }else{
                nowLinksData[ins[i].name].zr_shape.style.color = color;//80c26a
            }
            sHtml += setHtml(nowLinksData[ins[i].name].zr_shape,false);     
        }

        //从里指向外面的线 and 点
        for(var i=0; i<outs.length; i++){

            outs[i].arrow.line.style.strokeColor = '#F00';
            nowLinksData[outs[i].name].zr_shape.style.color = '#ffca00';

            //绘制线
            if(outs[i].arrow.polygon != undefined){
                outs[i].arrow.polygon.style.color = "#F00";
                conf.zr_hover.addShape(outs[i].arrow.polygon);
            }
            conf.zr_hover.addShape(outs[i].arrow.line);

            //绘制DOM点
            sHtml += setHtml(nowLinksData[outs[i].name].zr_shape);
        }
        conf.$cavHoverNodes.html(sHtml);

    }

});