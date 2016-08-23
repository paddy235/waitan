webpackHotUpdate(0,{

/***/ 958:
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
	 * 公司新闻
	 */

	var Immutable = __webpack_require__(718);

	var data = "";
	var CompanyNews = _react2.default.createClass({
	  displayName: 'CompanyNews',
	  getInitialState: function getInitialState() {
	    return {
	      itemAll: null
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.CompanyInfoNewsRequest, this.props.CompanyInfoNewsResult); //判断数据是否变化
	    if (!isEqual) {
	      var CompanyInfoNewsRequest = nextProps.CompanyInfoNewsRequest;
	      var CompanyInfoNewsResult = nextProps.CompanyInfoNewsResult;

	      if (CompanyInfoNewsRequest == true) {
	        data = CompanyInfoNewsResult.content.results;
	        if (!data) return;
	        console.log(data, "companyInfoNEWS");
	        _this.setState({
	          itemAll: data.map(function (item, index) {
	            return _react2.default.createElement(
	              'div',
	              { className: 'news-item', key: index },
	              _react2.default.createElement(
	                'div',
	                { className: 'news-list-item clear-fix' },
	                _react2.default.createElement(
	                  'div',
	                  { className: 'clear-fix' },
	                  _react2.default.createElement(
	                    'div',
	                    { className: 'item-num' },
	                    index
	                  ),
	                  _react2.default.createElement(
	                    'div',
	                    { className: 'item-title' },
	                    _react2.default.createElement(
	                      'a',
	                      { href: 'http://www.baidu.com' },
	                      item.news_title
	                    )
	                  )
	                ),
	                _react2.default.createElement(
	                  'div',
	                  { className: 'item-content' },
	                  item.content
	                ),
	                _react2.default.createElement(
	                  'div',
	                  { className: 'right-bottom-text' },
	                  _react2.default.createElement(
	                    'span',
	                    { className: 'website' },
	                    item.news_site
	                  ),
	                  _react2.default.createElement(
	                    'span',
	                    { className: 'rel-date' },
	                    item.pubdate
	                  )
	                )
	              )
	            );
	          })
	        });
	      } else {
	        // alert(404)
	      }
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoNews = this.props.getCompanyInfoNews;

	    var data = this.props.location.query.companyName;
	    var jsonData = {
	      company: data
	    };
	    getCompanyInfoNews(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'company-news company-news-scroll mod-space-l mod-space-t' },
	      _react2.default.createElement(
	        'div',
	        { className: 'news-name' },
	        '公司新闻舆情'
	      ),
	      this.state.itemAll
	    );
	  }
	});
	exports.default = CompanyNews;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyNews.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})