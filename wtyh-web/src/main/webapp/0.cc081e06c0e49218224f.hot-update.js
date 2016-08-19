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

	var nineDate = ""; //ajax返回回来的所有数据；
	var paramOne, paramTwo, paramThree, paramFour, paramFive, paramSix, paramSeven, paramEight, paramNine; //每一个小模块的数据，初始状态为空，render判断为空的话就不渲染。

	var TopRight = _react2.default.createClass({
	    displayName: 'TopRight',
	    getInitialState: function getInitialState() {
	        return {};
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

	                    //paramOneData-fixed == 1
	                    var paramOneData = [];
	                    nineDate.content.loan.series[0].map(function (item, index) {
	                        var xx = [index, item];
	                        paramOneData.push(xx);
	                    });
	                    nineDate.content.loan.series[1].map(function (item, index) {
	                        paramOneData[index].push(item);
	                    });
	                    //paramOneData-fixed-end
	                    paramOne = {
	                        id: 'realTimeRightOne', //必传
	                        height: '100%', //必传 带上单位
	                        title: '小额贷款之贷款余额',
	                        forMaterTitle: "贷款余额",
	                        forMaterTip: '平均贷款余额',
	                        gridTop: "20%",
	                        yType: "value",
	                        legend: [],
	                        xAxis: nineDate.content.loan.xAxis,
	                        yAxis: [],
	                        data: paramOneData,
	                        series: [[{
	                            color: '#e14340'
	                        }]]
	                    };
	                    paramTwo = {
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
	                        "xAxis": nineDate.content.private.xAxis,
	                        "yAxisName": ["亿元", "个数"],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": nineDate.content.private.series
	                        }
	                    };
	                    paramThree = {
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
	                        "xAxis": nineDate.content.p2p.xAxis,
	                        "yAxisName": ["家数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.p2p.series.bar],
	                            "line": [nineDate.content.p2p.series.line]
	                        }
	                    };
	                    paramFour = {
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
	                        "xAxis": nineDate.content.finance.xAxis,
	                        "yAxisName": ["亿人民币", "亿美元"],
	                        "barWidth": 10,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": nineDate.content.finance.series.bar,
	                            "line": [nineDate.content.finance.series.line]
	                        }
	                    };
	                    paramFive = {
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
	                        "yAxis": nineDate.content.exchange.xAxis,
	                        "Ytype": "category",
	                        "Xtype": "value",
	                        "yAxisName": ["新增项目数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.exchange.series]
	                        }
	                    };
	                    paramSix = {
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
	                        "xAxis": nineDate.content.crowd.xAxis,
	                        "yAxisName": ["新增项目数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.crowd.series]
	                        }
	                    };
	                    //paramSevenData-fixed == 1
	                    var paramSevenData = [];
	                    nineDate.content.mortgage.series[0].map(function (item, index) {
	                        var xx = [index, item];
	                        paramSevenData.push(xx);
	                    });
	                    nineDate.content.mortgage.series[1].map(function (item, index) {
	                        paramSevenData[index].push(item);
	                    });
	                    alert(paramSevenData);
	                    //paramSevenData-fixed-end
	                    paramSeven = {
	                        id: 'realTimeRightTwo', //必传
	                        height: '100%', //必传 带上单位
	                        title: '典当总额及业务笔数',
	                        yType: "value",
	                        gridTop: "20%",
	                        legend: [],
	                        xAxis: nineDate.content.mortgage.xAxis,
	                        yAxis: ['100000', '200000', '3000000', '4000000', '5000000'],
	                        data: paramSevenData,
	                        series: [[{
	                            color: '#e14340'
	                        }]]
	                    };
	                    paramEight = {
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
	                            //后台暂时没得数据，莫法传
	                            "bar": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)
	                            ]],
	                            "line": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)

	                            ]]
	                        }
	                    };
	                    paramNine = {
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
	                            "bar": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)
	                            ]]
	                        }
	                    };
	                } else {
	                        alert(404);
	                    }
	            }
	        }
	    },
	    // setParam:function(){
	    //         var paramOne={
	    //             id:'realTimeRightOne',//必传
	    //             height:'100%',//必传 带上单位
	    //             title:'小额贷款之贷款余额',
	    //             forMaterTitle:"贷款余额",
	    //             forMaterTip:'平均贷款余额',
	    //             legend: [],
	    //             xAxis:['2010', '2011', '2012','2013', '2014', '2015', '2016'],
	    //             yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	    //             data: [[0,0,300000],[1,1,1000000],[2,2,200000],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	    //             series:[
	    //                     [{
	    //                       color:'#e14340'
	    //                     }]
	    //                   ]
	    //         }
	    //         var paramTwo={
	    //             "title":"私募基金",
	    //             "color":["#f5b94b", "#01b6ed"],
	    //             "titleShow":"show",
	    //             "titleX":"left",
	    //             "legend": ["管理资本金额", "私募机构数量"],
	    //             "legendShow":true,
	    //             "legendLeft":"center",
	    //             "legendTop":"20",
	    //             "gridBottom":"0%",
	    //             "gridRight":"0%",
	    //             "barName":["管理资本金额","私募机构数量"],
	    //             "xAxis": ["2012", "2013", "2014", "2015"],
	    //             "yAxisName": ["亿元", "个数"],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //              "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ],
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ]
	    //             }
	    //         };
	    //         var paramThree={
	    //             "titleShow":true,
	    //             "title":"P2P平台",
	    //             "color":["#12b5b0", "#e24441"],
	    //             "legend": ["上海新增", "上海累计"],
	    //             "legendShow":true,
	    //             "legendLeft":"center",
	    //             "legendTop":"20",
	    //             "barName":["上海新增"],
	    //             "lineName":["上海累计"],
	    //             "YnameLocation":"end",
	    //             "gridLeft":"5%",
	    //             "gridRight":"0%",
	    //             "gridBottom":"0%",
	    //             "yFlag":"",
	    //             "xAxis": ["2012-Q1", "2014-Q2", "2014-Q3", "2014-Q4", "2015-Q1","2015-Q2", "2015-Q3", "2015-Q4", "2016-Q1"],
	    //             "yAxisName": ["家数", ""],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //             "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ],
	    //                 "line": [
	    //                         [
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200)

	    //                         ]
	    //                     ]
	    //             }
	    //         };
	    //         var paramFour={
	    //             "titleShow":true,
	    //             "title":"融资租赁",
	    //             "color":["#12b5b0", "#e24441","rgb(230,162,74)"],
	    //             "legend": ["注册资本($)","注册资本(¥)","企业数量",],
	    //             "legendShow":true,
	    //             "legendLeft":"center",
	    //             "legendTop":"20",
	    //             "legendWidth":600,
	    //             "barName":["注册资本($)","注册资本(¥)"],
	    //             "lineName":["企业数量"],
	    //             "YnameRoutate":0,
	    //             "YnameLocation":"end",
	    //             "gridLeft":"5%",
	    //             "gridRight":"0%",
	    //             "gridBottom":"0%",
	    //             "yFlag":"",
	    //             "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"],
	    //             "yAxisName": ["亿人民币", "亿美元"],
	    //             "barWidth":10,
	    //             "symbolSize":10,
	    //             "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ],
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ],
	    //                 "line": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                     ]
	    //             }
	    //         };
	    //         var paramFive={
	    //             "title":"众筹平台",
	    //             "color":["#f93330"],
	    //             "titleShow":"show",
	    //             "titleX":"left",
	    //             "legend": ["新增项目数"],
	    //             "legendShow":false,
	    //             "legendLeft":"center",
	    //             "axisLabelR":false,
	    //             "legendTop":"20",
	    //             "gridBottom":"0%",
	    //             "gridRight":"0%",
	    //             "labelShow":true,
	    //             "barName":["新增项目数"],
	    //             "lablePosition":"right",
	    //             "yAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	    //             "Ytype":"category",
	    //             "Xtype":"value",
	    //             "yAxisName": ["新增项目数", ""],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //              "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ]
	    //             }
	    //         };
	    //         var paramSix={
	    //             "title":"众筹平台",
	    //             "color":["#f93330"],
	    //             "titleShow":"show",
	    //             "titleX":"left",
	    //             "legend": ["新增项目数"],
	    //             "legendShow":false,
	    //             "legendLeft":"center",
	    //             "axisLabelR":false,
	    //             "legendTop":"20",
	    //             "gridBottom":"0%",
	    //             "gridRight":"0%",
	    //             "labelShow":true,
	    //             "barName":["新增项目数"],
	    //             "xAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	    //             "yAxisName": ["新增项目数", ""],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //              "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ]
	    //             }
	    //         };
	    //         var paramSeven={
	    //             id:'realTimeRightTwo',//必传
	    //             height:'100%',//必传 带上单位
	    //             title:'典当总额及业务笔数',
	    //             gridTop:"20%",
	    //             legend: [],
	    //             xAxis:['2009','2010','2011','2012','2013'],
	    //             yAxis: ['100000', '200000', '300000', '400000', '500000'],
	    //             data: [[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60]],
	    //             series:[
	    //                     [{
	    //                       color:'#e14340'
	    //                     }]
	    //                   ]
	    //         };
	    //         var paramEight={
	    //             "titleShow":true,
	    //             "title":"商业保理",
	    //             "color":["rgb(249,51,48)", "rgb(246,215,147)"],
	    //             "legend": ["商业保理业务总额", "融资余额"],
	    //             "legendShow":true,
	    //             "legendLeft":"center",
	    //             "legendTop":"20",
	    //             "barName":["商业保理业务总额"],
	    //             "lineName":["融资余额"],
	    //             "YnameLocation":"end",
	    //             "YnameGap":5,
	    //             "gridLeft":"5%",
	    //             "gridRight":"0%",
	    //             "gridBottom":"0%",
	    //             "Ytype":"value",
	    //             "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"],
	    //             "yAxisName": ["亿元", "个数"],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //             "itemStyle":{

	    //             },
	    //             "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ],
	    //                 "line": [
	    //                         [
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200),
	    //                             Math.round(Math.random() * 200)

	    //                         ]
	    //                     ]
	    //             }
	    //         };
	    //         var paramNine={
	    //             "title":"预付卡之备案企业预付金额总额",
	    //             "color":["#12b5b0", "#01b6ed"],
	    //             "titleShow":"show",
	    //             "titleX":"left",
	    //             "legend": ["管理资本金额"],
	    //             "legendShow":false,
	    //             "legendLeft":"center",
	    //             "legendTop":"20",
	    //             "gridBottom":"0%",
	    //             "gridRight":"0%",
	    //             "axisLabelR":false,
	    //             "barName":["管理资本金额"],
	    //             "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015","2016"],
	    //             "yAxisName": ["亿元", ""],
	    //             "barWidth":20,
	    //             "symbolSize":10,
	    //             "labelShow":true,
	    //              "series": {
	    //                 "bar": [
	    //                     [
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200),
	    //                         Math.round(Math.random() * 200)
	    //                     ]
	    //                 ]
	    //             }
	    //         };
	    //         return [paramOne,paramTwo,paramThree,paramFour,paramFive,paramSix,paramSeven,paramEight,paramNine];
	    // },
	    render: function render() {
	        var paramOneBox, paramTwoBox, paramThreeBox, paramFourBox, paramFiveBox, paramSixBox, paramSevenBox, paramEightBox, paramNineBox;
	        if (!!paramOne) {
	            paramOneBox = _react2.default.createElement(_ScatterChart2.default, { param: paramOne, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramTwo) {
	            paramTwoBox = _react2.default.createElement(_LineBarChart2.default, { param: paramTwo, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramThree) {
	            paramThreeBox = _react2.default.createElement(_LineBarChart2.default, { param: paramThree, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramFour) {
	            paramFourBox = _react2.default.createElement(_LineBarChart2.default, { param: paramFour, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramFive) {
	            paramFiveBox = _react2.default.createElement(_LineBarChart2.default, { param: paramFive, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramSix) {
	            paramSixBox = _react2.default.createElement(_LineBarChart2.default, { param: paramSix, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramSeven) {
	            paramSevenBox = _react2.default.createElement(_ScatterChart2.default, { param: paramSeven, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramEight) {
	            paramEightBox = _react2.default.createElement(_LineBarChart2.default, { param: paramEight, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramNine) {
	            paramNineBox = _react2.default.createElement(_LineBarChart2.default, { param: paramNine, style: { height: '100%', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-top-right' },
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramOneBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramTwoBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramThreeBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramFourBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramFiveBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramSixBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramSevenBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramEightBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramNineBox
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