webpackHotUpdate(0,{

/***/ 951:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	//子模块引入

	//redux


	__webpack_require__(952);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _topLeft = __webpack_require__(954);

	var _topLeft2 = _interopRequireDefault(_topLeft);

	var _topMiddle = __webpack_require__(955);

	var _topMiddle2 = _interopRequireDefault(_topMiddle);

	var _topRight = __webpack_require__(956);

	var _topRight2 = _interopRequireDefault(_topRight);

	var _bottomLeft = __webpack_require__(957);

	var _bottomLeft2 = _interopRequireDefault(_bottomLeft);

	var _bottomRight = __webpack_require__(958);

	var _bottomRight2 = _interopRequireDefault(_bottomRight);

	var _RealTimeAction = __webpack_require__(1291);

	var RealTimeCreaTers = _interopRequireWildcard(_RealTimeAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//实时监测首页s
	var RealtimeMonitorIndex = _react2.default.createClass({
	  displayName: 'RealtimeMonitorIndex',
	  getInitialState: function getInitialState() {
	    return {
	      windowHeight: null,
	      indexRange: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    $(window).resize(function (event) {
	      this.setState({
	        windowHeight: $(window).height()
	      });
	    }.bind(this));
	  },
	  componentWillMount: function componentWillMount() {
	    this.setState({
	      windowHeight: $(window).height()
	    });
	  },
	  getRange: function getRange(range) {
	    this.setState({
	      indexRange: range
	    });
	  },

	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-index wrap', style: { "height": this.state.windowHeight - 60 } },
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-top' },
	        _react2.default.createElement(_topLeft2.default, _extends({ getRange: this.getRange }, this.props)),
	        _react2.default.createElement(_topMiddle2.default, _extends({ pushRange: this.state.indexRange }, this.props)),
	        _react2.default.createElement(_topRight2.default, this.props)
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-bottom' },
	        _react2.default.createElement(_bottomLeft2.default, null),
	        _react2.default.createElement(_bottomRight2.default, this.props)
	      )
	    );
	  }
	});

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {
	    realTimeTableResult: state.RealTimeTable.result,
	    realTimeTableRequest: state.RealTimeTable.request, //RealTimeTable注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeNineResult: state.RealTimeNine.result,
	    realTimeNineRequest: state.RealTimeNine.request, //RealTimeNine注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeNewsResult: state.RealTimeNews.result,
	    realTimeNewsRequest: state.RealTimeNews.request //RealTimeNews注册在reduce里面的index。拿到处理后的两个返回值。
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(RealTimeCreaTers, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RealtimeMonitorIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 958:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(952);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	var data;
	var BottomRight = _react2.default.createClass({
	  displayName: 'BottomRight',
	  getInitialState: function getInitialState() {
	    return {};
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeNews = this.props.getRealTimeNews; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeNews(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeNewsRequest, this.props.realTimeNewsResult); //判断数据是否变化
	    if (!isEqual) {
	      var realTimeNewsRequest = nextProps.realTimeNewsRequest;
	      var realTimeNewsResult = nextProps.realTimeNewsResult;

	      if (realTimeNewsRequest == true) {
	        if (realTimeNewsRequest == true) {
	          alert();
	        } else {
	          alert(404);
	        }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-bottom-right' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '舆情'
	      ),
	      _react2.default.createElement(
	        'ul',
	        null,
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        )
	      )
	    );
	  }
	});

	//将state植入 到 props
	exports.default = BottomRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "bottomRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

	var _realtimeNewsReducer = __webpack_require__(1303);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _selectval = __webpack_require__(1302);

	var _selectval2 = _interopRequireDefault(_selectval);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//import ImgFinance from './parkMonitor/buildDetail/ImgFinance'
	/*众筹监测 end*/

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
	  RealTimeNews: _realtimeNewsReducer2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*实时监测 end*/

	//园区

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

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1303:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = realTimeNine;

	var _RealTimeAction = __webpack_require__(1291);

	//这个函数就是处理，action里面成功和失败的2个返回函数。
	//当ajax请求成功了，就可以调用这个两个返回函数进行操作。

	function realTimeNine() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? { //这个名字无所谓，最后都是用index里面对外暴露的名字。
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _RealTimeAction.REALTIME_NEWS_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _RealTimeAction.REALTIME_NEWS_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	//（默认的2个值，根据判断action返回的两个值）
	// 这个reducer就是从action里面抽离出来的数据的状态机

	// request、result

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "realtimeNewsReducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})