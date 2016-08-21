webpackHotUpdate(0,{

/***/ 961:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/**
	 * 招聘人员指数图
	 */

	var Immutable = __webpack_require__(718);

	var xDate = [];
	var series = [];
	var PersonIndexChart = _react2.default.createClass({
		displayName: 'PersonIndexChart',
		drawImg: function drawImg() {
			var myChart = echarts.init(document.getElementById('show-charts'));
			var option = {

				grid: {
					left: '7%',
					right: '6%',
					bottom: '6%',
					containLabel: true
				},
				xAxis: {
					type: 'category',
					axisLine: {
						show: true,
						lineStyle: {
							color: '#232932'
						}
					},
					axisLabel: {
						show: true,
						textStyle: {
							color: '#fff',
							fontSize: 14
						}
					},
					data: xDate /*--------------ajax-------------*/
				},
				yAxis: {
					name: '指数（%）',
					type: 'value',
					nameTextStyle: {
						color: '#fff',
						fontSize: 14
					},
					axisLine: {
						show: true,
						lineStyle: {
							color: '#232932'
						}
					},
					axisLabel: {
						textStyle: {
							color: '#fff',
							fontSize: 14
						}
					},
					splitLine: {
						lineStyle: {
							color: '#232932'
						}
					}
				},
				series: [{
					name: '邮件营销',
					type: 'line',
					stack: '总量',
					data: series, /*---------ajax----------*/
					symbol: 'circle',
					symbolSize: 15,
					lineStyle: {
						normal: {
							color: '#73d528',
							width: 3
						}
					},
					itemStyle: {
						normal: {
							color: '#73d528',
							shadowColor: 'red',
							shadowBlur: {
								shadowColor: 'rgba(115, 213, 40, 0.8)',
								shadowBlur: 5
							}
						}
					}
				}]
			};
			myChart.setOption(option);
		},

		// componentDidMount() {
		//      this.drawImg();
		// },
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var _this = this;
			if (nextProps.CompanyInfoD1Request) {
				var data = nextProps.CompanyInfoD1Result;
				console.log(data, "第一个图");
			}
		},
		componentDidMount: function componentDidMount() {
			var getCompanyInfoD1 = this.props.getCompanyInfoD1; // 取到props里面的getRealTimeTable方法。也可以说是请求action

			var jsonData = {
				company: "四川环福置地有限公司"
			}; //ajax传递给后台的data键值对
			getCompanyInfoD1(jsonData);
		},
		render: function render() {
			return _react2.default.createElement('div', { id: 'show-charts', className: 'show-charts' });
		}
	});
	exports.default = PersonIndexChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PersonIndexChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})