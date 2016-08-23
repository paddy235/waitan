webpackHotUpdate(0,{

/***/ 727:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(728);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineFinanceIndexAction = __webpack_require__(730);

	var LineFinanceIndexActionCreaters = _interopRequireWildcard(_LineFinanceIndexAction);

	var _setMinHeight = __webpack_require__(731);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _LineFinanceSearch = __webpack_require__(732);

	var _LineFinanceSearch2 = _interopRequireDefault(_LineFinanceSearch);

	var _SearchCondition = __webpack_require__(735);

	var _SearchCondition2 = _interopRequireDefault(_SearchCondition);

	var _LineFinanceRiskDistr = __webpack_require__(736);

	var _LineFinanceRiskDistr2 = _interopRequireDefault(_LineFinanceRiskDistr);

	var _LineFinanceList = __webpack_require__(740);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//线下理财首页
	var LineFinanceIndex = _react2.default.createClass({
	  displayName: 'LineFinanceIndex',

	  mixins: [_setMinHeight2.default],
	  getInitialState: function getInitialState() {
	    //区域选择
	    var areaSelect = ["黄浦区", "徐汇区", "静安区", "长宁区", "普陀区", "虹口区", "杨浦区", "浦东新区", "闵行区", "宝山区", "嘉定区", "金山区", "松江区", "青浦区", "奉贤区", "崇明县", "卢湾区", "闸北区"];
	    //注册资本
	    var regCapital = ["10-50万元", "50-100万元", "100-500万元", "500万以上"];
	    //存续时间
	    var durationTime = ["一年以内", "1-3年", "3-5年", "5-10年", "10年以上"];
	    //公司背景
	    var companyBg = ["国企", "上市公司"];
	    return {
	      areaSelect: areaSelect,
	      regCapital: regCapital,
	      durationTime: durationTime,
	      companyBg: companyBg,
	      areaCheck: "",
	      regCapCheck: "",
	      durTimCheck: "",
	      comBgCheck: "",
	      parm: {}
	    };
	  },

	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isCheckValEqual = Immutable.is(nextProps.checkVal, this.props.checkVal);
	    if (!isCheckValEqual) {
	      var checkVal = nextProps.checkVal;

	      this.checkValFomat(checkVal);
	    }
	  },
	  checkValFomat: function checkValFomat(data) {
	    var _this = this;
	    var label = data.label;
	    var nowVal = data.nowVal;
	    if (label == "区域选择") {
	      this.setState({ areaCheck: nowVal }, function () {
	        _this.checkValObj();
	      });
	    } else if (label == "注册资本") {
	      this.setState({ regCapCheck: nowVal }, function () {
	        _this.checkValObj();
	      });
	    } else if (label == "存续时间") {
	      this.setState({ durTimCheck: nowVal }, function () {
	        _this.checkValObj();
	      });
	    } else {
	      this.setState({ comBgCheck: nowVal }, function () {
	        _this.checkValObj();
	      });
	    }
	  },
	  checkValObj: function checkValObj() {

	    var regCapCheck = this.state.regCapCheck;
	    var durTimCheck = this.state.durTimCheck;
	    var comBgCheck = this.state.comBgCheck;

	    var area = this.state.areaCheck;
	    var minRegCapital = "";
	    var maxRegCapital = "";
	    var companyQualification = "";
	    var minReviewTime = "";
	    var maxReviewTime = "";

	    if (regCapCheck == "10-50万元") {
	      minRegCapital = 10;
	      maxRegCapital = 50;
	    } else if (regCapCheck == "50-100万元") {
	      minRegCapital = 50;
	      maxRegCapital = 100;
	    } else if (regCapCheck == "100-500万元") {
	      minRegCapital = 100;
	      maxRegCapital = 500;
	    } else if (regCapCheck == "500万元以上") {
	      minRegCapital = 500;
	    }

	    if (durTimCheck == "一年以内") {
	      maxReviewTime = 1;
	    } else if (durTimCheck == "1-3年") {
	      minReviewTime = 1;
	      maxReviewTime = 3;
	    } else if (durTimCheck == "3-5年") {
	      minReviewTime = 3;
	      maxReviewTime = 5;
	    } else if (durTimCheck == "5-10年") {
	      minReviewTime = 5;
	      maxReviewTime = 10;
	    }

	    if (comBgCheck == "国企") {
	      companyQualification = 0;
	    } else if (comBgCheck == "上市公司") {
	      companyQualification = 1;
	    }

	    var parm = { area: area,
	      minRegCapital: minRegCapital,
	      maxRegCapital: maxRegCapital,
	      minReviewTime: minReviewTime,
	      maxReviewTime: maxReviewTime,
	      companyQualification: companyQualification
	    };

	    this.setState({ parm: parm });
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
	        _react2.default.createElement(_SearchCondition2.default, _extends({ label: '区域选择', className: '', conList: this.state.areaSelect }, this.props)),
	        _react2.default.createElement(_SearchCondition2.default, _extends({ label: '注册资本', className: '', conList: this.state.regCapital }, this.props)),
	        _react2.default.createElement(_SearchCondition2.default, _extends({ label: '存续时间', className: '', conList: this.state.durationTime }, this.props)),
	        _react2.default.createElement(_SearchCondition2.default, _extends({ label: '公司背景', className: 'last', conList: this.state.companyBg }, this.props))
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'risk-distr-box' },
	        _react2.default.createElement(_LineFinanceRiskDistr2.default, _extends({}, this.props, { parm: this.state.parm }))
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'list-box' },
	        _react2.default.createElement(_LineFinanceList2.default, _extends({}, this.props, { parm: this.state.parm }))
	      )
	    );
	  }
	});
	//module.exports = LineFinanceIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {

	    //线下理财分布
	    lineFinaceRiskDistriRequest: state.LineFinanceRiskDistri.request,
	    lineFinaceRiskDistriResult: state.LineFinanceRiskDistri.result,

	    //线下理财列表
	    lineFinanceListRequest: state.LineFinanceList.request,
	    lineFinanceListResult: state.LineFinanceList.result,

	    //条件选择
	    checkVal: state.CheckVal.data
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(LineFinanceIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 736:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _ScatterBubbleChart = __webpack_require__(737);

	var _ScatterBubbleChart2 = _interopRequireDefault(_ScatterBubbleChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);


	//线下理财风险分布
	var LineFinanceRiskDistr = _react2.default.createClass({
	  displayName: 'LineFinanceRiskDistr',

	  getInitialState: function getInitialState() {
	    return {
	      option: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    this.getLinFinRiskDistr();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isCheckValEqual = Immutable.is(nextProps.parm, this.props.parm);
	    if (!isCheckValEqual) {
	      var parm = nextProps.parm;

	      var jsonData = parm;
	      this.getLinFinRiskDistr(jsonData);
	    }

	    var isEqual = Immutable.is(nextProps.lineFinaceRiskDistriRequest, this.props.lineFinaceRiskDistriResult);
	    if (!isEqual) {
	      var lineFinaceRiskDistriRequest = nextProps.lineFinaceRiskDistriRequest;
	      var lineFinaceRiskDistriResult = nextProps.lineFinaceRiskDistriResult;

	      if (lineFinaceRiskDistriRequest == true) {
	        if (lineFinaceRiskDistriResult.success == true) {
	          this.dataFomat(lineFinaceRiskDistriResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },

	  getLinFinRiskDistr: function getLinFinRiskDistr(jsonData) {
	    var getLinFinRiskDistr = this.props.getLinFinRiskDistr;

	    getLinFinRiskDistr(jsonData);
	  },
	  dataFomat: function dataFomat(data) {
	    var companyInfo = [];
	    var seriesData = [];

	    var content = data.content;
	    var len = content.length;
	    for (var i = 0; i < len; i++) {
	      companyInfo.push({
	        name: content[i].companyName,
	        regCapital: content[i].regCapital,
	        corporate: content[i].legalRpt,
	        companyType: content[i].companyType,
	        foundDate: content[i].regDateStr
	      });
	      seriesData.push([content[i].staticRiskIndex, content[i].dynamicRiskIndex]);
	    }
	    var option = {
	      color: ["#a40000"],
	      title: "",
	      companyInfo: companyInfo,
	      yAxisName: "动态风险指数",
	      xAxisName: "静态风险指数",
	      series: [{
	        name: '风险指数',
	        type: 'scatter',
	        data: seriesData
	      }]
	    };
	    this.setState({ option: option });
	  },
	  render: function render() {
	    var bbdScatterBubble = "";
	    if (this.state.option) {
	      bbdScatterBubble = _react2.default.createElement(_ScatterBubbleChart2.default, { option: this.state.option });
	    }
	    return _react2.default.createElement(
	      'div',
	      { className: 'line-finace-risk-distrib' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '线下理财分布'
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'chart-box' },
	        bbdScatterBubble
	      )
	    );
	  }
	});
	module.exports = LineFinanceRiskDistr;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceRiskDistr.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 737:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(738);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*
	    散点图 气泡图

	    调用方式：
	    const option ={
	          color:["#a40000"],
	          title:"",
	          companyInfo:[
	          {
	            name:"海东泰金融投资有限公司",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司1",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司2",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司3",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司4",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          }
	          ],
	          yAxisName:"动态风险指数",
	          xAxisName:"静态风险指数",
	          series:[
	            {
	                name:'风险指数',
	                type:'scatter',
	                data: [
	                    [161.2, 51.6], 
	                    [167.5, 59.0], 
	                    [159.5, 49.2], 
	                    [157.0, 63.0], 
	                    [155.8, 53.6]
	                ]
	            }
	          ]
	      }
	*/
	var BBDscatterBuble = _react2.default.createClass({
	    displayName: 'BBDscatterBuble',

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
	        var seriesLineData = [];
	        var option = {
	            color: parm.color || ["green"],
	            textStyle: {
	                color: "#fff"
	            },
	            title: {
	                text: parm.title == undefined ? "" : parm.title,
	                padding: [10, 0, 0, 15],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: parm.grid == undefined ? { left: '3%', right: '10%', bottom: '3%', containLabel: true } : parm.grid,
	            visualMap: {
	                type: 'continuous',
	                min: 0,
	                max: 200,
	                right: '4%',
	                bottom: '8%',
	                inRange: {
	                    colorLightness: [1, 0.5]
	                },
	                controller: {
	                    inRange: {
	                        symbolSize: [10, 200],
	                        color: ['#e14341']
	                    }
	                },
	                text: ['高', '低'], // 文本，默认为数值文本
	                calculable: true
	            },
	            tooltip: {
	                position: 'top',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(data) {
	                    var dataIndex = data.dataIndex;
	                    var opr = '<div class="scatter-bubble-tip">' + '<h4>' + parm.companyInfo[dataIndex].name + '</h4>' + '<ul>' + '<li>注册资本：' + parm.companyInfo[dataIndex].regCapital + '</li>' + '<li>法人代表：' + parm.companyInfo[dataIndex].corporate + '</li>' + '<li>公司类型：' + parm.companyInfo[dataIndex].companyType + '</li>' + '<li>成立时间：' + parm.companyInfo[dataIndex].foundDate + '</li>' + '<li>静态风险指数：' + data.value[0] + '</li>' + '<li>动态风险指数：' + data.value[1] + '</li>' + '</ul>' + '</div>';
	                    return opr;
	                }
	            },
	            xAxis: [{
	                name: parm.xAxisName || "",
	                type: 'value',
	                scale: true,
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
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            yAxis: [{
	                name: parm.yAxisName || "",
	                type: 'value',
	                scale: true,
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
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            series: parm.series
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
	        //===============================================================================
	        echartObj.setOption(this.setOption(this.props.option));
	        //===============================================================================
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
	            height: '100%', width: "100%"
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDscatterBuble;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterBubbleChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 740:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _ScatterChart = __webpack_require__(741);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//线下理财列表
	var LineFinanceList = _react2.default.createClass({
	    displayName: 'LineFinanceList',

	    getInitialState: function getInitialState() {
	        return {
	            count: 0,
	            nowpage: 1,
	            itemList: [],
	            parm: null,
	            sortType: 0
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var jsonData = { pageNo: this.state.nowpage };
	        this.getLinFinList(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isCheckValEqual = Immutable.is(nextProps.parm, this.props.parm);
	        if (!isCheckValEqual) {
	            var parm = nextProps.parm;

	            console.log(parm, 9999999999999);
	            this.setState({ parm: parm });
	            var jsonData = {
	                area: parm.area,
	                minRegCapital: parm.minRegCapital,
	                maxRegCapital: parm.maxRegCapital,
	                minReviewTime: parm.minReviewTime,
	                maxReviewTime: parm.maxReviewTime,
	                companyQualification: parm.companyQualification,
	                pageNo: this.state.nowpage,
	                sortType: this.state.sortType
	            };
	            this.getLinFinList(jsonData);
	        }

	        var isEqual = Immutable.is(nextProps.lineFinanceListRequest, this.props.lineFinanceListResult); //判断数据是否变化
	        console.log(isEqual, 8888888888);
	        if (!isEqual) {
	            var lineFinanceListRequest = nextProps.lineFinanceListRequest;
	            var lineFinanceListResult = nextProps.lineFinanceListResult;

	            if (lineFinanceListRequest == true) {
	                if (lineFinanceListResult.success == true) {
	                    this.dataFomat(lineFinanceListResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },

	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        var itemList = content.list;
	        console.log(itemList, 9999999999999);

	        this.setState({ itemList: itemList, count: content.count });
	    },
	    getLinFinList: function getLinFinList(jsonData) {
	        var getLinFinList = this.props.getLinFinList;

	        getLinFinList(jsonData);
	    },
	    //分页回调 
	    setCallBack: function setCallBack(nowpage, eachPageCount) {
	        this.setState({ nowpage: nowpage });
	        var parm = this.state.parm;
	        var jsonData = {};
	        if (parm) {
	            jsonData = {
	                area: parm.area,
	                minRegCapital: parm.minRegCapital,
	                maxRegCapital: parm.maxRegCapital,
	                minReviewTime: parm.minReviewTime,
	                maxReviewTime: parm.maxReviewTime,
	                companyQualification: parm.companyQualification,
	                pageNo: nowpage,
	                sortType: this.state.sortType
	            };
	        } else {
	            jsonData = { pageNo: nowpage };
	        }
	        this.getLinFinList(jsonData);
	    },
	    jumpClick: function jumpClick(e) {
	        this.props.history.push('/lineFinanceStaticRisk');
	    },
	    render: function render() {
	        var selectProp = {
	            width: '185px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: 1, label: '风险指数从低到高排列' }, { value: 2, label: '风险指数从高到低排列' }],
	            onChange: function (value) {
	                var val = value - 1;
	                var parm = this.state.parm;
	                var jsonData = {};
	                if (parm) {
	                    var jsonData = {
	                        area: parm.area,
	                        minRegCapital: parm.minRegCapital,
	                        maxRegCapital: parm.maxRegCapital,
	                        minReviewTime: parm.minReviewTime,
	                        maxReviewTime: parm.maxReviewTime,
	                        companyQualification: parm.companyQualification,
	                        pageNo: this.state.nowpage,
	                        sortType: val
	                    };
	                } else {
	                    jsonData = { pageNo: this.state.nowpage, sortType: val };
	                }
	                this.setState({ sortType: value });
	                this.getLinFinList(jsonData);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'line-finace-list mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '线下理财分布'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-title' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'select' },
	                        _react2.default.createElement(_index.Selected, selectProp)
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-box' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table table-top-line' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%', className: 'talign-left' },
	                                    '排行'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '50%', className: 'talign-left' },
	                                    '公司名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'talign-left' },
	                                    '风险指数'
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.itemList.map(function (elem, index) {
	                                var companyQualification = elem.companyQualification;
	                                var comQua = "";
	                                if (companyQualification == "1|0") {
	                                    comQua = _react2.default.createElement(
	                                        'em',
	                                        { className: 'bg-yellow' },
	                                        '上市企业'
	                                    );
	                                } else if (companyQualification == "0|1") {
	                                    comQua = _react2.default.createElement(
	                                        'em',
	                                        { className: 'bg-red' },
	                                        '国企背景'
	                                    );
	                                }

	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { onClick: this.jumpClick },
	                                                elem.companyName
	                                            ),
	                                            comQua
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            elem.staticRiskIndex,
	                                            _react2.default.createElement('i', { className: elem.isRise == "0" ? "iconfont icon-arrowupx" : "iconfont icon-xiangshang" })
	                                        )
	                                    );
	                                }{
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { onClick: this.jumpClick },
	                                                elem.companyName
	                                            ),
	                                            comQua
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'talign-left' },
	                                            elem.staticRiskIndex,
	                                            _react2.default.createElement('i', { className: elem.isRise == "0" ? "iconfont icon-arrowupx" : "iconfont icon-xiangshang" })
	                                        )
	                                    );
	                                }
	                            }.bind(this))
	                        )
	                    ),
	                    _react2.default.createElement(_index.PageList, { id: 'large-loan-page', count: this.state.count, showPage: '7', callback: this.setCallBack })
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

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

	var companyName = "中智资产管理有限公司";
	//静态风险指数
	var LineFinanceStaticRisk = _react2.default.createClass({
	  displayName: 'LineFinanceStaticRisk',

	  componentWillMount: function componentWillMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-static-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, null),
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
	    queryDateVersionResult: state.QueryDateVersion.result
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

/***/ 754:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险指数关联图
	var LineFinanceRelationGraph = _react2.default.createClass({
	    displayName: 'LineFinanceRelationGraph',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        var queryDynamicPic = this.props.queryDynamicPic;

	        queryDynamicPic({
	            "companyName": "宁夏思越资产投资管理有限责任公司",
	            "dataVersion": "20160530",
	            "degree": 3
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
	                                { className: 'btn active' },
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

/***/ 761:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.queryDynamicPic = queryDynamicPic;
	exports.queryRisk = queryRisk;
	exports.queryStatistics = queryStatistics;
	exports.queryRiskData = queryRiskData;
	exports.companyNews = companyNews;
	exports.queryDateVersion = queryDateVersion;
	/*
	  线下理财监测creat by yq
	*/

	//关联图谱数据
	var DYNAMIC_PIC_SUCCESS = exports.DYNAMIC_PIC_SUCCESS = 'DYNAMIC_PIC_SUCCESS';
	var DYNAMIC_PIC_FAIL = exports.DYNAMIC_PIC_FAIL = 'DYNAMIC_PIC_FAIL';

	function dynamicPicSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DYNAMIC_PIC_SUCCESS,
	    result: result
	  };
	}
	function dynamicPicFail(result) {
	  //请求失败调用方法
	  return {
	    type: DYNAMIC_PIC_FAIL,
	    result: result
	  };
	}

	function queryDynamicPic(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryDynamicPicData.do", //"/offlineFinance/queryDynamicPicData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(dynamicPicSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(dynamicPicFail(result));
	      }
	    });
	  };
	}
	//静态风险指数构成
	var STATIC_RISK_SUCCESS = exports.STATIC_RISK_SUCCESS = 'STATIC_RISK_SUCCESS';
	var STATIC_RISK_FAIL = exports.STATIC_RISK_FAIL = 'STATIC_RISK_FAIL';
	function queryRiskSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DYNAMIC_PIC_SUCCESS,
	    result: result
	  };
	}
	function queryRiskFail(result) {
	  //请求失败调用方法
	  return {
	    type: DYNAMIC_PIC_FAIL,
	    result: result
	  };
	}

	function queryRisk(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryRiskData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryRiskSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryRiskFail(result));
	      }
	    });
	  };
	}
	//静态风险趋势图/offlineFinance/queryStatistics.do
	var STATISTICS_SUCCESS = exports.STATISTICS_SUCCESS = 'STATISTICS_SUCCESS';
	var STATISTICS_FAIL = exports.STATISTICS_FAIL = 'STATISTICS_FAIL';
	function queryStatisticsSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: STATISTICS_SUCCESS,
	    result: result
	  };
	}
	function queryStatisticsFail(result) {
	  //请求失败调用方法
	  return {
	    type: STATISTICS_FAIL,
	    result: result
	  };
	}

	function queryStatistics(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryStatistics.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryStatisticsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryStatisticsFail(result));
	      }
	    });
	  };
	}
	//公司关联情况列表/offlineFinance/queryRiskData.do
	var RISK_DATA_SUCCESS = exports.RISK_DATA_SUCCESS = 'RISK_DATA_SUCCESS';
	var RISK_DATA_FAIL = exports.RISK_DATA_FAIL = 'RISK_DATA_FAIL';
	function queryRiskDataSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RISK_DATA_SUCCESS,
	    result: result
	  };
	}
	function queryRiskDataFail(result) {
	  //请求失败调用方法
	  return {
	    type: RISK_DATA_FAIL,
	    result: result
	  };
	}
	function queryRiskData(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryRiskData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryRiskDataSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryRiskDataFail(result));
	      }
	    });
	  };
	}
	// //静态风险指数构成offlineFinance/staticRiskIndex.do
	// export const STATIC_RISK_INDEX_SUCCESS='STATIC_RISK_INDEX_SUCCESS'
	// export const STATIC_RISK_INDEX_FAIL='STATIC_RISK_INDEX_FAIL'
	// function staticRiskIndexSuccess(result) {//请求成功调用方法
	//   return {
	//     type: STATIC_RISK_INDEX_SUCCESS,
	//     result:result
	//   }
	// }
	// function staticRiskIndexFail(result) {//请求失败调用方法
	//   return {
	//     type: STATIC_RISK_INDEX_FAIL,
	//     result:result
	//   }
	// }
	// export function staticRiskIndexPie(json) {
	//   return (dispatch)=> {
	//     console.log(json)
	//      $.ajax({
	//           url: "/offlineFinance/staticRiskIndex.do",
	//           dataType:"json",
	//           data: json,
	//           type: "GET",
	//           success: function(result) {
	//                return dispatch(staticRiskIndexSuccess(result))
	//           },
	//           error:function(result){
	//                return dispatch(staticRiskIndexFail(result))
	//           }
	//       });
	//   }
	// }
	// 公司舆情/offlineFinance/companyNews.do?companyName
	var COMPANY_NEWS_SUCCESS = exports.COMPANY_NEWS_SUCCESS = 'COMPANY_NEWS_SUCCESS';
	var COMPANY_NEWS_FAIL = exports.COMPANY_NEWS_FAIL = 'COMPANY_NEWS_FAIL';
	function companyNewsSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_NEWS_SUCCESS,
	    result: result
	  };
	}
	function companyNewsFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_NEWS_FAIL,
	    result: result
	  };
	}
	function companyNews(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/companyNews.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyNewsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyNewsFail(result));
	      }
	    });
	  };
	}
	//请求时间列表/offlineFinance/queryDateVersion.do
	var QUERY_DATA_SUCCESS = exports.QUERY_DATA_SUCCESS = 'QUERY_DATA_SUCCESS';
	var QUERY_DATA_FAIL = exports.QUERY_DATA_FAIL = 'QUERY_DATA_FAIL';
	function queryDataSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: QUERY_DATA_SUCCESS,
	    result: result
	  };
	}
	function queryDataFail(result) {
	  //请求失败调用方法
	  return {
	    type: QUERY_DATA_FAIL,
	    result: result
	  };
	}
	function queryDateVersion(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryDateVersion.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryDataSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryDataFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceStaticRiskAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 762:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(728);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _RiskSearchHeader = __webpack_require__(750);

	var _RiskSearchHeader2 = _interopRequireDefault(_RiskSearchHeader);

	var _TimeAxisCompare = __webpack_require__(763);

	var _TimeAxisCompare2 = _interopRequireDefault(_TimeAxisCompare);

	var _IndexCompare = __webpack_require__(770);

	var _IndexCompare2 = _interopRequireDefault(_IndexCompare);

	var _IndexList = __webpack_require__(771);

	var _IndexList2 = _interopRequireDefault(_IndexList);

	var _LineFinanceDynamicRiskAction = __webpack_require__(782);

	var LineFinanceDynamicRiskActionCreators = _interopRequireWildcard(_LineFinanceDynamicRiskAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//动态风险时序差异对比
	var LineFinanceDynamicRisk = _react2.default.createClass({
	  displayName: 'LineFinanceDynamicRisk',

	  getInitialState: function getInitialState() {
	    return {
	      areaCode: "上海市",
	      companyName: this.props.location.query.companyName || '《国际金融报》社有限公司',
	      compareMonth: "2016-08",
	      currentMonth: "2016-07",
	      indexCmpData: {},
	      dateLeft: "",
	      dateRight: ""
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    //2.企业关联方特征指数
	    var json = {
	      areaCode: this.state.areaCode,
	      companyName: this.state.companyName,
	      currentMonth: this.state.dateLeft,
	      compareMonth: this.state.dateRight
	    };
	    this.getDynamicRiskData(json);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps);
	    var isEqual = Immutable.is(nextProps.dynamicRiskIndexCmpResult, this.props.dynamicRiskIndexCmpResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskIndexCmpRequest = nextProps.dynamicRiskIndexCmpRequest;
	      var dynamicRiskIndexCmpResult = nextProps.dynamicRiskIndexCmpResult;

	      console.log(dynamicRiskIndexCmpResult, 'dynamicRiskIndexCmpResult');
	      if (dynamicRiskIndexCmpRequest == true) {
	        if (dynamicRiskIndexCmpResult.success == true) {
	          this.dataFomat(dynamicRiskIndexCmpResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }

	    var isDateEqual = Immutable.is(nextProps.selectDate, this.props.selectDate); //判断数据是否变化
	    if (!isDateEqual) {
	      var selectDate = nextProps.selectDate;
	      console.log(selectDate, 'selectDate222');

	      var selectDateLeftIsNull = $.isEmptyObject(selectDate.dateLeft);
	      var selectDateRightIsNull = $.isEmptyObject(selectDate.dateRight);
	      var currentMonth = this.state.currentMonth;
	      var compareMonth = this.state.compareMonth;
	      if (!selectDateLeftIsNull) {
	        currentMonth = selectDate.dateLeft;
	        this.setState({ currentMonth: currentMonth });
	      }
	      if (!selectDateRightIsNull) {
	        compareMonth = selectDate.dateRight;
	        this.setState({ compareMonth: compareMonth });
	      }
	      var json = {
	        areaCode: this.state.areaCode,
	        companyName: this.state.companyName,
	        currentMonth: currentMonth,
	        compareMonth: compareMonth
	      };
	      this.getDynamicRiskData(json);
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, 99999);
	    var content = data.content;
	    this.setState({ indexCmpData: content });
	  },
	  getDynamicRiskData: function getDynamicRiskData(data) {
	    var getDynamicRiskIndexCmp = this.props.getDynamicRiskIndexCmp;

	    getDynamicRiskIndexCmp(data);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-dynamic-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, null),
	      _react2.default.createElement(
	        'div',
	        { className: 'dynamic-risk-box content-space-10' },
	        _react2.default.createElement(
	          'div',
	          { className: 'top' },
	          _react2.default.createElement(
	            'div',
	            { className: 'left' },
	            _react2.default.createElement(_TimeAxisCompare2.default, this.props)
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'right' },
	            _react2.default.createElement(_IndexCompare2.default, _extends({}, this.props, { indexCmpData: this.state.indexCmpData }))
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'bottom mod-space-t' },
	          _react2.default.createElement(_IndexList2.default, { indexCmpData: this.state.indexCmpData })
	        )
	      )
	    );
	  }
	});

	function mapStateToProps(state) {
	  return {
	    //获取公司标签
	    dynamicRiskCompanyTagRequest: state.DynamicRiskCompanyTag.request,
	    dynamicRiskCompanyTagResult: state.DynamicRiskCompanyTag.result,

	    //获取对比图的日期
	    dynamicRiskDateRequest: state.DynamicRiskDate.request,
	    dynamicRiskDateResult: state.DynamicRiskDate.result,

	    //获取对比图 左侧
	    dynamicRiskLeftImgRequest: state.DynamicRiskLeftImg.request,
	    dynamicRiskLeftImgResult: state.DynamicRiskLeftImg.result,

	    //获取对比图 右侧
	    dynamicRiskRightImgRequest: state.DynamicRiskRightImg.request,
	    dynamicRiskRightImgResult: state.DynamicRiskRightImg.result,

	    dynamicRiskIndexCmpRequest: state.DynamicRiskIndexCmp.request,
	    dynamicRiskIndexCmpResult: state.DynamicRiskIndexCmp.result,

	    //获取搜索框的值  传递
	    riskSearch: state.RiskSearch.data,

	    //获取下拉选择框的日期 传递
	    selectDate: state.SelectDate.data
	  };
	}
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(LineFinanceDynamicRiskActionCreators, dispatch);
	}

	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceDynamicRisk);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DynamicRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 763:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(764);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _EachTimeAxisLeft = __webpack_require__(766);

	var _EachTimeAxisLeft2 = _interopRequireDefault(_EachTimeAxisLeft);

	var _EachTimeAxisRight = __webpack_require__(769);

	var _EachTimeAxisRight2 = _interopRequireDefault(_EachTimeAxisRight);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//时间轴对比
	var TimeAxisCompare = _react2.default.createClass({
	  displayName: 'TimeAxisCompare',

	  getInitialState: function getInitialState() {
	    return {
	      companyName: "",
	      month: "",
	      date: [],
	      dateLeft: "", //左侧日期
	      dateRight: "" //右侧日期
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var companyName = "《国际金融报》社有限公司";
	    var jsonData = { companyName: companyName };
	    this.setState({ companyName: companyName });
	    this.getRelativeDate(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    //获取公司名称 通过名称获取日期
	    var isSearchValEqual = Immutable.is(nextProps.riskSearch, this.props.riskSearch);
	    if (!isSearchValEqual) {
	      var riskSearch = nextProps.riskSearch;

	      var jsonData = { companyName: riskSearch };
	      this.setState({ companyName: riskSearch });
	      this.getRelativeDate(jsonData);
	    }

	    // 获取返回的日期
	    var isEqual = Immutable.is(nextProps.dynamicRiskDateResult, this.props.dynamicRiskDateResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskDateRequest = nextProps.dynamicRiskDateRequest;
	      var dynamicRiskDateResult = nextProps.dynamicRiskDateResult;

	      if (dynamicRiskDateRequest == true) {
	        if (dynamicRiskDateResult.success == true) {
	          this.dataDateFomat(dynamicRiskDateResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataDateFomat: function dataDateFomat(data) {
	    var content = data.content;
	    var len = content.length;
	    var dateArr = [];
	    for (var i = 0; i < len; i++) {
	      dateArr.push({ value: i + 1, label: content[i] });
	    }
	    //把第一个时间赋值给第一个图 第二个时间赋值给第二个图
	    this.setState({ date: dateArr, dateLeft: content[0], dateRight: content[1] });
	    var jsonData = { dateLeft: content[0], dateRight: content[1] };
	    this.getSelectDate(jsonData);
	  },
	  getRelativeDate: function getRelativeDate(jsonData) {
	    //获取日期
	    var getDynamicRiskDate = this.props.getDynamicRiskDate;

	    getDynamicRiskDate(jsonData);
	  },
	  getSelectDate: function getSelectDate(jsonData) {
	    //日期传递
	    var getSelectDate = this.props.getSelectDate;

	    getSelectDate(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-timeaxis-cmp mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '时间轴对比'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'cmp-box' },
	          _react2.default.createElement(
	            'div',
	            { className: 'cmp-l' },
	            _react2.default.createElement(_EachTimeAxisLeft2.default, _extends({ borderLeft: 'false' }, this.props, { date: this.state.date, nowDate: this.state.dateLeft, companyName: this.state.companyName }))
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'cmp-r' },
	            _react2.default.createElement(_EachTimeAxisRight2.default, _extends({ borderLeft: 'true' }, this.props, { date: this.state.date, nowDate: this.state.dateRight, companyName: this.state.companyName }))
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = TimeAxisCompare;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TimeAxisCompare.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 766:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(767);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//每个时间轴
	var EachTimeAxisLeft = _react2.default.createClass({
	  displayName: 'EachTimeAxisLeft',

	  getInitialState: function getInitialState() {
	    return {
	      wNo: 25,
	      scale: 100,
	      imgUrlLeft: '',
	      orgImgW: 0,
	      curImgW: 0
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    this.dragImg();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.nowDate, this.props.nowDate); //判断数据是否变化
	    if (!isEqual) {
	      var companyName = nextProps.companyName;
	      var nowDate = nextProps.nowDate;
	      var json = { companyName: companyName, month: nowDate };
	      this.getRelativeImg(json);
	    }
	    var isImgEqual = Immutable.is(nextProps.dynamicRiskLeftImgResult, this.props.dynamicRiskLeftImgResult);
	    if (!isImgEqual) {
	      var dynamicRiskLeftImgRequest = nextProps.dynamicRiskLeftImgRequest;
	      var dynamicRiskLeftImgResult = nextProps.dynamicRiskLeftImgResult;

	      if (dynamicRiskLeftImgRequest == true) {
	        if (dynamicRiskLeftImgResult.success == true) {
	          this.dataFomat(dynamicRiskLeftImgResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  getRelativeImg: function getRelativeImg(jsonData) {
	    //获取图片
	    var getDynamicRiskLeftImg = this.props.getDynamicRiskLeftImg;

	    getDynamicRiskLeftImg(jsonData);
	  },
	  getSelectDate: function getSelectDate(jsonData) {
	    //调用日期传递方法
	    var getSelectDate = this.props.getSelectDate;

	    getSelectDate(jsonData);
	  },
	  dataFomat: function dataFomat(data) {
	    var _this = this;
	    var imgUrl = data.content;
	    this.setState({ imgUrlLeft: imgUrl }, function () {
	      _this.getImgWidth();
	    });
	  },
	  getImgWidth: function getImgWidth() {
	    //获取图片宽度
	    var cmpImg = this.refs.cmpImg;
	    var orgImgW = $(cmpImg).width();
	    console.log(orgImgW, 'orgImgW3333333333');
	    this.setState({ orgImgW: orgImgW, curImgW: orgImgW });
	  },
	  setImgWidth: function setImgWidth(wNo, scale, curImgW) {
	    var cmpImg = this.refs.cmpImg;
	    $(cmpImg).width(curImgW);
	    this.setState({ wNo: wNo, scale: scale, curImgW: curImgW });
	  },

	  minClick: function minClick(e) {
	    //缩小图片
	    var wNo = this.state.wNo;
	    if (wNo > 25) {
	      wNo = wNo - 25;
	    }
	    var scale = wNo / 250 * 1000;
	    console.log(wNo, 'wNo3333333333');
	    var imgWScale = wNo / 25; //获取imgScale倍数
	    var orgImgW = this.state.orgImgW;
	    var curImgW = orgImgW * imgWScale;
	    this.setImgWidth(wNo, scale, curImgW);
	  },
	  addClick: function addClick(e) {
	    //放大图片
	    var wNo = this.state.wNo;
	    if (wNo < 200) {
	      wNo = wNo + 25;
	    }
	    var scale = wNo / 250 * 1000;
	    var imgWScale = wNo / 25; //获取imgScale倍数
	    var orgImgW = this.state.orgImgW;
	    var curImgW = orgImgW * imgWScale;
	    this.setImgWidth(wNo, scale, curImgW);
	  },
	  zoomoutClick: function zoomoutClick(e) {
	    var orgImgW = this.state.orgImgW;
	    this.setImgWidth(25, 100, orgImgW);
	  },
	  dragImg: function dragImg(e) {
	    var $this = $(this.refs.cmpImg);
	    var _x = 0,
	        _y = 0;
	    var _move = false;
	    $this.on('mousedown', function (e) {
	      e.preventDefault();
	      _move = true;
	      _x = e.pageX - parseInt($this.css("left"));
	      _y = e.pageY - parseInt($this.css("top"));
	    });
	    $(document).on('mousemove', function (e) {
	      e.preventDefault();
	      if (_move) {
	        var x = e.pageX - _x;
	        var y = e.pageY - _y;
	        $this.css({ top: y, left: x });
	      }
	    }).on('mouseup', function (e) {
	      e.preventDefault();
	      _move = false;
	    });
	  },
	  render: function render() {
	    var select = null;
	    var flag = this.props.flag;
	    var nowVal = null;

	    if (this.props.date.length > 0) {
	      var d = this.props.date[0];
	      nowVal = this.props.date[0].value;
	      var selectProp = {
	        width: '85px',
	        className: 'index-selected',
	        value: nowVal,
	        placeholder: '时间选择',
	        name: 'testselect',
	        id: 'indexSelected',
	        data: this.props.date,
	        onChange: function (value, date) {
	          var json = { companyName: this.props.companyName, month: date };
	          var jsonDate = { dateLeft: date };
	          this.getRelativeImg(json);
	          this.getSelectDate(jsonDate); //传递日期    
	        }.bind(this)
	      };
	      select = _react2.default.createElement(_index.Selected, selectProp);
	    }

	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-each-timeaxis mod' },
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft == 'true' ? 'mod-title bl' : 'mod-title' },
	        _react2.default.createElement(
	          'div',
	          { className: 'date' },
	          _react2.default.createElement(
	            'label',
	            null,
	            '时间选项'
	          ),
	          select
	        ),
	        _react2.default.createElement('i', { className: 'iconfont icon-zoomout', onClick: this.zoomoutClick }),
	        _react2.default.createElement(
	          'div',
	          { className: 'scale' },
	          _react2.default.createElement('i', { className: 'min iconfont icon-jian', onClick: this.minClick }),
	          _react2.default.createElement(
	            'div',
	            { className: 'scale-bar' },
	            _react2.default.createElement('span', { className: 's-bar', ref: 'sBar', style: { width: this.state.wNo + 'px' } }),
	            _react2.default.createElement(
	              'em',
	              { ref: 'sBarNo', style: { left: this.state.wNo + 10 + 'px' } },
	              this.state.scale,
	              '%'
	            )
	          ),
	          _react2.default.createElement('i', { className: 'add iconfont icon-jia', onClick: this.addClick })
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft ? 'mod-content bl' : 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'con-box' },
	          _react2.default.createElement('img', { src: this.state.imgUrlLeft, ref: 'cmpImg', alt: '时间轴对比图' })
	        )
	      )
	    );
	  }
	});
	module.exports = EachTimeAxisLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EachTimeAxisLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 768:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*单个时间轴 begin*/\r\n.linefin-each-timeaxis .mod-title{\r\n\theight: 45px;\r\n\tline-height: 45px;\r\n\tbackground-color: #1a2029 !important;\r\n\tpadding: 0 10px;\r\n\tmargin-top: 10px;\r\n}\r\n.linefin-each-timeaxis .mod-title.bl{\r\n\tborder-left: solid 1px #000000;\r\n}\r\n.linefin-each-timeaxis .mod-title .date{\r\n\tfloat: left;\r\n}\r\n.linefin-each-timeaxis .mod-title .date .label{\r\n\tfont-size: 14px;\r\n\tcolor: #ffffff;\r\n}\r\n.linefin-each-timeaxis .mod-title .date .mt-select{\r\n\tbackground-color: #ffffff;\r\n\tborder-radius: 5px;\r\n\tpadding-left: 5px;\r\n\tpadding-right: 0px;\r\n}\r\n.linefin-each-timeaxis .mod-title .date .mt-select .mt-select-title{\r\n\tcolor: #1a1a1a;\r\n}\r\n.linefin-each-timeaxis .mod-title .date .mt-select i{\r\n\tfont-size: 24px;\r\n\ttop: 0px;\r\n\tcolor:#1a1a1a;\r\n\tright:0px;\r\n}\r\n.linefin-each-timeaxis .mod-title .date .mt-select-box{\r\n\tcolor: #1a1a1a;\r\n}\r\n/*缩放条*/\r\n.scale{\r\n\tfloat: right;\r\n\tmargin-top: 10px;\r\n\twidth: 298px;\r\n\theight: 24px;\r\n\tbackground-color: #0d1013;\r\n}\r\n.scale .min,.scale .add{\r\n\tborder:solid 1px #dddddd;\r\n\tdisplay: inline-block;\r\n\twidth: 24px;\r\n\theight: 24px;\r\n\ttext-align: center;\r\n\tline-height: 20px;\r\n\tcursor: pointer;\r\n\tcolor: #00b7ee;\r\n}\r\n.scale .min{\r\n\tfloat: left;\r\n}\r\n.scale .add{\r\n\tfloat: right;\r\n}\r\n\r\n.scale .scale-bar{\r\n\tdisplay: inline-block;\r\n\twidth: 250px;\r\n\theight: 24px;\r\n\tfloat: left;\r\n\tposition: relative;\r\n}\r\n.scale .scale-bar .s-bar{\r\n\tdisplay:block;\r\n\twidth: 60%;\r\n\theight: 24px;\r\n\tbackground: #1e5799; /* Old browsers */\r\n\tbackground: -moz-linear-gradient(left,  #1e5799 0%, #00b7e7 0%, #207cca 100%, #7db9e8 100%); /* FF3.6-15 */\r\n\tbackground: -webkit-linear-gradient(left,  #1e5799 0%,#00b7e7 0%,#207cca 100%,#7db9e8 100%); /* Chrome10-25,Safari5.1-6 */\r\n\tbackground: linear-gradient(to right,  #1e5799 0%,#00b7e7 0%,#207cca 100%,#7db9e8 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */\r\n\tfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1e5799', endColorstr='#7db9e8',GradientType=1 ); /* IE6-9 */\r\n}\r\n.scale .scale-bar em{\r\n\tcolor: #999999;\r\n\tfont-size: 14px;\r\n\theight: 24px;\r\n\tposition: absolute;\r\n\tleft: 60%;\r\n\ttop: 3px;\r\n\tline-height: normal;\r\n}\r\n.linefin-each-timeaxis .mod-title .icon-zoomout{\r\n\tfloat: right;\r\n\tmargin-left: 10px;\r\n\tmargin-top: 13px;\r\n\tcolor: #00b7ee;\r\n}\r\n\r\n/*内容 begin*/\r\n.linefin-each-timeaxis .mod-content.bl{\r\n\tborder-left:solid 1px #282e37;\r\n}\r\n\r\n.linefin-each-timeaxis .mod-content .con-box{\r\n\twidth: 95%;\r\n\theight: 620px;\r\n\tmargin: 0 auto;\r\n\tmargin-top: 100px;\r\n\ttext-align: center;\r\n\tvertical-align: middle;\r\n\tposition: relative;\r\n}\r\n\r\n.linefin-each-timeaxis .mod-content .con-box img{\r\n\twidth: 80%;\r\n\tposition: absolute;\r\n\tleft: 50%;\r\n\ttop: 50%;\r\n\tmargin-left: -40%;\r\n\tmargin-top: -40%;\r\n}\r\n/*内容 end*/\r\n/*单个时间轴 end*/", ""]);

	// exports


/***/ },

/***/ 769:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(767);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//每个时间轴
	var EachTimeAxisRight = _react2.default.createClass({
	  displayName: 'EachTimeAxisRight',

	  getInitialState: function getInitialState() {
	    return {
	      wNo: 25,
	      scale: 100,
	      imgUrlRight: '',
	      dateRight: '',
	      orgImgW: 0,
	      curImgW: 0,
	      mouseDownFlag: false
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    this.dragImg();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.nowDate, this.props.nowDate); //判断数据是否变化

	    if (!isEqual) {
	      var companyName = nextProps.companyName;
	      var nowDate = nextProps.nowDate;
	      var json = { companyName: companyName, month: nowDate };
	      this.getRelativeImg(json);
	    }

	    var isImgEqual = Immutable.is(nextProps.dynamicRiskRightImgResult, this.props.dynamicRiskRightImgResult);
	    if (!isImgEqual) {
	      var dynamicRiskRightImgRequest = nextProps.dynamicRiskRightImgRequest;
	      var dynamicRiskRightImgResult = nextProps.dynamicRiskRightImgResult;

	      if (dynamicRiskRightImgRequest == true) {
	        if (dynamicRiskRightImgResult.success == true) {
	          this.dataFomat(dynamicRiskRightImgResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  getRelativeImg: function getRelativeImg(jsonData) {
	    //获取图片
	    var getDynamicRiskRightImg = this.props.getDynamicRiskRightImg;

	    getDynamicRiskRightImg(jsonData);
	  },
	  getSelectDate: function getSelectDate(jsonData) {
	    //调用日期传递方法
	    var getSelectDate = this.props.getSelectDate;

	    getSelectDate(jsonData);
	  },
	  dataFomat: function dataFomat(data) {
	    var _this = this;
	    var imgUrl = data.content;
	    console.log(imgUrl, 'imgUrl1111111111111111');
	    this.setState({ imgUrlRight: imgUrl }, function () {
	      _this.getImgWidth();
	    });
	  },
	  getImgWidth: function getImgWidth() {
	    //获取图片宽度
	    var cmpImg = this.refs.cmpImg;
	    var orgImgW = $(cmpImg).width();
	    this.setState({ orgImgW: orgImgW, curImgW: orgImgW });
	  },
	  setImgWidth: function setImgWidth(wNo, scale, curImgW) {
	    var cmpImg = this.refs.cmpImg;
	    $(cmpImg).width(curImgW);
	    this.setState({ wNo: wNo, scale: scale, curImgW: curImgW });
	  },
	  minClick: function minClick(e) {
	    //缩小图片
	    var wNo = this.state.wNo;
	    if (wNo > 25) {
	      wNo = wNo - 25;
	    }
	    var scale = wNo / 250 * 1000;
	    console.log(wNo, 'wNo3333333333');
	    var imgWScale = wNo / 25; //获取imgScale倍数
	    var orgImgW = this.state.orgImgW;
	    var curImgW = orgImgW * imgWScale;
	    this.setImgWidth(wNo, scale, curImgW);
	  },
	  addClick: function addClick(e) {
	    //放大图片
	    var wNo = this.state.wNo;
	    if (wNo < 200) {
	      wNo = wNo + 25;
	    }
	    var scale = wNo / 250 * 1000;
	    var imgWScale = wNo / 25; //获取imgScale倍数
	    var orgImgW = this.state.orgImgW;
	    var curImgW = orgImgW * imgWScale;
	    this.setImgWidth(wNo, scale, curImgW);
	  },
	  zoomoutClick: function zoomoutClick(e) {
	    var orgImgW = this.state.orgImgW;
	    this.setImgWidth(25, 100, orgImgW);
	  },
	  dragImg: function dragImg(e) {
	    var $this = $(this.refs.cmpImg);
	    var _x = 0,
	        _y = 0;
	    var _move = false;
	    $this.on('mousedown', function (e) {
	      e.preventDefault();
	      _move = true;
	      _x = e.pageX - parseInt($this.css("left"));
	      _y = e.pageY - parseInt($this.css("top"));
	    });
	    $(document).on('mousemove', function (e) {
	      e.preventDefault();
	      if (_move) {
	        var x = e.pageX - _x;
	        var y = e.pageY - _y;
	        $this.css({ top: y, left: x });
	      }
	    }).on('mouseup', function (e) {
	      e.preventDefault();
	      _move = false;
	    });
	  },
	  render: function render() {
	    var select = null;
	    var flag = this.props.flag;
	    var nowVal = null;

	    if (this.props.date.length > 0) {
	      var d = this.props.date[0];
	      nowVal = this.props.date[1].value;
	      var selectProp = {
	        width: '85px',
	        className: 'index-selected',
	        value: nowVal,
	        placeholder: '时间选择',
	        name: 'testselect',
	        id: 'indexSelected',
	        data: this.props.date,
	        onChange: function (value, date) {
	          var json = { companyName: this.props.companyName, month: date };
	          var jsonDate = { dateRight: date };
	          this.getRelativeImg(json);
	          this.getSelectDate(jsonDate); //传递日期              
	        }.bind(this)
	      };
	      select = _react2.default.createElement(_index.Selected, selectProp);
	    }

	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-each-timeaxis mod' },
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft == 'true' ? 'mod-title bl' : 'mod-title' },
	        _react2.default.createElement(
	          'div',
	          { className: 'date' },
	          _react2.default.createElement(
	            'label',
	            null,
	            '时间选项'
	          ),
	          select
	        ),
	        _react2.default.createElement('i', { className: 'iconfont icon-zoomout', onClick: this.zoomoutClick }),
	        _react2.default.createElement(
	          'div',
	          { className: 'scale' },
	          _react2.default.createElement('i', { className: 'min iconfont icon-jian', onClick: this.minClick }),
	          _react2.default.createElement(
	            'div',
	            { className: 'scale-bar' },
	            _react2.default.createElement('span', { className: 's-bar', ref: 'sBar', style: { width: this.state.wNo + 'px' } }),
	            _react2.default.createElement(
	              'em',
	              { ref: 'sBarNo', style: { left: this.state.wNo + 10 + 'px' } },
	              this.state.scale,
	              '%'
	            )
	          ),
	          _react2.default.createElement('i', { className: 'add iconfont icon-jia', onClick: this.addClick })
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: this.props.borderLeft ? 'mod-content bl' : 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'con-box' },
	          _react2.default.createElement('img', { src: this.state.imgUrlRight, ref: 'cmpImg', alt: '时间轴对比图' })
	        )
	      )
	    );
	  }
	});
	module.exports = EachTimeAxisRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EachTimeAxisRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 770:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(764);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//企业关联方特征指数对比
	var LineFinanceIndexCompare = _react2.default.createClass({
	    displayName: 'LineFinanceIndexCompare',

	    getInitialState: function getInitialState() {
	        return {
	            //关联自然人
	            decreaseRelationPerson: [],
	            addRelationPerson: [],
	            //关联法人
	            addCompanyPerson: [],
	            decreaseCompanyPerson: [],
	            //利益一致行动法人
	            addAgreeComDet: [],
	            decreaseAgreeComDet: [],
	            //子公司
	            addChildCompany: [],
	            decreaseChildCompany: [],
	            //一度自然人
	            addOnePerson: [],
	            decreaseOnePerson: [],
	            //一度法人
	            addOneCompany: [],
	            decreaseOneCompany: [],
	            //二度自然人
	            addTwoPerson: [],
	            decreaseTwoPerson: [],
	            //二度法人
	            addTwoCompany: [],
	            decreaseTwoCompany: [],
	            //三度自然人
	            addThreePerson: [],
	            decreaseThreePerson: [],
	            //三度法人
	            addThreeCompany: [],
	            decreaseThreeCompany: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log(nextProps, '33333333333333333');
	        var isEqual = Immutable.is(nextProps.indexCmpData, this.props.indexCmpData); //判断数据是否变化
	        if (!isEqual) {
	            var relationData = nextProps.indexCmpData.relationData;
	            console.log(relationData, relationData.decreaseRelationPerson, '指数对比');
	            this.setState({
	                //关联自然人
	                decreaseRelationPerson: relationData.decreaseRelationPerson,
	                addRelationPerson: relationData.addRelationPerson,
	                //关联法人
	                addCompanyPerson: relationData.addCompanyPerson,
	                decreaseCompanyPerson: relationData.decreaseCompanyPerson,
	                //利益一致行动法人
	                addAgreeComDet: relationData.addAgreeComDet,
	                decreaseAgreeComDet: relationData.decreaseAgreeComDet,
	                //子公司
	                addChildCompany: relationData.addChildCompany,
	                decreaseChildCompany: relationData.decreaseChildCompany,
	                //一度自然人
	                addOnePerson: relationData.addOnePerson,
	                decreaseOnePerson: relationData.decreaseOnePerson,
	                //一度法人
	                addOneCompany: relationData.addOneCompany,
	                decreaseOneCompany: relationData.decreaseOneCompany,
	                //二度自然人
	                addTwoPerson: relationData.addTwoPerson,
	                decreaseTwoPerson: relationData.decreaseTwoPerson,
	                //二度法人
	                addTwoCompany: relationData.addTwoCompany,
	                decreaseTwoCompany: relationData.decreaseTwoCompany,
	                //三度自然人
	                addThreePerson: relationData.addThreePerson,
	                decreaseThreePerson: relationData.decreaseThreePerson,
	                //三度法人
	                addThreeCompany: relationData.addThreeCompany,
	                decreaseThreeCompany: relationData.decreaseThreeCompany
	            });
	        }
	    },

	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        if (isTrue) {
	            $itemParent.removeClass('active');
	            $(this.refs.itemFirst).addClass('active');
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xup').addClass('icon-xdown');
	        } else {
	            $itemParent.find('.item-head .num-t i').removeClass('icon-xdown').addClass('icon-xup');
	            $(this.refs.itemFirst).removeClass('active');
	            $itemParent.addClass('active');
	            $itemParent.siblings('.item').removeClass('active');
	        }
	    },
	    render: function render() {
	        var _props$indexCmpData = this.props.indexCmpData;
	        var current = _props$indexCmpData.current;
	        var compare = _props$indexCmpData.compare;
	        var relationData = _props$indexCmpData.relationData;


	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-cmp mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业关联方特征指数对比'
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
	                        { className: 'd-cmp' },
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'date' },
	                            current
	                        ),
	                        _react2.default.createElement('i', { className: 'iconfont icon-duibi' }),
	                        _react2.default.createElement(
	                            'span',
	                            { className: 'date' },
	                            compare
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'item-box' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item active' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '关联自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseRelationPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addRelationPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '关联法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseCompanyPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addCompanyPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '利益一致行动法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '利益一致行动法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseAgreeComDet.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addAgreeComDet.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '子公司'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '子公司对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseChildCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addChildCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '一度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '一度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseOnePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addOnePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '一度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '一度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseOneCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addOneCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '二度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '二度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseTwoPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addTwoPerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '二度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '二度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseTwoCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addTwoCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '三度自然人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '三度自然人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseThreePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addThreePerson.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '三度法人'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-o' },
	                                    _react2.default.createElement('em', null)
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num-t' },
	                                    _react2.default.createElement('em', null),
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
	                                                    { width: '20%', className: 't-left', rowSpan: '4' },
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        '三度法人对比明细'
	                                                    )
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 减少',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-arrowupx' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.decreaseThreeCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    compare,
	                                                    ' 增加',
	                                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '80%', className: 't-right' },
	                                                    this.state.addThreeCompany.map(function (item, index) {
	                                                        return _react2.default.createElement(
	                                                            'span',
	                                                            null,
	                                                            item
	                                                        );
	                                                    })
	                                                )
	                                            )
	                                        )
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
	module.exports = LineFinanceIndexCompare;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexCompare.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 782:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.getDynamicRiskLeftImg = getDynamicRiskLeftImg;
	exports.getDynamicRiskRightImg = getDynamicRiskRightImg;
	exports.getDynamicRiskIndexCmp = getDynamicRiskIndexCmp;
	exports.getDynamicRiskCompanyTag = getDynamicRiskCompanyTag;
	exports.getDynamicRiskDate = getDynamicRiskDate;
	exports.getSelectDate = getSelectDate;
	/*
	* 动态风险模块 action
	* */

	/*
	* 获取图片 左侧
	* */
	var DYNAMIC_RISK_LEFTIMG_SUCCESS = exports.DYNAMIC_RISK_LEFTIMG_SUCCESS = "DYNAMIC_RISK_LEFTIMG_SUCCESS";
	var DYNAMIC_RISK_LEFTIMG_FAIL = exports.DYNAMIC_RISK_LEFTIMG_FAIL = "DYNAMIC_RISK_LEFTIMG_FAIL";

	function dynamicRiskLeftImgSuccess(result) {
		return {
			type: DYNAMIC_RISK_LEFTIMG_SUCCESS,
			result: result
		};
	}
	function dynamicRiskLeftImgFail(result) {
		return {
			type: DYNAMIC_RISK_LEFTIMG_FAIL,
			result: result
		};
	}

	function getDynamicRiskLeftImg() {
		var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

		return function (dispatch) {
			$.ajax({
				type: 'GET',
				url: '/offlineFinance/showYEDData.do',
				dataType: 'json',
				data: json,
				success: function success(result) {
					return dispatch(dynamicRiskLeftImgSuccess(result));
				},
				error: function error(result) {
					return dispatch(dynamicRiskLeftImgFail(result));
				}
			});
		};
	};
	/*
	* 获取图片 右侧
	* */
	var DYNAMIC_RISK_RIGHTIMG_SUCCESS = exports.DYNAMIC_RISK_RIGHTIMG_SUCCESS = "DYNAMIC_RISK_RIGHTIMG_SUCCESS";
	var DYNAMIC_RISK_RIGHTIMG_FAIL = exports.DYNAMIC_RISK_RIGHTIMG_FAIL = "DYNAMIC_RISK_RIGHTIMG_FAIL";

	function dynamicRiskRightImgSuccess(result) {
		return {
			type: DYNAMIC_RISK_RIGHTIMG_SUCCESS,
			result: result
		};
	}
	function dynamicRiskRightImgFail(result) {
		return {
			type: DYNAMIC_RISK_RIGHTIMG_FAIL,
			result: result
		};
	}

	function getDynamicRiskRightImg() {
		var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

		return function (dispatch) {
			$.ajax({
				type: 'GET',
				url: '/offlineFinance/showYEDData.do',
				dataType: 'json',
				data: json,
				success: function success(result) {
					return dispatch(dynamicRiskRightImgSuccess(result));
				},
				error: function error(result) {
					return dispatch(dynamicRiskRightImgFail(result));
				}
			});
		};
	};

	/*
	* 企业关联方特征指数对比
	* */
	var DYNAMIC_RISK_INDEX_CMP_SUCCESS = exports.DYNAMIC_RISK_INDEX_CMP_SUCCESS = "DYNAMIC_RISK_INDEX_CMP_SUCCESS";
	var DYNAMIC_RISK_INDEX_CMP_FAIL = exports.DYNAMIC_RISK_INDEX_CMP_FAIL = "DYNAMIC_RISK_INDEX_CMP_FAIL";

	function dynamicRiskIndexCmpSuccess(result) {
		return {
			type: DYNAMIC_RISK_INDEX_CMP_SUCCESS,
			result: result
		};
	}
	function dynamicRiskIndexCmpFail(result) {
		return {
			type: constDYNAMIC_RISK_INDEX_CMP_FAIL,
			result: result
		};
	}

	function getDynamicRiskIndexCmp() {
		var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

		return function (dispatch) {
			$.ajax({
				type: 'GET',
				url: '/offlineFinance/dynamicRiskData.do',
				dataType: 'json',
				data: json,
				success: function success(result) {
					return dispatch(dynamicRiskIndexCmpSuccess(result));
				},
				error: function error(result) {
					return dispatch(dynamicRiskIndexCmpFail(result));
				}
			});
		};
	}

	/*
	* 获取公司标签
	* */
	var DYNAMIC_RISK_COMPANY_TAG_SUCCESS = exports.DYNAMIC_RISK_COMPANY_TAG_SUCCESS = "DYNAMIC_RISK_COMPANY_TAG_SUCCESS";
	var DYNAMIC_RISK_COMPANY_TAG_FAIL = exports.DYNAMIC_RISK_COMPANY_TAG_FAIL = "DYNAMIC_RISK_COMPANY_TAG_FAIL";

	function getDynamicRiskCompanyTagsSuccess(result) {
		return {
			type: DYNAMIC_RISK_COMPANY_TAG_SUCCESS,
			result: result
		};
	}
	function getDynamicRiskCompanyTagsFail(result) {
		return {
			type: DYNAMIC_RISK_COMPANY_TAG_FAIL,
			result: result
		};
	}

	function getDynamicRiskCompanyTag() {
		var json = arguments.length <= 0 || arguments[0] === undefined ? null : arguments[0];

		return function (dispatch) {
			$.ajax({
				type: 'GET',
				url: '/offlineFinance/companyInfo.do',
				dataType: 'json',
				data: json,
				success: function success(result) {
					return dispatch(getDynamicRiskCompanyTagsSuccess(result));
				},
				error: function error(result) {
					return dispatch(getDynamicRiskCompanyTagsFail(result));
				}
			});
		};
	}

	/*
	* 获取对比时间
	* */
	var DYNAMIC_RISK_DATE_SUCCESS = exports.DYNAMIC_RISK_DATE_SUCCESS = "DYNAMIC_RISK_DATE_SUCCESS";
	var DYNAMIC_RISK_DATE_FAIL = exports.DYNAMIC_RISK_DATE_FAIL = "DYNAMIC_RISK_DATE_FAIL";

	function getDynamicRiskDateSuccess(result) {
		return {
			type: DYNAMIC_RISK_DATE_SUCCESS,
			result: result
		};
	}
	function getDynamicRiskDateFail(result) {
		return {
			type: DYNAMIC_RISK_DATE_FAIL,
			result: result
		};
	}

	function getDynamicRiskDate(json) {
		return function (dispatch) {
			$.ajax({
				type: 'GET',
				url: '/offlineFinance/queryDateVersion.do',
				dataType: 'json',
				data: json,
				success: function success(result) {
					return dispatch(getDynamicRiskDateSuccess(result));
				},
				error: function error(result) {
					return dispatch(getDynamicRiskDateFail(result));
				}
			});
		};
	}

	/*指数对比下拉选择框日期传递 begin*/
	var SELECT_DATE = exports.SELECT_DATE = 'SELECT_DATE';

	function getSelectDate(data) {
		return {
			type: SELECT_DATE,
			data: data
		};
	}
	/*指数对比下拉选择框日期传递 end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceDynamicRiskAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 839:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(835);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var AareaRanking = _react2.default.createClass({
	    displayName: 'AareaRanking',

	    getInitialState: function getInitialState() {
	        return {
	            listData: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getAreaRankRequest = this.props.getAreaRankRequest;

	        var jsonData = {};
	        getAreaRankRequest(jsonData);
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.listData, field, this.state.orderType);
	            this.setState({ listData: _basedata });
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.areaRankingResult, this.props.areaRankingResult);
	        if (!isEqual) {
	            var areaRankingRequest = nextProps.areaRankingRequest;
	            var areaRankingResult = nextProps.areaRankingResult;

	            if (areaRankingRequest == true) {
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
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'ecosystem', onClick: this.handleClick.bind(this, "ecosystem") },
	                                '生态环境',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'scale', onClick: this.handleClick.bind(this, "scale") },
	                                '规模',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'popularity', onClick: this.handleClick.bind(this, "popularity") },
	                                '人气',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' }),
	                                ' '
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'safety', onClick: this.handleClick.bind(this, "safety") },
	                                '安全',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' }),
	                                ' '
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'recognition', onClick: this.handleClick.bind(this, "recognition") },
	                                '资本认可',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'competitiveness', onClick: this.handleClick.bind(this, "competitiveness") },
	                                '综合竞争',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'rank', onClick: this.handleClick.bind(this, "rank") },
	                                '排名',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' }),
	                                ' '
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

/***/ 844:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; }; //基本信息
	//公司基本信息
	//核心数据
	//诉讼信息
	//平台舆情
	//动态图谱
	//评分雷达图


	__webpack_require__(831);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _baseMsg = __webpack_require__(845);

	var _baseMsg2 = _interopRequireDefault(_baseMsg);

	var _companyMsg = __webpack_require__(848);

	var _companyMsg2 = _interopRequireDefault(_companyMsg);

	var _coreData = __webpack_require__(849);

	var _coreData2 = _interopRequireDefault(_coreData);

	var _litigation = __webpack_require__(851);

	var _litigation2 = _interopRequireDefault(_litigation);

	var _publicOpinion = __webpack_require__(852);

	var _publicOpinion2 = _interopRequireDefault(_publicOpinion);

	var _rankPic = __webpack_require__(853);

	var _rankPic2 = _interopRequireDefault(_rankPic);

	var _scoreLeida = __webpack_require__(854);

	var _scoreLeida2 = _interopRequireDefault(_scoreLeida);

	var _P2PPortraitAction = __webpack_require__(856);

	var P2PPortraitCreaters = _interopRequireWildcard(_P2PPortraitAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//p2p平台画像
	var P2PPortrait = _react2.default.createClass({
	    displayName: 'P2PPortrait',

	    mixins: [_setHeight2.default],
	    getInitialState: function getInitialState() {
	        return {
	            getCompany: "",
	            companyName: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        this.setState({ getCompany: _selectVal }, function () {
	            $.ajax({
	                url: "/P2PImage/hasOrNotCompany.do",
	                dataType: "json",
	                data: {
	                    platName: this.state.getCompany
	                },
	                type: "GET",
	                success: function (result) {
	                    if (result.success) {
	                        this.setState({ companyName: result.content.name });
	                    }
	                }.bind(this)
	            });
	        });
	    },
	    handleFunction: function handleFunction(searchVal) {
	        $.ajax({
	            url: "/P2PImage/hasOrNotCompany.do",
	            dataType: "json",
	            data: {
	                platName: searchVal
	            },
	            type: "GET",
	            success: function (result) {
	                if (result.success) {
	                    this.setState({ companyVal: searchVal, companyName: result.content.name }, function () {
	                        var _props = this.props;
	                        var getbaseMsgRequest = _props.getbaseMsgRequest;
	                        var getcompanyMsgRequest = _props.getcompanyMsgRequest;
	                        var getcoreDataRequest = _props.getcoreDataRequest;
	                        var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	                        var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	                        var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;
	                        var getlitigationRequest = _props.getlitigationRequest;
	                        var getpublicOpinionRequest = _props.getpublicOpinionRequest;
	                        var getrankPicRequest = _props.getrankPicRequest;
	                        var getscoreLeidaRequest = _props.getscoreLeidaRequest;


	                        getbaseMsgRequest({ "platName": this.state.companyVal });
	                        getcompanyMsgRequest({ "platName": this.state.companyVal });
	                        getcoreDataRequest({ "platName": this.state.companyVal });
	                        getCoreBarDataRequest({ "platName": this.state.companyVal });
	                        getCoreTrendDataRequest({ "platName": this.state.companyVal });
	                        getCoreBalanceDataRequest({ "platName": this.state.companyVal });

	                        getlitigationRequest({ "platName": this.state.companyVal });
	                        getpublicOpinionRequest({ "platName": this.state.companyVal });

	                        getrankPicRequest({
	                            "platName": this.state.companyVal,
	                            "companyName": result.content.name,
	                            "dataVersion": "20160530",
	                            "degree": 3
	                        });

	                        getscoreLeidaRequest({ "platName": this.state.companyVal });
	                    });
	                }
	            }.bind(this)
	        });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-portrait', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', isHotWorld: 'false', searchFun: this.handleFunction, placeholder: '请输入平台全称' }),
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
	                        _react2.default.createElement(_companyMsg2.default, _extends({}, this.props, { data: this.state.companyName })),
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

/***/ 845:
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
	var BaseMsg = _react2.default.createClass({
	    displayName: 'BaseMsg',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getbaseMsgRequest = this.props.getbaseMsgRequest;

	        getbaseMsgRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.baseMsgResult, this.props.baseMsgResult);
	        if (!isEqual) {
	            var baseMsgRequest = nextProps.baseMsgRequest;
	            var baseMsgResult = nextProps.baseMsgResult;

	            if (baseMsgRequest == true) {
	                if (baseMsgResult.success) {
	                    var _setParm = [baseMsgResult.content];
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
	                                    { className: 'odd-blackbg-line' },
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

/***/ 848:
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
	var CompanyMsg = _react2.default.createClass({
	  displayName: 'CompanyMsg',

	  getInitialState: function getInitialState() {
	    var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	    return {
	      companyVal: _selectVal,
	      listData: []
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getcompanyMsgRequest = this.props.getcompanyMsgRequest;

	    getcompanyMsgRequest({ "platName": this.state.companyVal });
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps, "nextProps================================");
	    var isEqual = Immutable.is(nextProps.companyMsgResult, this.props.companyMsgResult);
	    if (!isEqual) {
	      var companyMsgRequest = nextProps.companyMsgRequest;
	      var companyMsgResult = nextProps.companyMsgResult;

	      if (companyMsgRequest == true) {
	        if (companyMsgResult.success) {
	          var _setParm = [companyMsgResult.content];
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
	      { className: 'left-t radius4 mod' },
	      this.state.listData.map(function (item, index) {
	        {
	          var _logo = "/images/no-logo.png";
	          if (item.logo) {
	            _logo = item.logo;
	          }
	          return _react2.default.createElement(
	            'ul',
	            null,
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement('img', { className: 'compangMsg-log', src: _logo })
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                'span',
	                { className: 'score orange' },
	                item.score
	              ),
	              _react2.default.createElement(
	                'span',
	                { className: 'score-title' },
	                '评分'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                'span',
	                { className: 'state' },
	                item.status
	              )
	            )
	          );
	        }
	      })
	    );
	  }
	});

	module.exports = CompanyMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	    componentDidMount: function componentDidMount() {
	        var _props = this.props;
	        var getcoreDataRequest = _props.getcoreDataRequest;
	        var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	        var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	        var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

	        getcoreDataRequest({ "platName": this.state.companyVal });
	        getCoreBarDataRequest({ "platName": this.state.companyVal });
	        getCoreTrendDataRequest({ "platName": this.state.companyVal });
	        getCoreBalanceDataRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.coreDataResult, this.props.coreDataResult);
	        if (!isEqual) {
	            var coreDataRequest = nextProps.coreDataRequest;
	            var coreDataResult = nextProps.coreDataResult;

	            if (coreDataRequest == true) {
	                if (coreDataResult.success) {
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
	                        legend: ["交易量"],
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
				companyVal: _selectVal
			};
		},
		componentDidMount: function componentDidMount() {
			var getlitigationRequest = this.props.getlitigationRequest;

			getlitigationRequest({ "platName": this.state.companyVal });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
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
											{ to: { pathname: '/SearchResultDetail', query: { formpage: 'Portrait' } }, className: 'orange' },
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

/***/ 852:
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

	var PublicOpinion = _react2.default.createClass({
					displayName: 'PublicOpinion',

					getInitialState: function getInitialState() {
									var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
									return {
													listData: [],
													companyVal: _selectVal
									};
					},
					componentDidMount: function componentDidMount() {
									var getpublicOpinionRequest = this.props.getpublicOpinionRequest;

									getpublicOpinionRequest({ "platName": this.state.companyVal });
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.publicOpinionResult, this.props.publicOpinionResult);
									if (!isEqual) {
													var publicOpinionRequest = nextProps.publicOpinionRequest;
													var publicOpinionResult = nextProps.publicOpinionResult;

													if (publicOpinionRequest == true) {
																	if (publicOpinionResult.success) {
																					var _setData = [];
																					for (var item in publicOpinionResult.content.warning) {
																									var items = {
																													"info": publicOpinionResult.content.warning[item].info,
																													"name": publicOpinionResult.content.plat_name
																									};
																									_setData.push(items);
																					}

																					console.log(_setData, "================publicOpinionResult==");
																					this.setState({ listData: _setData });
																	} else {
																					//错误后提示
																	}
													}
									}
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ className: 'bottom-r radius4 mod' },
													_react2.default.createElement(
																	'div',
																	{ className: 'header-gray' },
																	_react2.default.createElement(
																					'span',
																					{ className: 'title' },
																					'平台舆情'
																	)
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'content' },
																	this.state.listData.map(function (item, index) {
																					{
																									var num = index + 1;
																									return _react2.default.createElement(
																													'div',
																													{ className: 'list-item' },
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
																																													{ rowSpan: '3', className: 'v-aglign-t td2-l' },
																																													_react2.default.createElement(
																																																	'span',
																																																	{ className: 'serial-num' },
																																																	num
																																													)
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													{ className: 'td2-r' },
																																													_react2.default.createElement(
																																																	'a',
																																																	{ href: 'javascript:void(null)' },
																																																	item.name
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
																																																	'p',
																																																	{ className: 'item-mark' },
																																																	item.info
																																													)
																																									)
																																					)
																																	)
																													)
																									);
																					}
																	})
													)
									);
					}
	});

	module.exports = PublicOpinion;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "publicOpinion.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        var getrankPicRequest = this.props.getrankPicRequest;

	        getrankPicRequest({
	            "platName": this.state.companyVal,
	            "companyName": "宁夏思越资产投资管理有限责任公司",
	            "dataVersion": "20160530",
	            "degree": 3
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
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
	                                    "symbol": symbol
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

/***/ 854:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _RadarChart = __webpack_require__(855);

	var _RadarChart2 = _interopRequireDefault(_RadarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var ScoreLeida = _react2.default.createClass({
		displayName: 'ScoreLeida',

		getInitialState: function getInitialState() {
			var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
			return {
				listData: [],
				leidaData: null,
				companyVal: _selectVal
			};
		},
		componentDidMount: function componentDidMount() {
			var getscoreLeidaRequest = this.props.getscoreLeidaRequest;

			getscoreLeidaRequest({ "platName": this.state.companyVal });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.scoreLeidaResult, this.props.scoreLeidaResult);
			if (!isEqual) {
				var scoreLeidaRequest = nextProps.scoreLeidaRequest;
				var scoreLeidaResult = nextProps.scoreLeidaResult;

				if (scoreLeidaRequest == true) {
					if (scoreLeidaResult.success) {
						var socreNum = $(this.refs.scoreNum).html(scoreLeidaResult.content.score);
						var _setindicator = [];
						for (var item in scoreLeidaResult.content.indicator) {
							var items = {
								"name": scoreLeidaResult.content.indicator[item].name,
								"max": scoreLeidaResult.content.indicator[item].max + 30
							};
							_setindicator.push(items);
						}
						var chartOption = {
							"color": ["#00b8ee"],
							"legend": ["评分"],
							"legendShow": false,
							"series": scoreLeidaResult.content.series,
							"radarRadius": 110,
							"indicator": _setindicator
						};
						this.setState({ listData: scoreLeidaResult.content.indicator });
						this.setState({ leidaData: chartOption });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBoxBar = "";
			if (this.state.leidaData) {
				chartBoxBar = _react2.default.createElement(_RadarChart2.default, { option: this.state.leidaData, style: { height: '380px', width: '100%' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'right-t radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'评分雷达图'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						{ className: 'content-ul' },
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-l' },
							_react2.default.createElement(
								'p',
								{ className: 'orange socre-title' },
								'评分：'
							),
							_react2.default.createElement('p', { className: 'orange score', ref: 'scoreNum' })
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-c' },
							_react2.default.createElement(
								'div',
								{ className: 'leida-c-pic' },
								chartBoxBar
							)
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-r' },
							_react2.default.createElement(
								'ul',
								{ className: 'score-leida-r-ul' },
								this.state.listData.map(function (item, index) {
									{

										return _react2.default.createElement(
											'li',
											null,
											_react2.default.createElement(
												'p',
												null,
												item.max
											),
											_react2.default.createElement(
												'span',
												null,
												item.name
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

	module.exports = ScoreLeida;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "scoreLeida.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 860:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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
	        var isEqual = Immutable.is(nextProps.businessTypesResult, this.props.businessTypesResult);
	        if (!isEqual) {
	            var businessTypesRequest = nextProps.businessTypesRequest;
	            var businessTypesResult = nextProps.businessTypesResult;

	            if (businessTypesRequest == true) {
	                if (businessTypesResult.success) {
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
	                        "lable": {
	                            normal: { show: false },
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

/***/ 863:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
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
	        var isEqual = Immutable.is(nextProps.investPeopleResult, this.props.investPeopleResult);
	        if (!isEqual) {
	            var investPeopleRequest = nextProps.investPeopleRequest;
	            var investPeopleResult = nextProps.investPeopleResult;

	            if (investPeopleRequest == true) {
	                if (investPeopleResult.success) {
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
	                        formatter: "raise",
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
	                    '上月上海各类众筹平台新增项目的投资人次'
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

/***/ 864:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
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
	        var isEqual = Immutable.is(nextProps.newProjectResult, this.props.newProjectResult);
	        if (!isEqual) {
	            var newProjectRequest = nextProps.newProjectRequest;
	            var newProjectResult = nextProps.newProjectResult;

	            if (newProjectRequest == true) {
	                if (newProjectResult.success) {
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
	                    '上月上海各类众筹平台新增项目数'
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

/***/ 865:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
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
	        var isEqual = Immutable.is(nextProps.raiseMountResult, this.props.raiseMountResult);
	        if (!isEqual) {
	            var raiseMountRunRequest = nextProps.raiseMountRunRequest;
	            var raiseMountResult = nextProps.raiseMountResult;

	            if (raiseMountRunRequest == true) {
	                if (raiseMountResult.success) {
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
	                    '上月上海各类众筹平台新增项目数的成功筹资金额'
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
	                                    var _danwei = item.registeredCapitalType == 1 ? "人民币" : "美元";
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
	                                                item.companyName
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
	                                                item.companyName
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

/***/ 883:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(884);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RegionalDis = _react2.default.createClass({
	    displayName: 'RegionalDis',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getRegionalDisRequest = this.props.getRegionalDisRequest;

	        var jsonData = {};
	        getRegionalDisRequest(jsonData);
	    },
	    onChartClick: function onChartClick(param, echart) {
	        var setPieCounty = this.props.setPieCounty;

	        var jsonData = { areaName: param.data.name };
	        setPieCounty(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.regionalDisResult, this.props.regionalDisResult);
	        if (!isEqual) {
	            var regionalDisRequest = nextProps.regionalDisRequest;
	            var regionalDisResult = nextProps.regionalDisResult;


	            if (regionalDisRequest == true) {
	                if (regionalDisResult.success) {
	                    var _setData = [];
	                    for (var i = 0; i < regionalDisResult.content.yAxis.length; i++) {
	                        var item = {
	                            "name": regionalDisResult.content.yAxis[i],
	                            "value": regionalDisResult.content.series[i]
	                        };
	                        _setData.push(item);
	                    }
	                    var setParm = {
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
	                        "radius": "70%",
	                        "lable": {
	                            normal: {
	                                show: true,
	                                formatter: function formatter(val) {
	                                    return val.name + ":" + val.value;
	                                }
	                            },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '50%'],
	                        "series": _setData
	                    };

	                    this.setState({ option: setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        var onEvents = {
	            'click': this.onChartClick
	        };
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_BasePie2.default, { option: this.state.option, onEvents: onEvents, style: { height: '530px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-top' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '交易场所区域分布'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = RegionalDis;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RegionalDis.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 886:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(884);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(809);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Classification = _react2.default.createClass({
	    displayName: 'Classification',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getClassificationAllRequest = this.props.getClassificationAllRequest;

	        var jsonData = {};
	        getClassificationAllRequest(jsonData);
	    },
	    onChartClick: function onChartClick(param, echart) {
	        var setBarName = this.props.setBarName;

	        var jsonData = { statusName: param.name };
	        setBarName(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.classificationResult, this.props.classificationResult);
	        if (!isEqual) {
	            var classificationRequest = nextProps.classificationRequest;
	            var classificationResult = nextProps.classificationResult;


	            if (classificationRequest == true) {
	                if (classificationResult.success) {

	                    var _yAxis = [],
	                        _series = [];
	                    for (var i = 0; i < classificationResult.content.length; i++) {
	                        for (var item in classificationResult.content[i]) {
	                            _yAxis.push(item);
	                            _series.push(classificationResult.content[i][item]);
	                        }
	                    }
	                    var setParm = {
	                        color: ["#e14340"],
	                        "barWidth": 30,
	                        legendRight: "20",
	                        xAxisLine: true,
	                        xAxisLabel: true,
	                        titleName: "",
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
	                        gridRight: "10%",
	                        gridLeft: "5%",
	                        gridBottom: "5%",
	                        gridTop: "5%",
	                        xAxisName: "企业数",
	                        yAxis: _yAxis,
	                        series: [_series]
	                    };
	                    this.setState({ option: setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        var onEvents = {
	            'click': this.onChartClick
	        };
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_HorizontalBarChart2.default, { onEvents: onEvents, option: this.state.option, style: { height: '530px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-top' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '交易场所清理整顿分类'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = Classification;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Classification.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 887:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(884);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var HPQList = _react2.default.createClass({
	    displayName: 'HPQList',

	    getInitialState: function getInitialState() {
	        return {
	            list: [],
	            orderZB: "DESC",
	            areaName: "",
	            orderName: ""
	        };
	    },
	    countyChange: function countyChange(county, listType, orderType) {
	        var getHPQListRequest = this.props.getHPQListRequest;

	        var jsonData = {
	            areaName: county, //地区
	            orderName: listType, //列表排序
	            orderType: orderType //desc  //asc
	        };
	        getHPQListRequest(jsonData);
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ areaName: "" });
	        this.setState({ orderZB: "DESC" });
	        this.countyChange(this.state.areaName, "", this.state.orderZB);
	        $('#hpqList-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#hpqList-scroll').perfectScrollbar('update');
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderName: field, orderZB: _dom.attr("data-order") }, function () {
	            this.countyChange(this.state.areaName, field, this.state.orderZB);
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqualCounty = Immutable.is(nextProps.pieCounty.areaName, this.props.pieCounty.areaName);
	        if (!isEqualCounty) {
	            this.setState({ areaName: nextProps.pieCounty.areaName });
	            this.countyChange(nextProps.pieCounty.areaName, "", "");
	        }

	        var isEqual = Immutable.is(nextProps.HPQListResult, this.props.HPQListResult);
	        if (!isEqual) {
	            var HPQListRequest = nextProps.HPQListRequest;
	            var HPQListResult = nextProps.HPQListResult;


	            if (HPQListRequest == true) {
	                if (HPQListResult.success) {
	                    this.setState({ list: HPQListResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-bottom' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '黄浦区交易场所列表'
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
	                                    '交易所'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderZB, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital") },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderZB, ref: 'registeredDate', onClick: this.handleClick.bind(this, "registeredDate") },
	                                    '注册时间',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'hpqList-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.list.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _address = item.address == null ? "/" : item.address;
	                                    var _registeredCapital = item.registeredCapital == null ? "/" : item.registeredCapital + "万元";
	                                    var _registeredDate = item.registeredDate == null ? "/" : item.registeredDate;
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
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'HPQList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name, title: item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address, title: _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredCapital
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredDate
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
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'HPQList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name, title: item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address, title: _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredCapital
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredDate
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

	module.exports = HPQList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "HPQList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 888:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(884);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DetailList = _react2.default.createClass({
	    displayName: 'DetailList',

	    getInitialState: function getInitialState() {
	        return {
	            statusName: "",
	            listData: []
	        };
	    },
	    countyChange: function countyChange(county) {
	        var getDetailListRequest = this.props.getDetailListRequest;

	        var jsonData = {
	            statusName: county
	        };
	        getDetailListRequest(jsonData);
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ statusName: "" });
	        this.countyChange(this.statusName);
	        $('#detailList-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#detailList-scroll').perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var isEqualName = Immutable.is(nextProps.barName.statusName, this.props.barName.statusName);
	        if (!isEqualName) {
	            this.setState({ statusName: nextProps.barName.statusName });
	            this.countyChange(nextProps.barName.statusName);
	        }

	        var isEqual = Immutable.is(nextProps.detailListResult, this.props.detailListResult);
	        if (!isEqual) {
	            var detailListRequest = nextProps.detailListRequest;
	            var detailListResult = nextProps.detailListResult;


	            if (detailListRequest == true) {
	                if (detailListResult.success) {
	                    this.setState({ listData: detailListResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-bottom' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '取得合规意见或经过会商的交易场所详情列表'
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
	                                    '交易所'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '审批部门'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '监管部门'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '法定代表人'
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'detailList-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _legaPerson = item.legalPerson == null ? "/" : item.legalPerson;
	                                    var _approveDepartment = item.approveDepartment == null ? "/" : item.approveDepartment;
	                                    var _superviseDepartment = item.superviseDepartment == null ? "/" : item.superviseDepartment;
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
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'DetailList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name, title: item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _approveDepartment
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _superviseDepartment, title: _superviseDepartment },
	                                                    _superviseDepartment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _legaPerson
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
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'DetailList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name, title: item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _approveDepartment
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', title: _superviseDepartment, 'data-tip': _superviseDepartment },
	                                                    _superviseDepartment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _legaPerson
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

	module.exports = DetailList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DetailList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 928:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*@parkMonitor jifei  图片\r\n---------------------------------------------------------*/\r\n.Imgs{\r\n\twidth: 100%;\r\n\theight: 770px;\r\n    background: url(\"/images/Bg.png\") no-repeat;\r\n    background-size: 100% 770px;\r\n}\r\n/*@parkMonitor 舆情\r\n---------------------------------------------------------*/\r\n.Consensu{\r\n\twidth: 100%;\r\n\theight: 320px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n.Consensu h3{\r\n\tpadding: 15px 20px;\r\n\tcolor: #ddd;\r\n}\r\n.Consensu .box{\r\n\twidth: 99%;\r\n    height: 240px;\r\n    overflow: auto;\r\n    padding: 0px 0 0 10px;\r\n    margin-top: 15px;\r\n}\r\n.Consensu .box .list{\r\n\twidth: 98%;\r\n\theight: 115px;\r\n\tborder-bottom: 1px solid #484f59;\t\r\n\tbackground: #1b1f28;\r\n}\r\n.Consensu .box .list:nth-child(even){\r\n\tmargin-top: 10px;\r\n\tmargin-bottom: 10px;\r\n}\r\n.Consensu .box .list ul{\r\n\twidth: 100%;\r\n\theight: 105px;\r\n}\r\n.Consensu .box .list li{\r\n    height: 33px;\r\n    line-height: 50px;\r\n    text-indent: 30px;\r\n    font-size: 14px;\r\n}\r\n.Consensu .box .list li:nth-child(1){\r\n\tfont-size: 14px;\r\n\tcolor: #e34f4b;\r\n\tcursor: pointer;\r\n}\r\n.Consensu .box .list li:nth-child(1) .liLeft{\r\n\tmargin-left: 20px;\r\n}\r\n.Consensu .box .list li:nth-child(2){\r\n\tfont-size: 14px;\r\n    cursor: pointer;\r\n    width: 89%;\r\n    overflow: hidden;\r\n    white-space: nowrap;\r\n    text-overflow: ellipsis;\r\n}\r\n.Consensu .box .list li:nth-child(1) a{\r\n\tcolor: #e34f4b;\r\n}\r\n.Consensu .box .list li:nth-child(3) .liRight{\r\n\tfloat: right;\r\n\tpadding-right: 20px;\r\n\tfont-size: 14px;\r\n\tcolor: #8b8f98;\r\n}\r\n.Consensu .box .list li:nth-child(3) .spanLeft{\r\n\tmargin-right: 20px;\r\n}\r\n/*@parkMonitor 类金融企业集中度\r\n---------------------------------------------------------*/\r\n.Finance{\r\n\twidth: 100%;\r\n\theight: 380px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n.Finance h3{\r\n\tpadding: 15px 20px;\r\n\tcolor: #ddd;\r\n}\r\n.Finance .box{\r\n\twidth: 95%;\r\n    height: 255px;\r\n    border: 1px solid #2b323c;\r\n    margin: 40px auto;\r\n}\r\n.Finance .box .item{\r\n\twidth: 95%;\r\n    height: 181px;\r\n    margin: 35px auto;\r\n    overflow: auto; \r\n}\r\n.Finance .box .item ul li{\r\n\twidth: 30%;\r\n    display: inline-block;\r\n    text-align: center;\r\n    vertical-align: middle;\r\n    margin-left: 10px;\r\n}\r\n.Finance .box .item ul li img{\r\n\tcursor: pointer;\r\n}\r\n.Finance .box .item ul li a span{\r\n\tdisplay: block;\r\n\tcolor: #898f98;\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n}\r\n.Finance .box .item ul li .num-ratio {\r\n\tmargin-top: 10px;\r\n}\r\n.Finance .box .item ul li .num-ratio .num{\r\n\tfont-size: 24px;\r\n\tcolor: #ffffff;\r\n\tdisplay: inline-block;\r\n\tpadding: 0px 10px;\r\n}\r\n.Finance .box .item ul li .num-ratio .ratio{\r\n\tfont-size: 24px;\r\n\tcolor: #e14340;\r\n\tdisplay: inline-block;\r\n\tpadding: 0px 10px;\r\n\tborder-left: solid 1px #48505a;\r\n}\r\n\r\n\r\n\r\n/*@parkMonitor 园区行业分布\r\n---------------------------------------------------------*/\r\n.Park{\r\n\twidth: 100%;\r\n\theight: 380px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n/*@parkMonitor 在营时间分布\r\n---------------------------------------------------------*/\r\n.TheCamp{\r\n\twidth: 100%;\r\n\theight: 320px;\r\n\tmargin-top: 10px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 4px;\r\n}\r\n   ", ""]);

	// exports


/***/ },

/***/ 938:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(936);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//楼宇企业列表
	var BuildCompanyList = _react2.default.createClass({
	    displayName: 'BuildCompanyList',

	    getInitialState: function getInitialState() {
	        return {
	            Enterprise: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var json = { buildingId: 1 };
	        this.getBuildCompanyList(json);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.buildCompanyListResult, this.props.buildCompanyListResult); //判断数据是否变化
	        if (!isEqual) {
	            var buildCompanyListRequest = nextProps.buildCompanyListRequest;
	            var buildCompanyListResult = nextProps.buildCompanyListResult;

	            if (buildCompanyListRequest == true) {
	                if (buildCompanyListResult.success == true) {
	                    this.dataFomat(buildCompanyListResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ Enterprise: content });
	    },
	    getBuildCompanyList: function getBuildCompanyList(json) {
	        var getBuildCompanyList = this.props.getBuildCompanyList;

	        getBuildCompanyList(json);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'Enterprise mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '楼宇企业列表'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'right' },
	                    '1122家'
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
	                        { className: 'mt-table mt-table-center wtyh-table mt-mod' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanA' },
	                                        '公司名'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanB left' },
	                                        '企业背景'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanC left' },
	                                        '行业'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanD left' },
	                                        '注册资本'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanE left' },
	                                        '注册时间'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'spanF left' },
	                                        '企业类型'
	                                    ),
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
	                        { className: 'wtyh-table table-border-b mod-left' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.Enterprise.map(function (elem, index) {
	                                return _react2.default.createElement(
	                                    'tr',
	                                    { key: index },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            _reactRouter.Link,
	                                            { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                            _react2.default.createElement(
	                                                'span',
	                                                null,
	                                                elem.name
	                                            )
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            elem.backgroundCN
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            elem.comTypeCN
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            elem.registeredCapital
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            elem.registeredDate
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            null,
	                                            elem.registeredType
	                                        )
	                                    )
	                                );
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = BuildCompanyList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BuildCompanyList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

	var _CompanyProgress = __webpack_require__(1024);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1025);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1026);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1027);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1028);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1029);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1030);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1031);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1032);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1033);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1034);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1035);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1036);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1037);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1038);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1039);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1040);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1041);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1042);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1043);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1044);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1045);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1046);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1047);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1048);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _CatalogSelect = __webpack_require__(1049);

	var _CatalogSelect2 = _interopRequireDefault(_CatalogSelect);

	var _TimeSelect = __webpack_require__(1050);

	var _TimeSelect2 = _interopRequireDefault(_TimeSelect);

	var _realtimeTableRuducer = __webpack_require__(1051);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1052);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1053);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1054);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1055);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _MenuParkSelectVal = __webpack_require__(1056);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1057);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1058);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1059);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1060);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1061);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ParkImg = __webpack_require__(1062);

	var _ParkImg2 = _interopRequireDefault(_ParkImg);

	var _BuildCompanyList = __webpack_require__(1063);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1064);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1065);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1066);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1067);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1068);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _BuildSwitchVal = __webpack_require__(1069);

	var _BuildSwitchVal2 = _interopRequireDefault(_BuildSwitchVal);

	var _ChartAll3 = __webpack_require__(1070);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1071);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1072);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1073);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1074);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1075);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1076);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1077);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1079);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1080);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1081);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1082);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1083);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1084);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _DynamicRiskCompanyTag = __webpack_require__(1085);

	var _DynamicRiskCompanyTag2 = _interopRequireDefault(_DynamicRiskCompanyTag);

	var _DynamicRiskDate = __webpack_require__(1086);

	var _DynamicRiskDate2 = _interopRequireDefault(_DynamicRiskDate);

	var _DynamicRiskLeftImg = __webpack_require__(1087);

	var _DynamicRiskLeftImg2 = _interopRequireDefault(_DynamicRiskLeftImg);

	var _DynamicRiskRightImg = __webpack_require__(1088);

	var _DynamicRiskRightImg2 = _interopRequireDefault(_DynamicRiskRightImg);

	var _DynamicRiskIndexCmp = __webpack_require__(1089);

	var _DynamicRiskIndexCmp2 = _interopRequireDefault(_DynamicRiskIndexCmp);

	var _SelectDate = __webpack_require__(1393);

	var _SelectDate2 = _interopRequireDefault(_SelectDate);

	var _RiskSearch = __webpack_require__(1090);

	var _RiskSearch2 = _interopRequireDefault(_RiskSearch);

	var _industryTypeChart = __webpack_require__(1091);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1092);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1093);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1094);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/


	/*线下理财监测 end*/

	/*预付卡 begin*/


	//楼宇详情页

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

	//三个echarts图的接口


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
	  BuildSwitchVal: _BuildSwitchVal2.default,
	  ParkImg: _ParkImg2.default,

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

	/*商业保理监测 end*/

	/*线下理财监测 start*/
	//线下理财首页


	/*众筹监测 end*/

	/*商业保理监测 begin*/


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

	//诉讼记录的五个接口

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1393:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = selectDate;

	var _LineFinanceDynamicRiskAction = __webpack_require__(782);

	//初始化数据
	var initialState = {
		data: "" //下拉列表
	}; /*
	   * 动态风险下拉选择框的时间
	   * */


	function selectDate() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? initialState : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceDynamicRiskAction.SELECT_DATE:
				return {
					data: action.data
				};
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SelectDate.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})