webpackHotUpdate(0,{

/***/ 691:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(686);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(243);

	var _index = __webpack_require__(692);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _MenuParkAction = __webpack_require__(1304);

	var MenuParkActionCreaters = _interopRequireWildcard(_MenuParkAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	var Menu = _react2.default.createClass({
	  displayName: 'Menu',

	  getInitialState: function getInitialState() {
	    return {
	      subNav: false,
	      value: '',
	      selectDataArr: []
	    };
	  },
	  componentWillMount: function componentWillMount() {
	    this.getMenuParkSelectList();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.menuParkSelectListRequest, this.props.menuParkSelectListResult); //判断数据是否变化
	    if (!isEqual) {
	      var menuParkSelectListRequest = nextProps.menuParkSelectListRequest;
	      var menuParkSelectListResult = nextProps.menuParkSelectListResult;

	      if (menuParkSelectListRequest == true) {
	        if (menuParkSelectListResult.success == true) {
	          this.dataFomat(menuParkSelectListResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content;
	    var len = content.length;
	    var selectArr = [];
	    for (var i = 0; i < len; i++) {
	      selectArr.push({ value: content[i].areaId, label: content[i].name });
	    }
	    this.getMenuParkSelectVal(selectArr[0].value, selectArr[0].name);
	    this.setState({ selectDataArr: selectArr, value: selectArr[0].value });
	  },
	  getMenuParkSelectList: function getMenuParkSelectList(data) {
	    var getMenuParkSelectList = this.props.getMenuParkSelectList;

	    getMenuParkSelectList();
	  },
	  getMenuParkSelectVal: function getMenuParkSelectVal(areaId, name) {
	    var getMenuParkSelectVal = this.props.getMenuParkSelectVal;

	    var data = { areaId: areaId, name: name };
	    getMenuParkSelectVal(data);
	  },
	  menuSlide: function menuSlide(e) {
	    var $this = $(e.target);
	    var text = $this.text();
	    if (text != '行业监测平台') {
	      this.setState({ subNav: false });
	    } else {
	      var isTrue = this.state.subNav;
	      console.log(isTrue);
	      if (!isTrue) {
	        this.setState({ subNav: true });
	      } else {
	        this.setState({ subNav: false });
	      }
	    }
	  },
	  subMenu: function subMenu(e) {
	    this.setState({ subNav: false });
	  },

	  render: function render() {
	    var select = null;
	    if (this.state.value) {
	      var selectProp = {
	        width: '160px',
	        className: 'index-selected',
	        value: this.state.value,
	        placeholder: '',
	        name: 'testselect',
	        id: 'indexSelected',
	        data: this.state.selectDataArr,
	        onChange: function (areaId, name) {
	          console.log(areaId, name);
	          this.getMenuParkSelectVal(areaId, name);
	        }.bind(this)
	      };
	      select = _react2.default.createElement(_index.Selected, selectProp);
	    }
	    var navActive = false;
	    var routPath = this.props.location.pathname;
	    if (routPath == '/P2P' || routPath == '/lineFinance' || routPath == '/smallLoan' || routPath == '/financeGuara' || routPath == '/privateFund') {
	      navActive = true;
	    } else {
	      navActive = false;
	    }

	    return _react2.default.createElement(
	      'div',
	      { className: 'menu' },
	      _react2.default.createElement(
	        'ul',
	        { className: 'nav' },
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;', className: navActive ? 'active' : '', onClick: this.menuSlide },
	            '行业监测平台'
	          ),
	          _react2.default.createElement(
	            'ul',
	            { className: this.state.subNav ? 'sub-nav show' : 'sub-nav hide' },
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/P2P', onClick: this.subMenu },
	                'P2P'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/lineFinance', onClick: this.subMenu },
	                '线下理财'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/smallLoan', onClick: this.subMenu },
	                '小额贷款'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/financeGuara', onClick: this.subMenu },
	                '融资担保'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/privateFund', onClick: this.subMenu },
	                '私募基金'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/TradingPlaces', onClick: this.subMenu },
	                '交易场所'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/RaiseIndex', onClick: this.subMenu },
	                '众筹监测'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/PawnMonitoring', onClick: this.subMenu },
	                '典当行业监测'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/financeLease', onClick: this.subMenu },
	                '融资租赁'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/commercialSecret', onClick: this.subMenu },
	                '商业保理'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/prepaidCard', onClick: this.subMenu },
	                '预付卡'
	              )
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/parkMonitor', onClick: this.menuSlide },
	            '园区监测平台'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/InfoSearchIndex', onClick: this.menuSlide },
	            '企业全息信息查询平台'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/realtimeMonitor', onClick: this.menuSlide },
	            '实时监测平台'
	          )
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'right' },
	        _react2.default.createElement(
	          'div',
	          { className: 'right-park' },
	          select,
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;' },
	            '进入信息填报系统'
	          )
	        )
	      )
	    );
	  }
	});

	//module.exports = Menu;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	//   ,{selectval}
	// )(Menu)

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {
	    //获取下拉列表数据
	    menuParkSelectListRequest: state.MenuParkSelectList.request,
	    menuParkSelectListResult: state.MenuParkSelectList.result
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(MenuParkActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(Menu);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MenuPark.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 771:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(772);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	var finGuaraActionCreaters = _interopRequireWildcard(_FinanceGuaraIndexAction);

	var _index = __webpack_require__(692);

	var _setMinHeight = __webpack_require__(729);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _IndustrySearch = __webpack_require__(741);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _FinanceGuaraCompanyGrade = __webpack_require__(774);

	var _FinanceGuaraCompanyGrade2 = _interopRequireDefault(_FinanceGuaraCompanyGrade);

	var _FinanceGuaraMap = __webpack_require__(778);

	var _FinanceGuaraMap2 = _interopRequireDefault(_FinanceGuaraMap);

	var _BalanceDistribute = __webpack_require__(781);

	var _BalanceDistribute2 = _interopRequireDefault(_BalanceDistribute);

	var _GuaraEachAverage = __webpack_require__(782);

	var _GuaraEachAverage2 = _interopRequireDefault(_GuaraEachAverage);

	var _GuaraDutyBalance = __webpack_require__(783);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinanceGuaraIndustryRisk = __webpack_require__(784);

	var _FinanceGuaraIndustryRisk2 = _interopRequireDefault(_FinanceGuaraIndustryRisk);

	var _LargeGuara = __webpack_require__(786);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//企业评级


	//融资担保地图

	//担保责任余额结构分布

	//担保笔均折线图


	//担保责任余额


	//股东行业风险


	//大额被担保人信息列表


	//融资担保
	var FinanceGuaraIndex = _react2.default.createClass({
	    displayName: 'FinanceGuaraIndex',

	    mixins: [_setMinHeight2.default],
	    getInitialState: function getInitialState() {
	        return {
	            guaraDutyBalaData: {},
	            balanceDistrData: [],
	            guaraEachAverData: {}
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getFinGuaDutyBalance = this.props.getFinGuaDutyBalance;

	        var jsonData = {};
	        getFinGuaDutyBalance(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.guaraDutyBalanceRequest, this.props.guaraDutyBalanceResult);
	        if (!isEqual) {
	            var guaraDutyBalanceRequest = nextProps.guaraDutyBalanceRequest;
	            var guaraDutyBalanceResult = nextProps.guaraDutyBalanceResult;

	            if (guaraDutyBalanceRequest == true) {
	                if (guaraDutyBalanceResult.success == true) {
	                    this.dataFomat(guaraDutyBalanceResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        var guaraDutyBalaData = { //担保责任余额
	            xAxis: [],
	            yAxis: [],
	            data: []
	        };
	        var balanceArr = [];
	        //贷款笔均折线图
	        var guaraEachAverData = {
	            xAxis: [],
	            series: []
	        };

	        //担保在责任余额结构分布图
	        var balanceDistrData = [];

	        var conLength = content.length;

	        for (var i = 0; i < conLength; i++) {
	            var year = content[i].year;
	            var balance = content[i].amount; //贷款余额
	            var dataArr = [i, i, balance];

	            balanceArr.push(balance);
	            guaraDutyBalaData.xAxis.push(year);
	            guaraDutyBalaData.data.push(dataArr);

	            guaraEachAverData.xAxis.push(year);
	            guaraEachAverData.series.push(content[i].number);
	        }
	        var balanceMax = Math.max.apply(null, balanceArr);
	        var eachYAxis = balanceMax / 5;
	        for (var j = 0; j < 5; j++) {
	            guaraDutyBalaData.yAxis.push(eachYAxis * j);
	        }

	        var policyBalance = content[conLength - 1].policyBalance; //政策类
	        var steelBalance = content[conLength - 1].steelBalance; //钢贸类
	        var compositeBalance = content[conLength - 1].compositeBalance; //综合类
	        balanceDistrData.push({ "name": "政策性", "value": policyBalance });
	        balanceDistrData.push({ "name": "综合型", "value": compositeBalance });
	        balanceDistrData.push({ "name": "钢贸类", "value": steelBalance });
	        console.log(guaraEachAverData, "许尧测试");

	        this.setState({ guaraDutyBalaData: guaraDutyBalaData, guaraEachAverData: guaraEachAverData, balanceDistrData: balanceDistrData });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'finance-guara-index content-space-10', style: this.state.style },
	            _react2.default.createElement(
	                'div',
	                { className: 'search-box' },
	                _react2.default.createElement(_IndustrySearch2.default, { label: '融资担保监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'top' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'left' },
	                    _react2.default.createElement(_FinanceGuaraCompanyGrade2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'middle mod-space-l' },
	                    _react2.default.createElement(_FinanceGuaraMap2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'right mod-space-l' },
	                    _react2.default.createElement(_BalanceDistribute2.default, { balanceDistrData: this.state.balanceDistrData }),
	                    _react2.default.createElement(_GuaraEachAverage2.default, { guaraEachAverData: this.state.guaraEachAverData })
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'bottom mod-space-t' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'left' },
	                    _react2.default.createElement(_GuaraDutyBalance2.default, { guaraDutyBalaData: this.state.guaraDutyBalaData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'middle mod-space-l' },
	                    _react2.default.createElement(_FinanceGuaraIndustryRisk2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'right mod-space-l' },
	                    _react2.default.createElement(_LargeGuara2.default, this.props)
	                )
	            )
	        );
	    }
	});

	//module.exports = FinanceGuaraIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {

	        //企业评级
	        FinGuaCompanyGradeRequest: state.FinGuaCompanyGrade.request,
	        FinGuaCompanyGradeResult: state.FinGuaCompanyGrade.result,

	        //地图
	        finGuaMapRequest: state.FinGuaMap.request,
	        finGuaMapResult: state.FinGuaMap.result,

	        //贷款余额
	        guaraDutyBalanceRequest: state.GuaraDutyBalance.request,
	        guaraDutyBalanceResult: state.GuaraDutyBalance.result,

	        //股东行业风险
	        finGuaIndustryRiskRequest: state.FinGuaIndustryRisk.request,
	        finGuaIndustryRiskResult: state.FinGuaIndustryRisk.result,

	        //大额借款公司信息列表
	        largeGuaraRequest: state.LargeGuara.request,
	        largeGuaraResult: state.LargeGuara.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(finGuaraActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(FinanceGuaraIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 787:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(741);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyProgress = __webpack_require__(790);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _CompanyQuality = __webpack_require__(793);

	var _CompanyQuality2 = _interopRequireDefault(_CompanyQuality);

	var _QDLPQuality = __webpack_require__(794);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(795);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(796);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _EquityL = __webpack_require__(798);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(800);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(801);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _PrivateFundIndexAction = __webpack_require__(1294);

	var PrivateFundIndexCreaters = _interopRequireWildcard(_PrivateFundIndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//私募股权基本情况
	//私募证券基本情况

	//QDLP试点企业最新进展

	//QDLP试点企业最新进展

	var Immutable = __webpack_require__(777);
	//私募基金首页
	//私募股权基本情况
	//私募股权基本情况
	//字私募基金分类
	//试点企业性质
	var PrivateFundIndex = _react2.default.createClass({
	    displayName: 'PrivateFundIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: [],
	            architectureMap: {}
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyProgressRequest = this.props.getCompanyProgressRequest;

	        var jsonData = {};
	        getCompanyProgressRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyProgressRequest, this.props.companyProgressResult);
	        if (!isEqual) {
	            var companyProgressRequest = nextProps.companyProgressRequest;
	            var companyProgressResult = nextProps.companyProgressResult;

	            if (companyProgressRequest == true) {
	                if (companyProgressResult.success) {
	                    this.setState({ listData: companyProgressResult.content.list }, function () {});
	                    this.setState({ architectureMap: companyProgressResult.content.architectureMap }, function () {});
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'privateFund-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '私募基金监测', placeholder: '请输入企业名称关键字' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'privateF-t clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-l mod radius4 clearfix' },
	                        _react2.default.createElement(_CompanyProgress2.default, { companyProgressData: this.state.listData }),
	                        _react2.default.createElement(_CompanyQuality2.default, { companyQuality: this.state.architectureMap })
	                    ),
	                    _react2.default.createElement(_QDLPQuality2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'privateF-m clearfix' },
	                    _react2.default.createElement(_FundClass2.default, this.props),
	                    _react2.default.createElement(_FundCase2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'privateF-b mod radius4' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'list-header' },
	                        '私募股权基本情况'
	                    ),
	                    _react2.default.createElement(_EquityL2.default, this.props),
	                    _react2.default.createElement(_EquityM2.default, this.props),
	                    _react2.default.createElement(_EquityR2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = PrivateFundIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        companyProgressRequest: state.CompanyProgress.request,
	        companyProgressResult: state.CompanyProgress.result,

	        QDLPQualityRequest: state.QDLPQuality.request,
	        QDLPQualityResult: state.QDLPQuality.result,

	        fundClassRequest: state.FundClass.request,
	        fundClassResult: state.FundClass.result,

	        fundCaseRequest: state.FundCase.request,
	        fundCaseResult: state.FundCase.result,

	        fundCaseTopRequest: state.FundCaseTop.request,
	        fundCaseTopResult: state.FundCaseTop.result,

	        equityLRequest: state.EquityL.request,
	        equityLResult: state.EquityL.result,

	        equityMRequest: state.EquityM.request,
	        equityMResult: state.EquityM.result,

	        equityRRequest: state.EquityR.request,
	        equityRResult: state.EquityR.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(PrivateFundIndexCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(PrivateFundIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 810:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//环形 饼图  有时间线
	var AnnularPieChart = _react2.default.createClass({
	    displayName: 'AnnularPieChart',

	    componentDidMount: function componentDidMount() {
	        var id = this.props.param.id;
	        var pieChart = echarts.init(document.getElementById(id));
	        var param = this.props.param;
	        var option = this.setOption(param);
	        pieChart.setOption(option);
	        this.resizeChart(pieChart);
	    },
	    resizeChart: function resizeChart(pieChart) {
	        //容器发生改变时重新设置图表大小
	        $(window).resize(function () {
	            pieChart.resize();
	        });
	    },
	    setOption: function setOption(param) {
	        var id = this.props.param.id;

	        var option = {
	            baseOption: {
	                timeline: {
	                    axisType: 'category',
	                    autoPlay: true,
	                    playInterval: 2000,
	                    currentIndex: 0,
	                    bottom: 10,
	                    left: '10%',
	                    right: '10%',
	                    // width:500,
	                    symbolSize: 10,
	                    symbolOffset: ['10%', '5%'],
	                    lineStyle: {
	                        color: '#ffffff'
	                    },
	                    checkpointStyle: {
	                        symbolSize: 10,
	                        color: 'rgba(225,67,64,1)'
	                    },
	                    controlStyle: {
	                        show: false
	                    },
	                    data: param.timeLineData,
	                    label: {
	                        normal: {},
	                        emphasis: {},
	                        textStyle: {
	                            color: '#ffffff'
	                        },
	                        formatter: function formatter(value, index) {
	                            return value;
	                        }
	                    }
	                },
	                tooltip: {
	                    show: true,
	                    formatter: "{a} <br/>{b} : {c} ({d}%)"
	                },
	                calculable: true,
	                color: ["#e14340", "#01b0d1", "#00c7ab"],
	                legend: {
	                    orient: 'vertical',
	                    top: '1%',
	                    left: document.getElementById(id).offsetWidth / 2,
	                    data: param.legendData,
	                    itemGap: 11,
	                    textStyle: {
	                        color: '#ffffff'
	                    }

	                },
	                series: [{
	                    name: '贷款余额总计',
	                    type: 'pie',
	                    radius: [80, 95],
	                    center: ['50%', '40%'],
	                    avoidLabelOverlap: true,
	                    clockwise: false,
	                    hoverAnimation: false,
	                    //startAngle:0,
	                    label: {
	                        normal: {
	                            show: false,
	                            position: 'outside'
	                        },
	                        emphasis: {
	                            show: false,
	                            textStyle: {
	                                fontSize: '12'
	                            }
	                        }
	                    },
	                    labelLine: {
	                        normal: {
	                            show: false,
	                            length: 20,
	                            length2: 20,
	                            lineStyle: {
	                                color: '#ffffff'
	                            }
	                        }
	                    }
	                }, {
	                    name: '小微企业贷款余额总计',
	                    type: 'pie',
	                    radius: [55, 70],
	                    center: ['50%', '40%'],
	                    avoidLabelOverlap: true,
	                    clockwise: false,
	                    hoverAnimation: false,
	                    //startAngle:50,
	                    label: {
	                        normal: {
	                            show: false
	                        },
	                        emphasis: {
	                            show: false
	                        }
	                    },
	                    labelLine: {
	                        normal: {
	                            show: true,
	                            length: 40,
	                            length2: 40,
	                            lineStyle: {
	                                color: '#ffffff'
	                            }
	                        }
	                    }
	                }, {
	                    name: '三农企业贷款余额总计',
	                    type: 'pie',
	                    radius: [30, 45],
	                    center: ['50%', '40%'],
	                    avoidLabelOverlap: true,
	                    clockwise: false,
	                    hoverAnimation: false,
	                    //startAngle:50,
	                    label: {
	                        normal: {
	                            show: false
	                        },
	                        emphasis: {
	                            show: false
	                        }
	                    },
	                    labelLine: {
	                        normal: {
	                            show: false
	                        }
	                    }
	                }]
	            },
	            options: param.data
	        };
	        return option;
	    },
	    render: function render() {
	        return _react2.default.createElement('div', { id: this.props.param.id, style: { height: this.props.param.height } });
	    }
	});

	module.exports = AnnularPieChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "AnnularPieChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 843:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getbaseMsgRequest = getbaseMsgRequest;
	exports.getcompanyMsgRequest = getcompanyMsgRequest;
	exports.getcoreDataRequest = getcoreDataRequest;
	exports.getCoreBarDataRequest = getCoreBarDataRequest;
	exports.getCoreTrendDataRequest = getCoreTrendDataRequest;
	exports.getCoreBalanceDataRequest = getCoreBalanceDataRequest;
	exports.getlitigationRequest = getlitigationRequest;
	exports.getpublicOpinionRequest = getpublicOpinionRequest;
	exports.getrankPicRequest = getrankPicRequest;
	exports.getscoreLeidaRequest = getscoreLeidaRequest;
	/*
	  平台画像
	*/

	/*基本信息*/
	var BASEMSG_REQUEST_SUCCESS = exports.BASEMSG_REQUEST_SUCCESS = 'BASEMSG_REQUEST_SUCCESS';
	var BASEMSG_REQUEST_FAIL = exports.BASEMSG_REQUEST_FAIL = 'BASEMSG_REQUEST_FAIL';

	function baseMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: BASEMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function baseMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BASEMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getbaseMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/baseInfo.do", ///data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(baseMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(baseMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*基本信息*/

	/*公司基本信息*/
	var COMPANYMSG_REQUEST_SUCCESS = exports.COMPANYMSG_REQUEST_SUCCESS = 'COMPANYMSG_REQUEST_SUCCESS';
	var COMPANYMSG_REQUEST_FAIL = exports.COMPANYMSG_REQUEST_FAIL = 'COMPANYMSG_REQUEST_FAIL';

	function companyMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function companyMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcompanyMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/platFormStatus.do", ///P2PImage/platFormStatus.do
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*公司基本信息	*/

	/*核心数据*/
	var COREDATA_REQUEST_SUCCESS = exports.COREDATA_REQUEST_SUCCESS = 'COREDATA_REQUEST_SUCCESS';
	var COREDATA_REQUEST_FAIL = exports.COREDATA_REQUEST_FAIL = 'COREDATA_REQUEST_FAIL';

	function coreDataRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREDATA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreDataRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREDATA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcoreDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataInfo.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreDataRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreDataRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据平台交易量走势
	var COREBAR_REQUEST_SUCCESS = exports.COREBAR_REQUEST_SUCCESS = 'COREBAR_REQUEST_SUCCESS';
	var COREBAR_REQUEST_FAIL = exports.COREBAR_REQUEST_FAIL = 'COREBAR_REQUEST_FAIL';

	function coreBarRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREBAR_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreBarRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREBAR_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreBarDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataDealTrend.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreBarRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreBarRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据  平台利率走势
	var CORETREND_REQUEST_SUCCESS = exports.CORETREND_REQUEST_SUCCESS = 'CORETREND_REQUEST_SUCCESS';
	var CORETREND_REQUEST_FAIL = exports.CORETREND_REQUEST_FAIL = 'CORETREND_REQUEST_FAIL';

	function coreaTrendRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: CORETREND_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreaTrendRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: CORETREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreTrendDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataInterestRateTrend.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreaTrendRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreaTrendRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据  贷款余额
	var COREBALANCE_REQUEST_SUCCESS = exports.COREBALANCE_REQUEST_SUCCESS = 'COREBALANCE_REQUEST_SUCCESS';
	var COREBALANCE_REQUEST_FAIL = exports.COREBALANCE_REQUEST_FAIL = 'COREBALANCE_REQUEST_FAIL';

	function coreBalanceRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREBALANCE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreBalanceRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREBALANCE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreBalanceDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataLoadOverage.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreBalanceRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreBalanceRequestFail(result));
	      }
	    });
	  };
	}

	/*核心数据*/

	/*诉讼信息*/
	var LITIGATION_REQUEST_SUCCESS = exports.LITIGATION_REQUEST_SUCCESS = 'LITIGATION_REQUEST_SUCCESS';
	var LITIGATION_REQUEST_FAIL = exports.LITIGATION_REQUEST_FAIL = 'LITIGATION_REQUEST_FAIL';

	function litigationRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LITIGATION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function litigationRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: LITIGATION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getlitigationRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/lawsuitMsg.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(litigationRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(litigationRequestFail(result));
	      }
	    });
	  };
	}
	/*诉讼信息*/

	/*平台舆情*/
	var PUBLICOPINION_REQUEST_SUCCESS = exports.PUBLICOPINION_REQUEST_SUCCESS = 'PUBLICOPINION_REQUEST_SUCCESS';
	var PUBLICOPINION_REQUEST_FAIL = exports.PUBLICOPINION_REQUEST_FAIL = 'PUBLICOPINION_REQUEST_FAIL';

	function publicOpinionRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function publicOpinionRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getpublicOpinionRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/platFormConsensus.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(publicOpinionRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(publicOpinionRequestFail(result));
	      }
	    });
	  };
	}
	/*平台舆情	*/

	/*动态图谱*/
	var RANKPIC_REQUEST_SUCCESS = exports.RANKPIC_REQUEST_SUCCESS = 'RANKPIC_REQUEST_SUCCESS';
	var RANKPIC_REQUEST_FAIL = exports.RANKPIC_REQUEST_FAIL = 'RANKPIC_REQUEST_FAIL';

	function rankPicRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RANKPIC_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function rankPicRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: RANKPIC_REQUEST_FAIL,
	    result: result
	  };
	}

	function getrankPicRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(rankPicRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(rankPicRequestFail(result));
	      }
	    });
	  };
	}
	/*动态图谱*/

	/*评分雷达图*/
	var SCORELEIDA_REQUEST_SUCCESS = exports.SCORELEIDA_REQUEST_SUCCESS = 'SCORELEIDA_REQUEST_SUCCESS';
	var SCORELEIDA_REQUEST_FAIL = exports.SCORELEIDA_REQUEST_FAIL = 'SCORELEIDA_REQUEST_FAIL';

	function scoreLeidaRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: SCORELEIDA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function scoreLeidaRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: SCORELEIDA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getscoreLeidaRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/radarScore.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(scoreLeidaRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(scoreLeidaRequestFail(result));
	      }
	    });
	  };
	}
	/*评分雷达图*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PPortraitAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 853:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(848);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var PlatformRun = _react2.default.createClass({
	  displayName: 'PlatformRun',

	  getInitialState: function getInitialState() {
	    return {
	      option: []
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	    var isEqual = Immutable.is(nextProps.platFormRunBaseData, this.props.platFormRunBaseData);
	    if (!isEqual) {
	      var platFormRunBaseData = nextProps.platFormRunBaseData;

	      this.setState({ option: platFormRunBaseData.content });
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
	          '平台运营情况'
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
	                  { width: '15%', className: 'talign-left' },
	                  '众筹平台'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '25%' },
	                  '公司名称'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '15%' },
	                  '业务类型',
	                  _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '20%' },
	                  '成功项目数',
	                  _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '25%' },
	                  '已筹基金(万元)',
	                  _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                )
	              )
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'table-content' },
	          _react2.default.createElement(
	            'table',
	            { className: 'mt-table mt-table-center wtyh-table' },
	            _react2.default.createElement(
	              'tbody',
	              null,
	              this.state.option.map(function (item, index) {
	                {
	                  if (item.fundingBusinessTypeCN == "0") {
	                    item.fundingBusinessTypeCN = "权益型";
	                  }
	                  if (!item.successNumber) {
	                    item.successNumber = "/";
	                  }
	                  if (!item.fundedAmout) {
	                    item.fundedAmout = "/";
	                  }
	                  if (index % 2) {

	                    return _react2.default.createElement(
	                      'tr',
	                      { className: 'even' },
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.platformName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%', className: 'talign-left' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.fundingBusinessTypeCN
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        item.successNumber
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%' },
	                        item.fundedAmout
	                      )
	                    );
	                  } else {
	                    return _react2.default.createElement(
	                      'tr',
	                      { className: 'odd' },
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.platformName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%', className: 'talign-left' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.fundingBusinessTypeCN
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        item.successNumber
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%' },
	                        item.fundedAmout
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

	module.exports = PlatformRun;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PlatformRun.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 854:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(848);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var PlatformBase = _react2.default.createClass({
	  displayName: 'PlatformBase',

	  getInitialState: function getInitialState() {
	    return {
	      option: []
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.platFormBaseData, this.props.platFormBaseData);
	    if (!isEqual) {
	      var platFormBaseData = nextProps.platFormBaseData;

	      this.setState({ option: platFormBaseData.content });
	    }
	  },
	  render: function render() {

	    return _react2.default.createElement(
	      'div',
	      { className: 'mod left-bottom radius4' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '平台基本情况'
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
	                  { width: '10%', className: 'talign-left' },
	                  '序号'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '15%', className: 'talign-left' },
	                  '平台名称'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '30%' },
	                  '公司名称'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '15%' },
	                  '注册地',
	                  _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '20%' },
	                  '运营地址'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '10%' },
	                  '网址'
	                )
	              )
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'table-content' },
	          _react2.default.createElement(
	            'table',
	            { className: 'mt-table mt-table-center wtyh-table' },
	            _react2.default.createElement(
	              'tbody',
	              null,
	              this.state.option.map(function (item, index) {
	                {
	                  if (!item.areaName) {
	                    item.areaName = "/";
	                  }
	                  if (!item.address) {
	                    item.address = "/";
	                  }
	                  if (index % 2) {
	                    return _react2.default.createElement(
	                      'tr',
	                      { className: 'even' },
	                      _react2.default.createElement(
	                        'td',
	                        { width: '10%' },
	                        index
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.platformName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '30%', className: 'talign-left' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.areaName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': '' },
	                          item.address
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '10%' },
	                        _react2.default.createElement(
	                          'a',
	                          { href: item.websiteUrl },
	                          '查看'
	                        )
	                      )
	                    );
	                  } else {
	                    return _react2.default.createElement(
	                      'tr',
	                      { className: 'odd' },
	                      _react2.default.createElement(
	                        'td',
	                        { width: '10%' },
	                        index
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.platformName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '30%', className: 'talign-left' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        item.areaName
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        _react2.default.createElement(
	                          'span',
	                          { className: 'word-limit-5', 'data-tip': '' },
	                          item.address
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '10%' },
	                        _react2.default.createElement(
	                          'a',
	                          { href: item.websiteUrl },
	                          '查看'
	                        )
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

	module.exports = PlatformBase;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PlatformBase.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 855:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getbusinessRequest = getbusinessRequest;
	exports.getinvestPeopleRequest = getinvestPeopleRequest;
	exports.getnewProjectRequest = getnewProjectRequest;
	exports.getraiseMountRunRequest = getraiseMountRunRequest;
	exports.getlistRequest = getlistRequest;
	/*
	  众筹监测
	*/

	/*业务类型begin*/
	var BUSINESS_REQUEST_SUCCESS = exports.BUSINESS_REQUEST_SUCCESS = 'BUSINESS_REQUEST_SUCCESS';
	var BUSINESS_REQUEST_FAIL = exports.BUSINESS_REQUEST_FAIL = 'BUSINESS_REQUEST_FAIL';

	function businessRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: BUSINESS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function businessRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BUSINESS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getbusinessRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/crowdFunding/distribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(businessRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(businessRequestFail(result));
	      }
	    });
	  };
	}
	/*业务类型nd*/

	/*6月上海各类众筹平台新增项目的投资人次begin*/
	var INVESTPEOPLE_REQUEST_SUCCESS = exports.INVESTPEOPLE_REQUEST_SUCCESS = 'INVESTPEOPLE_REQUEST_SUCCESS';
	var INVESTPEOPLE_REQUEST_FAIL = exports.INVESTPEOPLE_REQUEST_FAIL = 'INVESTPEOPLE_REQUEST_FAIL';

	function investPeopleRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INVESTPEOPLE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function investPeopleRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: INVESTPEOPLE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getinvestPeopleRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/crowdFunding/newlyPeople.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(investPeopleRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(investPeopleRequestFail(result));
	      }
	    });
	  };
	}
	/*6月上海各类众筹平台新增项目的投资人次end*/

	/*6月上海各类众筹平台新增项目数begin*/
	var NEWPROJECT_REQUEST_SUCCESS = exports.NEWPROJECT_REQUEST_SUCCESS = 'NEWPROJECT_REQUEST_SUCCESS';
	var NEWPROJECT_REQUEST_FAIL = exports.NEWPROJECT_REQUEST_FAIL = 'NEWPROJECT_REQUEST_FAIL';

	function newProjectRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NEWPROJECT_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function newProjectRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NEWPROJECT_REQUEST_FAIL,
	    result: result
	  };
	}

	function getnewProjectRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/crowdFunding/newlyProject.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(newProjectRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(newProjectRequestFail(result));
	      }
	    });
	  };
	}
	/*6月上海各类众筹平台新增项目数end*/

	/*6月上海各类众筹平台新增项目数的成功筹资金额begin*/
	var RAISEMOUNT_REQUEST_SUCCESS = exports.RAISEMOUNT_REQUEST_SUCCESS = 'RAISEMOUNT_REQUEST_SUCCESS';
	var RAISEMOUNT_REQUEST_FAIL = exports.RAISEMOUNT_REQUEST_FAIL = 'RAISEMOUNT_REQUEST_FAIL';

	function raiseMountRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RAISEMOUNT_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function raiseMountRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: RAISEMOUNT_REQUEST_FAIL,
	    result: result
	  };
	}

	function getraiseMountRunRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "crowdFunding/newlyAmount.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(raiseMountRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(raiseMountRequestFail(result));
	      }
	    });
	  };
	}
	/*6月上海各类众筹平台新增项目数的成功筹资金额end*/

	/*  筹资金额、新增项目 列表begin*/
	var LIST_REQUEST_SUCCESS = exports.LIST_REQUEST_SUCCESS = 'LIST_REQUEST_SUCCESS';
	var LIST_REQUEST_FAIL = exports.LIST_REQUEST_FAIL = 'LIST_REQUEST_FAIL';

	function listequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LIST_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function listRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: LIST_REQUEST_FAIL,
	    result: result
	  };
	}

	function getlistRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/crowdFunding/allCompanys.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(listequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(listRequestFail(result));
	      }
	    });
	  };
	}
	/*筹资金额、新增项目 列表end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RaiseIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 886:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(887);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _commercialSecretIndexAction = __webpack_require__(1305);

	var CommercialSecretIndexActionCreaters = _interopRequireWildcard(_commercialSecretIndexAction);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(741);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyNum = __webpack_require__(889);

	var _CompanyNum2 = _interopRequireDefault(_CompanyNum);

	var _CompanyAmount = __webpack_require__(892);

	var _CompanyAmount2 = _interopRequireDefault(_CompanyAmount);

	var _BusinessNum = __webpack_require__(893);

	var _BusinessNum2 = _interopRequireDefault(_BusinessNum);

	var _Balance = __webpack_require__(894);

	var _Balance2 = _interopRequireDefault(_Balance);

	var _CompanyDirectory = __webpack_require__(895);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//商业保理企业名单

	//国内商业保理和国际商业保理业务额
	//在沪商业保理企业数量
	var Immutable = __webpack_require__(777);
	//商业保理
	//全市商业保理业务总额及融资余额
	//全市商业保理企业资产总额(注册资本)

	var CommercialSecret = _react2.default.createClass({
	  displayName: 'CommercialSecret',

	  mixins: [_setHeight2.default],
	  getInitialState: function getInitialState() {
	    return {
	      CompanyNumData: []
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanynumRequest = this.props.getCompanynumRequest;

	    var jsonData = {};
	    getCompanynumRequest(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.CompanyNumChartRequest, this.props.CompanyNumChartResult);
	    if (!isEqual) {
	      var CompanyNumChartRequest = nextProps.CompanyNumChartRequest;
	      var CompanyNumChartResult = nextProps.CompanyNumChartResult;

	      if (CompanyNumChartRequest == true) {
	        if (CompanyNumChartResult.success) {
	          this.setState({ CompanyNumData: CompanyNumChartResult.content });
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'commercialS-index', style: this.state.style },
	      _react2.default.createElement(_IndustrySearch2.default, { label: '商业保理监测555', placeHolder: '请输入企业名称检索' }),
	      _react2.default.createElement(
	        'div',
	        { className: 'content clearfix' },
	        _react2.default.createElement(
	          'div',
	          { className: 'pawnM-top clearfix' },
	          _react2.default.createElement(_CompanyNum2.default, { CompanyNumData: this.state.CompanyNumData }),
	          _react2.default.createElement(_CompanyAmount2.default, { CompanyAmountData: this.state.CompanyNumData })
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'pawnM-Middle clearfix' },
	          _react2.default.createElement(_BusinessNum2.default, this.props),
	          _react2.default.createElement(_Balance2.default, this.props)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'pawnM-bottom' },
	          _react2.default.createElement(_CompanyDirectory2.default, null)
	        )
	      )
	    );
	  }
	});
	// module.exports = CommercialSecret;

	//将 request  result 绑定到props的request result
	function CommercialSecretStateToProps(state) {
	  return {

	    CompanyNumChartRequest: state.ChartAll.request,
	    CompanyNumChartResult: state.ChartAll.result,
	    //企业类型分布
	    BusinessNumChartRequest: state.businessnumChart.request,
	    BusinessNumChartResult: state.businessnumChart.result,
	    //商业保理地域分布
	    balanceRequest: state.balanceChart.request,
	    balanceResult: state.balanceChart.result
	  };
	}

	//将action的所有方法绑定到props上
	function CommercialSecretDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(CommercialSecretIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(CommercialSecretStateToProps, CommercialSecretDispatchToProps)(CommercialSecret);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 889:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(890);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(757);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var CompanyNum = _react2.default.createClass({
	    displayName: 'CompanyNum',
	    getInitialState: function getInitialState() {
	        return {
	            CompanyNumoption: null
	        };
	    },

	    setLineLParm: function setLineLParm(data) {
	        var options = {
	            color: ["#e24441"],
	            title: "",
	            titleShow: false,
	            titleX: "center",
	            symbolSize: 5,
	            legendIsShow: false,
	            yFlag: "",
	            lineLable: {
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
	            yAxisName: "个数",
	            legendRight: "30",
	            legend: ["企业数量"],
	            xAxis: data.line.xAxis,
	            series: [data.line.series]
	        };
	        this.setState({ CompanyNumoption: options });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.CompanyNumData, this.props.CompanyNumData);
	        if (!isEqual) {
	            var CompanyNumData = nextProps.CompanyNumData;

	            console.info("000000000000000000000" + CompanyNumData.line.xAxis + "11111111111111" + CompanyNumData.line.series);
	            this.setLineLParm(CompanyNumData);
	        }
	    },
	    render: function render() {
	        var CompanyNumBox = "";
	        if (this.state.CompanyNumoption) {
	            CompanyNumBox = _react2.default.createElement(_LineChart2.default, {
	                option: this.state.CompanyNumoption,
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
	                    '在沪商业保理企业数量'
	                )
	            ),
	            CompanyNumBox
	        );
	    }
	});

	module.exports = CompanyNum;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyNum.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 892:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(890);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(837);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var CompanyAmount = _react2.default.createClass({
		displayName: 'CompanyAmount',
		getInitialState: function getInitialState() {
			return {
				CompanyAmountoption: null
			};
		},

		setParm: function setParm(data) {
			var options = {
				title: "平台交易量走势",
				titleX: "center",
				color: ["#efd79b"],
				barWidth: 25,
				yAxisName: "人民币亿元",
				yFlag: "", //y轴单位
				splitLineShow: false,
				legendShow: false,
				gridLeft: '5%',
				gridRight: '5%',
				gridBottom: '5%',
				gridTop: '10%',
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
				legend: ["企业资产总额"],
				xAxis: data.histogram.xAxis,
				series: [data.histogram.series]
			};
			this.setState({ CompanyAmountoption: options });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.CompanyAmountData, this.props.CompanyAmountData);
			if (!isEqual) {
				var CompanyAmountData = nextProps.CompanyAmountData;

				this.setParm(CompanyAmountData);
			}
		},
		render: function render() {
			var CompanyAmountBox = "";
			if (this.state.CompanyAmountoption) {
				CompanyAmountBox = _react2.default.createElement(_BarChart2.default, {
					option: this.state.CompanyAmountoption,
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
						'全市商业保理企业注册资本总额'
					)
				),
				CompanyAmountBox
			);
		}
	});

	module.exports = CompanyAmount;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyAmount.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 893:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(890);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(756);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var BusinessNum = _react2.default.createClass({
	    displayName: 'BusinessNum',
	    getInitialState: function getInitialState() {
	        return {
	            BusinessNumoption: null
	        };
	    },

	    setParm: function setParm(data) {
	        var series = [];
	        for (var i = 0; i < data.legend.length; i++) {
	            series.push({ value: data.series[i], name: data.legend[i] });
	        }
	        var options = {
	            "color": ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	            "title": "",
	            "xtitle": "",
	            "titleLeft": "0",
	            "legend": data.legend,
	            "legendShow": true,
	            "legendOrient": "horizontal",
	            "legendLeft": "center",
	            "legendTop": "78%",
	            "seriesName": "基金类型",
	            "radius": "60%",
	            "lable": { normal: {
	                    show: true,
	                    position: 'inside',
	                    formatter: '{d}%',
	                    textStyle: {
	                        color: "#fff",
	                        fontSize: 12,
	                        fontWeight: "normal",
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '40%'],
	            "series": series
	        };
	        this.setState({
	            BusinessNumoption: options
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getBusinessnumRequest = this.props.getBusinessnumRequest;

	        var jsonData = {};
	        getBusinessnumRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.BusinessNumChartRequest, this.props.BusinessNumChartResult);
	        if (!isEqual) {
	            var BusinessNumChartRequest = nextProps.BusinessNumChartRequest;
	            var BusinessNumChartResult = nextProps.BusinessNumChartResult;

	            if (BusinessNumChartRequest == true) {
	                if (BusinessNumChartResult.success == true) {
	                    this.setParm(BusinessNumChartResult.content);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },

	    render: function render() {
	        var BusinessNumBox = "";
	        if (this.state.BusinessNumoption) {
	            BusinessNumBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.BusinessNumoption,
	                style: { height: '465px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-left radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业类型分布'
	                )
	            ),
	            BusinessNumBox
	        );
	    }
	});

	module.exports = BusinessNum;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessNum.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 894:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(890);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(797);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var Balance = _react2.default.createClass({
	    displayName: 'Balance',
	    getInitialState: function getInitialState() {
	        return {
	            Balanceoption: null
	        };
	    },

	    setBarParm: function setBarParm(data) {
	        var options = {
	            color: ["#e14340"],
	            titleName: "",
	            titleShow: false,
	            barWidth: 25,
	            legendRight: "20",
	            xAxisLine: true,
	            xAxisLabel: true,
	            gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
	            legend: [""],
	            label: {
	                normal: {
	                    show: true,
	                    position: 'right',
	                    textStyle: {
	                        color: "#fff",
	                        fontSize: 12,
	                        fontWeight: "normal",
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            },
	            gridLeft: '5%',
	            gridRight: '5%',
	            gridTop: '5%',
	            gridBottom: '10%',
	            yAxis: data.xAxis,
	            series: [data.series]

	        };
	        this.setState({
	            Balanceoption: options
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getBalanceRequest = this.props.getBalanceRequest;

	        var jsonData = {};
	        getBalanceRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.balanceRequest, this.props.balanceResult);
	        if (!isEqual) {
	            var balanceRequest = nextProps.balanceRequest;
	            var balanceResult = nextProps.balanceResult;

	            if (balanceRequest == true) {
	                if (balanceResult.success == true) {
	                    this.setBarParm(balanceResult.content);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    render: function render() {
	        var BalanceChart = "";
	        if (this.state.Balanceoption) {
	            BalanceChart = _react2.default.createElement(_HorizontalBarChart2.default, {
	                option: this.state.Balanceoption,
	                style: { height: '460px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-right radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '商业保理地域分布'
	                )
	            ),
	            BalanceChart
	        );
	    }
	});

	module.exports = Balance;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Balance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 895:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(890);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',
	    render: function render() {
	        var selectQuarter = {
	            width: '75px',
	            className: 'company-dire',
	            name: 'testselect',
	            value: "1",
	            id: 'selectType',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '内资' }, { value: '3', label: '外资' }],
	            onChange: function (value, label) {
	                console.info(value, label);
	                // this.quarterChoice(label);
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
	                    '商业保理企业名单'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'totle-num' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'orange' },
	                        ' 250 '
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
	                                    '企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '企业类型',
	                                    _react2.default.createElement(_index.Selected, selectQuarter)
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%' },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '1'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '2'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '3'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '4'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '5'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '6'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '7'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '8'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '9'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '10%', className: 'talign-center' },
	                                    '10'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '创富融资租赁(上海)有限公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '20%' },
	                                    '内资'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '30%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '15%' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', title: '' },
	                                        '1000万元'
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

	module.exports = CompanyDirectory;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDirectory.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1294:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getCompanyProgressRequest = getCompanyProgressRequest;
	exports.getQDLPQualityRequest = getQDLPQualityRequest;
	exports.getFundClassRequest = getFundClassRequest;
	exports.getFundCaseRequest = getFundCaseRequest;
	exports.getFundCaseTopRequest = getFundCaseTopRequest;
	exports.getEquityLRequest = getEquityLRequest;
	exports.getEquityMRequest = getEquityMRequest;
	exports.getEquityRRequest = getEquityRRequest;
	/*
	 私募基金
	*/

	/*QDLP试点企业最新进展begin*/
	var COMPANYPROGRESS_REQUEST_SUCCESS = exports.COMPANYPROGRESS_REQUEST_SUCCESS = 'COMPANYPROGRESS_REQUEST_SUCCESS';
	var COMPANYPROGRESS_REQUEST_FAIL = exports.COMPANYPROGRESS_REQUEST_FAIL = 'COMPANYPROGRESS_REQUEST_FAIL';

	function companyProgressRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYPROGRESS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function companyProgressRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYPROGRESS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCompanyProgressRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/qdlpProgressList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyProgressRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyProgressRequestFail(result));
	      }
	    });
	  };
	}
	/*QDLP试点企业最新进展end*/

	/*QFLP试点企业最新进展begin*/
	var QDLPQUALITY_REQUEST_SUCCESS = exports.QDLPQUALITY_REQUEST_SUCCESS = 'QDLPQUALITY_REQUEST_SUCCESS';
	var QDLPQUALITY_REQUEST_FAIL = exports.QDLPQUALITY_REQUEST_FAIL = 'QDLPQUALITY_REQUEST_FAIL';

	function QDLPQualityRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: QDLPQUALITY_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function QDLPQualityRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: QDLPQUALITY_REQUEST_FAIL,
	    result: result
	  };
	}

	function getQDLPQualityRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/qflpInfoList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(QDLPQualityRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(QDLPQualityRequestFail(result));
	      }
	    });
	  };
	}
	/*QQFLP试点企业最新进展end*/

	/*私募基金分类*/
	var FUNDCLASS_REQUEST_SUCCESS = exports.FUNDCLASS_REQUEST_SUCCESS = 'FUNDCLASS_REQUEST_SUCCESS';
	var FUNDCLASS_REQUEST_FAIL = exports.FUNDCLASS_REQUEST_FAIL = 'FUNDCLASS_REQUEST_FAIL';

	function fundClassRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FUNDCLASS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function fundClassRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: FUNDCLASS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getFundClassRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/typeStatistic.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(fundClassRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(fundClassRequestFail(result));
	      }
	    });
	  };
	}

	/*私募基金分类*/

	/*私募证券基本情况*/
	var FUNDCASE_REQUEST_SUCCESS = exports.FUNDCASE_REQUEST_SUCCESS = 'FUNDCASE_REQUEST_SUCCESS';
	var FUNDCASE_REQUEST_FAIL = exports.FUNDCASE_REQUEST_FAIL = 'FUNDCASE__REQUEST_FAIL';

	function fundCaseRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FUNDCASE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function fundCaseRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: FUNDCASE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getFundCaseRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/productTypeStatistic.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(fundCaseRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(fundCaseRequestFail(result));
	      }
	    });
	  };
	}

	var FUNDCASETOP_REQUEST_SUCCESS = exports.FUNDCASETOP_REQUEST_SUCCESS = 'FUNDCASETOP_REQUEST_SUCCESS';
	var FUNDCASETOP_REQUEST_FAIL = exports.FUNDCASETOP_REQUEST_FAIL = 'FUNDCASETOP_REQUEST_FAIL';

	function fundCaseTopRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FUNDCASETOP_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function fundCaseTopRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: FUNDCASETOP_REQUEST_FAIL,
	    result: result
	  };
	}

	function getFundCaseTopRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/topProductNumber.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(fundCaseTopRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(fundCaseTopRequestFail(result));
	      }
	    });
	  };
	}
	/*私募证券基本情况*/

	/*私募股权基本情况*/
	var EQUITYL_REQUEST_SUCCESS = exports.EQUITYL_REQUEST_SUCCESS = 'EQUITYL_REQUEST_SUCCESS';
	var EQUITYL_REQUEST_FAIL = exports.EQUITYL_REQUEST_FAIL = 'EQUITYL_REQUEST_FAIL';

	function equityLRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: EQUITYL_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function equityLRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: EQUITYL_REQUEST_FAIL,
	    result: result
	  };
	}

	function getEquityLRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/capitalAmount.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(equityLRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(equityLRequestFail(result));
	      }
	    });
	  };
	}

	var EQUITYM_REQUEST_SUCCESS = exports.EQUITYM_REQUEST_SUCCESS = 'EQUITYM_REQUEST_SUCCESS';
	var EQUITYM_REQUEST_FAIL = exports.EQUITYM_REQUEST_FAIL = 'EQUITYM_REQUEST_FAIL';

	function equityMRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: EQUITYM_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function equityMRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: EQUITYM_REQUEST_FAIL,
	    result: result
	  };
	}

	function getEquityMRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/investmentReturn.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(equityMRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(equityMRequestFail(result));
	      }
	    });
	  };
	}

	var EQUITYR_REQUEST_SUCCESS = exports.EQUITYR_REQUEST_SUCCESS = 'EQUITYR_REQUEST_SUCCESS';
	var EQUITYR_REQUEST_FAIL = exports.EQUITYR_REQUEST_FAIL = 'EQUITYR_REQUEST_FAIL';

	function equityRRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: EQUITYR_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function equityRRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: EQUITYR_REQUEST_FAIL,
	    result: result
	  };
	}

	function getEquityRRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/privateFund/investmentAmount.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(equityRRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(equityRRequestFail(result));
	      }
	    });
	  };
	}
	/*私募股权基本情况*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PrivateFundIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1304:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getMenuParkSelectList = getMenuParkSelectList;
	exports.getMenuParkSelectVal = getMenuParkSelectVal;

	/*获取下拉框数据begin*/
	var MENUPARK_SELECTVAL_SUCCESS = exports.MENUPARK_SELECTVAL_SUCCESS = 'MENUPARK_SELECTVAL_SUCCESS';
	var MENUPARK_SELECTVAL_FAIL = exports.MENUPARK_SELECTVAL_FAIL = 'MENUPARK_SELECTVAL_FAIL';

	function menuParkSelectValSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: MENUPARK_SELECTVAL_SUCCESS,
	    result: result
	  };
	}
	function menuParkSelectValFail(result) {
	  //请求失败调用方法
	  return {
	    type: MENUPARK_SELECTVAL_FAIL,
	    result: result
	  };
	}

	function getMenuParkSelectList(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/park/areaList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(menuParkSelectValSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(menuParkSelectValFail(result));
	      }
	    });
	  };
	}
	/*获取下拉框数据end*/

	/*园区 导航下拉选择框的值 begin*/
	var SELECT_NAME = exports.SELECT_NAME = 'SELECT_NAME';

	function getMenuParkSelectVal(data) {
	  console.log(data, 333333333334444444444);
	  return {
	    type: SELECT_NAME,
	    data: data
	  };
	}
	/*园区 导航下拉选择框 end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MenuParkAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1305:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getCompanynumRequest = getCompanynumRequest;
	exports.getBusinessnumRequest = getBusinessnumRequest;
	exports.getBalanceRequest = getBalanceRequest;
	/*
	 商业保理平台监测
	*/

	/*在沪商业保理企业数量图表begin*/
	var COMMERCIAL_COMPANYNUM_SUCCESS = exports.COMMERCIAL_COMPANYNUM_SUCCESS = 'COMMERCIAL_COMPANYNUM_SUCCESS';
	var COMMERCIAL_COMPANYNUM_FAIL = exports.COMMERCIAL_COMPANYNUM_FAIL = 'COMMERCIAL_COMPANYNUM_FAIL';

	function companynumRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_COMPANYNUM_SUCCESS,
	    result: result
	  };
	}
	function companynumRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_COMPANYNUM_FAIL,
	    result: result
	  };
	}

	function getCompanynumRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/factoring/countCapitalBySeason.do", //"/data/industryMonitor/p2p/index/indexChart.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companynumRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companynumRequestFail(result));
	      }
	    });
	  };
	}
	/*在沪商业保理企业数量图表end*/

	/*  企业类型分布图表begin*/
	var COMMERCIAL_BUSINESSNUM_SUCCESS = exports.COMMERCIAL_BUSINESSNUM_SUCCESS = 'COMMERCIAL_BUSINESSNUM_SUCCESS';
	var COMMERCIAL_BUSINESSNUM_FAIL = exports.COMMERCIAL_BUSINESSNUM_FAIL = 'COMMERCIAL_BUSINESSNUM_FAIL';

	function businessnumRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_BUSINESSNUM_SUCCESS,
	    result: result
	  };
	}
	function businessnumRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_BUSINESSNUM_FAIL,
	    result: result
	  };
	}

	function getBusinessnumRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/factoring/distribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(businessnumRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(businessnumRequestFail(result));
	      }
	    });
	  };
	}
	/* 企业类型分布图表end */

	/* 商业保理地域分布图表begin */
	var COMMERCIAL_BALANCE_SUCCESS = exports.COMMERCIAL_BALANCE_SUCCESS = 'COMMERCIAL_BALANCE_SUCCESS';
	var COMMERCIAL_BALANCE_FAIL = exports.COMMERCIAL_BALANCE_FAIL = 'COMMERCIAL_BALANCE_FAIL';

	function balanceRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_BALANCE_SUCCESS,
	    result: result
	  };
	}
	function balanceRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_BALANCE_FAIL,
	    result: result
	  };
	}

	function getBalanceRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/factoring/geogDistribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(balanceRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(balanceRequestFail(result));
	      }
	    });
	  };
	}
	/*商业保理地域分布图表end */

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "commercialSecretIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})