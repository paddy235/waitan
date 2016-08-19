webpackHotUpdate(0,{

/***/ 950:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(944);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/**
	 * 股东高管
	 */

	var ShareholderExe = _react2.default.createClass({
		displayName: 'ShareholderExe',
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
				case 'share-info':
					_pageNum = 1;
					break;
				case 'exe-info':
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
				{ className: 'shareholder-exe clear-fix' },
				_react2.default.createElement(
					'div',
					{ className: 'shareholder-title' },
					_react2.default.createElement(
						'div',
						{ className: 'title-item title-active', onClick: this.switchPage.bind(this, 'share-info') },
						'股东信息'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'exe-info') },
						'高管信息'
					)
				),
				this.state.pageNum == 1 ? _react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'content-title' },
						_react2.default.createElement(
							'div',
							null,
							'股东'
						),
						_react2.default.createElement(
							'div',
							null,
							'股东类型'
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'content-content' },
						_react2.default.createElement(
							'div',
							null,
							'国务院'
						),
						_react2.default.createElement(
							'div',
							null,
							'相关法人'
						),
						'//ajax'
					)
				) : _react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'content-title' },
						_react2.default.createElement(
							'div',
							null,
							'姓名'
						),
						_react2.default.createElement(
							'div',
							null,
							'职务'
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'content-content' },
						_react2.default.createElement(
							'div',
							null,
							'习大大'
						),
						_react2.default.createElement(
							'div',
							null,
							'相关法人'
						),
						'//ajax'
					)
				)
			);
		}
	});
	exports.default = ShareholderExe;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ShareholderExe.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})