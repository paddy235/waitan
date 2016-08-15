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
        //console.log("hoverNodes",conf.linksData);
        var newlinksData = conf.linksData;
        if(newlinksData[companyName] == undefined){
            return
        }else{
            var ins = newlinksData[companyName].ins;
            var outs = newlinksData[companyName].outs;
        }
        var nowRadius = 0;
        var sHtml = "";

        //绘制原点
        sHtml += setHtml(newlinksData[companyName].zr_shape,true);

        //从里指向外的线 and 点
        for(var i=0; i<ins.length; i++){
            //绘制线
            if(ins[i].arrow.polygon != undefined){
                conf.zr_hover.addShape(ins[i].arrow.polygon);
            }
            conf.zr_hover.addShape(ins[i].arrow.line);

            //绘制点
            sHtml += setHtml(newlinksData[ins[i].name].zr_shape,false);
            
        }

        //从外指向里面的线 and 点
        for(var i=0; i<outs.length; i++){
            //绘制线
            if(outs[i].arrow.polygon != undefined){
                conf.zr_hover.addShape(outs[i].arrow.polygon);
            }
            conf.zr_hover.addShape(outs[i].arrow.line);

            //绘制DOM点
            sHtml += setHtml(newlinksData[outs[i].name].zr_shape);
        }
        conf.$cavHoverNodes.html(sHtml);

    }

});