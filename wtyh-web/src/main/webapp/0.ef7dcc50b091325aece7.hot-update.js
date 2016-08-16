webpackHotUpdate(0,{

/***/ 798:
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
	                // formatter: function (v) {
	                //     var v1 = "<span style='color: #00b8ee'>" + v[0].value + "</span>";
	                //     var v2 = "<span style='color: #f7b650'>" + v[1].value + "</span>";
	                //     return v[0].name + "<br/>" + v[0].seriesName + "：" + v1 + "<br/>" + v[1].seriesName + "：" + v2;
	                //     return v[0].name + "<br/>" + v[0].seriesName + "£º" + v1 + "<br/>" + v[1].seriesName + "£º" + v2;
	                // },
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
	                // name: !!parm.yAxisName?parm.yAxisName[0] : "",
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
	                // name: !!parm.yAxisName?parm.yAxisName[1] : "",
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

/***/ },

/***/ 816:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(817);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _P2PIndexAction = __webpack_require__(819);

	var P2PIndexActionCreaters = _interopRequireWildcard(_P2PIndexAction);

	var _setHeight = __webpack_require__(721);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(740);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _devTrend = __webpack_require__(820);

	var _devTrend2 = _interopRequireDefault(_devTrend);

	var _volume = __webpack_require__(823);

	var _volume2 = _interopRequireDefault(_volume);

	var _map = __webpack_require__(824);

	var _map2 = _interopRequireDefault(_map);

	var _areaRanking = __webpack_require__(825);

	var _areaRanking2 = _interopRequireDefault(_areaRanking);

	var _problemScale = __webpack_require__(827);

	var _problemScale2 = _interopRequireDefault(_problemScale);

	var _IndustrySentiment = __webpack_require__(828);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _netCreditContrast = __webpack_require__(829);

	var _netCreditContrast2 = _interopRequireDefault(_netCreditContrast);

	var _netCredit = __webpack_require__(826);

	var _netCredit2 = _interopRequireDefault(_netCredit);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//网贷平台数据展示
	//p2p行业监测
	//行业人气
	//上海区域发展指数排名
	//成交量和综合利率
	var P2PIndex = _react2.default.createClass({
	    displayName: 'P2PIndex',

	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-index-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-top clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-l' },
	                        _react2.default.createElement(_devTrend2.default, this.props),
	                        _react2.default.createElement(_volume2.default, this.props)
	                    ),
	                    _react2.default.createElement(_map2.default, null),
	                    _react2.default.createElement(_areaRanking2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-bom clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bom-l' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'bom-l-t' },
	                            _react2.default.createElement(_problemScale2.default, this.props),
	                            _react2.default.createElement(_IndustrySentiment2.default, this.props)
	                        ),
	                        _react2.default.createElement(_netCreditContrast2.default, this.props)
	                    ),
	                    _react2.default.createElement(_netCredit2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PIndex;

	//将 request  result 绑定到props的request result
	//网贷对比
	//问题平台比例
	//地图
	//新增平台发展趋势
	function mapStateToProps(state) {
	    return {
	        devTrendRequest: state.DevTrend.request,
	        devTrendResult: state.DevTrend.result,

	        volumeRequest: state.Volume.request,
	        volumeResult: state.Volume.result,

	        mapRequest: state.Map.request,
	        mapResult: state.Map.result,

	        areaRankingRequest: state.AreaRanking.request,
	        areaRankingResult: state.AreaRanking.result,

	        problemScaleRequest: state.ProblemScale.request,
	        problemScaleResult: state.ProblemScale.result,

	        industrySentimentRequest: state.IndustrySentiment.request,
	        industrySentimentResult: state.IndustrySentiment.result,

	        netCreditContrastRequest: state.NetCreditContrast.request,
	        netCreditContrastResult: state.NetCreditContrast.result,

	        netCreditRequest: state.NetCredit.request,
	        netCreditResult: state.NetCredit.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 818:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".p2p-index .radius4,\r\n.p2p-portrait .radius4 {\r\n\tborder-radius: 5px;\t/*background: #2b323c;*/\r\n}\r\n\r\n.p2p-index .p2p-index-content,\r\n.p2p-portrait .p2p-portrait-content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.p2p-index .p2p-index-top .top-r {\r\n\twidth: 32.5%;\r\n\theight: 649px;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-r td a {\r\n\tcolor: #e14340\r\n}\r\n\r\n.header-gray .title {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tmargin-left: 30px;\r\n}\r\n\r\n.p2p-index .wtyh-table td,\r\n.p2p-portrait .wtyh-table td {\r\n\tpadding: 16px 0px;\t/*padding: 0px 0px !important;*/\r\n}\r\n\r\n.v-aglign-t {\r\n\tvertical-align: top;\r\n}", ""]);

	// exports


/***/ },

/***/ 819:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getDevTrendRequest = getDevTrendRequest;
	exports.getvolumeRequest = getvolumeRequest;
	exports.getMapRequest = getMapRequest;
	exports.getAreaRankRequest = getAreaRankRequest;
	exports.getNetCreditRequest = getNetCreditRequest;
	exports.getProblemScaleRequest = getProblemScaleRequest;
	exports.getIndustrySRequest = getIndustrySRequest;
	exports.getNetCreditConCRequest = getNetCreditConCRequest;
	/*
	  P2P平台监测
	*/

	/*上海新增平台发展趋势begin*/
	var DEVTREND_REQUEST_SUCCESS = exports.DEVTREND_REQUEST_SUCCESS = 'DEVTREND_REQUEST_SUCCESS';
	var DEVTREND_REQUEST_FAIL = exports.DEVTREND_REQUEST_FAIL = 'DEVTREND_REQUEST_FAIL';

	function devTrendRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DEVTREND_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function devTrendRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: DEVTREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getDevTrendRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(devTrendRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(devTrendRequestFail(result));
	      }
	    });
	  };
	}
	/*上海新增平台发展趋势end*/

	/*成交量和综合利率begin*/
	var VOLUME_REQUEST_SUCCESS = exports.VOLUME_REQUEST_SUCCESS = 'VOLUME_REQUEST_SUCCESS';
	var VOLUME_REQUEST_FAIL = exports.VOLUME_REQUEST_FAIL = 'VOLUME_REQUEST_FAIL';

	function volumeRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: VOLUME_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function volumeRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: DEVTREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getvolumeRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(volumeRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(volumeRequestFail(result));
	      }
	    });
	  };
	}
	/*成交量和综合利率end*/

	/*地图begin*/
	var MAP_REQUEST_SUCCESS = exports.MAP_REQUEST_SUCCESS = 'MAP_REQUEST_SUCCESS';
	var MAP_REQUEST_FAIL = exports.MAP_REQUEST_FAIL = 'MAP_REQUEST_FAIL';

	function mapRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: MAP_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function mapRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: MAP_REQUEST_FAIL,
	    result: result
	  };
	}

	function getMapRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(mapRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(mapRequestFail(result));
	      }
	    });
	  };
	}
	/*地图end*/

	/*  上海区域发展指数排名begin*/
	var AREARANK_REQUEST_SUCCESS = exports.AREARANK_REQUEST_SUCCESS = 'AREARANK_REQUEST_SUCCESS';
	var AREARANK_REQUEST_FAIL = exports.AREARANK_REQUEST_FAIL = 'AREARANK_REQUEST_FAIL';

	function areaRankRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: AREARANK_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function areaRankRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: AREARANK_REQUEST_FAIL,
	    result: result
	  };
	}

	function getAreaRankRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/areaIndex.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(areaRankRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(areaRankRequestFail(result));
	      }
	    });
	  };
	}
	/*上海区域发展指数排名end


	/*  网贷平台数据展示begin*/
	var NETCREDIT_REQUEST_SUCCESS = exports.NETCREDIT_REQUEST_SUCCESS = 'NETCREDIT_REQUEST_SUCCESS';
	var NETCREDIT_REQUEST_FAIL = exports.NETCREDIT_REQUEST_FAIL = 'NETCREDIT_REQUEST_FAIL';

	function netCreditRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NETCREDIT_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function netCreditRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NETCREDIT_REQUEST_FAIL,
	    result: result
	  };
	}

	function getNetCreditRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/platRankData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(netCreditRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(netCreditRequestFail(result));
	      }
	    });
	  };
	}
	/*网贷平台数据展示end*/

	/*  问题平台比例begin*/
	var PROBLEMSCALE_REQUEST_SUCCESS = exports.PROBLEMSCALE_REQUEST_SUCCESS = 'PROBLEMSCALE_REQUEST_SUCCESS';
	var PROBLEMSCALE_REQUEST_FAIL = exports.PROBLEMSCALE_REQUEST_FAIL = 'PROBLEMSCALE_REQUEST_FAIL';

	function problemScaleRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: PROBLEMSCALE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function problemScaleRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: PROBLEMSCALE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getProblemScaleRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(problemScaleRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(problemScaleRequestFail(result));
	      }
	    });
	  };
	}
	/*问题平台比例end*/

	/*行业人气 begin*/
	var INDUSTRYS_REQUEST_SUCCESS = exports.INDUSTRYS_REQUEST_SUCCESS = 'INDUSTRYS_REQUEST_SUCCESS';
	var INDUSTRYS_REQUEST_FAIL = exports.INDUSTRYS_REQUEST_FAIL = 'INDUSTRYS_REQUEST_FAIL';

	function industrySRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INDUSTRYS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function industrySRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: INDUSTRYS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getIndustrySRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(industrySRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(industrySRequestFail(result));
	      }
	    });
	  };
	}
	/*行业人气 end*/

	/*网贷对比 begin*/
	var NETCREDITCON_REQUEST_SUCCESS = exports.NETCREDITCON_REQUEST_SUCCESS = 'NETCREDITCON_REQUEST_SUCCESS';
	var NETCREDITCON_REQUEST_FAIL = exports.NETCREDITCON_REQUEST_FAIL = 'NETCREDITCON_REQUEST_FAIL';

	function netCreditConRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NETCREDITCON_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function netCreditConRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NETCREDITCON_REQUEST_FAIL,
	    result: result
	  };
	}

	function getNetCreditConCRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(netCreditConRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(netCreditConRequestFail(result));
	      }
	    });
	  };
	}
	/*网贷对比 end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 820:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(798);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	    "color": ["#12b5b0", "#e24441"],
	    "legend": ["上海新增", "上海累计"],
	    "legendShow": true,
	    "legendRight": "30",
	    "barName": ["上海新增"],
	    "lineName": ["上海累计"],
	    "yFlag": "",
	    "barWidth": 20,
	    "xAxis": [],
	    "yAxisName": ["平台数量(家数)", ""],
	    "symbolSize": 5,
	    "axisLabelR": false,
	    "axisLineR": false,
	    "series": {}
	};
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"];
	        baseParm.series = {
	            "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	            "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	        };
	        return baseParm;
	    },

	    componentDidMount: function componentDidMount() {
	        var getDevTrendRequest = this.props.getDevTrendRequest;

	        var jsonData = {};
	        getDevTrendRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.devTrendRequest, this.props.devTrendResult);
	        if (!isEqual) {
	            var devTrendRequest = nextProps.devTrendRequest;
	            var devTrendResult = nextProps.devTrendResult;

	            if (devTrendRequest == true) {
	                console.log("redux测试成功=================devTrendRequest");
	                if (devTrendResult.code == 200) {
	                    baseParm.xAxis = devTrendResult.content.xAxis;
	                    baseParm.series = devTrendResult.content.series;
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-l-t radius4', id: 'devTrend' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海新增平台发展趋势'
	                )
	            ),
	            _react2.default.createElement(_LineBarChart2.default, {
	                param: this.setParm(),
	                style: { height: '300px', width: '100%' } })
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "devTrend.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 822:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*content banner*/\r\n\r\n/*index top*/\r\n.p2p-index .p2p-index-top .top-l {\r\n\twidth: 28%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-index-top .top-l .top-l-t {\r\n\twidth: 100%;\r\n\theight: 300px;\r\n}\r\n\r\n.p2p-index-top .top-l  .top-l-b {\r\n\tmargin-top: 2%;\r\n\theight: 340px;\r\n}\r\n\r\n.p2p-index .p2p-index-top .top-c {\r\n\twidth: 38.5%;\r\n\tfloat: left;\r\n\theight: 649px;\r\n\tmargin: 0px 0.5%;\r\n}\r\n\r\n.p2p-index .p2p-index-top .top-r {\r\n\twidth: 32.5%;\r\n\theight: 649px;\r\n\tfloat: left;\r\n}\r\n\r\n/*index bom*/\r\n.p2p-index .p2p-index-bom {\r\n\tmargin-top: 0.5%;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-l {\r\n\twidth: 67%;\r\n\tfloat: left;\r\n\theight: 490px;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-l .bom-l-t {\r\n\theight: 255px;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-l .bom-l-t .bom-l-t-l {\r\n\twidth: 42%;\t/*height: 100%;*/\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-l .bom-l-t .bom-l-t-r {\r\n\twidth: 57.5%;\t/*height: 100%;*/\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-l .bom-l-b {\r\n\theight: 230px;\r\n\tmargin-top: 0.5%;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-r {\r\n\twidth: 32.5%;\r\n\tmargin-left: 0.5%;\r\n\theight: 490px;\r\n\tfloat: left;\r\n}\r\n\r\n/*AareaRanking banner -css*/\r\n.p2p-index .list-header {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tpadding: 14px;\r\n\ttext-indent: 30px;\r\n}\r\n\r\n.p2p-index .list-items {\r\n\tpadding: 0px 10px 30px 10px;\r\n}\r\n\r\n.p2p-index .table-8 th,\r\n.p2p-index .table-8 td {\r\n\twidth: 12.5%;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-index .table-8 th {\r\n\theight: 60px;\r\n}\r\n\r\n.p2p-index .table-6 th {\r\n\theight: 88px;\r\n}\r\n\r\n.p2p-index .table-8 {\r\n\r\n\t/*height: 550px;*/\r\n}\r\n\r\n.p2p-index .table-6 th,\r\n.p2p-index .table-6 td {\r\n\twidth: 13.5%;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-index .table-6 .diff-width {\r\n\twidth: 20%;\r\n}\r\n\r\n.p2p-index .table-6 {\r\n\theight: 400px;\r\n}\r\n\r\n.p2p-index .table-8.title {\r\n\tdisplay: block;\r\n\twidth: 100%\r\n}\r\n\r\n/*gray-theme-table for table -css*/\r\n.p2p-table {\r\n\twidth: 100%;\t/*height: 100%;*/\r\n\tcolor: #dddddd;\r\n}\r\n\r\n.p2p-table .icon-desc {\r\n\tcolor: #fff;\r\n\tfont-size: 24px;\r\n\tcursor: pointer;\t/*display: inline-block;*/\r\n}", ""]);

	// exports


/***/ },

/***/ 823:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(798);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	    "color": ["#12b5b0", "#e24441"],
	    "legend": ["上海新增", "上海累计"],
	    "legendShow": true,
	    "legendRight": "30",
	    "barName": ["上海新增"],
	    "lineName": ["上海累计"],
	    "yFlag": "",
	    "barWidth": 20,
	    "xAxis": [],
	    "yAxisName": ["平台数量(家数)", ""],
	    "symbolSize": 5,
	    "axisLabelR": false,
	    "axisLineR": false,
	    "series": {}
	};
	var volume = _react2.default.createClass({
	    displayName: 'volume',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = {
	            "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	            "line": [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]]
	        };

	        return baseParm;
	    },
	    componentDidMount: function componentDidMount() {
	        var getvolumeRequest = this.props.getvolumeRequest;

	        var jsonData = {};
	        getvolumeRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.volumeRequest, this.props.volumeResult);
	        if (!isEqual) {
	            var volumeRequest = nextProps.volumeRequest;
	            var volumeResult = nextProps.volumeResult;

	            if (volumeRequest == true) {
	                console.log("redux测试成功=================getvolumeRequest");
	                if (volumeResult.code == 200) {
	                    baseParm.xAxis = volumeResult.content.xAxis;
	                    baseParm.series = volumeResult.content.series;
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-l-b radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '成交量和综合利率'
	                )
	            ),
	            _react2.default.createElement(_LineBarChart2.default, {
	                param: this.setParm(),
	                style: { height: '300px', width: '100%' } })
	        );
	    }
	});

	module.exports = volume;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "volume.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 825:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	var AareaRanking = _react2.default.createClass({
					displayName: 'AareaRanking',

					getInitialState: function getInitialState() {
									return {
													listData: []
									};
					},
					componentDidMount: function componentDidMount() {
									var getAreaRankRequest = this.props.getAreaRankRequest;

									var jsonData = {};
									getAreaRankRequest(jsonData);
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.areaRankingRequest, this.props.areaRankingResult);
									if (!isEqual) {
													var areaRankingRequest = nextProps.areaRankingRequest;
													var areaRankingResult = nextProps.areaRankingResult;

													if (areaRankingRequest == true) {
																	console.log("redux测试成功=================areaRankingRequest");
																	if (areaRankingResult.success) {
																					this.setState({ listData: areaRankingResult.content });
																					// baseParm.xAxis=areaRankingResult.content.xAxis
																					// baseParm.series=areaRankingResult.content.series
																	} else {
																									//错误后提示
																					}
													}
									}
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ className: 'mod top-r radius4' },
													_react2.default.createElement(
																	'div',
																	{ className: 'mod-title' },
																	_react2.default.createElement(
																					'h3',
																					null,
																					'上海区域发展指数'
																	)
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'list-items' },
																	_react2.default.createElement(
																					'table',
																					{ className: 'p2p-table  table-8 mt-table wtyh-table' },
																					_react2.default.createElement(
																									'tHead',
																									null,
																									_react2.default.createElement(
																													'tr',
																													null,
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	'省份'
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'生态环境'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'规模'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'人气'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'安全'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'资本认可'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'综合竞争'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'上半年排名'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													)
																									)
																					),
																					_react2.default.createElement(
																									'tbody',
																									null,
																									this.state.listData.map(function (item, index) {
																													{
																																	if (index % 2) {
																																					return _react2.default.createElement(
																																									'tr',
																																									null,
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.area
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.ecosystem
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.scale
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.popularity
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.safety
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.recognition
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.competitiveness
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									)
																																					);
																																	} else {
																																					return _react2.default.createElement(
																																									'tr',
																																									{ className: 'odd-line' },
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.area
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.ecosystem
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.scale
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.popularity
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.safety
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.recognition
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.competitiveness
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									)
																																					);
																																	}
																													}
																									})
																					)
																	)
													)
									);
					}
	});

	module.exports = AareaRanking;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "areaRanking.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 826:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var NetCredit = _react2.default.createClass({
					displayName: 'NetCredit',

					getInitialState: function getInitialState() {
									return {
													listData: []
									};
					},
					componentDidMount: function componentDidMount() {
									var getNetCreditRequest = this.props.getNetCreditRequest;

									var jsonData = {};
									getNetCreditRequest(jsonData);
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.netCreditRequest, this.props.netCreditResult);
									if (!isEqual) {
													var netCreditRequest = nextProps.netCreditRequest;
													var netCreditResult = nextProps.netCreditResult;

													if (netCreditRequest == true) {
																	// console.log("redux测试成功=================netCreditRequest")
																	if (netCreditResult.success) {
																					this.setState({ listData: netCreditResult.content });
																	} else {
																					//错误后提示
																	}
													}
									}
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ className: 'mod bom-r radius4' },
													_react2.default.createElement(
																	'div',
																	{ className: 'mod-title' },
																	_react2.default.createElement(
																					'h3',
																					null,
																					'上海网贷平台数据展示'
																	)
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'list-items' },
																	_react2.default.createElement(
																					'table',
																					{ className: 'table-6 mt-table wtyh-table' },
																					_react2.default.createElement(
																									'tHead',
																									null,
																									_react2.default.createElement(
																													'tr',
																													null,
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	'排名',
																																	_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	'平台名称'
																													),
																													_react2.default.createElement(
																																	'th',
																																	{ className: 'diff-width' },
																																	'成交量',
																																	_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	'平均利率',
																																	_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																													),
																													_react2.default.createElement(
																																	'th',
																																	{ className: 'diff-width' },
																																	'平均借款期限',
																																	_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																													),
																													_react2.default.createElement(
																																	'th',
																																	{ className: 'diff-width' },
																																	'累计待还金额',
																																	_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																													)
																									)
																					),
																					_react2.default.createElement(
																									'tbody',
																									null,
																									this.state.listData.map(function (item, index) {
																													{
																																	if (index % 2) {
																																					return _react2.default.createElement(
																																									'tr',
																																									null,
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													_react2.default.createElement(
																																																	_reactRouter.Link,
																																																	{ to: '/Portrait' },
																																																	item.plat_name
																																													)
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.amount,
																																													'亿'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.income_rate,
																																													'%'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.loan_period,
																																													'月'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.stay_still_of_total,
																																													'亿元'
																																									)
																																					);
																																	} else {
																																					return _react2.default.createElement(
																																									'tr',
																																									{ className: 'odd-line' },
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													_react2.default.createElement(
																																																	_reactRouter.Link,
																																																	{ to: '/Portrait' },
																																																	item.plat_name
																																													)
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.amount,
																																													'亿'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.income_rate,
																																													'%'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.loan_period,
																																													'月'
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.stay_still_of_total,
																																													'亿元'
																																									)
																																					);
																																	}
																													}
																									})
																					)
																	)
													)
									);
					}
	});

	module.exports = NetCredit;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCredit.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 827:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(756);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	    color: ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	    title: "贷款余额",
	    titleX: "left",
	    boxId: "chartMap",
	    legendIsShow: true,
	    yFlag: "%",
	    legendRight: "10",
	    legendTop: "-10",
	    symbolSize: 5,
	    yAxisName: "",
	    legend: ["上海问题平台比例", "全国问题平台比例"],
	    xAxis: [],
	    series: []
	};
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)], [Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]];

	        return baseParm;
	    },
	    componentDidMount: function componentDidMount() {
	        var getProblemScaleRequest = this.props.getProblemScaleRequest;

	        var jsonData = {};
	        getProblemScaleRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.problemScaleRequest, this.props.problemScaleResult);
	        if (!isEqual) {
	            var problemScaleRequest = nextProps.problemScaleRequest;
	            var problemScaleResult = nextProps.problemScaleResult;


	            if (problemScaleRequest == true) {
	                console.log("redux测试成功=================problemScaleResult");
	                if (problemScaleResult.code == 200) {
	                    // baseParm.xAxis=problemScaleResult.content.xAxis
	                    // baseParm.series=problemScaleResult.content.series
	                } else {
	                        //错误后提示
	                    }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-l-t-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '问题平台比例'
	                )
	            ),
	            _react2.default.createElement(_LineChart2.default, {
	                option: this.setParm(),
	                style: { height: '205px', width: '100%' } })
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "problemScale.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 828:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(756);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	    color: ["#00b7ee", "#f8b551"],
	    title: "行业人气",
	    titleX: "left", //
	    boxId: "chartMap",
	    symbolSize: 5,
	    legendIsShow: true,
	    yFlag: "万人", //
	    yAxisName: "",
	    legendRight: "10%",
	    legendTop: "-10",
	    legend: ["投资人", "借款人"],
	    series: []
	};
	var IndustrySentiment = _react2.default.createClass({
	    displayName: 'IndustrySentiment',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)], [Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]];

	        return baseParm;
	    },
	    componentDidMount: function componentDidMount() {
	        var getIndustrySRequest = this.props.getIndustrySRequest;

	        var jsonData = {};
	        getIndustrySRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.industrySentimentRequest, this.props.industrySentimentResult);
	        if (!isEqual) {
	            var industrySentimentRequest = nextProps.industrySentimentRequest;
	            var industrySentimentResult = nextProps.industrySentimentResult;

	            if (industrySentimentRequest == true) {
	                console.log("redux测试成功=================industrySentimentRequest");
	                if (industrySentimentResult.code == 200) {
	                    // baseParm.xAxis=industrySentimentResult.content.xAxis
	                    // baseParm.series=industrySentimentResult.content.series
	                } else {
	                        //错误后提示
	                    }
	            }
	        }
	    },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: ' mod bom-l-t-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '行业人气'
	                )
	            ),
	            _react2.default.createElement(_LineChart2.default, {
	                option: this.setParm(),
	                style: { height: '205px', width: '100%' } })
	        );
	    }
	});

	module.exports = IndustrySentiment;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustrySentiment.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 829:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(796);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	  color: ["#e14340", "#00b7ee"],
	  barWidth: 20,
	  legendRight: "20",
	  gridLeft: '5%',
	  gridRight: '5%',
	  gridBottom: '0%',
	  gridTop: '15%',
	  titleName: "网贷数据对比(上海VS全国)",
	  legend: ["全国(亿元)", "上海(亿元)"],
	  yAxis: ["成交量", "贷款余额"],
	  series: []
	};
	var NetCreditContrast = _react2.default.createClass({
	  displayName: 'NetCreditContrast',

	  setParm: function setParm() {
	    baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[200, 100], [400, 200]];
	    return baseParm;
	  },
	  componentDidMount: function componentDidMount() {
	    var getNetCreditConCRequest = this.props.getNetCreditConCRequest;

	    var jsonData = {};
	    getNetCreditConCRequest(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.netCreditContrastRequest, this.props.netCreditContrastResult);
	    if (!isEqual) {
	      var netCreditContrastRequest = nextProps.netCreditContrastRequest;
	      var netCreditContrastResult = nextProps.netCreditContrastResult;

	      if (netCreditContrastRequest == true) {
	        console.log("redux测试成功=================netCreditContrastRequest");
	        if (netCreditContrastResult.code == 200) {
	          // baseParm.xAxis=industrySentimentResult.content.xAxis
	          // baseParm.series=industrySentimentResult.content.series
	        } else {
	            //错误后提示
	          }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'mod bom-l-b radius4' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '网贷数据对比(上海VS全国)'
	        )
	      ),
	      _react2.default.createElement(_HorizontalBarChart2.default, {
	        option: this.setParm(),
	        style: { height: '180px', width: '100%' } })
	    );
	  }
	});

	module.exports = NetCreditContrast;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCreditContrast.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 830:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(817);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(721);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(740);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _baseMsg = __webpack_require__(831);

	var _baseMsg2 = _interopRequireDefault(_baseMsg);

	var _companyMsg = __webpack_require__(834);

	var _companyMsg2 = _interopRequireDefault(_companyMsg);

	var _coreData = __webpack_require__(835);

	var _coreData2 = _interopRequireDefault(_coreData);

	var _litigation = __webpack_require__(837);

	var _litigation2 = _interopRequireDefault(_litigation);

	var _publicOpinion = __webpack_require__(838);

	var _publicOpinion2 = _interopRequireDefault(_publicOpinion);

	var _rankPic = __webpack_require__(839);

	var _rankPic2 = _interopRequireDefault(_rankPic);

	var _scoreLeida = __webpack_require__(840);

	var _scoreLeida2 = _interopRequireDefault(_scoreLeida);

	var _P2PPortraitAction = __webpack_require__(1259);

	var P2PPortraitCreaters = _interopRequireWildcard(_P2PPortraitAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//p2p平台画像
	//动态图谱
	//诉讼信息
	//公司基本信息
	var P2PPortrait = _react2.default.createClass({
	    displayName: 'P2PPortrait',

	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-portrait', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-portrait-content' },
	                '',
	                _react2.default.createElement(
	                    'div',
	                    { className: 'clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-left' },
	                        _react2.default.createElement(_companyMsg2.default, this.props),
	                        _react2.default.createElement(_baseMsg2.default, this.props),
	                        _react2.default.createElement(_rankPic2.default, this.props)
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-right' },
	                        _react2.default.createElement(_scoreLeida2.default, this.props),
	                        _react2.default.createElement(_coreData2.default, this.props)
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'portrait-bottom  clearfix' },
	                    _react2.default.createElement(_litigation2.default, this.props),
	                    _react2.default.createElement(_publicOpinion2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PPortrait;

	//将 request  result 绑定到props的request result
	//评分雷达图
	//平台舆情
	//核心数据
	//基本信息
	function mapStateToProps(state) {
	    return {
	        baseMsgRequest: state.BaseMsg.request,
	        baseMsgResult: state.BaseMsg.result,

	        companyMsgRequest: state.CompanyMsg.request,
	        companyMsgResult: state.CompanyMsg.result,

	        coreDataRequest: state.CoreData.request,
	        coreDataResult: state.CoreData.result,

	        litigationRequest: state.Litigation.request,
	        litigationResult: state.Litigation.result,

	        publicOpinionRequest: state.PublicOpinion.request,
	        publicOpinionResult: state.PublicOpinion.result,

	        rankPicRequest: state.RankPic.request,
	        rankPicResult: state.RankPic.result,

	        scoreLeidaRequest: state.ScoreLeida.request,
	        scoreLeidaResult: state.ScoreLeida.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PPortraitCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PPortrait);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Portrait.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 831:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var BaseMsg = _react2.default.createClass({
		displayName: 'BaseMsg',

		getInitialState: function getInitialState() {
			return {
				listData: []
			};
		},
		componentDidMount: function componentDidMount() {
			var getbaseMsgRequest = this.props.getbaseMsgRequest;

			var jsonData = {};
			getbaseMsgRequest(jsonData);
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.baseMsgRequest, this.props.baseMsgResult);
			if (!isEqual) {
				var baseMsgRequest = nextProps.baseMsgRequest;
				var baseMsgResult = nextProps.baseMsgResult;

				if (baseMsgRequest == true) {
					console.log("redux测试成功=================baseMsgRequest");
					if (baseMsgResult.code == 200) {
						// baseParm.xAxis=areaRankingResult.content.xAxis
						// baseParm.series=areaRankingResult.content.series
					} else {
							//错误后提示
						}
				}
			}
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'left-m radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'基本信息'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'list-items' },
					_react2.default.createElement(
						'table',
						{ className: 'mt-table wtyh-table' },
						_react2.default.createElement(
							'tbody',
							null,
							_react2.default.createElement(
								'tr',
								{ className: 'odd-blackbg-line' },
								_react2.default.createElement(
									'td',
									null,
									'平台名称：'
								),
								_react2.default.createElement(
									'td',
									null,
									'陆金所'
								),
								_react2.default.createElement('td', null),
								_react2.default.createElement('td', null)
							),
							_react2.default.createElement(
								'tr',
								null,
								_react2.default.createElement(
									'td',
									null,
									'公司名称：'
								),
								_react2.default.createElement(
									'td',
									null,
									_react2.default.createElement(
										'span',
										{ className: 'word-limit-5', 'data-tip': '上海市浦东新区陆家嘴环路1333号13楼' },
										'上海市浦东新区陆家嘴环路1333号13楼'
									)
								),
								_react2.default.createElement('td', null),
								_react2.default.createElement('td', null)
							),
							_react2.default.createElement(
								'tr',
								{ className: 'odd-blackbg-line' },
								_react2.default.createElement(
									'td',
									null,
									'法人代表：'
								),
								_react2.default.createElement(
									'td',
									null,
									'郑海生'
								),
								_react2.default.createElement(
									'td',
									null,
									'注册资本：'
								),
								_react2.default.createElement(
									'td',
									null,
									'8222'
								)
							),
							_react2.default.createElement(
								'tr',
								null,
								_react2.default.createElement(
									'td',
									null,
									'平台名称：'
								),
								_react2.default.createElement(
									'td',
									null,
									_react2.default.createElement(
										'span',
										{ className: 'word-limit-5', 'data-tip': '上海陆家嘴国际金融资产交易市场股份有限公司' },
										'上海陆家嘴国际金融资产交易市场股份有限公司'
									),
									' '
								),
								_react2.default.createElement('td', null),
								_react2.default.createElement('td', null)
							),
							_react2.default.createElement(
								'tr',
								{ className: 'odd-blackbg-line' },
								_react2.default.createElement(
									'td',
									null,
									'开业日期：'
								),
								_react2.default.createElement(
									'td',
									null,
									'2011年9月29日'
								),
								_react2.default.createElement(
									'td',
									null,
									'核准日期：'
								),
								_react2.default.createElement(
									'td',
									null,
									'2011年9月29日'
								)
							),
							_react2.default.createElement(
								'tr',
								null,
								_react2.default.createElement(
									'td',
									null,
									'登记机关：'
								),
								_react2.default.createElement(
									'td',
									null,
									'上海市工商局'
								),
								_react2.default.createElement(
									'td',
									null,
									'组织机构代码：'
								),
								_react2.default.createElement(
									'td',
									null,
									'325232'
								)
							)
						)
					)
				)
			);
		}
	});

	module.exports = BaseMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 834:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var CompanyMsg = _react2.default.createClass({
		displayName: 'CompanyMsg',
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'left-t radius4 mod' },
				_react2.default.createElement(
					'ul',
					null,
					_react2.default.createElement(
						'li',
						null,
						_react2.default.createElement('img', { src: '/images/no-logo.png' })
					),
					_react2.default.createElement(
						'li',
						null,
						_react2.default.createElement(
							'span',
							{ className: 'score orange' },
							'88'
						),
						_react2.default.createElement(
							'span',
							{ className: 'score-title' },
							'评分'
						)
					),
					_react2.default.createElement(
						'li',
						null,
						_react2.default.createElement(
							'span',
							{ className: 'state' },
							'正常营业'
						)
					)
				)
			);
		}
	});

	module.exports = CompanyMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 835:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(836);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	var _LineChart = __webpack_require__(756);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var CoreData = _react2.default.createClass({
		displayName: 'CoreData',

		setParm: function setParm() {
			var option = {
				title: "平台交易量走势",
				titleX: "center",
				color: ["#e14340"],
				titleShow: true,
				barWidth: 15,
				yAxisName: "万元",
				yFlag: "", //y轴单位
				gridBottom: '0',
				gridTop: '15%',
				legend: ["成交量"],
				legendShow: false,
				xAxis: ['2016-08-01', '2016-08-02', '2016-08-03', '2016-08-04', '2016-08-05', '2016-08-06', '2016-08-07', '2016-08-08', '2016-08-09', '2016-08-10', '2016-08-11', '2016-08-12', '2016-08-13', '2016-08-14', '2016-08-15'],
				series: [[Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000)]]
			};
			return option;
		},
		setLineLParm: function setLineLParm() {
			var option = {
				color: ["#00b7ee", "#f8b551"],
				title: "平台利率走势",
				titleShow: true,
				titleX: "center",
				boxId: "chartMap",
				symbolSize: 5,
				legendIsShow: false,
				yFlag: "%",
				yAxisName: "",
				legendRight: "30",
				legend: ["利率"],
				xAxis: ['2016-08-01', '2016-08-02', '2016-08-03', '2016-08-04', '2016-08-05', '2016-08-06', '2016-08-07', '2016-08-08', '2016-08-09', '2016-08-10', '2016-08-11', '2016-08-12', '2016-08-13', '2016-08-14', '2016-08-15'],
				series: [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]]
			};
			return option;
		},

		setLineRParm: function setLineRParm() {
			var option = {
				color: ["#00b7ee", "#f8b551"],
				title: "贷款余额",
				titleShow: true,
				titleX: "center",
				boxId: "chartMap",
				symbolSize: 5,
				legendIsShow: false,
				yFlag: "",
				yAxisName: "金额(亿元)",
				legendRight: "30",
				legend: ["投资人", "借款人"],
				xAxis: ['2016-08-01', '2016-08-02', '2016-08-03', '2016-08-04', '2016-08-05', '2016-08-06', '2016-08-07', '2016-08-08', '2016-08-09', '2016-08-10', '2016-08-11', '2016-08-12', '2016-08-13', '2016-08-14', '2016-08-15'],
				series: [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]]
			};
			return option;
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'right-b radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'核心数据'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'core-top' },
						_react2.default.createElement(
							'div',
							{ className: 'top-list' },
							_react2.default.createElement(
								'table',
								{ className: 'mt-table wtyh-table' },
								_react2.default.createElement(
									'tbody',
									null,
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'累计成交量'
										),
										_react2.default.createElement(
											'td',
											null,
											'32.12亿元'
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'贷款余额'
										),
										_react2.default.createElement(
											'td',
											null,
											'14亿元'
										)
									),
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'平均利率'
										),
										_react2.default.createElement(
											'td',
											null,
											'6.24%'
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'近30日资金净流入'
										),
										_react2.default.createElement(
											'td',
											null,
											'2300万元'
										)
									),
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'待收投资人数'
										),
										_react2.default.createElement(
											'td',
											null,
											'203232'
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'待还借款人数'
										),
										_react2.default.createElement(
											'td',
											null,
											'32323'
										)
									),
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'最大单户借款额'
										),
										_react2.default.createElement(
											'td',
											null,
											'2300万元'
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'最大十户借款额'
										),
										_react2.default.createElement(
											'td',
											null,
											'2300万元'
										)
									)
								)
							)
						),
						_react2.default.createElement(
							'div',
							{ className: 'top-bar' },
							_react2.default.createElement(_BarChart2.default, {
								option: this.setParm(),
								style: { height: '270px', width: '100%' } })
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'core-bottom' },
						_react2.default.createElement(
							'div',
							{ className: 'bottom-line-left' },
							_react2.default.createElement(_LineChart2.default, {
								option: this.setLineLParm(),
								style: { height: '320px', width: '100%' } })
						),
						_react2.default.createElement(
							'div',
							{ className: 'bottom-line-right' },
							_react2.default.createElement(_LineChart2.default, {
								option: this.setLineRParm(),
								style: { height: '320px', width: '100%' } })
						)
					)
				)
			);
		}
	});

	module.exports = CoreData;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "coreData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 837:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var Litigation = _react2.default.createClass({
		displayName: 'Litigation',
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'bottom-l radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'诉讼信息'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						null,
						_react2.default.createElement(
							'li',
							null,
							_react2.default.createElement('span', { className: 'iconfont icon-susong skublue' })
						),
						_react2.default.createElement(
							'li',
							null,
							_react2.default.createElement(
								'span',
								{ className: 'ssong-title' },
								'诉讼信息'
							)
						),
						_react2.default.createElement(
							'li',
							null,
							_react2.default.createElement(
								'span',
								{ className: 'ssong-num' },
								_react2.default.createElement(
									_reactRouter.Link,
									{ to: { pathname: '/SearchResultDetail', query: { formpage: 'Portrait' } }, className: 'orange' },
									'5'
								)
							)
						)
					)
				)
			);
		}
	});

	module.exports = Litigation;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "litigation.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 838:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var PublicOpinion = _react2.default.createClass({
		displayName: 'PublicOpinion',
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'bottom-r radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'平台舆情'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'list-item' },
						_react2.default.createElement(
							'table',
							null,
							_react2.default.createElement(
								'tbody',
								null,
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										{ rowSpan: '3', className: 'v-aglign-t td2-l' },
										_react2.default.createElement(
											'span',
											{ className: 'serial-num' },
											'1'
										)
									),
									_react2.default.createElement(
										'td',
										{ className: 'td2-r' },
										_react2.default.createElement(
											'a',
											{ href: 'javascript:void(null)' },
											'投融范'
										)
									)
								),
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										null,
										_react2.default.createElement(
											'p',
											{ className: 'item-mark' },
											'上海P2P投融范发逾期公告 承若九个月类兑付'
										)
									)
								)
							)
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'list-item' },
						_react2.default.createElement(
							'table',
							null,
							_react2.default.createElement(
								'tbody',
								null,
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										{ rowSpan: '3', className: 'v-aglign-t td2-l' },
										_react2.default.createElement(
											'span',
											{ className: 'serial-num' },
											'2'
										)
									),
									_react2.default.createElement(
										'td',
										{ className: 'td2-r' },
										_react2.default.createElement(
											'a',
											{ href: 'javascript:void(null)' },
											'投融范'
										)
									)
								),
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										null,
										_react2.default.createElement(
											'p',
											{ className: 'item-mark' },
											'投融范一个推子布局的诈骗平台“华仔”推子兼职诈骗，人人得而诛之！'
										)
									)
								)
							)
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'list-item' },
						_react2.default.createElement(
							'table',
							null,
							_react2.default.createElement(
								'tbody',
								null,
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										{ rowSpan: '3', className: 'v-aglign-t td2-l' },
										_react2.default.createElement(
											'span',
											{ className: 'serial-num' },
											'3'
										)
									),
									_react2.default.createElement(
										'td',
										{ className: 'td2-r' },
										_react2.default.createElement(
											'a',
											{ href: 'javascript:void(null)' },
											'投融范'
										)
									)
								),
								_react2.default.createElement(
									'tr',
									null,
									_react2.default.createElement(
										'td',
										null,
										_react2.default.createElement(
											'p',
											{ className: 'item-mark' },
											'投融范项目逾期，回款无望'
										)
									)
								)
							)
						)
					)
				)
			);
		}
	});

	module.exports = PublicOpinion;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "publicOpinion.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 839:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var RankPic = _react2.default.createClass({
	    displayName: 'RankPic',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/guanliantu.js");
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-rel-graph mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '企业关联方图谱'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right search-enlarge' },
	                    _react2.default.createElement('i', { className: 'iconfont icon-fullscreen' })
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-legend' },
	                    _react2.default.createElement(
	                        'table',
	                        null,
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '目标公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/xuxianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '投资人'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange-two' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '子公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/shixianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '企业高管'
	                                    )
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'condition', style: { display: "none" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'lable' },
	                            '请选择以下筛选条件'
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btns' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-modal' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'company-title' },
	                        '成都中建明城投资有限公司'
	                    ),
	                    _react2.default.createElement(
	                        'table',
	                        null,
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '注册资本'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '500万'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '登记状态'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '在营开业企业'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方法人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '386'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方自然人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '289'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '自然人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '21'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '法人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '8'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '子股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '0'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'a',
	                        { href: '', className: 'see-detail' },
	                        '查看详情'
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box' },
	                    _react2.default.createElement('input', { type: 'hidden', id: 'GLOBAL', 'data-url': '', 'data-sidenav': '3', 'data-taoxi': 'S', 'data-isopen': '1' }),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'main', style: { "height": "100%" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'show-company-info', id: 'show-company-info', style: { "display": "none" } },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            ),
	                            _react2.default.createElement(
	                                'h1',
	                                { id: 'companyName-info' },
	                                'loading...'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'des', id: 'companyName-des-info' },
	                                '...'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'correlation-tips' },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '隐藏文字', id: 'cavHideText' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-3.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '放大', id: 'cavToMax' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-4.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '缩小', id: 'cavToMin' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-5.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { className: 'pic-tips', href: 'javascript:;' },
	                                '图例说明 ',
	                                _react2.default.createElement('i', { className: 'iconfont icon-xia' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 't-img' },
	                                    _react2.default.createElement(
	                                        'ul',
	                                        null,
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop1' },
	                                            '当前目标'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '被投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '股东'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '董监高'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他自然人'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop3' },
	                                            '投资关系'
	                                        )
	                                    ),
	                                    _react2.default.createElement('img', { className: '', src: '/assets/images/tips.gif', alt: '' })
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'time-line' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'date' },
	                                _react2.default.createElement('ul', { className: 'dateul' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'canvas selectNull', id: 'canvas-box' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'drag-box' },
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover-nodes', id: 'cav-hover-nodes' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover', id: 'cav-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-main-hover', id: 'cav-main-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes', id: 'cav-nodes' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes-text', id: 'cav-nodes-text' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links-hover', id: 'cav-links-hover' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links', id: 'cav-links' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebar' },
	                            _react2.default.createElement('a', { href: 'javascript:;', className: 'sidebtn' })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebox', style: { display: "none" } },
	                            _react2.default.createElement(
	                                'ul',
	                                { className: 'select-nav clearfix' },
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '1' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '1度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '2' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '2度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '3' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '3度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '4' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '4度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'all' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '全部'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'shareholder', 'langs-title': '股东投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '股东投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'direct', 'langs-title': '直接投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '直接投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'leader', 'langs-title': '董监高' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '董监高'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'search-company' },
	                                _react2.default.createElement('input', { type: 'text', className: 'name', id: 'searchCompanyLocal', placeholder: '搜索关联方列表' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'index-search-content' },
	                                    ' ...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'allCompany' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'gdCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'zjCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'djgCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'down-btn' },
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-blue down-excel' },
	                                    '下载Excel'
	                                ),
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-grey reset-old' },
	                                    '恢复默认'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'loadingBox' },
	                        _react2.default.createElement(
	                            'p',
	                            null,
	                            '数据加载中...'
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'click-detail-show', id: 'click-detail-show' },
	                        _react2.default.createElement(
	                            'h1',
	                            null,
	                            '基本资料 ',
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            )
	                        ),
	                        _react2.default.createElement('div', { className: 'detail-content' })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = RankPic;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "rankPic.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 840:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(832);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _RadarChart = __webpack_require__(841);

	var _RadarChart2 = _interopRequireDefault(_RadarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var ScoreLeida = _react2.default.createClass({
		displayName: 'ScoreLeida',

		setParm: function setParm() {
			var option = {
				"color": ["#00b8ee"],
				"legend": ["评分"],
				"legendShow": false,
				"series": [[50, 50, 60, 70, 40, 70]],
				"radarRadius": 110,
				"indicator": [{ name: '违约成本', max: 100 }, { name: '分散度', max: 100 }, { name: '流动性', max: 100 }, { name: '运营能力', max: 100 }, { name: '资本充足', max: 100 }, { name: '信息披露', max: 100 }]
			};
			return option;
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'right-t radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'评分雷达图'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						null,
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-l' },
							_react2.default.createElement(
								'p',
								{ className: 'orange socre-title' },
								'评分：'
							),
							_react2.default.createElement(
								'p',
								{ className: 'orange score' },
								'88'
							)
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-c' },
							_react2.default.createElement(
								'div',
								{ className: 'leida-c-pic' },
								_react2.default.createElement(_RadarChart2.default, {
									option: this.setParm(),
									style: { height: '380px', width: '100%' } })
							)
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-r' },
							_react2.default.createElement(
								'table',
								null,
								_react2.default.createElement(
									'tbody',
									null,
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'99.36'
											),
											_react2.default.createElement(
												'span',
												null,
												'违约成本'
											)
										),
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'99.36'
											),
											_react2.default.createElement(
												'span',
												null,
												'信息披露'
											)
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'10.23'
											),
											_react2.default.createElement(
												'span',
												null,
												'资本充足'
											)
										),
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'99.36'
											),
											_react2.default.createElement(
												'span',
												null,
												'运营能力'
											)
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'99.36'
											),
											_react2.default.createElement(
												'span',
												null,
												'流动性'
											)
										),
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'p',
												null,
												'99.36'
											),
											_react2.default.createElement(
												'span',
												null,
												'分散度'
											)
										)
									)
								)
							)
						)
					)
				)
			);
		}
	});

	module.exports = ScoreLeida;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "scoreLeida.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 958:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _CompanyGrade = __webpack_require__(959);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _DevTrend = __webpack_require__(960);

	var _DevTrend2 = _interopRequireDefault(_DevTrend);

	var _Volume = __webpack_require__(1260);

	var _Volume2 = _interopRequireDefault(_Volume);

	var _Map = __webpack_require__(1261);

	var _Map2 = _interopRequireDefault(_Map);

	var _AreaRanking = __webpack_require__(1262);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1263);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _ProblemScale = __webpack_require__(1264);

	var _ProblemScale2 = _interopRequireDefault(_ProblemScale);

	var _IndustrySentiment = __webpack_require__(1265);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _NetCreditContrast = __webpack_require__(1266);

	var _NetCreditContrast2 = _interopRequireDefault(_NetCreditContrast);

	var _BaseMsg = __webpack_require__(1267);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1268);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1269);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _Litigation = __webpack_require__(1270);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1271);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1272);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1273);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*p2p画像平台 end*/

	//动态图谱

	//诉讼信息

	//公司基本信息

	//网贷对比

	//问题平台比例

	//上海区域发展指数排名

	//成交量和综合利率


	/*行业监测模块*/

	//小额贷款
	var rootReducer = (0, _redux.combineReducers)({
	  /*行业监测模块*/
	  //P2P平台监测
	  DevTrend: _DevTrend2.default,
	  Volume: _Volume2.default,
	  Map: _Map2.default,
	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  ProblemScale: _ProblemScale2.default,
	  IndustrySentiment: _IndustrySentiment2.default,
	  NetCreditContrast: _NetCreditContrast2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default,
	  Litigation: _Litigation2.default,
	  PublicOpinion: _PublicOpinion2.default,
	  RankPic: _RankPic2.default,
	  ScoreLeida: _ScoreLeida2.default,

	  //小额贷款
	  CompanyGrade: _CompanyGrade2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	//评分雷达图

	//平台舆情

	//核心数据

	/*p2p平台首页 end*/

	/*p2p画像平台 begin*/
	//基本信息

	//行业人气

	//网贷平台数据展示

	//地图

	/*p2p平台首页 begin*/
	//P2P平台监测

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1259:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getbaseMsgRequest = getbaseMsgRequest;
	exports.getcompanyMsgRequest = getcompanyMsgRequest;
	exports.getcoreDataRequest = getcoreDataRequest;
	exports.getlitigationRequest = getlitigationRequest;
	exports.getpublicOpinionRequest = getpublicOpinionRequest;
	exports.getrankPicRequest = getrankPicRequest;
	exports.getscoreLeidaRequest = getscoreLeidaRequest;
	/*
	  平台画像
	*/

	/*基本信息*/
	var BASEMSG_REQUEST_SUCCESS = exports.BASEMSG_REQUEST_SUCCESS = 'BASEMSG_REQUEST_SUCCESS';
	var BASEMSG_REQUEST_FAIL = exports.BASEMSG_REQUEST_FAIL = 'BASEMSG_REQUEST_FAIL';

	function baseMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: BASEMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function baseMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BASEMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getbaseMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(baseMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(baseMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*基本信息*/

	/*公司基本信息*/
	var COMPANYMSG_REQUEST_SUCCESS = exports.COMPANYMSG_REQUEST_SUCCESS = 'COMPANYMSG_REQUEST_SUCCESS';
	var COMPANYMSG_REQUEST_FAIL = exports.COMPANYMSG_REQUEST_FAIL = 'COMPANYMSG_REQUEST_FAIL';

	function companyMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function companyMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcompanyMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*公司基本信息	*/

	/*核心数据*/
	var COREDATA_REQUEST_SUCCESS = exports.COREDATA_REQUEST_SUCCESS = 'COREDATA_REQUEST_SUCCESS';
	var COREDATA_REQUEST_FAIL = exports.COREDATA_REQUEST_FAIL = 'COREDATA_REQUEST_FAIL';

	function coreDataRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREDATA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreDataRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREDATA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcoreDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreDataRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreDataRequestFail(result));
	      }
	    });
	  };
	}
	/*核心数据*/

	/*诉讼信息*/
	var LITIGATION_REQUEST_SUCCESS = exports.LITIGATION_REQUEST_SUCCESS = 'LITIGATION_REQUEST_SUCCESS';
	var LITIGATION_REQUEST_FAIL = exports.LITIGATION_REQUEST_FAIL = 'LITIGATION_REQUEST_FAIL';

	function litigationRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: BASEMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function litigationRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BASEMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getlitigationRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(litigationRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(litigationRequestFail(result));
	      }
	    });
	  };
	}
	/*诉讼信息*/

	/*平台舆情*/
	var PUBLICOPINION_REQUEST_SUCCESS = exports.PUBLICOPINION_REQUEST_SUCCESS = 'PUBLICOPINION_REQUEST_SUCCESS';
	var PUBLICOPINION_REQUEST_FAIL = exports.PUBLICOPINION_REQUEST_FAIL = 'PUBLICOPINION_REQUEST_FAIL';

	function publicOpinionRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function publicOpinionRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getpublicOpinionRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(publicOpinionRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(publicOpinionRequestFail(result));
	      }
	    });
	  };
	}
	/*平台舆情	*/

	/*动态图谱*/
	var RANKPIC_REQUEST_SUCCESS = exports.RANKPIC_REQUEST_SUCCESS = 'RANKPIC_REQUEST_SUCCESS';
	var RANKPIC_REQUEST_FAIL = exports.RANKPIC_REQUEST_FAIL = 'RANKPIC_REQUEST_FAIL';

	function rankPicRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RANKPIC_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function rankPicRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: RANKPIC_REQUEST_FAIL,
	    result: result
	  };
	}

	function getrankPicRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(rankPicRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(rankPicRequestFail(result));
	      }
	    });
	  };
	}
	/*动态图谱*/

	/*评分雷达图*/
	var SCORELEIDA_REQUEST_SUCCESS = exports.SCORELEIDA_REQUEST_SUCCESS = 'SCORELEIDA_REQUEST_SUCCESS';
	var SCORELEIDA_REQUEST_FAIL = exports.SCORELEIDA_REQUEST_FAIL = 'SCORELEIDA_REQUEST_FAIL';

	function scoreLeidaRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: SCORELEIDA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function scoreLeidaRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: SCORELEIDA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getscoreLeidaRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(scoreLeidaRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(scoreLeidaRequestFail(result));
	      }
	    });
	  };
	}
	/*评分雷达图*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PPortraitAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1260:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = Volume;

	var _P2PIndexAction = __webpack_require__(819);

	function Volume() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.VOLUME_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.VOLUME_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Volume.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1261:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = Map;

	var _P2PIndexAction = __webpack_require__(819);

	function Map() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.MAP_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.MAP_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Map.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1262:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = AreaRanking;

	var _P2PIndexAction = __webpack_require__(819);

	function AreaRanking() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.AREARANK_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.AREARANK_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "AreaRanking.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1263:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = NetCredit;

	var _P2PIndexAction = __webpack_require__(819);

	function NetCredit() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.NETCREDIT_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.NETCREDIT_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "NetCredit.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1264:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = ProblemScale;

	var _P2PIndexAction = __webpack_require__(819);

	function ProblemScale() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.PROBLEMSCALE_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.PROBLEMSCALE_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ProblemScale.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1265:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = IndustrySentiment;

	var _P2PIndexAction = __webpack_require__(819);

	function IndustrySentiment() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.INDUSTRYS_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.INDUSTRYS_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustrySentiment.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1266:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = NetCreditContrast;

	var _P2PIndexAction = __webpack_require__(819);

	function NetCreditContrast() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.NETCREDITCON_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.NETCREDITCON_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "NetCreditContrast.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1267:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = BaseMsg;

	var _P2PPortraitAction = __webpack_require__(1259);

	function BaseMsg() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.BASEMSG_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.BASEMSG_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BaseMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1268:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CompanyMsg;

	var _P2PPortraitAction = __webpack_require__(1259);

	function CompanyMsg() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.COMPANYMSG_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.COMPANYMSG_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1269:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CoreData;

	var _P2PPortraitAction = __webpack_require__(1259);

	function CoreData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.COREDATA_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.COREDATA_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CoreData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1270:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = Litigation;

	var _P2PPortraitAction = __webpack_require__(1259);

	function Litigation() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.LITIGATION_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.LITIGATION_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Litigation.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1271:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = PublicOpinion;

	var _P2PPortraitAction = __webpack_require__(1259);

	function PublicOpinion() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.PUBLICOPINION_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.PUBLICOPINION_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PublicOpinion.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1272:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = RankPic;

	var _P2PPortraitAction = __webpack_require__(1259);

	function RankPic() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.RANKPIC_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.RANKPIC_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RankPic.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1273:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = ScoreLeida;

	var _P2PPortraitAction = __webpack_require__(1259);

	function ScoreLeida() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.SCORELEIDA_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.SCORELEIDA_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScoreLeida.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})