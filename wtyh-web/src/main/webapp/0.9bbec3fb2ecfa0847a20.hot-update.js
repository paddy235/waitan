webpackHotUpdate(0,{

/***/ 970:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(955);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718); /**
	                                       * 招聘人员分布
	                                       */

	var data;

	var series = [];
	var legend = [];
	var PersonIndexChart = _react2.default.createClass({
	    displayName: 'PersonIndexChart',
	    getInitialState: function getInitialState() {
	        return {
	            chart: null
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var _this = this;
	        if (nextProps.CompanyInfoD2Request) {
	            data = nextProps.CompanyInfoD2Result.content.rdata;
	            series = data;
	            series.map(function (item, index) {
	                legend.push(item.name);
	            });
	            this.setState({
	                chart: _react2.default.createElement(_BasePie2.default, { option: this.setParm(), style: { height: '100%', width: '100%' } })
	            });
	        }
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyInfoD2 = this.props.getCompanyInfoD2; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	        var data = this.props.location.query.companyName;
	        var jsonData = {
	            company: data
	        };
	        getCompanyInfoD2(jsonData);
	    },

	    setParm: function setParm() {
	        var option = {
	            "color": ["#F98D2B", "#FFDB03", "#04B4EF", "#0479FC", "#10A8AB"],
	            "title": "招聘人员分布",
	            "titleLeft": 250,
	            "titleTop": 20,
	            "xtitle": "",
	            "titleWeight": "bold",
	            "legend": legend,
	            "legendShow": true,
	            "legendOrient": "vertical",
	            "legendLeft": "5%",
	            "legendTop": 100,
	            "legendItemGap": 30,
	            "seriesName": "企业数",
	            "radius": ["40%", "85%"],
	            "roseType": "area",
	            "lable": {
	                normal: {
	                    show: true,
	                    position: 'inner',
	                    formatter: '{d}%'
	                },
	                emphasis: { show: false }
	            },
	            "center": ['55%', '55%'],
	            "series": series
	        };
	        return option;
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { id: 'person-index' },
	            this.state.chart
	        );
	    }
	});
	exports.default = PersonIndexChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PersonIndexPie.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})