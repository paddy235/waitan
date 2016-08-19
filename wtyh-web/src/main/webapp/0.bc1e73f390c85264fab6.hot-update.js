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
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.CompanyInfoARequest, this.props.CompanyInfoAResult); //判断数据是否变化
	    if (!isEqual) {
	      var CompanyInfoARequest = nextProps.CompanyInfoARequest;
	      var CompanyInfoAResult = nextProps.CompanyInfoAResult;

	      if (CompanyInfoARequest == true) {
	        data = CompanyInfoAResult.content;
	        console.log(data, "companyInfoNEWS");
	      } else {
	        // alert(404)
	      }
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanyInfoA = this.props.getCompanyInfoA;

	    var jsonData = {
	      company: "贵阳综合保税区投资发展有限公司"
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
	              '王伟'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '注册资本'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '133.793400万人民币'
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
	              '存续（在营、开业、在册）'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '注册时间'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '2010-06-22'
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
	              '互联网和相关服务'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '工商注册号'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '310107000594527'
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
	              '有限责任公司'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '组织机构代码'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '未公开'
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
	              '2013-07-08至2033-07-07'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '登记机关'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '自贸区市场监督管理局'
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
	              '2010-06-22'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '统一信用代码'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '91310000557452741Q'
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
	              '计算机软硬件研发；计算机系统集成；企业征信服务；企业管理咨询、商务咨询（不含投资咨询）；销售电子产品、办公用品、通讯设备（不含无线广播电视发射及卫星地面接收设备)；会议及展览展示服务；货物进出口；技术进出口。（以上经营范围依法须经批准的项目，经相关部门批准后方可开展经营活动）。计算机软硬件研发；计算机系统集成；企业征信服务；企业管理咨询、商务咨询（不含投资咨询）；销售电子产品、办公用品、通讯设备（不含无线广播电视发射及卫星地面接收设备)；会议及展览展示服务；货物进出口；技术进出口。（以上经营范围依法须经批准的项目，经相关部门批准后方可开展经营活动）。'
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