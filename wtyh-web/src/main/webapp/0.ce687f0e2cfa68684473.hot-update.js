webpackHotUpdate(0,{

/***/ 964:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(955);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/**
	 * 诉讼记录>裁判文书
	 */

	var Immutable = __webpack_require__(718);
	var data = "1";
	var RefereeDocuments = _react2.default.createClass({
	  displayName: 'RefereeDocuments',
	  getInitialState: function getInitialState() {
	    return {
	      content: null
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    if (nextProps.CompanyInfoC2Request) {
	      var data = nextProps.CompanyInfoC2Result;
	      console.log(data, "诉讼记录B");
	      this.setState({
	        content: data.content.map(function (item, index) {
	          return _react2.default.createElement(
	            'div',
	            { className: 'content-content clear-fix', key: index },
	            _react2.default.createElement(
	              'div',
	              null,
	              item.litigant_type
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              item.litigant_type
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              item.action_cause
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              item.case_type
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              item.sentence_date
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '被告'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              item.caseout_come
	            )
	          );
	        })

	      });
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoC2 = this.props.getCompanyInfoC2; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var data = this.props.location.query.companyName;
	    var jsonData = {
	      company: data
	    };
	    getCompanyInfoC2(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'content referee-documents' },
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
	          '案件标题'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '案由'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '案件类型'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '审判时间'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '当事人类型'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '案件结果'
	        )
	      ),
	      this.state.content
	    );
	  }
	});
	exports.default = RefereeDocuments;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RefereeDocuments.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})