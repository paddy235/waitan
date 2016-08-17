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

	var _reactRedux = __webpack_require__(317);

	var _selectvalAction = __webpack_require__(1276);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Menu = _react2.default.createClass({
	  displayName: 'Menu',

	  getInitialState: function getInitialState() {
	    return {
	      subNav: false,
	      selectDom: _react2.default.createElement('span', null)
	    };
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

	  componentWillMount: function componentWillMount() {

	    var selectProp = {
	      width: '160px',
	      className: 'index-selected',
	      placeholder: '高级选项',
	      value: this.props.val,
	      name: 'testselect',
	      id: 'indexSelected',
	      onChange: function (value) {
	        //console.log("?????????????",value)
	        // this.props.selectVal(value);
	        this.props.selectval({ val: value });
	      }.bind(this)
	    };
	    //ajax请求区域
	    $.ajax({
	      url: 'park/areaList.do',
	      type: 'get',
	      dataType: 'json',
	      success: function (res) {
	        if (res.success) {
	          var menuBox = [];
	          for (var k = 0; k < res.content.length; k++) {
	            menuBox.push({ value: res.content[k].areaId, label: res.content[k].name });
	          }
	          selectProp.data = menuBox;
	          this.setState({
	            selectDom: _react2.default.createElement(_index.Selected, selectProp)
	          });
	          //this.props.selectval({data:{val:1122}})
	        }
	      }.bind(this)
	    });
	  },


	  render: function render() {

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
	          this.state.selectDom,
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
	exports.default = (0, _reactRedux.connect)(function (state) {
	  return {
	    val: state.selectVal.val
	  };
	}, { selectval: _selectvalAction.selectval })(Menu);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MenuPark.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 725:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(726);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setMinHeight = __webpack_require__(728);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _LineFinanceSearch = __webpack_require__(729);

	var _LineFinanceSearch2 = _interopRequireDefault(_LineFinanceSearch);

	var _SearchCondition = __webpack_require__(732);

	var _SearchCondition2 = _interopRequireDefault(_SearchCondition);

	var _LineFinanceRiskDistr = __webpack_require__(733);

	var _LineFinanceRiskDistr2 = _interopRequireDefault(_LineFinanceRiskDistr);

	var _LineFinanceList = __webpack_require__(737);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//线下理财首页
	var LineFinanceIndex = _react2.default.createClass({
	  displayName: 'LineFinanceIndex',

	  mixins: [_setMinHeight2.default],
	  getInitialState: function getInitialState() {
	    //区域选择
	    var areaSelect = ["浦东区", "嘉定区", "嘉定区", "嘉定区", "嘉定区", "嘉定区", "嘉定区", "嘉定区", "嘉定区"];
	    //注册资本
	    var regCapital = ["50万", "100万", "800万"];
	    //存续时间
	    var durationTime = ["一年以内", "1-3年", "1-3年", "1-3年"];
	    //公司背景
	    var companyBg = ["国企", "上市公司"];
	    return {
	      areaSelect: areaSelect,
	      regCapital: regCapital,
	      durationTime: durationTime,
	      companyBg: companyBg
	    };
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'line-finace-index', style: this.state.style },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_LineFinanceSearch2.default, this.props)
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'search-conditon-box' },
	        _react2.default.createElement(_SearchCondition2.default, { label: '区域选择：', className: '', conList: this.state.areaSelect }),
	        _react2.default.createElement(_SearchCondition2.default, { label: '注册资本', className: '', conList: this.state.regCapital }),
	        _react2.default.createElement(_SearchCondition2.default, { label: '存续时间', className: '', conList: this.state.durationTime }),
	        _react2.default.createElement(_SearchCondition2.default, { label: '公司背景：', className: 'last', conList: this.state.companyBg })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'risk-distr-box' },
	        _react2.default.createElement(_LineFinanceRiskDistr2.default, null)
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'list-box' },
	        _react2.default.createElement(_LineFinanceList2.default, this.props)
	      )
	    );
	  }
	});
	module.exports = LineFinanceIndex;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 801:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(802);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _SmallLoanIndexAction = __webpack_require__(804);

	var SmallLoanActionCreaters = _interopRequireWildcard(_SmallLoanIndexAction);

	var _index = __webpack_require__(692);

	var _setMinHeight = __webpack_require__(728);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _IndustrySearch = __webpack_require__(740);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyGrade = __webpack_require__(805);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _BalanceRatio = __webpack_require__(808);

	var _BalanceRatio2 = _interopRequireDefault(_BalanceRatio);

	var _EachAverage = __webpack_require__(810);

	var _EachAverage2 = _interopRequireDefault(_EachAverage);

	var _SmallLoanMap = __webpack_require__(811);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _LoanBalance = __webpack_require__(812);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(813);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(815);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//企业评级


	//余额占比

	//余额占比

	//地图


	//贷款余额


	//股东行业风险


	//大额借款公司信息列表


	//小额贷款首页
	var SmallLoanIndex = _react2.default.createClass({
	    displayName: 'SmallLoanIndex',

	    mixins: [_setMinHeight2.default],
	    getInitialState: function getInitialState() {
	        return {
	            loanBalanceData: {},
	            balanceRatioData: {},
	            eachAverageData: {}
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getLoanBalance = this.props.getLoanBalance;

	        var jsonData = {};
	        getLoanBalance(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.loanBalanceRequest, this.props.loanBalanceResult);
	        if (!isEqual) {
	            var loanBalanceRequest = nextProps.loanBalanceRequest;
	            var loanBalanceResult = nextProps.loanBalanceResult;

	            if (loanBalanceRequest == true) {
	                if (loanBalanceResult.success == true) {
	                    this.dataFomat(loanBalanceResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        console.log(data, '贷款余额');
	        var content = data.content;
	        //小额贷款数据
	        var loanBalanceData = { //贷款余额数据
	            xAxis: [],
	            yAxis: [],
	            data: [] ////[[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	        };
	        var balanceArr = [];
	        //贷款笔均折线图
	        var eachAverageData = {
	            xAxis: [],
	            series: []
	        };

	        var conLength = content.length;
	        for (var i = 0; i < conLength; i++) {
	            var year = content[i].year;
	            var balance = content[i].amount; //贷款余额
	            var dataArr = [i, i, balance];

	            balanceArr.push(balance);
	            loanBalanceData.xAxis.push(year);
	            loanBalanceData.data.push(dataArr);

	            eachAverageData.xAxis.push(year);
	            eachAverageData.series.push(content[i].number);
	        }
	        var balanceMax = Math.max.apply(null, balanceArr);
	        var eachYAxis = balanceMax / 5;
	        for (var j = 0; j < 5; j++) {
	            loanBalanceData.yAxis.push(eachYAxis * j);
	        }

	        this.setState({ loanBalanceData: loanBalanceData, eachAverageData: eachAverageData });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'small-loan-index content-space-10', style: this.state.style },
	            _react2.default.createElement(
	                'div',
	                { className: 'search-box' },
	                _react2.default.createElement(_IndustrySearch2.default, { label: '小额贷款监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'top' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'left' },
	                    _react2.default.createElement(_CompanyGrade2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'middle mod-space-l' },
	                    _react2.default.createElement(_SmallLoanMap2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'right mod-space-l' },
	                    _react2.default.createElement(_BalanceRatio2.default, this.props),
	                    _react2.default.createElement(_EachAverage2.default, { eachAverageData: this.state.eachAverageData })
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'bottom mod-space-t' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'left' },
	                    _react2.default.createElement(_LoanBalance2.default, { loanBalanceData: this.state.loanBalanceData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'middle mod-space-l' },
	                    _react2.default.createElement(_IndustryRisk2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'right mod-space-l' },
	                    _react2.default.createElement(_LargeLoan2.default, this.props)
	                )
	            )
	        );
	    }
	});
	//module.exports = SmallLoanIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {

	        //企业评级
	        companyGradeRequest: state.CompanyGrade.request,
	        companyGradeResult: state.CompanyGrade.result,

	        //地图
	        smollLoanMapRequest: state.SmallLoanMap.request,
	        smollLoanMapResult: state.SmallLoanMap.result,

	        //贷款余额
	        loanBalanceRequest: state.LoanBalance.request,
	        loanBalanceResult: state.LoanBalance.result,

	        //股东行业风险
	        industryRiskRequest: state.IndustryRisk.request,
	        industryRiskResult: state.IndustryRisk.result,

	        //大额借款公司信息列表
	        largeLoanRequest: state.LargeLoan.request,
	        largeLoanResult: state.LargeLoan.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(SmallLoanActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(SmallLoanIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 804:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getCompanyGrade = getCompanyGrade;
	exports.getSmallLoanMap = getSmallLoanMap;
	exports.getLoanBalance = getLoanBalance;
	exports.getIndustryRisk = getIndustryRisk;
	exports.getLargeLoan = getLargeLoan;
	/*
	  小额贷款模块action
	*/

	/*企业评级begin*/
	var COMPANY_GRADE_SUCCESS = exports.COMPANY_GRADE_SUCCESS = 'COMPANY_GRADE_SUCCESS';
	var COMPANY_GRADE_FAIL = exports.COMPANY_GRADE_FAIL = 'COMPANY_GRADE_FAIL';

	function companyGradeSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_GRADE_SUCCESS,
	    result: result
	  };
	}
	function companyGradeFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_GRADE_FAIL,
	    result: result
	  };
	}

	function getCompanyGrade(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: " /loan/companyLevel.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyGradeSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyGradeFail(result));
	      }
	    });
	  };
	}
	/*企业评级end*/

	/*地图模块begin*/
	var SMALLLOAN_MAP_SUCCESS = exports.SMALLLOAN_MAP_SUCCESS = 'SMALLLOAN_MAP_SUCCESS';
	var SMALLLOAN_MAP_FAIL = exports.SMALLLOAN_MAP_FAIL = 'SMALLLOAN_MAP_FAIL';

	function smallLoanMapSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: SMALLLOAN_MAP_SUCCESS,
	    result: result
	  };
	}
	function smallLoanMapFail(result) {
	  //请求失败调用方法
	  return {
	    type: SMALLLOAN_MAP_FAIL,
	    result: result
	  };
	}

	function getSmallLoanMap(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/loan/areaStatistic.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(smallLoanMapSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(smallLoanMapFail(result));
	      }
	    });
	  };
	}
	/*地图模块end*/

	/*贷款余额模块 此接口用于“贷款余额”，“贷款余额结构分布”，“贷款笔均折线图” begin*/
	var LOAN_BALANCE_SUCCESS = exports.LOAN_BALANCE_SUCCESS = 'LOAN_BALANCE_SUCCESS';
	var LOAN_BALANCE_FAIL = exports.LOAN_BALANCE_FAIL = 'LOAN_BALANCE_FAIL';

	function loanBalanceSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LOAN_BALANCE_SUCCESS,
	    result: result
	  };
	}

	function loanBalanceFail(result) {
	  //请求失败调用方法
	  return {
	    type: LOAN_BALANCE_FAIL,
	    result: result
	  };
	}

	function getLoanBalance(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/loan/balance.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(loanBalanceSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(loanBalanceFail(result));
	      }
	    });
	  };
	}
	/*贷款余额模块 此接口用于“贷款余额”，“贷款余额结构分布”，“贷款笔均折线图” end*/

	/*股东行业风险 begin*/
	var INDUSTRY_RISK_SUCCESS = exports.INDUSTRY_RISK_SUCCESS = 'INDUSTRY_RISK_SUCCESS';
	var INDUSTRY_RISK_FAIL = exports.INDUSTRY_RISK_FAIL = 'INDUSTRY_RISK_FAIL';

	function industryRiskSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INDUSTRY_RISK_SUCCESS,
	    result: result
	  };
	}

	function industryRiskFail(result) {
	  //请求失败调用方法
	  return {
	    type: INDUSTRY_RISK_FAIL,
	    result: result
	  };
	}

	function getIndustryRisk(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/loan/shareholderRisk.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(industryRiskSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(industryRiskFail(result));
	      }
	    });
	  };
	}
	/*股东行业风险  end*/

	/*大额借款人信息列表 begin*/
	var LARGE_LOAN_SUCCESS = exports.LARGE_LOAN_SUCCESS = 'LARGE_LOAN_SUCCESS';
	var LARGE_LOAN_FAIL = exports.LARGE_LOAN_FAIL = 'LARGE_LOAN_FAIL';

	function largeLoanSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LARGE_LOAN_SUCCESS,
	    result: result
	  };
	}

	function largeLoanFail(result) {
	  //请求失败调用方法
	  return {
	    type: LARGE_LOAN_FAIL,
	    result: result
	  };
	}

	function getLargeLoan(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/loan/largeLoanList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(largeLoanSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(largeLoanFail(result));
	      }
	    });
	  };
	}
	/*大额借款人信息列表  end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SmallLoanIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 808:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _AnnularPieChart = __webpack_require__(809);

	var _AnnularPieChart2 = _interopRequireDefault(_AnnularPieChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//三农、小微企业贷款余额占比
	var BalanceRatio = _react2.default.createClass({
	  displayName: 'BalanceRatio',

	  setParam: function setParam() {
	    var param = {
	      id: 'balance-ratio-char', //必传
	      height: '260px', //必传 带上单位
	      title: '贷款余额',
	      legendData: ['贷款余额总计', '小微企业贷款余额总计', '三农企业贷款余额总计'],
	      timeLineData: ['2002年1月', '2002年2月', '2002年3月', '2002年4月', '2002年5月', '2002年6月'],
	      data: []
	    };
	    return param;
	  },

	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'balance-radio mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '三农、小微企业贷款余额占比'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'chart-box' },
	          _react2.default.createElement(_AnnularPieChart2.default, { param: this.setParam() })
	        )
	      )
	    );
	  }
	});
	module.exports = BalanceRatio;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BalanceRatio.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 809:
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
													options: [{
																	series: [{
																					data: [{
																									value: 70,
																									name: '贷款余额总计'
																					}, {
																									value: 30,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}, {
																					data: [{
																									value: 29,
																									name: '小微企业贷款余额总计'
																					}, {
																									value: 71,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}, {

																					data: [{
																									value: 30,
																									name: '三农企业贷款余额总计'
																					}, {
																									value: 70,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}]
													}, {
																	series: [{

																					data: [{
																									value: 70,
																									name: '贷款余额总计'
																					}, {
																									value: 30,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}, {
																					data: [{
																									value: 29,
																									name: '小微企业贷款余额总计'
																					}, {
																									value: 71,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}, {

																					data: [{
																									value: 50,
																									name: '三农企业贷款余额总计'
																					}, {
																									value: 50,
																									name: 'invisible',
																									itemStyle: {
																													normal: {
																																	color: 'rgba(0,0,0,0)'
																													},
																													emphasis: {
																																	color: 'rgba(0,0,0,0)'
																													}
																									}
																					}]
																	}]
													}]
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

/***/ 816:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(817);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _P2PIndexAction = __webpack_require__(819);

	var P2PIndexActionCreaters = _interopRequireWildcard(_P2PIndexAction);

	var _setHeight = __webpack_require__(721);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(740);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _devTrend = __webpack_require__(820);

	var _devTrend2 = _interopRequireDefault(_devTrend);

	var _volume = __webpack_require__(823);

	var _volume2 = _interopRequireDefault(_volume);

	var _map = __webpack_require__(824);

	var _map2 = _interopRequireDefault(_map);

	var _areaRanking = __webpack_require__(825);

	var _areaRanking2 = _interopRequireDefault(_areaRanking);

	var _problemScale = __webpack_require__(827);

	var _problemScale2 = _interopRequireDefault(_problemScale);

	var _IndustrySentiment = __webpack_require__(828);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _netCreditContrast = __webpack_require__(829);

	var _netCreditContrast2 = _interopRequireDefault(_netCreditContrast);

	var _netCredit = __webpack_require__(826);

	var _netCredit2 = _interopRequireDefault(_netCredit);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//网贷平台数据展示

	//行业人气
	//上海区域发展指数排名
	//成交量和综合利率
	var Immutable = __webpack_require__(776);
	//p2p行业监测
	//网贷对比
	//问题平台比例
	//地图
	//新增平台发展趋势
	var P2PIndex = _react2.default.createClass({
	    displayName: 'P2PIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getp2pindexRequest = this.props.getp2pindexRequest;

	        var jsonData = {};
	        getp2pindexRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.indexChartRequest, this.props.indexChartResult);
	        if (!isEqual) {
	            var indexChartRequest = nextProps.indexChartRequest;
	            var indexChartResult = nextProps.indexChartResult;

	            if (indexChartRequest == true) {
	                if (indexChartResult.success) {
	                    console.log(indexChartResult, "redux测试成功=================indexChartRequest阿诗玛首页测试");
	                    this.setState({ listData: indexChartResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        var parm = this.state.listData;
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-index-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-top clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-l' },
	                        _react2.default.createElement(_devTrend2.default, { deveTrendData: this.state.listData }),
	                        _react2.default.createElement(_volume2.default, { volumeData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_map2.default, { mapData: this.state.listData }),
	                    _react2.default.createElement(_areaRanking2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-bom clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bom-l' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'bom-l-t' },
	                            _react2.default.createElement(_problemScale2.default, { problemScaleData: this.state.listData }),
	                            _react2.default.createElement(_IndustrySentiment2.default, { industrySentimentData: this.state.listData })
	                        ),
	                        _react2.default.createElement(_netCreditContrast2.default, { netCreditContrastData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_netCredit2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        indexChartRequest: state.IndexChartAll.request,
	        indexChartResult: state.IndexChartAll.result,

	        // devTrendRequest:state.DevTrend.request,
	        // devTrendResult: state.DevTrend.result,

	        // volumeRequest:state.Volume.request,
	        // volumeResult: state.Volume.result,

	        // mapRequest:state.Map.request,
	        // mapResult: state.Map.result,

	        areaRankingRequest: state.AreaRanking.request,
	        areaRankingResult: state.AreaRanking.result,

	        // problemScaleRequest:state.ProblemScale.request,
	        // problemScaleResult: state.ProblemScale.result,

	        // industrySentimentRequest:state.IndustrySentiment.request,
	        // industrySentimentResult: state.IndustrySentiment.result,

	        // netCreditContrastRequest:state.NetCreditContrast.request,
	        // netCreditContrastResult: state.NetCreditContrast.result,

	        netCreditRequest: state.NetCredit.request,
	        netCreditResult: state.NetCredit.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 820:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(798);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.deveTrendData, this.props.deveTrendData);
	        if (!isEqual) {
	            var deveTrendData = nextProps.deveTrendData;

	            var optionParm = {
	                "color": ["#12b5b0", "#e24441"],
	                "legend": ["上海新增", "上海累计"],
	                "legendShow": true,
	                "legendRight": "30",
	                "barName": ["上海新增"],
	                "lineName": ["上海累计"],
	                "yFlag": "",
	                "barWidth": 20,
	                "xAxis": deveTrendData.newly.xAxis,
	                "yAxisName": ["平台数量(家数)", ""],
	                "symbolSize": 5,
	                "axisLabelR": false,
	                "axisLineR": false,
	                "series": {
	                    "bar": [deveTrendData.newly.series.bar],
	                    "line": [deveTrendData.newly.series.line]
	                }
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartOption, style: { height: '300px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-l-t radius4', id: 'devTrend' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海新增平台发展趋势'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "devTrend.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 823:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(798);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var volume = _react2.default.createClass({
	    displayName: 'volume',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.volumeData, this.props.volumeData);
	        if (!isEqual) {
	            var volumeData = nextProps.volumeData;

	            var optionParm = {
	                "color": ["#12b5b0", "#e24441"],
	                "legend": ["成交量", "综合利率"],
	                "legendShow": true,
	                "legendRight": "30",
	                "barName": ["成交量"],
	                "lineName": ["综合利率"],
	                "yFlag": "",
	                "barWidth": 20,
	                "yAxisName": ["成交量", "综合利率"],
	                "symbolSize": 5,
	                "axisLabelR": false,
	                "axisLineR": false,
	                "xAxis": volumeData.bargain.xAxis,
	                "series": {
	                    "bar": [volumeData.bargain.series.bar],
	                    "line": [volumeData.bargain.series.line]
	                }
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartOption, style: { height: '300px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-l-b radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '成交量和综合利率'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = volume;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "volume.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 828:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(756);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	    color: ["#00b7ee", "#f8b551"],
	    title: "行业人气",
	    titleX: "left", //
	    boxId: "chartMap",
	    symbolSize: 5,
	    legendIsShow: true,
	    yFlag: "万人", //
	    yAxisName: "",
	    legendRight: "10%",
	    legendTop: "-10",
	    legend: ["投资人", "借款人"],
	    series: []
	};
	var IndustrySentiment = _react2.default.createClass({
	    displayName: 'IndustrySentiment',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)], [Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]];

	        return baseParm;
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: ' mod bom-l-t-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '行业人气'
	                )
	            ),
	            _react2.default.createElement(_LineChart2.default, {
	                option: this.setParm(),
	                style: { height: '205px', width: '100%' } })
	        );
	    }
	});

	module.exports = IndustrySentiment;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustrySentiment.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 842:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(843);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(721);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(740);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _BusinessTypes = __webpack_require__(845);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(848);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(849);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(852);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _PlatformRun = __webpack_require__(851);

	var _PlatformRun2 = _interopRequireDefault(_PlatformRun);

	var _PlatformBase = __webpack_require__(850);

	var _PlatformBase2 = _interopRequireDefault(_PlatformBase);

	var _RaiseIndexAction = __webpack_require__(1277);

	var RaiseIndexCreaters = _interopRequireWildcard(_RaiseIndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//平台运营情况
	//6月上海各类众筹平台新增项目数
	//业务类型

	var Immutable = __webpack_require__(776);
	//众筹监测
	//平台基本情况
	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	var RaiseIndex = _react2.default.createClass({
	    displayName: 'RaiseIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getlistRequest = this.props.getlistRequest;

	        var jsonData = {};
	        getlistRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.ListRequest, this.props.ListResult);
	        if (!isEqual) {
	            var ListRequest = nextProps.ListRequest;
	            var ListResult = nextProps.ListResult;

	            if (ListRequest == true) {
	                if (ListResult.success) {
	                    console.log(ListResult, "redux测试成功=================ListRequest");
	                    this.setState({ listData: ListResult }, function () {});
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
	            { className: 'raise-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '众筹监测', placeHolder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'raise-index-left' },
	                    _react2.default.createElement(_BusinessTypes2.default, this.props),
	                    _react2.default.createElement(_InvestPeople2.default, this.props),
	                    _react2.default.createElement(_PlatformBase2.default, { platFormBaseData: this.state.listData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'raise-index-right' },
	                    _react2.default.createElement(_NewProject2.default, this.props),
	                    _react2.default.createElement(_RaiseMount2.default, this.props),
	                    _react2.default.createElement(_PlatformRun2.default, { platFormRunBaseData: this.state.listData })
	                )
	            )
	        );
	    }
	});
	// module.exports = RaiseIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        businessTypesRequest: state.BusinessTypes.request,
	        businessTypesResult: state.BusinessTypes.result,

	        investPeopleRequest: state.InvestPeople.request,
	        investPeopleResult: state.InvestPeople.result,

	        newProjectRequest: state.NewProject.request,
	        newProjectResult: state.NewProject.result,

	        raiseMountRunRequest: state.RaiseMount.request,
	        raiseMountResult: state.RaiseMount.result,

	        ListRequest: state.List.request,
	        ListResult: state.List.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(RaiseIndexCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RaiseIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 845:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(755);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	var BusinessTypes = _react2.default.createClass({
	    displayName: 'BusinessTypes',


	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getbusinessRequest = this.props.getbusinessRequest;

	        var jsonData = {};
	        getbusinessRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.businessTypesRequest, this.props.businessTypesResult);
	        if (!isEqual) {
	            var businessTypesRequest = nextProps.businessTypesRequest;
	            var businessTypesResult = nextProps.businessTypesResult;

	            if (businessTypesRequest == true) {
	                if (businessTypesResult.success) {
	                    console.log(businessTypesResult, "redux测试成功=================businessTypesRequest");
	                    var option = {
	                        "color": ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	                        "title": "",
	                        "xtitle": "",
	                        "legend": businessTypesResult.content.legend,
	                        "legendShow": true,
	                        "legendOrient": "vertical",
	                        "legendLeft": "",
	                        "legendTop": "middle",
	                        "legendRight": "20%",
	                        "seriesName": "企业数",
	                        "radius": "70%",
	                        "lable": { normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['40%', '50%'],
	                        "series": businessTypesResult.content.series
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartData) {
	            console.log("测试");
	            chartBox = _react2.default.createElement(_BasePie2.default, { option: this.state.chartData, style: { height: '400px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod left-top radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '业务类型分布'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = BusinessTypes;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessTypes.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 848:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(836);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var InvestPeople = _react2.default.createClass({
		displayName: 'InvestPeople',

		getInitialState: function getInitialState() {
			return {
				chartData: null
			};
		},
		componentDidMount: function componentDidMount() {
			var getinvestPeopleRequest = this.props.getinvestPeopleRequest;

			var jsonData = {};
			getinvestPeopleRequest(jsonData);
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.investPeopleRequest, this.props.investPeopleResult);
			if (!isEqual) {
				var investPeopleRequest = nextProps.investPeopleRequest;
				var investPeopleResult = nextProps.investPeopleResult;

				if (investPeopleRequest == true) {
					if (investPeopleResult.success) {
						console.log(investPeopleResult, "redux测试成功=================investPeopleRequest");
						var option = {
							title: "平台交易量走势",
							titleX: "center",
							color: ["#e14340"],
							barWidth: 30,
							yAxisName: "万人次",
							gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
							yFlag: "", //y轴单位
							splitLineShow: false,
							legendShow: false,
							legend: ["投资人/次"],
							gridTop: "10%",
							gridBottom: "5%",
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
							xAxis: investPeopleResult.content.xAxis,
							series: [investPeopleResult.content.series]
						};
						this.setState({ chartData: option });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBox = "";
			if (this.state.chartData) {
				console.log("测试");
				chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '500px', width: '80%', margin: '0px auto' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'mod left-middle radius4' },
				_react2.default.createElement(
					'div',
					{ className: 'mod-title' },
					_react2.default.createElement(
						'h3',
						null,
						'6月上海各类众筹平台新增项目的投资人次'
					)
				),
				chartBox
			);
		}
	});

	module.exports = InvestPeople;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InvestPeople.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

	var _BarChart = __webpack_require__(836);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var NewProject = _react2.default.createClass({
		displayName: 'NewProject',

		getInitialState: function getInitialState() {
			return {
				chartData: null
			};
		},
		componentDidMount: function componentDidMount() {
			var getnewProjectRequest = this.props.getnewProjectRequest;

			var jsonData = {};
			getnewProjectRequest(jsonData);
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.newProjectRequest, this.props.newProjectResult);
			if (!isEqual) {
				var newProjectRequest = nextProps.newProjectRequest;
				var newProjectResult = nextProps.newProjectResult;

				if (newProjectRequest == true) {
					if (newProjectResult.success) {
						console.log(newProjectResult, "redux测试成功=================newProjectRequest");
						var option = {
							title: "平台交易量走势",
							titleX: "center",
							color: ["#e14340"],
							barWidth: 30,
							yAxisName: "",
							gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
							yFlag: "", //y轴单位
							splitLineShow: false,
							gridShow: false,
							legendShow: false,
							gridTop: "10%",
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
							legendBottom: "5%",
							legend: ["投资人/次"],
							xAxis: newProjectResult.content.xAxis,
							series: [newProjectResult.content.series]
						};
						this.setState({ chartData: option });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBox = "";
			if (this.state.chartData) {
				console.log("测试");
				chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '450px', width: '80%', margin: '0px auto' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'mod right-top radius4' },
				_react2.default.createElement(
					'div',
					{ className: 'mod-title' },
					_react2.default.createElement(
						'h3',
						null,
						'6月上海各类众筹平台新增项目数'
					)
				),
				chartBox
			);
		}
	});

	module.exports = NewProject;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "NewProject.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 850:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
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

	var Immutable = __webpack_require__(776);
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

	      console.log(platFormRunBaseData, "======================platFormRunBaseData======================");
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
	                  if (item.fundingBusinessType == "0") {
	                    item.fundingBusinessType = "权益型";
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
	                        item.fundingBusinessType
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
	                        item.fundingBusinessType
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

/***/ 852:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(836);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var RaiseMount = _react2.default.createClass({
		displayName: 'RaiseMount',

		getInitialState: function getInitialState() {
			return {
				chartData: null
			};
		},
		componentDidMount: function componentDidMount() {
			var getraiseMountRunRequest = this.props.getraiseMountRunRequest;

			var jsonData = {};
			getraiseMountRunRequest(jsonData);
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.raiseMountRunRequest, this.props.raiseMountResult);
			if (!isEqual) {
				var raiseMountRunRequest = nextProps.raiseMountRunRequest;
				var raiseMountResult = nextProps.raiseMountResult;

				if (raiseMountRunRequest == true) {
					if (raiseMountResult.success) {
						console.log(raiseMountResult, "redux测试成功=================raiseMountRunRequest");
						var option = {
							title: "平台交易量走势",
							titleX: "center",
							color: ["#e14340"],
							barWidth: 30,
							yAxisName: "亿元",
							yFlag: "", //y轴单位
							gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
							splitLineShow: false,
							legendShow: false,
							gridTop: "10%",
							gridBottom: "5%",
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
							legend: ["投资人/次"],
							xAxis: raiseMountResult.content.xAxis,
							series: [raiseMountResult.content.series]
						};
						this.setState({ chartData: option });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBox = "";
			if (this.state.chartData) {
				console.log("测试");
				chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '500px', width: '80%', margin: '0px auto' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'mod right-middle radius4' },
				_react2.default.createElement(
					'div',
					{ className: 'mod-title' },
					_react2.default.createElement(
						'h3',
						null,
						'6月上海各类众筹平台新增项目数的成功筹资金额'
					)
				),
				chartBox
			);
		}
	});

	module.exports = RaiseMount;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RaiseMount.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1276:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.selectval = selectval;
	/*园区*/
	var SELECT_NAME = exports.SELECT_NAME = 'SELECT_NAME';

	function selectval(data) {
	  return {
	    type: SELECT_NAME,
	    data: data
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "selectvalAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1277:
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
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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

/***/ }

})