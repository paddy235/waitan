webpackHotUpdate(0,{

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

	//行业人气
	//上海区域发展指数排名
	//成交量和综合利率
	var Immutable = __webpack_require__(776);
	//p2p行业监测
	//网贷对比
	//问题平台比例
	//地图
	//新增平台发展趋势
	var P2PIndex = _react2.default.createClass({
	    displayName: 'P2PIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getp2pindexRequest = this.props.getp2pindexRequest;

	        var jsonData = {};
	        getp2pindexRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.indexChartRequest, this.props.indexChartResult);
	        if (!isEqual) {
	            var indexChartRequest = nextProps.indexChartRequest;
	            var indexChartResult = nextProps.indexChartResult;

	            if (indexChartRequest == true) {
	                if (indexChartResult.success) {
	                    this.setState({ listData: indexChartResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        var parm = this.state.listData;
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
	                        _react2.default.createElement(_devTrend2.default, { deveTrendData: this.state.listData }),
	                        _react2.default.createElement(_volume2.default, { volumeData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_map2.default, { mapData: this.state.listData }),
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
	                            _react2.default.createElement(_problemScale2.default, { problemScaleData: this.state.listData }),
	                            _react2.default.createElement(_IndustrySentiment2.default, { industrySentimentData: this.state.listData })
	                        ),
	                        _react2.default.createElement(_netCreditContrast2.default, { netCreditContrastData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_netCredit2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        indexChartRequest: state.IndexChartAll.request,
	        indexChartResult: state.IndexChartAll.result,

	        areaRankingRequest: state.AreaRanking.request,
	        areaRankingResult: state.AreaRanking.result,

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
	var volume = _react2.default.createClass({
	    displayName: 'volume',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.volumeData, this.props.volumeData);
	        if (!isEqual) {
	            var volumeData = nextProps.volumeData;

	            var optionParm = {
	                "color": ["#00b8ee", "#f7b650"],
	                "legend": ["成交量", "综合利率"],
	                "barName": ["成交量"],
	                "lineName": ["综合利率"],
	                "legendShow": true,
	                "legendRight": "30",
	                "yFlag": "亿元",
	                "y2Flag": "%",
	                "yAxisName": ["成交量(亿元)", "综合利率"],
	                "barWidth": 20,
	                "symbolSize": 5,
	                "xAxis": volumeData.bargain.xAxis,
	                "series": {
	                    "bar": [volumeData.bargain.series.bar],
	                    "line": [volumeData.bargain.series.line]
	                }
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartOption, style: { height: '300px', width: '100%' } });
	        }
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
	            chartBox
	        );
	    }
	});

	module.exports = volume;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "volume.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 824:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _MapChart = __webpack_require__(778);

	var _MapChart2 = _interopRequireDefault(_MapChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var DevTrend = _react2.default.createClass({
	  displayName: 'DevTrend',

	  getInitialState: function getInitialState() {
	    return {
	      chartOption: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.mapData, this.props.mapData);
	    if (!isEqual) {
	      var mapData = nextProps.mapData;

	      var optionParm = {
	        "visualMapRight": "50", //值茷位置
	        "visualMapBottom": "30",
	        'visualMapText': ["公司数量"],
	        "series": mapData.hotMap.data
	      };
	      this.setState({ chartOption: optionParm });
	    }
	  },
	  render: function render() {
	    var chartBox = "";
	    if (this.state.chartOption) {
	      chartBox = _react2.default.createElement(_MapChart2.default, { option: this.state.chartOption, style: { height: '649px', width: '100%' } });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'mod top-c radius4' },
	      chartBox
	    );
	  }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "map.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	var DevTrend = _react2.default.createClass({
	  displayName: 'DevTrend',

	  getInitialState: function getInitialState() {
	    return {
	      chartOption: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.problemScaleData, this.props.problemScaleData);
	    if (!isEqual) {
	      var problemScaleData = nextProps.problemScaleData;

	      var optionParm = {
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
	        xAxis: problemScaleData.problem.xAxis,
	        series: problemScaleData.problem.series
	      };
	      this.setState({ chartOption: optionParm });
	    }
	  },
	  render: function render() {
	    var chartBox = "";
	    if (this.state.chartOption) {
	      chartBox = _react2.default.createElement(_LineChart2.default, { option: this.state.chartOption, style: { height: '205px', width: '100%' } });
	    }
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
	      chartBox
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

	var IndustrySentiment = _react2.default.createClass({
	  displayName: 'IndustrySentiment',

	  getInitialState: function getInitialState() {
	    return {
	      chartOption: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.industrySentimentData, this.props.industrySentimentData);
	    if (!isEqual) {
	      var industrySentimentData = nextProps.industrySentimentData;

	      var optionParm = {
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
	        xAxis: industrySentimentData.popularity.xAxis,
	        series: industrySentimentData.popularity.series
	      };
	      this.setState({ chartOption: optionParm });
	    }
	  },
	  render: function render() {
	    var chartBox = "";
	    if (this.state.chartOption) {
	      chartBox = _react2.default.createElement(_LineChart2.default, { option: this.state.chartOption, style: { height: '205px', width: '100%' } });
	    }
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
	      chartBox
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

	var NetCreditContrast = _react2.default.createClass({
	  displayName: 'NetCreditContrast',

	  getInitialState: function getInitialState() {
	    return {
	      chartOption: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.netCreditContrastData, this.props.netCreditContrastData);
	    if (!isEqual) {
	      var netCreditContrastData = nextProps.netCreditContrastData;

	      var optionParm = {
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
	        xAxis: netCreditContrastData.compare.xAxis,
	        series: netCreditContrastData.compare.series
	      };
	      this.setState({ chartOption: optionParm });
	    }
	  },
	  render: function render() {
	    var chartBox = "";
	    if (this.state.chartOption) {
	      chartBox = _react2.default.createElement(_HorizontalBarChart2.default, { option: this.state.chartOption, style: { height: '180px', width: '100%' } });
	    }
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
	      chartBox
	    );
	  }
	});

	module.exports = NetCreditContrast;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCreditContrast.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})