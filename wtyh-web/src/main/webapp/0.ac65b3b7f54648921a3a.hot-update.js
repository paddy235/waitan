webpackHotUpdate(0,{

/***/ 811:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDLineBar = _react2.default.createClass({
	    displayName: 'BBDLineBar',

	    // propTypes: {
	    //     param: React.PropTypes.object.isRequired,
	    //     style: React.PropTypes.object,
	    //     className: React.PropTypes.string,
	    //     theme: React.PropTypes.string,
	    //     onChartReady: React.PropTypes.func,
	    //     showLoading: React.PropTypes.bool,
	    //     onEvents: React.PropTypes.object
	    // },
	    setOption: function setOption(parm) {
	        var seriesBarData = [];
	        if (parm.series.bar) {
	            if (!parm.series.line) {
	                for (var i = 0; i < parm.series.bar.length; i++) {
	                    var seriesBarItem = {
	                        name: parm.barName[i],
	                        type: 'bar',
	                        label: {
	                            normal: {
	                                show: parm.labelShow || false,
	                                position: parm.lablePosition || "top",
	                                textStyle: {
	                                    color: "#fff"
	                                }
	                            }
	                        },
	                        stack: parm.stack == undefined ? "" : parm.stack,
	                        barWidth: parm.barWidth == undefined ? "auto" : parm.barWidth,
	                        data: parm.series.bar[i],
	                        itemStyle: parm.itemStyle || {
	                            normal: {},
	                            emphasis: {}
	                        }
	                    };
	                    if (i == parm.series.bar.length - 1) {
	                        seriesBarItem["yAxisIndex"] = 1;
	                    }
	                    seriesBarData.push(seriesBarItem);
	                }
	            } else {
	                for (var i = 0; i < parm.series.bar.length; i++) {
	                    var seriesBarItem = {
	                        name: parm.barName[i],
	                        type: 'bar',
	                        label: {
	                            normal: {
	                                show: parm.labelShow || false,
	                                position: parm.lablePosition || "top",
	                                textStyle: {
	                                    color: "#fff"
	                                }
	                            }
	                        },
	                        stack: parm.stack == undefined ? "" : parm.stack,
	                        barWidth: parm.barWidth == undefined ? "auto" : parm.barWidth,
	                        data: parm.series.bar[i],
	                        itemStyle: parm.itemStyle || {
	                            normal: {},
	                            emphasis: {}
	                        }
	                    };
	                    seriesBarData.push(seriesBarItem);
	                }
	            }
	        }
	        var barAreaStyle = {};
	        if (parm.series.line) {
	            for (var j = 0; j < parm.series.line.length; j++) {
	                var seriesBarItem = {
	                    name: parm.lineName[j],
	                    type: 'line',
	                    yAxisIndex: 1,
	                    symbolSize: parm.symbolSize,
	                    data: parm.series.line[j]
	                };
	                seriesBarData.push(seriesBarItem);
	            }
	        }
	        console.log(seriesBarData, "csy");
	        var option = {
	            color: parm.color,
	            title: {
	                show: parm.titleShow == undefined ? false : parm.titleShow,
	                text: parm.title,
	                x: parm.titleX,
	                padding: [25, 0, 0, 5],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 14,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            tooltip: {
	                trigger: 'axis',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    var info = v[0].name + "<br/>";
	                    for (var i = 0; i < v.length; i++) {
	                        var _until = "";
	                        if (parm.unit == undefined) {
	                            _until = "";
	                        } else {
	                            _until = parm.unit[i];
	                        }
	                        var _spanCorlor = '<span style=color:' + parm.color[i] + '>' + v[i].value + _until + '</span><br/>';
	                        info += v[i].seriesName + " :&nbsp;" + _spanCorlor;
	                    }
	                    return info;
	                },
	                axisPointer: {
	                    type: 'none'
	                }
	            },
	            legend: {
	                padding: [15, 0, 0, 0],
	                itemGap: 5,
	                itemWidth: 20,
	                itemHeight: 5,
	                width: parm.legendWidth || "auto",
	                show: parm.legendShow == undefined ? false : parm.legendShow,
	                left: parm.legendLeft == undefined ? "auto" : parm.legendLeft,
	                right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	                bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	                top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	                data: parm.legend,
	                textStyle: {
	                    color: "#99a3b7",
	                    fontSize: 12,
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: {
	                left: parm.gridLeft || '5%',
	                right: parm.gridRight || '5%',
	                bottom: parm.gridBottom == undefined ? "15%" : parm.gridBottom,
	                containLabel: true
	            },
	            xAxis: [{
	                name: parm.Xname || "",
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                type: parm.Xtype || 'category',
	                data: parm.xAxis || [],
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            }],
	            yAxis: [{
	                type: parm.Ytype || 'value',
	                data: parm.yAxis || [],
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[0],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                nameLocation: parm.YnameLocation || "end",
	                nameRotate: parm.YnameRoutate || 0,
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.axisLabelL == undefined ? true : parm.axisLabelL,
	                    formatter: parm.yFlag == undefined ? '{value}' : '{value}' + parm.yFlag,
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }, {
	                type: parm.Ytype || 'value',
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[1],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: parm.yAxis || [],
	                nameLocation: parm.YnameLocation || "end",
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: false
	                },
	                axisLine: {
	                    show: parm.axisLineR == undefined ? true : parm.axisLineR,
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.axisLabelR == undefined ? true : parm.axisLabelR,
	                    formatter: parm.y2Flag == undefined ? '{value}' : '{value}' + parm.y2Flag,
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }],
	            series: seriesBarData
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
	        //  echartObj.resize();
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
	        echartObj.setOption(this.setOption(this.props.param));
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
	exports.default = BBDLineBar;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineBarChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 899:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市自贸区融资租赁企业占比对比
	var Immutable = __webpack_require__(718);
	var ContrastRight = _react2.default.createClass({
	    displayName: 'ContrastRight',

	    getInitialState: function getInitialState() {
	        return {
	            paramContrastRight: null,
	            TimeSelectVal: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getContrastRightnumRequest = this.props.getContrastRightnumRequest;

	        var jsonData = { 'year': 2015 };
	        getContrastRightnumRequest(jsonData);

	        var getTimeSelectRequest = this.props.getTimeSelectRequest;

	        var jsonData = {};
	        getTimeSelectRequest(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.ContrastRightNumChartRequest, this.props.ContrastRightNumChartResult);
	        if (!isEqual) {
	            var ContrastRightNumChartRequest = nextProps.ContrastRightNumChartRequest;
	            var ContrastRightNumChartResult = nextProps.ContrastRightNumChartResult;

	            if (ContrastRightNumChartRequest == true) {
	                if (ContrastRightNumChartResult.success) {
	                    var optionThes = {
	                        "color": ["#facd89", "#e14340"],
	                        //"title":"私募基金总分类",
	                        "xtitle": "",
	                        "titleLeft": "19%",
	                        "titleTop": "60%",
	                        //"legend": ["自贸区", "非自贸区"],
	                        "legendShow": true,
	                        // "roseType":"radius",//是否玫瑰型
	                        "radius": [80, 110],
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "",
	                        "lable": { normal: { show: true },
	                            emphasis: { show: false }
	                        },
	                        "center": ['55%', '54%'],
	                        "series": [{ value: ContrastRightNumChartResult.content.inAreaNumber, name: '自贸区' }, { value: ContrastRightNumChartResult.content.outAreaNumber, name: '非自贸区' }]
	                    };
	                    this.setState({ paramContrastRight: optionThes });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        //下拉框
	        var isEqual = Immutable.is(nextProps.TimeSelectNumChartRequest, this.props.TimeSelectNumChartResult);
	        if (!isEqual) {
	            var TimeSelectNumChartRequest = nextProps.TimeSelectNumChartRequest;
	            var TimeSelectNumChartResult = nextProps.TimeSelectNumChartResult;

	            if (TimeSelectNumChartRequest == true) {
	                if (TimeSelectNumChartResult.success) {
	                    // $(this.refs.totleCount).html(ContrastCatalogNumChartResult.content.length)
	                    //this.dataFomat({CatalogCentent:ContrastCatalogNumChartResult}) 
	                    this.dataCatalogSelect(TimeSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        //console.log("jifei++++++++++",data.content)
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("qqqqqqqqqqqqqqqqqqqqqq",selectVar)
	        this.setState({ TimeSelectVal: selectVar });
	    },
	    selectValue: function selectValue(data) {
	        var yearData = { 'year': data };
	        var getContrastRightnumRequest = this.props.getContrastRightnumRequest;

	        getContrastRightnumRequest(yearData);
	    },

	    render: function render() {
	        //下拉选择         
	        var selectProp = {
	            width: '95px',
	            className: 'index-selected',
	            value: this.state.selectVar,
	            placeholder: '2015',
	            name: 'testselect',
	            data: this.state.TimeSelectVal,
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);           
	                this.selectValue(label);
	            }.bind(this)
	        };

	        var ContrastRightAmountBox = "";
	        if (this.state.paramContrastRight) {
	            ContrastRightAmountBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.paramContrastRight,
	                style: { height: '550px', width: '100%', margin: '0px auto' } });
	        }

	        return _react2.default.createElement(
	            'div',
	            { className: 'ContrastRight ContrastLeft' },
	            ContrastRightAmountBox,
	            _react2.default.createElement(
	                'div',
	                { className: 'select' },
	                _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelectedTimes' }))
	            )
	        );
	    }
	});
	module.exports = ContrastRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContrastRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	        console.info("jifei++++", areaNameData);
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
	            value: 2,
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: 2, label: '全部' }, { value: 0, label: '正常' }, { value: 1, label: '潜在' }],
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);         
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        //下拉选择全部
	        var selectProps = {
	            width: '55px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: 2, label: '全部' }, { value: 0, label: '是' }],
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
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD', title: item.companyName },
	                                                    item.companyName
	                                                )
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
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD', title: item.companyName },
	                                                    item.companyName
	                                                )
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
	    componentDidMount: function componentDidMount() {
	        //滚动条
	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    //滚动条
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
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
	                        { className: 'orange' },
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
	                                            { width: '25%', title: ele.companyName },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
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
	                                            { width: '25%', title: ele.companyName },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
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

/***/ 946:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Search = _react2.default.createClass({
	  displayName: 'Search',
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      this.refs.inp.value = this.props.location.query.searchInfo;
	    }
	  },

	  clickSearch: function clickSearch() {
	    if (this.refs.inp.value) {
	      var getSearchDataRequest = this.props.getSearchDataRequest;

	      var companyData = {
	        "company": this.refs.inp.value,
	        "page_no": 0,
	        "page_size": 4
	      };
	      getSearchDataRequest(companyData);
	      // $("#show").show()
	    }
	  },
	  keySearch: function keySearch(event) {
	    if (event.which == "13") this.clickSearch();
	    var value = $(event.target).val();
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Search' },
	      _react2.default.createElement(
	        'div',
	        { className: 'SearchBox' },
	        _react2.default.createElement(
	          'h1',
	          null,
	          '企业全息信息查询平台'
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'SearchInp' },
	          _react2.default.createElement('input', { placeholder: '', type: 'text', ref: 'inp', id: 'inp', onKeyUp: this.keySearch, placeholder: '请输入企业名称或关键字检索' }),
	          _react2.default.createElement(
	            'a',
	            { id: 'href', href: 'javascript:void(0);', onClick: this.clickSearch },
	            _react2.default.createElement('i', { className: 'iconfont icon-search' })
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = Search;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Search.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 949:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var SearchList = _react2.default.createClass({
	  displayName: 'SearchList',

	  getInitialState: function getInitialState() {
	    return {
	      count: 0,
	      DataList: [],
	      nowpage: 0
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.searchDataRequest, this.props.searchDataResult);
	    if (!isEqual) {
	      var searchDataRequest = nextProps.searchDataRequest;
	      var searchDataResult = nextProps.searchDataResult;

	      if (searchDataRequest == true) {
	        if (searchDataResult.success == true) {
	          this.dataFomat(searchDataResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content.rdata;
	    var count = data.content.sum;
	    if (content.length != 0) this.setState({ count: count, DataList: content });else this.setState({ count: count, DataList: null });
	  },
	  getLargeLoan: function getLargeLoan(jsonData) {
	    var getSearchDataRequest = this.props.getSearchDataRequest;

	    getSearchDataRequest(jsonData);
	  },
	  //分页回调 
	  setCallBack: function setCallBack(nowpage, eachPageCount) {
	    //console.info("aaaaaaaaaaaaaaaaaaa",eachPageCount)
	    this.setState({ nowpage: nowpage - 1 });
	    var searchName = "";
	    $("#inp").val() ? searchName = $("#inp").val() : searchName = this.props.location.query.searchInfo;
	    var jsonData = {
	      "company": searchName,
	      "page_no": nowpage - 1,
	      "page_size": 4
	    };
	    if ($("#inp").val() || this.props.location.query.searchInfo) this.getLargeLoan(jsonData);
	  },
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      var jsonData = {
	        "company": this.props.location.query.searchInfo,
	        "page_no": 0,
	        "page_size": 4
	      };
	      this.getLargeLoan(jsonData);
	    }
	  },

	  render: function render() {
	    var textBox = "";
	    if (this.state.count != 0) {
	      textBox = _react2.default.createElement(
	        'span',
	        { className: 'total' },
	        '共搜索到相关',
	        _react2.default.createElement(
	          'em',
	          null,
	          this.state.count
	        ),
	        '家企业'
	      );
	    }
	    if (this.state.DataList) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'SearchList' },
	        _react2.default.createElement(
	          'ul',
	          { className: 'ulBox xxx', id: 'show' },
	          this.state.DataList.map(function (ele, index) {
	            return _react2.default.createElement(
	              'li',
	              { className: 'liList', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  _reactRouter.Link,
	                  { to: "/SearchResultDetail?companyName=" + ele.company_name },
	                  _react2.default.createElement(
	                    'h2',
	                    null,
	                    ele.company_name
	                  )
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册号：',
	                  ele.regno
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '类型：',
	                  ele.company_type
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '法定代表人：',
	                  ele.frname
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册资本：',
	                  ele.regcap
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '成立日期：',
	                  ele.esdate
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册地址：',
	                  ele.address
	                )
	              )
	            );
	          }),
	          _react2.default.createElement(
	            'div',
	            { className: 'page' },
	            textBox,
	            _react2.default.createElement(_index.PageList, { id: 'pageList1', count: this.state.count, showPage: '6', callback: this.setCallBack })
	          )
	        )
	      );
	    } else if (this.state.DataList == null) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'noResult' },
	        '抱歉！ 暂无搜索结果'
	      );
	    }
	  }
	});
	module.exports = SearchList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})