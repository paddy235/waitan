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
	  getInitialState: function getInitialState() {
	    return {
	      content: []
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    if (nextProps.CompanyInfoC1Request) {
	      var data = nextProps.CompanyInfoC1Result;
	      console.log(data.content, "诉讼记录A");
	      this.setState({ content: data.content });
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
	    console.log(this.state.content, '33333333333333');
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
	          '案件内容'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '案由'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '当事人'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '开庭日期'
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          '省份'
	        )
	      ),
	      this.state.content.map(function (item, index) {
	        return;
	        _react2.default.createElement(
	          'div',
	          { className: 'content-content clear-fix', key: index },
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          ),
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          ),
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          ),
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          ),
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          ),
	          _react2.default.createElement(
	            'div',
	            null,
	            '无数据'
	          )
	        );
	      })
	    );
	  }
	});
	exports.default = Announcement;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Announcement.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})