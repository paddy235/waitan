webpackHotUpdate(0,{

/***/ 959:
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
	 * 诉讼记录>法院公告
	 */


	var Immutable = __webpack_require__(718);
	var data = "1";
	var CourtAnnouncement = _react2.default.createClass({
		displayName: 'CourtAnnouncement',
		getInitialState: function getInitialState() {
			return {
				content: null
			};
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var _this = this;
			if (nextProps.CompanyInfoC5Request) {
				var data = nextProps.CompanyInfoC5Result;
				console.log(data, "诉讼记录E");
				this.setState({
					content: data.content.results.map(function (item, index) {
						return _react2.default.createElement(
							'div',
							{ className: 'content-content clear-fix' },
							_react2.default.createElement(
								'div',
								null,
								item.notice_people
							),
							_react2.default.createElement(
								'div',
								null,
								item.notice_content
							),
							_react2.default.createElement(
								'div',
								null,
								item.notice_type
							),
							_react2.default.createElement(
								'div',
								null,
								item.notice_time
							)
						);
					})

				});
			}
		},
		componentDidMount: function componentDidMount() {
			var getCompanyInfoC5 = this.props.getCompanyInfoC5; // 取到props里面的getRealTimeTable方法。也可以说是请求action

			var jsonData = {
				company: "中国石油化工股份有限公司"
			}; //ajax传递给后台的data键值对
			getCompanyInfoC5(jsonData);
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'content court-announcement' },
				_react2.default.createElement(
					'div',
					{ className: 'content-title' },
					_react2.default.createElement(
						'div',
						null,
						'公告人'
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
				this.state.content
			);
		}
	});
	exports.default = CourtAnnouncement;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CourtAnnouncement.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})