webpackHotUpdate(0,{

/***/ 739:
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
	                padding: [10, 0],
	                textStyle: {
	                    fontSize: 14,
	                    color: "#fff",
	                    fontFamily: "microsoft yahei",
	                    fontWeight: "normal"
	                },
	                top: "3%"
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

/***/ }

})