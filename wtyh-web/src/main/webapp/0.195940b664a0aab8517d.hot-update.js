webpackHotUpdate(0,{

/***/ 949:
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
	 * 工商信息
	 */

	var Immutable = __webpack_require__(718);

	var data = "";
	var BusinessInfo = _react2.default.createClass({
	  displayName: 'BusinessInfo',
	  getInitialState: function getInitialState() {
	    return {
	      person: null,
	      money: null,
	      state: null,
	      buildTime: null,
	      type: null,
	      num: null,
	      companyType: null,
	      buildNum: null,
	      until: null,
	      whoPass: null,
	      passTime: null,
	      creditNum: null,
	      businessScope: null

	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.CompanyInfoARequest, this.props.CompanyInfoAResult); //判断数据是否变化
	    if (!isEqual) {
	      var CompanyInfoARequest = nextProps.CompanyInfoARequest;
	      var CompanyInfoAResult = nextProps.CompanyInfoAResult;

	      debugger;
	      if (CompanyInfoARequest == true) {
	        data = CompanyInfoAResult.content;
	        console.log(data, "companyInfoNEWS");
	        _this.setState({
	          person: data.法定代表人,
	          money: data.注册资本,
	          state: data.状态,
	          buildTime: data.注册时间,
	          type: data.行业,
	          num: data.工商注册号,
	          companyType: data.企业类型,
	          buildNum: data.组织机构代码,
	          until: data.营业期限,
	          whoPass: data.登记机关,
	          passTime: data.核准日期,
	          creditNum: data.统一信用代码,
	          businessScope: data.经营范围
	        });
	      } else {
	        // alert(404)
	      }
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoA = this.props.getCompanyInfoA;

	    var jsonData = {
	      company: "攀枝花市交通旅游客运有限责任公司"
	    };
	    getCompanyInfoA(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'bussiness-info' },
	      _react2.default.createElement(
	        'table',
	        null,
	        _react2.default.createElement(
	          'tbody',
	          null,
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '法定代表人'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.person
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '注册资本'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.money
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '状态'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.state
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '注册时间'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.buildTime
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement('td', null),
	            _react2.default.createElement('td', null),
	            _react2.default.createElement('td', null),
	            _react2.default.createElement('td', null)
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '行业'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.type
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '工商注册号'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.num
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '企业类型'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.companyType
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '组织机构代码'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.buildNum
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '营业期限'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.until
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '登记机关'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.whoPass
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '核准日期'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.passTime
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '统一信用代码'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              this.state.creditNum
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '经营范围'
	            ),
	            _react2.default.createElement(
	              'td',
	              { className: 'bussiness-scope', colSpan: '2' },
	              this.state.businessScope
	            )
	          )
	        )
	      )
	    );
	  }
	});
	exports.default = BusinessInfo;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessInfo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})