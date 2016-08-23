webpackHotUpdate(0,{

/***/ 736:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _ScatterBubbleChart = __webpack_require__(737);

	var _ScatterBubbleChart2 = _interopRequireDefault(_ScatterBubbleChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);


	//线下理财风险分布
	var LineFinanceRiskDistr = _react2.default.createClass({
	  displayName: 'LineFinanceRiskDistr',

	  getInitialState: function getInitialState() {
	    return {
	      option: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    this.getLinFinRiskDistr();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isCheckValEqual = Immutable.is(nextProps.parm, this.props.parm);
	    if (!isCheckValEqual) {
	      var parm = nextProps.parm;

	      console.log(parm, 9999999999999);
	      var jsonData = parm;
	      this.getLinFinRiskDistr(jsonData);
	    }

	    var isEqual = Immutable.is(nextProps.lineFinaceRiskDistriRequest, this.props.lineFinaceRiskDistriResult);
	    if (!isEqual) {
	      var lineFinaceRiskDistriRequest = nextProps.lineFinaceRiskDistriRequest;
	      var lineFinaceRiskDistriResult = nextProps.lineFinaceRiskDistriResult;

	      if (lineFinaceRiskDistriRequest == true) {
	        if (lineFinaceRiskDistriResult.success == true) {
	          this.dataFomat(lineFinaceRiskDistriResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },

	  getLinFinRiskDistr: function getLinFinRiskDistr(jsonData) {
	    var getLinFinRiskDistr = this.props.getLinFinRiskDistr;

	    getLinFinRiskDistr(jsonData);
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, 4444444444);
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
	      seriesData.push([content[i].dynamicRiskIndex, content[i].staticRiskIndex]);
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
	    this.setState({ option: option });
	  },
	  render: function render() {
	    var bbdScatterBubble = "";
	    if (this.state.option) {
	      bbdScatterBubble = _react2.default.createElement(_ScatterBubbleChart2.default, { option: this.state.option });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'line-finace-risk-distrib' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '线下理财分布sss'
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'chart-box' },
	        bbdScatterBubble
	      )
	    );
	  }
	});
	module.exports = LineFinanceRiskDistr;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceRiskDistr.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})