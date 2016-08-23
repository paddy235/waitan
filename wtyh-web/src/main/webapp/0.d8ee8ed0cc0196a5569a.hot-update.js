webpackHotUpdate(0,{

/***/ 749:
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

	var _LineFinanceRelationGraph = __webpack_require__(754);

	var _LineFinanceRelationGraph2 = _interopRequireDefault(_LineFinanceRelationGraph);

	var _LineFinanceCoCompose = __webpack_require__(757);

	var _LineFinanceCoCompose2 = _interopRequireDefault(_LineFinanceCoCompose);

	var _LineFinanceIndexConstitute = __webpack_require__(758);

	var _LineFinanceIndexConstitute2 = _interopRequireDefault(_LineFinanceIndexConstitute);

	var _LineFinanceStaticRiskAction = __webpack_require__(761);

	var LineFinanceStaticRiskAction = _interopRequireWildcard(_LineFinanceStaticRiskAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//静态风险指数
	var LineFinanceStaticRisk = _react2.default.createClass({
	  displayName: 'LineFinanceStaticRisk',
	  getInitialState: function getInitialState() {
	    return {
	      companyName: this.props.location.query.companyName,
	      companyInfo: ""
	    };
	  },

	  componentWillMount: function componentWillMount() {},
	  componentDidMount: function componentDidMount() {
	    $(".risk-search-header .search-bar .right a").first().addClass('active');
	    var paramObj = { companyName: this.state.companyName };
	    this.queryCompanyInfo(paramObj);
	  },
	  queryCompanyInfo: function queryCompanyInfo(param) {
	    var queryCompanyInfo = this.props.queryCompanyInfo;

	    queryCompanyInfo(param);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.queryCompanyInfoRequest, this.props.queryCompanyInfoRequest);
	    if (!isEqual) {
	      this.setState({
	        companyInfo: nextProps.queryCompanyInfoResult.content.backgroud
	      });
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-static-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, { companyInfo: this.state.companyInfo, companyName: this.state.companyName }),
	      _react2.default.createElement(
	        'div',
	        { className: 'static-risk-box content-space-10' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(_LineFinanceRelationGraph2.default, this.props),
	          _react2.default.createElement(_LineFinanceCoCompose2.default, this.props)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(_LineFinanceIndexConstitute2.default, this.props)
	        )
	      )
	    );
	  }
	});
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {

	    //静态图谱
	    dynamicPicRequest: state.DynamicPic.request,
	    dynamicPicResult: state.DynamicPic.result,
	    //静态风险指数构成
	    // staticRiskRequest:state.StaticRisk.request,
	    // staticRiskResult: state.StaticRisk.result,
	    //静态风险变化趋势图

	    statisticsRequest: state.Statistics.request,
	    statisticsResult: state.Statistics.result,

	    //静态风险公司关联表&静态风险指数构成
	    riskDataRequest: state.RiskData.request,
	    riskDataResult: state.RiskData.result,
	    //公司舆情
	    companyNewsRequest: state.CompanyNews.request,
	    companyNewsResult: state.CompanyNews.result,
	    //时间列表
	    queryDateVersionRequest: state.QueryDateVersion.request,
	    queryDateVersionResult: state.QueryDateVersion.result,

	    //公司标签
	    queryCompanyInfoRequest: state.QueryCompanyInfo.request,
	    queryCompanyInfoResult: state.QueryCompanyInfo.result
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(LineFinanceStaticRiskAction, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceStaticRisk);
	// module.exports = LineFinanceStaticRisk;
	//

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "StaticRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

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

	var _LineFinRiskSearchHeaderAction = __webpack_require__(753);

	var RiskSearchActionCreaters = _interopRequireWildcard(_LineFinRiskSearchHeaderAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险顶部公用头部
	var RiskSearchHeader = _react2.default.createClass({
	  displayName: 'RiskSearchHeader',

	  getInitialState: function getInitialState() {
	    return {
	      companyTag: [],
	      companyName: ""
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
	    //传入标签
	    if (nextProps.companyInfo) {
	      this.setState({
	        companyTag: nextProps.companyInfo
	      });
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
	            { activeClassName: 'active', to: { pathname: '/lineFinanceStaticRisk', query: { companyName: this.state.companyName } } },
	            _react2.default.createElement('i', { className: 'iconfont icon-bar' }),
	            '静态风险指数'
	          ),
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: { pathname: '/lineFinanceDynamicRisk', query: { companyName: this.state.companyName } } },
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

/***/ 754:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险指数关联图
	var LineFinanceRelationGraph = _react2.default.createClass({
	    displayName: 'LineFinanceRelationGraph',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: '',
	            companyName: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        this.queryDynamicPic(1, companyName);
	    },
	    queryDynamicPic: function queryDynamicPic(param, companyName, ev) {
	        $(".btns .btn").removeClass('active');
	        $(".btns .btn").eq(param - 1).addClass('active');
	        var queryDynamicPic = this.props.queryDynamicPic;

	        queryDynamicPic({
	            "companyName": companyName,
	            "dataVersion": "20160530",
	            "degree": param
	        });
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.dynamicPicResult, this.props.dynamicPicResult);
	        if (!isEqual) {
	            (function () {
	                var dynamicPicRequest = nextProps.dynamicPicRequest;
	                var dynamicPicResult = nextProps.dynamicPicResult;

	                if (dynamicPicRequest == true) {
	                    seajs.use("/relativeGraph/assets/script/main/dynamic.js", function (main) {
	                        var pointList = dynamicPicResult.content.pointList;
	                        if (pointList == null || pointList == "" || pointList == "undefined") {
	                            nodes = [];
	                        } else {
	                            nodes = [];
	                            for (var i = 0; i < pointList.length; i++) {
	                                var point = pointList[i];

	                                var symbol = "rect";
	                                if (point.isPerson == "1") {
	                                    symbol = "circle";
	                                }

	                                var color = "#FF0000";
	                                if (point.level == "1") {
	                                    color = "#0030AF";
	                                    if (point.isSonCom == "1") {
	                                        color = "#FFCA00";
	                                    }
	                                } else if (point.level == "2") {
	                                    color = "#36B3EB";
	                                } else if (point.level == "3") {
	                                    color = "#C1C1C1";
	                                } else {}

	                                nodes[i] = {
	                                    "addflag": "false",
	                                    "category": point.level,
	                                    "color": color,
	                                    "name": point.name,
	                                    "symbol": symbol
	                                };
	                            }
	                        }
	                        var lineList = dynamicPicResult.content.lineList;
	                        if (lineList == null || lineList == "" || lineList == "undefined") {
	                            links = [];
	                        } else {
	                            links = [];
	                            for (var i = 0; i < lineList.length; i++) {
	                                var line = lineList[i];
	                                var lineType = "line";
	                                if (line.isFullLine == "0") {
	                                    lineType = "dotted";
	                                }
	                                links[i] = {
	                                    "addflag": "false",
	                                    "guanlian": line.type,
	                                    "line": lineType,
	                                    "relatedParyName": line.relationship,
	                                    "source": line.orig,
	                                    "target": line.target
	                                };
	                            }
	                        }
	                        console.log(dynamicPicResult, "dynamicPicResult=============================");
	                        main.reDrawCanvas();
	                    });
	                }
	            })();
	        }
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    closeDetail: function closeDetail() {
	        $(".relation-modal").hide();
	    },
	    openDetail: function openDetail() {
	        $(".relation-modal").show();
	    },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-rel-graph mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '关联方图谱'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right search-enlarge' },
	                    _react2.default.createElement('i', { className: 'iconfont icon-fullscreen' })
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pic_rank' },
	                    _react2.default.createElement('span', { className: 'add iconfont icon-jia', id: 'btn_bigmore' }),
	                    _react2.default.createElement('span', { className: 'sub iconfont icon-jian', id: 'btn_smaller' })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-legend' },
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
	                                    _react2.default.createElement('span', { className: 'square orange' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '目标公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/xuxianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '投资人'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange-two' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '子公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/shixianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '企业高管'
	                                    )
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'condition' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'lable' },
	                            '请选择以下筛选条件'
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btns' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn active', onClick: this.queryDynamicPic.bind(this, 1, this.state.companyName) },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 2, this.state.companyName) },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 3, this.state.companyName) },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement('div', { className: 'relation-modal', id: 'relation-modal' }),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box', onClick: this.openDetail },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'dyMapMain' },
	                        _react2.default.createElement('div', { id: 'dyMap' })
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceRelationGraph;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceRelationGraph.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 756:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*关联图模块 begin*/\r\n.linefin-rel-graph {\r\n\theight: 1300px;\r\n}\r\n\r\n.linefin-rel-graph .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-rel-graph .mod-title h3 {\r\n}\r\n\r\n.linefin-rel-graph .mod-title .mod-title-right {\r\n\tmargin-top: 5px;\r\n\tdisplay: inline-block;\r\n\tfloat: right;\r\n}\r\n\r\n.linefin-rel-graph .mod-title-right i.icon-fullscreen {\r\n\tmargin-left: 20px;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 6px;\r\n\tfloat: right;\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-rel-graph .mod-content {\r\n\tposition: relative;\r\n}\r\n\r\n.linefin-rel-graph .mod-content .pic_rank {\r\n\tposition: absolute;\r\n\tright: 17px;\r\n\ttop: 62px;\r\n}\r\n\r\n.linefin-rel-graph .mod-content .pic_rank span {\r\n\tborder: 1px solid #3A4450;\r\n\tdisplay: inline-block;\r\n\twidth: 22px;\r\n\theight: 22px;\r\n\tbackground: #19202A;\r\n\ttext-align: center;\r\n\tline-height: 18px;\r\n\tcolor: #E14340;\r\n\tcursor: pointer;\r\n\tmargin-left: 8px;\r\n}\r\n\r\n.linefin-rel-graph .mod-content .relation-graph-box {\r\n\theight: 1200px;\r\n}\r\n\r\n/*关联图模块 end*/\r\n\r\n/*公司舆情 begin*/\r\n.linefin-cocompose {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.linefin-cocompose .mod-title {\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-cocompose .mod-content {\r\n\theight: 550px;\r\n}\r\n\r\n.linefin-cocompose .content-box {\r\n\theight: 534px;\r\n\toverflow: auto;\r\n\tmargin: 20px 20px 0px 20px;\r\n\tbackground-color: #212831;\r\n\tpadding: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box {\r\n\toverflow: hidden;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 a {\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 em {\r\n\tdisplay: inline-block;\r\n\ttext-align: center;\r\n\twidth: 24px;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\tborder-radius: 2px;\r\n\tbackground-color: #1a2029;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box p {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tmargin-left: 45px;\r\n\ttext-indent: 28px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tfloat: right;\r\n\tcolor: #e14340;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source .name {\r\n\tmargin-right: 40px;\r\n}\r\n\r\n/**公司舆情 end*/\r\n\r\n/*静态风险指数构成 begin*/\r\n.linefin-index-constitute .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-index-constitute .mt-select {\r\n\tmargin-top: 5px;\r\n\tmargin-right: 5px;\r\n\tcolor: #c9c9ca;\r\n}\r\n\r\n.linefin-index-constitute .con-box {\r\n\tbackground-color: #2b323c;\r\n\tpadding: 0 20px;\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-info {\r\n\tmin-height: 1362px;\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-pie {\r\n\theight: 520px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-head {\r\n\tbackground-color: #1a2029;\r\n\tborder-bottom: solid 1px #2b323c;\r\n\theight: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tfont-size: 14px;\r\n\theight: 20px;\r\n\tline-height: 20px;\r\n\tmargin-top: 10px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.name {\r\n\tcolor: #e5e5e5;\r\n\twidth: 40%;\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.num {\r\n\twidth: 60%;\r\n\ttext-indent: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head {\r\n\theight: 60px;\r\n\tbackground-color: #e14340;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span {\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.name {\r\n\tfont-size: 18px;\r\n\tborder-color: #ed8e8c;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.num em {\r\n\tfont-size: 36px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-other .item-head span.num i {\r\n\tfloat: right;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 3px;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table {\r\n\twidth: 100%;\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table {\r\n\twidth: 100%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td {\r\n\tborder-bottom: solid 1px #2b323c;\r\n\tpadding: 10px 0;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-left {\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-right {\r\n\tpadding-left: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart {\r\n\theight: 330px;\r\n\tbackground-color: #212831;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart h4 {\r\n\tbackground-color: #1a2029;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tpadding: 0 20px;\r\n\tfont-size: 16px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart .chart-b {\r\n\theight: 290px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-head span.name {\r\n\tfont-size: 16px;\r\n\tborder-color: #d0d8df;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-con {\r\n\tdisplay: none;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-con {\r\n\tdisplay: block;\r\n}\r\n\r\n/*关联图 侧边栏begin*/\r\n.sidebox {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation-tips {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .sidebar {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .canvas {\r\n\tmargin-right: auto !important;\r\n}\r\n\r\n.correlation .time-line {\r\n\tdisplay: none;\r\n}\r\n\r\n/*静态风险指数构成 end*/", ""]);

	// exports


/***/ },

/***/ 758:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//静态风险指数构成
	var LineFinanceIndexConstitute = _react2.default.createClass({
	    displayName: 'LineFinanceIndexConstitute',

	    getInitialState: function getInitialState() {
	        return {
	            statisticsDate: [],
	            riskIndex: [],
	            avgRiskIndex: [],
	            riskList: "",
	            allDate: "",
	            companyName: "",
	            pieOption: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });

	        //请求时间列表
	        var jsonDataDate = { companyName: companyName };
	        this.queryDateVersion(jsonDataDate);

	        //请求右面折线图      
	        var jsonDataLine = { companyName: companyName, areaCode: "金山区" };
	        this.staticRiskIndex(jsonDataLine);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.riskDataResult, this.props.riskDataResult);
	        if (!isEqual) {
	            //右边饼图数据
	            this.setState({
	                riskList: nextProps.riskDataResult.content
	            });
	            this.setParm(nextProps.riskDataResult.content);
	        }
	        var _allDate = [];
	        var queryDateVersionIsEqual = Immutable.is(nextProps.queryDateVersionRequest, this.props.queryDateVersionRequest);
	        if (!queryDateVersionIsEqual) {
	            //右边时间列表
	            nextProps.queryDateVersionResult.content.map(function (item, index) {
	                _allDate.push({
	                    value: index + 1,
	                    label: item
	                });
	            });
	            this.setState({
	                allDate: _allDate
	            });
	            this.queryRiskData(_allDate[0].label); //首次获取时间请求列表
	        }

	        var statisticsIsEqual = Immutable.is(nextProps.statisticsRequest, this.props.statisticsRequest);
	        if (!statisticsIsEqual) {
	            this.setState({
	                lineOption: nextProps.statisticsResult
	            });
	        }
	    },
	    queryRiskData: function queryRiskData(currentDate) {
	        //获取列表数据
	        var jsonData = { companyName: this.state.companyName, currentDate: currentDate };
	        var queryRiskData = this.props.queryRiskData;

	        queryRiskData(jsonData);
	    },
	    queryDateVersion: function queryDateVersion(jsonData) {
	        //获取日期
	        var queryDateVersion = this.props.queryDateVersion;

	        queryDateVersion(jsonData);
	    },
	    staticRiskIndex: function staticRiskIndex(jsonDataLine) {
	        //请求右面折线图         
	        var queryStatistics = this.props.queryStatistics;var self = this;
	        queryStatistics(jsonDataLine);
	    },

	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        var isFirstItem = $itemParent.hasClass('item-first');
	        if (isTrue) {
	            //关闭
	            if (!isFirstItem) {
	                //不是第一项
	                $itemParent.removeClass('active');
	                $(this.refs.itemFirst).addClass('active');
	                $itemParent.find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	        } else {
	            //@yq 修改bug5630 
	            $(".item-other").removeClass('active');
	            $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            if (!isFirstItem) {
	                $itemParent.find('.item-head .num i').removeClass('icon-xdown').addClass('icon-xup');
	                $(this.refs.itemFirst).removeClass('active');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	            $itemParent.addClass('active');
	        }
	    },
	    setParm: function setParm(itemTable) {
	        //渲染右边饼图
	        var option = {
	            "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	            "title": "",
	            "xtitle": "",
	            "legend": [""],
	            "legendShow": false,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "20%",
	            "seriesName": "静态风险指数构成",
	            "radius": "40%",
	            "lable": { normal: { show: true },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '50%'],
	            "series": [{
	                "name": "非法融资违规风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "人才结构风险",
	                "value": itemTable && itemTable.perStructRisk
	            }, {
	                "name": "实际控制人风险",
	                "value": itemTable && itemTable.realConRisk
	            }, {
	                "name": "公司扩张路径风险",
	                "value": itemTable && itemTable.comExpRisk
	            }, {
	                "name": "关联方中心集聚化风险",
	                "value": itemTable && itemTable.relInRisk
	            }, {
	                "name": "非法融资衍生风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "短期逐利风险",
	                "value": itemTable && itemTable.comExpRisk
	            }]
	        };
	        this.setState({ pieOption: option });
	    },
	    setLineParm: function setLineParm(param) {
	        var _xAxisArr = [],
	            _riskIndexArr = [],
	            _avgRiskIndexArr = [];
	        this.state.lineOption[param].map(function (item) {
	            _xAxisArr.push(item.date);
	        });
	        this.state.lineOption[param].map(function (item) {
	            _riskIndexArr.push(item.riskIndex);
	            _avgRiskIndexArr.push(item.avgRiskIndex);
	        });
	        var option = {
	            color: ["#00b7ee", "#f8b551"],
	            bgColor: "",
	            title: "实际控制人风险趋势",
	            titleX: "left", //
	            boxId: "chartMap",
	            symbolSize: 10,
	            legendIsShow: true,
	            yFlag: "",
	            yAxisName: "",
	            legendRight: "30",
	            legend: ["公司", "行业平均"],
	            xAxis: _xAxisArr,
	            series: [_riskIndexArr, _avgRiskIndexArr]
	        };
	        return option;
	    },
	    render: function render() {
	        var self = this;
	        var selectProp = { //渲染右边时间选择        
	            width: '85px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: this.state.allDate ? this.state.allDate[0].label : '',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: this.state.allDate,
	            onChange: function onChange(val) {
	                self.state.allDate.map(function (item) {
	                    if (item.value == val) {
	                        var queryRiskData = self.props.queryRiskData;

	                        queryRiskData({ companyName: self.state.companyName, currentDate: item.label });
	                    }
	                });
	            }
	        };
	        var itemTable = this.state.riskList || '';
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-constitute mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '静态风险指数构成'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right sd' },
	                    this.state.allDate ? _react2.default.createElement(_index.Selected, selectProp) : ''
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
	                        { className: 'index-con-pie' },
	                        this.state.pieOption ? _react2.default.createElement(_BasePie2.default, { option: this.state.pieOption, style: { height: '520px', width: '100%' } }) : ''
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-info' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-first active', ref: 'itemFirst' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '静态风险指数'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        null,
	                                        '51.2'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '静态风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex0'), style: { height: '290px', width: '100%' } }) : ""
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '实际控制人风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.realConRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '单个一度关联自然人最大控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.maxComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '平均每位一度关联自然人控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.avgPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心一度关联自然人'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneLvlPer
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '实际控制人风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex1'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '公司扩张风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.comExpRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司自然人股东数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldComConPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司企业法人数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldCtlNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreCldCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '公司扩张风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex2'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联方中心积聚化风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.relInRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.ctlCldComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '一度关联企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.conCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '关联方中心积聚化风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex3'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融盗衍生风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illFinRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '三度关联自然人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.thrPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '二度关联企业法人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.twoComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心二度关联公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreTwoCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融盗衍生风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex4'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '短期逐利风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.shortRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月~1年以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立的公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '短期逐利风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex5'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融资违规风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illMoneyFinRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '投资类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.investment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '咨询类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '贸易类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '租赁类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.lease
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '保理类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.factoring
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '公司名单'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.companyList
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融资违规风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex6'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '人才结构风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.underNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '硕士以上人次（包括硕士）'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科以下人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '人才结构风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex7'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '资本背景风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '信用信息风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
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
	module.exports = LineFinanceIndexConstitute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceIndexConstitute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 849:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CoreData = _react2.default.createClass({
	    displayName: 'CoreData',


	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            listData: [],
	            coreBarData: null,
	            coreTrendData: null,
	            coreBalanceData: null,
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var _props = this.props;
	            var getcoreDataRequest = _props.getcoreDataRequest;
	            var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	            var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	            var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

	            getcoreDataRequest({ "platName": this.state.companyVal });
	            getCoreBarDataRequest({ "platName": this.state.companyVal });
	            getCoreTrendDataRequest({ "platName": this.state.companyVal });
	            getCoreBalanceDataRequest({ "platName": this.state.companyVal });
	        }

	        var isEqual = Immutable.is(nextProps.coreDataResult, this.props.coreDataResult);
	        if (!isEqual) {
	            var coreDataRequest = nextProps.coreDataRequest;
	            var coreDataResult = nextProps.coreDataResult;

	            if (coreDataRequest == true) {
	                if (coreDataResult.success) {
	                    var _setParm = [coreDataResult.content];
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualBar = Immutable.is(nextProps.coreBarRequest, this.props.coreBarResult);
	        if (!isEqualBar) {
	            var coreBarRequest = nextProps.coreBarRequest;
	            var coreBarResult = nextProps.coreBarResult;

	            if (coreBarRequest == true) {
	                if (coreBarResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        barWidth: 15,
	                        yAxisName: "万元",
	                        yFlag: "", //y轴单位
	                        gridBottom: '0',
	                        unit: ["万元"],
	                        gridTop: '15%',
	                        legend: ["成交量"],
	                        legendShow: false,
	                        xAxis: coreBarResult.content.xAxis,
	                        series: [coreBarResult.content.series]
	                    };
	                    this.setState({ coreBarData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreTrendRequest, this.props.coreTrendResult);
	        if (!isEqualBar) {
	            var coreTrendRequest = nextProps.coreTrendRequest;
	            var coreTrendResult = nextProps.coreTrendResult;

	            if (coreTrendRequest == true) {
	                if (coreTrendResult.success) {
	                    var option = {
	                        title: "平台利率走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        symbolSize: 5,
	                        yAxisName: "",
	                        yFlag: "%", //y轴单位
	                        gridBottom: '0',
	                        gridTop: '15%',
	                        legend: ["利率"],
	                        unit: ["%", ""],
	                        legendShow: false,
	                        xAxis: coreTrendResult.content.xAxis,
	                        series: [coreTrendResult.content.series]
	                    };
	                    this.setState({ coreTrendData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreBalanceRequest, this.props.coreBalanceResult);
	        if (!isEqualBar) {
	            var coreBalanceRequest = nextProps.coreBalanceRequest;
	            var coreBalanceResult = nextProps.coreBalanceResult;

	            if (coreBalanceRequest == true) {
	                if (coreBalanceResult.success) {
	                    var option = {
	                        color: ["#00b7ee", "#f8b551"],
	                        title: "贷款余额",
	                        titleShow: true,
	                        titleX: "center",
	                        boxId: "chartMap",
	                        symbolSize: 5,
	                        legendIsShow: false,
	                        yFlag: "",
	                        unit: ["%", ""],
	                        yAxisName: "金额(亿元)",
	                        legendRight: "30",
	                        legend: ["贷款余额"],
	                        xAxis: coreBalanceResult.content.xAxis,
	                        series: [coreBalanceResult.content.series]
	                    };
	                    this.setState({ coreBalanceData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBoxBar = "",
	            chartBoxTrend = "",
	            chartBalance = "";
	        if (this.state.coreBarData) {
	            chartBoxBar = _react2.default.createElement(_BarChart2.default, { option: this.state.coreBarData, style: { height: '270px', width: '100%' } });
	        }
	        if (this.state.coreTrendData) {
	            chartBoxTrend = _react2.default.createElement(_LineChart2.default, { option: this.state.coreTrendData, style: { height: '320px', width: '100%' } });
	        }
	        if (this.state.coreBalanceData) {
	            chartBalance = _react2.default.createElement(_LineChart2.default, { option: this.state.coreBalanceData, style: { height: '320px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-b radius4 mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '核心数据'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-top' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-list' },
	                        _react2.default.createElement(
	                            'table',
	                            { className: 'mt-table wtyh-table' },
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var _amount_total = item.amount_total == undefined ? "/" : item.amount_total;
	                                    var _money_stock = item.money_stock == undefined ? "/" : item.money_stock;
	                                    var _interest_rate = item.interest_rate == undefined ? "/" : item.interest_rate;
	                                    var _month_net_inflow = item.month_net_inflow == undefined ? "/" : item.month_net_inflow;
	                                    var _bid_num_stay_stil = item.bid_num_stay_stil == undefined ? "/" : item.bid_num_stay_stil;

	                                    var _bor_num_stay_stil = item.bor_num_stay_stil == undefined ? "/" : item.bor_num_stay_stil;
	                                    var _top1_sum_amount = item.top1_sum_amount == undefined ? "/" : item.top1_sum_amount;
	                                    var _top10_sum_amount = item.top10_sum_amount == undefined ? "/" : item.top10_sum_amount;
	                                    return _react2.default.createElement(
	                                        'tbody',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '累计成交量'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _amount_total,
	                                                    '亿元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '贷款余额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _money_stock,
	                                                    '亿元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '平均利率'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _interest_rate,
	                                                    '%'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '近30日净资金流入'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _month_net_inflow,
	                                                    '万元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '待收投资人数'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _bid_num_stay_stil
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '待还借款人数'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _bor_num_stay_stil
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '最大单户借款额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _top1_sum_amount,
	                                                    '万元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '最大十户借款额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _top10_sum_amount,
	                                                    '万元'
	                                                )
	                                            )
	                                        )
	                                    );
	                                }
	                            })
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-bar' },
	                        chartBoxBar
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-bottom' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-left' },
	                        chartBoxTrend
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-right' },
	                        chartBalance
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CoreData;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "coreData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 851:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Litigation = _react2.default.createClass({
	  displayName: 'Litigation',

	  getInitialState: function getInitialState() {
	    var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	    return {
	      listData: [],
	      company: "",
	      companyVal: _selectVal
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    if (nextProps.companyData == "") {
	      return;
	    }
	    var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	    if (!isEqualCompany) {
	      var getlitigationRequest = this.props.getlitigationRequest;

	      this.setState({ company: nextProps.companyData });
	      getlitigationRequest({ "platName": this.state.companyVal });
	    }
	    var isEqual = Immutable.is(nextProps.litigationResult, this.props.litigationResult);
	    if (!isEqual) {
	      var litigationRequest = nextProps.litigationRequest;
	      var litigationResult = nextProps.litigationResult;

	      if (litigationRequest == true) {
	        if (litigationResult.success) {
	          var _setParm = [litigationResult.content];

	          this.setState({ listData: _setParm });
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  render: function render() {
	    var _companyName = this.state.company;
	    return _react2.default.createElement(
	      'div',
	      { className: 'bottom-l radius4 mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'header-gray' },
	        _react2.default.createElement(
	          'span',
	          { className: 'title' },
	          '诉讼信息'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'content' },
	        _react2.default.createElement(
	          'ul',
	          null,
	          _react2.default.createElement(
	            'li',
	            null,
	            _react2.default.createElement('span', { className: 'iconfont icon-susong skublue' })
	          ),
	          _react2.default.createElement(
	            'li',
	            null,
	            _react2.default.createElement(
	              'span',
	              { className: 'ssong-title' },
	              '诉讼信息'
	            )
	          ),
	          this.state.listData.map(function (item, index) {
	            {

	              return _react2.default.createElement(
	                'li',
	                null,
	                _react2.default.createElement(
	                  'span',
	                  { className: 'ssong-num' },
	                  _react2.default.createElement(
	                    _reactRouter.Link,
	                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'Portrait', companyName: _companyName } }, className: 'orange' },
	                    item.total
	                  )
	                )
	              );
	            }
	          })
	        )
	      )
	    );
	  }
	});

	module.exports = Litigation;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "litigation.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 853:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RankPic = _react2.default.createClass({
	    displayName: 'RankPic',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            searchVal: '',
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var getrankPicRequest = this.props.getrankPicRequest;

	            getrankPicRequest({
	                "platName": this.state.companyVal,
	                "companyName": nextProps.companyData,
	                "dataVersion": "20160530",
	                "degree": 3
	            });
	        }
	        var isEqual = Immutable.is(nextProps.rankPicResult, this.props.rankPicResult);
	        if (!isEqual) {
	            (function () {
	                var rankPicRequest = nextProps.rankPicRequest;
	                var rankPicResult = nextProps.rankPicResult;

	                if (rankPicRequest == true) {
	                    seajs.use("/relativeGraph/assets/script/main/dynamic.js", function (main) {
	                        var pointList = rankPicResult.pointList;
	                        if (pointList == null || pointList == "" || pointList == "undefined") {
	                            nodes = [];
	                        } else {
	                            nodes = [];
	                            for (var i = 0; i < pointList.length; i++) {
	                                var point = pointList[i];

	                                var symbol = "rect";
	                                if (point.isPerson == "1") {
	                                    symbol = "circle";
	                                }

	                                var color = "#FF0000";
	                                if (point.level == "1") {
	                                    color = "#0030AF";
	                                    if (point.isSonCom == "1") {
	                                        color = "#FFCA00";
	                                    }
	                                } else if (point.level == "2") {
	                                    color = "#36B3EB";
	                                } else if (point.level == "3") {
	                                    color = "#C1C1C1";
	                                } else {}

	                                nodes[i] = {
	                                    "addflag": "false",
	                                    "category": point.level,
	                                    "color": color,
	                                    "name": point.name,
	                                    "symbol": symbol,
	                                    "isGetCompany": false
	                                };
	                            }
	                        }
	                        var lineList = rankPicResult.lineList;
	                        if (lineList == null || lineList == "" || lineList == "undefined") {
	                            links = [];
	                        } else {
	                            links = [];
	                            for (var i = 0; i < lineList.length; i++) {
	                                var line = lineList[i];
	                                var lineType = "line";
	                                if (line.isFullLine == "0") {
	                                    lineType = "dotted";
	                                }
	                                links[i] = {
	                                    "addflag": "false",
	                                    "guanlian": line.type,
	                                    "line": lineType,
	                                    "relatedParyName": line.relationship,
	                                    "source": line.orig,
	                                    "target": line.target
	                                };
	                            }
	                        }

	                        main.reDrawCanvas();
	                    });
	                }
	            })();
	        }
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-rel-graph mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '企业关联方图谱'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pic_rank' },
	                    _react2.default.createElement('span', { className: 'add iconfont icon-jia', id: 'btn_bigmore' }),
	                    _react2.default.createElement('span', { className: 'sub iconfont icon-jian', id: 'btn_smaller' })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-legend' },
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
	                                    _react2.default.createElement('span', { className: 'square orange' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '目标公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/xuxianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '投资人'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange-two' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '子公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/shixianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '企业高管'
	                                    )
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement('div', { className: 'relation-modal', id: 'relation-modal' }),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'dyMapMain' },
	                        _react2.default.createElement('div', { id: 'dyMap' })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = RankPic;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "rankPic.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 869:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(870);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyNum = __webpack_require__(872);

	var _CompanyNum2 = _interopRequireDefault(_CompanyNum);

	var _CapitalAmount = __webpack_require__(875);

	var _CapitalAmount2 = _interopRequireDefault(_CapitalAmount);

	var _BusinessNum = __webpack_require__(876);

	var _BusinessNum2 = _interopRequireDefault(_BusinessNum);

	var _Income = __webpack_require__(877);

	var _Income2 = _interopRequireDefault(_Income);

	var _CompanyDirectory = __webpack_require__(878);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _PawnMonitoringAction = __webpack_require__(879);

	var PawnMonitoringActionCreaters = _interopRequireWildcard(_PawnMonitoringAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//典当总收入

	//注册资本总额


	var Immutable = __webpack_require__(718);
	//众筹监测
	//上海市企业典当目录
	//业务笔数
	//典当法人企业数
	var PawnMonitoring = _react2.default.createClass({
	    displayName: 'PawnMonitoring',

	    getInitialState: function getInitialState() {
	        return {
	            lineData: [],
	            doubleBarData: [],
	            scatterData: [],
	            barData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getChartAllRequest = this.props.getChartAllRequest;

	        var jsonData = {};
	        getChartAllRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.chartAllRequest, this.props.chartAllResult);
	        if (!isEqual) {
	            var chartAllRequest = nextProps.chartAllRequest;
	            var chartAllResult = nextProps.chartAllResult;

	            if (chartAllRequest == true) {
	                if (chartAllResult.success) {

	                    /*"year": 2015,
	                     "companyNumber": 256,
	                     "balance": 645711,//典当余额（万元
	                     "registerCapital": 637096,//注册资本（万元）
	                     "totalIncome": 103078,//总费收入（万元）
	                     "totalAmout": 4664405,//典当金额（万元）
	                     "number": 351148//典当笔数*/

	                    var _xAxisData = [],
	                        _companyNumber = [],
	                        _balance = [],
	                        _registerCapital = [],
	                        _totalIncome = [],
	                        _totalAmout = [],
	                        _number = [];
	                    for (var item in chartAllResult.content) {
	                        _xAxisData.push(chartAllResult.content[item].year); //年份
	                        _companyNumber.push(chartAllResult.content[item].companyNumber);

	                        _balance.push(Number(chartAllResult.content[item].balance / 10000).toFixed(2));
	                        _registerCapital.push(Number(chartAllResult.content[item].registerCapital / 10000).toFixed(2));
	                        _totalIncome.push(Number(chartAllResult.content[item].totalIncome / 10000).toFixed(2));
	                        _totalAmout.push(Number(chartAllResult.content[item].totalAmout / 10000).toFixed(2));
	                        _number.push(chartAllResult.content[item].number);
	                    }

	                    var _setLineData = {
	                        "xAxisData": _xAxisData,
	                        "data": _companyNumber
	                    };

	                    var _doubleBarData = {
	                        "xAxisData": _xAxisData,
	                        "data": [_balance, _registerCapital]
	                    };

	                    var _scatterData = {
	                        "xAxisData": _xAxisData,
	                        "yAxisData": _totalAmout.sort(function (a, b) {
	                            return a - b;
	                        }),
	                        "data": _number
	                    };

	                    var _barData = {
	                        "xAxisData": _xAxisData,
	                        "data": _totalIncome
	                    };
	                    this.setState({ lineData: _setLineData });
	                    this.setState({ doubleBarData: _doubleBarData });
	                    this.setState({ scatterData: _scatterData });
	                    this.setState({ barData: _barData });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'pawnMonitoring-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '典当行业监测', searchFun: this.handleFunction, companyType: '12', placeholder: '请输入企业名称检索' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-top clearfix' },
	                    _react2.default.createElement(_CompanyNum2.default, { Data: this.state.lineData }),
	                    _react2.default.createElement(_CapitalAmount2.default, { Data: this.state.doubleBarData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-Middle clearfix' },
	                    _react2.default.createElement(_BusinessNum2.default, { Data: this.state.scatterData }),
	                    _react2.default.createElement(_Income2.default, { Data: this.state.barData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-bottom' },
	                    _react2.default.createElement(_CompanyDirectory2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = PawnMonitoring;
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        chartAllRequest: state.PawnMChartAll.request,
	        chartAllResult: state.PawnMChartAll.result,

	        companyDirRequest: state.CompanyDirectory.request,
	        companyDirResult: state.CompanyDirectory.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(PawnMonitoringActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(PawnMonitoring);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 878:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(873);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',


	    getInitialState: function getInitialState() {
	        return {
	            listData: [],
	            orderZB: "desc", //排序方式
	            orderName: "" //排序字段
	        };
	    },
	    countyChange: function countyChange(orderType, orderName) {
	        var getcompanyDirRequest = this.props.getcompanyDirRequest;

	        var jsonData = {
	            descAsc: orderType, //desc:降序 asc:升序
	            orderByField: orderName //列表排序
	        };
	        getcompanyDirRequest(jsonData);
	    },
	    handleClick: function handleClick(field, type) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderName: type, orderZB: _dom.attr("data-order") }, function () {
	            this.countyChange(this.state.orderZB, this.state.orderName);
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ orderName: "" });
	        this.setState({ orderZB: "desc" });
	        this.countyChange(this.state.orderZB, this.state.orderName);
	        $('#companyDirectory-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#companyDirectory-scroll').perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyDirResult, this.props.companyDirResult);
	        if (!isEqual) {
	            var companyDirRequest = nextProps.companyDirRequest;
	            var companyDirResult = nextProps.companyDirResult;

	            if (companyDirRequest == true) {
	                if (companyDirResult.success) {
	                    $(this.refs.totleCount).html(companyDirResult.content.length);
	                    this.setState({ listData: companyDirResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市典当企业目录'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'totle-num' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'orange', ref: 'totleCount' },
	                        '  '
	                    ),
	                    '家企业'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-title' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '5%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '典当行名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%' },
	                                    '法人代表'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'cur-pointer', 'data-order': this.state.orderZB, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital", "1") },
	                                    '注册资本',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%', className: 'cur-pointer', 'data-order': this.state.orderZB, ref: 'registeredDate', onClick: this.handleClick.bind(this, "registeredDate", "2") },
	                                    '注册时间',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'companyDirectory-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _legalPerson = item.legalPerson == null ? "/" : item.legalPerson;
	                                    var _address = item.address == null ? "/" : item.address;
	                                    var _registeredCapital = item.registeredCapital == null ? "/" : item.registeredCapital;
	                                    var _registeredTime = item.registeredTime == null ? "/" : item.registeredTime;
	                                    var _danwei = item.registeredCapitalType == 1 ? "万人民币" : "万美元";
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '5%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } } },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _legalPerson
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _address
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _registeredCapital,
	                                                _danwei
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                _registeredTime
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '5%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } } },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _legalPerson
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _address
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _registeredCapital,
	                                                _danwei
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                _registeredTime
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CompanyDirectory;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDirectory.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 890:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(891);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _financeLeaseAction = __webpack_require__(893);

	var CommercialSecretIndexActionCreaters = _interopRequireWildcard(_financeLeaseAction);

	var _Lease = __webpack_require__(894);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _Balance = __webpack_require__(897);

	var _Balance2 = _interopRequireDefault(_Balance);

	var _ContrastLeft = __webpack_require__(898);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(899);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Unhealthy = __webpack_require__(900);

	var _Unhealthy2 = _interopRequireDefault(_Unhealthy);

	var _Catalog = __webpack_require__(901);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//子模块引入


	var Immutable = __webpack_require__(718);
	//融资租赁
	var FinanceLease = _react2.default.createClass({
	  displayName: 'FinanceLease',

	  mixins: [_setHeight2.default],
	  hrefFunction: function hrefFunction(searchVal) {
	    //console.log(searchVal,"================搜索词语============================");
	    this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'finance-list-index', searchFun: this.hrefFunction, style: this.state.style },
	      _react2.default.createElement(_IndustrySearch2.default, { label: '融资租赁监测', companyType: '13', searchFun: this.hrefFunction, placeholder: '请输入企业名称检索' }),
	      _react2.default.createElement(
	        'div',
	        { className: 'FinanceLeaseBottom' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(_Lease2.default, this.props),
	          _react2.default.createElement(_Balance2.default, null)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(_ContrastLeft2.default, this.props),
	          _react2.default.createElement(_ContrastRight2.default, this.props),
	          _react2.default.createElement(_Unhealthy2.default, null)
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'FinanceLeaseTop' },
	        _react2.default.createElement(_Catalog2.default, this.props)
	      )
	    );
	  }
	});
	//module.exports = FinanceLease;
	//将 request  result 绑定到props的request result
	function CommercialSecretStateToProps(state) {
	  return {
	    //总额
	    LeaseNumChartRequest: state.Lease.request,
	    LeaseNumChartResult: state.Lease.result,
	    //对比左图
	    ContrastLeftNumChartRequest: state.ContrastLeft.request,
	    ContrastLeftNumChartResult: state.ContrastLeft.result,
	    //对比右图
	    ContrastRightNumChartRequest: state.ContrastRight.request,
	    ContrastRightNumChartResult: state.ContrastRight.result,
	    //列表
	    ContrastCatalogNumChartRequest: state.Catalog.request,
	    ContrastCatalogNumChartResult: state.Catalog.result,
	    //下拉框
	    CatalogSelectNumChartRequest: state.CatalogSelect.request,
	    CatalogSelectNumChartResult: state.CatalogSelect.result,
	    //饼图时间选择下拉框
	    TimeSelectNumChartRequest: state.TimeSelect.request,
	    TimeSelectNumChartResult: state.TimeSelect.result
	  };
	}

	//将action的所有方法绑定到props上
	function CommercialSecretDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(CommercialSecretIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(CommercialSecretStateToProps, CommercialSecretDispatchToProps)(FinanceLease);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 901:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//融资租赁企业目录
	var Immutable = __webpack_require__(718);
	var innerdata = [];
	var outerdata = [];
	var Catalog = _react2.default.createClass({
	    displayName: 'Catalog',

	    getInitialState: function getInitialState() {
	        return {
	            CatalogCentent: [],
	            CompanyDirectoryData: [],
	            CatalogDirectoryData: [],
	            CatalogSelect: [],
	            CatalogAdd: []
	        };
	    },
	    //初始
	    componentDidMount: function componentDidMount() {
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        var jsonData = { 'areaName': '黄浦区' };
	        getContrastCatalognumRequest(jsonData);

	        var getSelectRequest = this.props.getSelectRequest;

	        var jsonData = { 'areaId': 104 };
	        getSelectRequest(jsonData);

	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //下拉框
	        var isEqual = Immutable.is(nextProps.CatalogSelectNumChartRequest, this.props.CatalogSelectNumChartResult);
	        if (!isEqual) {
	            var CatalogSelectNumChartRequest = nextProps.CatalogSelectNumChartRequest;
	            var CatalogSelectNumChartResult = nextProps.CatalogSelectNumChartResult;

	            if (CatalogSelectNumChartRequest == true) {
	                if (CatalogSelectNumChartResult.success) {
	                    this.dataCatalogSelect(CatalogSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        //列表
	        var isEqual = Immutable.is(nextProps.ContrastCatalogNumChartRequest, this.props.ContrastCatalogNumChartResult);
	        if (!isEqual) {
	            var ContrastCatalogNumChartRequest = nextProps.ContrastCatalogNumChartRequest;
	            var ContrastCatalogNumChartResult = nextProps.ContrastCatalogNumChartResult;

	            if (ContrastCatalogNumChartRequest == true) {
	                if (ContrastCatalogNumChartResult.success) {
	                    this.dataFomat(ContrastCatalogNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    //列表
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ CatalogCentent: content });
	    },
	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("qqqqqqqqqqqqqqqqqqqqqq",selectVar)
	        this.setState({ CatalogSelect: selectVar });
	    },
	    //风险状态判断
	    quarterChoice: function quarterChoice(value) {
	        var areaName = $("#indexSelected").find('.mt-select-title').text();
	        var analysisResult = $("#indexSelectedFeng").attr('data-val');
	        var riskA = $("#indexSelectedShi").attr('data-val');
	        var riskB = $("#indexSelectedWei").attr('data-val');
	        var riskC = $("#indexSelectedAdd").attr('data-val');
	        var riskD = $("#indexSelectedBtt").attr('data-val');
	        var areaNameData = { 'areaName': areaName, 'analysisResult': analysisResult, "riskA": riskA, "riskB": riskB, "riskC": riskC, "riskD": riskD };
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        getContrastCatalognumRequest(areaNameData);
	        //console.info("jifei++++",areaNameData)
	    },
	    render: function render() {
	        //下拉选择列表头         
	        var selectProp = {
	            width: '110px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '黄浦区',
	            name: 'testselect',
	            data: this.state.CatalogSelect,
	            onChange: function (value, label) {
	                this.quarterChoice(label);
	            }.bind(this)
	        };
	        //下拉选择风险状态
	        var selectPropL = {
	            width: '55px',
	            className: 'index-selected',
	            value: '',
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: '', label: '全部' }, { value: 0, label: '正常' }, { value: 1, label: '潜在' }],
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);         
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        //下拉选择全部
	        var selectProps = {
	            width: '55px',
	            className: 'index-selected',
	            value: '',
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: '', label: '全部' }, { value: 1, label: '是' }],
	            onChange: function (value, label) {
	                console.log('当前值为：', value);
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'Catalog mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市融资租赁企业目录'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'total' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { ref: 'totleCount' },
	                        this.state.CatalogCentent.length
	                    ),
	                    '家企业'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'right' },
	                    _react2.default.createElement(
	                        'em',
	                        null,
	                        '地区筛选'
	                    ),
	                    _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelected' }))
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'tabs' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'wtyh-table table-border-b' },
	                    _react2.default.createElement(
	                        'thead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width1' },
	                                '序号'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width2' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '公司名称'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width3' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '注册地址'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width4' },
	                                '风险状态',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectPropL, { id: 'indexSelectedFeng' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { colSpan: '4', className: 'width5' },
	                                '潜在风险'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '失联',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedShi' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '未参加自查',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedWei' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上零认缴',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedAdd' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上未经营',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedBtt' }))
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box', id: 'platformBase-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.CatalogCentent.map(function (item, index) {
	                                var Green = '';
	                                item.riskStatus == "正常" ? Green = 'Green' : Green = 'Yellow';
	                                var riskStatusA = item.riskStatusA == null ? "—" : item.riskStatusA;
	                                var riskStatusB = item.riskStatusB == null ? "—" : item.riskStatusB;
	                                var riskStatusC = item.riskStatusC == null ? "—" : item.riskStatusC;
	                                var riskStatusD = item.riskStatusD == null ? "—" : item.riskStatusD;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: item.companyName } }, className: 'word-limit-5 leftD', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD', title: item.address },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: item.companyName } }, className: 'word-limit-5 leftD', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD', title: item.address },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
	                                        )
	                                    );
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = Catalog;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Catalog.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 913:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(914);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _prepaidCardAction = __webpack_require__(916);

	var PrepaidCardActionCreaters = _interopRequireWildcard(_prepaidCardAction);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _TotleMoney = __webpack_require__(917);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _IndustryType = __webpack_require__(920);

	var _IndustryType2 = _interopRequireDefault(_IndustryType);

	var _MsgNotice = __webpack_require__(921);

	var _MsgNotice2 = _interopRequireDefault(_MsgNotice);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//备案企业信息公告

	//备案企业预付金额总额
	var Immutable = __webpack_require__(718);
	//支付卡
	//备案企业行业类型

	var PrepaidCard = _react2.default.createClass({
	    displayName: 'PrepaidCard',

	    mixins: [_setHeight2.default],
	    getInitialState: function getInitialState() {
	        return {
	            prepaidData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getIndustryTypeRequest = this.props.getIndustryTypeRequest;

	        var jsonData = {};
	        getIndustryTypeRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.PrepaidRequest, this.props.PrepaidResult);
	        if (!isEqual) {
	            var PrepaidRequest = nextProps.PrepaidRequest;
	            var PrepaidResult = nextProps.PrepaidResult;

	            if (PrepaidRequest == true) {
	                if (PrepaidResult.success) {
	                    this.setState({ prepaidData: PrepaidResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    hrefFunction: function hrefFunction(searchVal) {
	        //console.log(searchVal,"================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'prepaidC-index', searchFun: this.hrefFunction, style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '单用途预付卡备案企业监测', companyType: '11', searchFun: this.hrefFunction, placeholder: '请输入企业名称检索' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-top clearfix' },
	                    _react2.default.createElement(_IndustryType2.default, { industryTypeData: this.state.prepaidData }),
	                    _react2.default.createElement(_TotleMoney2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-bottom' },
	                    _react2.default.createElement(_MsgNotice2.default, { msgNoticeData: this.state.prepaidData })
	                )
	            )
	        );
	    }
	});
	//module.exports = PrepaidCard;

	//将 request  result 绑定到props的request result
	function PrepaidCardStateToProps(state) {
	    return {

	        PrepaidRequest: state.industryTypeChart.request,
	        PrepaidResult: state.industryTypeChart.result,

	        TotleMoneyRequest: state.TotleMoney.request,
	        TotleMoneyResult: state.TotleMoney.result

	    };
	}

	//将action的所有方法绑定到props上
	function PrepaidCardDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(PrepaidCardActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(PrepaidCardStateToProps, PrepaidCardDispatchToProps)(PrepaidCard);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 917:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(918);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CapitalAmount = _react2.default.createClass({
		displayName: 'CapitalAmount',
		getInitialState: function getInitialState() {
			return {
				totleMoneyOption: null
			};
		},

		setParm: function setParm(data) {
			var options = {
				title: "平台交易量走势",
				titleX: "center",
				color: ["#e14340", "#12b5b0"],
				barWidth: 30,
				yAxisName: "金额(亿元)",
				xAxisName: "企业数量",
				yFlag: "", //y轴单位
				splitLineShow: false,
				legend: ["企业预付金额总额"],
				legendShow: false,
				label: {
					normal: {
						show: true,
						position: 'top',
						textStyle: {
							color: "#fff",
							fontSize: 12,
							fontWeight: "normal",
							fontFamily: 'Microsoft Yahei'
						}
					}
				},
				gridTop: "10%",
				gridBottom: "5%",
				gridLeft: "5%",
				gridRight: "11%",
				xAxis: data.xAxis,
				series: [data.series]
			};
			this.setState({ totleMoneyOption: options });
		},
		componentDidMount: function componentDidMount() {
			var getTotleMoneyRequest = this.props.getTotleMoneyRequest;

			var jsonData = {};
			getTotleMoneyRequest(jsonData);
		},

		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.TotleMoneyRequest, this.props.TotleMoneyResult);
			if (!isEqual) {
				var TotleMoneyRequest = nextProps.TotleMoneyRequest;
				var TotleMoneyResult = nextProps.TotleMoneyResult;

				if (TotleMoneyRequest == true) {
					if (TotleMoneyResult.success) {
						this.setParm(TotleMoneyResult.content);
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var totleMoneyBox = "";
			if (this.state.totleMoneyOption) {
				totleMoneyBox = _react2.default.createElement(_BarChart2.default, {
					option: this.state.totleMoneyOption,
					style: { height: '465px', width: '100%', margin: '0px auto' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'mod top-right radius4' },
				_react2.default.createElement(
					'div',
					{ className: 'mod-title' },
					_react2.default.createElement(
						'h3',
						null,
						'备案企业预付金额总额'
					)
				),
				totleMoneyBox
			);
		}
	});

	module.exports = CapitalAmount;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TotleMoney.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 919:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".prepaidC-index .right-bottom tbody td,\r\n.prepaidC-index .right-bottom thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.prepaidC-index  .mt-table {\r\n\tmargin: 0px;\r\n}\r\n\r\n.prepaidC-index  .mt-table tr td a {\r\n\tcolor: #fff;\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-content {\r\n\theight: 500px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.prepaidC-index .right-bottom  .mod-content {\r\n\tpadding: 10px 20px 20px 20px;\r\n}\r\n\r\n/*.prepaidC-index .right-bottom .table-content  table {\r\n\theight: 100%\r\n}*/\r\n.prepaidC-index .right-bottom .table-content  table tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-title th {\r\n\theight: 50px\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-content  .mt-table td {\r\n\theight: 50px;\r\n}\r\n\r\n.prepaidC-index .right-bottom  .mod-title .totle-num {\r\n\tfont-size: 14px;\r\n\tcolor: #fff;\r\n\tfloat: right;\r\n\tdisplay: inline-block;\r\n\tmargin: 15px 20px 0px 0px;\r\n}\r\n\r\n.mt-select .company-dire {\r\n\tbackground: #393a48;\r\n\tborder: 1px #393a48 solid;\r\n\tmargin-left: 5px;\r\n}\r\n\r\n.prepaidC-index .orange {\r\n\tcolor: #3aec8e;\r\n}\r\n\r\n.prepaidC-index .yellows {\r\n\tcolor: #fcae03;\r\n}\r\n\r\n.prepaidC-index .reds {\r\n\tcolor: #e14340;\r\n}\r\n.prepaidC-index .oranges{\r\n\tcolor: #e0433c;\r\n}\r\n.prepaidC-index .statu-yellow {\r\n\tcolor: #feac00\r\n}\r\n\r\n.prepaidC-index .statu-green {\r\n\tcolor: #33da82\r\n}\r\n\r\n.prepaidC-index .BZ-num {\r\n\tfloat: right;\r\n\tmargin: 10px 20px 0px 0px;\r\n}\r\n\r\n.prepaidC-index .BZ-num .orange {\r\n\tfont-size: 16px;\r\n}", ""]);

	// exports


/***/ },

/***/ 920:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(918);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var BusinessNum = _react2.default.createClass({
	    displayName: 'BusinessNum',
	    getInitialState: function getInitialState() {
	        return {
	            industryTypeOption: null,
	            sum: 0

	        };
	    },

	    setParm: function setParm(data) {
	        var seriesData = [];
	        for (var i = 0; i < data.legend.length; i++) {
	            seriesData.push({ "name": data.legend[i], "value": data.series[i] });
	        }
	        var options = {
	            "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	            "title": "",
	            "xtitle": "",
	            "legend": [""],
	            "legendShow": false,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "20%",
	            "seriesName": "企业数",
	            "radius": ["50%", "70%"],
	            "lable": {
	                normal: { show: true },
	                emphasis: { show: false }
	            },
	            "center": ['40%', '50%'],
	            "series": seriesData
	        };
	        this.setState({
	            industryTypeOption: options
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.industryTypeData, this.props.industryTypeData);
	        if (!isEqual) {
	            var industryTypeData = nextProps.industryTypeData;

	            this.setState({
	                sum: industryTypeData.companys.length
	            });
	            this.setParm(industryTypeData.pie);
	        }
	    },
	    render: function render() {
	        var industryTypeBox = "";
	        if (this.state.industryTypeOption) {
	            industryTypeBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.industryTypeOption,
	                style: { height: '465px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-left radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '备案企业行业类型'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'BZ-num' },
	                    '备案企业：',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'oranges' },
	                        this.state.sum
	                    ),
	                    ' 家'
	                )
	            ),
	            industryTypeBox
	        );
	    }
	});

	module.exports = BusinessNum;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryType.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 921:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(918);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var msgNoticeDatas;
	var finalData = {
	    normal: [],
	    occurred: [],
	    potential: []
	};
	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',

	    componentDidMount: function componentDidMount() {
	        //滚动条
	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    //滚动条
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update').scrollTop(0);
	    },
	    getInitialState: function getInitialState() {
	        return {
	            msgNoticeDataS: []
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.msgNoticeData, this.props.msgNoticeData);
	        if (!isEqual) {
	            var msgNoticeData = nextProps.msgNoticeData;

	            for (var i = 0; i < msgNoticeData.companys.length; i++) {
	                if (msgNoticeData.companys[i].analysisResultCN == "正常") {
	                    finalData.normal.push(msgNoticeData.companys[i]);
	                } else if (msgNoticeData.companys[i].analysisResultCN == "已发生") {
	                    finalData.occurred.push(msgNoticeData.companys[i]);
	                } else {
	                    finalData.potential.push(msgNoticeData.companys[i]);
	                }
	            }
	            msgNoticeDatas = msgNoticeData.companys;
	            this.setState({
	                msgNoticeDataS: msgNoticeData.companys
	            });
	        }
	    },

	    quarterChoice: function quarterChoice(value) {
	        switch (value) {
	            case 2:
	                //正常
	                this.setState({
	                    msgNoticeDataS: finalData.normal
	                });
	                break;
	            case 3:
	                //已发生
	                this.setState({
	                    msgNoticeDataS: finalData.occurred
	                });
	                break;
	            case 4:
	                //潜在
	                this.setState({
	                    msgNoticeDataS: finalData.potential
	                });
	                break;
	            default:
	                this.setState({
	                    msgNoticeDataS: msgNoticeDatas
	                });
	                break;
	        }
	    },
	    render: function render() {
	        var selectQuarter = {
	            width: '75px',
	            className: 'company-dire',
	            name: 'testselect',
	            value: "1",
	            id: 'selectType',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '正常' }, { value: '3', label: '已发生' }, { value: '4', label: '潜在' }],
	            onChange: function (value, label) {
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '备案企业信息公告'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'totle-num' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'oranges' },
	                        ' ',
	                        this.state.msgNoticeDataS.length,
	                        ' '
	                    ),
	                    '家企业'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-title' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '备案号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '单位'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '所属行业'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '风险状态',
	                                    _react2.default.createElement(_index.Selected, selectQuarter)
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'platformBase-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.msgNoticeDataS.map(function (ele, index) {
	                                var orange = '';
	                                if (ele.analysisResultCN == "正常") {
	                                    orange = 'orange';
	                                } else if (ele.analysisResultCN == "潜在") {
	                                    orange = 'yellows';
	                                } else {
	                                    orange = 'reds';
	                                }
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index, className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '10%', className: 'talign-center' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            ele.recordNumber
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: ele.companyName } }, className: 'word-limit-5', 'data-tip': ele.companyName, title: ele.companyName },
	                                                ele.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            ele.businessType
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: orange },
	                                                ele.analysisResultCN
	                                            )
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index, className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '10%', className: 'talign-center' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            ele.recordNumber
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: ele.companyName } }, className: 'word-limit-5', 'data-tip': ele.companyName, title: ele.companyName },
	                                                ele.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            ele.businessType
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: orange },
	                                                ele.analysisResultCN
	                                            )
	                                        )
	                                    );
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CompanyDirectory;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MsgNotice.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 986:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _companyInfoTitRuducer = __webpack_require__(987);

	var _companyInfoTitRuducer2 = _interopRequireDefault(_companyInfoTitRuducer);

	var _companyInfoNewsRuducer = __webpack_require__(988);

	var _companyInfoNewsRuducer2 = _interopRequireDefault(_companyInfoNewsRuducer);

	var _companyInfoARuducer = __webpack_require__(989);

	var _companyInfoARuducer2 = _interopRequireDefault(_companyInfoARuducer);

	var _companyInfoBRuducer = __webpack_require__(990);

	var _companyInfoBRuducer2 = _interopRequireDefault(_companyInfoBRuducer);

	var _companyPic = __webpack_require__(991);

	var _companyPic2 = _interopRequireDefault(_companyPic);

	var _companyInfoC1Ruducer = __webpack_require__(992);

	var _companyInfoC1Ruducer2 = _interopRequireDefault(_companyInfoC1Ruducer);

	var _companyInfoC2Ruducer = __webpack_require__(993);

	var _companyInfoC2Ruducer2 = _interopRequireDefault(_companyInfoC2Ruducer);

	var _companyInfoC3Ruducer = __webpack_require__(994);

	var _companyInfoC3Ruducer2 = _interopRequireDefault(_companyInfoC3Ruducer);

	var _companyInfoC4Ruducer = __webpack_require__(995);

	var _companyInfoC4Ruducer2 = _interopRequireDefault(_companyInfoC4Ruducer);

	var _companyInfoC5Ruducer = __webpack_require__(996);

	var _companyInfoC5Ruducer2 = _interopRequireDefault(_companyInfoC5Ruducer);

	var _companyInfoD1Ruducer = __webpack_require__(997);

	var _companyInfoD1Ruducer2 = _interopRequireDefault(_companyInfoD1Ruducer);

	var _companyInfoD2Ruducer = __webpack_require__(998);

	var _companyInfoD2Ruducer2 = _interopRequireDefault(_companyInfoD2Ruducer);

	var _companyInfoD3Ruducer = __webpack_require__(999);

	var _companyInfoD3Ruducer2 = _interopRequireDefault(_companyInfoD3Ruducer);

	var _Common = __webpack_require__(1000);

	var _Common2 = _interopRequireDefault(_Common);

	var _SmallLoanMap = __webpack_require__(1001);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(1002);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(1003);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(1004);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _IndustryRiskDetail = __webpack_require__(1396);

	var _IndustryRiskDetail2 = _interopRequireDefault(_IndustryRiskDetail);

	var _LargeLoan = __webpack_require__(1005);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(1006);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(1007);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(1008);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(1009);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _FinGuaIndustryRiskDetail = __webpack_require__(1397);

	var _FinGuaIndustryRiskDetail2 = _interopRequireDefault(_FinGuaIndustryRiskDetail);

	var _LargeGuara = __webpack_require__(1010);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(1011);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1012);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(1013);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(1014);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1015);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1016);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1017);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1018);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1019);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(1020);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1021);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1022);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1023);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyName = __webpack_require__(1024);

	var _CompanyName2 = _interopRequireDefault(_CompanyName);

	var _CompanyProgress = __webpack_require__(1025);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1026);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1027);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1028);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1029);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1030);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1031);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1032);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1033);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1034);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1035);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1036);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1037);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1038);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1039);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1040);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1041);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1042);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1043);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1044);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1045);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1046);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1047);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1048);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1049);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _CatalogSelect = __webpack_require__(1050);

	var _CatalogSelect2 = _interopRequireDefault(_CatalogSelect);

	var _TimeSelect = __webpack_require__(1051);

	var _TimeSelect2 = _interopRequireDefault(_TimeSelect);

	var _realtimeTableRuducer = __webpack_require__(1052);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1053);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1054);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1055);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1056);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _realtimeRiskReducer = __webpack_require__(1057);

	var _realtimeRiskReducer2 = _interopRequireDefault(_realtimeRiskReducer);

	var _MenuParkSelectVal = __webpack_require__(1058);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1059);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1060);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1061);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1062);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1063);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ParkImg = __webpack_require__(1064);

	var _ParkImg2 = _interopRequireDefault(_ParkImg);

	var _BuildCompanyList = __webpack_require__(1065);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1066);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1067);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1068);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1069);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1070);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _BuildSwitchVal = __webpack_require__(1071);

	var _BuildSwitchVal2 = _interopRequireDefault(_BuildSwitchVal);

	var _ChartAll3 = __webpack_require__(1072);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1073);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1074);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1075);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1076);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1077);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1078);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1079);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1081);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1082);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1083);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1084);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1085);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1086);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _QueryCompanyInfo = __webpack_require__(1398);

	var _QueryCompanyInfo2 = _interopRequireDefault(_QueryCompanyInfo);

	var _DynamicRiskCompanyTag = __webpack_require__(1087);

	var _DynamicRiskCompanyTag2 = _interopRequireDefault(_DynamicRiskCompanyTag);

	var _DynamicRiskDate = __webpack_require__(1088);

	var _DynamicRiskDate2 = _interopRequireDefault(_DynamicRiskDate);

	var _DynamicRiskLeftImg = __webpack_require__(1089);

	var _DynamicRiskLeftImg2 = _interopRequireDefault(_DynamicRiskLeftImg);

	var _DynamicRiskRightImg = __webpack_require__(1090);

	var _DynamicRiskRightImg2 = _interopRequireDefault(_DynamicRiskRightImg);

	var _DynamicRiskIndexCmp = __webpack_require__(1091);

	var _DynamicRiskIndexCmp2 = _interopRequireDefault(_DynamicRiskIndexCmp);

	var _SelectDate = __webpack_require__(1092);

	var _SelectDate2 = _interopRequireDefault(_SelectDate);

	var _RiskSearch = __webpack_require__(1093);

	var _RiskSearch2 = _interopRequireDefault(_RiskSearch);

	var _industryTypeChart = __webpack_require__(1094);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1095);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1096);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1097);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/


	/*线下理财监测 end*/

	/*预付卡 begin*/

	/*商业保理监测 end*/

	/*线下理财监测 start*/
	//线下理财首页


	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//园区首页

	/*实时监测 end*/

	//园区

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

	//动态图谱

	//诉讼信息

	//核心数据

	/*====================================P2P平台监测============================*/

	/*====================================p2p画像平台============================*/
	//基本信息

	//网贷平台数据展示


	/*企业全息查询*/

	/*行业监测模块*/
	/* 公共搜索 */

	//诉讼记录的五个接口
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
	  CompanyPic: _companyPic2.default,

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
	  CompanyName: _CompanyName2.default,

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
	  IndustryRiskDetail: _IndustryRiskDetail2.default,
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
	  FinGuaIndustryRiskDetail: _FinGuaIndustryRiskDetail2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,
	  RealTimeNews: _realtimeNewsReducer2.default,
	  RealTimeMap: _realtimeMapReducer2.default,
	  RealTimeMapSh: _realtimeMapShReducer2.default,
	  RealTimeRisk: _realtimeRiskReducer2.default,

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
	  QueryCompanyInfo: _QueryCompanyInfo2.default,
	  //动态风险
	  DynamicRiskCompanyTag: _DynamicRiskCompanyTag2.default,
	  DynamicRiskDate: _DynamicRiskDate2.default,
	  DynamicRiskLeftImg: _DynamicRiskLeftImg2.default,
	  DynamicRiskRightImg: _DynamicRiskRightImg2.default,
	  DynamicRiskIndexCmp: _DynamicRiskIndexCmp2.default,
	  SelectDate: _SelectDate2.default,
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


	//楼宇详情页

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

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名


	//融资担保

	//小额贷款

	//三个echarts图的接口


	/*企业全息查询*/

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1398:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = queryCompanyInfo;

	var _LineFinanceStaticRiskAction = __webpack_require__(761);

	function queryCompanyInfo() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceStaticRiskAction.COMPANY_INFO_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceStaticRiskAction.COMPANY_INFO_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "QueryCompanyInfo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})