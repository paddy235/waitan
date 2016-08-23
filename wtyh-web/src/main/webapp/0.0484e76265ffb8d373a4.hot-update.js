webpackHotUpdate(0,{

/***/ 957:
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
	 * 诉讼记录>被执行人
	 */


	var Immutable = __webpack_require__(718);
	var data = "1";
	var Executor = _react2.default.createClass({
		displayName: 'Executor',
		getInitialState: function getInitialState() {
			return {
				content: null
			};
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var _this = this;
			if (nextProps.CompanyInfoC3Request) {
				var data = nextProps.CompanyInfoC3Result;
				console.log(data, "诉讼记录C");
				this.setState({
					content: data.content.map(function (itme, index) {
						return _react2.default.createElement(
							'div',
							{ className: 'content-content clear-fix' },
							_react2.default.createElement(
								'div',
								null,
								'中国平安财产保险股份有限公司阳泉中心支公司'
							),
							_react2.default.createElement(
								'div',
								null,
								'41052119801****2519'
							),
							_react2.default.createElement(
								'div',
								null,
								'山西省阳曲县人民法院'
							),
							_react2.default.createElement(
								'div',
								null,
								'2015年12月15日'
							),
							_react2.default.createElement(
								'div',
								null,
								'(2016)阳法晋0122执字第00104号'
							),
							_react2.default.createElement(
								'div',
								null,
								'20000'
							)
						);
					})

				});
			}
		},
		componentDidMount: function componentDidMount() {
			var getCompanyInfoC3 = this.props.getCompanyInfoC3; // 取到props里面的getRealTimeTable方法。也可以说是请求action

			var jsonData = {
				company: "汕头市金通汽车运输有限公司"
			}; //ajax传递给后台的data键值对
			getCompanyInfoC3(jsonData);
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'content executor' },
				_react2.default.createElement(
					'div',
					{ className: 'content-title' },
					_react2.default.createElement(
						'div',
						null,
						'被执行人姓名/名称'
					),
					_react2.default.createElement(
						'div',
						null,
						'身份证号/组织机构代码'
					),
					_react2.default.createElement(
						'div',
						null,
						'执行法院'
					),
					_react2.default.createElement(
						'div',
						null,
						'立案时间'
					),
					_react2.default.createElement(
						'div',
						null,
						'案号'
					),
					_react2.default.createElement(
						'div',
						null,
						'执行标的'
					)
				),
				this.state.content
			);
		}
	});
	exports.default = Executor;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Executor.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})