webpackHotUpdate(0,{

/***/ 960:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _PersonIndexChart = __webpack_require__(961);

	var _PersonIndexChart2 = _interopRequireDefault(_PersonIndexChart);

	var _PersonIndexPie = __webpack_require__(962);

	var _PersonIndexPie2 = _interopRequireDefault(_PersonIndexPie);

	var _PayIndexBar = __webpack_require__(963);

	var _PayIndexBar2 = _interopRequireDefault(_PayIndexBar);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var RecruitingInfo = _react2.default.createClass({
		displayName: 'RecruitingInfo',
		getInitialState: function getInitialState() {
			return {
				pageNum: 1
			};
		},
		switchPage: function switchPage(param, ev) {
			$(".title-item").removeClass('title-active');
			$(ev.target).addClass('title-active');
			var _pageNum;
			switch (param) {
				case 'person-index':
					_pageNum = 1;
					break;
				case 'pay-distribute':
					_pageNum = 2;
					break;
			}
			this.setState({
				pageNum: _pageNum
			});
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'recruiting-info' },
				_react2.default.createElement(
					'div',
					{ className: 'shareholder-title' },
					_react2.default.createElement(
						'div',
						{ className: 'title-item title-active', onClick: this.switchPage.bind(this, 'person-index') },
						'招聘人数指数'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'pay-distribute') },
						'招聘人员及薪酬分布'
					)
				),
				this.state.pageNum == 1 ? _react2.default.createElement(_PersonIndexChart2.default, this.props) : _react2.default.createElement(
					'div',
					{ className: 'show-charts' },
					_react2.default.createElement(_PersonIndexPie2.default, this.props),
					_react2.default.createElement(_PayIndexBar2.default, this.props)
				)
			);
		}
	});
	exports.default = RecruitingInfo;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RecruitingInfo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})