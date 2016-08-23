webpackHotUpdate(0,{

/***/ 957:
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

	/*
	 *公司基本情况
	 */

	var Immutable = __webpack_require__(718);

	var data = null;
	var CompanyInfo = _react2.default.createClass({
	  displayName: 'CompanyInfo',
	  getInitialState: function getInitialState() {
	    return {
	      name: "",
	      person: "",
	      money: "",
	      add: ""
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.CompanyInfoTitRequest, this.props.CompanyInfoTitResult); //判断数据是否变化
	    if (!isEqual) {
	      var CompanyInfoTitRequest = nextProps.CompanyInfoTitRequest;
	      var CompanyInfoTitResult = nextProps.CompanyInfoTitResult;

	      if (CompanyInfoTitRequest == true) {
	        if (CompanyInfoTitRequest == true) {
	          data = CompanyInfoTitResult.content;
	          _this.setState({
	            name: data.公司名称,
	            person: data.法定代表人,
	            money: data.注册资本,
	            add: data.注册地址
	          });
	        } else {
	          alert(404);
	        }
	      }
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoTit = this.props.getCompanyInfoTit;

	    var data = this.props.location.query.companyName;
	    var jsonData = {
	      company: data
	    };
	    getCompanyInfoTit(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'company-info mod-space-l mod-space-t' },
	      _react2.default.createElement(
	        'div',
	        { className: 'logo-name' },
	        _react2.default.createElement('div', { className: 'logo' }),
	        _react2.default.createElement(
	          'div',
	          { className: 'cname' },
	          this.state.name
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'person-info' },
	        _react2.default.createElement(
	          'div',
	          null,
	          _react2.default.createElement('i', { className: 'iconfont icon-person' }),
	          _react2.default.createElement(
	            'span',
	            null,
	            '法定代表人：',
	            this.state.person
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          _react2.default.createElement('i', { className: 'iconfont icon-money' }),
	          _react2.default.createElement(
	            'span',
	            null,
	            '注册资本： ',
	            this.state.money
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          null,
	          _react2.default.createElement('i', { className: 'iconfont icon-position' }),
	          _react2.default.createElement(
	            'span',
	            null,
	            '注册地址： ',
	            this.state.add
	          )
	        )
	      )
	    );
	  }
	});
	exports.default = CompanyInfo;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyInfo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})