webpackHotUpdate(0,{

/***/ 956:
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
	        content: data.content.map(function (itme, index) {
	          return _react2.default.createElement(
	            'div',
	            { className: 'content-content clear-fix', key: index },
	            _react2.default.createElement(
	              'div',
	              null,
	              '1'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '冯阳火与黄志金、中国平安财产保险股份有限公'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '机动车交通事故'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '民事二审案件'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '2015年12月15日'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '被告'
	            ),
	            _react2.default.createElement(
	              'div',
	              null,
	              '上诉人 败诉'
	            )
	          );
	        })

	      });
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoC2 = this.props.getCompanyInfoC2; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {
	      company: "汕头市金通汽车运输有限公司"
	    }; //ajax传递给后台的data键值对
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