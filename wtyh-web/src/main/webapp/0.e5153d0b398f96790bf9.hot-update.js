webpackHotUpdate(0,{

/***/ 954:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _Announcement = __webpack_require__(955);

	var _Announcement2 = _interopRequireDefault(_Announcement);

	var _RefereeDocuments = __webpack_require__(956);

	var _RefereeDocuments2 = _interopRequireDefault(_RefereeDocuments);

	var _Executor = __webpack_require__(957);

	var _Executor2 = _interopRequireDefault(_Executor);

	var _BrokenPromises = __webpack_require__(958);

	var _BrokenPromises2 = _interopRequireDefault(_BrokenPromises);

	var _CourtAnnouncement = __webpack_require__(959);

	var _CourtAnnouncement2 = _interopRequireDefault(_CourtAnnouncement);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var ControlRecord = _react2.default.createClass({
		displayName: 'ControlRecord',
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
				case 'announcement':
					_pageNum = 1;
					break;
				case 'referee-documents':
					_pageNum = 2;
					break;
				case 'executor':
					_pageNum = 3;
					break;
				case 'broken-promises':
					_pageNum = 4;
					break;
				case 'court-announcement':
					_pageNum = 5;
					break;
			}
			this.setState({
				pageNum: _pageNum
			});
		},
		render: function render() {
			console.log(this.props, "props_ControlRecord");
			var self = this;
			return _react2.default.createElement(
				'div',
				{ className: 'control-record' },
				_react2.default.createElement(
					'div',
					{ className: 'control-title' },
					_react2.default.createElement(
						'div',
						{ className: 'title-item title-active', onClick: this.switchPage.bind(this, 'announcement') },
						'开庭公告'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'referee-documents') },
						'裁判文书'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'executor') },
						'被执行人'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'broken-promises') },
						'失信被执行人'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'court-announcement') },
						'法院公告'
					)
				),
				function () {
					switch (self.state.pageNum) {
						case 1:
							return _react2.default.createElement(_Announcement2.default, this.props);
							break;
						case 2:
							return _react2.default.createElement(_RefereeDocuments2.default, this.props);
							break;
						case 3:
							return _react2.default.createElement(_Executor2.default, this.props);
							break;
						case 4:
							return _react2.default.createElement(_BrokenPromises2.default, this.props);
							break;
						case 5:
							return _react2.default.createElement(_CourtAnnouncement2.default, this.props);
							break;
					}
				}()
			);
		}
	}); /**
	     * 诉控记录
	     */

	exports.default = ControlRecord;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ControlRecord.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})