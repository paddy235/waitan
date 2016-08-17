webpackHotUpdate(0,{

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
	        console.log(data, '担保责任余额');
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

/***/ 774:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//融资担保企业评级
	var FinanceGuaraCompanyGrade = _react2.default.createClass({
	    displayName: 'FinanceGuaraCompanyGrade',

	    getInitialState: function getInitialState() {
	        return {
	            companyGradeList: [],
	            orderByField: 1,
	            descAsc: "desc"
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var orderByField = this.state.orderByField;
	        var descAsc = this.state.descAsc;
	        var jsonData = { orderByField: orderByField, descAsc: descAsc };
	        this.getCompanyGrade(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.FinGuaCompanyGradeRequest, this.props.FinGuaCompanyGradeResult); //判断数据是否变化
	        if (!isEqual) {
	            var FinGuaCompanyGradeRequest = nextProps.FinGuaCompanyGradeRequest;
	            var FinGuaCompanyGradeResult = nextProps.FinGuaCompanyGradeResult;

	            if (FinGuaCompanyGradeRequest == true) {
	                if (FinGuaCompanyGradeResult.success == true) {
	                    this.dataFomat(FinGuaCompanyGradeResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ companyGradeList: content });
	    },
	    getCompanyGrade: function getCompanyGrade(jsonData) {
	        var getFinGuaCompanyGrade = this.props.getFinGuaCompanyGrade; // 取到props里面的getFinGuaCompanyGrade方法。也可以说是请求action

	        getFinGuaCompanyGrade(jsonData);
	    },
	    orderByField: function orderByField(parm, e) {
	        console.log(parm, e);
	        var $this = $(e.target).parent('th');
	        var $i = $this.find('i');
	        var isDesc = $i.hasClass('icon-desc');
	        var descAsc = "";
	        if (isDesc == true) {
	            $i.removeClass('icon-desc').addClass('icon-asc');
	            descAsc = "asc";
	        } else {
	            $i.removeClass('icon-asc').addClass('icon-desc');
	            descAsc = "desc";
	        }

	        this.setState({ orderByField: parm, descAsc: descAsc });

	        var orderByField = parm;
	        var jsonData = { orderByField: orderByField, descAsc: descAsc };
	        this.getCompanyGrade(jsonData);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'company-grade mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业评级'
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
	                                    { width: '25%', className: 'talign-left' },
	                                    '企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '外部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '内部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '现场检查',
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
	                            this.state.companyGradeList.map(function (elem, index) {
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.liveLevel
	                                        )
	                                    );
	                                }{
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            elem.liveLevel
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
	module.exports = FinanceGuaraCompanyGrade;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinanceGuaraCompanyGrade.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 778:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _MapChart = __webpack_require__(779);

	var _MapChart2 = _interopRequireDefault(_MapChart);

	var _PieChart = __webpack_require__(780);

	var _PieChart2 = _interopRequireDefault(_PieChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//融资担保地图
	var FinanceGuaraMap = _react2.default.createClass({
	    displayName: 'FinanceGuaraMap',

	    getInitialState: function getInitialState() {
	        return {
	            mapOption: null,
	            pieOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        console.log(this.props, 3333);
	        var getfinGuaMap = this.props.getfinGuaMap;

	        var jsonData = {};
	        getfinGuaMap(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isMapEqual = Immutable.is(nextProps.finGuaMapRequest, this.props.finGuaMapResult);
	        console.log("isMapEqual:", isMapEqual);
	        if (!isMapEqual) {
	            var finGuaMapRequest = nextProps.finGuaMapRequest;
	            var finGuaMapResult = nextProps.finGuaMapResult;

	            if (finGuaMapRequest == true) {
	                if (finGuaMapResult.success == true) {
	                    this.dataFomatMap(finGuaMapResult);
	                    this.dataFomatPie(finGuaMapResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomatMap: function dataFomatMap(data) {
	        var content = data.content;
	        var series = [];
	        for (var i = 0; i < content.length; i++) {
	            var s = { "name": content[i].areaName, "value": content[i].all };
	            series.push(s);
	        }
	        var option = {
	            "visualMapRight": "50", //值茷位置
	            "visualMapBottom": "30",
	            "seriesName": '小额贷款企业数',
	            "series": series
	        };
	        this.setState({ mapOption: option });
	    },
	    dataFomatPie: function dataFomatPie(data) {
	        var content = data.content;
	        var series = [];
	        var stateOwned = 0; //国企数量统计
	        var privateCompany = 0; //私有企业数量统计
	        for (var i = 0; i < content.length; i++) {
	            stateOwned = stateOwned + content[i].stateOwned;
	            privateCompany = privateCompany + content[i].privateCompany;
	        }
	        var option = {
	            color: ['#e14340', '#ffffff'],
	            id: 'small-loan-company-chart', //必传
	            height: '200px', //必传 带上单位
	            title: '',
	            legendBottom: '0%',
	            legendData: ['国有企业', '民营企业'],
	            data: [{ value: stateOwned, name: '国有企业' }, { value: privateCompany, name: '民营企业' }]
	        };
	        this.setState({ pieOption: option });
	    },
	    // setParm:function(){
	    //   const option ={
	    //     "visualMapRight":"50",//值茷位置
	    //     "visualMapBottom":"30",
	    //      "seriesName":'融资担保企业数',
	    //         "series": [
	    //                 {
	    //                     "name": "嘉定区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "青浦区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "松江区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "金山区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "崇明县",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "宝山区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "杨浦区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "闵行区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },

	    //                 {
	    //                     "name": "徐汇区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "长宁区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },

	    //                 {
	    //                     "name": "普陀区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "静安区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },

	    //                 {
	    //                     "name": "黄浦区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "闸北区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "闵行区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "闵行区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "闵行区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "虹口区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "浦东新区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 },
	    //                 {
	    //                     "name": "奉贤区",
	    //                     "value": Math.round(Math.random() * 1000)
	    //                 }
	    //             ]
	    //     }
	    //       return option;
	    // },
	    // setPieParm:function(){
	    //      var param={
	    //           id:'finance-guara-compose1',//必传  企业构成
	    //           color:['#e14340','#ffffff'],
	    //           height:'200px',//必传 带上单位
	    //           title:'',
	    //           legendBottom:'0%',
	    //           grid:{top:'15%',left: '0%',right: '60%',bottom: '5%'},
	    //           legendData:['国有企业','民营企业'],
	    //           data: [
	    //                     {value:100, name:'国有企业'},
	    //                     {value:200, name:'民营企业'}
	    //                 ]
	    //       }
	    //       return param;
	    // },

	    render: function render() {
	        var bbdMap = "";
	        if (this.state.mapOption) {
	            bbdMap = _react2.default.createElement(_MapChart2.default, { option: this.state.mapOption, style: { height: '610px', width: '100%' } });
	        }
	        var bbdPie = "";
	        if (this.state.pieOption) {
	            bbdPie = _react2.default.createElement(_PieChart2.default, { param: this.state.pieOption });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'finance-guara-map mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'map-chart-box' },
	                    bbdMap,
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'visual-text' },
	                        '企业数量'
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'company-chart-box' },
	                    bbdPie
	                )
	            )
	        );
	    }
	});
	module.exports = FinanceGuaraMap;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinanceGuaraMap.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 781:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(756);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//担保责任余额结构分布
	var BalanceDistribute = _react2.default.createClass({
	      displayName: 'BalanceDistribute',

	      setParm: function setParm() {
	            var option = {
	                  "color": ["#6c9f87", "#e14340", "#61a0a8"],
	                  "title": "",
	                  "xtitle": "",
	                  "legend": ["政策性", "综合型", "钢贸类"],
	                  "legendShow": true,
	                  "legendOrient": "vertical",
	                  "legendLeft": "",
	                  "legendTop": "middle",
	                  "legendRight": "10%",
	                  "seriesName": "担保责任余额结构分布",
	                  "radius": "70%",
	                  "lable": { normal: { show: false },
	                        emphasis: { show: false }
	                  },
	                  "center": ['40%', '50%'],
	                  "series": [{ value: 500, name: '政策性' }, { value: 800, name: '综合型' }, { value: 400, name: '钢贸类' }]
	            };
	            return option;
	      },
	      render: function render() {
	            return _react2.default.createElement(
	                  'div',
	                  { className: 'balance-distribute mod' },
	                  _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                              'h3',
	                              null,
	                              '担保责任余额结构分布'
	                        )
	                  ),
	                  _react2.default.createElement(
	                        'div',
	                        { className: 'mod-content' },
	                        _react2.default.createElement(
	                              'div',
	                              { className: 'chart-box' },
	                              _react2.default.createElement(_BasePie2.default, { option: this.setParm(), style: { height: '272px', width: '100%' } })
	                        )
	                  )
	            );
	      }
	});
	module.exports = BalanceDistribute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BalanceDistribute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	        var isEqual = Immutable.is(nextProps.eachAverageData, this.props.eachAverageData);
	        if (!isEqual) {
	            var eachAverageData = nextProps.eachAverageData;

	            this.dataFomat(eachAverageData);
	        }
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
	            xAxis: data.xAxis,
	            series: [data.series]
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

/***/ 783:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _ScatterChart = __webpack_require__(739);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//担保责任余额
	var GuaraDutyBalance = _react2.default.createClass({
	  displayName: 'GuaraDutyBalance',

	  getInitialState: function getInitialState() {
	    return {
	      option: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.guaraDutyBalaData, this.props.guaraDutyBalaData);
	    if (!isEqual) {
	      var guaraDutyBalaData = nextProps.guaraDutyBalaData;

	      this.dataFomat(guaraDutyBalaData);
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var option = {
	      id: 'guara-balance-chart', //必传
	      height: '272px', //必传 带上单位
	      title: '',
	      forMaterTitle: "担保责任余额",
	      forMaterTip: '平均担保责任余额',
	      legend: [],
	      yAxisName: '亿元',
	      xAxis: data.xAxis,
	      yAxis: data.yAxis,
	      data: data.data,
	      series: [[{
	        color: '#e14340'
	      }]]
	    };

	    this.setState({ option: option });
	  },
	  // setParam:function(){
	  //     var param={
	  //         id:'loan-balance-chart',//必传
	  //         height:'272px',//必传 带上单位
	  //         title:'',
	  //         yAxisName:'亿元',
	  //         forMaterTitle:"担保责任余额",
	  //         forMaterTip:'平均担保责任余额',
	  //         legend: [],
	  //         xAxis:['2010', '2011', '2012','2013', '2014', '2015', '2016'],
	  //         yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	  //         data: [[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	  //         series:[
	  //                 [{
	  //                   color:'#e14340'
	  //                 }]
	  //               ]
	  //     }
	  //     return param;
	  // },
	  render: function render() {
	    var bbdScatter = "";
	    if (this.state.option) {
	      bbdScatter = _react2.default.createElement(_ScatterChart2.default, { param: this.state.option });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'loan-balance mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '担保责任余额'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'chart-box' },
	          bbdScatter
	        )
	      )
	    );
	  }
	});
	module.exports = GuaraDutyBalance;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "GuaraDutyBalance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 784:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _IndustryRiskMore = __webpack_require__(785);

	var _IndustryRiskMore2 = _interopRequireDefault(_IndustryRiskMore);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);
	//股东行业风险
	var FinanceGuaraIndustryRisk = _react2.default.createClass({
	    displayName: 'FinanceGuaraIndustryRisk',

	    getInitialState: function getInitialState() {
	        return {
	            industryRiskList: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getFinGuaIndustryRisk = this.props.getFinGuaIndustryRisk;

	        var jsonData = {};
	        getFinGuaIndustryRisk(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.finGuaIndustryRiskRequest, this.props.finGuaIndustryRiskResult);
	        if (!isEqual) {
	            var finGuaIndustryRiskRequest = nextProps.finGuaIndustryRiskRequest;
	            var finGuaIndustryRiskResult = nextProps.finGuaIndustryRiskResult;

	            if (finGuaIndustryRiskRequest == true) {
	                if (finGuaIndustryRiskResult.success == true) {
	                    this.dataFomat(finGuaIndustryRiskResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ industryRiskList: content });
	    },
	    orderByField: function orderByField(parm, e) {},
	    handleMore: function handleMore(e) {
	        console.log(e);
	        var left = e.screenX - 500;
	        var top = e.screenY - 310;
	        $('.industry-risk-more').css({
	            position: 'fixed',
	            left: left + 'px',
	            top: top + 'px',
	            display: 'block'
	        });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'industry-risk mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '股东行业风险'
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
	                                    { width: '20%', className: 'talign-left' },
	                                    '公司名'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    'P2P关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '私募基金关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '22%' },
	                                    '线下理财关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '13%' },
	                                    '更多'
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
	                            this.state.industryRiskList.map(function (elem, index) {
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.p2p
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', onClick: this.handleMore },
	                                                '更多'
	                                            )
	                                        )
	                                    );
	                                }{
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.p2p
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', onClick: this.handleMore },
	                                                '更多'
	                                            )
	                                        )
	                                    );
	                                }
	                            }.bind(this))
	                        )
	                    )
	                )
	            ),
	            _react2.default.createElement(_IndustryRiskMore2.default, null)
	        );
	    }
	});
	module.exports = FinanceGuaraIndustryRisk;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinanceGuaraIndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 785:
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

	//股东行业风险更多
	var IndustryRiskMore = _react2.default.createClass({
	   displayName: 'IndustryRiskMore',

	   getInitialState: function getInitialState() {
	      return {};
	   },
	   closeClick: function closeClick(e) {
	      $(this.refs.industryRiskMore).hide();
	   },
	   render: function render() {
	      return _react2.default.createElement(
	         'div',
	         { className: 'industry-risk-more', ref: 'industryRiskMore' },
	         _react2.default.createElement(
	            'div',
	            { className: 'title' },
	            _react2.default.createElement(
	               'span',
	               null,
	               'P2P关联'
	            ),
	            _react2.default.createElement(
	               'span',
	               null,
	               '私募基金关联'
	            ),
	            _react2.default.createElement(
	               'span',
	               null,
	               '线下理财关联'
	            ),
	            _react2.default.createElement('i', { className: 'iconfont icon-guanbi', onClick: this.closeClick })
	         ),
	         _react2.default.createElement(
	            'div',
	            { className: 'content' },
	            _react2.default.createElement(
	               'ul',
	               { className: 'left' },
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               )
	            ),
	            _react2.default.createElement(
	               'ul',
	               { className: 'middle' },
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               )
	            ),
	            _react2.default.createElement(
	               'ul',
	               { className: 'right' },
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               ),
	               _react2.default.createElement(
	                  'li',
	                  null,
	                  '上海贝电实业（集团）股份有限公司'
	               )
	            )
	         )
	      );
	   }
	});
	module.exports = IndustryRiskMore;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRiskMore.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 786:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(775);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//大额被担保人信息列表
	var LargeGuara = _react2.default.createClass({
	    displayName: 'LargeGuara',

	    getInitialState: function getInitialState() {
	        return {
	            count: 0,
	            largeGuaraList: [],
	            orderByField: 1,
	            nowpage: 1
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var jsonData = { pageSize: 4 };
	        this.getLargeGuara(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.largeGuaraRequest, this.props.largeGuaraResult);
	        if (!isEqual) {
	            var largeGuaraRequest = nextProps.largeGuaraRequest;
	            var largeGuaraResult = nextProps.largeGuaraResult;

	            if (largeGuaraRequest == true) {
	                if (largeGuaraResult.success == true) {
	                    this.dataFomat(largeGuaraResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content.list;
	        var count = data.content.pagination.count;
	        this.setState({ count: count, largeGuaraList: content });
	    },
	    getLargeGuara: function getLargeGuara(jsonData) {
	        var getLargeGuara = this.props.getLargeGuara;

	        getLargeGuara(jsonData);
	    },
	    //分页回调 
	    setCallBack: function setCallBack(nowpage, eachPageCount) {
	        this.setState({ nowpage: nowpage });
	        var orderByField = this.state.orderByField;
	        var descAsc = this.state.descAsc;

	        var jsonData = { orderByField: orderByField, descAsc: descAsc, pageSize: 4, pageNumber: nowpage };
	        this.getLargeGuara(jsonData);
	    },
	    orderByField: function orderByField(parm, e) {
	        console.log(parm, e);
	        var $this = $(e.target).parent('th');
	        var $i = $this.find('i');
	        var isDesc = $i.hasClass('icon-desc');
	        var descAsc = "";
	        if (isDesc == true) {
	            $i.removeClass('icon-desc').addClass('icon-asc');
	            descAsc = "asc";
	        } else {
	            $i.removeClass('icon-asc').addClass('icon-desc');
	            descAsc = "desc";
	        }

	        this.setState({ orderByField: parm, descAsc: descAsc });
	        var nowpage = this.state.nowpage;

	        var orderByField = parm;
	        var jsonData = { orderByField: orderByField, descAsc: descAsc, pageSize: 4, pageNumber: nowpage };
	        this.getLargeGuara(jsonData);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'large-loan mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '大额借款人信息列表'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
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
	                                { width: '20%', className: 'talign-left', onClick: this.orderByField.bind(this, 1) },
	                                '担保公司',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { width: '25%', onClick: this.orderByField.bind(this, 2) },
	                                '被担保公司',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { width: '30%', onClick: this.orderByField.bind(this, 3) },
	                                '被担保公司行业',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { width: '25%', onClick: this.orderByField.bind(this, 4) },
	                                '注册资本',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tbody',
	                        null,
	                        this.state.largeGuaraList.map(function (elem, index) {
	                            if (index % 2) {
	                                return _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.borrowerName },
	                                            elem.guaranteeName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.lenderName },
	                                            elem.guaranteedName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.guaranteedBusinessType
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.guaranteedRegisteredCapital
	                                    )
	                                );
	                            }{
	                                return _react2.default.createElement(
	                                    'tr',
	                                    { className: 'even' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.borrowerName },
	                                            elem.guaranteeName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.lenderName },
	                                            elem.guaranteedName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.guaranteedBusinessType
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.guaranteedRegisteredCapital
	                                    )
	                                );
	                            }
	                        }.bind(this))
	                    )
	                ),
	                _react2.default.createElement(_index.PageList, { id: 'large-loan-page', count: this.state.count, showPage: '3', callback: this.setCallBack })
	            )
	        );
	    }
	});
	module.exports = LargeGuara;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LargeGuara.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 813:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(807);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _ScatterChart = __webpack_require__(739);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//贷款余额
	var LoanBalance = _react2.default.createClass({
	  displayName: 'LoanBalance',

	  getInitialState: function getInitialState() {
	    return {
	      option: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.loanBalanceData, this.props.loanBalanceData);
	    if (!isEqual) {
	      var loanBalanceData = nextProps.loanBalanceData;

	      this.dataFomat(loanBalanceData);
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var option = {
	      id: 'loan-balance-chart', //必传
	      height: '272px', //必传 带上单位
	      title: '',
	      forMaterTitle: "贷款余额",
	      forMaterTip: '平均贷款余额',
	      legend: [],
	      yAxisName: '亿元',
	      xAxis: data.xAxis,
	      yAxis: data.yAxis,
	      data: data.data,
	      series: [[{
	        color: '#e14340'
	      }]]
	    };
	    this.setState({ option: option });
	  },
	  render: function render() {
	    var bbdScatter = "";
	    if (this.state.option) {
	      bbdScatter = _react2.default.createElement(_ScatterChart2.default, { param: this.state.option });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'loan-balance mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '贷款余额'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'chart-box' },
	          bbdScatter
	        )
	      )
	    );
	  }
	});
	module.exports = LoanBalance;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LoanBalance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 819:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".p2p-index .radius4,\r\n.p2p-portrait .radius4 {\r\n\tborder-radius: 5px;\t/*background: #2b323c;*/\r\n}\r\n\r\n.p2p-index .p2p-index-content,\r\n.p2p-portrait .p2p-portrait-content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.p2p-index .p2p-index-top .top-r {\r\n\twidth: 32.5%;\r\n\theight: 649px;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-index .p2p-index-bom .bom-r td a {\r\n\tcolor: #e14340\r\n}\r\n\r\n.header-gray .title {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tmargin-left: 30px;\r\n}\r\n\r\n.p2p-index .wtyh-table td {\r\n\tpadding: 16px 0px;\t/*padding: 0px 0px !important;*/\r\n}\r\n\r\n.p2p-portrait .list-items .wtyh-table td {\r\n\tpadding: 0px 0px;\t/*padding: 0px 0px !important;*/\r\n}\r\n\r\n.v-aglign-t {\r\n\tvertical-align: top;\r\n}", ""]);

	// exports


/***/ },

/***/ 820:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getp2pindexRequest = getp2pindexRequest;
	exports.getAreaRankRequest = getAreaRankRequest;
	exports.getNetCreditRequest = getNetCreditRequest;
	/*
	 P2P平台监测
	*/

	/*chart所有图表begin*/
	var P2PINDEX_REQUEST_SUCCESS = exports.P2PINDEX_REQUEST_SUCCESS = 'P2PINDEX_REQUEST_SUCCESS';
	var P2PINDEX_REQUEST_FAIL = exports.P2PINDEX_REQUEST_FAIL = 'P2PINDEX_REQUEST_FAIL';

	function p2pindexRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: P2PINDEX_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function p2pindexRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: P2PINDEX_REQUEST_FAIL,
	    result: result
	  };
	}

	function getp2pindexRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/integrated.do", //"/data/industryMonitor/p2p/index/indexChart.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(p2pindexRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(p2pindexRequestFail(result));
	      }
	    });
	  };
	}
	/*chart所有图表end*/

	/*  上海区域发展指数排名begin*/
	var AREARANK_REQUEST_SUCCESS = exports.AREARANK_REQUEST_SUCCESS = 'AREARANK_REQUEST_SUCCESS';
	var AREARANK_REQUEST_FAIL = exports.AREARANK_REQUEST_FAIL = 'AREARANK_REQUEST_FAIL';

	function areaRankRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: AREARANK_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function areaRankRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: AREARANK_REQUEST_FAIL,
	    result: result
	  };
	}

	function getAreaRankRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/areaIndex.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(areaRankRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(areaRankRequestFail(result));
	      }
	    });
	  };
	}
	/*上海区域发展指数排名end


	/*  网贷平台数据展示begin*/
	var NETCREDIT_REQUEST_SUCCESS = exports.NETCREDIT_REQUEST_SUCCESS = 'NETCREDIT_REQUEST_SUCCESS';
	var NETCREDIT_REQUEST_FAIL = exports.NETCREDIT_REQUEST_FAIL = 'NETCREDIT_REQUEST_FAIL';

	function netCreditRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NETCREDIT_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function netCreditRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NETCREDIT_REQUEST_FAIL,
	    result: result
	  };
	}

	function getNetCreditRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/platRankData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(netCreditRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(netCreditRequestFail(result));
	      }
	    });
	  };
	}
	/*网贷平台数据展示end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 826:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(822);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	var AareaRanking = _react2.default.createClass({
					displayName: 'AareaRanking',

					getInitialState: function getInitialState() {
									return {
													listData: []
									};
					},
					componentDidMount: function componentDidMount() {
									var getAreaRankRequest = this.props.getAreaRankRequest;

									var jsonData = {};
									getAreaRankRequest(jsonData);
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.areaRankingRequest, this.props.areaRankingResult);
									if (!isEqual) {
													var areaRankingRequest = nextProps.areaRankingRequest;
													var areaRankingResult = nextProps.areaRankingResult;

													if (areaRankingRequest == true) {
																	console.log("redux测试成功=================areaRankingRequest");
																	if (areaRankingResult.success) {
																					this.setState({ listData: areaRankingResult.content });
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
																	{ className: 'mod-title' },
																	_react2.default.createElement(
																					'h3',
																					null,
																					'上海区域发展指数'
																	)
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'list-items' },
																	_react2.default.createElement(
																					'table',
																					{ className: 'p2p-table  table-8 mt-table wtyh-table' },
																					_react2.default.createElement(
																									'tHead',
																									null,
																									_react2.default.createElement(
																													'tr',
																													null,
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	'省份'
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'生态环境'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'规模'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'人气'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'安全'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'资本认可'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'综合竞争'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													),
																													_react2.default.createElement(
																																	'th',
																																	null,
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'title' },
																																					'上半年排名'
																																	),
																																	_react2.default.createElement(
																																					'span',
																																					{ className: 'nume' },
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													)
																									)
																					),
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
																																													item.area
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.ecosystem
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.scale
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.popularity
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.safety
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.recognition
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.competitiveness
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									)
																																					);
																																	} else {
																																					return _react2.default.createElement(
																																									'tr',
																																									{ className: 'odd-line' },
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.area
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.ecosystem
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.scale
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.popularity
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.safety
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.recognition
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.competitiveness
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													item.rank
																																									)
																																					);
																																	}
																													}
																									})
																					)
																	)
													)
									);
					}
	});

	module.exports = AareaRanking;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "areaRanking.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 831:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(818);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(741);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _baseMsg = __webpack_require__(832);

	var _baseMsg2 = _interopRequireDefault(_baseMsg);

	var _companyMsg = __webpack_require__(835);

	var _companyMsg2 = _interopRequireDefault(_companyMsg);

	var _coreData = __webpack_require__(836);

	var _coreData2 = _interopRequireDefault(_coreData);

	var _litigation = __webpack_require__(838);

	var _litigation2 = _interopRequireDefault(_litigation);

	var _publicOpinion = __webpack_require__(839);

	var _publicOpinion2 = _interopRequireDefault(_publicOpinion);

	var _rankPic = __webpack_require__(840);

	var _rankPic2 = _interopRequireDefault(_rankPic);

	var _scoreLeida = __webpack_require__(841);

	var _scoreLeida2 = _interopRequireDefault(_scoreLeida);

	var _P2PPortraitAction = __webpack_require__(843);

	var P2PPortraitCreaters = _interopRequireWildcard(_P2PPortraitAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//p2p平台画像
	//动态图谱
	//诉讼信息
	//公司基本信息
	var P2PPortrait = _react2.default.createClass({
	    displayName: 'P2PPortrait',

	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-portrait', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-portrait-content' },
	                '',
	                _react2.default.createElement(
	                    'div',
	                    { className: 'clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-left' },
	                        _react2.default.createElement(_companyMsg2.default, this.props),
	                        _react2.default.createElement(_baseMsg2.default, this.props),
	                        _react2.default.createElement(_rankPic2.default, this.props)
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-right' },
	                        _react2.default.createElement(_scoreLeida2.default, this.props),
	                        _react2.default.createElement(_coreData2.default, this.props)
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'portrait-bottom  clearfix' },
	                    _react2.default.createElement(_litigation2.default, this.props),
	                    _react2.default.createElement(_publicOpinion2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PPortrait;

	//将 request  result 绑定到props的request result
	//评分雷达图
	//平台舆情
	//核心数据
	//基本信息
	function mapStateToProps(state) {
	    return {
	        baseMsgRequest: state.BaseMsg.request,
	        baseMsgResult: state.BaseMsg.result,

	        companyMsgRequest: state.CompanyMsg.request,
	        companyMsgResult: state.CompanyMsg.result,

	        coreDataRequest: state.CoreData.request,
	        coreDataResult: state.CoreData.result,

	        coreBarRequest: state.CoreBar.request,
	        coreBarResult: state.CoreBar.result,

	        coreTrendRequest: state.CoreTrend.request,
	        coreTrendResult: state.CoreTrend.result,

	        coreBalanceRequest: state.CoreBalance.request,
	        coreBalanceResult: state.CoreBalance.result,

	        litigationRequest: state.Litigation.request,
	        litigationResult: state.Litigation.result,

	        publicOpinionRequest: state.PublicOpinion.request,
	        publicOpinionResult: state.PublicOpinion.result,

	        rankPicRequest: state.RankPic.request,
	        rankPicResult: state.RankPic.result,

	        scoreLeidaRequest: state.ScoreLeida.request,
	        scoreLeidaResult: state.ScoreLeida.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PPortraitCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PPortrait);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Portrait.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

			var jsonData = {};
			getbaseMsgRequest(jsonData);
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
							platformName: "陆金所",
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

/***/ 834:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".p2p-portrait {\r\n}\r\n\r\n.p2p-portrait .portrait-left {\r\n\twidth: 45%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right {\r\n\twidth: 54.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom {\r\n\twidth: 100%;\r\n\tmargin-top: 0.5%\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t {\r\n\twidth: 100%;\r\n\theight: 180px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m {\r\n\twidth: 100%;\r\n\theight: 275px;\r\n\tmargin: 1.5% 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-b {\r\n\twidth: 100%;\r\n\theight: 815px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t {\r\n\twidth: 100%;\r\n\theight: 464px\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b {\r\n\twidth: 100%;\r\n\theight: 815px;\r\n\tmargin-top: 1.4%;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l {\r\n\twidth: 24%;\r\n\theight: 255px;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-r {\r\n\twidth: 75.5%;\r\n\theight: 255px;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\tdisplay: table;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul li {\r\n\tdisplay: table-cell;\r\n\tvertical-align: middle;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul span {\r\n\tdisplay: block;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .score {\r\n\tfont-size: 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .score-title {\r\n\tfont-size: 18px;\r\n\tcolor: #fff\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .state {\r\n\tfont-size: 24px;\r\n\tcolor: #fff\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table {\r\n\theight: 180px;\r\n\tcolor: #dddddd\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table td {\r\n\tcolor: #dddddd;\r\n\tpadding-left: 20px !important;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table td .word-limit-5 {\r\n\twidth: 200px\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .list-items {\r\n\tpadding: 10px 10px 0px 10px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content {\r\n\tpadding: 65px 43px 20px 43px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul {\r\n\tdisplay: table;\r\n\twidth: 100%;\r\n\tposition: relative;\r\n\tpadding-bottom: 20px;\r\n\ttext-align: center;\r\n\tborder-bottom: 1px #00b8ee solid;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul:before {\r\n\tcontent: \"\";\r\n\theight: 50%;\r\n\twidth: 1px;\r\n\tbackground: #00b8ee;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n\tleft: 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul:after {\r\n\tcontent: \"\";\r\n\theight: 50%;\r\n\twidth: 1px;\r\n\tbackground: #00b8ee;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n\tright: 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul li {\r\n\tdisplay: table-cell;\r\n\twidth: 33.3%;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .icon-susong {\r\n\tdisplay: inline-block;\r\n\tfont-size: 60px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .ssong-title {\r\n\tfont-size: 18px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .ssong-num {\r\n\tfont-size: 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .content {\r\n\tmargin: 20px;\r\n\theight: 170px;\r\n\tbackground: #212831;\r\n\toverflow: auto;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .serial-num {\r\n\twidth: 25px;\r\n\theight: 25px;\r\n\tline-height: 25px;\r\n\ttext-align: center;\r\n\tbackground: #1a2029;\r\n\tcolor: #fff;\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item a {\r\n\tcolor: #e14340\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item {\r\n\tcolor: #d9d9d9;\r\n\tpadding: 11px 30px 11px 30px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item table {\r\n\twidth: 100%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .item-mark {\r\n\ttext-indent: 30px;\r\n\tpadding: 10px 0px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item  .td2-l {\r\n\twidth: 5%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item  .td2-r {\r\n\twidth: 95%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .soure,\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .time {\r\n\tcolor: #999999\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .time {\r\n\tdisplay: inline-block;\r\n\tmargin-left: 20px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .content {\r\n\tpadding: 15px  50px 0px 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t ul {\r\n\tdisplay: table;\r\n\twidth: 100%;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t ul li {\r\n\tdisplay: table-cell;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l {\r\n\twidth: 15%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-c {\r\n\twidth: 53%;\r\n\tmargin-right: 2%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r {\r\n\twidth: 30%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l .socre-title {\r\n\tfont-size: 30px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l .score {\r\n\tfont-size: 52px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r table {\r\n\r\n\t/*text-align: center;*/\r\n\twidth: 100%;\r\n\theight: 380px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r p {\r\n\tfont-size: 32px;\r\n\tcolor: #fdba45\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t  .leida-c-pic {\r\n\theight: 382px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r span {\r\n\tfont-size: 16px;\r\n\tcolor: #dddddd\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .content {\r\n\tpadding: 40px 30px;\r\n\theight: 760px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top {\r\n\theight: 50%;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top table {\r\n\twidth: 100%;\r\n\theight: 90%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom .bottom-line-left {\r\n\twidth: 50%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom .bottom-line-right {\r\n\twidth: 50%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top table  td {\r\n\twidth: 50%;\r\n\tcolor: #dddddd;\r\n\tpadding-left: 30px !important;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top .top-list {\r\n\theight: 100%;\r\n\twidth: 40%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top .top-bar {\r\n\theight: 100%;\r\n\twidth: 55%;\r\n\tfloat: right;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom {\r\n\theight: 50%\r\n}\r\n\r\n.p2p-portrait .relation-legend table {\r\n\twidth: 100%\r\n}\r\n\r\n.p2p-portrait .relation-modal {\r\n\tdisplay: none;\r\n}\r\n\r\n.p2p-portrait .linefin-rel-graph .mod-content .relation-graph-box {\r\n\theight: 640px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.p2p-portrait  .linefin-rel-graph {\r\n\theight: 815px\r\n}\r\n\r\n.p2p-portrait .relation-legend table tr td {\r\n\twidth: 19.8%;\r\n}\r\n\r\n.p2p-portrait .relation-legend {\r\n\tmargin: 25px 10px 15px 10px;\r\n\twidth: auto;\r\n}\r\n\r\n.p2p-portrait  .relation-legend table tr .square,\r\n.p2p-portrait   .relation-legend table tr .round {\r\n\tmargin-right: 5px;\r\n}\r\n\r\n.p2p-portrait  .relation-legend table tr .square {\r\n\twidth: 10px;\r\n\theight: 10px;\r\n}\r\n\r\n.p2p-portrait   .relation-legend table tr .round {\r\n\twidth: 10px;\r\n\theight: 10px;\r\n}", ""]);

	// exports


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

		// setParm:function(){
		// 	const option ={
		//         title:"平台交易量走势",
		//         titleX:"center",
		//         color:["#e14340"],
		//         titleShow:true,
		//         barWidth:15,
		//         yAxisName:"万元",
		//         yFlag:"",//y轴单位
		//            gridBottom:'0',
		//            gridTop:'15%',
		//         legend:["成交量"],
		//         legendShow:false,
		//         xAxis:[
		//         		'2016-08-01',
		//         		'2016-08-02',
		//         		'2016-08-03',
		//         		'2016-08-04',
		//         		'2016-08-05',
		//         		'2016-08-06',
		//         		'2016-08-07',
		//         		'2016-08-08',
		//         		'2016-08-09',
		//         		'2016-08-10',
		//         		'2016-08-11',
		//         		'2016-08-12',
		//         		'2016-08-13',
		//         		'2016-08-14',
		//         		'2016-08-15',
		//         	],
		//         series:[
		//             [
		//             	Math.round(Math.random() * 1000),
		//             	Math.round(Math.random() * 1000),
		//             	Math.round(Math.random() * 1000),
		//             	Math.round(Math.random() * 1000),
		//             	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		//              	Math.round(Math.random() * 1000),
		// 				Math.round(Math.random() * 1000),
		// 				Math.round(Math.random() * 1000),
		// 				Math.round(Math.random() * 1000),
		// 				Math.round(Math.random() * 1000)
		//             ]
		//         ]
		//     };
		//         return option;
		// },
		setLineLParm: function setLineLParm() {
			var option = {
				color: ["#00b7ee", "#f8b551"],
				title: "平台利率走势",
				titleShow: true,
				titleX: "center",
				boxId: "chartMap",
				symbolSize: 5,
				legendIsShow: false,
				yFlag: "%",
				yAxisName: "",
				legendRight: "30",
				legend: ["利率"],
				xAxis: ['2016-08-01', '2016-08-02', '2016-08-03', '2016-08-04', '2016-08-05', '2016-08-06', '2016-08-07', '2016-08-08', '2016-08-09', '2016-08-10', '2016-08-11', '2016-08-12', '2016-08-13', '2016-08-14', '2016-08-15'],
				series: [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]]
			};
			return option;
		},

		setLineRParm: function setLineRParm() {
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
				xAxis: ['2016-08-01', '2016-08-02', '2016-08-03', '2016-08-04', '2016-08-05', '2016-08-06', '2016-08-07', '2016-08-08', '2016-08-09', '2016-08-10', '2016-08-11', '2016-08-12', '2016-08-13', '2016-08-14', '2016-08-15'],
				series: [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]]
			};
			return option;
		},

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

			getcoreDataRequest({ "platName": "" });
			getCoreBarDataRequest({ "plat_name": "" });
			getCoreTrendDataRequest({ "plat_name": "" });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.coreDataRequest, this.props.coreDataResult);
			if (!isEqual) {
				var coreDataRequest = nextProps.coreDataRequest;
				var coreDataResult = nextProps.coreDataResult;

				if (coreDataRequest == true) {
					if (coreDataResult.success) {
						var _setParm = [{ name: "待还借款人数", value: "21564" }, { name: "最大单户借款额", value: "1213.65" }, { name: "最大十户借款额", value: "7984.36" }, { name: "近30日资产流入", value: "18" }, { name: "贷款余额", value: "21564" }, { name: "累计成交量", value: "31.21" }, { name: "平均利率", value: "6.532" }];
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
		},
		render: function render() {
			var chartBoxBar = "",
			    chartBoxTrend = "";
			if (this.state.coreBarData) {
				chartBoxBar = _react2.default.createElement(_BarChart2.default, { option: this.state.coreBarData, style: { height: '270px', width: '100%' } });
			}
			if (this.state.coreTrendData) {
				chartBoxTrend = _react2.default.createElement(_LineChart2.default, { option: this.state.coreTrendData, style: { height: '320px', width: '100%' } });
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
							_react2.default.createElement(_LineChart2.default, {
								option: this.setLineRParm(),
								style: { height: '320px', width: '100%' } })
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
	      url: "/P2PImage/coreDataDealTrend.do",
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
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
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

	var _realtimeTableRuducer = __webpack_require__(978);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

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

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*众筹监测 end*/

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次


	/*p2p画像平台 end*/

	/*实时监测 begin*/
	//左侧表格

	//动态图谱

	//诉讼信息

	//核心数据

	/*p2p平台首页 end*/

	/*p2p画像平台 begin*/
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

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	//列表

	//6月上海各类众筹平台新增项目数

	/*实时监测 end*/

	/*众筹监测 begin*/
	//业务类型

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表

	/*p2p平台首页 begin*/
	//P2P平台监测

	//上海区域发展指数排名


	/*行业监测模块*/

	//小额贷款

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1282:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getFinGuaCompanyGrade = getFinGuaCompanyGrade;
	exports.getfinGuaMap = getfinGuaMap;
	exports.getFinGuaDutyBalance = getFinGuaDutyBalance;
	exports.getFinGuaIndustryRisk = getFinGuaIndustryRisk;
	exports.getLargeGuara = getLargeGuara;
	/*
	  融资担保模块action
	*/

	/*企业评级begin*/
	var FINGUA_COMPANYGRADE_SUCCESS = exports.FINGUA_COMPANYGRADE_SUCCESS = 'FINGUA_COMPANYGRADE_SUCCESS';
	var FINGUA_COMPANYGRADE_FAIL = exports.FINGUA_COMPANYGRADE_FAIL = 'FINGUA_COMPANYGRADE_FAIL';

	function finGuaCompanyGradeSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FINGUA_COMPANYGRADE_SUCCESS,
	    result: result
	  };
	}
	function finGuaCompanyGradeFail(result) {
	  //请求失败调用方法
	  return {
	    type: FINGUA_COMPANYGRADE_FAIL,
	    result: result
	  };
	}

	function getFinGuaCompanyGrade(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /guarantee/companyLevel.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(finGuaCompanyGradeSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(finGuaCompanyGradeFail(result));
	      }
	    });
	  };
	}
	/*企业评级end*/

	/*地图模块begin*/
	var FINGUA_MAP_SUCCESS = exports.FINGUA_MAP_SUCCESS = 'FINGUA_MAP_SUCCESS';
	var FINGUA_MAP_FAIL = exports.FINGUA_MAP_FAIL = 'FINGUA_MAP_FAIL';

	function finGuaMapSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FINGUA_MAP_SUCCESS,
	    result: result
	  };
	}
	function finGuaMapFail(result) {
	  //请求失败调用方法
	  return {
	    type: FINGUA_MAP_FAIL,
	    result: result
	  };
	}

	function getfinGuaMap(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/guarantee/areaStatistic.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(finGuaMapSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(finGuaMapFail(result));
	      }
	    });
	  };
	}
	/*地图模块end*/

	/*担保责任余额 本接口可以用于“担保责任余额”，“担保责任余额结构分布”，“担保笔均折线图” 三个图表 begin*/
	var FINGUA_DUTY_SUCCESS = exports.FINGUA_DUTY_SUCCESS = 'FINGUA_DUTY_SUCCESS';
	var FINGUA_DUTY_FAIL = exports.FINGUA_DUTY_FAIL = 'FINGUA_DUTY_FAIL';

	function finGuaDutySuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FINGUA_DUTY_SUCCESS,
	    result: result
	  };
	}

	function finGuaDutyFail(result) {
	  //请求失败调用方法
	  return {
	    type: FINGUA_DUTY_FAIL,
	    result: result
	  };
	}

	function getFinGuaDutyBalance(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/guarantee/balance.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(finGuaDutySuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(finGuaDutyFail(result));
	      }
	    });
	  };
	}
	/*担保责任余额 本接口可以用于“担保责任余额”，“担保责任余额结构分布”，“担保笔均折线图” 三个图表 end*/

	/*股东行业风险 begin*/
	var FINGUA_INDUSTRYRISK_SUCCESS = exports.FINGUA_INDUSTRYRISK_SUCCESS = 'FINGUA_INDUSTRYRISK_SUCCESS';
	var FINGUA_INDUSTRYRISK_FAIL = exports.FINGUA_INDUSTRYRISK_FAIL = 'FINGUA_INDUSTRYRISK_FAIL';

	function finGuaIndustryRiskSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FINGUA_INDUSTRYRISK_SUCCESS,
	    result: result
	  };
	}

	function finGuaIndustryRiskFail(result) {
	  //请求失败调用方法
	  return {
	    type: FINGUA_INDUSTRYRISK_FAIL,
	    result: result
	  };
	}

	function getFinGuaIndustryRisk(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/guarantee/shareholderRisk.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(finGuaIndustryRiskSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(finGuaIndustryRiskFail(result));
	      }
	    });
	  };
	}
	/*股东行业风险  end*/

	/*大额被担保人信息列表 begin*/
	var LARGE_GUARA_SUCCESS = exports.LARGE_GUARA_SUCCESS = 'LARGE_GUARA_SUCCESS';
	var LARGE_GUARA_FAIL = exports.LARGE_GUARA_FAIL = 'LARGE_GUARA_FAIL';

	function largeGuaraSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LARGE_GUARA_SUCCESS,
	    result: result
	  };
	}

	function largeGuaraFail(result) {
	  //请求失败调用方法
	  return {
	    type: LARGE_GUARA_FAIL,
	    result: result
	  };
	}

	function getLargeGuara(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/guarantee/largeGuaranteeList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(largeGuaraSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(largeGuaraFail(result));
	      }
	    });
	  };
	}
	/*大额被担保人信息列表  end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinanceGuaraIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1283:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = finGuaMap;

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	//地图
	function finGuaMap() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.FINGUA_MAP_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.FINGUA_MAP_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinGuaMap.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1284:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = finGuaCompanyGrade;

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	//企业评级
	function finGuaCompanyGrade() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.FINGUA_COMPANYGRADE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.FINGUA_COMPANYGRADE_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinGuaCompanyGrade.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
			case _FinanceGuaraIndexAction.GUARADUTY_BALANCE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.GUARADUTY_BALANCE_FAIL:
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

/***/ 1286:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = FinGuaIndustryRisk;

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	//股东行业风险
	function FinGuaIndustryRisk() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.FINGUA_INDUSTRYRISK_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.FINGUA_INDUSTRYRISK_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinGuaIndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1287:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = largeGuara;

	var _FinanceGuaraIndexAction = __webpack_require__(1282);

	//大额被担保人人信息列表
	function largeGuara() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.LARGE_GUARA_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.LARGE_GUARA_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LargeGuara.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1288:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CoreBar;

	var _P2PPortraitAction = __webpack_require__(843);

	function CoreBar() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.COREBAR_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.COREBAR_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CoreBar.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1289:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CoreTrend;

	var _P2PPortraitAction = __webpack_require__(843);

	function CoreTrend() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.CORETREND_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.CORETREND_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CoreTrend.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1290:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CoreBalance;

	var _P2PPortraitAction = __webpack_require__(843);

	function CoreBalance() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.COREBALANCE_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PPortraitAction.COREBALANCE_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CoreBalance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})