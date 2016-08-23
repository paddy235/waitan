webpackHotUpdate(0,{

/***/ 955:
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
	 * 诉讼记录>开庭公告
	 */

	var Immutable = __webpack_require__(718);
	var data = "1";
	var Announcement = _react2.default.createClass({
		displayName: 'Announcement',
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var _this = this;
			if (nextProps.CompanyInfoC1Request) {
				var data = nextProps.CompanyInfoC1Result;
				console.log(data, "诉讼记录A");
			}
		},
		componentDidMount: function componentDidMount() {
			var getCompanyInfoC1 = this.props.getCompanyInfoC1; // 取到props里面的getRealTimeTable方法。也可以说是请求action

			var jsonData = {
				company: "汕头市金通汽车运输有限公司"
			}; //ajax传递给后台的data键值对
			getCompanyInfoC1(jsonData);
		},
		render: function render() {
			console.log(this.props, "props_Announcement");
			return _react2.default.createElement(
				'div',
				{ className: 'content announcement' },
				_react2.default.createElement(
					'div',
					{ className: 'content-title' },
					_react2.default.createElement(
						'div',
						null,
						'案号'
					),
					_react2.default.createElement(
						'div',
						null,
						'公告人ss'
					),
					_react2.default.createElement(
						'div',
						null,
						'公告内容'
					),
					_react2.default.createElement(
						'div',
						null,
						'公告类型'
					),
					_react2.default.createElement(
						'div',
						null,
						'公告时间'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content-content clear-fix' },
					_react2.default.createElement(
						'div',
						null,
						'1'
					),
					_react2.default.createElement(
						'div',
						null,
						'成都市金牛区人民法院'
					),
					_react2.default.createElement(
						'div',
						null,
						'申请人潘文财依据北京市第二中级人民法院作出的民事判决，向北京市通州区人民法院申请执行，要被执行人中扶建设有限责任公司北京路通同泰建筑分公司（以下简称路通同泰建筑分公司）给付货款、违约金、迟延履行期间的债务利息，共计115万余元。执行法院通过相关查询、现场勘查，发现路通同泰建筑分公司没有能力履行全部债务。'
					),
					_react2.default.createElement(
						'div',
						null,
						'相关法人'
					),
					_react2.default.createElement(
						'div',
						null,
						'2016年6月7日'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content-content clear-fix' },
					_react2.default.createElement(
						'div',
						null,
						'2'
					),
					_react2.default.createElement(
						'div',
						null,
						'成都市金牛区人民法院'
					),
					_react2.default.createElement(
						'div',
						null,
						'申请人潘文财依据北京市第二中级人民法院作出的民事判决，向北京市通州区人民法院申请执行，要被执行人中扶建设有限责任公司北京路通同泰建筑分公司（以下简称路通同泰建筑分公司）给付货款、违约金、迟延履行期间的债务利息，共计115万余元。执行法院通过相关查询、现场勘查，发现路通同泰建筑分公司没有能力履行全部债务。'
					),
					_react2.default.createElement(
						'div',
						null,
						'相关法人'
					),
					_react2.default.createElement(
						'div',
						null,
						'2016年6月7日'
					)
				)
			);
		}
	});
	exports.default = Announcement;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Announcement.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})