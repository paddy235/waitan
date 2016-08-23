webpackHotUpdate(0,{

/***/ 750:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(751);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineFinRiskSearchHeaderAction = __webpack_require__(1375);

	var RiskSearchActionCreaters = _interopRequireWildcard(_LineFinRiskSearchHeaderAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险顶部公用头部
	var RiskSearchHeader = _react2.default.createClass({
	  displayName: 'RiskSearchHeader',

	  getInitialState: function getInitialState() {
	    return {
	      companyTag: []
	    };
	  },
	  componentWillMount: function componentWillMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.dynamicRiskCompanyTagResult, this.props.dynamicRiskCompanyTagResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskCompanyTagRequest = nextProps.dynamicRiskCompanyTagRequest;
	      var dynamicRiskCompanyTagResult = nextProps.dynamicRiskCompanyTagResult;

	      if (dynamicRiskCompanyTagRequest == true) {
	        if (dynamicRiskCompanyTagResult.success == true) {
	          this.dataFomat(dynamicRiskCompanyTagResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  getRiskSearchVal: function getRiskSearchVal(data) {
	    var _props = this.props;
	    var getRiskSearchVal = _props.getRiskSearchVal;
	    var getDynamicRiskCompanyTag = _props.getDynamicRiskCompanyTag;

	    getRiskSearchVal(data);
	    var json = { companyName: data };
	    getDynamicRiskCompanyTag(json);
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, '公司标签');
	  },
	  //重新载入搜索结果的页面
	  searchKey: function searchKey(data) {
	    this.getRiskSearchVal(data);
	  },
	  render: function render() {
	    //企业标签className
	    var classNameSet = ["bg-blue", "bg-yellow", "bg-red"];

	    return _react2.default.createElement(
	      'div',
	      { className: 'risk-search-header' },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_IndustrySearch2.default, { companyType: '4', searchFun: this.searchKey, label: '线下理财监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'search-bar' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(
	            'div',
	            { className: 'company-name' },
	            this.props.companyName
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'company-info' },
	            this.state.companyTag.map(function (item, index) {
	              return _react2.default.createElement(
	                'span',
	                { className: classNameSet[index], key: 'span-' + index },
	                item
	              );
	            })
	          ),
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;', className: 'export-report' },
	            _react2.default.createElement('i', { className: 'iconfont icon-export' }),
	            '导出报告'
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/lineFinanceStaticRisk' },
	            _react2.default.createElement('i', { className: 'iconfont icon-bar' }),
	            '静态风险指数'
	          ),
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/lineFinanceDynamicRisk' },
	            _react2.default.createElement('i', { className: 'iconfont icon-history' }),
	            '风险时序差异对比'
	          )
	        )
	      )
	    );
	  }
	});
	//module.exports = RiskSearchHeader;

	function mapStateToProps(state) {
	  return {};
	}
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(RiskSearchActionCreaters, dispatch);
	}

	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RiskSearchHeader);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RiskSearchHeader.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 761:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(728);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _RiskSearchHeader = __webpack_require__(750);

	var _RiskSearchHeader2 = _interopRequireDefault(_RiskSearchHeader);

	var _TimeAxisCompare = __webpack_require__(762);

	var _TimeAxisCompare2 = _interopRequireDefault(_TimeAxisCompare);

	var _IndexCompare = __webpack_require__(768);

	var _IndexCompare2 = _interopRequireDefault(_IndexCompare);

	var _IndexList = __webpack_require__(769);

	var _IndexList2 = _interopRequireDefault(_IndexList);

	var _LineFinanceDynamicRiskAction = __webpack_require__(774);

	var LineFinanceDynamicRiskActionCreators = _interopRequireWildcard(_LineFinanceDynamicRiskAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//动态风险时序差异对比
	var LineFinanceDynamicRisk = _react2.default.createClass({
	  displayName: 'LineFinanceDynamicRisk',

	  getInitialState: function getInitialState() {
	    return {
	      companyName: this.props.location.query.companyName || '《国际金融报》社有限公司',
	      compareMonth: "2016-08",
	      currentMonth: "2016-07",
	      indexCmpData: {}
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    //2.企业关联方特征指数
	    var json = {
	      areaCode: "上海市",
	      companyName: this.state.companyName,
	      currentMonth: this.state.currentMonth,
	      compareMonth: this.state.compareMonth
	    };
	    this.getDynamicRiskData(json);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps);
	    var isEqual = Immutable.is(nextProps.dynamicRiskIndexCmpResult, this.props.dynamicRiskIndexCmpResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskIndexCmpRequest = nextProps.dynamicRiskIndexCmpRequest;
	      var dynamicRiskIndexCmpResult = nextProps.dynamicRiskIndexCmpResult;

	      console.log(dynamicRiskIndexCmpResult, 'dynamicRiskIndexCmpResult');
	      if (dynamicRiskIndexCmpRequest == true) {
	        if (dynamicRiskIndexCmpResult.success == true) {
	          this.dataFomat(dynamicRiskIndexCmpResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, 99999);
	    var content = data.content;
	    this.setState({ indexCmpData: content });
	  },
	  getDynamicRiskData: function getDynamicRiskData(data) {
	    var getDynamicRiskIndexCmp = this.props.getDynamicRiskIndexCmp;

	    getDynamicRiskIndexCmp(data);
	  },
	  render: function render() {

	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-dynamic-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, this.props),
	      _react2.default.createElement(
	        'div',
	        { className: 'dynamic-risk-box content-space-10' },
	        _react2.default.createElement(
	          'div',
	          { className: 'top' },
	          _react2.default.createElement(
	            'div',
	            { className: 'left' },
	            _react2.default.createElement(_TimeAxisCompare2.default, this.props)
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'right' },
	            _react2.default.createElement(_IndexCompare2.default, { indexCmpData: this.state.indexCmpData })
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'bottom mod-space-t' },
	          _react2.default.createElement(_IndexList2.default, { indexCmpData: this.state.indexCmpData })
	        )
	      )
	    );
	  }
	});

	function mapStateToProps(state) {
	  console.log(state.DynamicRiskIndexCmp, 'DynamicRiskIndexCmp');
	  return {
	    //dynamicRiskData: state.dynamicRiskData,

	    //获取公司标签
	    dynamicRiskCompanyTagRequest: state.DynamicRiskCompanyTag.request,
	    dynamicRiskCompanyTagResult: state.DynamicRiskCompanyTag.result,

	    //获取对比图的日期
	    dynamicRiskDateRequest: state.DynamicRiskDate.request,
	    dynamicRiskDateResult: state.DynamicRiskDate.result,

	    //获取对比图
	    dynamicRiskImgRequest: state.DynamicRiskImg.request,
	    dynamicRiskImgResult: state.DynamicRiskImg.result,

	    //获取对比图
	    dynamicRiskIndexCmpRequest: state.DynamicRiskIndexCmp.request,
	    dynamicRiskIndexCmpResult: state.DynamicRiskIndexCmp.result,

	    //获取下拉列表的值
	    riskSearch: state.RiskSearch.data
	  };
	}
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(LineFinanceDynamicRiskActionCreators, dispatch);
	}

	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceDynamicRisk);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DynamicRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 762:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(763);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _EachTimeAxis = __webpack_require__(765);

	var _EachTimeAxis2 = _interopRequireDefault(_EachTimeAxis);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//时间轴对比
	var TimeAxisCompare = _react2.default.createClass({
	  displayName: 'TimeAxisCompare',

	  getInitialState: function getInitialState() {
	    return {
	      companyName: "",
	      month: "",
	      date: [],
	      dateLeft: "", //左侧日期
	      dateRight: "" //右侧日期
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var companyName = "上海北湖投资管理有限公司";
	    var jsonData = { companyName: companyName };
	    this.setState({ companyName: companyName });
	    this.getRelativeDate(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    //获取公司名称 通过名称获取日期
	    var isSearchValEqual = Immutable.is(nextProps.riskSearch, this.props.riskSearch);
	    if (!isSearchValEqual) {
	      var riskSearch = nextProps.riskSearch;

	      var jsonData = { companyName: riskSearch };
	      this.setState({ companyName: riskSearch });
	      this.getRelativeDate(jsonData);
	    }

	    // 获取返回的日期
	    var isEqual = Immutable.is(nextProps.dynamicRiskDateResult, this.props.dynamicRiskDateResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskDateRequest = nextProps.dynamicRiskDateRequest;
	      var dynamicRiskDateResult = nextProps.dynamicRiskDateResult;

	      if (dynamicRiskDateRequest == true) {
	        if (dynamicRiskDateResult.success == true) {
	          this.dataDateFomat(dynamicRiskDateResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataDateFomat: function dataDateFomat(data) {
	    var content = data.content;
	    var len = content.length;
	    var dateArr = [];
	    for (var i = 0; i < len; i++) {
	      dateArr.push({ value: i + 1, label: content[i] });
	    }
	    //把第一个时间赋值给第一个图 第二个时间赋值给第二个图
	    this.setState({ date: dateArr, dateLeft: content[0], dateRight: content[1] }, function () {
	      console.log(this.state.dateLeft, this.state.dateRight, 99999999);
	    });
	  },
	  getRelativeDate: function getRelativeDate(jsonData) {
	    //获取日期
	    var getDynamicRiskDate = this.props.getDynamicRiskDate;

	    getDynamicRiskDate(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-timeaxis-cmp mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '时间轴对比'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'cmp-box' },
	          _react2.default.createElement(
	            'div',
	            { className: 'cmp-l' },
	            _react2.default.createElement(_EachTimeAxis2.default, _extends({ flag: 'left', borderLeft: 'false' }, this.props, { date: this.state.date, nowDate: this.state.dateLeft, companyName: this.state.companyName }))
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'cmp-r' },
	            _react2.default.createElement(_EachTimeAxis2.default, _extends({ flag: 'right', borderLeft: 'true' }, this.props, { date: this.state.date, nowDate: this.state.dateRight, companyName: this.state.companyName }))
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = TimeAxisCompare;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TimeAxisCompare.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 764:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*时间轴对比模块 begin*/\r\n.linefin-timeaxis-cmp .mod-content{\r\n\theight: 880px;\r\n}\r\n.linefin-timeaxis-cmp .mod-content .cmp-box{\r\n    overflow: hidden;\r\n    margin: 5px;\r\n}\r\n.linefin-timeaxis-cmp .mod-content .cmp-box .cmp-l{\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n.linefin-timeaxis-cmp .mod-content .cmp-box .cmp-r{\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n/*时间轴对比模块 end*/\r\n\r\n/*企业关联方特征指数对比 begin*/\r\n.linefin-index-cmp{\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.linefin-index-cmp .mod-content{\r\n\tpadding: 10px;\r\n}\r\n.linefin-index-cmp .mod-content .con-box{\r\n\r\n}\r\n.linefin-index-cmp .mod-content .d-cmp{\r\n\tpadding-left:20px;\r\n\theight: 40px;\r\n\twidth: 100%;\r\n\tbackground-color: #1a2029;\r\n\tmargin-bottom: 1px;\r\n\tborder-radius: 5px;\r\n\toverflow: hidden;\r\n}\r\n.linefin-index-cmp .mod-content .d-cmp .date{\r\n\tdisplay: inline-block;\r\n\tbackground-color: #ffffff;\r\n\tcolor: #888888;\r\n\tfont-size: 14px;\r\n\tpadding: 2px 5px;\r\n\tborder-radius: 2px;\r\n\tmargin-top: 9px;\r\n}\r\n.linefin-index-cmp .mod-content .d-cmp .icon-duibi{\r\n\tmargin-left:10px;\r\n\tmargin-right: 10px;\r\n}\r\n.linefin-index-cmp .item-box .item {\r\n\tborder-radius: 5px;\r\n\toverflow: hidden;\r\n}\r\n.linefin-index-cmp .item-box .item .item-head{\r\n\tbackground-color: #1a2029;\r\n\tborder-bottom: solid 1px #2b323c;\r\n\theight: 40px;\r\n\tcursor: pointer;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span{\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tfont-size: 14px;\r\n\theight: 20px;\r\n\tline-height: 20px;\r\n\tmargin-top: 10px;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span.name{\r\n\tcolor: #e5e5e5;\r\n\twidth: 40%;\r\n\tpadding-left: 20px;\r\n\tfont-size: 14px;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span.num-o{\r\n\twidth: 20%;\r\n}\r\n.linefin-index-cmp .item-box .item .item-head span.num-t{\r\n\twidth: 40%;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span.num-o,\r\n.linefin-index-cmp .item-box  .item-head span.num-t{\r\n\ttext-align: right;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span.num-o em{\r\n\ttext-align: right;\r\n\tfont-size: 14px;\r\n\tcolor: #00b7ee;\r\n}\r\n.linefin-index-cmp .item-box  .item-head span.num-t em{\r\n\tcolor: #e14340;\r\n}\r\n.linefin-index-cmp .item-box .item .item-head span.num-t i{\r\n\tfloat: right;\r\n\tmargin-right: 10px;\r\n\tmargin-top: 3px;\r\n\tfont-size: 12px;\r\n\tmargin-left: 10px;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table{\r\n\twidth: 100%;\r\n\tbackground-color: #36404d;\r\n\theight: 225px;\r\n\toverflow: auto;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table{\r\n\twidth: 100%;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td{\r\n\tborder-bottom:solid 1px #2b323c;\r\n\tpadding: 10px 0;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td.t-left{\r\n\tborder-right:solid 2px #2b323c;\r\n\ttext-align: center;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td.t-left span{\r\n\tdisplay: inline-block;\r\n\twidth: 14px;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td.t-right{\r\n\tpadding-left: 10%;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td.t-right span{\r\n\tdisplay: inline-block;\r\n\tpadding: 5px;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td i{\r\n\tmargin-left: 10px;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td i.icon-xiangshang{\r\n\tcolor: #e14340;\r\n}\r\n.linefin-index-cmp .item-box .item .item-table table td i.icon-arrowupx{\r\n\tcolor: #00b8ee;\r\n}\r\n.linefin-index-cmp .item-box .item.active .item-head span.name{\r\n\tborder-color: #d0d8df;\r\n}\r\n.linefin-index-cmp .item-box .item .item-con{\r\n\tdisplay: none;\r\n}\r\n.linefin-index-cmp .item-box .item.active .item-con{\r\n\tdisplay: block;\r\n}\r\n/*企业关联方特征指数对比 end*/\r\n\r\n/*动态风险指数列表 begin*/\r\n.linefin-index-list{\r\n\tbackground-color: #2b323c;\r\n}\r\n.linefin-index-list .con-box{\r\n\tmargin: 35px 20px 40px 20px;\r\n}\r\n.linefin-index-list .con-box .con-title{\r\n\tbackground-color: #e14340;\r\n\toverflow: hidden;\r\n\twidth: 415px;\r\n\theight: 50px;\r\n\tborder-radius: 5px;\r\n\tline-height: 50px;\r\n\tfont-size: 18px;\r\n\tmargin-bottom: 20px;\r\n}\r\n.linefin-index-list .con-box .con-title .name{\r\n\tmargin-left: 35px;\r\n}\r\n.linefin-index-list .con-box .con-title .name i{\r\n\tmargin-right: 30px;\r\n\tfont-size: 22px;\r\n}\r\n.linefin-index-list .con-box .con-title .num{\r\n\tborder-left: solid 1px #eeeeee;\r\n\tmargin-left: 40px;\r\n\tpadding-left: 40px;\r\n}\r\n.index-list-tab .mt-tabs-header{\r\n\tbackground-color: #1a212b;\r\n}\r\n.index-list-tab .mt-tabs-header li{\r\n\twidth: 12.5%;\r\n\tborder-left: solid 1px #1e222b;\r\n\tpadding: 5px 10px;\r\n\ttext-align: center;\r\n}\r\n.index-list-tab .mt-tabs-header li a{\r\n\tdisplay: inline-block;\r\n}\r\n.index-list-tab .mt-tabs-header li.mt-tabs-active{\r\n\tbackground-color: #37414d;\r\n\tborder:none;\r\n}\r\n.index-list-tab .mt-tabs-header li span{\r\n\tpadding: 2px 10px;\r\n    display: block;\r\n    float: left;\r\n    text-align: center;\r\n}\r\n.index-list-tab .mt-tabs-header li span.name{\r\n\tcolor: #ffffff;\r\n\twidth: 90px;\r\n}\r\n.index-list-tab .mt-tabs-header li span.num{\r\n\tcolor:#e14340;\r\n\tborder-left: solid 1px #8a8c9b;\r\n\tmargin-top: 10px;\r\n}\r\n.index-list-tab .mt-tabs-content{\r\n\tbackground-color: #37414d !important;\r\n\tborder:none;\r\n}\r\n/*动态风险指数列表 end*/", ""]);

	// exports


/***/ },

/***/ 765:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(766);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//每个时间轴
	var EachTimeAxis = _react2.default.createClass({
	  displayName: 'EachTimeAxis',

	  getInitialState: function getInitialState() {
	    return {
	      wNo: 25,
	      scale: 100
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.nowDate, this.props.nowDate); //判断数据是否变化
	    if (!isEqual) {
	      var companyName = nextProps.companyName;
	      var nowDate = nextProps.nowDate;
	      var json = { companyName: companyName, month: nowDate };
	      this.getRelativeImg(json);
	    }
	  },
	  getRelativeImg: function getRelativeImg(jsonData) {
	    //获取图片
	    var getDynamicRiskImg = this.props.getDynamicRiskImg;

	    getDynamicRiskImg(jsonData);
	  },

	  minClick: function minClick(e) {
	    //缩小图片
	    var wNo = this.state.wNo;
	    if (wNo > 25) {
	      wNo = wNo - 25;
	    }
	    var scale = wNo / 250 * 1000;
	    this.setState({ wNo: wNo, scale: scale });
	  },
	  addClick: function addClick(e) {
	    //放大图片
	    var wNo = this.state.wNo;
	    if (wNo < 200) {
	      wNo = wNo + 25;
	    }
	    var scale = wNo / 250 * 1000;
	    this.setState({ wNo: wNo, scale: scale });
	  },
	  render: function render() {
	    var select = null;
	    var flag = this.props.flag;
	    var nowVal = null;

	    if (this.props.date.length > 0) {
	      var d = this.props.date[0];
	      if (flag == "left") {
	        //判断是左侧图还是右侧图  设置不同的时间
	        nowVal = this.props.date[0].value;
	      } else {
	        nowVal = this.props.date[1].value;
	      }
	      var selectProp = {
	        width: '85px',
	        className: 'index-selected',
	        value: nowVal,
	        placeholder: '时间选择',
	        name: 'testselect',
	        id: 'indexSelected',
	        data: this.props.date,
	        onChange: function (value, date) {
	          var json = { companyName: this.props.companyName, month: date };
	          this.getRelativeImg(json);
	        }.bind(this)
	      };
	      select = _react2.default.createElement(_index.Selected, selectProp);
	    }

	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-each-timeaxis mod' },
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft == 'true' ? 'mod-title bl' : 'mod-title' },
	        _react2.default.createElement(
	          'div',
	          { className: 'date' },
	          _react2.default.createElement(
	            'label',
	            null,
	            '时间选项'
	          ),
	          select
	        ),
	        _react2.default.createElement('i', { className: 'iconfont icon-zoomout' }),
	        _react2.default.createElement(
	          'div',
	          { className: 'scale' },
	          _react2.default.createElement('i', { className: 'min iconfont icon-jian', onClick: this.minClick }),
	          _react2.default.createElement(
	            'div',
	            { className: 'scale-bar' },
	            _react2.default.createElement('span', { className: 's-bar', ref: 'sBar', style: { width: this.state.wNo + 'px' } }),
	            _react2.default.createElement(
	              'em',
	              { ref: 'sBarNo', style: { left: this.state.wNo + 10 + 'px' } },
	              this.state.scale,
	              '%'
	            )
	          ),
	          _react2.default.createElement('i', { className: 'add iconfont icon-jia', onClick: this.addClick })
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft ? 'mod-content bl' : 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'con-box' },
	          _react2.default.createElement('img', { src: this.props.cmpUrl, alt: '时间轴对比图' })
	        )
	      )
	    );
	  }
	});
	module.exports = EachTimeAxis;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EachTimeAxis.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 768:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(763);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _EachTimeAxis = __webpack_require__(765);

	var _EachTimeAxis2 = _interopRequireDefault(_EachTimeAxis);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//企业关联方特征指数对比
	var LineFinanceIndexCompare = _react2.default.createClass({
	    displayName: 'LineFinanceIndexCompare',

	    getInitialState: function getInitialState() {
	        return {
	            //关联自然人
	            decreaseRelationPerson: [],
	            addRelationPerson: [],
	            //关联法人
	            addCompanyPerson: [],
	            decreaseCompanyPerson: [],
	            //利益一致行动法人
	            addAgreeComDet: [],
	            decreaseAgreeComDet: [],
	            //子公司
	            addChildCompany: [],
	            decreaseChildCompany: [],
	            //一度自然人
	            addOnePerson: [],
	            decreaseOnePerson: [],
	            //一度法人
	            addOneCompany: [],
	            decreaseOneCompany: [],
	            //二度自然人
	            addTwoPerson: [],
	            decreaseTwoPerson: [],
	            //二度法人
	            addTwoCompany: [],
	            decreaseTwoCompany: [],
	            //三度自然人
	            addThreePerson: [],
	            decreaseThreePerson: [],
	            //三度法人
	            addThreeCompany: [],
	            decreaseThreeCompany: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, 'nextProps');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var relationData = nextProps.indexCmpData.relationData;
	            console.log(relationData, relationData.decreaseRelationPerson, '指数对比');
	            this.setState({
	                //关联自然人
	                decreaseRelationPerson: relationData.decreaseRelationPerson,
	                addRelationPerson: relationData.addRelationPerson,
	                //关联法人
	                addCompanyPerson: relationData.addCompanyPerson,
	                decreaseCompanyPerson: relationData.decreaseCompanyPerson,
	                //利益一致行动法人
	                addAgreeComDet: relationData.addAgreeComDet,
	                decreaseAgreeComDet: relationData.decreaseAgreeComDet,
	                //子公司
	                addChildCompany: relationData.addChildCompany,
	                decreaseChildCompany: relationData.decreaseChildCompany,
	                //一度自然人
	                addOnePerson: relationData.addOnePerson,
	                decreaseOnePerson: relationData.decreaseOnePerson,
	                //一度法人
	                addOneCompany: relationData.addOneCompany,
	                decreaseOneCompany: relationData.decreaseOneCompany,
	                //二度自然人
	                addTwoPerson: relationData.addTwoPerson,
	                decreaseTwoPerson: relationData.decreaseTwoPerson,
	                //二度法人
	                addTwoCompany: relationData.addTwoCompany,
	                decreaseTwoCompany: relationData.decreaseTwoCompany,
	                //三度自然人
	                addThreePerson: relationData.addThreePerson,
	                decreaseThreePerson: relationData.decreaseThreePerson,
	                //三度法人
	                addThreeCompany: relationData.addThreeCompany,
	                decreaseThreeCompany: relationData.decreaseThreeCompany
	            });
	        }
	    },

	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        if (isTrue) {
	            $itemParent.removeClass('active');
	            $(this.refs.itemFirst).addClass('active');
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xup').addClass('icon-xdown');
	        } else {
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xdown').addClass('icon-xup');
	            $(this.refs.itemFirst).removeClass('active');
	            $itemParent.addClass('active');
	            $itemParent.siblings('.item').removeClass('active');
	        }
	    },
	    render: function render() {
	        var _props$indexCmpData = this.props.indexCmpData;
	        var current = _props$indexCmpData.current;
	        var compare = _props$indexCmpData.compare;
	        var relationData = _props$indexCmpData.relationData;


	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-cmp mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业关联方特征指数对比'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'con-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'd-cmp' },
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'date' },
	                            current
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-duibi' }),
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'date' },
	                            compare
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'item-box' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item active' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '关联自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseRelationPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addRelationPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '关联法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseCompanyPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addCompanyPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '利益一致行动法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '利益一致行动法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseAgreeComDet.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addAgreeComDet.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '子公司'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '子公司对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseChildCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addChildCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '一度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '一度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseOnePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addOnePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '一度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '一度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseOneCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addOneCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '二度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '二度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseTwoPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addTwoPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '二度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '二度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseTwoCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addTwoCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '三度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '三度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseThreePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addThreePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '三度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '三度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseThreeCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addThreeCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceIndexCompare;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexCompare.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 769:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(763);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _EachTimeAxis = __webpack_require__(765);

	var _EachTimeAxis2 = _interopRequireDefault(_EachTimeAxis);

	var _RiskTab = __webpack_require__(770);

	var _RiskTab2 = _interopRequireDefault(_RiskTab);

	var _IndexListTableOne = __webpack_require__(1382);

	var _IndexListTableOne2 = _interopRequireDefault(_IndexListTableOne);

	var _IndexListTableTwo = __webpack_require__(1383);

	var _IndexListTableTwo2 = _interopRequireDefault(_IndexListTableTwo);

	var _IndexListTableThree = __webpack_require__(1384);

	var _IndexListTableThree2 = _interopRequireDefault(_IndexListTableThree);

	var _IndexListTableFour = __webpack_require__(1385);

	var _IndexListTableFour2 = _interopRequireDefault(_IndexListTableFour);

	var _IndexListTableFive = __webpack_require__(1386);

	var _IndexListTableFive2 = _interopRequireDefault(_IndexListTableFive);

	var _IndexListTableSix = __webpack_require__(1387);

	var _IndexListTableSix2 = _interopRequireDefault(_IndexListTableSix);

	var _IndexListTableSeven = __webpack_require__(1388);

	var _IndexListTableSeven2 = _interopRequireDefault(_IndexListTableSeven);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//动态风险指数列表
	var LineFinanceIndexList = _react2.default.createClass({
	    displayName: 'LineFinanceIndexList',

	    getInitialState: function getInitialState() {
	        return {
	            indexCmpData: {}
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, 'nextProps');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var indexCmpData = nextProps.indexCmpData;
	            this.setState({ indexCmpData: indexCmpData });
	        }
	    },
	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        if (isTrue) {
	            $itemParent.removeClass('active');
	            $(this.refs.itemFirst).addClass('active');
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xup').addClass('icon-xdown');
	        } else {
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xdown').addClass('icon-xup');
	            $(this.refs.itemFirst).removeClass('active');
	            $itemParent.addClass('active');
	        }
	    },
	    render: function render() {
	        var tabsData = {
	            className: 'index-list-tab',
	            defaultVal: 0,
	            animate: true, //是否支持动画效果？  
	            callBack: function callBack(index, title) {
	                //切换后的回调函数  
	                console.log("当前选择的tabs为：", index);
	                console.log("当前选择的title为：", title);
	            }
	        };
	        var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-list mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业关联方特征指数对比'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'con-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'con-title' },
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'name' },
	                            _react2.default.createElement('i', { className: 'iconfont icon-iconrisk' }),
	                            'BBD时序风险指数'
	                        ),
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'num' },
	                            dynamicRisk ? dynamicRisk.bbdTimeRiskIndex : 0
	                        )
	                    ),
	                    _react2.default.createElement(
	                        _RiskTab2.default,
	                        tabsData,
	                        _react2.default.createElement(
	                            'div',
	                            { title: '稳态运营风险', num: dynamicRisk ? dynamicRisk.steadyOperationRisk : 0, className: 'mytabs mytas-c1' },
	                            _react2.default.createElement(_IndexListTableOne2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '核心资本运作风险', num: dynamicRisk ? dynamicRisk.coreCapitalOperationRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableTwo2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '可持续性风险指数', num: dynamicRisk ? dynamicRisk.sustainableRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableThree2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '泡沫化风险指数', num: dynamicRisk ? dynamicRisk.foamRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableFour2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '传销风险指数', num: dynamicRisk ? dynamicRisk.pyramidSellingRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableFive2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '非法集资违规风险', num: dynamicRisk ? dynamicRisk.illegalFundRaisingRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableSix2.default, { indexCmpData: this.state.indexCmpData })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { title: '跨区域舞弊风险', num: dynamicRisk ? dynamicRisk.steadyStateOperationRisk : 0, className: 'mytabs mytas-c2' },
	                            _react2.default.createElement(_IndexListTableSeven2.default, { indexCmpData: this.state.indexCmpData })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceIndexList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 774:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getDynamicRiskImg = getDynamicRiskImg;
	exports.getDynamicRiskIndexCmp = getDynamicRiskIndexCmp;
	exports.getDynamicRiskCompanyTag = getDynamicRiskCompanyTag;
	exports.getDynamicRiskDate = getDynamicRiskDate;
	/*
	* 动态风险模块 action
	* */

	/*
	* 获取图片
	* */
	var DYNAMIC_RISK_IMG_SUCCESS = exports.DYNAMIC_RISK_IMG_SUCCESS = "DYNAMIC_RISK_IMG_SUCCESS";
	var DYNAMIC_RISK_IMG_FAIL = exports.DYNAMIC_RISK_IMG_FAIL = "DYNAMIC_RISK_IMG_FAIL";

	function dynamicRiskImgSuccess(result) {
	  return {
	    type: DYNAMIC_RISK_IMG_SUCCESS,
	    result: result
	  };
	}
	function dynamicRiskImgFail(result) {
	  return {
	    type: DYNAMIC_RISK_IMG_FAIL,
	    result: result
	  };
	}

	function getDynamicRiskImg() {
	  var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

	  return function (dispatch) {
	    $.ajax({
	      type: 'GET',
	      url: '/offlineFinance/showYEDData.do',
	      dataType: 'json',
	      data: json,
	      success: function success(result) {
	        return dispatch(dynamicRiskImgSuccess(result.content));
	      },
	      error: function error(result) {
	        return dispatch(dynamicRiskImgFail(result.content));
	      }
	    });
	  };
	};

	/*
	* 企业关联方特征指数对比
	* */
	var DYNAMIC_RISK_INDEX_CMP_SUCCESS = exports.DYNAMIC_RISK_INDEX_CMP_SUCCESS = "DYNAMIC_RISK_INDEX_CMP_SUCCESS";
	var DYNAMIC_RISK_INDEX_CMP_FAIL = exports.DYNAMIC_RISK_INDEX_CMP_FAIL = "DYNAMIC_RISK_INDEX_CMP_FAIL";

	function dynamicRiskIndexCmpSuccess(result) {
	  return {
	    type: DYNAMIC_RISK_INDEX_CMP_SUCCESS,
	    result: result
	  };
	}
	function dynamicRiskIndexCmpFail(result) {
	  return {
	    type: constDYNAMIC_RISK_INDEX_CMP_FAIL,
	    result: result
	  };
	}

	function getDynamicRiskIndexCmp() {
	  var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

	  return function (dispatch) {
	    $.ajax({
	      type: 'GET',
	      url: '/offlineFinance/dynamicRiskData.do',
	      dataType: 'json',
	      data: json,
	      success: function success(result) {
	        return dispatch(dynamicRiskIndexCmpSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(dynamicRiskIndexCmpFail(result));
	      }
	    });
	  };
	}

	/*
	* 获取公司标签
	* */
	var DYNAMIC_RISK_COMPANY_TAG_SUCCESS = exports.DYNAMIC_RISK_COMPANY_TAG_SUCCESS = "DYNAMIC_RISK_COMPANY_TAG_SUCCESS";
	var DYNAMIC_RISK_COMPANY_TAG_FAIL = exports.DYNAMIC_RISK_COMPANY_TAG_FAIL = "DYNAMIC_RISK_COMPANY_TAG_FAIL";

	function getDynamicRiskCompanyTagsSuccess(result) {
	  return {
	    type: DYNAMIC_RISK_COMPANY_TAG_SUCCESS,
	    result: result
	  };
	}
	function getDynamicRiskCompanyTagsFail(result) {
	  return {
	    type: DYNAMIC_RISK_COMPANY_TAG_FAIL,
	    result: result
	  };
	}

	function getDynamicRiskCompanyTag() {
	  var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

	  return function (dispatch) {
	    $.ajax({
	      type: 'GET',
	      url: '/offlineFinance/companyInfo.do',
	      dataType: 'json',
	      data: json,
	      success: function success(result) {
	        return dispatch(getDynamicRiskCompanyTagsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(getDynamicRiskCompanyTagsFail(result));
	      }
	    });
	  };
	}

	/*
	* 获取对比时间
	* */
	var DYNAMIC_RISK_DATE_SUCCESS = exports.DYNAMIC_RISK_DATE_SUCCESS = "DYNAMIC_RISK_DATE_SUCCESS";
	var DYNAMIC_RISK_DATE_FAIL = exports.DYNAMIC_RISK_DATE_FAIL = "DYNAMIC_RISK_DATE_FAIL";

	function getDynamicRiskDateSuccess(result) {
	  return {
	    type: DYNAMIC_RISK_DATE_SUCCESS,
	    result: result
	  };
	}
	function getDynamicRiskDateFail(result) {
	  return {
	    type: DYNAMIC_RISK_DATE_FAIL,
	    result: result
	  };
	}

	function getDynamicRiskDate(json) {
	  return function (dispatch) {
	    $.ajax({
	      type: 'GET',
	      url: '/offlineFinance/queryDateVersion.do',
	      dataType: 'json',
	      data: json,
	      success: function success(result) {
	        return dispatch(getDynamicRiskDateSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(getDynamicRiskDateFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceDynamicRiskAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 978:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _companyInfoTitRuducer = __webpack_require__(979);

	var _companyInfoTitRuducer2 = _interopRequireDefault(_companyInfoTitRuducer);

	var _companyInfoNewsRuducer = __webpack_require__(980);

	var _companyInfoNewsRuducer2 = _interopRequireDefault(_companyInfoNewsRuducer);

	var _companyInfoARuducer = __webpack_require__(981);

	var _companyInfoARuducer2 = _interopRequireDefault(_companyInfoARuducer);

	var _companyInfoBRuducer = __webpack_require__(982);

	var _companyInfoBRuducer2 = _interopRequireDefault(_companyInfoBRuducer);

	var _companyInfoC1Ruducer = __webpack_require__(983);

	var _companyInfoC1Ruducer2 = _interopRequireDefault(_companyInfoC1Ruducer);

	var _companyInfoC2Ruducer = __webpack_require__(984);

	var _companyInfoC2Ruducer2 = _interopRequireDefault(_companyInfoC2Ruducer);

	var _companyInfoC3Ruducer = __webpack_require__(985);

	var _companyInfoC3Ruducer2 = _interopRequireDefault(_companyInfoC3Ruducer);

	var _companyInfoC4Ruducer = __webpack_require__(986);

	var _companyInfoC4Ruducer2 = _interopRequireDefault(_companyInfoC4Ruducer);

	var _companyInfoC5Ruducer = __webpack_require__(987);

	var _companyInfoC5Ruducer2 = _interopRequireDefault(_companyInfoC5Ruducer);

	var _companyInfoD1Ruducer = __webpack_require__(1372);

	var _companyInfoD1Ruducer2 = _interopRequireDefault(_companyInfoD1Ruducer);

	var _companyInfoD2Ruducer = __webpack_require__(1373);

	var _companyInfoD2Ruducer2 = _interopRequireDefault(_companyInfoD2Ruducer);

	var _companyInfoD3Ruducer = __webpack_require__(1374);

	var _companyInfoD3Ruducer2 = _interopRequireDefault(_companyInfoD3Ruducer);

	var _Common = __webpack_require__(988);

	var _Common2 = _interopRequireDefault(_Common);

	var _SmallLoanMap = __webpack_require__(989);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(990);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(991);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(992);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(993);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(994);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(995);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(996);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(997);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(998);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(999);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1000);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(1001);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(1002);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1003);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1004);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1005);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1006);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1007);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(1008);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1009);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1010);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1011);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyProgress = __webpack_require__(1012);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1013);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1014);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1015);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1016);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1017);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1018);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1019);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1020);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1021);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1022);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1023);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1024);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1025);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1026);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1027);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1028);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1029);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1030);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1031);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1032);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1033);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1034);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1035);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1036);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _CatalogSelect = __webpack_require__(1376);

	var _CatalogSelect2 = _interopRequireDefault(_CatalogSelect);

	var _TimeSelect = __webpack_require__(1377);

	var _TimeSelect2 = _interopRequireDefault(_TimeSelect);

	var _realtimeTableRuducer = __webpack_require__(1037);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1038);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1039);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1040);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1041);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _MenuParkSelectVal = __webpack_require__(1042);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1043);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1044);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1045);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1046);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1047);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ParkImg = __webpack_require__(1378);

	var _ParkImg2 = _interopRequireDefault(_ParkImg);

	var _BuildCompanyList = __webpack_require__(1048);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1049);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1050);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1051);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1052);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1053);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _BuildSwitchVal = __webpack_require__(1379);

	var _BuildSwitchVal2 = _interopRequireDefault(_BuildSwitchVal);

	var _ChartAll3 = __webpack_require__(1054);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1055);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1056);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1057);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1059);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1060);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1061);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1062);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1064);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1065);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1066);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1067);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1068);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1069);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _DynamicRiskCompanyTag = __webpack_require__(1389);

	var _DynamicRiskCompanyTag2 = _interopRequireDefault(_DynamicRiskCompanyTag);

	var _DynamicRiskDate = __webpack_require__(1380);

	var _DynamicRiskDate2 = _interopRequireDefault(_DynamicRiskDate);

	var _DynamicRiskImg = __webpack_require__(1390);

	var _DynamicRiskImg2 = _interopRequireDefault(_DynamicRiskImg);

	var _DynamicRiskIndexCmp = __webpack_require__(1391);

	var _DynamicRiskIndexCmp2 = _interopRequireDefault(_DynamicRiskIndexCmp);

	var _RiskSearch = __webpack_require__(1381);

	var _RiskSearch2 = _interopRequireDefault(_RiskSearch);

	var _industryTypeChart = __webpack_require__(1070);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1071);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1072);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1073);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/


	/*线下理财监测 end*/

	/*预付卡 begin*/


	//楼宇详情页

	//企业占比对比

	//企业目录列表

	/*实时监测 begin*/

	/*=================================交易场所监测=================================*/

	/*=================================融资租赁=================================*/
	//典当法人企业数

	//交易场所清理整顿分类

	/*=================================典当行业监测=================================*/

	/*=================================交易场所监测=================================*/
	//黄浦区交易场所列表

	/*=================================众筹监测=================================*/

	/*=================================典当行业监测=================================*/
	//所有图标

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	//私募股权基本情况

	//私募证券基本情况

	//QFLP试点企业最新进展

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名

	//小额贷款

	//三个echarts图的接口
	var rootReducer = (0, _redux.combineReducers)({

	  /*企业全息*/
	  CompanyInfoTit: _companyInfoTitRuducer2.default,
	  CompanyInfoNews: _companyInfoNewsRuducer2.default,
	  CompanyInfoA: _companyInfoARuducer2.default,
	  CompanyInfoB: _companyInfoBRuducer2.default,
	  CompanyInfoC1: _companyInfoC1Ruducer2.default,
	  CompanyInfoC2: _companyInfoC2Ruducer2.default,
	  CompanyInfoC3: _companyInfoC3Ruducer2.default,
	  CompanyInfoC4: _companyInfoC4Ruducer2.default,
	  CompanyInfoC5: _companyInfoC5Ruducer2.default,
	  CompanyInfoD1: _companyInfoD1Ruducer2.default,
	  CompanyInfoD2: _companyInfoD2Ruducer2.default,
	  CompanyInfoD3: _companyInfoD3Ruducer2.default,

	  /*搜索部分*/
	  Common: _Common2.default,
	  /*行业监测模块*/

	  //P2P平台监测

	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  IndexChartAll: _IndexChartAll2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default, CoreBar: _CoreBar2.default, CoreTrend: _CoreTrend2.default, CoreBalance: _CoreBalance2.default,
	  Litigation: _Litigation2.default,
	  PublicOpinion: _PublicOpinion2.default,
	  RankPic: _RankPic2.default,
	  ScoreLeida: _ScoreLeida2.default,

	  //众筹
	  BusinessTypes: _BusinessTypes2.default,
	  InvestPeople: _InvestPeople2.default,
	  NewProject: _NewProject2.default,
	  RaiseMount: _RaiseMount2.default,
	  List: _List2.default,

	  //典当行业监测
	  PawnMChartAll: _ChartAll2.default,
	  CompanyDirectory: _CompanyDirectory2.default,

	  //私募基金
	  CompanyProgress: _CompanyProgress2.default,
	  QDLPQuality: _QDLPQuality2.default,
	  FundClass: _FundClass2.default,
	  FundCase: _FundCase2.default, FundCaseTop: _FundCaseTop2.default,
	  EquityL: _EquityL2.default,
	  EquityM: _EquityM2.default,
	  EquityR: _EquityR2.default,

	  //交易场所监测
	  HPQList: _HPQList2.default,
	  RegionalDis: _RegionalDis2.default,
	  Classification: _Classification2.default,
	  DetailList: _DetailList2.default,
	  PieCounty: _PieCounty2.default,
	  BarName: _BarName2.default,

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //园区
	  MenuParkSelectVal: _MenuParkSelectVal2.default,
	  MenuParkSelectList: _MenuParkSelectList2.default,

	  //园区首页
	  ParkCamp: _ParkCamp2.default,
	  ParkFinance: _ParkFinance2.default,
	  ParkIndustry: _ParkIndustry2.default,
	  ParkNews: _ParkNews2.default,

	  //园区详情
	  BuildCompanyList: _BuildCompanyList2.default,
	  BuildIndDistri: _BuildIndDistri2.default,
	  CompanyBg: _CompanyBg2.default,
	  BuildList: _BuildList2.default,
	  BuildNews: _BuildNews2.default,
	  BuildRisk: _BuildRisk2.default,
	  BuildSwitchVal: _BuildSwitchVal2.default,
	  ParkImg: _ParkImg2.default,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,
	  RealTimeNews: _realtimeNewsReducer2.default,
	  RealTimeMap: _realtimeMapReducer2.default,
	  RealTimeMapSh: _realtimeMapShReducer2.default,

	  //商业保理监测
	  ChartAll: _ChartAll4.default,
	  businessnumChart: _businessnumChart2.default,
	  balanceChart: _balanceChart2.default,
	  CompanyDirectoryChart: _CompanyDirectoryChart2.default,

	  //预付卡
	  industryTypeChart: _industryTypeChart2.default,
	  TotleMoney: _TotleMoney2.default,

	  //融资租赁
	  Lease: _Lease2.default,
	  ContrastLeft: _ContrastLeft2.default,
	  ContrastRight: _ContrastRight2.default,
	  Catalog: _Catalog2.default,
	  CatalogSelect: _CatalogSelect2.default,
	  TimeSelect: _TimeSelect2.default,

	  //线下理财
	  //线下理财首页
	  LineFinanceRiskDistri: _LineFinanceRiskDistri2.default,
	  LineFinanceList: _LineFinanceList2.default,
	  CheckVal: _CheckVal2.default,

	  DynamicPic: _DynamicPic2.default,
	  SearchResult: _SearchResultList2.default,
	  StaticRisk: _StaticRisk2.default,
	  Statistics: _Statistics2.default,
	  RiskData: _RiskData2.default,
	  CompanyNews: _CompanyNews2.default,
	  QueryDateVersion: _QueryDateVersion2.default,
	  //动态风险
	  DynamicRiskCompanyTag: _DynamicRiskCompanyTag2.default,
	  DynamicRiskDate: _DynamicRiskDate2.default,
	  DynamicRiskImg: _DynamicRiskImg2.default,
	  DynamicRiskIndexCmp: _DynamicRiskIndexCmp2.default,
	  //头部搜索传值
	  RiskSearch: _RiskSearch2.default,

	  //首页
	  homeThree: _homeThree2.default,

	  //企业全息信息查询平台
	  infoSearch: _infoSearch2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*首页 end*/

	/*企业全息信息查询平台 begin*/


	//头部搜索值传递


	//动态风险模块 begein

	/*商业保理监测 end*/

	/*线下理财监测 start*/
	//线下理财首页


	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//园区首页

	/*实时监测 end*/

	//园区

	//取得合规意见或经过会商的交易场所详情列表

	//交易场所清理整顿分类

	//上海市典当企业目录

	//列表

	//6月上海各类众筹平台新增项目数

	/*====================================私募基金===============================*/

	/*=================================众筹监测=================================*/
	//业务类型

	//私募基金分类


	/*====================================p2p画像平台============================*/

	/*====================================私募基金===============================*/
	//QDLP试点企业最新进展

	//动态图谱

	//诉讼信息

	//核心数据

	/*====================================P2P平台监测============================*/

	/*====================================p2p画像平台============================*/
	//基本信息

	//网贷平台数据展示


	//融资担保


	/*企业全息查询*/

	/*行业监测模块*/
	/* 公共搜索 */

	//诉讼记录的五个接口


	/*企业全息查询*/

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1382:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第一个表格
	var IndexListTableOne = _react2.default.createClass({
	    displayName: 'IndexListTableOne',

	    getInitialState: function getInitialState() {
	        return {
	            indexCmpData: {}
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, 'nextProps');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var indexCmpData = nextProps.indexCmpData;
	            this.setState({ indexCmpData: indexCmpData });
	        }
	    },
	    render: function render() {
	        var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	        var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	        var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	        return _react2.default.createElement(
	            'div',
	            { className: 'index-list-table' },
	            _react2.default.createElement(
	                'table',
	                { className: 'mt-table mt-table-center wtyh-table' },
	                _react2.default.createElement(
	                    'tbody',
	                    null,
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '风险类型'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '特征指标'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            current
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            compare
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            { rowSpan: '3' },
	                            '稳态运营风险'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '自然人节点数'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curPersonNum : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprPersonNum : ""
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '企业法人节点数'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curCompanyNum : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprCompanyNum : ""
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '总节点数'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curSumNum : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprSumNum : ""
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = IndexListTableOne;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableOne.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1383:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第三个表格
	var IndexListTableTwo = _react2.default.createClass({
	  displayName: 'IndexListTableTwo',

	  getInitialState: function getInitialState() {
	    return {
	      indexCmpData: {}
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps, 'nextProps');
	    var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	    if (!isEqual) {
	      var indexCmpData = nextProps.indexCmpData;
	      this.setState({ indexCmpData: indexCmpData });
	    }
	  },
	  render: function render() {
	    var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	    var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	    var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	    return _react2.default.createElement(
	      'div',
	      { className: 'index-list-table' },
	      _react2.default.createElement(
	        'table',
	        { className: 'mt-table mt-table-center wtyh-table' },
	        _react2.default.createElement(
	          'tbody',
	          null,
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '风险类型'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '特征指标'
	            ),
	            _react2.default.createElement(
	              'td',
	              { colSpan: '3' },
	              current
	            ),
	            _react2.default.createElement(
	              'td',
	              { colSpan: '3' },
	              compare
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '2' },
	              '核心资本运作风险'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '核心自然人'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curCorePersonList.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.ucp
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprCorePersonList.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pcp
	                );
	              }) : ""
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '控制节点数'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curControlNum.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.ucn
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprControlNum.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pcn
	                );
	              }) : ""
	            )
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = IndexListTableTwo;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableTwo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1384:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第三个表格
	var IndexListTableThree = _react2.default.createClass({
	  displayName: 'IndexListTableThree',

	  getInitialState: function getInitialState() {
	    return {
	      indexCmpData: {}
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps, 'nextProps');
	    var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	    if (!isEqual) {
	      var indexCmpData = nextProps.indexCmpData;
	      this.setState({ indexCmpData: indexCmpData });
	    }
	  },
	  render: function render() {
	    var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	    var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	    var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	    return _react2.default.createElement(
	      'div',
	      { className: 'index-list-table' },
	      _react2.default.createElement(
	        'table',
	        { className: 'mt-table mt-table-center wtyh-table' },
	        _react2.default.createElement(
	          'tbody',
	          null,
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '风险类型'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '特征指标'
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '3' },
	              current
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '3' },
	              compare
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '3' },
	              '可持续性风险'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '利益一致行动法人数量'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curAgreeActNum : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprAgreeActNum : ""
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '利益一致行动法人占比'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curAgreeActProp : "",
	              '%'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprAgreeActProp : "",
	              '%'
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '利益一致行动法人明细'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curAgreeComDet.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.uacd
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprAgreeComDet.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pacd
	                );
	              }) : ""
	            )
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = IndexListTableThree;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableThree.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1385:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第四个表格
	var IndexListTableFour = _react2.default.createClass({
	    displayName: 'IndexListTableFour',

	    getInitialState: function getInitialState() {
	        return {
	            indexCmpData: {}
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, 'nextProps');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var indexCmpData = nextProps.indexCmpData;
	            this.setState({ indexCmpData: indexCmpData });
	        }
	    },
	    render: function render() {
	        var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	        var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	        var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	        return _react2.default.createElement(
	            'div',
	            { className: 'index-list-table' },
	            _react2.default.createElement(
	                'table',
	                { className: 'mt-table mt-table-center wtyh-table' },
	                _react2.default.createElement(
	                    'tbody',
	                    null,
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '风险类型'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '特征指标'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            { colSpan: '3' },
	                            current
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            { colSpan: '3' },
	                            compare
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            { rowSpan: '2' },
	                            '泡沫化风险'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '一度、二度关联法人数量'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curOneTwoComapnyNum : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprOneTwoComapnyNum : ""
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '一度、二度关联法人占比'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curOneTwoCompanyProp : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprOneTwoCompanyProp : ""
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = IndexListTableFour;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableFour.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1386:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第四个表格
	var IndexListTableFive = _react2.default.createClass({
	    displayName: 'IndexListTableFive',

	    getInitialState: function getInitialState() {
	        return {
	            indexCmpData: {}
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, 'nextProps');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var indexCmpData = nextProps.indexCmpData;
	            this.setState({ indexCmpData: indexCmpData });
	        }
	    },
	    render: function render() {
	        var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	        var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	        var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	        return _react2.default.createElement(
	            'div',
	            { className: 'index-list-table' },
	            _react2.default.createElement(
	                'table',
	                { className: 'mt-table mt-table-center wtyh-table' },
	                _react2.default.createElement(
	                    'tbody',
	                    null,
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '风险类型'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '特征指标'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            { colSpan: '3' },
	                            current
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            { colSpan: '3' },
	                            compare
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            { rowSpan: '2' },
	                            '传销风险'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '三度关联自然人数量'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curThreePersonNum : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprThreePersonNum : ""
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tr',
	                        null,
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            '三度关联自然人占比'
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.curThreePersonProp : ""
	                        ),
	                        _react2.default.createElement(
	                            'td',
	                            null,
	                            dynamicRisk ? dynamicRisk.cprThreePersonProp : ""
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = IndexListTableFive;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableFive.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1387:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第四个表格
	var IndexListTableSix = _react2.default.createClass({
	  displayName: 'IndexListTableSix',

	  getInitialState: function getInitialState() {
	    return {
	      indexCmpData: {}
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps, 'nextProps');
	    var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	    if (!isEqual) {
	      var indexCmpData = nextProps.indexCmpData;
	      this.setState({ indexCmpData: indexCmpData });
	    }
	  },
	  render: function render() {
	    var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	    var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	    var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	    return _react2.default.createElement(
	      'div',
	      { className: 'index-list-table' },
	      _react2.default.createElement(
	        'table',
	        { className: 'mt-table mt-table-center wtyh-table' },
	        _react2.default.createElement(
	          'tbody',
	          null,
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '风险类型'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '特征指标'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              current
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              compare
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '3' },
	              '非法集资违规风险'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '投资类，咨询类，贸易类，租赁类，保理类公司数量'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curTypeSumNum : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprTypeSumProp : ""
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '公司明细'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.curCompanyDetail.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.ucd
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              dynamicRisk ? dynamicRisk.cprCompanyDetail.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pcd
	                );
	              }) : ""
	            )
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = IndexListTableSix;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableSix.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1388:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//指数列表 第四个表格
	var IndexListTableSeven = _react2.default.createClass({
	  displayName: 'IndexListTableSeven',

	  getInitialState: function getInitialState() {
	    return {
	      indexCmpData: {}
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps, 'nextProps');
	    var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	    if (!isEqual) {
	      var indexCmpData = nextProps.indexCmpData;
	      this.setState({ indexCmpData: indexCmpData });
	    }
	  },
	  render: function render() {
	    var current = this.state.indexCmpData ? this.state.indexCmpData.current : ""; //获取当前时间
	    var compare = this.state.indexCmpData ? this.state.indexCmpData.compare : ""; //获取对比时间
	    var dynamicRisk = this.state.indexCmpData ? this.state.indexCmpData.dynamicRisk : null;
	    return _react2.default.createElement(
	      'div',
	      { className: 'index-list-table' },
	      _react2.default.createElement(
	        'table',
	        { className: 'mt-table mt-table-center wtyh-table' },
	        _react2.default.createElement(
	          'tbody',
	          null,
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '风险类型'
	            ),
	            _react2.default.createElement('td', null),
	            _react2.default.createElement(
	              'td',
	              { colSpan: '2' },
	              current
	            ),
	            _react2.default.createElement(
	              'td',
	              { colSpan: '2' },
	              compare
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '5' },
	              '跨区域舞弊风险'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '地域积聚化排名'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '地域'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '法人数量'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '地域'
	            ),
	            _react2.default.createElement(
	              'td',
	              null,
	              '法人数量'
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '1'
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '4' },
	              dynamicRisk ? dynamicRisk.curAreaList.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.ual
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '4' },
	              dynamicRisk ? dynamicRisk.curAreaCompanyNum.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.ucn
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '4' },
	              dynamicRisk ? dynamicRisk.cprAreaList.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pal
	                );
	              }) : ""
	            ),
	            _react2.default.createElement(
	              'td',
	              { rowSpan: '4' },
	              dynamicRisk ? dynamicRisk.cprAreaCompanyNum.map(function (elem, index) {
	                return _react2.default.createElement(
	                  'span',
	                  null,
	                  elem.pcn
	                );
	              }) : ""
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '2'
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '3'
	            )
	          ),
	          _react2.default.createElement(
	            'tr',
	            null,
	            _react2.default.createElement(
	              'td',
	              null,
	              '4'
	            )
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = IndexListTableSeven;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexListTableSeven.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1389:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = dynamicRiskImg;

	var _LineFinanceDynamicRiskAction = __webpack_require__(774);

	function dynamicRiskImg() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_COMPANY_TAG_SUCCESS:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_COMPANY_TAG_FAIL:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	} /*
	  * 动态风险获取时间 reducer
	  * */
	//获取图片
	;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DynamicRiskCompanyTag.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1390:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = dynamicRiskImg;

	var _LineFinanceDynamicRiskAction = __webpack_require__(774);

	function dynamicRiskImg() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_IMG_SUCCESS:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_IMG_FAIL:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	} /*
	  * 动态风险获取时间 reducer
	  * */
	//获取图片
	;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DynamicRiskImg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1391:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = dynamicRiskIndexCmp;

	var _LineFinanceDynamicRiskAction = __webpack_require__(774);

	function dynamicRiskIndexCmp() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_INDEX_CMP_SUCCESS:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceDynamicRiskAction.DYNAMIC_RISK_INDEX_CMP_FAIL:
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	} /*
	  * 动态风险获取时间 reducer
	  * */
	//获取图片
	;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DynamicRiskIndexCmp.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})