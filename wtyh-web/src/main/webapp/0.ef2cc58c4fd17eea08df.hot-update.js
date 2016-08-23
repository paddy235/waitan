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

	var Immutable = __webpack_require__(718);
	//实时监测的线下理财
	var BottomLeft = _react2.default.createClass({
	  displayName: 'BottomLeft',

	  getInitialState: function getInitialState() {
	    return {
	      option: null,
	      companyInfo: []
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    this.getRealTimeRisk();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    debugger;
	    var isCheckValEqual = Immutable.is(nextProps.parm, this.props.parm);
	    if (!isCheckValEqual) {
	      var parm = nextProps.parm;

	      var jsonData = parm;
	      this.getRealTimeRisk(jsonData);
	    }

	    var isEqual = Immutable.is(nextProps.realTimeRiskShResult, this.props.realTimeRiskShResult);
	    if (!isEqual) {
	      var realTimeRiskShResult = nextProps.realTimeRiskShResult;
	      var realTimeRiskRequest = nextProps.realTimeRiskRequest;

	      if (realTimeRiskShResult == true) {
	        if (realTimeRiskRequest.success == true) {
	          this.dataFomat(realTimeRiskRequest);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var companyInfo = [];
	    var seriesData = [];

	    var content = data.content;
	    var len = content.length;
	    for (var i = 0; i < len; i++) {
	      companyInfo.push({
	        name: content[i].companyName,
	        regCapital: content[i].regCapital,
	        corporate: content[i].legalRpt,
	        companyType: content[i].companyType,
	        foundDate: content[i].regDateStr
	      });
	      seriesData.push([content[i].staticRiskIndex, content[i].dynamicRiskIndex]);
	    }
	    var option = {
	      color: ["#a40000"],
	      title: "",
	      companyInfo: companyInfo,
	      yAxisName: "动态风险指数",
	      xAxisName: "静态风险指数",
	      series: [{
	        name: '风险指数',
	        type: 'scatter',
	        data: seriesData
	      }]
	    };
	    console.log(seriesData, 333333333333);
	    this.setState({ option: option, companyInfo: companyInfo });
	  },

	  getRealTimeRisk: function getRealTimeRisk(jsonData) {
	    var getRealTimeRisk = this.props.getRealTimeRisk;

	    getRealTimeRisk(jsonData);
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
	  render: function render() {
	    console.log(this.props);
	    var bbdScatterBubble = "暂无数据";
	    if (this.state.option) {
	      bbdScatterBubble = _react2.default.createElement(_ScatterBubbleChart2.default, { option: this.state.option });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-bottom-left', id: 'realtime-bottom-left' },
	      bbdScatterBubble
	    );
	  }
	});

	//将state植入 到 props
	exports.default = BottomLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "bottomLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})