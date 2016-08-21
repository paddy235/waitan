webpackHotUpdate(0,{

/***/ 963:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
					value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _BarChart = __webpack_require__(842);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var xData = []; /**
	                 * 薪酬分布图
	                 */

	var series = [];
	var PersonIndexChart = _react2.default.createClass({
					displayName: 'PersonIndexChart',
					getInitialState: function getInitialState() {
									return {
													chart: null
									};
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var _this = this;
									if (nextProps.CompanyInfoD3Request) {
													var data = nextProps.CompanyInfoD3Result.content.rdata;
													data.map(function (item, index) {
																	xData.push(x_value);
																	series.push(y_value);
													});

													this.setState({
																	chart: _react2.default.createElement(_BarChart2.default, { option: this.setParm(), style: { height: '100%', width: '100%' } })
													});
													console.log(data, "第3个图");
									}
					},
					componentDidMount: function componentDidMount() {
									var getCompanyInfoD3 = this.props.getCompanyInfoD3; // 取到props里面的getRealTimeTable方法。也可以说是请求action

									var jsonData = {
													company: "四川环福置地有限公司"
									}; //ajax传递给后台的data键值对
									getCompanyInfoD3(jsonData);
					},

					setParm: function setParm() {
									var option = {
													title: "薪酬分布",
													titleX: "center",
													titleShow: true,
													color: ["#E24340", "#00A0EA"],
													barWidth: 40,
													yAxisName: "",
													yFlag: "", //y轴单位
													splitLineShow: true,
													legendShow: false,
													gridTop: "10%",
													legend: ["企业资产总额"],
													xAxis: xData /*---------------ajax-----------------*/
													, XTextColor: '#fff',
													YTextColor: '#fff',
													series: [series /*---------------ajax-----------------*/
													]
									};
									return option;
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ id: 'pay-distribute' },
													this.state.chart
									);
					}
	});
	exports.default = PersonIndexChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PayIndexBar.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})