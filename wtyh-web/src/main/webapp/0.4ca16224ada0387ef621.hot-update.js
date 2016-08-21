webpackHotUpdate(0,{

/***/ 959:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(955);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _BusinessInfo = __webpack_require__(960);

	var _BusinessInfo2 = _interopRequireDefault(_BusinessInfo);

	var _ShareholderExe = __webpack_require__(961);

	var _ShareholderExe2 = _interopRequireDefault(_ShareholderExe);

	var _ControlRecord = __webpack_require__(962);

	var _ControlRecord2 = _interopRequireDefault(_ControlRecord);

	var _RecruitingInfo = __webpack_require__(968);

	var _RecruitingInfo2 = _interopRequireDefault(_RecruitingInfo);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/**
	 * 底部表格
	 */


	var CompanyDetail = _react2.default.createClass({
		displayName: 'CompanyDetail',
		GetQueryString: function GetQueryString(paraName) {
			var sUrl = window.location.href;
			var sReg = "(?:\\?|&){1}" + paraName + "=([^&]*)";
			var re = new RegExp(sReg, "gi");
			re.exec(sUrl);return RegExp.$1;
		},
		getInitialState: function getInitialState() {
			return {
				pageNum: 1
			};
		},
		componentWillMount: function componentWillMount() {},

		componentDidMount: function componentDidMount() {
			var getPageNums = this.GetQueryString("formpage");
			if (getPageNums == "Portrait") {
				this.refs.susong.click();
			}
			function getQueryString(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
				var r = window.location.search.substr(1).match(reg);
				if (r != null) return unescape(r[2]);return null;
			}
			var a = this.props.location.query.companyName;
		},
		switchPage: function switchPage(param, ev) {
			$(".label-name").removeClass('name-active');
			$(ev.target).addClass('name-active');
			var _pageNum;
			switch (param) {
				case 'bussiness-info':
					_pageNum = 1;
					break;
				case 'shareholder-exe':
					_pageNum = 2;
					break;
				case 'control-record':
					_pageNum = 3;
					break;
				case 'recruiting-info':
					_pageNum = 4;
					break;
			}
			this.setState({
				pageNum: _pageNum
			});
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'company-detail-inner mod-space-l mod-space-t' },
				_react2.default.createElement(
					'div',
					{ className: 'clabel' },
					'企业信息'
				),
				_react2.default.createElement(
					'div',
					{ className: 'label-all clear-fix' },
					_react2.default.createElement(
						'div',
						{ className: 'label-name name-active', onClick: this.switchPage.bind(this, 'bussiness-info') },
						'工商信息'
					),
					_react2.default.createElement(
						'div',
						{ className: 'label-name', onClick: this.switchPage.bind(this, 'shareholder-exe') },
						'股东高管'
					),
					_react2.default.createElement(
						'div',
						{ className: 'label-name', ref: 'susong', onClick: this.switchPage.bind(this, 'control-record') },
						'诉讼记录'
					),
					_react2.default.createElement(
						'div',
						{ className: 'label-name', onClick: this.switchPage.bind(this, 'recruiting-info') },
						'招聘信息'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'bussiness-content' },
					this.state.pageNum == 1 ? _react2.default.createElement(_BusinessInfo2.default, this.props) : this.state.pageNum == 2 ? _react2.default.createElement(_ShareholderExe2.default, this.props) : this.state.pageNum == 3 ? _react2.default.createElement(_ControlRecord2.default, this.props) : _react2.default.createElement(_RecruitingInfo2.default, this.props)
				)
			);
		}
	});
	exports.default = CompanyDetail;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDetail.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})