webpackHotUpdate(0,{

/***/ 687:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "* {\r\n\tmargin: 0px;\r\n\tpadding: 0px;\r\n}\r\n\r\nul,\r\nli {\r\n\tlist-style: none;\r\n}\r\n\r\na {\r\n\ttext-decoration: none;\r\n}\r\n\r\nhtml {\r\n\t-webkit-text-size-adjust: none;\r\n}\r\n\r\nbody {\r\n\tbackground-color: #1a2029;\r\n\tcolor: #ffffff;\r\n\tfont-family: 'Microsoft Yahei';\r\n}\r\n\r\n.clear:after {\r\n\tcontent: \".\";\r\n\theight: 0;\r\n\tvisibility: hidden;\r\n\tdisplay: block;\r\n\tclear: both;\r\n}\r\n\r\n.cur-pointer {\r\n\tcursor: pointer;\r\n}\r\n\r\n/*头部导航 header begin*/\r\n.header {\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tbackground-color: #383e47;\r\n\toverflow: hidden;\r\n}\r\n\r\n.header .logo {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tline-height: 60px;\r\n\tcolor: #ffffff;\r\n\tfont-size: 20px;\r\n}\r\n\r\n.header .logo .img {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\twidth: 90px;\r\n\theight: 60px;\r\n\tbackground: url(/images/logo.png);\r\n}\r\n\r\n.header .right {\r\n\tfloat: right;\r\n\tmargin-top: 20px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.header .right .name {\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 30px;\r\n\tcursor: pointer;\r\n}\r\n\r\n.list-header {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tpadding: 14px;\t/*text-indent: 30px;*/\r\n}\r\n\r\n.wrap {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\tposition: relative;\r\n\tz-index: 500;\r\n\toverflow: hidden;\r\n\tbackground: #1f253d;\r\n\tbackground-size: cover;\r\n}\r\n\r\n.header .right .name span {\r\n\tmargin-left: 10px;\r\n\tmargin-right: 8px;\r\n\tfont-weight: bold;\r\n}\r\n\r\n.header .right .quit {\r\n\tfont-size: 16px;\r\n\tcolor: #e24643;\r\n}\r\n\r\n/*头部导航 header end*/\r\n.radius4 {\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  begin*/\r\n.menu {\r\n\twidth: 100%;\r\n\theight: 50px;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.menu ul.nav {\r\n\theight: 50px;\r\n\tfloat: left;\r\n}\r\n\r\n.menu ul.nav  li {\r\n\tfloat: left;\r\n\tposition: relative;\r\n}\r\n\r\n.menu ul.nav  li a {\r\n\tcolor: #ffffff;\r\n\tpadding: 0px 30px;\r\n\tline-height: 50px;\r\n}\r\n\r\n.menu ul.nav li a.active:after {\r\n\tcontent: \"\";\r\n\tposition: absolute;\r\n\tleft: 0px;\r\n\tbottom: 0px;\r\n\twidth: 100%;\r\n\theight: 0.2rem;\r\n\tbackground: #e14340;\r\n\tz-index: 0;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav {\r\n\twidth: 96px;\r\n\theight: auto;\r\n\tbackground-color: #545e6d;\r\n\tposition: absolute;\r\n\tleft: 50%;\r\n\ttop: 40px;\r\n\tmargin-left: -50px;\r\n\tz-index: 10;\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.hide {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.show {\r\n\tdisplay: block;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li {\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tfloat: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a {\r\n\tdisplay: block;\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tpadding: 0 0;\r\n\tfont-size: 14px;\r\n\tcolor: #b7b7b7;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a.active:after {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a:hover {\r\n\tbackground-color: #42b8e2;\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.menu .right-park {\r\n\tfloat: right;\r\n\tmargin-top: 12px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.menu .right-park .mt-select {\r\n\tmargin-right: 10px;\r\n}\r\n\r\n.menu .right-park .mt-select-title {\r\n\tbackground-color: #ffffff;\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park .mt-select-box {\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park a {\r\n\tbackground-color: #e14340;\r\n\tcolor: #ffffff;\r\n\tpadding: 4px 10px;\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  end*/\r\n\r\n/*控制边距的类*/\r\n.content-space-10 {\r\n\tmargin: 10px;\r\n}\r\n\r\n.content-space-top-0 {\r\n\tmargin: 0px 10px 10px 10px;\r\n}\r\n\r\n.mod-space-l {\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.mod-space-t {\r\n\tmargin-top: 0.5%;\r\n}\r\n\r\n.mod-space-dl {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.mod-space-dt {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n/*模块公用样式 begin*/\r\n.mod {\r\n\theight: 100%;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.mod .mod-title h3 {\r\n\tdisplay: inline-block;\r\n\tvertical-align: middle;\r\n\tfont-weight: normal;\r\n\tfont-style: normal;\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-left: 10px;\r\n\tpadding: 8px 0;\r\n}\r\n\r\n.mod .mod-title .mod-title-right {\r\n\tfloat: right;\r\n}\r\n\r\n/*模块标题上的下拉选择框 begind*/\r\n.mod .mod-title .mod-title-right .mt-select {\r\n\tcolor: #e5e5e5;\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n\tpadding-left: 5px;\r\n\tpadding-right: 5px;\r\n}\r\n\r\n.mod .mod-title .mod-title-right .mt-select-box {\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n}\r\n\r\n/*模块标题上的下拉选择框 end*/\r\n.mt-select {\r\n\tborder: none !important;\r\n}\r\n\r\n/*模块公用样式 end*/\r\n*:focus {\r\n\toutline: none;\r\n}\r\n\r\n/*表格公用样式*/\r\ntable {\r\n\tborder-collapse: separate;\r\n}\r\n\r\n.wtyh-table thead th {\r\n\tborder-bottom: none;\r\n\tbackground-color: #1a2029;\r\n\tcolor: #dddddd;\r\n\tfont-size: 14px;\r\n\tfont-weight: normal;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.wtyh-table thead tr {\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.wtyh-table tbody td {\r\n\tborder-bottom: none;\r\n\tcolor: #ffffff;\r\n\tfont-size: 14px;\r\n}\r\n.wtyh-table tbody td .word-limit-5{\r\n\tcursor: pointer;\r\n\tcolor: #ffffff;\r\n}\r\n.wtyh-table tbody tr.odd td {\r\n\tbackground: #2b323c;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-line td {\r\n\tbackground: #36404d;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-blackbg-line td {\r\n\tbackground: #222932;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.even td {\r\n\tbackground-color: #1a2029;\r\n}\r\n\r\n.talign-left {\r\n\ttext-align: left !important;\r\n}\r\n\r\n.wtyh-table.table-border-b  tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.talign-right {\r\n\ttext-align: right !important;\r\n}\r\n\r\n.talign-center {\r\n\ttext-align: center !important;\r\n}\r\n\r\n.header-gray {\r\n\theight: 50px;\r\n\tline-height: 50px;\r\n\tbackground: #394351;\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.skublue {\r\n\tcolor: #00b8ee\r\n}\r\n\r\n.orange {\r\n\tcolor: #e14340\r\n}\r\n\r\n/*限制字数五个字*/\r\n.word-limit-5 {\r\n\toverflow: hidden; /*自动隐藏文字*/\r\n\ttext-overflow: ellipsis;/*文字隐藏后添加省略号*/\r\n\twhite-space: nowrap;/*强制不换行*/\r\n\tdisplay: inline-block;\r\n\twidth: 80px;\r\n}\r\n\r\n/*分页样式覆盖*/\r\n.mt-pagelist {\r\n\tmargin-top: 10px !important;\r\n}\r\n\r\n.mt-pagelist ul {\r\n\theight: 30px;\r\n}\r\n\r\n.mt-pagelist .mt-select,\r\n.mt-pagelist .mt-pagelist-first,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-runprev,\r\n.mt-pagelist .mt-pagelist-runnext {\r\n\tdisplay: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-prev,\r\n.mt-pagelist .mt-pagelist-next,\r\n.mt-pagelist .mt-pagelist-btn,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-first {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-input .mt-input {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a {\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n\tline-height: 26px !important;\r\n\tborder-radius: 2px !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li.on a {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-btn:hover,\r\n.mt-pagelist .mt-pagelist-prev:hover,\r\n.mt-pagelist .mt-pagelist-next:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n/*搜索框*/\r\n.mt-input .mt-iconbtn,\r\n.mt-input-block .mt-iconbtn a {\r\n\tcursor: pointer !important;\r\n}\r\n\r\n/*颜色*/\r\n.c-red {\r\n\tcolor: #e14340;\r\n}\r\n\r\n/*联想词*/\r\n.ac_results {\r\n\tpadding: 0;\r\n\toverflow: auto;\r\n\tz-index: 99999;\r\n\tmax-height: 200px;\r\n\tbackground: rgba(17, 38, 67, 0.9);\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results ul {\r\n\twidth: 100%;\r\n\tlist-style: none;\r\n\tpadding: 0;\r\n\tmargin: 0;\r\n}\r\n\r\n.ac_results ul li:last-child {\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results li {\r\n\tpadding: 5px 10px;\r\n\tdisplay: block;\r\n\tfont-size: 14px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.ac_results .group-item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.ac_results ul .group-item:hover {\r\n\tbackground: #063a5f;\r\n}\r\n\r\n.ac_results .group {\r\n\tcolor: #666;\r\n}\r\n\r\n.ac_results i {\r\n\tfont-size: 12px;\r\n\tcolor: #999;\r\n\tpadding-left: 1em;\r\n}\r\n\r\n.ac_results .strong {\r\n\tcolor: #13b7fe;\r\n}\r\n\r\n.ac-results ul li.group:hover {\r\n\tcursor: default;\r\n\tbackground-color: #172837;\r\n\tcolor: #666;\r\n}\r\n\r\n.iconfont.icon-desc {\r\n\tcursor: pointer;\r\n}\r\n\r\n", ""]);

	// exports


/***/ },

/***/ 741:
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
	                }
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
	                    console.log(data, '33333333333');
	                    if (param.formatter == "BusinessNum") {
	                        //典当总额业务笔数
	                        return data.name + ' 年<br/> 典当总额：&nbsp <span style="color:#00b7f0">' + data.data[3] + '亿元</span><br/>业务笔数：&nbsp  <span style="color:#00b7f0">' + data.data[2] + '</span>';
	                    } else {
	                        return data.name + ' 年<br/> ' + param.forMaterTitle + "：" + data.data[2] + '亿元<br/>' + param.forMaterTip + "：" + data.data[3] + "亿元";
	                    }
	                }
	            },
	            grid: {
	                top: param.gridTop || '10%',
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
	                type: param.yType || 'category',
	                name: param.yAxisName == undefined ? "" : param.yAxisName,
	                boundaryGap: ["10%", "10%"],
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
	                    console.log(val[3], '第四个值');
	                    if (val[3] < 1000) {
	                        return val[3] / 10;
	                    } else if (val[3] > 1000 && val[3] < 10000) {
	                        return val[3] / 1000;
	                    } else if (10000 < val[3] && val[3] < 100000) {
	                        return val[3] / 5000;
	                    } else if (100000 < val[3] && val[3] < 1000000) {
	                        return val[3] / 10000;
	                    } else if (1000000 < val[3] && val[3] < 10000000) {
	                        return val[3] / 80000;
	                    } else {
	                        return val[3] / 1000000;
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

	//静态风险指数
	var LineFinanceStaticRisk = _react2.default.createClass({
	  displayName: 'LineFinanceStaticRisk',
	  getInitialState: function getInitialState() {
	    return {
	      companyName: this.props.location.query.companyName
	    };
	  },

	  componentWillMount: function componentWillMount() {},
	  componentDidMount: function componentDidMount() {
	    $(".risk-search-header .search-bar .right a").first().addClass('active');
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-static-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, { companyName: this.state.companyName }),
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

/***/ 752:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".risk-search-header{\r\n\t\r\n}\r\n.risk-search-header .search-bar{\r\n\tbackground-color: #212831;\r\n\theight: 50px;\r\n\tline-height: 50px;\r\n\tpadding-left:20px;\r\n\toverflow: hidden;\r\n}\r\n.risk-search-header .search-bar .left{\r\n\tfloat: left;\r\n}\r\n.risk-search-header .search-bar .left a{\r\n\tcolor:#272436;\r\n}\r\n.risk-search-header .search-bar .right{\r\n\tfloat: right;\r\n}\r\n.risk-search-header .search-bar .company-name{\r\n\tcolor: #ffffff;\r\n\tfont-size: 16px;\r\n\tdisplay: inline-block;\r\n}\r\n.risk-search-header .search-bar .company-info{\r\n\tdisplay: inline-block;\r\n\tmargin-left: 20px;\r\n}\r\n.risk-search-header .search-bar .company-info span{\r\n\tpadding: 2px 5px;\r\n\tfont-size: 12px;\r\n\tmargin: 0 5px;\r\n}\r\n.risk-search-header .search-bar .company-info span.bg-blue{\r\n\tbackground-color: #00b7ee;\r\n}\r\n.risk-search-header .search-bar .company-info span.bg-yellow{\r\n\tbackground-color: #f98d2b;\r\n}\r\n.risk-search-header .search-bar .company-info span.bg-red{\r\n\tbackground-color: #e14340;\r\n}\r\n.risk-search-header .search-bar .export-report{\r\n\tbackground-color: #e5e5e5;\r\n\tborder-radius: 2px;\r\n\tpadding: 2px 5px;\r\n\tfont-size: 12px;\r\n\tmargin-left: 40px;\r\n}\r\n.risk-search-header .search-bar .export-report i{\r\n\tmargin-right: 2px;\r\n}\r\n.risk-search-header .search-bar .right{\r\n\r\n}\r\n.risk-search-header .search-bar .right a{\r\n\tdisplay: inline-block;\r\n\theight: 100%;\r\n\tfont-size: 16px;\r\n\tpadding: 0 10px;\r\n\tcolor: #999999;\r\n}\r\n.risk-search-header .search-bar .right a i{\r\n\tmargin-right: 5px;\r\n}\r\n.risk-search-header .search-bar .right a.active{\r\n\tbackground-color: #1a2029;\r\n\tcolor: #ffffff;\r\n}\r\n.risk-search-header .search-bar .right a.active i{\r\n\tcolor: #e14340;\r\n}", ""]);

	// exports


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
	            searchVal: '',
	            companyName: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        this.queryDynamicPic(1, companyName);
	    },
	    queryDynamicPic: function queryDynamicPic(param, companyName, ev) {
	        $(".btns .btn").removeClass('active');
	        $(".btns .btn").eq(param - 1).addClass('active');
	        var queryDynamicPic = this.props.queryDynamicPic;

	        queryDynamicPic({
	            "companyName": companyName,
	            "dataVersion": "20160530",
	            "degree": param
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
	                                { className: 'btn active', onClick: this.queryDynamicPic.bind(this, 1, this.state.companyName) },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 2, this.state.companyName) },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 3, this.state.companyName) },
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

/***/ 756:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*关联图模块 begin*/\r\n.linefin-rel-graph {\r\n\theight: 1300px;\r\n}\r\n\r\n.linefin-rel-graph .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-rel-graph .mod-title h3 {\r\n}\r\n\r\n.linefin-rel-graph .mod-title .mod-title-right {\r\n\tmargin-top: 5px;\r\n\tdisplay: inline-block;\r\n\tfloat: right;\r\n}\r\n\r\n.linefin-rel-graph .mod-title-right i.icon-fullscreen {\r\n\tmargin-left: 20px;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 6px;\r\n\tfloat: right;\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-rel-graph .mod-content {\r\n\tposition: relative;\r\n}\r\n\r\n.linefin-rel-graph .mod-content .relation-graph-box {\r\n\theight: 1200px;\r\n}\r\n\r\n/*关联图模块 end*/\r\n\r\n/*公司舆情 begin*/\r\n.linefin-cocompose {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.linefin-cocompose .mod-title {\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-cocompose .mod-content {\r\n\theight: 550px;\r\n}\r\n\r\n.linefin-cocompose .content-box {\r\n\theight: 534px;\r\n\toverflow: auto;\r\n\tmargin: 20px 20px 0px 20px;\r\n\tbackground-color: #212831;\r\n\tpadding: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box {\r\n\toverflow: hidden;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 a {\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 em {\r\n\tdisplay: inline-block;\r\n\ttext-align: center;\r\n\twidth: 24px;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\tborder-radius: 2px;\r\n\tbackground-color: #1a2029;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box p {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tmargin-left: 45px;\r\n\ttext-indent: 28px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tfloat: right;\r\n\tcolor: #e14340;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source .name {\r\n\tmargin-right: 40px;\r\n}\r\n\r\n/**公司舆情 end*/\r\n\r\n/*静态风险指数构成 begin*/\r\n.linefin-index-constitute .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-index-constitute .mt-select {\r\n\tmargin-top: 5px;\r\n\tmargin-right: 5px;\r\n\tcolor: #c9c9ca;\r\n}\r\n\r\n.linefin-index-constitute .con-box {\r\n\tbackground-color: #2b323c;\r\n\tpadding: 0 20px;\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-info {\r\n\tmin-height: 1362px;\r\n\t\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-pie {\r\n\theight: 520px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-head {\r\n\tbackground-color: #1a2029;\r\n\tborder-bottom: solid 1px #2b323c;\r\n\theight: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tfont-size: 14px;\r\n\theight: 20px;\r\n\tline-height: 20px;\r\n\tmargin-top: 10px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.name {\r\n\tcolor: #e5e5e5;\r\n\twidth: 40%;\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.num {\r\n\twidth: 60%;\r\n\ttext-indent: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head {\r\n\theight: 60px;\r\n\tbackground-color: #e14340;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span {\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.name {\r\n\tfont-size: 18px;\r\n\tborder-color: #ed8e8c;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.num em {\r\n\tfont-size: 36px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-other .item-head span.num i {\r\n\tfloat: right;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 3px;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table {\r\n\twidth: 100%;\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table {\r\n\twidth: 100%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td {\r\n\tborder-bottom: solid 1px #2b323c;\r\n\tpadding: 10px 0;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-left {\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-right {\r\n\tpadding-left: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart {\r\n\theight: 330px;\r\n\tbackground-color: #212831;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart h4 {\r\n\tbackground-color: #1a2029;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tpadding: 0 20px;\r\n\tfont-size: 16px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart .chart-b {\r\n\theight: 290px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-head span.name {\r\n\tfont-size: 16px;\r\n\tborder-color: #d0d8df;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-con {\r\n\tdisplay: none;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-con {\r\n\tdisplay: block;\r\n}\r\n\r\n/*关联图 图例 begin*/\r\n.relation-legend {\r\n\tmargin: 25px 0 15px 10px;\r\n\twidth: 99%;\r\n\theight: 56px;\r\n}\r\n\r\n.relation-legend table {\r\n\tbackground: #1a2029;\r\n\twidth: 80%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.relation-legend table tr {\r\n\theight: 50%;\r\n\twidth: 10%;\r\n}\r\n\r\n.relation-legend table tr td {\r\n\tpadding: 8px 0 0 14px;\r\n\tposition: relative;\r\n\twidth: 19.8%;\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.relation-legend table tr span {\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.relation-legend table tr .item-lable {\r\n\tfont-size: 12px;\r\n\tcolor: #b2b2b2;\r\n\tposition: absolute;\r\n}\r\n\r\n.relation-legend table tr img {\r\n\tmargin: -5px 20px 0 0;\r\n}\r\n\r\n.relation-legend table tr .square {\r\n\twidth: 17px;\r\n\theight: 17px;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.relation-legend table tr .round {\r\n\twidth: 17px;\r\n\theight: 17px;\r\n\tmargin-right: 20px;\r\n\tborder-radius: 100px;\r\n}\r\n\r\n.relation-legend table tr .orange {\r\n\tbackground: #f44603;\r\n}\r\n\r\n.relation-legend table tr .orange-two {\r\n\tbackground: #f98d2b;\r\n}\r\n\r\n.relation-legend table tr .blue {\r\n\tbackground: #046adb;\r\n}\r\n\r\n.relation-legend table tr .yellow {\r\n\tbackground: #ffdb03;\r\n}\r\n\r\n.relation-legend table tr .green {\r\n\tbackground: #73d528;\r\n}\r\n\r\n.relation-legend .condition {\r\n\twidth: 19.6%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n\tmargin-left: 2px;\r\n\tbackground: #212831;\r\n}\r\n\r\n.relation-legend .condition .lable {\r\n\tfont-size: 12px;\r\n\tcolor: #fff;\r\n\twidth: 100%;\r\n\theight: 50%;\r\n\tpadding-top: 8px;\r\n\tline-height: 100%;\r\n\ttext-align: center;\r\n}\r\n\r\n.relation-legend .condition .btns {\r\n\twidth: 100%;\r\n\theight: 50%;\r\n}\r\n\r\n.relation-legend .condition .btns .btn {\r\n\tbackground: #474f5c;\r\n\tfloat: left;\r\n\twidth: 32.5%;\r\n\theight: 100%;\r\n\tmargin-left: 1px;\r\n\ttext-align: center;\r\n\tpadding-top: 5px;\r\n\tcursor: pointer;\r\n}\r\n\r\n.relation-legend .condition .btns .btn.active {\r\n\tbackground-color: #00b8ee;\r\n}\r\n\r\n.relation-modal {\r\n\tposition: absolute;\r\n\tleft: 10px;\r\n\ttop: 100px;\r\n\twidth: 270px;\r\n\tpadding-bottom: 5px;\r\n\tborder-radius: 5px;\r\n\tbackground: #222931;\r\n\tz-index: 99999;\r\n\t-webkit-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n\t-moz-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n\tbox-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n}\r\n\r\n.relation-modal .company-title {\r\n\twidth: 100%;\r\n\theight: 30px;\r\n\tline-height: 30px;\r\n\tpadding-left: 5%;\r\n\tbackground: #4B5668;\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.relation-modal table {\r\n\twidth: 100%;\r\n}\r\n\r\n.relation-modal table tr {\r\n\twidth: 100%;\r\n}\r\n\r\n.relation-modal table tr td {\r\n\theight: 27px;\r\n\tline-height: 27px;\r\n\tfont-size: 12px;\r\n}\r\n\r\n.relation-modal table tr td:first-child {\r\n\twidth: 60%;\r\n\tcolor: #878E96;\r\n\tpadding-left: 5%;\r\n}\r\n\r\n.relation-modal table tr td:last-child {\r\n\twidth: 40%;\r\n}\r\n\r\n.relation-modal .see-detail {\r\n\tfont-size: 12px;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\tcolor: #ffffff;\r\n\ttext-align: center;\r\n\tdisplay: block;\r\n\tborder-radius: 5px;\r\n\tbackground-color: #e14340;\r\n\tmargin-top: 10px;\r\n\tmargin-bottom: 10px;\r\n\tmargin-left: 10px;\r\n\tmargin-right: 10px;\r\n}\r\n\r\n/*关联图 图例 end*/\r\n\r\n/*关联图 侧边栏begin*/\r\n.sidebox {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation-tips {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .sidebar {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .canvas {\r\n\tmargin-right: auto !important;\r\n}\r\n\r\n.correlation .time-line {\r\n\tdisplay: none;\r\n}\r\n\r\n/*关联图 end*/\r\n\r\n/*静态风险指数构成 end*/", ""]);

	// exports


/***/ },

/***/ 757:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//公司舆情
	var LineFinanceCoCompose = _react2.default.createClass({
	    displayName: 'LineFinanceCoCompose',

	    getInitialState: function getInitialState() {
	        return {
	            listData: "",
	            companyName: ""
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var companyNewsIsEqual = Immutable.is(nextProps.companyNewsRequest, this.props.companyNewsRequest);
	        if (!companyNewsIsEqual) {
	            var dataList = nextProps.companyNewsResult.content ? eval("(" + nextProps.companyNewsResult.content + ")") : "";
	            this.setState({
	                listData: dataList.results
	            });
	        }
	    },

	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });
	        this.requestCompanyNews(companyName);
	    },
	    requestCompanyNews: function requestCompanyNews(companyName) {
	        //请求公司舆情
	        var companyNews = this.props.companyNews;

	        companyNews({ companyName: companyName });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-cocompose mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '公司舆情'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-box' },
	                    _react2.default.createElement(
	                        'ul',
	                        null,
	                        this.state.listData ? this.state.listData.map(function (item, index) {
	                            return _react2.default.createElement(
	                                'li',
	                                { key: index },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'list-box' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        { className: 'title' },
	                                        _react2.default.createElement(
	                                            'a',
	                                            { href: item.bbd_source },
	                                            _react2.default.createElement(
	                                                'em',
	                                                null,
	                                                index + 1
	                                            ),
	                                            item.news_title
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'p',
	                                        { className: 'abstract' },
	                                        item.search_key
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'source' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'name' },
	                                            item.news_site
	                                        ),
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'date' },
	                                            item.pubdate
	                                        )
	                                    )
	                                )
	                            );
	                        }) : ""
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceCoCompose;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceCoCompose.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 758:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//静态风险指数构成
	var LineFinanceIndexConstitute = _react2.default.createClass({
	    displayName: 'LineFinanceIndexConstitute',

	    getInitialState: function getInitialState() {
	        return {
	            statisticsDate: [],
	            riskIndex: [],
	            avgRiskIndex: [],
	            riskList: "",
	            allDate: "",
	            companyName: "",
	            pieOption: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });

	        //请求时间列表
	        var jsonDataDate = { companyName: companyName };
	        this.queryDateVersion(jsonDataDate);

	        //请求右面折线图      
	        var jsonDataLine = { companyName: companyName, areaCode: "金山区" };
	        this.staticRiskIndex(jsonDataLine);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.riskDataResult, this.props.riskDataResult);
	        if (!isEqual) {
	            //右边饼图数据
	            this.setState({
	                riskList: nextProps.riskDataResult.content
	            });
	            this.setParm(nextProps.riskDataResult.content);
	        }
	        var _allDate = [];
	        var queryDateVersionIsEqual = Immutable.is(nextProps.queryDateVersionRequest, this.props.queryDateVersionRequest);
	        if (!queryDateVersionIsEqual) {
	            //右边时间列表
	            nextProps.queryDateVersionResult.content.map(function (item, index) {
	                _allDate.push({
	                    value: index + 1,
	                    label: item
	                });
	            });
	            this.setState({
	                allDate: _allDate
	            });
	            this.queryRiskData(_allDate[0].label); //首次获取时间请求列表
	        }

	        var statisticsIsEqual = Immutable.is(nextProps.statisticsRequest, this.props.statisticsRequest);
	        if (!statisticsIsEqual) {
	            this.setState({
	                lineOption: nextProps.statisticsResult
	            });
	        }
	    },
	    queryRiskData: function queryRiskData(currentDate) {
	        //获取列表数据
	        var jsonData = { companyName: this.state.companyName, currentDate: currentDate };
	        var queryRiskData = this.props.queryRiskData;

	        queryRiskData(jsonData);
	    },
	    queryDateVersion: function queryDateVersion(jsonData) {
	        //获取日期
	        var queryDateVersion = this.props.queryDateVersion;

	        queryDateVersion(jsonData);
	    },
	    staticRiskIndex: function staticRiskIndex(jsonDataLine) {
	        //请求右面折线图         
	        var queryStatistics = this.props.queryStatistics;var self = this;
	        queryStatistics(jsonDataLine);
	    },

	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        var isFirstItem = $itemParent.hasClass('item-first');
	        if (isTrue) {
	            if (!isFirstItem) {
	                $itemParent.removeClass('active');
	                $(this.refs.itemFirst).addClass('active');
	                $itemParent.find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	        } else {
	            if (!isFirstItem) {
	                $itemParent.find('.item-head .num i').removeClass('icon-xdown').addClass('icon-xup');
	                $(this.refs.itemFirst).removeClass('active');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	            $itemParent.addClass('active');
	        }
	    },
	    setParm: function setParm(itemTable) {
	        //渲染右边饼图
	        var option = {
	            "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	            "title": "",
	            "xtitle": "",
	            "legend": [""],
	            "legendShow": false,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "20%",
	            "seriesName": "静态风险指数构成",
	            "radius": "40%",
	            "lable": { normal: { show: true },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '50%'],
	            "series": [{
	                "name": "非法融资违规风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "人才结构风险",
	                "value": itemTable && itemTable.perStructRisk
	            }, {
	                "name": "实际控制人风险",
	                "value": itemTable && itemTable.realConRisk
	            }, {
	                "name": "公司扩张路径风险",
	                "value": itemTable && itemTable.comExpRisk
	            }, {
	                "name": "关联方中心集聚化风险",
	                "value": itemTable && itemTable.relInRisk
	            }, {
	                "name": "非法融资衍生风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "短期逐利风险",
	                "value": itemTable && itemTable.comExpRisk
	            }]
	        };
	        this.setState({ pieOption: option });
	    },
	    setLineParm: function setLineParm(param) {
	        var _xAxisArr = [],
	            _riskIndexArr = [],
	            _avgRiskIndexArr = [];
	        this.state.lineOption[param].map(function (item) {
	            _xAxisArr.push(item.date);
	        });
	        this.state.lineOption[param].map(function (item) {
	            _riskIndexArr.push(item.riskIndex);
	            _avgRiskIndexArr.push(item.avgRiskIndex);
	        });
	        var option = {
	            color: ["#00b7ee", "#f8b551"],
	            bgColor: "",
	            title: "实际控制人风险趋势",
	            titleX: "left", //
	            boxId: "chartMap",
	            symbolSize: 10,
	            legendIsShow: true,
	            yFlag: "",
	            yAxisName: "",
	            legendRight: "30",
	            legend: ["公司", "行业平均"],
	            xAxis: _xAxisArr,
	            series: [_riskIndexArr, _avgRiskIndexArr]
	        };
	        return option;
	    },
	    render: function render() {
	        var self = this;
	        var selectProp = { //渲染右边时间选择        
	            width: '85px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: this.state.allDate ? this.state.allDate[0].label : '',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: this.state.allDate,
	            onChange: function onChange(val) {
	                self.state.allDate.map(function (item) {
	                    if (item.value == val) {
	                        var queryRiskData = self.props.queryRiskData;

	                        queryRiskData({ companyName: self.state.companyName, currentDate: item.label });
	                    }
	                });
	            }
	        };
	        var itemTable = this.state.riskList || '';
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-constitute mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '静态风险指数构成'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right sd' },
	                    this.state.allDate ? _react2.default.createElement(_index.Selected, selectProp) : ''
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
	                        { className: 'index-con-pie' },
	                        this.state.pieOption ? _react2.default.createElement(_BasePie2.default, { option: this.state.pieOption, style: { height: '520px', width: '100%' } }) : ''
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-info clear' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-first active', ref: 'itemFirst' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '静态风险指数'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        null,
	                                        '51.2'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '静态风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex0'), style: { height: '290px', width: '100%' } }) : ""
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '实际控制人风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.realConRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '单个一度关联自然人最大控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.maxComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '平均每位一度关联自然人控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.avgPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心一度关联自然人'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneLvlPer
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '实际控制人风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex1'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '公司扩张风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.comExpRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司自然人股东数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldComConPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司企业法人数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldCtlNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreCldCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '公司扩张风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex2'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联方中心积聚化风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.relInRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.ctlCldComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '一度关联企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.conCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '关联方中心积聚化风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex3'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融盗衍生风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illFinRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '三度关联自然人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.thrPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '二度关联企业法人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.twoComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心二度关联公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreTwoCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融盗衍生风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex4'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '短期逐利风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.shortRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月~1年以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立的公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '短期逐利风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex5'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融资违规风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illMoneyFinRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '投资类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.investment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '咨询类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '贸易类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '租赁类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.lease
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '保理类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.factoring
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '公司名单'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.companyList
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融资违规风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex6'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '人才结构风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
	                                    ),
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
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.underNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '硕士以上人次（包括硕士）'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科以下人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '人才结构风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex7'), style: { height: '290px', width: '510px' } }) : ''
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
	module.exports = LineFinanceIndexConstitute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceIndexConstitute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 759:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDBasePie = _react2.default.createClass({
	  displayName: "BBDBasePie",

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
	    var option = {
	      color: parm.color,
	      title: {
	        text: parm.title,
	        x: parm.xtitle,
	        left: parm.titleLeft == undefined ? "auto" : parm.titleLeft,
	        top: parm.titleTop == undefined ? "auto" : parm.titleTop,
	        bottom: parm.titleBottom == undefined ? "auto" : parm.titleBottom,
	        textStyle: {
	          color: "#fff",
	          fontSize: 14,
	          fontWeight: parm.titleWeight || "normal",
	          fontFamily: 'Microsoft Yahei'
	        }
	      },
	      tooltip: {
	        trigger: 'item',
	        backgroundColor: 'rgba(0,0,0,0.7)',
	        padding: [10, 10, 10, 10],
	        formatter: function formatter(v) {
	          var _until = "";
	          if (parm.flag == "balanceDistri") {
	            return v.name + "<br/>" + v.seriesName + "<span style='color:#00b7f0'>" + v.value + _until + "亿元(" + v.percent + "%)" + "</span>";
	          } else {
	            if (parm.unit == undefined) {
	              _until = "";
	            } else {
	              _until = parm.unit;
	            }
	            return v.name + ":&nbsp;<span style='color:#00b7f0'>" + v.value + _until + "(" + v.percent + "%)" + "</span>";
	          }
	        }
	      },
	      legend: {
	        show: parm.legendShow,
	        orient: parm.legendOrient == undefined ? "vertical" : parm.legendOrient,
	        left: parm.legendLeft == undefined ? "auto" : parm.legendLeft,
	        top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	        right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	        bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	        itemGap: parm.legendItemGap || 10,
	        data: parm.legend,
	        textStyle: {
	          color: "#e6e6e6",
	          fontSize: 12,
	          fontWeight: "normal",
	          fontFamily: 'Microsoft Yahei'
	        }
	      },
	      series: [{
	        name: parm.seriesName,
	        type: 'pie',
	        avoidLabelOverlap: false,
	        selectedOffset: "5",
	        roseType: parm.roseType == undefined ? false : parm.roseType,
	        radius: parm.radius,
	        center: parm.center,
	        label: parm.lable,
	        labelLine: parm.labelLine == undefined ? {} : parm.labelLine,
	        data: parm.series,
	        itemStyle: {
	          emphasis: {
	            shadowBlur: 10,
	            shadowOffsetX: 0,
	            shadowColor: 'rgba(0, 0, 0, 0.5)'
	          }
	        }
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
	    return _react2.default.createElement("div", { ref: "echartsDom", style: style });
	  }
	});
	exports.default = BBDBasePie;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BasePie.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 783:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(784);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _FinanceGuaraIndexAction = __webpack_require__(786);

	var finGuaraActionCreaters = _interopRequireWildcard(_FinanceGuaraIndexAction);

	var _index = __webpack_require__(692);

	var _setMinHeight = __webpack_require__(731);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _FinanceGuaraCompanyGrade = __webpack_require__(787);

	var _FinanceGuaraCompanyGrade2 = _interopRequireDefault(_FinanceGuaraCompanyGrade);

	var _FinanceGuaraMap = __webpack_require__(790);

	var _FinanceGuaraMap2 = _interopRequireDefault(_FinanceGuaraMap);

	var _BalanceDistribute = __webpack_require__(793);

	var _BalanceDistribute2 = _interopRequireDefault(_BalanceDistribute);

	var _GuaraEachAverage = __webpack_require__(794);

	var _GuaraEachAverage2 = _interopRequireDefault(_GuaraEachAverage);

	var _GuaraDutyBalance = __webpack_require__(795);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinanceGuaraIndustryRisk = __webpack_require__(796);

	var _FinanceGuaraIndustryRisk2 = _interopRequireDefault(_FinanceGuaraIndustryRisk);

	var _LargeGuara = __webpack_require__(798);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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
	            var amount = content[i].amount; //贷款余额
	            var number = content[i].number; //笔数
	            var companyAmount = content[i].number; //公司数量
	            var averageBlance = Number(amount / companyAmount).toFixed(2); //平均担保责任余额
	            console.log(averageBlance, '333333333333');
	            var dataArr = [i, i, amount, averageBlance];

	            balanceArr.push(amount);
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

	        this.setState({ guaraDutyBalaData: guaraDutyBalaData, guaraEachAverData: guaraEachAverData, balanceDistrData: balanceDistrData });
	    },
	    searchFun: function searchFun(e) {
	        this.props.history.push('/SearchResultDetail?companyName=' + e);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'finance-guara-index content-space-10', style: this.state.style },
	            _react2.default.createElement(
	                'div',
	                { className: 'search-box' },
	                _react2.default.createElement(_IndustrySearch2.default, { label: '融资担保监测', companyType: '3', searchFun: this.searchFun, className: 'small-loan-search', placeholder: '请输入企业名称检索' })
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

	        //股东行业风险
	        finGuaIndustryRiskDetailRequest: state.FinGuaIndustryRiskDetail.request,
	        finGuaIndustryRiskDetailResult: state.FinGuaIndustryRiskDetail.result,

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

/***/ 786:
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
	exports.getFinGuaIndustryRiskDetail = getFinGuaIndustryRiskDetail;
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
	/*股东行业风险详情 begin*/
	var FINGUA_INDUSTRYRISK_DET_SUCCESS = exports.FINGUA_INDUSTRYRISK_DET_SUCCESS = 'FINGUA_INDUSTRYRISK_DET_SUCCESS';
	var FINGUA_INDUSTRYRISK_DET_FAIL = exports.FINGUA_INDUSTRYRISK_DET_FAIL = 'FINGUA_INDUSTRYRISK_DET_FAIL';

	function finGuaIndustryRiskDetSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: FINGUA_INDUSTRYRISK_DET_SUCCESS,
	    result: result
	  };
	}

	function finGuaIndustryRiskDetFail(result) {
	  //请求失败调用方法
	  return {
	    type: FINGUA_INDUSTRYRISK_DET_FAIL,
	    result: result
	  };
	}

	function getFinGuaIndustryRiskDetail(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/guarantee/shareholderRiskDetail.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(finGuaIndustryRiskDetSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(finGuaIndustryRiskDetFail(result));
	      }
	    });
	  };
	}
	/*股东行业风险详情  end*/

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

/***/ 787:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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
	        $('#financeGuara-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#financeGuara-scroll').perfectScrollbar('update');
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
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ companyGradeList: content });
	    },
	    getCompanyGrade: function getCompanyGrade(jsonData) {
	        var getFinGuaCompanyGrade = this.props.getFinGuaCompanyGrade; // 取到props里面的getFinGuaCompanyGrade方法。也可以说是请求action

	        getFinGuaCompanyGrade(jsonData);
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
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 1) },
	                                    '外部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 2) },
	                                    '内部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 3) },
	                                    '现场检查',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'financeGuara-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.companyGradeList.map(function (elem, index) {
	                                var _innerLevel = elem.innerLevel == undefined ? "/" : elem.innerLevel;
	                                var _outLevel = elem.outLevel == undefined ? "/" : elem.outLevel;
	                                var _liveLevel = elem.liveLevel == undefined ? "/" : elem.liveLevel;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _liveLevel
	                                        )
	                                    );
	                                }{
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _liveLevel
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

/***/ 789:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".finance-guara-index .mt-table {\r\n\tmargin: 0px !important;\r\n}\r\n\r\n/*企业评级*/\r\n.finance-guara-index .company-grade .mod-content .table-content {\r\n\theight: 530px;\r\n\toverflow: auto;\r\n}\r\n\r\n/*担保责任余额结构分布*/\r\n.finance-guara-index .balance-distribute {\r\n\theight: 49.5%;\r\n}\r\n\r\n.finance-guara-index .balance-distribute .chart-box {\r\n\theight: 272px;\r\n}\r\n\r\n/*担保笔均折线图*/\r\n.finance-guara-index .each-average {\r\n\theight: 49.5%;\r\n\tmargin-top: 2%;\r\n}\r\n\r\n.finance-guara-index .each-average .chart-box {\r\n\theight: 272px;\r\n}\r\n\r\n/*地图模块*/\r\n.finance-guara-index .finance-guara-map .map-chart-box {\r\n\theight: 610px;\r\n\tposition: relative;\r\n}\r\n\r\n.finance-guara-index .mod-content {\r\n\tposition: relative;\r\n}\r\n\r\n.finance-guara-index .finance-guara-map .company-chart-box {\r\n\twidth: 200px;\r\n\theight: 200px;\r\n\tposition: absolute;\r\n\tleft: 0px;\r\n\ttop: 0px;\r\n}\r\n\r\n.finance-guara-index .finance-guara-map .visual-text {\r\n\tposition: absolute;\r\n\tbottom: 26%;\r\n\tright: 3%;\r\n\tz-index: 1000;\r\n\twidth: 14px;\r\n}\r\n\r\n/*贷款余额占比*/\r\n.finance-guara-index .loan-balance .chart-box {\r\n\theight: 300px;\r\n}\r\n\r\n/*股东行业风险*/\r\n.finance-guara-index .industry-risk .mod-content .table-content {\r\n\theight: 240px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.finance-guara-index .industry-risk .mod-content .table-content table td a.more {\r\n\tcolor: #e14340;\r\n}\r\n\r\n/*大额借款人信息列表*/\r\n\r\n/*股东风险更多*/\r\n.finance-guara-index .industry-risk-more {\r\n\tbackground-color: #254155;\r\n\twidth: 480px;\r\n\theight: 260px;\r\n\tposition: fixed;\r\n\tleft: 0px;\r\n\ttop: 0px;\r\n\tz-index: 100;\r\n\tborder: solid 1px #040506;\r\n\tborder-radius: 5px;\r\n\tdisplay: none;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .title {\r\n\tborder-bottom: solid 1px #000000;\r\n\tpadding: 10px 20px;\r\n\tposition: relative;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .title span {\r\n\tdisplay: inline-block;\r\n\ttext-align: center;\r\n\twidth: 33%;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .title i {\r\n\tposition: absolute;\r\n\tright: 0px;\r\n\ttop: -1px;\r\n\tfont-size: 20px;\r\n\tcolor: #ffffff;\r\n\tcursor: pointer;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .content {\r\n\tpadding: 8px 10px;\r\n\toverflow: hidden;\r\n\theight: 215px;\r\n\tposition: relative;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .content ul {\r\n\tdisplay: inline-block;\r\n\twidth: 33.33%;\r\n}\r\n\r\n.finance-guara-index .industry-risk-more .content ul li {\r\n\tpadding: 15px 5px;\r\n\tfont-size: 14px;\r\n}", ""]);

	// exports


/***/ },

/***/ 793:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//担保责任余额结构分布
	var BalanceDistribute = _react2.default.createClass({
	    displayName: 'BalanceDistribute',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.balanceDistrData, this.props.balanceDistrData);
	        console.log(isEqual);
	        if (!isEqual) {
	            var balanceDistrData = nextProps.balanceDistrData;

	            this.dataFomat(balanceDistrData);
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var option = {
	            "color": ["#6c9f87", "#e14340", "#efd79b"],
	            "title": "",
	            "xtitle": "",
	            "legend": ["政策性", "综合型", "钢贸类"],
	            "legendShow": true,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "10%",
	            "seriesName": "",
	            "flag": "balanceDistri",
	            "radius": "70%",
	            "lable": { normal: { show: false },
	                emphasis: { show: false }
	            },
	            "center": ['40%', '50%'],
	            "series": data
	        };
	        this.setState({ option: option });
	    },
	    //   setParm:function(){
	    //   const option ={
	    //         "color":["#6c9f87", "#e14340","#61a0a8"],
	    //         "title":"",
	    //         "xtitle":"",
	    //         "legend": ["政策性", "综合型","钢贸类"],
	    //         "legendShow":true,
	    //         "legendOrient":"vertical",
	    //         "legendLeft":"",
	    //         "legendTop":"middle",
	    //         "legendRight":"10%",
	    //         "seriesName":"担保责任余额结构分布",
	    //         "radius":"70%",
	    //         "lable":{ normal: { show:false},
	    //                   emphasis: {show:false}
	    //               },
	    //         "center":['40%', '50%'],
	    //         "series": [
	    //                 {value:500, name:'政策性'},
	    //                 {value:800, name:'综合型'},
	    //                 {value:400, name:'钢贸类'}
	    //             ]
	    //     };
	    //         return option;
	    // },
	    render: function render() {
	        var bbdPie = "";
	        if (this.state.option) {
	            bbdPie = _react2.default.createElement(_BasePie2.default, { option: this.state.option, style: { height: '272px', width: '100%' } });
	        }
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
	                    bbdPie
	                )
	            )
	        );
	    }
	});
	module.exports = BalanceDistribute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BalanceDistribute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 795:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _ScatterChart = __webpack_require__(741);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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
	    console.log(data, '担保责任余额');
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

/***/ 796:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	var _IndustryRiskMore = __webpack_require__(797);

	var _IndustryRiskMore2 = _interopRequireDefault(_IndustryRiskMore);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//股东行业风险
	var FinanceGuaraIndustryRisk = _react2.default.createClass({
	    displayName: 'FinanceGuaraIndustryRisk',

	    getInitialState: function getInitialState() {
	        return {
	            industryRiskList: [],
	            industryRiskDetList: {},
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getFinGuaIndustryRisk = this.props.getFinGuaIndustryRisk;

	        var jsonData = {};
	        getFinGuaIndustryRisk(jsonData);
	        $('#finGuaRisk-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#finGuaRisk-scroll').perfectScrollbar('update');
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domIco = _dom.find("i"),
	            _domAttr = _dom.attr("data-order"),
	            _domIcoIs = _dom.find("i").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.industryRiskList, field, this.state.orderType);
	            this.setState({ industryRiskList: _basedata });
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.finGuaIndustryRiskResult, this.props.finGuaIndustryRiskResult);
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

	        var isEqualDet = Immutable.is(nextProps.finGuaIndustryRiskDetailResult, this.props.finGuaIndustryRiskDetailResult);
	        if (!isEqualDet) {
	            var finGuaIndustryRiskDetailRequest = nextProps.finGuaIndustryRiskDetailRequest;
	            var finGuaIndustryRiskDetailResult = nextProps.finGuaIndustryRiskDetailResult;

	            console.log(finGuaIndustryRiskDetailRequest, finGuaIndustryRiskDetailResult, '123');
	            if (finGuaIndustryRiskDetailRequest == true) {
	                if (finGuaIndustryRiskDetailResult.success == true) {
	                    console.log(finGuaIndustryRiskDetailResult, 'finGuaIndustryRiskDetailResult');
	                    this.dataFomatDetail(finGuaIndustryRiskDetailResult);
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
	    dataFomatDetail: function dataFomatDetail(data) {
	        var content = data.content;
	        console.log(content, 'xuyao');
	        this.setState({ industryRiskDetList: content });
	    },
	    getFinGuaIndustryRiskDetail: function getFinGuaIndustryRiskDetail(jsonData) {
	        var getFinGuaIndustryRiskDetail = this.props.getFinGuaIndustryRiskDetail;

	        getFinGuaIndustryRiskDetail(jsonData);
	    },
	    handleMore: function handleMore(data, e) {
	        console.log(data, e);
	        var jsonData = { companyId: data };
	        this.getFinGuaIndustryRiskDetail(jsonData);

	        var left = e.screenX - 500;
	        var top = e.screenY - 310;
	        var moreStyle = {
	            position: 'fixed',
	            left: left + 'px',
	            top: top + 'px',
	            display: 'block'
	        };
	        //this.setState({moreStyle:moreStyle});
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
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'p2p', onClick: this.handleClick.bind(this, "p2p") },
	                                    'P2P关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'privateFund', onClick: this.handleClick.bind(this, "privateFund") },
	                                    '私募基金关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '22%', className: 'cur-pointer', 'data-order': this.state.offlineFinance, ref: 'offlineFinance', onClick: this.handleClick.bind(this, "offlineFinance") },
	                                    '线下理财关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '13%', className: 'cur-pointer' },
	                                    '更多'
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'finGuaRisk-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.industryRiskList.map(function (elem, index) {
	                                var companyId = elem.companyId;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
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
	                                            { width: '25%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '22%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '13%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', className: 'more', onClick: this.handleMore.bind(this, companyId) },
	                                                '更多'
	                                            )
	                                        )
	                                    );
	                                }{
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
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
	                                            { width: '25%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '22%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '13%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', className: 'more', onClick: this.handleMore.bind(this, companyId) },
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
	            _react2.default.createElement(_IndustryRiskMore2.default, { riskListDet: this.state.industryRiskDetList })
	        );
	    }
	});
	module.exports = FinanceGuaraIndustryRisk;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinanceGuaraIndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 797:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//股东行业风险更多
	var IndustryRiskMore = _react2.default.createClass({
	  displayName: 'IndustryRiskMore',

	  getInitialState: function getInitialState() {
	    return {
	      p2p: [], //p2p
	      linFin: [], //线下理财
	      preFun: [] };
	  },
	  //私募基金
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.riskListDet, this.props.riskListDet);
	    if (!isEqual) {
	      this.dataFomat(nextProps);
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data.riskListDet, 333);
	    var p2p = [],
	        linFin = [],
	        preFun = [];
	    var riskListDet = data.riskListDet;
	    if (riskListDet["1"] != undefined) {
	      p2p = riskListDet["1"];
	    }
	    if (riskListDet["4"] != undefined) {
	      linFin = riskListDet["4"];
	    }
	    if (riskListDet["5"] != undefined) {
	      preFun = riskListDet["5"];
	    }
	    this.setState({ p2p: p2p, linFin: linFin, preFun: preFun });
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
	          this.state.p2p.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        ),
	        _react2.default.createElement(
	          'ul',
	          { className: 'middle' },
	          this.state.preFun.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        ),
	        _react2.default.createElement(
	          'ul',
	          { className: 'right' },
	          this.state.linFin.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        )
	      )
	    );
	  }
	});
	module.exports = IndustryRiskMore;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRiskMore.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 798:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(788);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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
	                { width: '20%', className: 'talign-left cur-pointer', onClick: this.orderByField.bind(this, 1) },
	                '担保公司',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 2) },
	                '被担保公司',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '30%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 3) },
	                '被担保公司行业',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 4) },
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
	                  { className: 'even' },
	                  _react2.default.createElement(
	                    'td',
	                    { className: 'talign-left' },
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.guaranteeName } }, className: 'word-limit-5', title: elem.guaranteeName },
	                      elem.guaranteeName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.guaranteedName } }, className: 'word-limit-5', title: elem.guaranteedName },
	                      elem.guaranteedName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      'span',
	                      { className: 'word-limit-5', 'data-tip': elem.guaranteedBusinessType, title: elem.guaranteedBusinessType },
	                      elem.guaranteedBusinessType
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    elem.guaranteedRegisteredCapital
	                  )
	                );
	              } else {
	                return _react2.default.createElement(
	                  'tr',
	                  { className: 'odd' },
	                  _react2.default.createElement(
	                    'td',
	                    { className: 'talign-left' },
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.guaranteeName } }, className: 'word-limit-5', title: elem.guaranteeName },
	                      elem.guaranteeName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.guaranteedName } }, className: 'word-limit-5', title: elem.guaranteedName },
	                      elem.guaranteedName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.guaranteedBusinessType } }, className: 'word-limit-5', title: elem.guaranteedBusinessType },
	                      elem.guaranteedBusinessType
	                    )
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

/***/ 799:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(800);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyProgress = __webpack_require__(802);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _CompanyQuality = __webpack_require__(805);

	var _CompanyQuality2 = _interopRequireDefault(_CompanyQuality);

	var _QDLPQuality = __webpack_require__(806);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(807);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(808);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _EquityL = __webpack_require__(810);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(812);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(813);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _PrivateFundIndexAction = __webpack_require__(814);

	var PrivateFundIndexCreaters = _interopRequireWildcard(_PrivateFundIndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//私募股权基本情况
	//私募证券基本情况

	//QDLP试点企业最新进展

	//QDLP试点企业最新进展

	var Immutable = __webpack_require__(718);
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
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'privateFund-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '私募基金监测', searchFun: this.handleFunction, companyType: '5', placeholder: '请输入企业名称检索' }),
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

/***/ 815:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(816);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _SmallLoanIndexAction = __webpack_require__(818);

	var SmallLoanActionCreaters = _interopRequireWildcard(_SmallLoanIndexAction);

	var _index = __webpack_require__(692);

	var _setMinHeight = __webpack_require__(731);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyGrade = __webpack_require__(819);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _BalanceRatio = __webpack_require__(822);

	var _BalanceRatio2 = _interopRequireDefault(_BalanceRatio);

	var _EachAverage = __webpack_require__(824);

	var _EachAverage2 = _interopRequireDefault(_EachAverage);

	var _SmallLoanMap = __webpack_require__(825);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _LoanBalance = __webpack_require__(826);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(827);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(829);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

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

	    //三农小微企业图表数据
	    var balanceRatioData = [];

	    var conLength = content.length;
	    for (var i = 0; i < conLength; i++) {
	      var year = content[i].year;
	      var amount = content[i].amount; //贷款余额

	      var number = content[i].number; //笔数
	      var companyAmount = content[i].companyAmount; //公司数量
	      var averageBlance = Number(amount / companyAmount).toFixed(2); //平均贷款余额

	      //贷款余额
	      var dataArr = [i, i, amount, averageBlance];
	      balanceArr.push(amount);
	      loanBalanceData.xAxis.push(year);
	      loanBalanceData.data.push(dataArr);

	      var eachAver = Number(amount / number).toFixed(2); //贷款笔均数
	      eachAverageData.xAxis.push(year);
	      eachAverageData.series.push(eachAver);

	      //三农 小微企业
	      var agricultureBalance = content[i].agricultureBalance;
	      var smallCompanyBalance = content[i].smallCompanyBalance;
	      balanceRatioData.push({
	        year: year,
	        amount: amount,
	        agricultureBalance: agricultureBalance,
	        smallCompanyBalance: smallCompanyBalance,
	        amountScale: Number(amount / amount * 0.7).toFixed(2),
	        agrBalScale: Number(agricultureBalance / amount).toFixed(2),
	        smlComBalScale: Number(smallCompanyBalance / amount).toFixed(2)
	      });
	    }

	    var balanceMax = Math.max.apply(null, balanceArr);
	    var eachYAxis = balanceMax / 5;
	    for (var j = 0; j < 5; j++) {
	      loanBalanceData.yAxis.push(eachYAxis * j);
	    }

	    this.setState({ loanBalanceData: loanBalanceData, eachAverageData: eachAverageData, balanceRatioData: balanceRatioData });
	  },
	  searchFun: function searchFun(e) {
	    this.props.history.push('/SearchResultDetail?companyName=' + e);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'small-loan-index content-space-10', style: this.state.style },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_IndustrySearch2.default, { label: '小额贷款监测', companyType: '2', searchFun: this.searchFun, className: 'small-loan-search', placeholder: '请输入企业名称检索' })
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
	          _react2.default.createElement(_BalanceRatio2.default, { balanceRatioData: this.state.balanceRatioData }),
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

	    //股东行业风险详情
	    industryRiskDetailRequest: state.IndustryRiskDetail.request,
	    industryRiskDetailResult: state.IndustryRiskDetail.result,

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

/***/ 818:
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
	exports.getIndustryRiskDetail = getIndustryRiskDetail;
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
	/*股东行业风险详情 begin*/
	var INDUSTRY_RISK_DETAIL_SUCCESS = exports.INDUSTRY_RISK_DETAIL_SUCCESS = 'INDUSTRY_RISK_DETAIL_SUCCESS';
	var INDUSTRY_RISK_DETAIL_FAIL = exports.INDUSTRY_RISK_DETAIL_FAIL = 'INDUSTRY_RISK_DETAIL_FAIL';

	function industryRiskDetailSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INDUSTRY_RISK_DETAIL_SUCCESS,
	    result: result
	  };
	}

	function industryRiskDetailFail(result) {
	  //请求失败调用方法
	  return {
	    type: INDUSTRY_RISK_DETAIL_FAIL,
	    result: result
	  };
	}

	function getIndustryRiskDetail(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/loan/shareholderRiskDetail.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(industryRiskDetailSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(industryRiskDetailFail(result));
	      }
	    });
	  };
	}
	/*股东行业风险详情  end*/

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

/***/ 819:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(820);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//企业评级
	var CompanyGrade = _react2.default.createClass({
	    displayName: 'CompanyGrade',

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
	        $('#companyGrade-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#companyGrade-scroll').perfectScrollbar('update');
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
	    getCompanyGrade: function getCompanyGrade(jsonData) {
	        var getCompanyGrade = this.props.getCompanyGrade; // 取到props里面的getCompanyGrade方法。也可以说是请求action

	        getCompanyGrade(jsonData);
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
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 1) },
	                                    '外部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 2) },
	                                    '内部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 3) },
	                                    '现场检查',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'companyGrade-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.companyGradeList.map(function (elem, index) {
	                                var _innerLevel = elem.innerLevel == undefined ? "/" : elem.innerLevel;
	                                var _outLevel = elem.outLevel == undefined ? "/" : elem.outLevel;
	                                var _liveLevel = elem.liveLevel == undefined ? "/" : elem.liveLevel;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _liveLevel
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
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
	                                                elem.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _innerLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _outLevel
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            _liveLevel
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

/***/ 821:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".small-loan-index .mt-table {\r\n\tmargin: 0px !important;\r\n}\r\n\r\n/*企业评级*/\r\n.small-loan-index .company-grade .mod-content .table-content {\r\n\theight: 530px;\r\n\toverflow: auto;\r\n}\r\n\r\n/*余额占比*/\r\n.small-loan-index .balance-radio {\r\n\theight: 49.5%;\r\n}\r\n\r\n.small-loan-index .balance-radio .chart-box {\r\n\theight: 272px;\r\n}\r\n\r\n/*贷款笔均折线图*/\r\n.small-loan-index .each-average {\r\n\theight: 49.5%;\r\n\tmargin-top: 2%;\r\n}\r\n\r\n.small-loan-index .each-average .chart-box {\r\n\theight: 272px;\r\n}\r\n\r\n/*地图模块*/\r\n.small-loan-index .small-loan-map .map-chart-box {\r\n\theight: 610px;\r\n\tposition: relative;\r\n}\r\n\r\n.small-loan-index .mod-content {\r\n\tposition: relative;\r\n}\r\n\r\n.small-loan-index .small-loan-map .company-chart-box {\r\n\twidth: 200px;\r\n\theight: 200px;\r\n\tposition: absolute;\r\n\tleft: 0px;\r\n\ttop: 0px;\r\n}\r\n\r\n.small-loan-index .small-loan-map .visual-text {\r\n\tposition: absolute;\r\n\tbottom: 26%;\r\n\tright: 3%;\r\n\tz-index: 1000;\r\n\twidth: 14px;\r\n}\r\n\r\n/*贷款余额占比*/\r\n.small-loan-index .loan-balance .chart-box {\r\n\theight: 300px;\r\n}\r\n\r\n/*股东行业风险*/\r\n.small-loan-index .industry-risk .mod-content .table-content {\r\n\theight: 240px;\r\n\toverflow: auto;\r\n}\r\n\r\n.small-loan-index .industry-risk .mod-content .table-content table td a.more {\r\n\tcolor: #e14340;\r\n}\r\n\r\n/*大额借款人信息列表*/\r\n\r\n/*股东风险更多*/\r\n.small-loan-index .industry-risk-more {\r\n\tbackground-color: #254155;\r\n\twidth: 480px;\r\n\theight: 260px;\r\n\tposition: fixed;\r\n\tleft: 0px;\r\n\ttop: 0px;\r\n\tz-index: 100;\r\n\tborder: solid 1px #040506;\r\n\tborder-radius: 5px;\r\n\tdisplay: none;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .title {\r\n\tborder-bottom: solid 1px #000000;\r\n\tpadding: 10px 20px;\r\n\tposition: relative;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .title span {\r\n\tdisplay: inline-block;\r\n\ttext-align: center;\r\n\twidth: 33%;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .title i {\r\n\tposition: absolute;\r\n\tright: 0px;\r\n\ttop: -1px;\r\n\tfont-size: 20px;\r\n\tcolor: #ffffff;\r\n\tcursor: pointer;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .content {\r\n\tpadding: 8px 10px;\r\n\toverflow: hidden;\r\n\theight: 215px;\r\n\tposition: relative;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .content ul {\r\n\tdisplay: inline-block;\r\n\twidth: 33.33%;\r\n}\r\n\r\n.small-loan-index .industry-risk-more .content ul li {\r\n\tpadding: 15px 5px;\r\n\tfont-size: 14px;\r\n}", ""]);

	// exports


/***/ },

/***/ 823:
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
	                    backgroundColor: 'rgba(0,0,0,0.7)',
	                    padding: [10, 10, 10, 10],
	                    //formatter: "{a} <br/>{b} : {c} ({d}%)"
	                    formatter: function formatter(data) {
	                        console.log(data.name, 4444);
	                        if (data.name != "invisible") {
	                            var value = data.value;
	                            if (value == 70) {
	                                return data.seriesName + "：100(100)%";
	                            } else {
	                                return data.seriesName + "：" + data.value + "(" + data.value + ")%";
	                            }
	                        }
	                    }
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

/***/ 827:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(820);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _IndustryRiskMore = __webpack_require__(828);

	var _IndustryRiskMore2 = _interopRequireDefault(_IndustryRiskMore);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//股东行业风险
	var IndustryRisk = _react2.default.createClass({
	    displayName: 'IndustryRisk',

	    getInitialState: function getInitialState() {
	        return {
	            industryRiskList: [],
	            industryRiskDetList: {},
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },

	    componentDidMount: function componentDidMount() {
	        var getIndustryRisk = this.props.getIndustryRisk;

	        var jsonData = {};
	        getIndustryRisk(jsonData);
	        $('#industryRisk-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#industryRisk-scroll').perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.industryRiskResult, this.props.industryRiskResult);
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

	        var isEqualDet = Immutable.is(nextProps.industryRiskDetailResult, this.props.industryRiskDetailResult);
	        if (!isEqualDet) {
	            var industryRiskDetailRequest = nextProps.industryRiskDetailRequest;
	            var industryRiskDetailResult = nextProps.industryRiskDetailResult;

	            if (industryRiskDetailRequest == true) {
	                if (industryRiskDetailResult.success == true) {
	                    this.dataFomatDetail(industryRiskDetailResult);
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
	    dataFomatDetail: function dataFomatDetail(data) {
	        var content = data.content;
	        this.setState({ industryRiskDetList: content });
	    },
	    getIndustryRiskDetail: function getIndustryRiskDetail(jsonData) {
	        var getIndustryRiskDetail = this.props.getIndustryRiskDetail;

	        getIndustryRiskDetail(jsonData);
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domIco = _dom.find("i"),
	            _domAttr = _dom.attr("data-order"),
	            _domIcoIs = _dom.find("i").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.industryRiskList, field, this.state.orderType);
	            this.setState({ industryRiskList: _basedata });
	        });
	    },
	    handleMore: function handleMore(data, e) {
	        console.log(data, e);
	        var jsonData = { companyId: data };
	        this.getIndustryRiskDetail(jsonData);

	        var left = e.screenX - 500;
	        var top = e.screenY - 310;
	        var moreStyle = {
	            position: 'fixed',
	            left: left + 'px',
	            top: top + 'px',
	            display: 'block'
	        };
	        //this.setState({moreStyle:moreStyle});
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
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'p2p', onClick: this.handleClick.bind(this, "p2p") },
	                                    'P2P关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'privateFund', onClick: this.handleClick.bind(this, "privateFund") },
	                                    '私募基金关联',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '22%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'offlineFinance', onClick: this.handleClick.bind(this, "offlineFinance") },
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
	                    { className: 'table-content', id: 'industryRisk-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.industryRiskList.map(function (elem, index) {
	                                var companyId = elem.companyId;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%', className: 'talign-left' },
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
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
	                                            { width: '25%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '22%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '13%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', className: 'more', onClick: this.handleMore.bind(this, companyId) },
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
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { companyName: elem.companyName } }, className: 'word-limit-5', title: elem.companyName, 'data-tip': elem.companyName },
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
	                                            { width: '25%' },
	                                            elem.privateFund
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '22%' },
	                                            elem.offlineFinance
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '13%' },
	                                            _react2.default.createElement(
	                                                'a',
	                                                { href: 'javascript:;', className: 'more', onClick: this.handleMore.bind(this, companyId) },
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
	            _react2.default.createElement(_IndustryRiskMore2.default, { riskListDet: this.state.industryRiskDetList })
	        );
	    }
	});
	module.exports = IndustryRisk;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 828:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(820);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//股东行业风险更多
	var IndustryRiskMore = _react2.default.createClass({
	  displayName: 'IndustryRiskMore',

	  getInitialState: function getInitialState() {
	    return {
	      p2p: [], //p2p
	      linFin: [], //线下理财
	      preFun: [] };
	  },
	  //私募基金
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.riskListDet, this.props.riskListDet);
	    if (!isEqual) {
	      this.dataFomat(nextProps);
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data.riskListDet, 333);
	    var p2p = [],
	        linFin = [],
	        preFun = [];
	    var riskListDet = data.riskListDet;
	    if (riskListDet["1"] != undefined) {
	      p2p = riskListDet["1"];
	    }
	    if (riskListDet["4"] != undefined) {
	      linFin = riskListDet["4"];
	    }
	    if (riskListDet["5"] != undefined) {
	      preFun = riskListDet["5"];
	    }
	    this.setState({ p2p: p2p, linFin: linFin, preFun: preFun });
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
	          this.state.p2p.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        ),
	        _react2.default.createElement(
	          'ul',
	          { className: 'middle' },
	          this.state.preFun.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        ),
	        _react2.default.createElement(
	          'ul',
	          { className: 'right' },
	          this.state.linFin.map(function (elem, index) {
	            console.log(elem);
	            return _react2.default.createElement(
	              'li',
	              null,
	              elem
	            );
	          }.bind(this))
	        )
	      )
	    );
	  }
	});
	module.exports = IndustryRiskMore;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRiskMore.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 829:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(820);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//大额借款人信息列表
	var LargeLoan = _react2.default.createClass({
	  displayName: 'LargeLoan',

	  getInitialState: function getInitialState() {
	    return {
	      count: 0,
	      largeLoanList: [],
	      orderByField: 1,
	      nowpage: 1
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var jsonData = { pageSize: 4 };
	    this.getLargeLoan(jsonData);
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
	  getLargeLoan: function getLargeLoan(jsonData) {
	    var getLargeLoan = this.props.getLargeLoan;

	    getLargeLoan(jsonData);
	  },
	  //分页回调 
	  setCallBack: function setCallBack(nowpage, eachPageCount) {
	    this.setState({ nowpage: nowpage });
	    var orderByField = this.state.orderByField;
	    var descAsc = this.state.descAsc;

	    var jsonData = { orderByField: orderByField, descAsc: descAsc, pageSize: 4, pageNumber: nowpage };
	    this.getLargeLoan(jsonData);
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
	    this.getLargeLoan(jsonData);
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
	                { width: '20%', className: 'talign-left cur-pointer', onClick: this.orderByField.bind(this, 1) },
	                '借款公司',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 2) },
	                '贷款公司',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '30%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 3) },
	                '借款公司行业',
	                _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	              ),
	              _react2.default.createElement(
	                'th',
	                { width: '25%', className: 'cur-pointer', onClick: this.orderByField.bind(this, 4) },
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
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.borrowerName } }, className: 'word-limit-5', title: elem.borrowerName },
	                      elem.borrowerName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.lenderName } }, className: 'word-limit-5', title: elem.lenderName },
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
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.borrowerName } }, className: 'word-limit-5', title: elem.borrowerName },
	                      elem.borrowerName
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                      _reactRouter.Link,
	                      { to: { pathname: '/SearchResultDetail', query: { companyName: elem.lenderName } }, className: 'word-limit-5', title: elem.lenderName },
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
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var getbaseMsgRequest = this.props.getbaseMsgRequest;

	            getbaseMsgRequest({ "platName": this.state.companyVal });
	        }
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
	                                            { className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
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
	                                            { className: 'word-limit-5', 'data-tip': item.address, title: item.address },
	                                            '>',
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
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var _props = this.props;
	            var getcoreDataRequest = _props.getcoreDataRequest;
	            var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	            var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	            var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

	            getcoreDataRequest({ "platName": this.state.companyVal });
	            getCoreBarDataRequest({ "platName": this.state.companyVal });
	            getCoreTrendDataRequest({ "platName": this.state.companyVal });
	            getCoreBalanceDataRequest({ "platName": this.state.companyVal });
	        }

	        var isEqual = Immutable.is(nextProps.coreDataResult, this.props.coreDataResult);
	        if (!isEqual) {
	            var coreDataRequest = nextProps.coreDataRequest;
	            var coreDataResult = nextProps.coreDataResult;

	            if (coreDataRequest == true) {
	                if (coreDataResult.success) {
	                    var _setParm = [coreDataResult.content];
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
	                        unit: ["万元"],
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
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var _amount_total = item.amount_total == undefined ? "/" : item.amount_total;
	                                    var _money_stock = item.money_stock == undefined ? "/" : item.money_stock;
	                                    var _interest_rate = item.interest_rate == undefined ? "/" : item.interest_rate;
	                                    var _month_net_inflow = item.month_net_inflow == undefined ? "/" : item.month_net_inflow;
	                                    var _bid_num_stay_stil = item.bid_num_stay_stil == undefined ? "/" : item.bid_num_stay_stil;

	                                    var _bor_num_stay_stil = item.bor_num_stay_stil == undefined ? "/" : item.bor_num_stay_stil;
	                                    var _top1_sum_amount = item.top1_sum_amount == undefined ? "/" : item.top1_sum_amount;
	                                    var _top10_sum_amount = item.top10_sum_amount == undefined ? "/" : item.top10_sum_amount;
	                                    return _react2.default.createElement(
	                                        'tbody',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '累计成交量'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _amount_total,
	                                                    '亿元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '贷款余额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _money_stock,
	                                                    '亿元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '平均利率'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _interest_rate,
	                                                    '%'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '近30日净资金流入'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _month_net_inflow,
	                                                    '万元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '待收投资人数'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _bid_num_stay_stil
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '待还借款人数'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _bor_num_stay_stil
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd-blackbg-line' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '最大单户借款额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _top1_sum_amount,
	                                                    '万元'
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                '最大十户借款额'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    null,
	                                                    _top10_sum_amount,
	                                                    '万元'
	                                                )
	                                            )
	                                        )
	                                    );
	                                }
	                            })
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

/***/ 857:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(858);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _BusinessTypes = __webpack_require__(860);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(863);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(864);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(865);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _PlatformRun = __webpack_require__(866);

	var _PlatformRun2 = _interopRequireDefault(_PlatformRun);

	var _PlatformBase = __webpack_require__(867);

	var _PlatformBase2 = _interopRequireDefault(_PlatformBase);

	var _RaiseIndexAction = __webpack_require__(868);

	var RaiseIndexCreaters = _interopRequireWildcard(_RaiseIndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//平台运营情况
	//6月上海各类众筹平台新增项目数
	//业务类型

	var Immutable = __webpack_require__(718);
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
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'raise-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '众筹监测', searchFun: this.handleFunction, companyType: '6', placeholder: '请输入企业名称检索' }),
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

/***/ 859:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".raise-index .radius4 {\r\n\tborder-radius: 5px;\t/*background: #2b323c;*/\r\n}\r\n\r\n.raise-index .header {\r\n\theight: 70px;\r\n\tline-height: 70px;\r\n\tfont-size: 24px;\r\n\tcolor: #fff;\r\n\tbackground: #1a2029;\r\n\ttext-align: center;\r\n}\r\n\r\n.raise-index .raise-index-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.raise-index .raise-index-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n}\r\n\r\n.raise-index .raise-index-right {\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.raise-index  .content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.raise-index a {\r\n\tcolor: #e14340 !important;\r\n}", ""]);

	// exports


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
	                        "yAxisName": "个数",
	                        "legend": businessTypesResult.content.legend,
	                        "legendShow": true,
	                        "legendOrient": "vertical",
	                        "legendLeft": "",
	                        "legendTop": "middle",
	                        "legendRight": "20%",
	                        "seriesName": "企业数",
	                        "radius": "70%",
	                        "unit": "家",
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
	                        yAxisName: "个数",
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

/***/ 869:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(870);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyNum = __webpack_require__(872);

	var _CompanyNum2 = _interopRequireDefault(_CompanyNum);

	var _CapitalAmount = __webpack_require__(875);

	var _CapitalAmount2 = _interopRequireDefault(_CapitalAmount);

	var _BusinessNum = __webpack_require__(876);

	var _BusinessNum2 = _interopRequireDefault(_BusinessNum);

	var _Income = __webpack_require__(877);

	var _Income2 = _interopRequireDefault(_Income);

	var _CompanyDirectory = __webpack_require__(878);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _PawnMonitoringAction = __webpack_require__(879);

	var PawnMonitoringActionCreaters = _interopRequireWildcard(_PawnMonitoringAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//典当总收入

	//注册资本总额


	var Immutable = __webpack_require__(718);
	//众筹监测
	//上海市企业典当目录
	//业务笔数
	//典当法人企业数
	var PawnMonitoring = _react2.default.createClass({
	    displayName: 'PawnMonitoring',

	    getInitialState: function getInitialState() {
	        return {
	            lineData: [],
	            doubleBarData: [],
	            scatterData: [],
	            barData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getChartAllRequest = this.props.getChartAllRequest;

	        var jsonData = {};
	        getChartAllRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.chartAllRequest, this.props.chartAllResult);
	        if (!isEqual) {
	            var chartAllRequest = nextProps.chartAllRequest;
	            var chartAllResult = nextProps.chartAllResult;

	            if (chartAllRequest == true) {
	                if (chartAllResult.success) {

	                    /*"year": 2015,
	                     "companyNumber": 256,
	                     "balance": 645711,//典当余额（万元
	                     "registerCapital": 637096,//注册资本（万元）
	                     "totalIncome": 103078,//总费收入（万元）
	                     "totalAmout": 4664405,//典当金额（万元）
	                     "number": 351148//典当笔数*/

	                    var _xAxisData = [],
	                        _companyNumber = [],
	                        _balance = [],
	                        _registerCapital = [],
	                        _totalIncome = [],
	                        _totalAmout = [],
	                        _number = [];
	                    for (var item in chartAllResult.content) {
	                        _xAxisData.push(chartAllResult.content[item].year); //年份
	                        _companyNumber.push(chartAllResult.content[item].companyNumber);

	                        _balance.push(chartAllResult.content[item].balance);
	                        _registerCapital.push(chartAllResult.content[item].registerCapital);
	                        _totalIncome.push(chartAllResult.content[item].totalIncome);
	                        _totalAmout.push(chartAllResult.content[item].totalAmout);
	                        _number.push(chartAllResult.content[item].number);
	                    }

	                    var _setLineData = {
	                        "xAxisData": _xAxisData,
	                        "data": _companyNumber
	                    };

	                    var _doubleBarData = {
	                        "xAxisData": _xAxisData,
	                        "data": [_balance, _registerCapital]
	                    };

	                    var _scatterData = {
	                        "xAxisData": _xAxisData,
	                        "yAxisData": _totalAmout.sort(function (a, b) {
	                            return a - b;
	                        }),
	                        "data": _number
	                    };

	                    var _barData = {
	                        "xAxisData": _xAxisData,
	                        "data": _totalIncome
	                    };
	                    this.setState({ lineData: _setLineData });
	                    this.setState({ doubleBarData: _doubleBarData });
	                    this.setState({ scatterData: _scatterData });
	                    this.setState({ barData: _barData });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'pawnMonitoring-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '典当行业监测', searchFun: this.handleFunction, companyType: '12', placeholder: '请输入企业名称检索' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-top clearfix' },
	                    _react2.default.createElement(_CompanyNum2.default, { Data: this.state.lineData }),
	                    _react2.default.createElement(_CapitalAmount2.default, { Data: this.state.doubleBarData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-Middle clearfix' },
	                    _react2.default.createElement(_BusinessNum2.default, { Data: this.state.scatterData }),
	                    _react2.default.createElement(_Income2.default, { Data: this.state.barData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-bottom' },
	                    _react2.default.createElement(_CompanyDirectory2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = PawnMonitoring;
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        chartAllRequest: state.PawnMChartAll.request,
	        chartAllResult: state.PawnMChartAll.result,

	        companyDirRequest: state.CompanyDirectory.request,
	        companyDirResult: state.CompanyDirectory.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(PawnMonitoringActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(PawnMonitoring);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	                                    var _danwei = item.registeredCapitalType == 1 ? "万元" : "美元";
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
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } } },
	                                                    item.companyName
	                                                )
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
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } } },
	                                                    item.companyName
	                                                )
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

/***/ 880:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(881);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _RegionalDis = __webpack_require__(883);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(886);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _HPQList = __webpack_require__(887);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _DetailList = __webpack_require__(888);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _TradingPlacesAction = __webpack_require__(889);

	var TradingPlacesCreaters = _interopRequireWildcard(_TradingPlacesAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//黄浦区交易场所列表
	//交易场所区域分布

	var TradingPlaces = _react2.default.createClass({
	    displayName: 'TradingPlaces',

	    mixins: [_setHeight2.default],
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?companyName=' + searchVal);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'tradingPlaces-index', searchFun: this.handleFunction, style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '交易场所监测', companyType: '9', searchFun: this.handleFunction, placeholder: '请输入企业名称检索' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tradingP-left mod radius4 clearfix' },
	                    _react2.default.createElement(_RegionalDis2.default, this.props),
	                    _react2.default.createElement(_HPQList2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tradingP-right mod radius4 clearfix' },
	                    _react2.default.createElement(_Classification2.default, this.props),
	                    _react2.default.createElement(_DetailList2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = TradingPlaces;
	//将 request  result 绑定到props的request result
	//取得合规意见或经过商的交易场所详情列表
	//交易场所清理整顿分类
	function mapStateToProps(state) {
	    return {
	        HPQListRequest: state.HPQList.request,
	        HPQListResult: state.HPQList.result,

	        regionalDisRequest: state.RegionalDis.request,
	        regionalDisResult: state.RegionalDis.result,

	        classificationRequest: state.Classification.request,
	        classificationResult: state.Classification.result,

	        detailListRequest: state.DetailList.request,
	        detailListResult: state.DetailList.result,

	        pieCounty: state.PieCounty.county,

	        barName: state.BarName.county

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(TradingPlacesCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(TradingPlaces);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 882:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".tradingPlaces-index .tradingP-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.tradingPlaces-index .tradingP-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.tradingPlaces-index .content {\r\n\tpadding: 30px 20px 30px 20px;\r\n}\r\n\r\n.tradingPlaces-index  a {\r\n\tcolor: #e14340 !important\r\n}", ""]);

	// exports


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
	            areaName: "浦东新区",
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
	        this.setState({ areaName: this.state.areaName });
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
	            _domIco = _dom.find("i"),
	            _domIcoIs = _dom.find("i").hasClass('icon-desc');
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
	                    this.state.areaName,
	                    '交易场所列表'
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
	            statusName: "通过验收",
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
	        this.countyChange(this.state.statusName);
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
	                    this.state.statusName,
	                    '详情列表'
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
	                                                    { className: 'leftD' },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
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
	                                                    { className: 'leftD' },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
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

/***/ 904:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".commercialS-index .content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.commercialS-index .pawnM-top {\r\n}\r\n\r\n.commercialS-index .pawnM-top .top-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.commercialS-index .pawnM-top .top-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.commercialS-index .pawnM-Middle {\r\n\tmargin: 0.5% 0px;\r\n}\r\n\r\n.commercialS-index .pawnM-Middle .middle-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.commercialS-index .pawnM-Middle .middle-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.commercialS-index .pawnM-bottom {\r\n}", ""]);

	// exports


/***/ },

/***/ 908:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".commercialS-index .right-bottom tbody td,\r\n.commercialS-index .right-bottom thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content {\r\n\theight: 560px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content .mt-table,\r\n.commercialS-index .right-bottom .table-title  .mt-table {\r\n\tmargin: 0px;\r\n}\r\n\r\n.commercialS-index .right-bottom  .mod-content {\r\n\tpadding: 10px 20px 20px 20px;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table {\r\n\r\n\t/*height: 100%*/\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table  td {\r\n\tpadding: 16px 0px;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-title th {\r\n\theight: 50px\r\n}\r\n\r\n.commercialS-index .right-bottom  .mod-title .totle-num {\r\n\tfont-size: 14px;\r\n\tcolor: #fff;\r\n\tfloat: right;\r\n\tdisplay: inline-block;\r\n\tmargin: 15px 20px 0px 0px;\r\n}\r\n\r\n.commercialS-index a {\r\n\tcolor: #e14340 !important\r\n}\r\n\r\n.mt-select.company-dire {\r\n\tbackground: #393a48;\r\n\tborder: 1px #393a48 solid;\r\n\tmargin-left: 5px;\r\n\theight: 25px;\r\n\tline-height: 25px;\r\n}\r\n\r\n.mt-select.company-dire .mt-select-title {\r\n\theight: 25px;\r\n}\r\n\r\n.mt-select.company-dire .mt-select-box {\r\n\tbackground: #1f1f27;\r\n\tborder: 1px #1f1f27 solid\r\n}\r\n\r\n.modLong .long {\r\n\twidth: 250px;\r\n}", ""]);

	// exports


/***/ },

/***/ 911:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(907);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(809);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
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
	            xAxisName: "企业数量",
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
	            gridRight: '7%',
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

/***/ 912:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(907);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var innerdata = [];
	var outerdata = [];
	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',
	    getInitialState: function getInitialState() {
	        return {
	            CompanyDirectoryData: [],
	            selected: 1,
	            selectedData: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },

	    //排序
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("i"),
	            _domIcoIs = _dom.find("i").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.selectedData, field, this.state.orderType);
	            this.setState({ selectedData: _basedata });
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyDirectoryRequest = this.props.getCompanyDirectoryRequest;

	        var jsonData = {};
	        getCompanyDirectoryRequest(jsonData);
	        //滚动条
	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    //滚动条
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.CompanyDirectoryRequest, this.props.CompanyDirectoryResult);
	        if (!isEqual) {
	            var CompanyDirectoryRequest = nextProps.CompanyDirectoryRequest;
	            var CompanyDirectoryResult = nextProps.CompanyDirectoryResult;

	            if (CompanyDirectoryRequest == true) {
	                if (CompanyDirectoryResult.success) {
	                    for (var i = 0; i < CompanyDirectoryResult.content.length; i++) {
	                        if (CompanyDirectoryResult.content[i].isForeign == "内资") innerdata.push(CompanyDirectoryResult.content[i]);else outerdata.push(CompanyDirectoryResult.content[i]);
	                    }
	                    this.setState({
	                        CompanyDirectoryData: CompanyDirectoryResult.content,
	                        selectedData: CompanyDirectoryResult.content
	                    });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    quarterChoice: function quarterChoice(value) {
	        var CompanyDirectoryDatas = this.state.CompanyDirectoryData;
	        switch (value) {
	            case 2:
	                //内资
	                this.setState({
	                    selectedData: innerdata
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	            case 3:
	                //外资
	                this.setState({
	                    selectedData: outerdata
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	            default:
	                this.setState({
	                    selectedData: CompanyDirectoryDatas
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	        }
	    },
	    render: function render() {
	        var selectQuarter = {
	            width: '75px',
	            className: 'company-dire',
	            name: 'testselect',
	            value: "1",
	            id: 'selectType',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '内资' }, { value: '3', label: '外资' }],
	            onChange: function (value, label) {
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4 modLong' },
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
	                        ' ',
	                        this.state.selectedData.length,
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
	                                    { width: '15%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital") },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
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
	                            this.state.selectedData.map(function (item, index) {
	                                var _address = item.address == null ? "/" : item.address;
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
	                                            ' ',
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            item.isForeign
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '30%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5 long', 'data-tip': _address, title: _address },
	                                                _address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '15%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', title: '' },
	                                                item.registeredCapital,
	                                                '万元'
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
	                                            ' ',
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            item.isForeign
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '30%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5 long', 'data-tip': _address, title: _address },
	                                                _address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '15%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', title: '' },
	                                                item.registeredCapital,
	                                                '万元'
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

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDirectory.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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

	var _IndustryRiskDetail = __webpack_require__(1396);

	var _IndustryRiskDetail2 = _interopRequireDefault(_IndustryRiskDetail);

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

	var _FinGuaIndustryRiskDetail = __webpack_require__(1397);

	var _FinGuaIndustryRiskDetail2 = _interopRequireDefault(_FinGuaIndustryRiskDetail);

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

	var _CompanyName = __webpack_require__(1024);

	var _CompanyName2 = _interopRequireDefault(_CompanyName);

	var _CompanyProgress = __webpack_require__(1025);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1026);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1027);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1028);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1029);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1030);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1031);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1032);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1033);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1034);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1035);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1036);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1037);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1038);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1039);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1040);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1041);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1042);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1043);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1044);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1045);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1046);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1047);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1048);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1049);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _CatalogSelect = __webpack_require__(1050);

	var _CatalogSelect2 = _interopRequireDefault(_CatalogSelect);

	var _TimeSelect = __webpack_require__(1051);

	var _TimeSelect2 = _interopRequireDefault(_TimeSelect);

	var _realtimeTableRuducer = __webpack_require__(1052);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1053);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1054);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1055);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1056);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _realtimeRiskReducer = __webpack_require__(1057);

	var _realtimeRiskReducer2 = _interopRequireDefault(_realtimeRiskReducer);

	var _MenuParkSelectVal = __webpack_require__(1058);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1059);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1060);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1061);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1062);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1063);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ParkImg = __webpack_require__(1064);

	var _ParkImg2 = _interopRequireDefault(_ParkImg);

	var _BuildCompanyList = __webpack_require__(1065);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1066);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1067);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1068);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1069);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1070);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _BuildSwitchVal = __webpack_require__(1071);

	var _BuildSwitchVal2 = _interopRequireDefault(_BuildSwitchVal);

	var _ChartAll3 = __webpack_require__(1072);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1073);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1074);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1075);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1076);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1077);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1078);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1079);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1081);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1082);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1083);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1084);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1085);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1086);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _DynamicRiskCompanyTag = __webpack_require__(1087);

	var _DynamicRiskCompanyTag2 = _interopRequireDefault(_DynamicRiskCompanyTag);

	var _DynamicRiskDate = __webpack_require__(1088);

	var _DynamicRiskDate2 = _interopRequireDefault(_DynamicRiskDate);

	var _DynamicRiskLeftImg = __webpack_require__(1089);

	var _DynamicRiskLeftImg2 = _interopRequireDefault(_DynamicRiskLeftImg);

	var _DynamicRiskRightImg = __webpack_require__(1090);

	var _DynamicRiskRightImg2 = _interopRequireDefault(_DynamicRiskRightImg);

	var _DynamicRiskIndexCmp = __webpack_require__(1091);

	var _DynamicRiskIndexCmp2 = _interopRequireDefault(_DynamicRiskIndexCmp);

	var _SelectDate = __webpack_require__(1092);

	var _SelectDate2 = _interopRequireDefault(_SelectDate);

	var _RiskSearch = __webpack_require__(1093);

	var _RiskSearch2 = _interopRequireDefault(_RiskSearch);

	var _industryTypeChart = __webpack_require__(1094);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1095);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1096);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1097);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/


	/*线下理财监测 end*/

	/*预付卡 begin*/


	//楼宇详情页

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

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名


	//融资担保

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
	  CompanyName: _CompanyName2.default,

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
	  IndustryRiskDetail: _IndustryRiskDetail2.default,
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
	  FinGuaIndustryRiskDetail: _FinGuaIndustryRiskDetail2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,
	  RealTimeNews: _realtimeNewsReducer2.default,
	  RealTimeMap: _realtimeMapReducer2.default,
	  RealTimeMapSh: _realtimeMapShReducer2.default,
	  RealTimeRisk: _realtimeRiskReducer2.default,

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

	//动态图谱

	//诉讼信息

	//核心数据

	/*====================================P2P平台监测============================*/

	/*====================================p2p画像平台============================*/
	//基本信息

	//网贷平台数据展示


	/*企业全息查询*/

	/*行业监测模块*/
	/* 公共搜索 */

	//诉讼记录的五个接口

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1009:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = finGuaIndustryRisk;

	var _FinanceGuaraIndexAction = __webpack_require__(786);

	//股东行业风险
	function finGuaIndustryRisk() {
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

/***/ 1396:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = industryRiskDetail;

	var _SmallLoanIndexAction = __webpack_require__(818);

	//股东行业风险详情
	function industryRiskDetail() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _SmallLoanIndexAction.INDUSTRY_RISK_DETAIL_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _SmallLoanIndexAction.INDUSTRY_RISK_DETAIL_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustryRiskDetail.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1397:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = finGuaIndustryRiskDetail;

	var _FinanceGuaraIndexAction = __webpack_require__(786);

	//股东行业风险详情
	function finGuaIndustryRiskDetail() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _FinanceGuaraIndexAction.FINGUA_INDUSTRYRISK_DET_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _FinanceGuaraIndexAction.FINGUA_INDUSTRYRISK_DET_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FinGuaIndustryRiskDetail.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})