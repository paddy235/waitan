webpackHotUpdate(0,{

/***/ 949:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var SearchList = _react2.default.createClass({
	  displayName: 'SearchList',

	  getInitialState: function getInitialState() {
	    return {
	      count: 0,
	      DataList: [],
	      nowpage: 0
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.searchDataRequest, this.props.searchDataResult);
	    if (!isEqual) {
	      var searchDataRequest = nextProps.searchDataRequest;
	      var searchDataResult = nextProps.searchDataResult;

	      if (searchDataRequest == true) {
	        if (searchDataResult.success == true) {
	          this.dataFomat(searchDataResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content.rdata;
	    var count = data.content.sum;
	    if (content.length != 0) this.setState({ count: count, DataList: content });else this.setState({ count: count, DataList: null });
	  },
	  getLargeLoan: function getLargeLoan(jsonData) {
	    var getSearchDataRequest = this.props.getSearchDataRequest;

	    getSearchDataRequest(jsonData);
	  },
	  //分页回调 
	  setCallBack: function setCallBack(nowpage, eachPageCount) {
	    console.info("aaaaaaaaaaaaaaaaaaa", eachPageCount);
	    this.setState({ nowpage: nowpage - 1 });
	    var searchName = "";
	    $("#inp").val() ? searchName = $("#inp").val() : searchName = this.props.location.query.searchInfo;
	    var jsonData = {
	      "company": searchName,
	      "page_no": nowpage - 1,
	      "page_size": 4
	    };
	    if ($("#inp").val() || this.props.location.query.searchInfo) this.getLargeLoan(jsonData);
	  },
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      var jsonData = {
	        "company": this.props.location.query.searchInfo,
	        "page_no": 0,
	        "page_size": 4
	      };
	      this.getLargeLoan(jsonData);
	    }
	  },

	  render: function render() {
	    var textBox = "";
	    if (this.state.count != 0) {
	      textBox = _react2.default.createElement(
	        'span',
	        { className: 'total' },
	        '共搜索到相关',
	        _react2.default.createElement(
	          'em',
	          null,
	          this.state.count
	        ),
	        '家企业。'
	      );
	    }
	    if (this.state.DataList) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'SearchList' },
	        _react2.default.createElement(
	          'ul',
	          { className: 'ulBox xxx', id: 'show' },
	          this.state.DataList.map(function (ele, index) {
	            return _react2.default.createElement(
	              'li',
	              { className: 'liList', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  _reactRouter.Link,
	                  { to: '/SearchResultDetail?csy=fuck是' },
	                  _react2.default.createElement(
	                    'h2',
	                    null,
	                    ele.company_name
	                  )
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册号：',
	                  ele.regno
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '类型：',
	                  ele.company_type
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '法定代表人：',
	                  ele.frname
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册资本：',
	                  ele.regcap
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '成立日期：',
	                  ele.esdate
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册地址：',
	                  ele.address
	                )
	              )
	            );
	          }),
	          _react2.default.createElement(
	            'div',
	            { className: 'page' },
	            textBox,
	            _react2.default.createElement(_index.PageList, { id: 'pageList1', count: this.state.count, showPage: '6', callback: this.setCallBack })
	          )
	        )
	      );
	    } else if (this.state.DataList == null) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'noResult' },
	        '抱歉！ 暂无搜索结果'
	      );
	    }
	  }
	});
	module.exports = SearchList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})