webpackHotUpdate(0,{

/***/ 811:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDLineBar = _react2.default.createClass({
	    displayName: 'BBDLineBar',

	    // propTypes: {
	    //     param: React.PropTypes.object.isRequired,
	    //     style: React.PropTypes.object,
	    //     className: React.PropTypes.string,
	    //     theme: React.PropTypes.string,
	    //     onChartReady: React.PropTypes.func,
	    //     showLoading: React.PropTypes.bool,
	    //     onEvents: React.PropTypes.object
	    // },
	    setOption: function setOption(parm) {
	        var seriesBarData = [];
	        if (parm.series.bar) {
	            if (!parm.series.line) {
	                for (var i = 0; i < parm.series.bar.length; i++) {
	                    var seriesBarItem = {
	                        name: parm.barName[i],
	                        type: 'bar',
	                        label: {
	                            normal: {
	                                show: parm.labelShow || false,
	                                position: parm.lablePosition || "top",
	                                textStyle: {
	                                    color: "#fff"
	                                }
	                            }
	                        },
	                        stack: parm.stack == undefined ? "" : parm.stack,
	                        barWidth: parm.barWidth == undefined ? "auto" : parm.barWidth,
	                        data: parm.series.bar[i],
	                        itemStyle: parm.itemStyle || {
	                            normal: {},
	                            emphasis: {}
	                        }
	                    };
	                    if (i == parm.series.bar.length - 1) {
	                        seriesBarItem["yAxisIndex"] = 1;
	                    }
	                    seriesBarData.push(seriesBarItem);
	                }
	            } else {
	                for (var i = 0; i < parm.series.bar.length; i++) {
	                    var seriesBarItem = {
	                        name: parm.barName[i],
	                        type: 'bar',
	                        label: {
	                            normal: {
	                                show: parm.labelShow || false,
	                                position: parm.lablePosition || "top",
	                                textStyle: {
	                                    color: "#fff"
	                                }
	                            }
	                        },
	                        stack: parm.stack == undefined ? "" : parm.stack,
	                        barWidth: parm.barWidth == undefined ? "auto" : parm.barWidth,
	                        data: parm.series.bar[i],
	                        itemStyle: parm.itemStyle || {
	                            normal: {},
	                            emphasis: {}
	                        }
	                    };
	                    seriesBarData.push(seriesBarItem);
	                }
	            }
	        }
	        var barAreaStyle = {};
	        if (parm.series.line) {
	            for (var j = 0; j < parm.series.line.length; j++) {
	                var seriesBarItem = {
	                    name: parm.lineName[j],
	                    type: 'line',
	                    yAxisIndex: 1,
	                    symbolSize: parm.symbolSize,
	                    data: parm.series.line[j]
	                };
	                seriesBarData.push(seriesBarItem);
	            }
	        }
	        console.log(seriesBarData, "csy");
	        var option = {
	            color: parm.color,
	            title: {
	                show: parm.titleShow == undefined ? false : parm.titleShow,
	                link: parm.link || "",
	                target: "self",
	                text: parm.title,
	                x: parm.titleX,
	                padding: [25, 0, 0, 5],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 14,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            tooltip: {
	                trigger: 'axis',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    var info = v[0].name + "<br/>";
	                    for (var i = 0; i < v.length; i++) {
	                        var _until = "";
	                        if (parm.unit == undefined) {
	                            _until = "";
	                        } else {
	                            _until = parm.unit[i];
	                        }
	                        var _spanCorlor = '<span style=color:' + parm.color[i] + '>' + v[i].value + _until + '</span><br/>';
	                        info += v[i].seriesName + " :&nbsp;" + _spanCorlor;
	                    }
	                    return info;
	                },
	                axisPointer: {
	                    type: 'none'
	                }
	            },
	            legend: {
	                padding: [15, 0, 0, 0],
	                itemGap: 5,
	                itemWidth: 20,
	                itemHeight: 5,
	                width: parm.legendWidth || "auto",
	                show: parm.legendShow == undefined ? false : parm.legendShow,
	                left: parm.legendLeft == undefined ? "auto" : parm.legendLeft,
	                right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	                bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	                top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	                data: parm.legend,
	                textStyle: {
	                    color: "#99a3b7",
	                    fontSize: 12,
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: {
	                left: parm.gridLeft || '5%',
	                right: parm.gridRight || '5%',
	                bottom: parm.gridBottom == undefined ? "15%" : parm.gridBottom,
	                containLabel: true
	            },
	            xAxis: [{
	                name: parm.Xname || "",
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                type: parm.Xtype || 'category',
	                data: parm.xAxis || [],
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
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            }],
	            yAxis: [{
	                type: parm.Ytype || 'value',
	                data: parm.yAxis || [],
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[0],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                nameLocation: parm.YnameLocation || "end",
	                nameRotate: parm.YnameRoutate || 0,
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.axisLabelL == undefined ? true : parm.axisLabelL,
	                    formatter: parm.yFlag == undefined ? '{value}' : '{value}' + parm.yFlag,
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }, {
	                type: parm.Ytype || 'value',
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[1],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: parm.yAxis || [],
	                nameLocation: parm.YnameLocation || "end",
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: false
	                },
	                axisLine: {
	                    show: parm.axisLineR == undefined ? true : parm.axisLineR,
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.axisLabelR == undefined ? true : parm.axisLabelR,
	                    formatter: parm.y2Flag == undefined ? '{value}' : '{value}' + parm.y2Flag,
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }],
	            series: seriesBarData
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
	        // if (typeof this.props.onChartReady === 'function') this.props.onChartReady(echartObj);
	        // elementResizeEvent(this.refs.echartsDom, function() {
	        //  echartObj.resize();
	        // });
	        //
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
	        echartObj.setOption(this.setOption(this.props.param));
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
	            height: '300px'
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDLineBar;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineBarChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})