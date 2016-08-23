webpackHotUpdate(0,{

/***/ 979:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(974);

	var _ScatterBubbleChart = __webpack_require__(737);

	var _ScatterBubbleChart2 = _interopRequireDefault(_ScatterBubbleChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//实时监测的线下理财
	var BottomLeft = _react2.default.createClass({
	    displayName: 'BottomLeft',
	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    map: function map() {
	        var myChart = echarts.init(document.getElementById("realtime-bottom-left"));
	        var option = {
	            title: {
	                text: '线下理财风险指数',
	                textStyle: {
	                    color: "#fff"
	                }
	            },
	            textStyle: {
	                color: "#fff"
	            },
	            grid: {
	                left: '3%',
	                right: '10%',
	                bottom: '3%',
	                containLabel: true
	            },
	            tooltip: {
	                trigger: 'axis',
	                showDelay: 0,
	                formatter: function formatter(params) {
	                    if (params.value.length > 1) {
	                        return params.seriesName + ' :<br/>' + params.value[0] + 'cm ' + params.value[1] + 'kg ';
	                    } else {
	                        return params.seriesName + ' :<br/>' + params.name + ' : ' + params.value + 'kg ';
	                    }
	                },
	                axisPointer: {
	                    show: true,
	                    type: 'cross',
	                    lineStyle: {
	                        type: 'dashed',
	                        width: 1
	                    }
	                }
	            },
	            xAxis: [{
	                name: "动态风险指数",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value} cm'
	                },
	                splitLine: {
	                    show: false
	                }
	            }],
	            yAxis: [{
	                name: "静态风险指数",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value} kg'
	                },
	                splitLine: {
	                    show: false
	                }
	            }],
	            series: [{
	                name: '女性',
	                type: 'scatter',
	                data: [[161.2, 51.6], [167.5, 59.0], [159.5, 49.2], [157.0, 63.0], [155.8, 53.6], [170.0, 59.0], [159.1, 47.6], [166.0, 69.8], [176.2, 66.8], [160.2, 75.2], [172.5, 55.2], [170.9, 54.2], [172.9, 62.5], [153.4, 42.0], [160.0, 50.0], [147.2, 49.8], [168.2, 49.2], [175.0, 73.2], [157.0, 47.8], [167.6, 68.8], [159.5, 50.6], [175.0, 82.5], [166.8, 57.2], [176.5, 87.8], [170.2, 72.8], [174.0, 54.5], [173.0, 59.8], [179.9, 67.3], [170.5, 67.8], [160.0, 47.0], [154.4, 46.2], [162.0, 55.0], [176.5, 83.0], [160.0, 54.4], [152.0, 45.8], [162.1, 53.6], [170.0, 73.2], [160.2, 52.1], [161.3, 67.9], [166.4, 56.6], [168.9, 62.3], [163.8, 58.5], [167.6, 54.5], [160.0, 50.2], [161.3, 60.3], [167.6, 58.3], [165.1, 56.2], [160.0, 50.2], [170.0, 72.9], [157.5, 59.8], [167.6, 61.0], [160.7, 69.1], [163.2, 55.9], [152.4, 46.5], [157.5, 54.3], [168.3, 54.8], [180.3, 60.7], [165.5, 60.0], [165.0, 62.0], [164.5, 60.3], [156.0, 52.7], [160.0, 74.3], [163.0, 62.0], [165.7, 73.1], [161.0, 80.0], [162.0, 54.7], [166.0, 53.2], [174.0, 75.7], [172.7, 61.1], [167.6, 55.7], [151.1, 48.7], [164.5, 52.3], [163.5, 50.0], [152.0, 59.3], [169.0, 62.5], [164.0, 55.7], [161.2, 54.8], [155.0, 45.9], [170.0, 70.6], [176.2, 67.2], [170.0, 69.4], [162.5, 58.2], [170.3, 64.8], [164.1, 71.6], [169.5, 52.8], [163.2, 59.8], [154.5, 49.0], [159.8, 50.0], [173.2, 69.2], [170.0, 55.9], [161.4, 63.4], [169.0, 58.2], [166.2, 58.6], [159.4, 45.7], [162.5, 52.2], [159.0, 48.6], [162.8, 57.8], [159.0, 55.6], [179.8, 66.8], [162.9, 59.4], [161.0, 53.6], [151.1, 73.2], [168.2, 53.4], [168.9, 69.0], [173.2, 58.4], [171.8, 56.2], [178.0, 70.6], [164.3, 59.8], [163.0, 72.0], [168.5, 65.2], [166.8, 56.6], [172.7, 105.2], [163.5, 51.8], [169.4, 63.4], [167.8, 59.0], [159.5, 47.6], [167.6, 63.0], [161.2, 55.2], [160.0, 45.0], [163.2, 54.0], [162.2, 50.2], [161.3, 60.2], [149.5, 44.8], [157.5, 58.8], [163.2, 56.4], [172.7, 62.0], [155.0, 49.2], [156.5, 67.2], [164.0, 53.8], [160.9, 54.4], [162.8, 58.0], [167.0, 59.8], [160.0, 54.8], [160.0, 43.2], [168.9, 60.5], [158.2, 46.4], [156.0, 64.4], [160.0, 48.8], [167.1, 62.2], [158.0, 55.5], [167.6, 57.8], [156.0, 54.6], [162.1, 59.2], [173.4, 52.7], [159.8, 53.2], [170.5, 64.5], [159.2, 51.8], [157.5, 56.0], [161.3, 63.6], [162.6, 63.2], [160.0, 59.5], [168.9, 56.8], [165.1, 64.1], [162.6, 50.0], [165.1, 72.3], [166.4, 55.0], [160.0, 55.9], [152.4, 60.4], [170.2, 69.1], [162.6, 84.5], [170.2, 55.9], [158.8, 55.5], [172.7, 69.5], [167.6, 76.4], [162.6, 61.4], [167.6, 65.9], [156.2, 58.6], [175.2, 66.8], [172.1, 56.6], [162.6, 58.6], [160.0, 55.9], [165.1, 59.1], [182.9, 81.8], [166.4, 70.7], [165.1, 56.8], [177.8, 60.0], [165.1, 58.2], [175.3, 72.7], [154.9, 54.1], [158.8, 49.1], [172.7, 75.9], [168.9, 55.0], [161.3, 57.3], [167.6, 55.0], [165.1, 65.5], [175.3, 65.5], [157.5, 48.6], [163.8, 58.6], [167.6, 63.6], [165.1, 55.2], [165.1, 62.7], [168.9, 56.6], [162.6, 53.9], [164.5, 63.2], [176.5, 73.6], [168.9, 62.0], [175.3, 63.6], [159.4, 53.2], [160.0, 53.4], [170.2, 55.0], [162.6, 70.5], [167.6, 54.5], [162.6, 54.5], [160.7, 55.9], [160.0, 59.0], [157.5, 63.6], [162.6, 54.5], [152.4, 47.3], [170.2, 67.7], [165.1, 80.9], [172.7, 70.5], [165.1, 60.9], [170.2, 63.6], [170.2, 54.5], [170.2, 59.1], [161.3, 70.5], [167.6, 52.7], [167.6, 62.7], [165.1, 86.3], [162.6, 66.4], [152.4, 67.3], [168.9, 63.0], [170.2, 73.6], [175.2, 62.3], [175.2, 57.7], [160.0, 55.4], [165.1, 104.1], [174.0, 55.5], [170.2, 77.3], [160.0, 80.5], [167.6, 64.5], [167.6, 72.3], [167.6, 61.4], [154.9, 58.2], [162.6, 81.8], [175.3, 63.6], [171.4, 53.4], [157.5, 54.5], [165.1, 53.6], [160.0, 60.0], [174.0, 73.6], [162.6, 61.4], [174.0, 55.5], [162.6, 63.6], [161.3, 60.9], [156.2, 60.0], [149.9, 46.8], [169.5, 57.3], [160.0, 64.1], [175.3, 63.6], [169.5, 67.3], [160.0, 75.5], [172.7, 68.2], [162.6, 61.4], [157.5, 76.8], [176.5, 71.8], [164.4, 55.5], [160.7, 48.6], [174.0, 66.4], [163.8, 67.3]]
	            }]
	        };
	        myChart.setOption(option);
	    },
	    componentDidMount: function componentDidMount() {
	        // this.map()
	    },

	    setParm: function setParm() {
	        var option = {
	            color: ["#a40000"],
	            title: "",
	            companyInfo: [{
	                name: "海东泰金融投资有限公司", //公司名称
	                regCapital: '50万元人名币', //注册资本
	                corporate: '周全', //法人代表
	                companyType: '国有出资', //公司类型
	                foundDate: '2014年3月12日' //成立日期
	            }, {
	                name: "海东泰金融投资有限公司1", //公司名称
	                regCapital: '50万元人名币', //注册资本
	                corporate: '周全', //法人代表
	                companyType: '国有出资', //公司类型
	                foundDate: '2014年3月12日' //成立日期
	            }, {
	                name: "海东泰金融投资有限公司2", //公司名称
	                regCapital: '50万元人名币', //注册资本
	                corporate: '周全', //法人代表
	                companyType: '国有出资', //公司类型
	                foundDate: '2014年3月12日' //成立日期
	            }, {
	                name: "海东泰金融投资有限公司3", //公司名称
	                regCapital: '50万元人名币', //注册资本
	                corporate: '周全', //法人代表
	                companyType: '国有出资', //公司类型
	                foundDate: '2014年3月12日' //成立日期
	            }, {
	                name: "海东泰金融投资有限公司4", //公司名称
	                regCapital: '50万元人名币', //注册资本
	                corporate: '周全', //法人代表
	                companyType: '国有出资', //公司类型
	                foundDate: '2014年3月12日' //成立日期
	            }],
	            yAxisName: "动态风险指数",
	            xAxisName: "静态风险指数",
	            series: [{
	                name: '风险指数',
	                type: 'scatter',
	                data: [[161.2, 51.6], [167.5, 59.0], [159.5, 49.2], [157.0, 63.0], [155.8, 53.6], [170.0, 59.0], [159.1, 47.6], [166.0, 69.8], [176.2, 66.8], [160.2, 75.2], [172.5, 55.2], [170.9, 54.2], [172.9, 62.5], [153.4, 42.0], [160.0, 50.0]]
	            }]
	        };
	        return option;
	    },
	    componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
	        console.log(this.state.chartOption);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-bottom-left', id: 'realtime-bottom-left' },
	            _react2.default.createElement(_ScatterBubbleChart2.default, { option: this.setParm() })
	        );
	    }
	});

	//将state植入 到 props
	exports.default = BottomLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "bottomLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})