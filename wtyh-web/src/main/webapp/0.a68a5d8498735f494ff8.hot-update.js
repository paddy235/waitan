webpackHotUpdate(0,{

/***/ 938:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(939);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Search = _react2.default.createClass({
	  displayName: 'Search',
	  componentDidMount: function componentDidMount() {},

	  clickSearch: function clickSearch() {
	    if (this.refs.inp.value) {
	      var getSearchDataRequest = this.props.getSearchDataRequest;

	      var companyData = {
	        "company": this.refs.inp.value,
	        "page_no": 0,
	        "page_size": 4
	      };
	      getSearchDataRequest(companyData);
	      // $("#show").show()
	    }
	  },
	  keySearch: function keySearch(event) {
	    if (event.which == "13") this.clickSearch();
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Search' },
	      _react2.default.createElement(
	        'div',
	        { className: 'SearchBox' },
	        _react2.default.createElement(
	          'h1',
	          null,
	          '企业全息信息查询平台f'
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'SearchInp' },
	          _react2.default.createElement('input', { placeholder: '', type: 'text', ref: 'inp', id: 'inp', onKeyUp: this.keySearch }),
	          _react2.default.createElement(
	            'a',
	            { id: 'href', href: 'javascript:void(0);', onClick: this.clickSearch },
	            _react2.default.createElement('i', { className: 'iconfont icon-search' })
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = Search;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Search.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})