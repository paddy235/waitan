webpackHotUpdate(0,{

/***/ 738:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//散点图 横坐标为时间

	/*
	  调用方式：
	     var param={
	            id:'loan-balance-chart',//必传
	            height:'272px',//必传 带上单位
	            title:'贷款余额',
	            legend: [],
	            xAxis:['2010', '2011', '2012','2013', '2014', '2015', '2016'],
	            yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	            data: [[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	            series:[
	                    [{
	                      color:'#e14340'
	                    }]
	                  ]
	        }
	*/
	var ScatterChart = _react2.default.createClass({
	    displayName: 'ScatterChart',

	    componentDidMount: function componentDidMount() {
	        var id = this.props.param.id;
	        var bubbleChart = echarts.init(document.getElementById(id));
	        var param = this.props.param;
	        var option = this.setOption(param);
	        bubbleChart.setOption(option);
	        this.resizeChart(bubbleChart);
	    },
	    resizeChart: function resizeChart(bubbleChart) {
	        //容器发生改变时重新设置图表大小
	        $(window).resize(function () {
	            bubbleChart.resize();
	        });
	    },
	    setOption: function setOption(param) {
	        console.log(param.xAxis);
	        var seriesData = [];
	        for (var i = 0; i < param.data.length; i++) {
	            var eachSeriesData = {};
	            seriesData.push(eachSeriesData);
	        }

	        var option = {
	            title: {
	                text: param.title || "",
	                textStyle: {
	                    fontSize: 14,
	                    color: "#fff",
	                    fontFamily: "microsoft yahei",
	                    fontWeight: "normal"

	                },
	                top: "8%"
	            },
	            legend: {
	                data: [],
	                left: 'right'
	            },
	            tooltip: {
	                position: 'top',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(data) {
	                    console.log(data);
	                    if (!param.formatter) {
	                        //典当总额业务笔数
	                        return data.name + ' 年<br/> ' + param.forMaterTitle + '：&nbsp ' + data.data[2] + "亿元<br/>" + param.forMaterTip + "：&nbsp  " + data.data[2] + "万元";
	                    } else {
	                        return data.value[2] + ' commits in ' + ' of ' + param.xAxis[data.value[1]];
	                    }
	                }
	            },
	            grid: {
	                top: param.gridTop || '15%',
	                left: '5%',
	                bottom: '5%',
	                right: '5%',
	                containLabel: true
	            },
	            xAxis: {
	                type: 'category',
	                data: param.xAxis,
	                boundaryGap: false,
	                splitLine: {
	                    show: false,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            },
	            yAxis: {
	                type: 'category',
	                name: param.yAxisName == undefined ? "" : param.yAxisName,
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: param.yAxis,
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            },
	            series: [{
	                name: '',
	                type: 'scatter',
	                symbolSize: function symbolSize(val) {
	                    if (val[2] < 10000) {
	                        return val[2] / 1000;
	                    } else if (10000 < val[2] && val[2] < 100000) {
	                        return val[2] / 10000;
	                    } else {
	                        return val[2] / 200000;
	                    }
	                },
	                data: param.data,
	                animationDelay: function animationDelay(idx) {
	                    return idx * 5;
	                }
	            }]
	        };
	        return option;
	    },
	    render: function render() {
	        return _react2.default.createElement('div', { id: this.props.param.id, style: { height: this.props.param.height } });
	    }
	});

	module.exports = ScatterChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 778:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDMap = _react2.default.createClass({
	    displayName: 'BBDMap',

	    propTypes: {
	        option: _react2.default.PropTypes.object.isRequired,
	        style: _react2.default.PropTypes.object,
	        className: _react2.default.PropTypes.string,
	        theme: _react2.default.PropTypes.string,
	        onChartReady: _react2.default.PropTypes.func,
	        showLoading: _react2.default.PropTypes.bool,
	        onEvents: _react2.default.PropTypes.object
	    },
	    setOption: function setOption(parm) {
	        //值阀最大值
	        var maxData = parm.series[0].value;
	        for (var i = 0; i < parm.series.length; i++) {
	            if (Number(parm.series[i].value) > maxData) {
	                maxData = Number(parm.series[i].value);
	            }
	        }
	        var option = {
	            tooltip: {
	                trigger: 'item',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    return v.name + "<br/>" + v.seriesName + ":" + v.value;
	                }
	            },
	            visualMap: {
	                min: 0,
	                max: maxData + 200,
	                itemWidth: "15",
	                textGap: 30,
	                right: parm.visualMapRight == undefined ? "auto" : parm.visualMapRight,
	                bottom: parm.visualMapBottom == undefined ? "auto" : parm.visualMapBottom,
	                padding: [0, 0, 20, 50],
	                text: parm.visualMapText,
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                inRange: {
	                    color: ['rgba(4, 184, 245, 1)', 'rgba(14, 155, 200, 1)', 'rgba(34, 114, 139, 1)']
	                }
	            },
	            series: [{
	                type: 'map',
	                name: parm.seriesName == undefined ? "P2P公司数" : parm.seriesName,
	                map: 'shanghai',
	                animationDurationUpdate: 1000,
	                animationEasingUpdate: 'quinticInOut',
	                itemStyle: {
	                    normal: {
	                        label: {
	                            show: false
	                        },
	                        borderColor: '#a7d1df',
	                        areaColor: '#fff'
	                    },
	                    emphasis: {
	                        label: {
	                            show: false
	                        },
	                        areaColor: '#a7d1df',
	                        borderWidth: 0
	                    }
	                },
	                data: parm.series
	            }]
	        };
	        return option;
	    },
	    componentDidMount: function componentDidMount() {
	        var echartObj = this.renderEchartDom();
	        var onEvents = this.props.onEvents || [];

	        var _loop = function _loop(eventName) {
	            if (typeof eventName === 'string' && typeof onEvents[eventName] === 'function') {
	                echartObj.on(eventName, function (param) {
	                    onEvents[eventName](param, echartObj);
	                });
	            }
	        };

	        for (var eventName in onEvents) {
	            _loop(eventName);
	        }
	        // if (typeof this.props.onChartReady === 'function') this.props.onChartReady(echartObj);
	        // elementResizeEvent(this.refs.echartsDom, function() {
	        // 	echartObj.resize();
	        // });
	        //
	        $(window).resize(function () {
	            echartObj.resize();
	        });
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        this.renderEchartDom();
	    },
	    componentWillUnmount: function componentWillUnmount() {
	        echarts.dispose(this.refs.chart);
	    },
	    renderEchartDom: function renderEchartDom() {
	        var echartObj = this.getEchartsInstance();
	        echartObj.setOption(this.setOption(this.props.option));

	        if (this.props.showLoading) {
	            echartObj.showLoading();
	        } else {
	            echartObj.hideLoading();
	        }
	        return echartObj;
	    },
	    getEchartsInstance: function getEchartsInstance() {
	        return echarts.getInstanceByDom(this.refs.echartsDom) || echarts.init(this.refs.echartsDom, this.props.theme);
	    },
	    render: function render() {
	        var style = this.props.style || {
	            height: '300px'
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDMap;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MapChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 805:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//企业评级
	var CompanyGrade = _react2.default.createClass({
	    displayName: 'CompanyGrade',

	    getInitialState: function getInitialState() {
	        return {
	            companyGradeList: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyGrade = this.props.getCompanyGrade; // 取到props里面的getCompanyGrade方法。也可以说是请求action

	        var jsonData = {};
	        getCompanyGrade(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyGradeRequest, this.props.companyGradeResult); //判断数据是否变化
	        if (!isEqual) {
	            var companyGradeRequest = nextProps.companyGradeRequest;
	            var companyGradeResult = nextProps.companyGradeResult;

	            if (companyGradeRequest == true) {
	                if (companyGradeResult.success == true) {
	                    this.dataFomat(companyGradeResult);
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
	                                            'B'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            'B'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            'B'
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
	                                            'B'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            'B'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            'B'
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
	module.exports = CompanyGrade;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyGrade.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 810:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(756);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//贷款笔均折线图
	var EachAverage = _react2.default.createClass({
	    displayName: 'EachAverage',

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
	            yAxisName: "万元",
	            legend: ["贷款总余额/总笔数"],
	            xAxis: data.xAxis,
	            series: [data.series]
	        };
	        this.setState({ option: option });
	    },
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
	module.exports = EachAverage;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EachAverage.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 811:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _MapChart = __webpack_require__(778);

	var _MapChart2 = _interopRequireDefault(_MapChart);

	var _PieChart = __webpack_require__(779);

	var _PieChart2 = _interopRequireDefault(_PieChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//上海市地图
	var SmallLoanMap = _react2.default.createClass({
	    displayName: 'SmallLoanMap',

	    getInitialState: function getInitialState() {
	        return {
	            mapOption: null,
	            pieOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        console.log(this.props, 3333);
	        var getSmallLoanMap = this.props.getSmallLoanMap;

	        var jsonData = {};
	        getSmallLoanMap(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isMapEqual = Immutable.is(nextProps.smollLoanMapRequest, this.props.smollLoanMapResult);
	        console.log("isMapEqual:", isMapEqual);
	        if (!isMapEqual) {
	            var smollLoanMapRequest = nextProps.smollLoanMapRequest;
	            var smollLoanMapResult = nextProps.smollLoanMapResult;

	            if (smollLoanMapRequest == true) {
	                if (smollLoanMapResult.success == true) {
	                    this.dataFomatMap(smollLoanMapResult);
	                    this.dataFomatPie(smollLoanMapResult);
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
	            { className: 'small-loan-map mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'map-chart-box', id: 'small-loan-map-chart' },
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
	module.exports = SmallLoanMap;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SmallLoanMap.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 812:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _ScatterChart = __webpack_require__(738);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

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
	  // setParam:function(){
	  //     var param={
	  //         id:'loan-balance-chart',//必传
	  //         height:'272px',//必传 带上单位
	  //         title:'',
	  //         forMaterTitle:"贷款余额",
	  //         forMaterTip:'平均贷款余额',
	  //         legend: [],
	  //         yAxisName:'亿元',
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

/***/ 813:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _IndustryRiskMore = __webpack_require__(814);

	var _IndustryRiskMore2 = _interopRequireDefault(_IndustryRiskMore);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	//股东行业风险
	var IndustryRisk = _react2.default.createClass({
	    displayName: 'IndustryRisk',

	    getInitialState: function getInitialState() {
	        return {
	            industryRiskList: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getIndustryRisk = this.props.getIndustryRisk;

	        var jsonData = {};
	        getIndustryRisk(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.industryRiskRequest, this.props.industryRiskResult);
	        if (!isEqual) {
	            var industryRiskRequest = nextProps.industryRiskRequest;
	            var industryRiskResult = nextProps.industryRiskResult;

	            if (industryRiskRequest == true) {
	                if (industryRiskResult.success == true) {
	                    this.dataFomat(industryRiskResult);
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
	module.exports = IndustryRisk;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 815:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//大额借款人信息列表
	var LargeLoan = _react2.default.createClass({
	    displayName: 'LargeLoan',

	    getInitialState: function getInitialState() {
	        return {
	            count: 0,
	            largeLoanList: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        this.getLargeLoan();
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.largeLoanRequest, this.props.largeLoanResult);
	        if (!isEqual) {
	            var largeLoanRequest = nextProps.largeLoanRequest;
	            var largeLoanResult = nextProps.largeLoanResult;

	            if (largeLoanRequest == true) {
	                if (largeLoanResult.success == true) {
	                    this.dataFomat(largeLoanResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content.list;
	        var count = data.content.pagination.count;
	        this.setState({ count: count, largeLoanList: content });
	    },
	    getLargeLoan: function getLargeLoan() {
	        var getLargeLoan = this.props.getLargeLoan;
	        //var jsonData={orderByField:orderByField,descAsc:descAsc,pageSize:pageSize,pageNumber:pageNumber};

	        var jsonData = { pageSize: 4 };
	        getLargeLoan(jsonData);
	    },
	    //分页回调 
	    setCallBack: function setCallBack(nowpage, eachPageCount) {
	        this.setState({ count: 300 });
	    },
	    orderByField: function orderByField(parm, e) {
	        console.log(parm, e);
	        var $this = $(e.target).parent('th');
	        var $i = $this.find('i');
	        var isDesc = $i.hasClass('icon-desc');
	        if (isDesc == true) {
	            $i.removeclass('icon-desc').addClass('icon-asc');
	        }
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
	                                '借款公司',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { width: '25%', onClick: this.orderByField.bind(this, 2) },
	                                '贷款公司',
	                                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { width: '30%', onClick: this.orderByField.bind(this, 3) },
	                                '借款公司行业',
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
	                        this.state.largeLoanList.map(function (elem, index) {
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
	                                            elem.borrowerName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.lenderName },
	                                            elem.lenderName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.borrowerBusinessType
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.borrowerRegisteredCapital
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
	                                            elem.borrowerName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': elem.lenderName },
	                                            elem.lenderName
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.borrowerBusinessType
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        elem.borrowerRegisteredCapital
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
	module.exports = LargeLoan;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LargeLoan.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 819:
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
	      url: "/data/industryMonitor/p2p/index/indexChart.json",
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

/***/ 827:
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
	    color: ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	    title: "贷款余额",
	    titleX: "left",
	    boxId: "chartMap",
	    legendIsShow: true,
	    yFlag: "%",
	    legendRight: "10",
	    legendTop: "-10",
	    symbolSize: 5,
	    yAxisName: "",
	    legend: ["上海问题平台比例", "全国问题平台比例"],
	    xAxis: [],
	    series: []
	};
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    setParm: function setParm() {
	        baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)], [Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20), Math.round(Math.random() * 20)]];

	        return baseParm;
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-l-t-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '问题平台比例'
	                )
	            ),
	            _react2.default.createElement(_LineChart2.default, {
	                option: this.setParm(),
	                style: { height: '205px', width: '100%' } })
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "problemScale.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 829:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(821);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(796);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);
	var baseParm = {
	  color: ["#e14340", "#00b7ee"],
	  barWidth: 20,
	  legendRight: "20",
	  gridLeft: '5%',
	  gridRight: '5%',
	  gridBottom: '0%',
	  gridTop: '15%',
	  titleName: "网贷数据对比(上海VS全国)",
	  legend: ["全国(亿元)", "上海(亿元)"],
	  yAxis: ["成交量", "贷款余额"],
	  series: []
	};
	var NetCreditContrast = _react2.default.createClass({
	  displayName: 'NetCreditContrast',

	  setParm: function setParm() {
	    baseParm.xAxis = ["2016-01", "2016-02", "2016-03", "2016-04", "2016-05", "2016-06", "2016-07", "2016-08"], baseParm.series = [[200, 100], [400, 200]];
	    return baseParm;
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'mod bom-l-b radius4' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '网贷数据对比(上海VS全国)'
	        )
	      ),
	      _react2.default.createElement(_HorizontalBarChart2.default, {
	        option: this.setParm(),
	        style: { height: '180px', width: '100%' } })
	    );
	  }
	});

	module.exports = NetCreditContrast;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCreditContrast.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 906:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*@parkMonitor jifei  图片\r\n---------------------------------------------------------*/\r\n.Imgs{\r\n\twidth: 100%;\r\n\theight: 770px;\r\n    background: url(\"/images/Bg.png\") no-repeat;\r\n    background-size: 100% 770px;\r\n}\r\n/*@parkMonitor 舆情\r\n---------------------------------------------------------*/\r\n.Consensu{\r\n\twidth: 100%;\r\n\theight: 320px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n.Consensu h3{\r\n\tpadding: 15px 20px;\r\n\tcolor: #ddd;\r\n}\r\n.Consensu .box{\r\n\twidth: 99%;\r\n    height: 240px;\r\n    //overflow: auto;\r\n    padding: 0px 0 0 10px;\r\n    margin-top: 15px;\r\n}\r\n.Consensu .box .list{\r\n\twidth: 98%;\r\n\theight: 115px;\r\n\tborder-bottom: 1px solid #484f59;\t\r\n\tbackground: #1b1f28;\r\n}\r\n.Consensu .box .list:nth-child(even){\r\n\tmargin-top: 10px;\r\n\tmargin-bottom: 10px;\r\n}\r\n.Consensu .box .list ul{\r\n\twidth: 100%;\r\n\theight: 105px;\r\n}\r\n.Consensu .box .list li{\r\n    height: 33px;\r\n    line-height: 50px;\r\n    text-indent: 30px;\r\n    font-size: 14px;\r\n}\r\n.Consensu .box .list li:nth-child(1){\r\n\tfont-size: 14px;\r\n\tcolor: #e34f4b;\r\n\tcursor: pointer;\r\n}\r\n.Consensu .box .list li:nth-child(1) .liLeft{\r\n\tmargin-left: 20px;\r\n}\r\n.Consensu .box .list li:nth-child(2){\r\n\tfont-size: 14px;\r\n    cursor: pointer;\r\n    width: 89%;\r\n    overflow: hidden;\r\n    white-space: nowrap;\r\n    text-overflow: ellipsis;\r\n}\r\n.Consensu .box .list li:nth-child(1) a{\r\n\tcolor: #e34f4b;\r\n}\r\n.Consensu .box .list li:nth-child(3) .liRight{\r\n\tfloat: right;\r\n\tpadding-right: 20px;\r\n\tfont-size: 14px;\r\n\tcolor: #8b8f98;\r\n}\r\n.Consensu .box .list li:nth-child(3) .spanLeft{\r\n\tmargin-right: 20px;\r\n}\r\n/*@parkMonitor 类金融企业集中度\r\n---------------------------------------------------------*/\r\n.Finance{\r\n\twidth: 100%;\r\n\theight: 380px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n.Finance h3{\r\n\tpadding: 15px 20px;\r\n\tcolor: #ddd;\r\n}\r\n.Finance .box{\r\n\twidth: 95%;\r\n    height: 255px;\r\n    //border: 1px solid red;\r\n    margin: 40px auto;\r\n}\r\n.Finance .box .item{\r\n\twidth: 95%;\r\n    height: 254px;\r\n    margin: 0 auto;\r\n    overflow: auto; \r\n}\r\n.Finance .box .item ul li{\r\n\twidth: 30%;\r\n    height: 255px;\r\n    //border: 1px solid red;\r\n    display: inline-block;\r\n    text-align: center;\r\n    vertical-align: middle;\r\n    line-height: 77px;\r\n    margin-left: 10px;\r\n}\r\n.Finance .box .item ul li img{\r\n\tcursor: pointer;\r\n}\r\n.Finance .box .item ul li .color{\r\n\tcolor: #9198a2;\r\n}\r\n.Finance .box .item ul li .digit{\r\n\tfont-size: 20px;\r\n\tpadding-right: 10px;\r\n}\r\n.Finance .box .item ul li .solid{\r\n\twidth: 1px;\r\n\theight: 50px;\r\n\tborder: 1px solid #4a515b;\r\n\tvertical-align: top;\r\n}\r\n.Finance .box .item ul li .Yellow{\r\n\tcolor: #e44446;\r\n\tfont-size: 20px;\r\n\tpadding-left: 10px;\r\n}\r\n\r\n/*@parkMonitor 园区行业分布\r\n---------------------------------------------------------*/\r\n.Park{\r\n\twidth: 100%;\r\n\theight: 380px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n/*@parkMonitor 在营时间分布\r\n---------------------------------------------------------*/\r\n.TheCamp{\r\n\twidth: 100%;\r\n\theight: 320px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n   ", ""]);

	// exports


/***/ },

/***/ 907:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(905);

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
	    val: state.selectVal.val
	  };
	})(Consensu);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Consensu.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 908:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(905);

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
	        val: state.selectVal.val
	    };
	})(Finance);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Finance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 909:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(905);

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
	                orient: 'vertical',
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
	        val: state.selectVal.val
	    };
	})(Park);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Park.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 910:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(905);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(796);

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
	        val: state.selectVal.val
	    };
	})(TheCamp);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TheCamp.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 912:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(913);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//import { ImgFinanceval } from '../../ions/parkMonitor/ImgFinancek/ImgFinance'

	//园区监测
	var Img = _react2.default.createClass({
	    displayName: 'Img',

	    //风险等级切换
	    componentDidMount: function componentDidMount() {
	        $(".tabs > table").on("click", "tr", function () {
	            $(this).addClass("trColor").siblings().removeClass("trColor");
	            $(".tabs > table").find('td').removeClass("color");
	            $(this).children('.r').addClass("color");
	        });
	        $(".show").show();
	        $(".tabs > table").on("click", "tr", function () {
	            var index = $(this).index();
	            $(".tableLeft").eq(index).show().siblings(".tableLeft").hide();
	        });
	    },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'Img mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'carousel' },
	                _react2.default.createElement(
	                    'ul',
	                    null,
	                    _react2.default.createElement(
	                        'li',
	                        null,
	                        _react2.default.createElement('i', { className: 'iconfont icon-jianLeft left' })
	                    ),
	                    _react2.default.createElement(
	                        'li',
	                        null,
	                        '国家开发银行大厦'
	                    ),
	                    _react2.default.createElement(
	                        'li',
	                        null,
	                        _react2.default.createElement('i', { className: 'iconfont icon-jianRight right' })
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'tabs' },
	                _react2.default.createElement(
	                    'table',
	                    null,
	                    _react2.default.createElement(
	                        'thead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '风险等级'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '数量'
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tbody',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            { className: 'trColor' },
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Red' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'color r' },
	                                '4'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Yellow' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                '3'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Green' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                '5'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                '0'
	                            )
	                        )
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'onTabs' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tableLeft show' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                            'h3',
	                            null,
	                            '已出风险企业'
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'box' },
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
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxx1xxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tableLeft' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                            'h3',
	                            null,
	                            '已出风险企业'
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'box' },
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
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxx2xxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tableLeft' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                            'h3',
	                            null,
	                            '已出风险企业'
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'box' },
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
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxx3xxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tableLeft' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                            'h3',
	                            null,
	                            '已出风险企业'
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'box' },
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
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxx4xxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            'xxxxxxxxxxxxxx有限公司'
	                                        )
	                                    )
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement('div', { className: 'solidRight' })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'yuan' },
	                _react2.default.createElement('img', { src: '../images/yuan.png' })
	            )
	        );
	    }
	});
	module.exports = Img;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Img.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 914:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*@parkMonitor jifei  图片\r\n---------------------------------------------------------*/\r\n.Img{\r\n\twidth: 100%;\r\n\theight: 948px;\r\n\tbackground: url(\"/images/floor.png\") no-repeat;\r\n\tbackground-size: 100% 948px;\r\n}\r\n.Img .carousel{\r\n\twidth: 160px;\r\n\theight: 30px;\r\n\tbackground: #e2f1fc;\r\n\tborder-radius: 3px;\r\n\tposition: relative;\r\n    top: 10px;\r\n    left: 10px;\r\n}\r\n.Img .carousel ul li{\r\n\tdisplay: inline-block;\r\n\tvertical-align: middle;\r\n\tline-height: 30px;\r\n}\r\n.Img .carousel ul li:nth-child(1){\r\n\twidth: 15%;\r\n\theight: 30px;\r\n}\r\n.Img .carousel ul li:nth-child(2){\r\n\twidth: 70%;\r\n\theight: 30px;\r\n\ttext-align: center;\r\n\tline-height: 30px;\r\n\tcolor: #1a2029;\r\n}\r\n.Img .carousel ul li:nth-child(3){\r\n\twidth: 15%;\r\n\theight: 30px;\r\n}\r\n.Img .carousel .left{\r\n\tline-height: 30px;\r\n\tmargin-left: 3px;\r\n\tcolor: #1a2029;\r\n\tfont-size: 18px;\r\n\tcursor: pointer;\r\n}\r\n.Img .carousel .right{\r\n\tline-height: 30px;\r\n\tmargin-left: 5px;\r\n\tcolor: #1a2029;\r\n\tfont-size: 18px;\r\n\tcursor: pointer;\r\n}\r\n.Img  .tabs{\r\n\twidth: 30%;\r\n    height: 150px;\r\n    float: right;\r\n    margin-right: 20px;\r\n    margin-top: -10px;\r\n}\r\n.Img  .tabs table{\r\n\twidth: 100%;\r\n\tborder-radius: 3px;\r\n\toverflow: hidden;\r\n}\r\n.Img  .tabs table tr th{\r\n\theight: 30px;\r\n\ttext-align: center;\r\n\twidth: 50%;\r\n\tbackground: #e14340;\r\n\tcolor: #fff;\r\n}\r\n.Img  .tabs table tr td{\r\n\tcursor: pointer;\r\n\twidth: 50%;\r\n\theight: 35px;\r\n\ttext-align: center;\r\n\tbackground: #5383a1;\r\n\tborder-bottom: 1px solid #75c5f1;\r\n\tcolor: #fff;\r\n}\r\n.Img  .tabs table tr td .Red{\r\n\tcolor: #e14340;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Yellow{\r\n\tcolor: #f39800;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Green{\r\n\tcolor: #32b16c;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Black{\r\n\tcolor: #000000;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td:nth-child(2){\r\n\tcolor: #fff;\r\n}\r\n.Img  .tabs table tr .color{\r\n\tcolor: #000 !important;\r\n}\r\n.Img  .tabs table .trColor td{\r\n\tbackground: #b8dff9;\r\n\tbackground: rgba(100, 131, 152, 0.5) none repeat scroll 0 0;\r\n}\r\n.Img .onTabs{\r\n\twidth: 43.6%;\r\n    height: 280px;\r\n    border-radius: 3px;   \r\n    position: absolute;\r\n    left: 3%;\r\n    top: 17%;\r\n}\r\n.Img .onTabs .tableLeft{\r\n\twidth: 85%;\r\n\theight: 274px;\r\n\tbackground: rgba(100, 131, 152, 0.5) none repeat scroll 0 0;\r\n\tfloat: left;\r\n}\r\n.Img .onTabs .solidRight{\r\n\twidth: 15%;\r\n    border: 1px solid #ffffff;\r\n    position: absolute;\r\n    right: 0;\r\n    top: 46.8%;\r\n}\r\n.Img .onTabs .mod-title{\r\n\tborder-bottom: 1px solid #495b69;\r\n}\r\n.Img .onTabs .mod-title .Black{\r\n\tfloat: right;\r\n    margin: 10px;\r\n    font-size: 18px;\r\n    color: #000000;\r\n}\r\n.Img .onTabs .box{\r\n\twidth: 100%;\r\n\theight: 234px;\r\n    //overflow: auto;\r\n}\r\n.Img .onTabs .box table {\r\n\twidth: 93%;\r\n    margin: 0 10px;\r\n}\r\n.Img .onTabs .box table  tr td{\r\n\theight: 33px;\r\n\twidth: 95%;\r\n\twhite-space: nowrap;\r\n}\r\n.Img .onTabs .box table  tr td span{\r\n\tfloat: left;\r\n\tpadding-right: 10px;\r\n}\r\n.Img .yuan{\r\n\tposition: absolute;\r\n    right: 52%;\r\n    top: 29.7%;\r\n}\r\n.Img .onTabs .tableLeft{\r\n\tdisplay: none;\r\n}\r\n/*@parkMonitor jifei  楼宇企业列表\r\n---------------------------------------------------------*/\r\n.Enterprise{\r\n\twidth: 100%;\r\n\theight: 540px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n}\r\n.Enterprise .right{\r\n\tcolor: #e14340;\r\n\tfloat: right;\r\n\tfont-size: 16px;\r\n\tpadding: 10px 33px;\r\n}\r\n.Enterprise .items{\r\n    width: 100%;\r\n    height: 470px;\r\n    margin: 10px auto;\r\n    //overflow: auto;\r\n}\r\n.Enterprise .items .wtyh-table{\r\n\twidth: 96%;\r\n    margin: 0 auto;\r\n}\r\n.Enterprise .items .wtyh-table tr th{\r\n\theight: 40px;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(1){\r\n\twidth: 30%;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(2){\r\n\twidth: 12%;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(3){\r\n\twidth: 12%;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(4){\r\n\twidth: 12%;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(5){\r\n\twidth: 12%;\r\n}\r\n.Enterprise .items .wtyh-table tr th:nth-child(6){\r\n\twidth: 12%;\r\n}\r\n.Enterprise .items .wtyh-table tr th .icon-desc{\r\n    font-size: 20px;\r\n    float: left;\r\n    margin-top: -4px;\r\n    cursor: pointer;\r\n}\r\n.Enterprise .items .wtyh-table tr th span{\r\n\tfloat: left;\r\n\tpadding-left: 10%;\r\n}\r\n.Enterprise .items .wtyh-table tr td{\r\n\theight: 40px;\r\n\tfont-size: 12px;\r\n\tborder-bottom: 1px solid #444951;\r\n}\r\n.Enterprise .items .wtyh-table tr:nth-child(even){\r\n\tbackground: #222932;\r\n}\r\n.Enterprise .items .wtyh-table tr td span{\r\n\tfloat: left;\r\n\tpadding-left: 10%;\r\n\tcolor: #fff;\r\n\tcursor: pointer;\r\n}\r\n/*@parkMonitor jifei  楼宇行业分布\r\n---------------------------------------------------------*/\r\n.Industry{\r\n\twidth: 49.5%;\r\n\theight: 398px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n\tmargin-top: 10px;\r\n\tfloat: left;\r\n}\r\n/*@parkMonitor jifei  企业背景情况\r\n---------------------------------------------------------*/\r\n.Context{\r\n\twidth: 49.5%;\r\n\theight: 398px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n\tmargin-top: 10px;\r\n\tfloat: right;\r\n}\r\n/*@parkMonitor jifei  舆情更新\r\n---------------------------------------------------------*/\r\n.Footer{\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tposition: fixed;\r\n    bottom: 0;\r\n    left: 0;\r\n    background: rgba(43, 50, 60, 0.9) none repeat scroll 0 0;\r\n    box-shadow: 2px 2px 10px #000;\r\n}\r\n.Footer .box{\r\n\twidth: 95%;\r\n\theight: 40px;\r\n\tmargin: 10px auto;\r\n\tposition: relative;\r\n}\r\n.Footer .boxLeft{\r\n\twidth: 10%;\r\n\theight: 40px;\r\n\tborder-right: 1px solid #8a9199;\r\n\tline-height: 40px;\r\n\tfloat: left;\r\n}\r\n.Footer .boxLeft .icon-news{\r\n\tfont-size: 35px;\r\n\tcolor: #e14340;\r\n}\r\n.Footer .boxLeft .size{\r\n\tfont-size: 18px;\r\n    vertical-align: super;\r\n    padding-left: 25%;\r\n}\r\n.Footer .boxRight{\r\n\twidth: 85%;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tfloat: right;\r\n\t/* background: #666 */\r\n}\r\n.Footer .boxRight ul li{\r\n\tfloat: left;\r\n}\r\n.Footer .boxRight ul li:nth-child(1){\r\n\twidth: 20%;\r\n    font-size: 16px;\r\n    color: #e14340;\r\n    overflow: hidden;\r\n    text-overflow: ellipsis;\r\n    white-space: nowrap;\r\n    display: inline-block;\r\n}\r\n.Footer .boxRight ul li:nth-child(1) em{\r\n\tpadding-left: 5%;\r\n}\r\n.Footer .boxRight ul li:nth-child(2){\r\n\twidth: 60%;\r\n\tfont-size: 14px;\r\n    overflow: hidden;\r\n    text-overflow: ellipsis;\r\n    white-space: nowrap;\r\n    display: inline-block;\r\n}\r\n.Footer .boxRight ul li:nth-child(2) .liTop{\r\n\tpadding-left: 8%;\r\n}\r\n.Footer .boxRight ul li:nth-child(3){\r\n\twidth: 20%;\r\n\tfont-size: 12px;\r\n}\r\n.Footer .boxRight ul li:nth-child(3) em{\r\n\tpadding-left: 5%;\r\n}\r\n.Footer .boxRight ul li:nth-child(3) .liRight{\r\n\tpadding-left: 18%;\r\n}\r\n.boxRight{\r\noverflow: hidden;\r\nposition: relative;\r\n}\r\n.boxRight ul{\r\n\t/* background: red; */\r\n\twidth: 100%;height: 40px;\r\n}\r\n\r\n.boxRightScroll {\r\n\twidth: 100%;\r\n\theight: auto;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n}", ""]);

	// exports


/***/ },

/***/ 956:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.default = configureStore;

	var _redux = __webpack_require__(306);

	var _reduxThunk = __webpack_require__(957);

	var _reduxThunk2 = _interopRequireDefault(_reduxThunk);

	var _index = __webpack_require__(958);

	var _index2 = _interopRequireDefault(_index);

	var _DevTools = __webpack_require__(961);

	var _DevTools2 = _interopRequireDefault(_DevTools);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function configureStore() {
	  var store = (0, _redux.createStore)(_index2.default, _DevTools2.default.instrument(),
	  //applyMiddleware(thunk)
	  (0, _redux.applyMiddleware)(_reduxThunk2.default));
	  return store;
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "configureStore.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 958:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _SmallLoanMap = __webpack_require__(1278);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(1279);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(1280);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(1281);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(1282);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _AreaRanking = __webpack_require__(1262);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1263);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(1283);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(1267);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1268);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1269);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _Litigation = __webpack_require__(1270);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1271);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1272);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1273);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _realtimeTableRuducer = __webpack_require__(1274);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _BusinessTypes = __webpack_require__(1284);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1285);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1286);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1287);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1288);

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

	//公司基本信息

	//p2p图表


	/*p2p平台首页 begin*/
	//P2P平台监测

	//上海区域发展指数排名
	var rootReducer = (0, _redux.combineReducers)({
	  /*行业监测模块*/
	  //P2P平台监测

	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  IndexChartAll: _IndexChartAll2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default,
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

	//核心数据

	/*p2p平台首页 end*/

	/*p2p画像平台 begin*/
	//基本信息

	//网贷平台数据展示


	/*行业监测模块*/

	//小额贷款

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1278:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = smallLoanMap;

	var _SmallLoanIndexAction = __webpack_require__(804);

	//地图
	function smallLoanMap() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.SMALLLOAN_MAP_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.SMALLLOAN_MAP_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SmallLoanMap.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1279:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = companyGrade;

	var _SmallLoanIndexAction = __webpack_require__(804);

	//企业评级
	function companyGrade() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.COMPANY_GRADE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.COMPANY_GRADE_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyGrade.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1280:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = loanBalance;

	var _SmallLoanIndexAction = __webpack_require__(804);

	//贷款余额 贷款笔均折线图 三农小微企业余额占比
	function loanBalance() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.LOAN_BALANCE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.LOAN_BALANCE_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LoanBalance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1281:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = industryRisk;

	var _SmallLoanIndexAction = __webpack_require__(804);

	//股东行业风险
	function industryRisk() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.INDUSTRY_RISK_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.INDUSTRY_RISK_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1282:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = largeLoan;

	var _SmallLoanIndexAction = __webpack_require__(804);

	//大额贷款人信息列表
	function largeLoan() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.LARGE_LOAN_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.LARGE_LOAN_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LargeLoan.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1283:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = IndexChartAll;

	var _P2PIndexAction = __webpack_require__(819);

	function IndexChartAll() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PIndexAction.P2PINDEX_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _P2PIndexAction.P2PINDEX_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexChartAll.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1284:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = BusinessTypes;

	var _RaiseIndexAction = __webpack_require__(1277);

	function BusinessTypes() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _RaiseIndexAction.BUSINESS_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _RaiseIndexAction.BUSINESS_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessTypes.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1285:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = InvestPeople;

	var _RaiseIndexAction = __webpack_require__(1277);

	function InvestPeople() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _RaiseIndexAction.INVESTPEOPLE_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _RaiseIndexAction.INVESTPEOPLE_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InvestPeople.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1286:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = NewProject;

	var _RaiseIndexAction = __webpack_require__(1277);

	function NewProject() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _RaiseIndexAction.NEWPROJECT_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _RaiseIndexAction.NEWPROJECT_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "NewProject.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1287:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = RaiseMount;

	var _RaiseIndexAction = __webpack_require__(1277);

	function RaiseMount() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _RaiseIndexAction.RAISEMOUNT_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _RaiseIndexAction.RAISEMOUNT_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RaiseMount.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1288:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = List;

	var _RaiseIndexAction = __webpack_require__(1277);

	function List() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _RaiseIndexAction.LIST_REQUEST_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _RaiseIndexAction.LIST_REQUEST_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "List.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})