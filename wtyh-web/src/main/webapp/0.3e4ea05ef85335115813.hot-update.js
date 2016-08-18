webpackHotUpdate(0,{

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

	var _FundCaseTop = __webpack_require__(1309);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

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

	var _ChartAll = __webpack_require__(1310);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1311);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1312);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1313);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1314);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1315);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _Lease = __webpack_require__(1316);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _realtimeTableRuducer = __webpack_require__(978);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1292);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1303);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1329);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _MenuParkSelectVal = __webpack_require__(1318);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1319);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1320);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1321);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1322);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1323);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ChartAll3 = __webpack_require__(1324);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1325);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1326);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*商业保理监测 end*/

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

	  //商业保理监测
	  ChartAll: _ChartAll4.default,
	  businessnumChart: _businessnumChart2.default,
	  balanceChart: _balanceChart2.default,

	  //融资租赁
	  Lease: _Lease2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});

	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//园区首页

	/*实时监测 end*/

	//园区

	//企业占比对比

	//企业目录列表

	/*实时监测 begin*/

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

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1329:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "realtimeMapReducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})