webpackHotUpdate(0,{

/***/ 945:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(943);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _AssociationGraph = __webpack_require__(946);

	var _AssociationGraph2 = _interopRequireDefault(_AssociationGraph);

	var _CompanyInfo = __webpack_require__(949);

	var _CompanyInfo2 = _interopRequireDefault(_CompanyInfo);

	var _CompanyNews = __webpack_require__(950);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _CompanyDetail = __webpack_require__(951);

	var _CompanyDetail2 = _interopRequireDefault(_CompanyDetail);

	var _InfoSearchAction = __webpack_require__(964);

	var InfoSearchAction = _interopRequireWildcard(_InfoSearchAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var SearchResultDetail = _react2.default.createClass({
		displayName: 'SearchResultDetail',

		pageScroll: function pageScroll() {
			$('html, body').animate({ scrollTop: 0 }, 'slow');
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ id: 'search-result-detail' },
				_react2.default.createElement(
					'div',
					{ className: 'company-name' },
					_react2.default.createElement(
						'span',
						null,
						'上海明成投资有限公司'
					),
					_react2.default.createElement(
						'div',
						{ className: 'btn' },
						'存续'
					),
					_react2.default.createElement(
						'div',
						{ className: 'right-content' },
						_react2.default.createElement(
							'div',
							{ className: 'search-group' },
							_react2.default.createElement('input', { type: 'text', placeholder: '请输入企业名称检索' }),
							_react2.default.createElement(
								'a',
								{ href: '#', className: 'search' },
								_react2.default.createElement('i', { className: 'iconfont icon-search' })
							)
						),
						_react2.default.createElement(
							'div',
							{ className: 'back-btn' },
							_react2.default.createElement('i', { className: 'iconfont icon-fanhui fanhui' }),
							'返回'
						)
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'company-detail clear-fix' },
					_react2.default.createElement(_AssociationGraph2.default, null),
					_react2.default.createElement(_CompanyInfo2.default, this.props),
					_react2.default.createElement(_CompanyNews2.default, this.props),
					_react2.default.createElement(_CompanyDetail2.default, this.props)
				),
				_react2.default.createElement(
					'div',
					{ className: 'back-top', onClick: this.pageScroll },
					_react2.default.createElement('i', { className: 'iconfont icon-top' })
				)
			);
		}
	});

	//将 request  result 绑定到props的request result
	/*
	 *Create by yq
	 */
	function mapStateToProps(state) {
		return {
			CompanyInfoTitResult: state.CompanyInfoTit.result,
			CompanyInfoTitRequest: state.CompanyInfoTit.request,

			CompanyInfoNewsResult: state.CompanyInfoNews.result,
			CompanyInfoNewsRequest: state.CompanyInfoNews.request,

			CompanyInfoAResult: state.CompanyInfoA.result,
			CompanyInfoARequest: state.CompanyInfoA.request,

			CompanyInfoBResult: state.CompanyInfoB.result,
			CompanyInfoBRequest: state.CompanyInfoB.request,

			//诉讼记录5个ajax
			CompanyInfoC1Result: state.CompanyInfoC1.result,
			CompanyInfoC1Request: state.CompanyInfoC1.request,

			CompanyInfoC2Result: state.CompanyInfoC2.result,
			CompanyInfoC2Request: state.CompanyInfoC2.request,

			CompanyInfoC3Result: state.CompanyInfoC3.result,
			CompanyInfoC3Request: state.CompanyInfoC3.request,

			CompanyInfoC4Result: state.CompanyInfoC4.result,
			CompanyInfoC4Request: state.CompanyInfoC4.request,

			CompanyInfoC5Result: state.CompanyInfoC5.result,
			CompanyInfoC5Request: state.CompanyInfoC5.request
			//三个echarts图的ajax

		};
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
		return (0, _redux.bindActionCreators)(InfoSearchAction, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(SearchResultDetail);

	// (function(){
	// 	switch(self.state.pageNum){
	// 		case 1:
	// 			return (<Announcement {...this.props}></Announcement>)
	// 		break;
	// 		case 2:
	// 			return (<RefereeDocuments ...{this.props}></RefereeDocuments>)
	// 		break;
	// 		case 3:
	// 			return (<Executor {...this.props}></Executor>)
	// 		break;
	// 		case 4:
	// 			return (<BrokenPromises {...this.props}></BrokenPromises>)
	// 		break;
	// 		case 5:
	// 			return (<CourtAnnouncement {...this.props}></CourtAnnouncement>)
	// 		break;
	// 	}
	// })()

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchResultDetail.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

	var _companyInfoC1Ruducer = __webpack_require__(1367);

	var _companyInfoC1Ruducer2 = _interopRequireDefault(_companyInfoC1Ruducer);

	var _companyInfoC2Ruducer = __webpack_require__(1368);

	var _companyInfoC2Ruducer2 = _interopRequireDefault(_companyInfoC2Ruducer);

	var _companyInfoC3Ruducer = __webpack_require__(1369);

	var _companyInfoC3Ruducer2 = _interopRequireDefault(_companyInfoC3Ruducer);

	var _companyInfoC4Ruducer = __webpack_require__(1370);

	var _companyInfoC4Ruducer2 = _interopRequireDefault(_companyInfoC4Ruducer);

	var _companyInfoC5Ruducer = __webpack_require__(1371);

	var _companyInfoC5Ruducer2 = _interopRequireDefault(_companyInfoC5Ruducer);

	var _Common = __webpack_require__(983);

	var _Common2 = _interopRequireDefault(_Common);

	var _SmallLoanMap = __webpack_require__(984);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(985);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(986);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(987);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(988);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(989);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(990);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(991);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(992);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(993);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(994);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(995);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(996);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(997);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(998);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(999);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1000);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1001);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1002);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(1003);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1004);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1005);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1006);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyProgress = __webpack_require__(1007);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1008);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1009);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1010);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1011);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1012);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1013);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1014);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1015);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1016);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1017);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1018);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1019);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1020);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1021);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1022);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1023);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1024);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1025);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1026);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1027);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1028);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1029);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1030);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1031);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _realtimeTableRuducer = __webpack_require__(1032);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1033);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1034);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1035);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1036);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _MenuParkSelectVal = __webpack_require__(1037);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1038);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1039);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1040);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1041);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1042);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _BuildCompanyList = __webpack_require__(1043);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1044);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1045);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1046);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1047);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1048);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _ChartAll3 = __webpack_require__(1049);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1050);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1051);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1052);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _DynamicRisk = __webpack_require__(1053);

	var _DynamicRisk2 = _interopRequireDefault(_DynamicRisk);

	var _LineFinanceRiskDistri = __webpack_require__(1054);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1055);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1056);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1057);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1059);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1060);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1061);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1062);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1063);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1064);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _industryTypeChart = __webpack_require__(1065);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1066);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1067);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1068);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/

	/*线下理财监测 end*/

	/*预付卡 begin*/

	/*动态风险模块 end*/

	/*线下理财监测 start*/
	//线下理财首页

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

	//诉讼记录的五个接口


	/*企业全息查询*/
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

	  //动态风险
	  dynamicRiskData: _DynamicRisk2.default,

	  //融资租赁
	  Lease: _Lease2.default,
	  ContrastLeft: _ContrastLeft2.default,
	  ContrastRight: _ContrastRight2.default,
	  Catalog: _Catalog2.default,

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

	  //首页
	  homeThree: _homeThree2.default,

	  //企业全息信息查询平台
	  infoSearch: _infoSearch2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*首页 end*/

	/*企业全息信息查询平台 begin*/

	/*商业保理监测 end*/

	/*动态风险模块 begein*/


	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//楼宇详情页


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

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1367:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyInfoC1Ruducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1368:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyInfoC2Ruducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1369:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyInfoC3Ruducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1370:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyInfoC4Ruducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1371:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyInfoC5Ruducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})