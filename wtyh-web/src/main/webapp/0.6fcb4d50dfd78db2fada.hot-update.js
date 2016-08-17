webpackHotUpdate(0,{

/***/ 956:
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

	var _ScatterChart = __webpack_require__(739);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	var _LineBarChart = __webpack_require__(799);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	var nineDate = "";
	var TopRight = _react2.default.createClass({
	    displayName: 'TopRight',
	    getInitialState: function getInitialState() {
	        return {
	            paramOne: {
	                id: 'realTimeRightOne', //必传
	                height: '100%', //必传 带上单位
	                title: '初始化之前',
	                forMaterTitle: "贷款余额",
	                forMaterTip: '平均贷款余额',
	                legend: [],
	                xAxis: ['2010', '2011', '2012', '2013', '2014', '2015', '2016'],
	                yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	                data: [[0, 0, 300000], [1, 1, 1000000], [2, 2, 200000], [3, 3, 50], [4, 4, 60], [5, 5, 10], [6, 6, 80]],
	                series: [[{
	                    color: '#e14340'
	                }]]
	            }
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getRealTimeNine = this.props.getRealTimeNine; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	        var jsonData = {}; //ajax传递给后台的data键值对
	        getRealTimeNine(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var _this = this;
	        var isEqual = Immutable.is(nextProps.realTimeNineRequest, this.props.realTimeNineResult); //判断数据是否变化
	        if (!isEqual) {
	            var realTimeNineRequest = nextProps.realTimeNineRequest;
	            var realTimeNineResult = nextProps.realTimeNineResult;

	            if (realTimeNineRequest == true) {
	                if (realTimeNineRequest == true) {
	                    //这里可以开始渲染数据
	                    nineDate = realTimeNineResult; //赋值给全局变量
	                    console.log(nineDate, "NINE");
	                    _this.setState({
	                        paramOne: {
	                            id: 'realTimeRightOne', //必传
	                            height: '100%', //必传 带上单位
	                            title: "sss",
	                            forMaterTitle: "贷款余额",
	                            forMaterTip: '平均贷款余额',
	                            legend: [],
	                            xAxis: ['2010', '2011', '2012', '2013', '2014', '2015', '2016'],
	                            yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	                            data: [[0, 0, 300000], [1, 1, 1000000], [2, 2, 200000], [3, 3, 50], [4, 4, 60], [5, 5, 10], [6, 6, 80]],
	                            series: [[{
	                                color: '#e14340'
	                            }]]
	                        }
	                    });
	                } else {
	                    alert(404);
	                }
	            }
	        }
	    },
	    setParam: function setParam() {
	        var paramOne = {
	            id: 'realTimeRightOne', //必传
	            height: '100%', //必传 带上单位
	            title: '小额贷款之贷款余额',
	            forMaterTitle: "贷款余额",
	            forMaterTip: '平均贷款余额',
	            legend: [],
	            xAxis: ['2010', '2011', '2012', '2013', '2014', '2015', '2016'],
	            yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	            data: [[0, 0, 300000], [1, 1, 1000000], [2, 2, 200000], [3, 3, 50], [4, 4, 60], [5, 5, 10], [6, 6, 80]],
	            series: [[{
	                color: '#e14340'
	            }]]
	        };
	        var paramTwo = {
	            "title": "私募基金",
	            "color": ["#f5b94b", "#01b6ed"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["管理资本金额", "私募机构数量"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "barName": ["管理资本金额", "私募机构数量"],
	            "xAxis": ["2012", "2013", "2014", "2015"],
	            "yAxisName": ["亿元", "个数"],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)], [Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramThree = {
	            "titleShow": true,
	            "title": "P2P平台",
	            "color": ["#12b5b0", "#e24441"],
	            "legend": ["上海新增", "上海累计"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "barName": ["上海新增"],
	            "lineName": ["上海累计"],
	            "YnameLocation": "end",
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "yFlag": "",
	            "xAxis": ["2012-Q1", "2014-Q2", "2014-Q3", "2014-Q4", "2015-Q1", "2015-Q2", "2015-Q3", "2015-Q4", "2016-Q1"],
	            "yAxisName": ["家数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramFour = {
	            "titleShow": true,
	            "title": "融资租赁",
	            "color": ["#12b5b0", "#e24441", "rgb(230,162,74)"],
	            "legend": ["注册资本($)", "注册资本(¥)", "企业数量"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "legendWidth": 600,
	            "barName": ["注册资本($)", "注册资本(¥)"],
	            "lineName": ["企业数量"],
	            "YnameRoutate": 0,
	            "YnameLocation": "end",
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "yFlag": "",
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"],
	            "yAxisName": ["亿人民币", "亿美元"],
	            "barWidth": 10,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)], [Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramFive = {
	            "title": "众筹平台",
	            "color": ["#f93330"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["新增项目数"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "axisLabelR": false,
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "labelShow": true,
	            "barName": ["新增项目数"],
	            "lablePosition": "right",
	            "yAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	            "Ytype": "category",
	            "Xtype": "value",
	            "yAxisName": ["新增项目数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramSix = {
	            "title": "众筹平台",
	            "color": ["#f93330"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["新增项目数"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "axisLabelR": false,
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "labelShow": true,
	            "barName": ["新增项目数"],
	            "xAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	            "yAxisName": ["新增项目数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramSeven = {
	            id: 'realTimeRightTwo', //必传
	            height: '100%', //必传 带上单位
	            title: '典当总额及业务笔数',
	            gridTop: "20%",
	            legend: [],
	            xAxis: ['2009', '2010', '2011', '2012', '2013'],
	            yAxis: ['100000', '200000', '300000', '400000', '500000'],
	            data: [[0, 0, 30], [1, 1, 10], [2, 2, 20], [3, 3, 50], [4, 4, 60]],
	            series: [[{
	                color: '#e14340'
	            }]]
	        };
	        var paramEight = {
	            "titleShow": true,
	            "title": "商业保理",
	            "color": ["rgb(249,51,48)", "rgb(246,215,147)"],
	            "legend": ["商业保理业务总额", "融资余额"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "barName": ["商业保理业务总额"],
	            "lineName": ["融资余额"],
	            "YnameLocation": "end",
	            "YnameGap": 5,
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "Ytype": "value",
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"],
	            "yAxisName": ["亿元", "个数"],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "itemStyle": {},
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramNine = {
	            "title": "预付卡之备案企业预付金额总额",
	            "color": ["#12b5b0", "#01b6ed"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["管理资本金额"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "axisLabelR": false,
	            "barName": ["管理资本金额"],
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"],
	            "yAxisName": ["亿元", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "labelShow": true,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        return [paramOne, paramTwo, paramThree, paramFour, paramFive, paramSix, paramSeven, paramEight, paramNine];
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-top-right' },
	            _react2.default.createElement(
	                'div',
	                { className: 'item', 'data-xx': this.state.paramOne },
	                _react2.default.createElement(_ScatterChart2.default, { param: this.state.paramOne })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[1], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[2], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[3], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[4], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[5], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_ScatterChart2.default, { param: this.setParam()[6], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[7], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[8], style: { height: '100%', width: '100%' } })
	            )
	        );
	    }
	});

	//将state植入 到 props
	exports.default = TopRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})