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

	var _selectvalAction = __webpack_require__(1293);

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
	    val: state.selectval.val
	  };
	}, { selectval: _selectvalAction.selectval })(Menu);

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
	            balanceDistrData: {},
	            GuaraEachAverData: {}
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
	        var GuaraEachAverData = {
	            xAxis: [],
	            series: []
	        };

	        var conLength = content.length;
	        for (var i = 0; i < conLength; i++) {
	            var year = content[i].year;
	            var balance = content[i].amount; //贷款余额
	            var dataArr = [i, i, balance];

	            balanceArr.push(balance);
	            guaraDutyBalaData.xAxis.push(year);
	            guaraDutyBalaData.data.push(dataArr);

	            GuaraEachAverData.xAxis.push(year);
	            GuaraEachAverData.series.push(content[i].number);
	        }
	        var balanceMax = Math.max.apply(null, balanceArr);
	        var eachYAxis = balanceMax / 5;
	        for (var j = 0; j < 5; j++) {
	            guaraDutyBalaData.yAxis.push(eachYAxis * j);
	        }
	        console.log(GuaraEachAverData, '笔均折线图');
	        this.setState({ guaraDutyBalaData: guaraDutyBalaData, GuaraEachAverData: GuaraEachAverData });
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
	                    _react2.default.createElement(_BalanceDistribute2.default, this.props),
	                    _react2.default.createElement(_GuaraEachAverage2.default, { GuaraEachAverData: this.state.GuaraEachAverData })
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

/***/ 782:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(757);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//担保笔均折线图
	var GuaraEachAverage = _react2.default.createClass({
	    displayName: 'GuaraEachAverage',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var eachAverageData = nextProps.eachAverageData;

	        this.dataFomat(eachAverageData);
	        // var isEqual=Immutable.is(nextProps.eachAverageData, this.props.eachAverageData);
	        //     console.log(nextProps,isEqual,'打印看看2222222222222')
	        //     if(!isEqual){
	        //      const {eachAverageData}=nextProps
	        //      this.dataFomat(eachAverageData)
	        //   }
	    },
	    dataFomat: function dataFomat(data) {
	        var option = {
	            color: ["#00b8ee", "#f8b551"],
	            title: "",
	            titleX: "left",
	            boxId: "each-average-chart",
	            symbolSize: 10,
	            legendIsShow: true,
	            yFlag: "",
	            legendRight: "center",
	            legendTop: '1%',
	            legendPadding: [0, 0, 0, 0],
	            grid: { top: '10%', left: '5%', right: '5%', bottom: '5%', containLabel: true },
	            yAxisName: "",
	            legend: ["贷款总余额/总笔数"],
	            xAxis: ['2013', '2014', '2015', '2016', '2017', '2018'], //data.xAxis,
	            series: [[0, 1, 2, 3, 4]] //[data.series]
	        };
	        this.setState({ option: option });
	    },
	    // setParm:function(){
	    //   const option ={
	    //     color:["#00b8ee","#f8b551"],
	    //         title:"",
	    //         titleX:"left",
	    //         boxId:"each-average-chart",
	    //         symbolSize:10,
	    //         legendIsShow:true,
	    //         yFlag:"",
	    //         legendRight:"center",
	    //         legendTop:'1%',
	    //         legendPadding:[0,0,0,0],
	    //         grid:{top:'10%',left: '5%',right: '5%',bottom: '5%',containLabel: true},
	    //         yAxisName:"",
	    //         legend:["贷款总余额/总笔数"],
	    //         xAxis:['2013', '2014', '2015', '2016', '2017', '2018'],
	    //         series:[[0,1,2,3,4]]
	    //     }
	    //       return option;
	    // },
	    render: function render() {
	        var bbdLine = "";
	        if (this.state.option) {
	            bbdLine = _react2.default.createElement(_LineChart2.default, { option: this.state.option, style: { height: '272px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'each-average mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '贷款笔均折线图'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'chart-box' },
	                    bbdLine
	                )
	            )
	        );
	    }
	});
	module.exports = GuaraEachAverage;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "GuaraEachAverage.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	                    _react2.default.createElement(_EquityL2.default, null),
	                    _react2.default.createElement(_EquityM2.default, null),
	                    _react2.default.createElement(_EquityR2.default, null)
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

/***/ 790:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(791);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var CompanyProgress = _react2.default.createClass({
		displayName: 'CompanyProgress',

		getInitialState: function getInitialState() {
			return {
				list: []
			};
		},
		componentDidMount: function componentDidMount() {},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.companyProgressData, this.props.companyProgressData);
			if (!isEqual) {
				var companyProgressData = nextProps.companyProgressData;

				for (var i = 0; i < companyProgressData.length; i++) {
					companyProgressData.shareholders = companyProgressData[i].shareholders.join("、");
				}
				this.setState({ list: companyProgressData });
			}
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: ' top-left-l' },
				_react2.default.createElement(
					'div',
					{ className: 'list-header' },
					'QDLP试点企业最新进展'
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
										'拟用名'
									),
									_react2.default.createElement(
										'th',
										{ width: '20%' },
										'股东方'
									),
									_react2.default.createElement(
										'th',
										{ width: '20%' },
										'获批额度($)',
										_react2.default.createElement('i', { className: 'iconfont icon-desc' })
									),
									_react2.default.createElement(
										'th',
										{ width: '25%' },
										'近期进展',
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
							{ className: 'mt-table mt-table-center table-border-b wtyh-table' },
							_react2.default.createElement(
								'tbody',
								null,
								this.state.list.map(function (item, index) {
									{
										var num = index + 1;
										if (index % 2) {
											return _react2.default.createElement(
												'tr',
												{ className: 'even' },
												_react2.default.createElement(
													'td',
													{ width: '10%', className: 'talign-center' },
													num
												),
												_react2.default.createElement(
													'td',
													{ width: '25%' },
													_react2.default.createElement(
														'span',
														{ className: 'word-limit-5', 'data-tip': item.companyName },
														item.companyName
													)
												),
												_react2.default.createElement(
													'td',
													{ width: '20%' },
													_react2.default.createElement(
														'span',
														{ className: 'word-limit-5', 'data-tip': item.shareholders },
														item.shareholders
													)
												),
												_react2.default.createElement(
													'td',
													{ width: '20%' },
													item.quatas,
													'亿'
												),
												_react2.default.createElement(
													'td',
													{ width: '25%' },
													item.progress
												)
											);
										} else {
											return _react2.default.createElement(
												'tr',
												{ className: 'odd' },
												_react2.default.createElement(
													'td',
													{ width: '10%', className: 'talign-center' },
													num
												),
												_react2.default.createElement(
													'td',
													{ width: '25%' },
													_react2.default.createElement(
														'span',
														{ className: 'word-limit-5', 'data-tip': item.companyName },
														item.companyName
													)
												),
												_react2.default.createElement(
													'td',
													{ width: '20%' },
													_react2.default.createElement(
														'span',
														{ className: 'word-limit-5', 'data-tip': item.shareholders },
														item.shareholders
													)
												),
												_react2.default.createElement(
													'td',
													{ width: '20%' },
													item.quatas,
													'亿'
												),
												_react2.default.createElement(
													'td',
													{ width: '25%' },
													item.progress
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

	module.exports = CompanyProgress;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyProgress.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 792:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".privateFund-index .middle-l .content,\r\n.privateFund-index .middle-r .content {\r\n\theight: 570px;\r\n}\r\n\r\n.privateFund-index .middle-l .content .content-l {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .middle-l .content .content-r {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .middle-r .content .content-l {\r\n\twidth: 40%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index  .middle-r .content .content-r {\r\n\twidth: 60%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark {\r\n\tmargin-top: 50px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark table {\r\n\theight: 100px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark table {\r\n\twidth: 100%;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark tbody {\r\n\tbackground: #3a4352;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark .padding-l20 {\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark .word-limit-5 {\r\n\r\n\t/*width: 200px;*/\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark tbody tr {\r\n\tborder-bottom: 1px #555c6c solid;\r\n\ttext-align: left;\r\n}\r\n\r\n.privateFund-index .top-left-l .mod-content,\r\n.privateFund-index .top-r .mod-content {\r\n\tpadding: 10px 15px 50px 15px;\r\n}\r\n\r\n.privateFund-index .top-left-l .table-content,\r\n.privateFund-index .top-r .table-content {\r\n\theight: 460px;\r\n\toverflow: auto;\r\n}\r\n\r\n.privateFund-index .top-left-l .table-content table,\r\n.privateFund-index .top-r .table-content table {\r\n\r\n\t/*height: 100%*/\r\n}\r\n\r\n.privateFund-index .top-left-l  thead th,\r\n.privateFund-index .top-r  thead th {\r\n\ttext-align: left;\r\n\theight: 40px;\r\n\tpadding: 0px !important;\r\n}\r\n\r\n.privateFund-index .top-left-l tbody td,\r\n.privateFund-index .top-r tbody td {\r\n\ttext-align: left;\r\n\tpadding: 10px 0px !important;\r\n}\r\n\r\n.privateFund-index .top-left-l .mt-table th {\r\n\tpadding: 0px;\r\n}\r\n\r\n.padding-l20 {\r\n\tpadding-left: 20px !important;\r\n}", ""]);

	// exports


/***/ },

/***/ 793:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(791);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _PieChart = __webpack_require__(780);

	var _PieChart2 = _interopRequireDefault(_PieChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var CompanyQuality = _react2.default.createClass({
	  displayName: 'CompanyQuality',

	  getInitialState: function getInitialState() {
	    return {
	      pieData: null,
	      listData: []
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.companyQuality, this.props.companyQuality);
	    if (!isEqual) {
	      var companyQuality = nextProps.companyQuality;
	      //列表数据格式化

	      var _listData = [],
	          _legendData = [],
	          pieData = [];

	      for (var item in companyQuality) {
	        var items = {
	          type: item,
	          totleNum: companyQuality[item].length,
	          companyList: companyQuality[item].join("、")
	        };

	        var _setPieData = {
	          value: companyQuality[item].length,
	          name: item
	        };

	        _listData.push(items);
	        _legendData.push(item);
	        pieData.push(_setPieData);
	      }

	      var _setParm = {
	        id: 'small-loan-company-chart', //必传
	        color: ['#efd79b', '#e24340'],
	        height: '300px', //必传 带上单位
	        title: '',
	        legendBottom: "0",
	        legendData: _legendData,
	        data: pieData
	      };
	      this.setState({ listData: _listData });
	      this.setState({ pieData: _setParm });
	    }
	  },
	  render: function render() {
	    var chartBox = "";
	    if (this.state.pieData) {
	      console.log("测试");
	      chartBox = _react2.default.createElement(_PieChart2.default, { param: this.state.pieData });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: ' top-left-r' },
	      _react2.default.createElement(
	        'div',
	        { className: 'list-header' },
	        '试点企业性质'
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'content' },
	        chartBox,
	        _react2.default.createElement(
	          'div',
	          { className: 'pic-remark' },
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
	                  { style: { width: "40%" }, className: 'padding-l20' },
	                  '类型'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { style: { width: "20%" } },
	                  '数量'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { style: { width: "40%" } },
	                  '机构名称'
	                )
	              )
	            ),
	            _react2.default.createElement(
	              'tbody',
	              null,
	              this.state.listData.map(function (item, index) {
	                {
	                  return _react2.default.createElement(
	                    'tr',
	                    null,
	                    _react2.default.createElement(
	                      'td',
	                      { className: 'padding-l20' },
	                      item.type
	                    ),
	                    _react2.default.createElement(
	                      'td',
	                      null,
	                      item.totleNum
	                    ),
	                    _react2.default.createElement(
	                      'td',
	                      null,
	                      _react2.default.createElement(
	                        'span',
	                        { className: 'word-limit-5', 'data-tip': item.companyList },
	                        item.companyList
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

	module.exports = CompanyQuality;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 794:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(791);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var QDLPQuality = _react2.default.createClass({
	    displayName: 'QDLPQuality',


	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getQDLPQualityRequest = this.props.getQDLPQualityRequest;

	        var jsonData = {};
	        getQDLPQualityRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.QDLPQualityRequest, this.props.QDLPQualityResult);
	        if (!isEqual) {
	            var QDLPQualityRequest = nextProps.QDLPQualityRequest;
	            var QDLPQualityResult = nextProps.QDLPQualityResult;

	            if (QDLPQualityRequest == true) {
	                if (QDLPQualityResult.success) {
	                    this.setState({ listData: QDLPQualityResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                'QFLP试点企业最新进展'
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
	                                    { width: '30%' },
	                                    '试点企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '总规模($)',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '美元部分($)',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '投资合计(￥)',
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
	                        { className: 'mt-table mt-table-center table-border-b wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal
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

	module.exports = QDLPQuality;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "QDLPQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 795:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(791);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(756);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var FundClass = _react2.default.createClass({
	    displayName: 'FundClass',

	    getInitialState: function getInitialState() {
	        return {
	            pieLeft: null,
	            pieRight: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getFundClassRequest = this.props.getFundClassRequest;

	        var jsonData = {};
	        getFundClassRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.fundClassRequest, this.props.fundClassResult);
	        if (!isEqual) {
	            var fundClassRequest = nextProps.fundClassRequest;
	            var fundClassResult = nextProps.fundClassResult;

	            if (fundClassRequest == true) {
	                if (fundClassResult.success) {
	                    var _setPieLegend = [],
	                        _setPieData = [],
	                        _setRosePieLegend = [],
	                        _setRosePieData = [];
	                    for (var i = 0; i < fundClassResult.content.length; i++) {
	                        var items = {};
	                        _setPieLegend.push(fundClassResult.content[i].typeName);
	                        if (fundClassResult.content[i].typeName == "股权投资基金") {
	                            for (var j = 0; j < fundClassResult.content[i].children.length; j++) {
	                                _setRosePieLegend.push(fundClassResult.content[i].children[j].typeName);
	                                var itemsChild = {
	                                    value: fundClassResult.content[i].children[j].amount,
	                                    name: fundClassResult.content[i].children[j].typeName
	                                };
	                                _setRosePieData.push(itemsChild);
	                            }

	                            items = {
	                                value: fundClassResult.content[i].amount,
	                                name: fundClassResult.content[i].typeName,
	                                selected: true
	                            };
	                        } else {
	                            items = {
	                                value: fundClassResult.content[i].amount,
	                                name: fundClassResult.content[i].typeName
	                            };
	                        }

	                        _setPieData.push(items);
	                    }
	                    var _setPieLeft = {
	                        "color": ["#e14340", "#deab61"],
	                        "title": "私募基金总分类",
	                        "xtitle": "",
	                        "titleLeft": "18%",
	                        "titleTop": "60%",
	                        "legend": _setPieLegend,
	                        "legendShow": true,
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "基金类型",
	                        "radius": "60%",
	                        "lable": { normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '35%'],
	                        "series": _setPieData
	                    };

	                    var _setPieRight = {
	                        "color": ["#ff9b93", "#d58469", "#8bcaad", "#6b9f88", "#dfab62", "#c09f9a", "f7cf8a"],
	                        "title": "私募股权基金细分",
	                        "xtitle": "",
	                        "titleLeft": "19%",
	                        "titleTop": "60%",
	                        "legend": _setRosePieLegend,
	                        "legendShow": true,
	                        "roseType": "radius", //是否玫瑰型
	                        "radius": [20, 110],
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "基金类型",
	                        "lable": { normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '35%'],
	                        "series": _setRosePieData
	                    };

	                    this.setState({ pieLeft: _setPieLeft });
	                    this.setState({ pieRight: _setPieRight });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var pieLeftBox = "",
	            pieRightBox = "";
	        if (this.state.pieLeft) {
	            pieLeftBox = _react2.default.createElement(_BasePie2.default, { option: this.state.pieLeft, style: { height: '550px', width: '100%' } });
	        }
	        if (this.state.pieRight) {
	            pieRightBox = _react2.default.createElement(_BasePie2.default, { option: this.state.pieRight, style: { height: '550px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                '私募基金分类'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-l' },
	                    pieLeftBox
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-r' },
	                    pieRightBox
	                )
	            )
	        );
	    }
	});

	module.exports = FundClass;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FundClass.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 832:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(833);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var BaseMsg = _react2.default.createClass({
		displayName: 'BaseMsg',

		getInitialState: function getInitialState() {
			return {
				listData: []
			};
		},
		componentDidMount: function componentDidMount() {
			var getbaseMsgRequest = this.props.getbaseMsgRequest;

			getbaseMsgRequest({ "platName": "" });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.baseMsgRequest, this.props.baseMsgResult);
			if (!isEqual) {
				var baseMsgRequest = nextProps.baseMsgRequest;
				var baseMsgResult = nextProps.baseMsgResult;

				if (baseMsgRequest == true) {
					if (baseMsgResult.success) {
						var _setParm = [{
							address: "上海浦东新区陆家嘴环路1333号",
							legalPeople: "郑森",
							platName: "陆金所",
							registerOffice: "上海市工商局",
							companyName: "上海陆家嘴国际金融资产交易市场股份有限公司",
							verifiedTime: "2011-11-9",
							capital: "83667",
							companyCode: "79361521",
							openedTime: "2011-11-9"
						}];
						this.setState({ listData: _setParm });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'left-m radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'基本信息'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'list-items' },
					_react2.default.createElement(
						'table',
						{ className: 'mt-table wtyh-table' },
						this.state.listData.map(function (item, index) {
							{

								return _react2.default.createElement(
									'tbody',
									null,
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'平台名称'
										),
										_react2.default.createElement(
											'td',
											null,
											item.platName
										),
										_react2.default.createElement('td', null),
										_react2.default.createElement('td', null)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'公司名称：'
										),
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'span',
												{ className: 'word-limit-5', 'data-tip': item.companyName },
												item.companyName
											)
										),
										_react2.default.createElement('td', null),
										_react2.default.createElement('td', null)
									),
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'法人代表：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.legalPeople
										),
										_react2.default.createElement(
											'td',
											null,
											'注册资本：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.capital
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'注册地址'
										),
										_react2.default.createElement(
											'td',
											null,
											_react2.default.createElement(
												'span',
												{ className: 'word-limit-5', 'data-tip': item.address },
												item.address
											),
											' '
										),
										_react2.default.createElement('td', null),
										_react2.default.createElement('td', null)
									),
									_react2.default.createElement(
										'tr',
										{ className: 'odd-blackbg-line' },
										_react2.default.createElement(
											'td',
											null,
											'开业日期：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.openedTime
										),
										_react2.default.createElement(
											'td',
											null,
											'核准日期：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.verifiedTime
										)
									),
									_react2.default.createElement(
										'tr',
										null,
										_react2.default.createElement(
											'td',
											null,
											'登记机关：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.registerOffice
										),
										_react2.default.createElement(
											'td',
											null,
											'组织机构代码：'
										),
										_react2.default.createElement(
											'td',
											null,
											item.companyCode
										)
									),
									' '
								);
							}
						})
					)
				)
			);
		}
	});

	module.exports = BaseMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 836:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(833);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(837);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	var _LineChart = __webpack_require__(757);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var CoreData = _react2.default.createClass({
		displayName: 'CoreData',


		getInitialState: function getInitialState() {
			return {
				listData: [],
				coreBarData: null,
				coreTrendData: null,
				coreBalanceData: null
			};
		},
		componentDidMount: function componentDidMount() {
			var _props = this.props;
			var getcoreDataRequest = _props.getcoreDataRequest;
			var getCoreBarDataRequest = _props.getCoreBarDataRequest;
			var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
			var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

			getcoreDataRequest({ "platName": "" });
			getCoreBarDataRequest({ "platName": "" });
			getCoreTrendDataRequest({ "platName": "" });
			getCoreBalanceDataRequest({ "platName": "" });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.coreDataRequest, this.props.coreDataResult);
			if (!isEqual) {
				var coreDataRequest = nextProps.coreDataRequest;
				var coreDataResult = nextProps.coreDataResult;

				if (coreDataRequest == true) {
					if (coreDataResult.success) {
						coreDataResult.content = {
							"待还借款人数": "21564",
							"最大单户借款额": "1213.65",
							"最大十户借款额": "7984.36",
							"近30日资产流入": "952638",
							"贷款余额": "18",
							"待收投资人数": "21564",
							"累计成交量": "31.21",
							"平均利率": "6.532"
						};

						var _setParm = [];
						for (var item in coreDataResult.content) {
							var items = {
								name: item,
								value: coreDataResult.content[item]
							};
							_setParm.push(items);
						}
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
							title: "平台交易量走势",
							titleX: "center",
							color: ["#e14340"],
							titleShow: true,
							barWidth: 15,
							yAxisName: "万元",
							yFlag: "", //y轴单位
							gridBottom: '0',
							gridTop: '15%',
							legend: ["成交量"],
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
							yAxisName: "金额(亿元)",
							legendRight: "30",
							legend: ["投资人", "借款人"],
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
								_react2.default.createElement(
									'tbody',
									null,
									this.state.listData.map(function (item, index) {
										{
											if (index % 2) {
												return _react2.default.createElement(
													'tr',
													null,
													_react2.default.createElement(
														'td',
														null,
														item.name
													),
													_react2.default.createElement(
														'td',
														null,
														item.value,
														'亿元'
													)
												);
											} else {
												return _react2.default.createElement(
													'tr',
													{ className: 'odd-blackbg-line' },
													_react2.default.createElement(
														'td',
														null,
														item.name
													),
													_react2.default.createElement(
														'td',
														null,
														item.value,
														'亿元'
													)
												);
											}
										}
									})
								)
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

/***/ 840:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(833);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	var RankPic = _react2.default.createClass({
	    displayName: 'RankPic',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/guanliantu.js");
	        var getrankPicRequest = this.props.getrankPicRequest;

	        var jsonData = {};
	        getrankPicRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.rankPicRequest, this.props.rankPicResult);
	        if (!isEqual) {
	            var rankPicRequest = nextProps.rankPicRequest;
	            var rankPicResult = nextProps.rankPicResult;

	            if (rankPicRequest == true) {
	                if (rankPicResult.success) {
	                    console.log("===================================图谱数据测试成功~！============================");
	                } else {
	                    //错误后提示
	                }
	            }
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
	                        { className: 'condition', style: { display: "none" } },
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
	                                { className: 'btn' },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-modal' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'company-title' },
	                        '成都中建明城投资有限公司'
	                    ),
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
	                                    '注册资本'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '500万'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '登记状态'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '在营开业企业'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方法人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '386'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方自然人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '289'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '自然人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '21'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '法人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '8'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '子股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '0'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'a',
	                        { href: '', className: 'see-detail' },
	                        '查看详情'
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box' },
	                    _react2.default.createElement('input', { type: 'hidden', id: 'GLOBAL', 'data-url': '', 'data-sidenav': '3', 'data-taoxi': 'S', 'data-isopen': '1' }),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'main', style: { "height": "100%" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'show-company-info', id: 'show-company-info', style: { "display": "none" } },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            ),
	                            _react2.default.createElement(
	                                'h1',
	                                { id: 'companyName-info' },
	                                'loading...'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'des', id: 'companyName-des-info' },
	                                '...'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'correlation-tips' },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '隐藏文字', id: 'cavHideText' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-3.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '放大', id: 'cavToMax' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-4.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '缩小', id: 'cavToMin' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-5.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { className: 'pic-tips', href: 'javascript:;' },
	                                '图例说明 ',
	                                _react2.default.createElement('i', { className: 'iconfont icon-xia' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 't-img' },
	                                    _react2.default.createElement(
	                                        'ul',
	                                        null,
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop1' },
	                                            '当前目标'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '被投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '股东'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '董监高'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他自然人'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop3' },
	                                            '投资关系'
	                                        )
	                                    ),
	                                    _react2.default.createElement('img', { className: '', src: '/assets/images/tips.gif', alt: '' })
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'time-line' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'date' },
	                                _react2.default.createElement('ul', { className: 'dateul' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'canvas selectNull', id: 'canvas-box' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'drag-box' },
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover-nodes', id: 'cav-hover-nodes' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover', id: 'cav-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-main-hover', id: 'cav-main-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes', id: 'cav-nodes' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes-text', id: 'cav-nodes-text' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links-hover', id: 'cav-links-hover' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links', id: 'cav-links' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebar' },
	                            _react2.default.createElement('a', { href: 'javascript:;', className: 'sidebtn' })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebox', style: { display: "none" } },
	                            _react2.default.createElement(
	                                'ul',
	                                { className: 'select-nav clearfix' },
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '1' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '1度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '2' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '2度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '3' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '3度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '4' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '4度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'all' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '全部'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'shareholder', 'langs-title': '股东投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '股东投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'direct', 'langs-title': '直接投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '直接投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'leader', 'langs-title': '董监高' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '董监高'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'search-company' },
	                                _react2.default.createElement('input', { type: 'text', className: 'name', id: 'searchCompanyLocal', placeholder: '搜索关联方列表' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'index-search-content' },
	                                    ' ...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'allCompany' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'gdCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'zjCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'djgCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'down-btn' },
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-blue down-excel' },
	                                    '下载Excel'
	                                ),
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-grey reset-old' },
	                                    '恢复默认'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'loadingBox' },
	                        _react2.default.createElement(
	                            'p',
	                            null,
	                            '数据加载中...'
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'click-detail-show', id: 'click-detail-show' },
	                        _react2.default.createElement(
	                            'h1',
	                            null,
	                            '基本资料 ',
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            )
	                        ),
	                        _react2.default.createElement('div', { className: 'detail-content' })
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
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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
	    type: BASEMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function litigationRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BASEMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getlitigationRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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

/***/ 844:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(845);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(741);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _BusinessTypes = __webpack_require__(847);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(850);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(851);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(852);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _PlatformRun = __webpack_require__(853);

	var _PlatformRun2 = _interopRequireDefault(_PlatformRun);

	var _PlatformBase = __webpack_require__(854);

	var _PlatformBase2 = _interopRequireDefault(_PlatformBase);

	var _RaiseIndexAction = __webpack_require__(855);

	var RaiseIndexCreaters = _interopRequireWildcard(_RaiseIndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//平台运营情况
	//6月上海各类众筹平台新增项目数
	//业务类型

	var Immutable = __webpack_require__(777);
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

	      this.setState({ option: platFormBaseData });
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
	      url: "/dcrowdFunding/allCompanys.do",
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

/***/ 910:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(908);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//舆情
	var Consensu = _react2.default.createClass({
	  displayName: 'Consensu',
	  getInitialState: function getInitialState() {
	    return {
	      consensu: []
	    };
	  },

	  //ajax请求
	  ajaxConsensu: function ajaxConsensu(val) {
	    $.ajax({
	      url: 'park/news.do',
	      type: 'get',
	      dataType: 'json',
	      data: { areaId: val },
	      success: function (res) {
	        //console.log("取val=",val,"的值");
	        //console.log(res)
	        this.setState({
	          consensu: res.content
	        });
	      }.bind(this)
	    });
	  },
	  componentDidMount: function componentDidMount() {
	    this.ajaxConsensu(this.props.val);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    this.ajaxConsensu(nextProps.val);
	  },

	  render: function render() {
	    //console.log("========>",this.props.val);
	    return _react2.default.createElement(
	      'div',
	      { className: 'Consensu mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '舆情',
	          this.props.val
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'box' },
	          this.state.consensu.map(function (elem, index) {
	            return _react2.default.createElement(
	              'div',
	              { className: 'list', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  _react2.default.createElement(
	                    'a',
	                    { href: elem.url },
	                    index + 1,
	                    _react2.default.createElement(
	                      'span',
	                      { className: 'liLeft' },
	                      elem.title
	                    )
	                  )
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  elem.content
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  _react2.default.createElement(
	                    'span',
	                    { className: 'liRight' },
	                    _react2.default.createElement(
	                      'span',
	                      { className: 'spanLeft' },
	                      elem.fromSite
	                    ),
	                    elem.date
	                  )
	                )
	              )
	            );
	          })
	        )
	      )
	    );
	  }
	});
	//module.exports = Consensu;
	exports.default = (0, _reactRedux.connect)(function (state) {
	  return {
	    val: state.selectval.val
	  };
	})(Consensu);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Consensu.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 911:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(908);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//类金融企业集中度
	var Finance = _react2.default.createClass({
	    displayName: 'Finance',
	    getInitialState: function getInitialState() {
	        return {
	            item: []
	        };
	    },

	    //ajax请求
	    ajaxFinance: function ajaxFinance(val) {
	        $.ajax({
	            url: 'park/companyConcentration.do',
	            type: 'get',
	            dataType: 'json',
	            data: { areaId: val },
	            success: function (res) {
	                console.log(res);
	                this.setState({
	                    item: res.content
	                });
	            }.bind(this)
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        this.ajaxFinance(this.props.val);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        this.ajaxFinance(nextProps.val);
	    },


	    //获取大厦的名称
	    ImgbtnAdd: function ImgbtnAdd(e) {
	        var imgId = $(e.target).attr("data-img");
	        var nameId = $(e.target).attr("data-name");
	        console.log(imgId);
	    },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'Finance mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '类金融企业集中度',
	                    this.props.val
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'item' },
	                        _react2.default.createElement(
	                            'ul',
	                            null,
	                            this.state.item.map(function (elem, index) {
	                                return _react2.default.createElement(
	                                    'li',
	                                    { key: index },
	                                    _react2.default.createElement(
	                                        _reactRouter.Link,
	                                        { to: { pathname: HOME_PATH + "/buildDetail" } },
	                                        _react2.default.createElement('img', { onClick: this.ImgbtnAdd, 'data-img': elem.buildingId, src: "../images/lou" + (index + 1) + ".png" })
	                                    ),
	                                    _react2.default.createElement('br', null),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { 'data-name': elem.name, className: 'color' },
	                                        elem.name
	                                    ),
	                                    _react2.default.createElement('br', null),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'digit' },
	                                        elem.finComNum
	                                    ),
	                                    _react2.default.createElement('span', { className: 'solid' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'Yellow' },
	                                        elem.finComRatio
	                                    )
	                                );
	                            }.bind(this))
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	//module.exports = Finance;
	exports.default = (0, _reactRedux.connect)(function (state) {
	    return {
	        val: state.selectval.val
	    };
	})(Finance);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Finance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 912:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(908);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var myChart;
	var option;
	//园区行业分布
	var Park = _react2.default.createClass({
	    displayName: 'Park',
	    getInitialState: function getInitialState() {
	        return {
	            Park: [],
	            ParkEnd: []
	        };
	    },
	    initMap: function initMap(ParkBox, ParkEnd) {
	        myChart = echarts.init(document.getElementById("myChart"));
	        option = {
	            backgroundColor: '#2b323c',
	            color: ['#c33533', '#61a0a9', '#54656f', '#6e6f71', '#2f4553', '#c09f9a', '#dfab62'],
	            title: {
	                text: "园区行业分布",
	                x: "left",
	                y: "top",
	                top: "5px",
	                left: "5px",
	                textStyle: {
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    color: '#fff',
	                    fontFamily: "microsoft yahei"
	                }
	            },
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b}{c}"
	            },
	            legend: {
	                orient: 'vertical',
	                x: '80%',
	                y: "80%",
	                textStyle: {
	                    color: "#dddddd"
	                },
	                data: ['金融', '类金融', '其他']
	            },
	            series: [{
	                type: 'pie',
	                selectedMode: 'single',
	                center: ['45%', 200],
	                radius: [0, '30%'],
	                label: {
	                    normal: {
	                        show: false
	                    }
	                },
	                labelLine: {
	                    normal: {
	                        show: false
	                    }
	                },
	                data: ParkBox
	            }, {
	                type: 'pie',
	                center: ['45%', 200],
	                radius: ['40%', '60%'],
	                data: ParkEnd
	            }]
	        };
	        myChart.setOption(option);
	        myChart.resize();
	    },
	    ajaxPark: function ajaxPark(val) {
	        $.ajax({
	            url: 'park/businessDistribute.do',
	            type: 'get',
	            dataType: 'json',
	            data: { areaId: val },
	            success: function (res) {
	                if (res.success) {
	                    var ParkBox = [];
	                    var ParkContent = [];
	                    for (var i = 0; i < res.content.length; i++) {
	                        ParkBox.push({ value: res.content[i].count, name: res.content[i].type });
	                    };
	                    for (var j = 0; j < res.content[0].children.length; j++) {
	                        ParkContent.push({ value: res.content[0].children[j].count, name: res.content[0].children[j].type });
	                    };
	                }
	                this.initMap(ParkBox, ParkContent);
	            }.bind(this)
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        this.ajaxPark(this.props.val);

	        $(window).resize(function (event) {
	            this.initMap();
	        }.bind(this));
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        this.ajaxPark(nextProps.val);
	    },


	    render: function render() {
	        return _react2.default.createElement('div', { className: 'Park', id: 'myChart' });
	    }
	});
	//module.exports = Park;
	exports.default = (0, _reactRedux.connect)(function (state) {
	    return {
	        val: state.selectval.val
	    };
	})(Park);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Park.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 913:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(908);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(797);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//在营时间分布
	var TheCamp = _react2.default.createClass({
	    displayName: 'TheCamp',
	    getInitialState: function getInitialState() {
	        return {
	            TheCamp: []
	        };
	    },

	    setBarParm: function setBarParm() {
	        var option = {
	            color: ["#e14340"],
	            titleName: "在营分布",
	            titleNameX: "28px",
	            gridRight: "11%",
	            gridLeft: "2%",
	            gridTop: "5%",
	            padding: [10, 10, 10, 12],
	            Color: "#919bae",
	            titleShow: true,
	            barWidth: 25,
	            legendRight: "20",
	            xAxisName: "企业数",
	            xAxisLine: true,
	            xAxisLabel: true,
	            gradient: ['rgb(193, 42, 39)', 'rgb(251, 99, 96)'],
	            legend: [""],
	            yAxis: ['10年以上', '5-10年', '3-5年', '1-3年', '1年以下'],
	            series: [this.state.TheCamp]
	        };
	        return option;
	    },

	    //ajax请求
	    ajaxTheCamp: function ajaxTheCamp(val) {
	        $.ajax({
	            url: 'park/inBusiness.do',
	            type: 'get',
	            dataType: 'json',
	            data: { areaId: val },
	            success: function (res) {
	                console.log(res);
	                if (res.success) {
	                    var TheCampBox = [];
	                    for (var i = 0; i < res.content.length; i++) {
	                        TheCampBox.push(res.content[i].count);
	                    }
	                    this.setState({
	                        TheCamp: TheCampBox
	                    });
	                }
	            }.bind(this)
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        this.ajaxTheCamp(this.props.val);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        this.ajaxTheCamp(nextProps.val);
	    },


	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'TheCamp mod', id: 'TheCamp' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '在营时间分布',
	                    this.props.val
	                )
	            ),
	            _react2.default.createElement(_HorizontalBarChart2.default, {
	                option: this.setBarParm(),
	                style: { height: '270px', width: '97%' } })
	        );
	    }
	});
	//module.exports = TheCamp;
	exports.default = (0, _reactRedux.connect)(function (state) {
	    return {
	        val: state.selectval.val
	    };
	})(TheCamp);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TheCamp.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 962:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _SmallLoanMap = __webpack_require__(963);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(964);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(965);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(966);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(967);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(1283);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(1284);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(1285);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(1286);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(1287);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(968);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(969);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(970);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(971);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(972);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(973);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1288);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1289);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1290);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(974);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(975);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(976);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(977);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyProgress = __webpack_require__(1295);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1296);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1297);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1298);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _EquityL = __webpack_require__(1299);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1300);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1301);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(979);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(980);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(981);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(982);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(983);

	var _List2 = _interopRequireDefault(_List);

	var _realtimeTableRuducer = __webpack_require__(978);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1292);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _selectval = __webpack_require__(1302);

	var _selectval2 = _interopRequireDefault(_selectval);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//import ImgFinance from './parkMonitor/buildDetail/ImgFinance'
	/*众筹监测 end*/

	//列表

	//6月上海各类众筹平台新增项目数

	/*====================================私募基金===============================*/

	/*=================================众筹监测=================================*/
	//业务类型

	//私募证券基本情况

	//QFLP试点企业最新进展

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名


	/*行业监测模块*/

	//小额贷款
	var rootReducer = (0, _redux.combineReducers)({
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

	  //私募基金
	  CompanyProgress: _CompanyProgress2.default,
	  QDLPQuality: _QDLPQuality2.default,
	  FundClass: _FundClass2.default,
	  FundCase: _FundCase2.default,
	  EquityL: _EquityL2.default,
	  EquityM: _EquityM2.default,
	  EquityR: _EquityR2.default,

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //园区
	  selectval: _selectval2.default,
	  //ImgFinance,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*实时监测 end*/

	//园区

	/*=================================众筹监测=================================*/

	/*实时监测 begin*/
	//左侧表格

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	//私募股权基本情况

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

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1285:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = guaraDutyBalance;

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	//担保责任余额 担保责任余额结构分布 担保笔均折线图
	function guaraDutyBalance() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.FINGUA_DUTY_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.FINGUA_DUTY_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "GuaraDutyBalance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1293:
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
	      url: "/privateFund/typeStatistic.do",
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
	      url: "/data/industryMonitor/p2p/index/indexChart.json",
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
	      url: "/data/industryMonitor/p2p/index/indexChart.json",
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
	      url: "/data/industryMonitor/p2p/index/indexChart.json",
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

/***/ 1295:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CompanyProgress;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function CompanyProgress() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.COMPANYPROGRESS_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.COMPANYPROGRESS_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyProgress.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1296:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = QDLPQuality;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function QDLPQuality() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.QDLPQUALITY_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.QDLPQUALITY_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "QDLPQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1297:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = FundClass;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function FundClass() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.FUNDCLASS_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.FUNDCLASS_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FundClass.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1298:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = FundCase;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function FundCase() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.FUNDCASE_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.FUNDCASE_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FundCase.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1299:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = EquityL;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function EquityL() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.EQUITYL_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.EQUITYL_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityL.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1300:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = EquityM;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function EquityM() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.EQUITYM_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.EQUITYM_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityM.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1301:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = EquityR;

	var _PrivateFundIndexAction = __webpack_require__(1294);

	function EquityR() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _PrivateFundIndexAction.EQUITYR_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _PrivateFundIndexAction.EQUITYR_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityR.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1302:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = todo;

	var _selectvalAction = __webpack_require__(1293);

	//初始化数据
	var initialState = {
		val: 1122 //下拉列表
	};

	function todo() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? initialState : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _selectvalAction.SELECT_NAME:
				return {
					val: action.data.val
				};

			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "selectval.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})