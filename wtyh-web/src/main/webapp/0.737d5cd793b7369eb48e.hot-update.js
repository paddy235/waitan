webpackHotUpdate(0,{

/***/ 737:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(738);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*
	    散点图 气泡图

	    调用方式：
	    const option ={
	          color:["#a40000"],
	          title:"",
	          companyInfo:[
	          {
	            name:"海东泰金融投资有限公司",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司1",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司2",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司3",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司4",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          }
	          ],
	          yAxisName:"动态风险指数",
	          xAxisName:"静态风险指数",
	          series:[
	            {
	                name:'风险指数',
	                type:'scatter',
	                data: [
	                    [161.2, 51.6], 
	                    [167.5, 59.0], 
	                    [159.5, 49.2], 
	                    [157.0, 63.0], 
	                    [155.8, 53.6]
	                ]
	            }
	          ]
	      }
	*/
	var BBDscatterBuble = _react2.default.createClass({
	    displayName: 'BBDscatterBuble',

	    propTypes: {
	        option: _react2.default.PropTypes.object.isRequired,
	        style: _react2.default.PropTypes.object,
	        className: _react2.default.PropTypes.string,
	        theme: _react2.default.PropTypes.string,
	        onChartReady: _react2.default.PropTypes.func,
	        showLoading: _react2.default.PropTypes.bool,
	        onEvents: _react2.default.PropTypes.object
	    },
	    setOption: function setOption(parm) {
	        var seriesLineData = [];
	        var option = {
	            color: parm.color || ["green"],
	            textStyle: {
	                color: "#fff"
	            },
	            title: {
	                text: parm.title == undefined ? "" : parm.title,
	                padding: [10, 0, 0, 15],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: parm.grid == undefined ? { left: '3%', right: '10%', bottom: '3%', containLabel: true } : parm.grid,
	            visualMap: {
	                type: 'continuous',
	                min: 0,
	                max: 200,
	                right: '4%',
	                bottom: '8%',
	                textStyle: {
	                    color: "#fff"
	                },
	                inRange: {
	                    colorLightness: [1, 0.5]
	                },
	                controller: {
	                    inRange: {
	                        symbolSize: [10, 200],
	                        color: ['#e14341']
	                    }
	                },
	                text: ['高', '低'], // 文本，默认为数值文本
	                calculable: true
	            },
	            tooltip: {
	                position: 'top',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(data) {
	                    var dataIndex = data.dataIndex;
	                    var opr = '<div class="scatter-bubble-tip">' + '<h4>' + parm.companyInfo[dataIndex].name + '</h4>' + '<ul>' + '<li>注册资本：<span class="c-blue">' + parm.companyInfo[dataIndex].regCapital + '</span></li>' + '<li>法人代表：<span class="c-blue">' + parm.companyInfo[dataIndex].corporate + '</span></li>' + '<li>公司类型：<span class="c-blue">' + parm.companyInfo[dataIndex].companyType + '</span></li>' + '<li>成立时间：<span class="c-blue">' + parm.companyInfo[dataIndex].foundDate + '</span></li>' + '<li>静态风险指数：<span class="c-blue">' + data.value[0] + '</span></li>' + '<li>动态风险指数：<span class="c-blue">' + data.value[1] + '</span></li>' + '</ul>' + '</div>';
	                    return opr;
	                }
	            },
	            xAxis: [{
	                name: parm.xAxisName || "",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            yAxis: [{
	                name: parm.yAxisName || "",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            series: parm.series
	        };
	        return option;
	    },
	    componentDidMount: function componentDidMount() {
	        var echartObj = this.renderEchartDom();
	        var onEvents = this.props.onEvents || [];

	        var _loop = function _loop(eventName) {
	            if (typeof eventName === 'string' && typeof onEvents[eventName] === 'function') {
	                echartObj.on(eventName, function (param) {
	                    onEvents[eventName](param, echartObj);
	                });
	            }
	        };

	        for (var eventName in onEvents) {
	            _loop(eventName);
	        }
	        $(window).resize(function () {
	            echartObj.resize();
	        });
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        this.renderEchartDom();
	    },
	    componentWillUnmount: function componentWillUnmount() {
	        echarts.dispose(this.refs.chart);
	    },
	    renderEchartDom: function renderEchartDom() {
	        var echartObj = this.getEchartsInstance();
	        //===============================================================================
	        echartObj.setOption(this.setOption(this.props.option));
	        //===============================================================================
	        if (this.props.showLoading) {
	            echartObj.showLoading();
	        } else {
	            echartObj.hideLoading();
	        }
	        return echartObj;
	    },
	    getEchartsInstance: function getEchartsInstance() {
	        return echarts.getInstanceByDom(this.refs.echartsDom) || echarts.init(this.refs.echartsDom, this.props.theme);
	    },
	    render: function render() {
	        var style = this.props.style || {
	            height: '100%', width: "100%"
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDscatterBuble;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterBubbleChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})